package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.ElectricalChargeUnit;
import org.djunits4.unit.EnergyUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.MassUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.unit.VolumeUnit;

/**
 * Easy access methods for the FloatDuration FloatScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatDuration extends AbstractFloatScalarRel<DurationUnit, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatDuration ZERO = new FloatDuration(0.0f, DurationUnit.SI);

    /** constant with value one. */
    public static final FloatDuration ONE = new FloatDuration(1.0f, DurationUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatDuration NaN = new FloatDuration(Float.NaN, DurationUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatDuration POSITIVE_INFINITY = new FloatDuration(Float.POSITIVE_INFINITY, DurationUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatDuration NEGATIVE_INFINITY = new FloatDuration(Float.NEGATIVE_INFINITY, DurationUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatDuration POS_MAXVALUE = new FloatDuration(Float.MAX_VALUE, DurationUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatDuration NEG_MAXVALUE = new FloatDuration(-Float.MAX_VALUE, DurationUnit.SI);

    /**
     * Construct FloatDuration scalar.
     * @param value float; the float value
     * @param unit DurationUnit; unit for the float value
     */
    public FloatDuration(final float value, final DurationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatDuration scalar.
     * @param value FloatDuration; Scalar from which to construct this instance
     */
    public FloatDuration(final FloatDuration value)
    {
        super(value);
    }

    /**
     * Construct FloatDuration scalar using a double value.
     * @param value double; the double value
     * @param unit DurationUnit; unit for the resulting float value
     */
    public FloatDuration(final double value, final DurationUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDuration instantiateRel(final float value, final DurationUnit unit)
    {
        return new FloatDuration(value, unit);
    }

    /**
     * Construct FloatDuration scalar.
     * @param value float; the float value in SI units
     * @return FloatDuration; the new scalar with the SI value
     */
    public static final FloatDuration createSI(final float value)
    {
        return new FloatDuration(value, DurationUnit.SI);
    }

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value float; the float value
     * @param unit TimeUnit; the unit
     * @return FloatTime; a new absolute instance of the FloatScalar of the right type
     */
    public final FloatTime instantiateAbs(final float value, final TimeUnit unit)
    {
        return new FloatTime(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatDuration; the low value
     * @param one FloatDuration; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return FloatDuration; a Scalar at the ratio between
     */
    public static FloatDuration interpolate(final FloatDuration zero, final FloatDuration one, final float ratio)
    {
        return new FloatDuration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v FloatTime; ; the value to add
     * @return FloatTime; sum of this value and v as a new object
     */
    public final FloatTime plus(final FloatTime v)
    {
        TimeUnit targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatDuration; the first scalar
     * @param r2 FloatDuration; the second scalar
     * @return FloatDuration; the maximum value of two relative scalars
     */
    public static FloatDuration max(final FloatDuration r1, final FloatDuration r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatDuration; the first scalar
     * @param r2 FloatDuration; the second scalar
     * @param rn FloatDuration...; the other scalars
     * @return FloatDuration; the maximum value of more than two relative scalars
     */
    public static FloatDuration max(final FloatDuration r1, final FloatDuration r2, final FloatDuration... rn)
    {
        FloatDuration maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatDuration r : rn)
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
     * @param r1 FloatDuration; the first scalar
     * @param r2 FloatDuration; the second scalar
     * @return FloatDuration; the minimum value of two relative scalars
     */
    public static FloatDuration min(final FloatDuration r1, final FloatDuration r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatDuration; the first scalar
     * @param r2 FloatDuration; the second scalar
     * @param rn FloatDuration...; the other scalars
     * @return FloatDuration; the minimum value of more than two relative scalars
     */
    public static FloatDuration min(final FloatDuration r1, final FloatDuration r2, final FloatDuration... rn)
    {
        FloatDuration minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatDuration r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatDuration representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not required, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatDuration
     * @return FloatDuration; the Scalar value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatDuration valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatDuration -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (DurationUnit unit : DurationUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatDuration(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatDuration from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatDuration from " + text);
    }

    /**
     * Calculate the division of FloatDuration and FloatDuration, which results in a FloatDimensionless scalar.
     * @param v FloatDuration scalar
     * @return FloatDimensionless scalar as a division of FloatDuration and FloatDuration
     */
    public final FloatDimensionless divideBy(final FloatDuration v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatFrequency, which results in a FloatDimensionless scalar.
     * @param v FloatDuration scalar
     * @return FloatDimensionless scalar as a multiplication of FloatDuration and FloatFrequency
     */
    public final FloatDimensionless multiplyBy(final FloatFrequency v)
    {
        return new FloatDimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatElectricalCurrent, which results in a FloatElectricalCharge
     * scalar.
     * @param v FloatDuration scalar
     * @return FloatElectricalCharge scalar as a multiplication of FloatDuration and FloatElectricalCurrent
     */
    public final FloatElectricalCharge multiplyBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatFlowMass, which results in a FloatMass scalar.
     * @param v FloatDuration scalar
     * @return FloatMass scalar as a multiplication of FloatDuration and FloatFlowMass
     */
    public final FloatMass multiplyBy(final FloatFlowMass v)
    {
        return new FloatMass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatFlowVolume, which results in a FloatVolume scalar.
     * @param v FloatDuration scalar
     * @return FloatVolume scalar as a multiplication of FloatDuration and FloatFlowVolume
     */
    public final FloatVolume multiplyBy(final FloatFlowVolume v)
    {
        return new FloatVolume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatAcceleration, which results in a FloatSpeed scalar.
     * @param v FloatDuration scalar
     * @return FloatSpeed scalar as a multiplication of FloatDuration and FloatAcceleration
     */
    public final FloatSpeed multiplyBy(final FloatAcceleration v)
    {
        return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatPower, which results in a FloatEnergy scalar.
     * @param v FloatDuration scalar
     * @return FloatEnergy scalar as a multiplication of FloatDuration and FloatPower
     */
    public final FloatEnergy multiplyBy(final FloatPower v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDuration and FloatSpeed, which results in a FloatLength scalar.
     * @param v FloatDuration scalar
     * @return FloatLength scalar as a multiplication of FloatDuration and FloatSpeed
     */
    public final FloatLength multiplyBy(final FloatSpeed v)
    {
        return new FloatLength(this.si * v.si, LengthUnit.SI);
    }

}
