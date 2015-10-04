package org.djunits.value.vfloat.vector;

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
public class FloatVectorDataDense extends FloatVectorData
{
    /**
     * Create a vector with dense data.
     * @param vectorSI the data to store
     */
    public FloatVectorDataDense(final float[] vectorSI)
    {
        super();
        this.vectorSI = new float[vectorSI.length];
        System.arraycopy(vectorSI, 0, this.vectorSI, 0, vectorSI.length);
    }

    /**
     * @param floatFunction the function to apply on the (mutable) data elements
     */
    public final void assign(final FloatFunction floatFunction)
    {
        for (int index = 0; index < this.vectorSI.length; index++)
        {
            this.vectorSI[index] = floatFunction.apply(this.vectorSI[index]);
        }
    }

    /**
     * @return a sparse variant of the data.
     */
    public final FloatVectorDataSparse toSparse()
    {
        int length = cardinality();
        float[] sparseSI = new float[length];
        int[] indices = new int[length];
        int count = 0;
        for (int i = 0; i < this.vectorSI.length; i++)
        {
            if (this.vectorSI[i] != 0.0)
            {
                sparseSI[count] = this.vectorSI[i];
                indices[count] = i;
                count++;
            }
        }
        return new FloatVectorDataSparse(sparseSI, indices, size());
    }

    /** {@inheritDoc} */
    @Override
    public final int size()
    {
        return this.vectorSI.length;
    }

    /** {@inheritDoc} */
    @Override
    public final float getSI(final int index)
    {
        return this.vectorSI[index];
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int index, final float valueSI)
    {
        this.vectorSI[index] = valueSI;
    }

    /** {@inheritDoc} */
    @Override
    public final float[] getDenseVectorSI()
    {
        return this.vectorSI.clone();
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVectorDataDense copy()
    {
        float[] vCopy = new float[this.vectorSI.length];
        System.arraycopy(this.vectorSI, 0, vCopy, 0, this.vectorSI.length);
        return new FloatVectorDataDense(vCopy);
    }
}
