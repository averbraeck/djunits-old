package org.djunits4.value.vfloat.scalar.base;

import org.djunits4.unit.Unit;
import org.djunits4.value.base.Scalar;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vdouble.scalar.SIScalar;
import org.djunits4.value.vfloat.scalar.FloatDimensionless;
import org.djunits4.value.vfloat.scalar.FloatSIScalar;

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
 * @param <R> the Relative class for reference purposes
 */
public abstract class AbstractFloatScalarRel<U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>>
        extends AbstractFloatScalar<U, R> implements Scalar.Rel<U, R>
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

    /** {@inheritDoc} */
    @Override
    public R copy()
    {
        R result = instantiateRel(getSI(), getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public final R plus(final R increment)
    {
        if (getUnit().isBaseSIUnit())
        {
            return instantiateRel(this.getSI() + increment.getSI(), getUnit().getStandardUnit());
        }
        return getUnit().equals(increment.getUnit()) ? instantiateRel(getInUnit() + increment.getInUnit(), getUnit())
                : instantiateRel(this.getSI() + increment.getSI(), getUnit().getStandardUnit());
    }

    /** {@inheritDoc} */
    @Override
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
     * Interpolate between two values.
     * @param zero R; the low value
     * @param one R; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     * @param <U> the unit
     * @param <R> the Relative class for reference purposes
     */
    public static <U extends Unit<U>, R extends AbstractFloatScalarRel<U, R>> R interpolate(final R zero, final R one,
            final float ratio)
    {
        return zero.instantiateRel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Multiply this scalar by another scalar and create a new scalar.
     * @param otherScalar AbstractFloatScalarRel&lt;?, ?&gt;; the value by which this scalar is multiplied
     * @return FloatScalar&lt;?&gt;; a new scalar instance with correct SI dimensions
     */
    public FloatSIScalar times(AbstractFloatScalarRel<?, ?> otherScalar)
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
    public FloatSIScalar divide(AbstractFloatScalarRel<?, ?> otherScalar)
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
    public R neg()
    {
        return instantiateRel(-getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R times(final double constant)
    {
        return instantiateRel((float) (getInUnit() * constant), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R divide(final double constant)
    {
        return instantiateRel((float) (getInUnit() / constant), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R times(final float constant)
    {
        return instantiateRel(getInUnit() * constant, getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public R divide(final float constant)
    {
        return instantiateRel(getInUnit() / constant, getUnit());
    }

}
