package org.djunits4.value.vdouble.vector.base;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Vector;
import org.djunits4.value.vdouble.function.DoubleMathFunctions;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarAbs;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRelWithAbs;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * AbstractMutableDoubleVectorRelWithAbs.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <AU> the absolute unit belonging to the relative unit
 * @param <A> the absolute scalar type belonging to the absolute vector type
 * @param <AV> the (immutable or mutable) absolute vector type
 * @param <RU> the relative unit belonging to the absolute unit
 * @param <R> the relative scalar type belonging to the relative vector type
 * @param <RV> the relative (immutable or mutable) vector type with this unit
 */
// @formatter:off
public abstract class AbstractDoubleVectorAbs<
        AU  extends AbsoluteLinearUnit<AU, RU>, 
        A   extends AbstractDoubleScalarAbs<AU, A, RU, R>,
        AV  extends AbstractDoubleVectorAbs<AU, A, AV, RU, R, RV>, 
        RU  extends Unit<RU>,
        R   extends AbstractDoubleScalarRelWithAbs<AU, A, RU, R>,
        RV  extends AbstractDoubleVectorRelWithAbs<AU, A, AV, RU, R, RV>>
        extends AbstractDoubleVector<AU, A, AV>
        implements Vector.Abs<AU, A, AV, RU, R, RV>, Absolute
// @formatter:on
{
    /** */
    private static final long serialVersionUID = 20190908L;

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit U; the unit
     */
    protected AbstractDoubleVectorAbs(final DoubleVectorData data, final AU unit)
    {
        super(data.copy(), unit);
    }

    /** {@inheritDoc} */
    @Override
    public AV plus(RV increment) throws ValueRuntimeException
    {
        return DoubleVector.instantiate(this.getData().plus(increment.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public AV minus(RV decrement) throws ValueRuntimeException
    {
        return DoubleVector.instantiate(this.getData().minus(decrement.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public RV minus(AV decrement) throws ValueRuntimeException
    {
        return DoubleVector.instantiate(this.getData().minus(decrement.getData()), decrement.getUnit().getRelativeUnit());
    }

    /**
     * Decrement all values of this vector by the decrement. This only works if this vector is mutable.
     * @param decrement R; the scalar by which to decrement all values
     * @return AV; this modified vector
     * @throws ValueRuntimeException in case this vector is immutable
     */
    @SuppressWarnings("unchecked")
    public AV decrementBy(final R decrement)
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.DEC(decrement.si));
        return (AV) this;
    }

    /**
     * Decrement all values of this vector by the decrement on a value by value basis. This only works if this vector is mutable.
     * @param decrement RV; the vector that contains the values by which to decrement the corresponding values
     * @return AV; this modified vector
     * @throws ValueRuntimeException in case this vector is immutable
     * @Throws ValueException when the sizes of the vectors differ, or <code>decrement</code> is null
     */
    @SuppressWarnings("unchecked")
    public AV decrementBy(RV decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement.getData());
        return (AV) this;
    }

}
