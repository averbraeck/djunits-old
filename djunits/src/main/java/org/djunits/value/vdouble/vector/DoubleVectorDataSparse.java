package org.djunits.value.vdouble.vector;

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
public class DoubleVectorDataSparse extends DoubleVectorData
{
    /** the index values of the Vector. */
    private int[] indices;

    /** the length of the vector (padded with 0 after highest index in indices). */
    private final int length;

    /**
     * Create a vector with sparse data.
     * @param vectorSI the data to store
     * @param indices the index values of the Vector
     * @param length the length of the vector (padded with 0 after highest index in indices)
     */
    public DoubleVectorDataSparse(final double[] vectorSI, final int[] indices, final int length)
    {
        super();
        this.vectorSI = vectorSI;
        this.indices = indices;
        this.length = length;
    }

    /**
     * @return a dense variant of the data.
     */
    public final DoubleVectorDataDense toDense()
    {
        double[] denseSI = new double[this.length];
        for (int index = 0; index < this.vectorSI.length; index++)
        {
            denseSI[this.indices[index]] = this.vectorSI[index];
        }
        return new DoubleVectorDataDense(denseSI);
    }

    /** {@inheritDoc} */
    @Override
    public final int size()
    {
        return this.length;
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI(final int index)
    {
        int internalIndex = Arrays.binarySearch(this.indices, index);
        return internalIndex < 0 ? 0.0 : this.vectorSI[internalIndex];
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int index, final double valueSI)
    {
        int internalIndex = Arrays.binarySearch(this.indices, index);
        if (internalIndex >= 0)
        {
            this.vectorSI[internalIndex] = valueSI;
            return;
        }

        // make room. TODO increase size in chunks
        internalIndex = -internalIndex - 1;
        int[] indicesNew = new int[this.indices.length + 1];
        double[] vectorSINew = new double[this.vectorSI.length + 1];
        System.arraycopy(this.indices, 0, indicesNew, 0, internalIndex);
        System.arraycopy(this.vectorSI, 0, vectorSINew, 0, internalIndex);
        System.arraycopy(this.indices, internalIndex, indicesNew, internalIndex - 1, this.indices.length
            - internalIndex);
        System.arraycopy(this.vectorSI, internalIndex, vectorSINew, internalIndex - 1, this.indices.length
            - internalIndex);
        indicesNew[internalIndex] = index;
        vectorSINew[internalIndex] = valueSI;
        this.indices = indicesNew;
        this.vectorSI = vectorSINew;
    }

    /** {@inheritDoc} */
    @Override
    public final double[] getDenseVectorSI()
    {
        return toDense().vectorSI;
    }

    /** {@inheritDoc} */
    @Override
    public final DoubleVectorDataSparse copy()
    {
        double[] vCopy = new double[this.vectorSI.length];
        System.arraycopy(this.vectorSI, 0, vCopy, 0, this.vectorSI.length);
        int[] iCopy = new int[this.indices.length];
        System.arraycopy(this.indices, 0, iCopy, 0, this.indices.length);
        return new DoubleVectorDataSparse(vCopy, iCopy, this.length);
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
        DoubleVectorDataSparse other = (DoubleVectorDataSparse) obj;
        if (!Arrays.equals(this.indices, other.indices))
            return false;
        if (this.length != other.length)
            return false;
        return true;
    }
}
