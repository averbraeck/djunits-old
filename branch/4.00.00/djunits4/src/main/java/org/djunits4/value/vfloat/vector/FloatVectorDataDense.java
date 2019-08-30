package org.djunits4.value.vfloat.vector;

import java.util.stream.IntStream;

import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.FloatFunction;

/**
 * Stores dense data for a FloatVector and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatVectorDataDense extends FloatVectorData
{
    /** */
    private static final long serialVersionUID = 1L;

    /**
     * Create a vector with dense data.
     * @param vectorSI float[]; the data to store
     */
    public FloatVectorDataDense(final float[] vectorSI)
    {
        super(StorageType.DENSE);
        this.vectorSI = new float[vectorSI.length];
        System.arraycopy(vectorSI, 0, this.vectorSI, 0, vectorSI.length);
    }

    /**
     * @param floatFunction FloatFunction; the function to apply on the (mutable) data elements
     */
    public final void assign(final FloatFunction floatFunction)
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] = floatFunction.apply(this.vectorSI[i]));
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVectorDataSparse toSparse()
    {
        return FloatVectorDataSparse.instantiate(this.vectorSI);
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

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final FloatVectorData right) throws ValueException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] += right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final float valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] += valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final FloatVectorData right) throws ValueException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] -= right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final float valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] -= valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final FloatVectorData right) throws ValueException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] *= right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final float valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] *= valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final FloatVectorData right) throws ValueException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] /= right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final float valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] /= valueSI);
    }

}
