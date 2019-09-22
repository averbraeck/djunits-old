package org.djunits4.value.vdouble.matrix.data;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.djunits4.unit.Unit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.matrix.base.DoubleSparseValue;
import org.djunits4.value.vdouble.scalar.base.DoubleScalarInterface;

/**
 * Stores sparse data for a DoubleMatrix and carries out basic operations. The index in the sparse matrix data is calculated as
 * <code>r * columns + c</code>, where r is the row number, cols is the total number of columns, and c is the column number.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class DoubleMatrixDataSparse extends DoubleMatrixData
{
    /** */
    private static final long serialVersionUID = 1L;

    /** the index values of the Matrix. The index is calculated as r * columns + c. */
    private long[] indices;

    /**
     * Create a matrix with sparse data.
     * @param matrixSI double[]; the data to store
     * @param indices long[]; the index values of the Matrix, with &lt;tt&gt;index = row * cols + col&lt;/tt&gt;
     * @param rows int; the number of rows
     * @param cols int; the number of columns
     */
    public DoubleMatrixDataSparse(final double[] matrixSI, final long[] indices, final int rows, final int cols)
    {
        super(StorageType.SPARSE);
        this.matrixSI = matrixSI;
        this.indices = indices;
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Create a matrix with sparse data from an internal vector with dense data.
     * @param denseSI double[]; the dense data to store
     * @param rows int; the number of rows
     * @param cols int; the number of columns
     * @throws ValueRuntimeException in case size is incorrect
     */
    public DoubleMatrixDataSparse(final double[] denseSI, final int rows, final int cols) throws ValueRuntimeException
    {
        super(StorageType.SPARSE);
        if (denseSI == null || denseSI.length == 0)
        {
            throw new ValueRuntimeException("DoubleMatrixDataSparse constructor, denseSI == null || denseSI.length == 0");
        }

        int length = nonZero(denseSI);
        this.rows = rows;
        this.cols = cols;
        this.matrixSI = new double[length];
        this.indices = new long[length];
        fill(denseSI, this.matrixSI, this.indices);
    }

    /**
     * Create a matrix with sparse data.
     * @param dataSI double[][]; the data to store
     * @throws ValueRuntimeException in case matrix is ragged
     */
    public DoubleMatrixDataSparse(final double[][] dataSI) throws ValueRuntimeException
    {
        super(StorageType.SPARSE);
        if (dataSI == null || dataSI.length == 0)
        {
            throw new ValueRuntimeException("DoubleMatrixDataSparse constructor, matrixSI == null || matrixSI.length == 0");
        }

        int length = nonZero(dataSI);
        this.rows = dataSI.length;
        this.cols = dataSI[0].length;
        this.matrixSI = new double[length];
        this.indices = new long[length];
        fill(dataSI, this.matrixSI, this.indices);
    }

    /**
     * Create a matrix with sparse data.
     * @param dataSI Collection&lt;DoubleSparseValue&lt;U, S&gt;&gt;; the sparse [X, Y, SI] values to store
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     * @throws ValueRuntimeException in case matrix is ragged
     */
    public <U extends Unit<U>, S extends DoubleScalarInterface<U, S>> DoubleMatrixDataSparse(
            final Collection<DoubleSparseValue<U, S>> dataSI, final int rows, final int cols) throws ValueRuntimeException
    {
        super(StorageType.SPARSE);
        if (dataSI == null || dataSI.size() == 0)
        {
            throw new ValueRuntimeException("DoubleMatrixDataSparse constructor, matrixSI == null || matrixSI.length == 0");
        }

        int length = (int) dataSI.stream().parallel().filter(d -> d.getValueSI() != 0.0).count();
        this.rows = rows;
        this.cols = cols;
        this.matrixSI = new double[length];
        this.indices = new long[length];
        int index = 0;
        for (DoubleSparseValue<U, S> data : dataSI)
        {
            if (data.getValueSI() != 0.0)
            {
                this.indices[index] = data.getRow() * this.cols + data.getColumn();
                this.matrixSI[index] = data.getValueSI();
                index++;
            }
        }
    }

    /**
     * Fill the sparse data structures matrixSI[] and indices[]. Note: output vectors have to be initialized at the right size.
     * Cannot be parallelized because of stateful and sequence-sensitive count.
     * @param data double[][]; the input data
     * @param matrixSI double[]; the matrix data to write
     * @param indices long[]; the indices to write
     * @throws ValueRuntimeException in case matrix is ragged
     */
    @SuppressWarnings("checkstyle:finalparameters")
    private static void fill(final double[][] data, double[] matrixSI, long[] indices) throws ValueRuntimeException
    {
        int rows = data.length;
        int cols = data[0].length;
        int count = 0;
        for (int r = 0; r < rows; r++)
        {
            double[] row = data[r];
            if (row.length != cols)
            {
                throw new ValueRuntimeException("Matrix is ragged");
            }
            for (int c = 0; c < cols; c++)
            {
                int index = r * cols + c;
                if (row[c] != 0.0)
                {
                    matrixSI[count] = row[c];
                    indices[count] = index;
                    count++;
                }
            }
        }
    }

    /**
     * Fill the sparse data structures matrixSI[] and indices[]. Note: output vectors have to be initialized at the right size.
     * Cannot be parallelized because of stateful and sequence-sensitive count.
     * @param data double[]; the input data
     * @param matrixSI double[]; the matrix data to write
     * @param indices long[]; the indices to write
     */
    @SuppressWarnings("checkstyle:finalparameters")
    private static void fill(final double[] data, double[] matrixSI, long[] indices)
    {
        int count = 0;
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] != 0.0)
            {
                matrixSI[count] = data[i];
                indices[count] = i;
                count++;
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public final DoubleMatrixDataDense toDense()
    {
        double[] denseSI = new double[this.rows * this.cols];
        for (int index = 0; index < this.matrixSI.length; index++)
        {
            denseSI[(int) this.indices[index]] = this.matrixSI[index];
        }
        try
        {
            return new DoubleMatrixDataDense(denseSI, this.rows, this.cols);
        }
        catch (ValueRuntimeException exception)
        {
            throw new RuntimeException(exception); // cannot happen -- denseSI has the right size
        }
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI(final int row, final int col)
    {
        long index = row * this.cols + col;
        int internalIndex = Arrays.binarySearch(this.indices, index);
        return internalIndex < 0 ? 0.0 : this.matrixSI[internalIndex];
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int row, final int col, final double valueSI)
    {
        long index = row * this.cols + col;
        int internalIndex = Arrays.binarySearch(this.indices, index);
        if (internalIndex >= 0)
        {
            this.matrixSI[internalIndex] = valueSI;
            return;
        }

        // make room. TODO increase size in chunks
        internalIndex = -internalIndex - 1;
        long[] indicesNew = new long[this.indices.length + 1];
        double[] matrixSINew = new double[this.matrixSI.length + 1];
        System.arraycopy(this.indices, 0, indicesNew, 0, internalIndex);
        System.arraycopy(this.matrixSI, 0, matrixSINew, 0, internalIndex);
        System.arraycopy(this.indices, internalIndex, indicesNew, internalIndex + 1, this.indices.length - internalIndex);
        System.arraycopy(this.matrixSI, internalIndex, matrixSINew, internalIndex + 1, this.indices.length - internalIndex);
        indicesNew[internalIndex] = index;
        matrixSINew[internalIndex] = valueSI;
        this.indices = indicesNew;
        this.matrixSI = matrixSINew;
    }

    /** {@inheritDoc} */
    @Override
    public final double[][] getDenseMatrixSI()
    {
        return toDense().getDenseMatrixSI();
    }

    /** {@inheritDoc} */
    @Override
    public final DoubleMatrixDataSparse copy()
    {
        double[] vCopy = new double[this.matrixSI.length];
        System.arraycopy(this.matrixSI, 0, vCopy, 0, this.matrixSI.length);
        long[] iCopy = new long[this.indices.length];
        System.arraycopy(this.indices, 0, iCopy, 0, this.indices.length);
        return new DoubleMatrixDataSparse(vCopy, iCopy, this.rows, this.cols);
    }

    /**
     * Instantiate a DoubleMatrixDataSparse from an array.
     * @param valuesSI double[][]; the (SI) values to store
     * @return the DoubleMatrixDataSparse
     * @throws ValueRuntimeException in case matrix is ragged
     */
    public static DoubleMatrixDataSparse instantiate(final double[][] valuesSI) throws ValueRuntimeException
    {
        int length = nonZero(valuesSI);
        final int rows = valuesSI.length;
        final int cols = valuesSI[0].length;
        double[] sparseSI = new double[length];
        long[] indices = new long[length];
        fill(valuesSI, sparseSI, indices);
        return new DoubleMatrixDataSparse(sparseSI, indices, rows, cols);
    }

    /**
     * Calculate the number of non-zero values in a double[][] matrix.
     * @param valuesSI double[][]; the double[][] matrix
     * @return the number of non-zero values in the double[][] matrix
     */
    private static int nonZero(final double[][] valuesSI)
    {
        // determine number of non-null cells
        AtomicInteger atomicLength = new AtomicInteger(0);
        IntStream.range(0, valuesSI.length).parallel().forEach(r -> IntStream.range(0, valuesSI[0].length).forEach(c ->
        {
            if (valuesSI[r][c] != 0.0)
            {
                atomicLength.incrementAndGet();
            }
        }));

        return atomicLength.get();
    }

    /**
     * Calculate the number of non-zero values in a double[] vector.
     * @param valuesSI double[]; the double[] vector
     * @return the number of non-zero values in the double[] vector
     */
    private static int nonZero(final double[] valuesSI)
    {
        return (int) Arrays.stream(valuesSI).parallel().filter(d -> d != 0.0).count();
    }

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final DoubleMatrixData right) throws ValueRuntimeException
    {
        int newLength = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                if (this.getSI(r, c) + right.getSI(r, c) != 0.0)
                {
                    newLength++;
                }
            }
        }
        double[] newMatrixSI = new double[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                double value = this.getSI(r, c) + right.getSI(r, c);
                if (value != 0.0)
                {
                    int index = r * cols() + c;
                    newMatrixSI[count] = value;
                    newIndices[count] = index;
                    count++;
                }
            }
        }
        this.indices = newIndices;
        this.matrixSI = newMatrixSI;
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final DoubleMatrixData right) throws ValueRuntimeException
    {
        int newLength = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                if (this.getSI(r, c) - right.getSI(r, c) != 0.0)
                {
                    newLength++;
                }
            }
        }
        double[] newMatrixSI = new double[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                double value = this.getSI(r, c) - right.getSI(r, c);
                if (value != 0.0)
                {
                    int index = r * cols() + c;
                    newMatrixSI[count] = value;
                    newIndices[count] = index;
                    count++;
                }
            }
        }
        this.indices = newIndices;
        this.matrixSI = newMatrixSI;
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final DoubleMatrixData right) throws ValueRuntimeException
    {
        int newLength = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                if (this.getSI(r, c) * right.getSI(r, c) != 0.0)
                {
                    newLength++;
                }
            }
        }
        double[] newMatrixSI = new double[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                double value = this.getSI(r, c) * right.getSI(r, c);
                if (value != 0.0)
                {
                    int index = r * cols() + c;
                    newMatrixSI[count] = value;
                    newIndices[count] = index;
                    count++;
                }
            }
        }
        this.indices = newIndices;
        this.matrixSI = newMatrixSI;
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final DoubleMatrixData right) throws ValueRuntimeException
    {
        int newLength = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                if (this.getSI(r, c) / right.getSI(r, c) != 0.0)
                {
                    newLength++;
                }
            }
        }
        double[] newMatrixSI = new double[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                double value = this.getSI(r, c) / right.getSI(r, c);
                if (value != 0.0)
                {
                    int index = r * cols() + c;
                    newMatrixSI[count] = value;
                    newIndices[count] = index;
                    count++;
                }
            }
        }
        this.indices = newIndices;
        this.matrixSI = newMatrixSI;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(this.indices);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:needbraces", "checkstyle:designforextension"})
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoubleMatrixDataSparse other = (DoubleMatrixDataSparse) obj;
        if (!Arrays.equals(this.indices, other.indices))
            return false;
        return true;
    }

}
