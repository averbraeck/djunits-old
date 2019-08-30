package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the Acceleration DoubleScalar, which is relative by definition. Instead of:
 * <pre>DoubleScalar.Rel&lt;AccelerationUnit&gt; value = new DoubleScalar.Rel&lt;AccelerationUnit&gt;(100.0,
 * AccelerationUnit.SI);</pre>
 * we can now write:
 * <pre>Acceleration value = new Acceleration(100.0, AccelerationUnit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Acceleration extends AbstractDoubleScalarRel<AccelerationUnit, Acceleration> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Acceleration ZERO = new Acceleration(0.0, AccelerationUnit.SI);

    /** constant with value one. */
    public static final Acceleration ONE = new Acceleration(1.0, AccelerationUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Acceleration NaN = new Acceleration(Double.NaN, AccelerationUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Acceleration POSITIVE_INFINITY = new Acceleration(Double.POSITIVE_INFINITY, AccelerationUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Acceleration NEGATIVE_INFINITY = new Acceleration(Double.NEGATIVE_INFINITY, AccelerationUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Acceleration POS_MAXVALUE = new Acceleration(Double.MAX_VALUE, AccelerationUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Acceleration NEG_MAXVALUE = new Acceleration(-Double.MAX_VALUE, AccelerationUnit.SI);

    /**
     * Construct Acceleration scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Acceleration(final double value, final AccelerationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Acceleration scalar.
     * @param value Scalar from which to construct this instance
     */
    public Acceleration(final Acceleration value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Acceleration instantiateRel(final double value, final AccelerationUnit unit)
    {
        return new Acceleration(value, unit);
    }

    /**
     * Construct Acceleration scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Acceleration createSI(final double value)
    {
        return new Acceleration(value, AccelerationUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Acceleration interpolate(final Acceleration zero, final Acceleration one, final double ratio)
    {
        return new Acceleration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Acceleration max(final Acceleration r1, final Acceleration r2)
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
    public static Acceleration max(final Acceleration r1, final Acceleration r2, final Acceleration... rn)
    {
        Acceleration maxr = (r1.gt(r2)) ? r1 : r2;
        for (Acceleration r : rn)
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
    public static Acceleration min(final Acceleration r1, final Acceleration r2)
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
    public static Acceleration min(final Acceleration r1, final Acceleration r2, final Acceleration... rn)
    {
        Acceleration minr = (r1.lt(r2)) ? r1 : r2;
        for (Acceleration r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a Acceleration representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a Acceleration
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static Acceleration valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing Acceleration -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (AccelerationUnit unit : AccelerationUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new Acceleration(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Acceleration from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Acceleration from " + text);
    }
    
            /**
         * Calculate the division of Acceleration and Acceleration, which results in a Dimensionless scalar.
         * @param v Acceleration scalar
         * @return Dimensionless scalar as a division of Acceleration and Acceleration
         */
        public final Dimensionless divideBy(final Acceleration v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Acceleration and Mass, which results in a Force scalar.
         * @param v Acceleration scalar
         * @return Force scalar as a multiplication of Acceleration and Mass
         */
        public final Force multiplyBy(final Mass v)
        {
            return new Force(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Acceleration and Duration, which results in a Speed scalar.
         * @param v Acceleration scalar
         * @return Speed scalar as a multiplication of Acceleration and Duration
         */
        public final Speed multiplyBy(final Duration v)
        {
            return new Speed(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of Acceleration and Frequency, which results in a Speed scalar.
         * @param v Acceleration scalar
         * @return Speed scalar as a division of Acceleration and Frequency
         */
        public final Speed divideBy(final Frequency v)
        {
            return new Speed(this.si / v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the division of Acceleration and Speed, which results in a Frequency scalar.
         * @param v Acceleration scalar
         * @return Frequency scalar as a division of Acceleration and Speed
         */
        public final Frequency divideBy(final Speed v)
        {
            return new Frequency(this.si / v.si, FrequencyUnit.SI);
        }


}

