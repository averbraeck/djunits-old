package org.djunits4.value.vfloat.matrix;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;

/**
 * Stores sparse data for a FloatMatrix and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMatrixDataSparse extends FloatMatrixData
{
    /** */
    private static final long serialVersionUID = 1L;

    /** the index values of the Matrix. */
    private long[] indices;

    /** the length of the vector (padded with 0 after highest index in indices). */
    private final int length;

    /**
     * Create a vector with sparse data.
     * @param matrixSI float[]; the data to store
     * @param indices long[]; the index values of the Matrix, with &lt;tt&gt;index = row * cols + col&lt;/tt&gt;
     * @param length int; the length of the vector (padded with 0 after highest index in indices)
     * @param rows int; the number of rows
     * @param cols int; the number of columns
     */
    public FloatMatrixDataSparse(final float[] matrixSI, final long[] indices, final int length, final int rows, final int cols)
    {
        super(StorageType.SPARSE);
        this.matrixSI = matrixSI;
        this.indices = indices;
        this.length = length;
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Create a vector with sparse data from an internal vector with dense data.
     * @param denseSI float[]; the dense data to store
     * @param rows int; the number of rows
     * @param cols int; the number of columns
     * @throws ValueException in case size is incorrect
     */
    public FloatMatrixDataSparse(final float[] denseSI, final int rows, final int cols) throws ValueException
    {
        super(StorageType.SPARSE);
        if (denseSI == null || denseSI.length == 0)
        {
            throw new ValueException("FloatMatrixDataSparse constructor, denseSI == null || denseSI.length == 0");
        }

        this.length = nonZero(denseSI);
        this.rows = rows;
        this.cols = cols;
        this.matrixSI = new float[this.length];
        this.indices = new long[this.length];
        fill(denseSI, this.matrixSI, this.indices);
    }

    /**
     * Create a vector with sparse data.
     * @param dataSI float[][]; the data to store
     * @throws ValueException in case matrix is ragged
     */
    public FloatMatrixDataSparse(final float[][] dataSI) throws ValueException
    {
        super(StorageType.SPARSE);
        if (dataSI == null || dataSI.length == 0)
        {
            throw new ValueException("FloatMatrixDataSparse constructor, matrixSI == null || matrixSI.length == 0");
        }

        this.length = nonZero(dataSI);
        this.rows = dataSI.length;
        this.cols = dataSI[0].length;
        this.matrixSI = new float[this.length];
        this.indices = new long[this.length];
        fill(dataSI, this.matrixSI, this.indices);
    }

    /**
     * Fill the sparse data structures matrixSI[] and indices[]. Note: output vectors have to be initialized at the right size.
     * Cannot be parallelized because of stateful and sequence-sensitive count.
     * @param data float[][]; the input data
     * @param matrixSI float[]; the matrix data to write
     * @param indices long[]; the indices to write
     * @throws ValueException in case matrix is ragged
     */
    @SuppressWarnings("checkstyle:finalparameters")
    private static void fill(final float[][] data, float[] matrixSI, long[] indices) throws ValueException
    {
        int rows = data.length;
        int cols = data[0].length;
        int count = 0;
        for (int r = 0; r < rows; r++)
        {
            float[] row = data[r];
            if (row.length != cols)
            {
                throw new ValueException("Matrix is ragged");
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
     * @param data float[]; the input data
     * @param matrixSI float[]; the matrix data to write
     * @param indices long[]; the indices to write
     */
    @SuppressWarnings("checkstyle:finalparameters")
    private static void fill(final float[] data, float[] matrixSI, long[] indices)
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
    public final FloatMatrixDataDense toDense()
    {
        float[] denseSI = new float[this.rows * this.cols];
        for (int index = 0; index < this.matrixSI.length; index++)
        {
            denseSI[(int) this.indices[index]] = this.matrixSI[index];
        }
        try
        {
            return new FloatMatrixDataDense(denseSI, this.rows, this.cols);
        }
        catch (ValueException exception)
        {
            throw new RuntimeException(exception); // cannot happen -- denseSI has the right size
        }
    }

    /** {@inheritDoc} */
    @Override
    public final float getSI(final int row, final int col)
    {
        long index = row * this.cols + col;
        int internalIndex = Arrays.binarySearch(this.indices, index);
        return internalIndex < 0 ? 0.0f : this.matrixSI[internalIndex];
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int row, final int col, final float valueSI)
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
        float[] matrixSINew = new float[this.matrixSI.length + 1];
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
    public final float[][] getDenseMatrixSI()
    {
        return toDense().getDenseMatrixSI();
    }

    /** {@inheritDoc} */
    @Override
    public final double[][] getDoubleDenseMatrixSI()
    {
        return toDense().getDoubleDenseMatrixSI();
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMatrixDataSparse copy()
    {
        float[] vCopy = new float[this.matrixSI.length];
        System.arraycopy(this.matrixSI, 0, vCopy, 0, this.matrixSI.length);
        long[] iCopy = new long[this.indices.length];
        System.arraycopy(this.indices, 0, iCopy, 0, this.indices.length);
        return new FloatMatrixDataSparse(vCopy, iCopy, this.length, this.rows, this.cols);
    }

    /**
     * Instantiate a FloatMatrixDataSparse from an array.
     * @param valuesSI float[][]; the (SI) values to store
     * @return the FloatMatrixDataSparse
     * @throws ValueException in case matrix is ragged
     */
    public static FloatMatrixDataSparse instantiate(final float[][] valuesSI) throws ValueException
    {
        int length = nonZero(valuesSI);
        final int rows = valuesSI.length;
        final int cols = valuesSI[0].length;
        float[] sparseSI = new float[length];
        long[] indices = new long[length];
        fill(valuesSI, sparseSI, indices);
        return new FloatMatrixDataSparse(sparseSI, indices, length, rows, cols);
    }

    /**
     * Calculate the number of non-zero values in this float[][] matrix.
     * @param valuesSI float[][]; the float[][] matrix
     * @return the number of non-zero values in this float[][] matrix
     */
    private static int nonZero(final float[][] valuesSI)
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
     * Calculate the number of non-zero values in this float[] vector.
     * @param valuesSI float[]; the float[] vector
     * @return the number of non-zero values in this float[] vector
     */
    private static int nonZero(final float[] valuesSI)
    {
        return (int) IntStream.range(0, valuesSI.length).parallel().mapToDouble(i -> valuesSI[i]).filter(d -> d != 0.0).count();
    }

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final FloatMatrixData right) throws ValueException
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
        float[] newMatrixSI = new float[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                float value = this.getSI(r, c) + right.getSI(r, c);
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
    public final void incrementBy(final float valueSI)
    {
        int newLength = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                if (this.getSI(r, c) + valueSI != 0.0)
                {
                    newLength++;
                }
            }
        }
        float[] newMatrixSI = new float[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                float value = this.getSI(r, c) + valueSI;
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
    public final void decrementBy(final FloatMatrixData right) throws ValueException
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
        float[] newMatrixSI = new float[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                float value = this.getSI(r, c) - right.getSI(r, c);
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
    public final void decrementBy(final float valueSI)
    {
        int newLength = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                if (this.getSI(r, c) - valueSI != 0.0)
                {
                    newLength++;
                }
            }
        }
        float[] newMatrixSI = new float[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                float value = this.getSI(r, c) - valueSI;
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
    public final void multiplyBy(final FloatMatrixData right) throws ValueException
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
        float[] newMatrixSI = new float[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                float value = this.getSI(r, c) * right.getSI(r, c);
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
    public final void multiplyBy(final float valueSI)
    {
        int newLength = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                if (this.getSI(r, c) * valueSI != 0.0)
                {
                    newLength++;
                }
            }
        }
        float[] newMatrixSI = new float[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                float value = this.getSI(r, c) * valueSI;
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
    public final void divideBy(final FloatMatrixData right) throws ValueException
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
        float[] newMatrixSI = new float[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                float value = this.getSI(r, c) / right.getSI(r, c);
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
    public final void divideBy(final float valueSI)
    {
        int newLength = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                if (this.getSI(r, c) / valueSI != 0.0)
                {
                    newLength++;
                }
            }
        }
        float[] newMatrixSI = new float[newLength];
        long[] newIndices = new long[newLength];

        // fill the sparse data structures. Cannot be parallelized because of stateful and sequence-sensitive count
        int count = 0;
        for (int r = 0; r < rows(); r++)
        {
            for (int c = 0; c < cols(); c++)
            {
                float value = this.getSI(r, c) / valueSI;
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
        result = prime * result + this.length;
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
        FloatMatrixDataSparse other = (FloatMatrixDataSparse) obj;
        if (!Arrays.equals(this.indices, other.indices))
            return false;
        if (this.length != other.length)
            return false;
        return true;
    }
}
