package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.value.Relative;

/**
 * Easy access methods for the Speed FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;SpeedUnit&gt; value = new FloatScalar.Rel&lt;SpeedUnit&gt;(100.0, SpeedUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatSpeed value = new FloatSpeed(100.0, SpeedUnit.SI);</i><br>
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
public class FloatSpeed extends FloatScalar.Rel<SpeedUnit> implements Relative
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct FloatSpeed scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatSpeed(final float value, final SpeedUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatSpeed scalar using a double value.
     * @param value double value
     * @param unit unit for the value
     */
    public FloatSpeed(final double value, final SpeedUnit unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct FloatSpeed scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatSpeed(final FloatScalar.Rel<SpeedUnit> value)
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
    public static FloatSpeed interpolate(final FloatSpeed zero, final FloatSpeed one, final float ratio)
    {
        return new FloatSpeed(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatSpeed interpolate(final FloatSpeed zero, final FloatSpeed one, final double ratio)
    {
        return interpolate(zero, one, (float) ratio);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed abs()
    {
        return new FloatSpeed(Math.abs(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed acos()
    {
        return new FloatSpeed((float) Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed asin()
    {
        return new FloatSpeed((float) Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed atan()
    {
        return new FloatSpeed((float) Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed cbrt()
    {
        return new FloatSpeed((float) Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed ceil()
    {
        return new FloatSpeed((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed cos()
    {
        return new FloatSpeed((float) Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed cosh()
    {
        return new FloatSpeed((float) Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed exp()
    {
        return new FloatSpeed((float) Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed expm1()
    {
        return new FloatSpeed((float) Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed floor()
    {
        return new FloatSpeed((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed log()
    {
        return new FloatSpeed((float) Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed log10()
    {
        return new FloatSpeed((float) Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed log1p()
    {
        return new FloatSpeed((float) Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed rint()
    {
        return new FloatSpeed((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed round()
    {
        return new FloatSpeed(Math.round(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed signum()
    {
        return new FloatSpeed(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed sin()
    {
        return new FloatSpeed((float) Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed sinh()
    {
        return new FloatSpeed((float) Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed sqrt()
    {
        return new FloatSpeed((float) Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed tan()
    {
        return new FloatSpeed((float) Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed tanh()
    {
        return new FloatSpeed((float) Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed inv()
    {
        return new FloatSpeed(1.0f / getInUnit(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed toDegrees()
    {
        return new FloatSpeed((float) Math.toDegrees(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed toRadians()
    {
        return new FloatSpeed((float) Math.toRadians(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed pow(final double x)
    {
        return new FloatSpeed((float) Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed multiplyBy(final float factor)
    {
        return new FloatSpeed(getInUnit() * factor, getUnit());
    }

    /**
     * Multiply scalar with a double factor.
     * @param factor the factor to multiply with
     * @return new instance of a relative speed
     */
    public final FloatSpeed multiplyBy(final double factor)
    {
        return multiplyBy((float) factor);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed divideBy(final float divisor)
    {
        return new FloatSpeed(getInUnit() / divisor, getUnit());
    }

    /**
     * Divide scalar by a double factor.
     * @param factor the factor to divide by
     * @return new instance of a relative speed
     */
    public final FloatSpeed divideBy(final double factor)
    {
        return divideBy((float) factor);
    }

    /**
     * Relative scalar plus Relative scalar = Relative scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatSpeed plus(final FloatSpeed v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatSpeed(getInUnit() + v.getInUnit(), getUnit()) : new FloatSpeed(
            this.si + v.si, SpeedUnit.SI);
    }

    /**
     * Relative scalar minus Relative scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final FloatSpeed minus(final FloatSpeed v)
    {
        return getUnit().equals(v.getUnit()) ? new FloatSpeed(getInUnit() - v.getInUnit(), getUnit()) : new FloatSpeed(
            this.si - v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatSpeed and FloatSpeed, which results in a FloatDimensionless scalar.
     * @param v FloatSpeed scalar
     * @return FloatDimensionless scalar as a division of FloatSpeed and FloatSpeed
     */
    public final FloatDimensionless.Rel divideBy(final FloatSpeed v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatSpeed and FloatArea, which results in a FloatFlowVolume scalar.
     * @param v FloatSpeed scalar
     * @return FloatFlowVolume scalar as a multiplication of FloatSpeed and FloatArea
     */
    public final FloatFlowVolume multiplyBy(final FloatArea v)
    {
        return new FloatFlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatSpeed and FloatForce, which results in a FloatPower scalar.
     * @param v FloatSpeed scalar
     * @return FloatPower scalar as a multiplication of FloatSpeed and FloatForce
     */
    public final FloatPower multiplyBy(final FloatForce v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatSpeed and FloatFrequency, which results in a FloatAcceleration scalar.
     * @param v FloatSpeed scalar
     * @return FloatAcceleration scalar as a multiplication of FloatSpeed and FloatFrequency
     */
    public final FloatAcceleration multiplyBy(final FloatFrequency v)
    {
        return new FloatAcceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of FloatSpeed and FloatLength, which results in a FloatFrequency scalar.
     * @param v FloatSpeed scalar
     * @return FloatFrequency scalar as a division of FloatSpeed and FloatLength
     */
    public final FloatFrequency divideBy(final FloatLength.Rel v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of FloatSpeed and FloatFrequency, which results in a FloatLength scalar.
     * @param v FloatSpeed scalar
     * @return FloatLength scalar as a division of FloatSpeed and FloatFrequency
     */
    public final FloatLength.Rel divideBy(final FloatFrequency v)
    {
        return new FloatLength.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatSpeed and FloatLinearDensity, which results in a FloatFrequency scalar.
     * @param v FloatSpeed scalar
     * @return FloatFrequency scalar as a multiplication of FloatSpeed and FloatLinearDensity
     */
    public final FloatFrequency multiplyBy(final FloatLinearDensity v)
    {
        return new FloatFrequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatSpeed and FloatTime, which results in a FloatLength scalar.
     * @param v FloatSpeed scalar
     * @return FloatLength scalar as a multiplication of FloatSpeed and FloatTime
     */
    public final FloatLength.Rel multiplyBy(final FloatTime.Rel v)
    {
        return new FloatLength.Rel(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of FloatSpeed and FloatTime, which results in a FloatAcceleration scalar.
     * @param v FloatSpeed scalar
     * @return FloatAcceleration scalar as a division of FloatSpeed and FloatTime
     */
    public final FloatAcceleration divideBy(final FloatTime.Rel v)
    {
        return new FloatAcceleration(this.si / v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of FloatSpeed and FloatAcceleration, which results in a FloatTime scalar.
     * @param v FloatSpeed scalar
     * @return FloatTime scalar as a division of FloatSpeed and FloatAcceleration
     */
    public final FloatTime.Rel divideBy(final FloatAcceleration v)
    {
        return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatSpeed and FloatFlowMass, which results in a FloatForce scalar.
     * @param v FloatSpeed scalar
     * @return FloatForce scalar as a multiplication of FloatSpeed and FloatFlowMass
     */
    public final FloatForce multiplyBy(final FloatFlowMass v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

}
