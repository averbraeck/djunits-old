package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Acceleration FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;AccelerationUnit&gt; value = new FloatScalar.Rel&lt;AccelerationUnit&gt;(100.0,
 * AccelerationUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatAcceleration value = new FloatAcceleration(100.0, AccelerationUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAcceleration extends FloatScalar.Rel<AccelerationUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatAcceleration scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatAcceleration(final float value, final AccelerationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAcceleration scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatAcceleration(final double value, final AccelerationUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatAcceleration scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatAcceleration(final FloatScalar.Rel<AccelerationUnit> value)
    {
        super(value);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAcceleration interpolate(final FloatAcceleration zero, final FloatAcceleration one,
        final float ratio)
    {
        return new FloatAcceleration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAcceleration interpolate(final FloatAcceleration zero, final FloatAcceleration one,
        final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration abs()
    {
        return new FloatAcceleration(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration acos()
    {
        return new FloatAcceleration((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration asin()
    {
        return new FloatAcceleration((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration atan()
    {
        return new FloatAcceleration((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration cbrt()
    {
        return new FloatAcceleration((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration ceil()
    {
        return new FloatAcceleration((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration cos()
    {
        return new FloatAcceleration((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration cosh()
    {
        return new FloatAcceleration((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration exp()
    {
        return new FloatAcceleration((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration expm1()
    {
        return new FloatAcceleration((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration floor()
    {
        return new FloatAcceleration((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration log()
    {
        return new FloatAcceleration((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration log10()
    {
        return new FloatAcceleration((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration log1p()
    {
        return new FloatAcceleration((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration rint()
    {
        return new FloatAcceleration((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration round()
    {
        return new FloatAcceleration(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration signum()
    {
        return new FloatAcceleration(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration sin()
    {
        return new FloatAcceleration((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration sinh()
    {
        return new FloatAcceleration((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration sqrt()
    {
        return new FloatAcceleration((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration tan()
    {
        return new FloatAcceleration((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration tanh()
    {
        return new FloatAcceleration((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration inv()
    {
        return new FloatAcceleration(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration toDegrees()
    {
        return new FloatAcceleration((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration toRadians()
    {
        return new FloatAcceleration((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration pow(final double x)
    {
        return new FloatAcceleration((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration multiplyBy(final float factor)
    {
        return new FloatAcceleration(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative acceleration
     */
    public final FloatAcceleration multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration divideBy(final float divisor)
    {
        return new FloatAcceleration(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative acceleration
     */
    public final FloatAcceleration divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatAcceleration plus(final FloatAcceleration v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatAcceleration(getInUnit() + v.getInUnit(), getUnit())
            : new FloatAcceleration(this.si + v.si, AccelerationUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatAcceleration minus(final FloatAcceleration v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatAcceleration(getInUnit() - v.getInUnit(), getUnit())
            : new FloatAcceleration(this.si - v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of FloatAcceleration and FloatAcceleration, which results in a FloatDimensionless scalar.
     * @param v FloatAcceleration scalar
     * @return FloatDimensionless scalar as a division of FloatAcceleration and FloatAcceleration
     */
    public final FloatDimensionless.Rel divideBy(final FloatAcceleration v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatAcceleration and FloatMass, which results in a FloatForce scalar.
     * @param v FloatAcceleration scalar
     * @return FloatForce scalar as a multiplication of FloatAcceleration and FloatMass
     */
    public final FloatForce multiplyBy(final FloatMass v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatAcceleration and FloatTime, which results in a FloatSpeed scalar.
     * @param v FloatAcceleration scalar
     * @return FloatSpeed scalar as a multiplication of FloatAcceleration and FloatTime
     */
    public final FloatSpeed multiplyBy(final FloatTime.Rel v)
    {
        return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatAcceleration and FloatFrequency, which results in a FloatSpeed scalar.
     * @param v FloatAcceleration scalar
     * @return FloatSpeed scalar as a division of FloatAcceleration and FloatFrequency
     */
    public final FloatSpeed divideBy(final FloatFrequency v)
    {
        return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatAcceleration and FloatSpeed, which results in a FloatFrequency scalar.
     * @param v FloatAcceleration scalar
     * @return FloatFrequency scalar as a division of FloatAcceleration and FloatSpeed
     */
    public final FloatFrequency divideBy(final FloatSpeed v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

}
