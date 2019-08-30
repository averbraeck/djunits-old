package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.value.Relative;
import org.djunits4.unit.*;

/**
 * Easy access methods for the Frequency FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * <pre>FloatScalar.Rel&lt;FrequencyUnit&gt; value = new FloatScalar.Rel&lt;FrequencyUnit&gt;(100.0, FrequencyUnit.SI);</pre>
 * we can now write:
 * <pre>FloatFrequency value = new FloatFrequency(100.0, FrequencyUnit.SI);</pre>
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
public class FloatFrequency extends AbstractFloatScalarRel<FrequencyUnit, FloatFrequency> 
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatFrequency ZERO = new FloatFrequency(0.0f, FrequencyUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatFrequency NaN = new FloatFrequency(Float.NaN, FrequencyUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatFrequency POSITIVE_INFINITY = new FloatFrequency(Float.POSITIVE_INFINITY, FrequencyUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatFrequency NEGATIVE_INFINITY = new FloatFrequency(Float.NEGATIVE_INFINITY, FrequencyUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatFrequency POS_MAXVALUE = new FloatFrequency(Float.MAX_VALUE, FrequencyUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatFrequency NEG_MAXVALUE = new FloatFrequency(-Float.MAX_VALUE, FrequencyUnit.SI);

    /**
     * Construct FloatFrequency scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatFrequency(final float value, final FrequencyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatFrequency scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatFrequency(final FloatFrequency value)
    {
        super(value);
    }

    /**
     * Construct FloatFrequency scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatFrequency(final double value, final FrequencyUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFrequency instantiateRel(final float value, final FrequencyUnit unit)
    {
        return new FloatFrequency(value, unit);
    }

    /**
     * Construct FloatFrequency scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatFrequency createSI(final float value)
    {
        return new FloatFrequency(value, FrequencyUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatFrequency interpolate(final FloatFrequency zero, final FloatFrequency one, final float ratio)
    {
        return new FloatFrequency(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatFrequency max(final FloatFrequency r1, final FloatFrequency r2)
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
    public static FloatFrequency max(final FloatFrequency r1, final FloatFrequency r2, final FloatFrequency... rn)
    {
        FloatFrequency maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatFrequency r : rn)
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
    public static FloatFrequency min(final FloatFrequency r1, final FloatFrequency r2)
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
    public static FloatFrequency min(final FloatFrequency r1, final FloatFrequency r2, final FloatFrequency... rn)
    {
        FloatFrequency minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatFrequency r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatFrequency representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatFrequency
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatFrequency valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatFrequency -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (FrequencyUnit unit : FrequencyUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatFrequency(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatFrequency from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatFrequency from " + text);
    }
        /**
         * Calculate the division of FloatFrequency and FloatFrequency, which results in a FloatDimensionless scalar.
         * @param v FloatFrequency scalar
         * @return FloatDimensionless scalar as a division of FloatFrequency and FloatFrequency
         */
        public final FloatDimensionless divideBy(final FloatFrequency v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFrequency and FloatDuration, which results in a FloatDimensionless scalar.
         * @param v FloatFrequency scalar
         * @return FloatDimensionless scalar as a multiplication of FloatFrequency and FloatDuration
         */
        public final FloatDimensionless multiplyBy(final FloatDuration v)
        {
            return new FloatDimensionless(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFrequency and FloatLength, which results in a FloatSpeed scalar.
         * @param v FloatFrequency scalar
         * @return FloatSpeed scalar as a multiplication of FloatFrequency and FloatLength
         */
        public final FloatSpeed multiplyBy(final FloatLength v)
        {
            return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFrequency and FloatSpeed, which results in a FloatAcceleration scalar.
         * @param v FloatFrequency scalar
         * @return FloatAcceleration scalar as a multiplication of FloatFrequency and FloatSpeed
         */
        public final FloatAcceleration multiplyBy(final FloatSpeed v)
        {
            return new FloatAcceleration(this.si * v.si, AccelerationUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatFrequency and FloatEnergy, which results in a FloatPower scalar.
         * @param v FloatFrequency scalar
         * @return FloatPower scalar as a multiplication of FloatFrequency and FloatEnergy
         */
        public final FloatPower multiplyBy(final FloatEnergy v)
        {
            return new FloatPower(this.si * v.si, PowerUnit.SI);
        }


}

