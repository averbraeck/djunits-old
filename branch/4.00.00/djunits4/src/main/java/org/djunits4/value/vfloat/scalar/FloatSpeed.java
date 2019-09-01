package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.unit.AccelerationUnit;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.FlowVolumeUnit;
import org.djunits4.unit.ForceUnit;
import org.djunits4.unit.FrequencyUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PowerUnit;
import org.djunits4.unit.SpeedUnit;

/**
 * Easy access methods for the FloatSpeed FloatScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatSpeed extends AbstractFloatScalarRel<SpeedUnit, FloatSpeed>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatSpeed ZERO = new FloatSpeed(0.0f, SpeedUnit.SI);

    /** constant with value zero. */
    public static final FloatSpeed ONE = new FloatSpeed(1.0f, SpeedUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatSpeed NaN = new FloatSpeed(Float.NaN, SpeedUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatSpeed POSITIVE_INFINITY = new FloatSpeed(Float.POSITIVE_INFINITY, SpeedUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatSpeed NEGATIVE_INFINITY = new FloatSpeed(Float.NEGATIVE_INFINITY, SpeedUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatSpeed POS_MAXVALUE = new FloatSpeed(Float.MAX_VALUE, SpeedUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatSpeed NEG_MAXVALUE = new FloatSpeed(-Float.MAX_VALUE, SpeedUnit.SI);

    /**
     * Construct FloatSpeed scalar.
     * @param value float; the float value
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
     * @param value double; the double value
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
     * Construct FloatSpeed scalar.
     * @param value float; the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatSpeed createSI(final float value)
    {
        return new FloatSpeed(value, SpeedUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
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
     * Returns a FloatSpeed representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not required, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatSpeed
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatSpeed valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatSpeed -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (SpeedUnit unit : SpeedUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatSpeed(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatSpeed from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatSpeed from " + text);
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
        return new FloatDuration(this.si / v.si, DurationUnit.SI);
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
