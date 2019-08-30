package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.value.Relative;
import org.djunits4.unit.*;

/**
 * Easy access methods for the Energy FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * <pre>FloatScalar.Rel&lt;EnergyUnit&gt; value = new FloatScalar.Rel&lt;EnergyUnit&gt;(100.0, EnergyUnit.SI);</pre>
 * we can now write:
 * <pre>FloatEnergy value = new FloatEnergy(100.0, EnergyUnit.SI);</pre>
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
public class FloatEnergy extends AbstractFloatScalarRel<EnergyUnit, FloatEnergy> 
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatEnergy ZERO = new FloatEnergy(0.0f, EnergyUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatEnergy NaN = new FloatEnergy(Float.NaN, EnergyUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatEnergy POSITIVE_INFINITY = new FloatEnergy(Float.POSITIVE_INFINITY, EnergyUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatEnergy NEGATIVE_INFINITY = new FloatEnergy(Float.NEGATIVE_INFINITY, EnergyUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatEnergy POS_MAXVALUE = new FloatEnergy(Float.MAX_VALUE, EnergyUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatEnergy NEG_MAXVALUE = new FloatEnergy(-Float.MAX_VALUE, EnergyUnit.SI);

    /**
     * Construct FloatEnergy scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatEnergy(final float value, final EnergyUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatEnergy scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatEnergy(final FloatEnergy value)
    {
        super(value);
    }

    /**
     * Construct FloatEnergy scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatEnergy(final double value, final EnergyUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergy instantiateRel(final float value, final EnergyUnit unit)
    {
        return new FloatEnergy(value, unit);
    }

    /**
     * Construct FloatEnergy scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatEnergy createSI(final float value)
    {
        return new FloatEnergy(value, EnergyUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatEnergy interpolate(final FloatEnergy zero, final FloatEnergy one, final float ratio)
    {
        return new FloatEnergy(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatEnergy max(final FloatEnergy r1, final FloatEnergy r2)
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
    public static FloatEnergy max(final FloatEnergy r1, final FloatEnergy r2, final FloatEnergy... rn)
    {
        FloatEnergy maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatEnergy r : rn)
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
    public static FloatEnergy min(final FloatEnergy r1, final FloatEnergy r2)
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
    public static FloatEnergy min(final FloatEnergy r1, final FloatEnergy r2, final FloatEnergy... rn)
    {
        FloatEnergy minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatEnergy r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatEnergy representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatEnergy
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatEnergy valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatEnergy -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (EnergyUnit unit : EnergyUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatEnergy(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatEnergy from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatEnergy from " + text);
    }
        /**
         * Calculate the division of FloatEnergy and FloatEnergy, which results in a FloatDimensionless scalar.
         * @param v FloatEnergy scalar
         * @return FloatDimensionless scalar as a division of FloatEnergy and FloatEnergy
         */
        public final FloatDimensionless divideBy(final FloatEnergy v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of FloatEnergy and FloatForce, which results in a FloatLength scalar.
         * @param v FloatEnergy scalar
         * @return FloatLength scalar as a division of FloatEnergy and FloatForce
         */
        public final FloatLength divideBy(final FloatForce v)
        {
            return new FloatLength(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of FloatEnergy and FloatLength, which results in a FloatForce scalar.
         * @param v FloatEnergy scalar
         * @return FloatForce scalar as a division of FloatEnergy and FloatLength
         */
        public final FloatForce divideBy(final FloatLength v)
        {
            return new FloatForce(this.si / v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatEnergy and FloatLinearDensity, which results in a FloatForce scalar.
         * @param v FloatEnergy scalar
         * @return FloatForce scalar as a multiplication of FloatEnergy and FloatLinearDensity
         */
        public final FloatForce multiplyBy(final FloatLinearDensity v)
        {
            return new FloatForce(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the division of FloatEnergy and FloatDuration, which results in a FloatPower scalar.
         * @param v FloatEnergy scalar
         * @return FloatPower scalar as a division of FloatEnergy and FloatDuration
         */
        public final FloatPower divideBy(final FloatDuration v)
        {
            return new FloatPower(this.si / v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of FloatEnergy and FloatPower, which results in a FloatDuration scalar.
         * @param v FloatEnergy scalar
         * @return FloatDuration scalar as a division of FloatEnergy and FloatPower
         */
        public final FloatDuration divideBy(final FloatPower v)
        {
            return new FloatDuration(this.si / v.si, DurationUnit.SI);
        }

        /**
         * Calculate the division of FloatEnergy and FloatVolume, which results in a FloatPressure scalar.
         * @param v FloatEnergy scalar
         * @return FloatPressure scalar as a division of FloatEnergy and FloatVolume
         */
        public final FloatPressure divideBy(final FloatVolume v)
        {
            return new FloatPressure(this.si / v.si, PressureUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatEnergy and FloatFrequency, which results in a FloatPower scalar.
         * @param v FloatEnergy scalar
         * @return FloatPower scalar as a multiplication of FloatEnergy and FloatFrequency
         */
        public final FloatPower multiplyBy(final FloatFrequency v)
        {
            return new FloatPower(this.si * v.si, PowerUnit.SI);
        }


}

