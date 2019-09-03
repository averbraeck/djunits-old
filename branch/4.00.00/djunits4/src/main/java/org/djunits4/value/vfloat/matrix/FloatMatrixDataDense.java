package org.djunits4.value.vfloat.matrix;

import java.util.stream.IntStream;

import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.FloatFunction;

/**
 * Stores dense data for a FloatMatrix and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMatrixDataDense extends FloatMatrixData
{
    /** */
    private static final long serialVersionUID = 1L;

    /**
     * Create a matrix with dense data.
     * @param matrixSI float[]; the data to store
     * @param rows int; the number of rows
     * @param cols int; the number of columns
     * @throws ValueException in case <tt>rows * cols != matrixSI.length</tt>
     */
    public FloatMatrixDataDense(final float[] matrixSI, final int rows, final int cols) throws ValueException
    {
        super(StorageType.DENSE);
        if (rows * cols != matrixSI.length)
        {
            throw new ValueException("FloatMatrixDataDense constructor, rows * cols != matrixSI.length");
        }
        this.matrixSI = new float[matrixSI.length];
        System.arraycopy(matrixSI, 0, this.matrixSI, 0, matrixSI.length);
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Create a matrix with dense data.
     * @param matrixSI float[][]; the data to store
     * @throws ValueException in case matrix is ragged
     */
    public FloatMatrixDataDense(final float[][] matrixSI) throws ValueException
    {
        super(StorageType.DENSE);
        if (matrixSI == null || matrixSI.length == 0)
        {
            throw new ValueException("FloatMatrixDataDense constructor, matrixSI == null || matrixSI.length == 0");
        }
        this.rows = matrixSI.length;
        this.cols = matrixSI[0].length;
        this.matrixSI = new float[this.rows * this.cols];
        for (int r = 0; r < this.rows; r++)
        {
            float[] row = matrixSI[r];
            if (row.length != this.cols)
            {
                throw new ValueException("FloatMatrixDataDense constructor, ragged matrix");
            }
            System.arraycopy(row, 0, this.matrixSI, r * this.cols, row.length);
        }
    }

    /**
     * Apply a function to all data elements of this matrix.
     * @param floatFunction FloatFunction; the function to apply on the (mutable) data elements
     */
    public final void assign(final FloatFunction floatFunction)
    {
        IntStream.range(0, this.rows() * this.cols()).parallel()
                .forEach(i -> this.matrixSI[i] = floatFunction.apply(this.matrixSI[i]));
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMatrixDataSparse toSparse()
    {
        int length = cardinality();
        float[] sparseSI = new float[length];
        long[] indices = new long[length];
        int count = 0;
        for (int r = 0; r < this.rows; r++)
        {
            for (int c = 0; c < this.cols; c++)
            {
                int index = r * this.cols + c;
                if (this.matrixSI[index] != 0.0)
                {
                    sparseSI[count] = this.matrixSI[index];
                    indices[count] = index;
                    count++;
                }
            }
        }
        return new FloatMatrixDataSparse(sparseSI, indices, this.matrixSI.length, this.rows, this.cols);
    }

    /** {@inheritDoc} */
    @Override
    public final float getSI(final int row, final int col)
    {
        return this.matrixSI[row * this.cols + col];
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int row, final int col, final float valueSI)
    {
        this.matrixSI[row * this.cols + col] = valueSI;
    }

    /** {@inheritDoc} */
    @Override
    public final float[][] getDenseMatrixSI()
    {
        float[][] matrix = new float[this.rows][];
        for (int r = 0; r < this.rows; r++)
        {
            float[] row = new float[this.cols];
            System.arraycopy(this.matrixSI, r * this.cols, row, 0, row.length);
            matrix[r] = row;
        }
        return matrix;
    }

    /** {@inheritDoc} */
    @Override
    public final double[][] getDoubleDenseMatrixSI()
    {
        double[][] matrix = new double[this.rows][];
        for (int r = 0; r < this.rows; r++)
        {
            double[] row = new double[this.cols];
            int offset = r * this.cols;
            for (int c = 0; c < this.cols; c++)
            {
                row[c] = this.matrixSI[offset++];
            }
            matrix[r] = row;
        }
        return matrix;
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMatrixDataDense copy()
    {
        try
        {
            return new FloatMatrixDataDense(getDenseMatrixSI());
        }
        catch (ValueException exception)
        {
            throw new RuntimeException(exception); // should not happen -- original is not ragged...
        }
    }

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final FloatMatrixData right) throws ValueException
    {
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> this.matrixSI[r * this.cols + c] += right.getSI(r, c)));
    }

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final float valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] += valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final FloatMatrixData right) throws ValueException
    {
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> this.matrixSI[r * this.cols + c] -= right.getSI(r, c)));
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final float valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] -= valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final FloatMatrixData right) throws ValueException
    {
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> this.matrixSI[r * this.cols + c] *= right.getSI(r, c)));
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final float valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] *= valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final FloatMatrixData right) throws ValueException
    {
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> this.matrixSI[r * this.cols + c] /= right.getSI(r, c)));
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final float valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] /= valueSI);
    }

}