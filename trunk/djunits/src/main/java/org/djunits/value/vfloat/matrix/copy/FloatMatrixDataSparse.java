package org.djunits.value.vfloat.matrix.copy;

import java.util.Arrays;

import org.djunits.value.ValueException;

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
public class FloatMatrixDataSparse extends FloatMatrixData
{
    /** the index values of the Vector. */
    private long[] indices;

    /** the length of the vector (padded with 0 after highest index in indices). */
    private final int length;

    /**
     * Create a vector with sparse data.
     * @param matrixSI the data to store
     * @param indices the index values of the Vector, with <tt>index = row * cols + col</tt>
     * @param length the length of the vector (padded with 0 after highest index in indices)
     * @param rows the number of rows
     * @param cols the number of columns
     */
    public FloatMatrixDataSparse(final float[] matrixSI, final long[] indices, final int length, final int rows,
        final int cols)
    {
        super();
        this.matrixSI = matrixSI;
        this.indices = indices;
        this.length = length;
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Create a vector with sparse data.
     * @param matrixSI the data to store
     * @throws ValueException in case matrix is ragged
     */
    public FloatMatrixDataSparse(final float[][] matrixSI) throws ValueException
    {
        super();
        if (matrixSI == null || matrixSI.length == 0)
        {
            throw new ValueException("FloatMatrixDataSparse constructor, matrixSI == null || matrixSI.length == 0");
        }

        this.rows = matrixSI.length;
        this.cols = matrixSI[0].length;

        int card = 0;
        for (int r = 0; r < this.rows; r++)
        {
            float[] row = matrixSI[r];
            if (row.length != this.cols)
            {
                throw new ValueException("FloatMatrixDataDense constructor, ragged matrix");
            }
            for (int c = 0; c < this.cols; c++)
            {
                if (matrixSI[r][c] != 0.0)
                {
                    card++;
                }
            }
        }

        this.matrixSI = new float[card];
        this.indices = new long[card];

        int count = 0;
        for (int r = 0; r < this.rows; r++)
        {
            float[] row = matrixSI[r];
            for (int c = 0; c < this.cols; c++)
            {
                int index = r * this.cols + c;
                if (row[c] != 0.0)
                {
                    this.matrixSI[count] = row[c];
                    this.indices[count] = index;
                    count++;
                }
            }
        }

        this.length = card;
    }

    /**
     * @return a dense variant of the data.
     */
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
        System.arraycopy(this.indices, internalIndex, indicesNew, internalIndex - 1, this.indices.length
            - internalIndex);
        System.arraycopy(this.matrixSI, internalIndex, matrixSINew, internalIndex - 1, this.indices.length
            - internalIndex);
        indicesNew[internalIndex] = index;
        matrixSINew[internalIndex] = valueSI;
        this.indices = indicesNew;
        this.matrixSI = matrixSINew;
    }

    /** {@inheritDoc} */
    @Override
    public final float[] getDenseVectorSI()
    {
        return toDense().matrixSI;
    }

    /** {@inheritDoc} */
    @Override
    public final float[][] getDenseMatrixSI()
    {
        return toDense().getDenseMatrixSI();
    }

    /** {@inheritDoc} */
    @Override
    public final double[][] getDenseDoubleMatrixSI()
    {
        return toDense().getDenseDoubleMatrixSI();
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
    @SuppressWarnings({"checkstyle:needbraces", "checkstyle:designforextension"})
    @Override
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
