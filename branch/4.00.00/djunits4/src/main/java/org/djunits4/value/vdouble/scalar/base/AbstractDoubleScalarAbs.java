package org.djunits4.value.vdouble.scalar.base;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.base.Scalar;
import org.djunits4.value.util.ValueUtil;

/**
 * The typed, abstract DoubleScalarAbs class that forms the basis of all DoubleScalar definitions and extensions.<br>
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
public abstract class AbstractDoubleScalarAbs<AU extends AbsoluteLinearUnit<AU, RU>,
        A extends AbstractDoubleScalarAbs<AU, A, RU, R>, RU extends Unit<RU>,
        R extends AbstractDoubleScalarRelWithAbs<AU, A, RU, R>> extends AbstractDoubleScalar<AU, A>
        implements Scalar.Abs<AU, A, RU, R>
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new Absolute Immutable DoubleScalar.
     * @param value double; the value of the new Absolute Immutable DoubleScalar
     * @param unit AU; the unit of the new Absolute Immutable DoubleScalar
     */
    public AbstractDoubleScalarAbs(final double value, final AU unit)
    {
        super(unit, unit.isBaseSIUnit() ? value : ValueUtil.expressAsSIUnit(value, unit));
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar from an existing Absolute Immutable DoubleScalar.
     * @param value A, an absolute typed DoubleScalar; the reference
     */
    public AbstractDoubleScalarAbs(final A value)
    {
        super(value.getUnit(), value.getSI());
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the double value
     * @param unit AU; the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    public abstract A instantiateAbs(double value, AU unit);

    /**
     * Construct a new Relative Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the double value
     * @param unit RU; the unit
     * @return R a new relative instance of the DoubleScalar of the right type
     */
    public abstract R instantiateRel(double value, RU unit);

    /** {@inheritDoc} */
    @Override
    public A copy()
    {
        A result = instantiateAbs(getSI(), getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public final A plus(final R increment)
    {
        AU targetUnit = getUnit();
        return instantiateAbs(getInUnit() + increment.getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final A minus(final R decrement)
    {
        AU targetUnit = getUnit();
        return instantiateAbs(getInUnit() - decrement.getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final R minus(final A decrement)
    {
        RU targetUnit = getUnit().getRelativeUnit();
        return instantiateRel(getInUnit() - decrement.getInUnit(getUnit()), targetUnit);
    }

    /**
     * Interpolate between two values.
     * @param zero A; the low value
     * @param one A; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     * @param <AU> the absolute unit
     * @param <A> the Absolute class for reference purposes
     * @param <RU> the relative unit
     * @param <R> the Relative class for reference purposes
     */
    public static <AU extends AbsoluteLinearUnit<AU, RU>, A extends AbstractDoubleScalarAbs<AU, A, RU, R>, RU extends Unit<RU>,
            R extends AbstractDoubleScalarRelWithAbs<AU, A, RU, R>> A interpolate(final A zero, final A one, final double ratio)
    {
        return zero.instantiateAbs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A abs()
    {
        return instantiateAbs(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A ceil()
    {
        return instantiateAbs(Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A floor()
    {
        return instantiateAbs(Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A neg()
    {
        return instantiateAbs(-getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A rint()
    {
        return instantiateAbs(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A times(final double constant)
    {
        return instantiateAbs(getInUnit() * constant, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A divide(final double constant)
    {
        return instantiateAbs(getInUnit() / constant, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A times(final float constant)
    {
        return instantiateAbs(getInUnit() * constant, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A divide(final float constant)
    {
        return instantiateAbs(getInUnit() / constant, getUnit());
    }

}
