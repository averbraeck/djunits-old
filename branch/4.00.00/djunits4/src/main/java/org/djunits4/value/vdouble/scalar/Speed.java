package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

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
 * Easy access methods for the Speed DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;SpeedUnit&gt; value = new DoubleScalar.Rel&lt;SpeedUnit&gt;(100.0, SpeedUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Speed value = new Speed(100.0, SpeedUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Speed extends AbstractDoubleScalarRel<SpeedUnit, Speed>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Speed ZERO = new Speed(0.0, SpeedUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Speed NaN = new Speed(Double.NaN, SpeedUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Speed POSITIVE_INFINITY = new Speed(Double.POSITIVE_INFINITY, SpeedUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Speed NEGATIVE_INFINITY = new Speed(Double.NEGATIVE_INFINITY, SpeedUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Speed POS_MAXVALUE = new Speed(Double.MAX_VALUE, SpeedUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Speed NEG_MAXVALUE = new Speed(-Double.MAX_VALUE, SpeedUnit.SI);

    /**
     * Construct Speed scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Speed(final double value, final SpeedUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Speed scalar.
     * @param value Scalar from which to construct this instance
     */
    public Speed(final Speed value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Speed instantiateRel(final double value, final SpeedUnit unit)
    {
        return new Speed(value, unit);
    }

    /**
     * Construct Speed scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Speed createSI(final double value)
    {
        return new Speed(value, SpeedUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Speed interpolate(final Speed zero, final Speed one, final double ratio)
    {
        return new Speed(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Speed max(final Speed r1, final Speed r2)
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
    public static Speed max(final Speed r1, final Speed r2, final Speed... rn)
    {
        Speed maxr = (r1.gt(r2)) ? r1 : r2;
        for (Speed r : rn)
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
    public static Speed min(final Speed r1, final Speed r2)
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
    public static Speed min(final Speed r1, final Speed r2, final Speed... rn)
    {
        Speed minr = (r1.lt(r2)) ? r1 : r2;
        for (Speed r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a Speed representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a Speed
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static Speed valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing Speed -- null or empty argument");
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
                        double d = Double.parseDouble(valueString);
                        return new Speed(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Speed from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Speed from " + text);
    }

    /**
     * Calculate the division of Speed and Speed, which results in a Dimensionless scalar.
     * @param v Speed scalar
     * @return Dimensionless scalar as a division of Speed and Speed
     */
    public final Dimensionless divideBy(final Speed v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Area, which results in a FlowVolume scalar.
     * @param v Speed scalar
     * @return FlowVolume scalar as a multiplication of Speed and Area
     */
    public final FlowVolume multiplyBy(final Area v)
    {
        return new FlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Force, which results in a Power scalar.
     * @param v Speed scalar
     * @return Power scalar as a multiplication of Speed and Force
     */
    public final Power multiplyBy(final Force v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Frequency, which results in a Acceleration scalar.
     * @param v Speed scalar
     * @return Acceleration scalar as a multiplication of Speed and Frequency
     */
    public final Acceleration multiplyBy(final Frequency v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Speed and Length, which results in a Frequency scalar.
     * @param v Speed scalar
     * @return Frequency scalar as a division of Speed and Length
     */
    public final Frequency divideBy(final Length v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of Speed and Frequency, which results in a Length scalar.
     * @param v Speed scalar
     * @return Length scalar as a division of Speed and Frequency
     */
    public final Length divideBy(final Frequency v)
    {
        return new Length(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and LinearDensity, which results in a Frequency scalar.
     * @param v Speed scalar
     * @return Frequency scalar as a multiplication of Speed and LinearDensity
     */
    public final Frequency multiplyBy(final LinearDensity v)
    {
        return new Frequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and Duration, which results in a Length scalar.
     * @param v Speed scalar
     * @return Length scalar as a multiplication of Speed and Duration
     */
    public final Length multiplyBy(final Duration v)
    {
        return new Length(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Speed and Duration, which results in a Acceleration scalar.
     * @param v Speed scalar
     * @return Acceleration scalar as a division of Speed and Duration
     */
    public final Acceleration divideBy(final Duration v)
    {
        return new Acceleration(this.si / v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Speed and Acceleration, which results in a Duration scalar.
     * @param v Speed scalar
     * @return Duration scalar as a division of Speed and Acceleration
     */
    public final Duration divideBy(final Acceleration v)
    {
        return new Duration(this.si / v.si, DurationUnit.SI);
    }

    /**
     * Calculate the multiplication of Speed and FlowMass, which results in a Force scalar.
     * @param v Speed scalar
     * @return Force scalar as a multiplication of Speed and FlowMass
     */
    public final Force multiplyBy(final FlowMass v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

}
