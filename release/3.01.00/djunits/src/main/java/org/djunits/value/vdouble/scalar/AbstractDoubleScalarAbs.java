package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AbsoluteLinearUnit;
import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.MathFunctionsAbs;
import org.djunits.value.ValueUtil;
import org.djunits.value.vdouble.DoubleMathFunctions;

/**
 * The typed, abstract DoubleScalarAbs class that forms the basis of all DoubleScalar definitions and extensions.<br>
 * Note: A relative scalar class can implement the toAbs() method if it has an absolute equivalent.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 13, 2016 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <AU> the absolute unit
 * @param <A> the Absolute class for reference purposes
 * @param <RU> the relative unit
 * @param <R> the Relative class for reference purposes
 */
public abstract class AbstractDoubleScalarAbs<AU extends AbsoluteLinearUnit<AU, RU>,
        A extends AbstractDoubleScalarAbs<AU, A, RU, R>, RU extends Unit<RU>, R extends AbstractDoubleScalarRel<RU, R>>
        extends AbstractDoubleScalar<AU, A> implements Absolute, MathFunctionsAbs<A>, DoubleMathFunctions<A>
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
        super(value.getUnit(), value.si);
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

    /**
     * Increment the value by the supplied value and return the result using the current unit of the Absolute value.
     * @param increment R, a relative typed DoubleScalar; amount by which the value is incremented
     * @return Absolute DoubleScalar
     */
    public final A plus(final R increment)
    {
        AU targetUnit = getUnit();
        return instantiateAbs(getInUnit() + increment.getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Decrement the value by the supplied value and return the result using the current unit of the Absolute value.
     * @param decrement R, a relative typed DoubleScalar; amount by which the value is decremented
     * @return Absolute DoubleScalar
     */
    public final A minus(final R decrement)
    {
        AU targetUnit = getUnit();
        return instantiateAbs(getInUnit() - decrement.getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Decrement the value by the supplied value and return the result using the relative unit belonging to the unit of the
     * Absolute value.
     * @param decrement A, an absolute typed DoubleScalar; amount by which the value is decremented
     * @return Relative DoubleScalar
     */
    public final R minus(final A decrement)
    {
        RU targetUnit = getUnit().getRelativeUnit();
        return instantiateRel(getInUnit() - decrement.getInUnit(getUnit()), targetUnit);
    }

    /**
     * Interpolate between two values.
     * @param zero Duration; the low value
     * @param one Duration; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     * @param <AU> the absolute unit
     * @param <A> the Absolute class for reference purposes
     * @param <RU> the relative unit
     * @param <R> the Relative class for reference purposes
     */
    public static <AU extends AbsoluteLinearUnit<AU, RU>, A extends AbstractDoubleScalarAbs<AU, A, RU, R>, RU extends Unit<RU>,
            R extends AbstractDoubleScalarRel<RU, R>> A interpolate(final A zero, final A one, final double ratio)
    {
        return zero.instantiateAbs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

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
    public A rint()
    {
        return instantiateAbs(Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A round()
    {
        return instantiateAbs(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A multiplyBy(final double constant)
    {
        return instantiateAbs(getInUnit() * constant, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A divideBy(final double constant)
    {
        return instantiateAbs(getInUnit() / constant, getUnit());
    }

}
