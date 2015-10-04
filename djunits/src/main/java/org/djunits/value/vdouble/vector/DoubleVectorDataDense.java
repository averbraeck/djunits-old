package org.djunits.value.vdouble.vector;

import org.djunits.value.vdouble.DoubleFunction;

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
public class DoubleVectorDataDense extends DoubleVectorData
{
    /**
     * Create a vector with dense data.
     * @param vectorSI the data to store
     */
    public DoubleVectorDataDense(final double[] vectorSI)
    {
        super();
        this.vectorSI = new double[vectorSI.length];
        System.arraycopy(vectorSI, 0, this.vectorSI, 0, vectorSI.length);
    }

    /**
     * @param doubleFunction the function to apply on the (mutable) data elements
     */
    public final void assign(final DoubleFunction doubleFunction)
    {
        for (int index = 0; index < this.vectorSI.length; index++)
        {
            this.vectorSI[index] = doubleFunction.apply(this.vectorSI[index]);
        }
    }

    /**
     * @return a sparse variant of the data.
     */
    public final DoubleVectorDataSparse toSparse()
    {
        int length = cardinality();
        double[] sparseSI = new double[length];
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
        return new DoubleVectorDataSparse(sparseSI, indices, size());
    }

    /** {@inheritDoc} */
    @Override
    public final int size()
    {
        return this.vectorSI.length;
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI(final int index)
    {
        return this.vectorSI[index];
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int index, final double valueSI)
    {
        this.vectorSI[index] = valueSI;
    }

    /** {@inheritDoc} */
    @Override
    public final double[] getDenseVectorSI()
    {
        return this.vectorSI.clone();
    }

    /** {@inheritDoc} */
    @Override
    public final DoubleVectorDataDense copy()
    {
        double[] vCopy = new double[this.vectorSI.length];
        System.arraycopy(this.vectorSI, 0, vCopy, 0, this.vectorSI.length);
        return new DoubleVectorDataDense(vCopy);
    }
}
