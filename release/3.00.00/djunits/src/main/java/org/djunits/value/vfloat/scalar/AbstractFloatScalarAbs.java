package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AbsoluteLinearUnit;
import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.MathFunctionsAbs;
import org.djunits.value.ValueUtil;
import org.djunits.value.vfloat.FloatMathFunctions;

/**
 * The typed, abstract FloatScalarAbs class that forms the basis of all FloatScalar definitions and extensions.<br>
 * Note: A relative scalar class can implement the toAbs() method if it has an absolute equivalent.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 13, 2016 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <AU> Absolute unit
 * @param <RU> Relative unit
 * @param <A> the absolute class for reference
 * @param <R> the relative class for reference
 */
public abstract class AbstractFloatScalarAbs<AU extends AbsoluteLinearUnit<AU, RU>,
        A extends AbstractFloatScalarAbs<AU, A, RU, R>, RU extends Unit<RU>, R extends AbstractFloatScalarRel<RU, R>>
        extends AbstractFloatScalar<AU, A> implements Absolute, MathFunctionsAbs<A>, FloatMathFunctions<A>
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new Absolute Immutable FloatScalar.
     * @param value float; the value of the new Absolute Immutable FloatScalar
     * @param unit U; the unit of the new Absolute Immutable FloatScalar
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
        super(value.getUnit(), value.si);
    }

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return A a new absolute instance of the FloatScalar of the right type
     */
    public abstract A instantiateAbs(float value, AU unit);

    /**
     * Construct a new Relative Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return R a new relative instance of the FloatScalar of the right type
     */
    public abstract R instantiateRel(float value, RU unit);

    /**
     * Increment the value by the supplied value and return the result using the current unit of the Absolute value.
     * @param increment R, a relative typed FloatScalar; amount by which the value is incremented
     * @return Absolute FloatScalar
     */
    public final A plus(final R increment)
    {
        AU targetUnit = getUnit();
        return instantiateAbs(getInUnit() + increment.getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Decrement the value by the supplied value and return the result using the current unit of the Absolute value.
     * @param decrement R, a relative typed FloatScalar; amount by which the value is decremented
     * @return Absolute FloatScalar
     */
    public final A minus(final R decrement)
    {
        AU targetUnit = getUnit();
        return instantiateAbs(getInUnit() - decrement.getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Decrement the value by the supplied value and return the result using the relative unit belonging to the unit of the
     * Absolute value.
     * @param decrement A, an absolute typed FloatScalar; amount by which the value is decremented
     * @return Relative FloatScalar
     */
    public final R minus(final A decrement)
    {
        RU targetUnit = getUnit().getRelativeUnit();
        return instantiateRel(getInUnit() - decrement.getInUnit(getUnit()), targetUnit);
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A ceil()
    {
        return instantiateAbs((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A floor()
    {
        return instantiateAbs((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A rint()
    {
        return instantiateAbs((float) Math.rint(getInUnit()), getUnit());
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
    public A multiplyBy(final float constant)
    {
        return instantiateAbs(getInUnit() * constant, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public A divideBy(final float constant)
    {
        return instantiateAbs(getInUnit() / constant, getUnit());
    }

}
