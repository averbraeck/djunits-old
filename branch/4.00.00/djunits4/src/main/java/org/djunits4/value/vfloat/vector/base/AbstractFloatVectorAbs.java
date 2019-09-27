package org.djunits4.value.vfloat.vector.base;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Vector;
import org.djunits4.value.vfloat.function.FloatMathFunctions;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarAbs;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRelWithAbs;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * AbstractMutableFloatVectorRelWithAbs.java.
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
public abstract class AbstractFloatVectorAbs<
        AU  extends AbsoluteLinearUnit<AU, RU>, 
        A   extends AbstractFloatScalarAbs<AU, A, RU, R>,
        AV  extends AbstractFloatVectorAbs<AU, A, AV, RU, R, RV>, 
        RU  extends Unit<RU>,
        R   extends AbstractFloatScalarRelWithAbs<AU, A, RU, R>,
        RV  extends AbstractFloatVectorRelWithAbs<AU, A, AV, RU, R, RV>>
        extends AbstractFloatVector<AU, A, AV>
        implements Vector.Abs<AU, A, AV, RU, R, RV>, Absolute
// @formatter:on
{
    /** */
    private static final long serialVersionUID = 20190908L;

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param data FloatVectorData; an internal data object
     * @param unit U; the unit
     */
    protected AbstractFloatVectorAbs(final FloatVectorData data, final AU unit)
    {
        super(data.copy(), unit);
    }

    /** {@inheritDoc} */
    @Override
    public AV plus(RV increment) throws ValueRuntimeException
    {
        return FloatVector.instantiate(this.getData().plus(increment.getData()), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    public AV minus(RV decrement) throws ValueRuntimeException
    {
        return FloatVector.instantiate(this.getData().minus(decrement.getData()), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    public RV minus(AV decrement) throws ValueRuntimeException
    {
        return FloatVector.instantiate(this.getData().minus(decrement.getData()), decrement.getDisplayUnit().getRelativeUnit());
    }

    /**
     * Decrement all values of this vector by the decrement. This only works if the vector is mutable.
     * @param decrement R; the scalar by which to decrement all values
     * @return AV; this modified vector
     * @throws ValueRuntimeException in case this vector is immutable
     */
    @SuppressWarnings("unchecked")
    public AV decrementBy(final R decrement)
    {
        checkCopyOnWrite();
        assign(FloatMathFunctions.DEC(decrement.si));
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
