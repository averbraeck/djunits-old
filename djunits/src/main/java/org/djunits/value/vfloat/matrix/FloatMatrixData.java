package org.djunits.value.vfloat.matrix;

import java.util.Arrays;

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
abstract class FloatMatrixData
{
    /** the internal storage of the Matrix; can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected float[] matrixSI;

    /** the number of rows of the vector. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected int rows;

    /** the number of columns of the vector. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected int cols;

    /**
     * @return the number of rows of the vector
     */
    public int rows()
    {
        return this.rows;
    }

    /**
     * @return the number of columns of the vector
     */
    public int cols()
    {
        return this.cols;
    }

    /**
     * @param row the row number to get the value for
     * @param col the column number to get the value for
     * @return the value at the [row, col] point
     */
    public abstract float getSI(final int row, final int col);

    /**
     * Sets a value at the [row, col] point in the vector.
     * @param row the row number to set the value for
     * @param col the column number to set the value for
     * @param valueSI the value at the index
     */
    public abstract void setSI(final int row, final int col, final float valueSI);

    /**
     * @return the number of non-zero cells.
     */
    public final int cardinality()
    {
        int count = 0;
        for (int i = 0; i < this.matrixSI.length; i++)
        {
            if (this.matrixSI[i] != 0.0)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * @return the sum of the values of all cells.
     */
    public final float zSum()
    {
        float result = 0.0f;
        for (int i = 0; i < this.matrixSI.length; i++)
        {
            result += this.matrixSI[i];
        }
        return result;
    }

    /**
     * @return a deep copy of the data.
     */
    public abstract FloatMatrixData copy();

    /**
     * @return a safe dense copy of matrixSI as a vector
     */
    public abstract float[] getDenseVectorSI();

    /**
     * @return a safe dense copy of matrixSI as a matrix
     */
    public abstract float[][] getDenseMatrixSI();

    /**
     * @return a safe dense copy of matrixSI as a double matrix for ojAlgo
     */
    public abstract double[][] getDenseDoubleMatrixSI();

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.matrixSI);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:needbraces")
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FloatMatrixData other = (FloatMatrixData) obj;
        if (!Arrays.equals(this.matrixSI, other.matrixSI))
            return false;
        return true;
    }
}
