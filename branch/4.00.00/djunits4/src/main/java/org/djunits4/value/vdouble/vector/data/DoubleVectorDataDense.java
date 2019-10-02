package org.djunits4.value.vdouble.vector.data;

import java.util.stream.IntStream;

import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.function.DoubleFunction;

/**
 * Stores dense data for a DoubleVector and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class DoubleVectorDataDense extends DoubleVectorData
{
    /** */
    private static final long serialVersionUID = 1L;

    /**
     * Create a vector with dense data.
     * @param vectorSI double[]; the data to store
     */
    public DoubleVectorDataDense(final double[] vectorSI)
    {
        super(StorageType.DENSE);
        this.vectorSI = new double[vectorSI.length];
        System.arraycopy(vectorSI, 0, this.vectorSI, 0, vectorSI.length);
    }

    /**
     * Modify the data by applying a function to each value.
     * @param doubleFunction DoubleFunction; the function to apply on the (mutable) data elements
     */
    public final void assign(final DoubleFunction doubleFunction)
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] = doubleFunction.apply(this.vectorSI[i]));
    }

    /** {@inheritDoc} */
    @Override
    public final DoubleVectorDataSparse toSparse()
    {
        return DoubleVectorDataSparse.instantiate(this.vectorSI);
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

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final DoubleVectorData right) throws ValueRuntimeException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] += right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final DoubleVectorData right) throws ValueRuntimeException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] -= right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final DoubleVectorData right) throws ValueRuntimeException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] *= right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final double valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] *= valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final DoubleVectorData right) throws ValueRuntimeException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] /= right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final double valueSI)
    {
        IntStream.range(0, this.vectorSI.length).parallel().forEach(i -> this.vectorSI[i] /= valueSI);
    }

}
