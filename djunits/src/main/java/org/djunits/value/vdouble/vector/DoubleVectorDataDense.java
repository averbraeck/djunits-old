package org.djunits.value.vdouble.vector;

import java.util.stream.IntStream;

import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.DoubleFunction;

/**
 * Stores dense data for a DoubleVector and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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
        super(StorageType.DENSE);
        this.vectorSI = new double[vectorSI.length];
        System.arraycopy(vectorSI, 0, this.vectorSI, 0, vectorSI.length);
    }

    /**
     * @param doubleFunction the function to apply on the (mutable) data elements
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
    public final void incrementBy(final DoubleVectorData right) throws ValueException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] += right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final DoubleVectorData right) throws ValueException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] -= right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final DoubleVectorData right) throws ValueException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] *= right.getSI(i));
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final DoubleVectorData right) throws ValueException
    {
        IntStream.range(0, size()).parallel().forEach(i -> this.vectorSI[i] /= right.getSI(i));
    }
}
