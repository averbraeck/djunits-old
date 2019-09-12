package org.djunits4.value.vfloat.scalar;

import org.djunits4.unit.Unit;
import org.djunits4.value.Relative;
import org.djunits4.value.function.MathFunctionsRel;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vfloat.FloatMathFunctions;

/**
 * The typed, abstract FloatScalarRel class that forms the basis of all FloatScalar definitions and extensions.<br>
 * Note: A relative scalar class can implement the toAbs() method if it has an absolute equivalent.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
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
        super(value.getUnit(), value.getSI());
    }

    /**
     * Construct a new Relative Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value float; the float value
     * @param unit U; the unit
     * @return R a new relative instance of the FloatScalar of the right type
     */
    public abstract R instantiateRel(float value, U unit);

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
            return instantiateRel(this.getSI() + increment.getSI(), getUnit().getStandardUnit());
        }
        return getUnit().equals(increment.getUnit()) ? instantiateRel(getInUnit() + increment.getInUnit(), getUnit())
                : instantiateRel(this.getSI() + increment.getSI(), getUnit().getStandardUnit());
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
            return instantiateRel(this.getSI() - decrement.getSI(), getUnit().getStandardUnit());
        }
        return getUnit().equals(decrement.getUnit()) ? instantiateRel(getInUnit() - decrement.getInUnit(), getUnit())
                : instantiateRel(this.getSI() - decrement.getSI(), getUnit().getStandardUnit());
    }

    /**
     * Multiply this scalar by another scalar and create a new scalar.
     * @param otherScalar AbstractFloatScalarRel&lt;?, ?&gt;; the value by which this scalar is multiplied
     * @return FloatScalar&lt;?&gt;; a new scalar instance with correct SI dimensions
     */
    public FloatSIScalar multiplyBy(AbstractFloatScalarRel<?, ?> otherScalar)
    {
        return FloatScalar.multiply(this, otherScalar);
    }

    /**
     * Create the reciprocal of this scalar with the correct dimensions.
     * @return FloatScalar&lt;?&gt;; a new scalar instance with correct SI dimensions
     */
    public FloatSIScalar reciprocal()
    {
        return FloatScalar.divide(FloatDimensionless.ONE, this);
    }

    /**
     * Divide this scalar by another scalar and create a new scalar.
     * @param otherScalar AbstractFloatScalarRel&lt;?, ?&gt;; the value by which this scalar is divided
     * @return FloatScalar&lt;?&gt;; a new scalar instance with correct SI dimensions
     */
    public FloatSIScalar divideBy(AbstractFloatScalarRel<?, ?> otherScalar)
    {
        return FloatScalar.divide(this, otherScalar);
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
