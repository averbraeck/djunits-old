package org.djunits4.value.vfloat.scalar.base;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.base.Scalar;
import org.djunits4.value.util.ValueUtil;

/**
 * The typed, abstract FloatScalarAbs class that forms the basis of all FloatScalar definitions and extensions.<br>
 * Note: A relative scalar class can implement the toAbs() method if it has an absolute equivalent.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <AU> the absolute unit
 * @param <A> the Absolute class for reference purposes
 * @param <RU> the relative unit
 * @param <R> the Relative class for reference purposes
 */
public abstract class AbstractFloatScalarAbs<AU extends AbsoluteLinearUnit<AU, RU>,
        A extends AbstractFloatScalarAbs<AU, A, RU, R>, RU extends Unit<RU>,
        R extends AbstractFloatScalarRelWithAbs<AU, A, RU, R>> extends AbstractFloatScalar<AU, A>
        implements Scalar.Abs<AU, A, RU, R>
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new Absolute Immutable FloatScalar.
     * @param value float; the value of the new Absolute Immutable FloatScalar
     * @param unit AU; the unit of the new Absolute Immutable FloatScalar
     */
    public AbstractFloatScalarAbs(final float value, final AU unit)
    {
        super(unit, unit.isBaseSIUnit() ? value : (float) ValueUtil.expressAsSIUnit(value, unit));
    }

    /**
     * Construct a new Absolute Immutable FloatScalar from an existing Absolute Immutable FloatScalar.
     * @param value A, an absolute typed FloatScalar; the reference
     */
    public AbstractFloatScalarAbs(final A value)
    {
        super(value.getDisplayUnit(), value.getSI());
    }

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value float; the float value
     * @param unit AU; the unit
     * @return A a new absolute instance of the FloatScalar of the right type
     */
    public abstract A instantiateAbs(float value, AU unit);

    /**
     * Construct a new Relative Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value float; the float value
     * @param unit RU; the unit
     * @return R a new relative instance of the FloatScalar of the right type
     */
    public abstract R instantiateRel(float value, RU unit);

    /** {@inheritDoc} */
    @Override
    public final A plus(final R increment)
    {
        AU targetUnit = getDisplayUnit();
        return instantiateAbs(getInUnit() + increment.getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final A minus(final R decrement)
    {
        AU targetUnit = getDisplayUnit();
        return instantiateAbs(getInUnit() - decrement.getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final R minus(final A decrement)
    {
        RU targetUnit = getDisplayUnit().getRelativeUnit();
        return instantiateRel(getInUnit() - decrement.getInUnit(getDisplayUnit()), targetUnit);
    }

    /**
     * Interpolate between two values.
     * @param zero A; the low value
     * @param one A; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     * @param <AU> the absolute unit
     * @param <A> the Absolute class for reference purposes
     * @param <RU> the relative unit
     * @param <R> the Relative class for reference purposes
     */
    public static <AU extends AbsoluteLinearUnit<AU, RU>, A extends AbstractFloatScalarAbs<AU, A, RU, R>, RU extends Unit<RU>,
            R extends AbstractFloatScalarRelWithAbs<AU, A, RU, R>> A interpolate(final A zero, final A one, final float ratio)
    {
        return zero.instantiateAbs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio, zero.getDisplayUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A abs()
    {
        return instantiateAbs(Math.abs(getInUnit()), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A ceil()
    {
        return instantiateAbs((float) Math.ceil(getInUnit()), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A floor()
    {
        return instantiateAbs((float) Math.floor(getInUnit()), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A neg()
    {
        return instantiateAbs(-getInUnit(), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A rint()
    {
        return instantiateAbs((float) Math.rint(getInUnit()), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A times(final double constant)
    {
        return instantiateAbs((float) (getInUnit() * constant), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A divide(final double constant)
    {
        return instantiateAbs((float) (getInUnit() / constant), getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A times(final float constant)
    {
        return instantiateAbs(getInUnit() * constant, getDisplayUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A divide(final float constant)
    {
        return instantiateAbs(getInUnit() / constant, getDisplayUnit());
    }

}
