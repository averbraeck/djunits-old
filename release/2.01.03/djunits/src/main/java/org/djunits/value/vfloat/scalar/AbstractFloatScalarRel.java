package org.djunits.value.vfloat.scalar;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsRel;
import org.djunits.value.Relative;
import org.djunits.value.ValueUtil;
import org.djunits.value.vfloat.FloatMathFunctions;

/**
 * The typed, abstract FloatScalarRel class that forms the basis of all FloatScalar definitions and extensions.<br>
 * Note: A relative scalar class can implement the toAbs() method if it has an absolute equivalent.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 13, 2016 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 * @param <R> the relative class for reference
 */
public abstract class AbstractFloatScalarRel<U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>>
        extends AbstractFloatScalar<U, R> implements Relative, MathFunctionsRel<R>, FloatMathFunctions<R>
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new Relative Immutable FloatScalar.
     * @param value float; the value of the new Relative Immutable FloatScalar
     * @param unit U; the unit of the new Relative Immutable FloatScalar
     */
    public AbstractFloatScalarRel(final float value, final U unit)
    {
        super(unit, unit.isBaseSIUnit() ? value : (float) ValueUtil.expressAsSIUnit(value, unit));
    }

    /**
     * Construct a new Relative Immutable FloatScalar from an existing Relative Immutable FloatScalar.
     * @param value R, a relative typed FloatScalar; the reference
     */
    public AbstractFloatScalarRel(final R value)
    {
        super(value.getUnit(), value.si);
    }

    /**
     * Construct a new Relative Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return R a new relative instance of the FloatScalar of the right type
     */
    public abstract R instantiateRel(final float value, final U unit);

    /**
     * Increment the value by the supplied value and return the result. If the units are equal, the result is expressed in that
     * unit. If the units are unequal, the result is expressed in the standard (often SI) unit.
     * @param increment R, a relative typed FloatScalar; amount by which the value is incremented
     * @return Absolute FloatScalar
     */
    public final R plus(final R increment)
    {
        if (getUnit().isBaseSIUnit())
        {
            return instantiateRel(this.si + increment.si, getUnit().getStandardUnit());
        }
        return getUnit().equals(increment.getUnit()) ? instantiateRel(getInUnit() + increment.getInUnit(), getUnit())
                : instantiateRel(this.si + increment.si, getUnit().getStandardUnit());
    }

    /**
     * Decrement the value by the supplied value and return the result. If the units are equal, the result is expressed in that
     * unit. If the units are unequal, the result is expressed in the standard (often SI) unit.
     * @param decrement R, a relative typed FloatScalar; amount by which the value is decremented
     * @return Relative FloatScalar
     */
    public final R minus(final R decrement)
    {
        if (getUnit().isBaseSIUnit())
        {
            return instantiateRel(this.si - decrement.si, getUnit().getStandardUnit());
        }
        return getUnit().equals(decrement.getUnit()) ? instantiateRel(getInUnit() - decrement.getInUnit(), getUnit())
                : instantiateRel(this.si - decrement.si, getUnit().getStandardUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R abs()
    {
        return instantiateRel(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R ceil()
    {
        return instantiateRel((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R floor()
    {
        return instantiateRel((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R rint()
    {
        return instantiateRel((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R round()
    {
        return instantiateRel(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R neg()
    {
        return instantiateRel(-getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R multiplyBy(final float constant)
    {
        return instantiateRel(getInUnit() * constant, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R divideBy(final float constant)
    {
        return instantiateRel(getInUnit() / constant, getUnit());
    }
}