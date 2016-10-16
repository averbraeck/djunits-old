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

/**
 * Easy access methods for the Speed FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;SpeedUnit&gt; value = new FloatScalar.Rel&lt;SpeedUnit&gt;(100.0, SpeedUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatSpeed value = new FloatSpeed(100.0, SpeedUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatSpeed extends AbstractFloatScalarRel<SpeedUnit, FloatSpeed>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatSpeed ZERO = new FloatSpeed(0.0f, SpeedUnit.SI);

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
     * Construct FloatSpeed scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatSpeed(final FloatSpeed value)
    {
        super(value);
    }

    /**
     * Construct FloatSpeed scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatSpeed(final double value, final SpeedUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeed instantiateRel(final float value, final SpeedUnit unit)
    {
        return new FloatSpeed(value, unit);
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
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatSpeed max(final FloatSpeed r1, final FloatSpeed r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatSpeed max(final FloatSpeed r1, final FloatSpeed r2, final FloatSpeed... rn)
    {
        FloatSpeed maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatSpeed r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatSpeed min(final FloatSpeed r1, final FloatSpeed r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatSpeed min(final FloatSpeed r1, final FloatSpeed r2, final FloatSpeed... rn)
    {
        FloatSpeed minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatSpeed r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatSpeed and FloatSpeed, which results in a FloatDimensionless scalar.
     * @param v FloatSpeed scalar
     * @return FloatDimensionless scalar as a division of FloatSpeed and FloatSpeed
     */
    public final FloatDimensionless divideBy(final FloatSpeed v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
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
    public final FloatFrequency divideBy(final FloatLength v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of FloatSpeed and FloatFrequency, which results in a FloatLength scalar.
     * @param v FloatSpeed scalar
     * @return FloatLength scalar as a division of FloatSpeed and FloatFrequency
     */
    public final FloatLength divideBy(final FloatFrequency v)
    {
        return new FloatLength(this.si / v.si, LengthUnit.SI);
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
     * Calculate the multiplication of FloatSpeed and FloatDuration, which results in a FloatLength scalar.
     * @param v FloatSpeed scalar
     * @return FloatLength scalar as a multiplication of FloatSpeed and FloatDuration
     */
    public final FloatLength multiplyBy(final FloatDuration v)
    {
        return new FloatLength(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of FloatSpeed and FloatDuration, which results in a FloatAcceleration scalar.
     * @param v FloatSpeed scalar
     * @return FloatAcceleration scalar as a division of FloatSpeed and FloatDuration
     */
    public final FloatAcceleration divideBy(final FloatDuration v)
    {
        return new FloatAcceleration(this.si / v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of FloatSpeed and FloatAcceleration, which results in a FloatDuration scalar.
     * @param v FloatSpeed scalar
     * @return FloatDuration scalar as a division of FloatSpeed and FloatAcceleration
     */
    public final FloatDuration divideBy(final FloatAcceleration v)
    {
        return new FloatDuration(this.si / v.si, TimeUnit.SI);
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
