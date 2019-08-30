package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.value.Relative;
import org.djunits4.unit.*;

/**
 * Easy access methods for the LinearDensity FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * <pre>FloatScalar.Rel&lt;LinearDensityUnit&gt; value = new FloatScalar.Rel&lt;LinearDensityUnit&gt;(100.0, LinearDensityUnit.SI);</pre>
 * we can now write:
 * <pre>FloatLinearDensity value = new FloatLinearDensity(100.0, LinearDensityUnit.SI);</pre>
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
public class FloatLinearDensity extends AbstractFloatScalarRel<LinearDensityUnit, FloatLinearDensity> 
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatLinearDensity ZERO = new FloatLinearDensity(0.0f, LinearDensityUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatLinearDensity NaN = new FloatLinearDensity(Float.NaN, LinearDensityUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatLinearDensity POSITIVE_INFINITY = new FloatLinearDensity(Float.POSITIVE_INFINITY, LinearDensityUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatLinearDensity NEGATIVE_INFINITY = new FloatLinearDensity(Float.NEGATIVE_INFINITY, LinearDensityUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatLinearDensity POS_MAXVALUE = new FloatLinearDensity(Float.MAX_VALUE, LinearDensityUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatLinearDensity NEG_MAXVALUE = new FloatLinearDensity(-Float.MAX_VALUE, LinearDensityUnit.SI);

    /**
     * Construct FloatLinearDensity scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatLinearDensity(final float value, final LinearDensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatLinearDensity scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatLinearDensity(final FloatLinearDensity value)
    {
        super(value);
    }

    /**
     * Construct FloatLinearDensity scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatLinearDensity(final double value, final LinearDensityUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity instantiateRel(final float value, final LinearDensityUnit unit)
    {
        return new FloatLinearDensity(value, unit);
    }

    /**
     * Construct FloatLinearDensity scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatLinearDensity createSI(final float value)
    {
        return new FloatLinearDensity(value, LinearDensityUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatLinearDensity interpolate(final FloatLinearDensity zero, final FloatLinearDensity one, final float ratio)
    {
        return new FloatLinearDensity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatLinearDensity max(final FloatLinearDensity r1, final FloatLinearDensity r2)
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
    public static FloatLinearDensity max(final FloatLinearDensity r1, final FloatLinearDensity r2, final FloatLinearDensity... rn)
    {
        FloatLinearDensity maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatLinearDensity r : rn)
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
    public static FloatLinearDensity min(final FloatLinearDensity r1, final FloatLinearDensity r2)
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
    public static FloatLinearDensity min(final FloatLinearDensity r1, final FloatLinearDensity r2, final FloatLinearDensity... rn)
    {
        FloatLinearDensity minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatLinearDensity r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatLinearDensity representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatLinearDensity
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatLinearDensity valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatLinearDensity -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (LinearDensityUnit unit : LinearDensityUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatLinearDensity(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatLinearDensity from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatLinearDensity from " + text);
    }
        /**
         * Calculate the division of FloatLinearDensity and FloatLinearDensity, which results in a FloatDimensionless scalar.
         * @param v FloatLinearDensity scalar
         * @return FloatDimensionless scalar as a division of FloatLinearDensity and FloatLinearDensity
         */
        public final FloatDimensionless divideBy(final FloatLinearDensity v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLinearDensity and FloatArea, which results in a FloatLength scalar.
         * @param v FloatLinearDensity scalar
         * @return FloatLength scalar as a multiplication of FloatLinearDensity and FloatArea
         */
        public final FloatLength multiplyBy(final FloatArea v)
        {
            return new FloatLength(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLinearDensity and FloatEnergy, which results in a FloatForce scalar.
         * @param v FloatLinearDensity scalar
         * @return FloatForce scalar as a multiplication of FloatLinearDensity and FloatEnergy
         */
        public final FloatForce multiplyBy(final FloatEnergy v)
        {
            return new FloatForce(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatLinearDensity and FloatSpeed, which results in a FloatFrequency scalar.
         * @param v FloatLinearDensity scalar
         * @return FloatFrequency scalar as a multiplication of FloatLinearDensity and FloatSpeed
         */
        public final FloatFrequency multiplyBy(final FloatSpeed v)
        {
            return new FloatFrequency(this.si * v.si, FrequencyUnit.SI);
        }


}

