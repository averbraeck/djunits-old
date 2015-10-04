package org.djunits.value.vfloat.matrix;

import org.djunits.value.ValueException;
import org.djunits.value.vfloat.FloatFunction;

/**
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatMatrixDataDense extends FloatMatrixData
{
    /**
     * Create a vector with dense data.
     * @param matrixSI the data to store
     * @param rows the number of rows
     * @param cols the number of columns
     * @throws ValueException in case <tt>rows * cols != matrixSI.length</tt>
     */
    public FloatMatrixDataDense(final float[] matrixSI, final int rows, final int cols) throws ValueException
    {
        super();
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
     * Create a vector with dense data.
     * @param matrixSI the data to store
     * @throws ValueException in case matrix is ragged
     */
    public FloatMatrixDataDense(final float[][] matrixSI) throws ValueException
    {
        super();
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
     * @param floatFunction the function to apply on the (mutable) data elements
     */
    public final void assign(final FloatFunction floatFunction)
    {
        for (int index = 0; index < this.matrixSI.length; index++)
        {
            this.matrixSI[index] = floatFunction.apply(this.matrixSI[index]);
        }
    }

    /**
     * @return a sparse variant of the data.
     */
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
    public final float[] getDenseVectorSI()
    {
        float[] mCopy = new float[this.matrixSI.length];
        System.arraycopy(this.matrixSI, 0, mCopy, 0, this.matrixSI.length);
        return mCopy;
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
    public final double[][] getDenseDoubleMatrixSI()
    {
        double[][] matrix = new double[this.rows][];
        for (int r = 0; r < this.rows; r++)
        {
            double[] row = new double[this.cols];
            matrix[r] = row;
            for (int c = 0; c < this.cols; c++)
            {
                matrix[r][c] = this.matrixSI[r * this.cols + c];
            }
        }
        return matrix;
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMatrixDataDense copy()
    {
        try
        {
            return new FloatMatrixDataDense(getDenseVectorSI(), this.rows, this.cols);
        }
        catch (ValueException exception)
        {
            throw new RuntimeException(exception); // should not happen -- original is not ragged...
        }
    }
}
