package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the Relative Duration DoubleScalar. Instead of:
 * <pre>DoubleScalar&lt;DurationUnit&gt; value = new DoubleScalar&lt;DurationUnit&gt;(100.0, DurationUnit.SI);</pre>
 * we can now write:
 * <pre>Duration value = new Duration(100.0, DurationUnit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
 * unit used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class Duration extends AbstractDoubleScalarRel<DurationUnit, Duration>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Duration ZERO = new Duration(0.0, DurationUnit.SI);

    /** constant with value zero. */
    public static final Duration ONE = new Duration(1.0, DurationUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Duration NaN = new Duration(Double.NaN, DurationUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Duration POSITIVE_INFINITY = new Duration(Double.POSITIVE_INFINITY, DurationUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Duration NEGATIVE_INFINITY = new Duration(Double.NEGATIVE_INFINITY, DurationUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Duration POS_MAXVALUE = new Duration(Double.MAX_VALUE, DurationUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Duration NEG_MAXVALUE = new Duration(-Double.MAX_VALUE, DurationUnit.SI);

    /**
     * Construct Duration scalar.
     * @param value double; the double value
     * @param unit unit for the double value
     */
    public Duration(final double value, final DurationUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Duration scalar.
     * @param value Scalar from which to construct this instance
     */
    public Duration(final Duration value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Duration instantiateRel(final double value, final DurationUnit unit)
    {
        return new Duration(value, unit);
    }

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the double value
     * @param unit the unit
     * @return A a new absolute instance of the DoubleScalar of the right type
     */
    public final Time instantiateAbs(final double value, final TimeUnit unit)
    {
        return new Time(value, unit);
    }

    /**
     * Construct Duration scalar.
     * @param value double; the double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Duration createSI(final double value)
    {
        return new Duration(value, DurationUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Duration interpolate(final Duration zero, final Duration one, final double ratio)
    {
        return new Duration(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }
    
    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Time plus(final Time v)
    {
        TimeUnit targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Duration max(final Duration r1, final Duration r2)
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
    public static Duration max(final Duration r1, final Duration r2, final Duration... rn)
    {
        Duration maxr = (r1.gt(r2)) ? r1 : r2;
        for (Duration r : rn)
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
    public static Duration min(final Duration r1, final Duration r2)
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
    public static Duration min(final Duration r1, final Duration r2, final Duration... rn)
    {
        Duration minr = (r1.lt(r2)) ? r1 : r2;
        for (Duration r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }
    
    /**
     * Returns a Duration representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a Duration
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static Duration valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing Duration -- null or empty argument");
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
                        double d = Double.parseDouble(valueString);
                        return new Duration(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Duration from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Duration from " + text);
    }

        /**
         * Calculate the division of Duration and Duration, which results in a Dimensionless scalar.
         * @param v Duration scalar
         * @return Dimensionless scalar as a division of Duration and Duration
         */
        public final Dimensionless divideBy(final Duration v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Duration and Frequency, which results in a Dimensionless scalar.
         * @param v Duration scalar
         * @return Dimensionless scalar as a multiplication of Duration and Frequency
         */
        public final Dimensionless multiplyBy(final Frequency v)
        {
            return new Dimensionless(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Duration and ElectricalCurrent, which results in a ElectricalCharge scalar.
         * @param v Duration scalar
         * @return ElectricalCharge scalar as a multiplication of Duration and ElectricalCurrent
         */
        public final ElectricalCharge multiplyBy(final ElectricalCurrent v)
        {
            return new ElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of Duration and FlowMass, which results in a Mass scalar.
         * @param v Duration scalar
         * @return Mass scalar as a multiplication of Duration and FlowMass
         */
        public final Mass multiplyBy(final FlowMass v)
        {
            return new Mass(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Duration and FlowVolume, which results in a Volume scalar.
         * @param v Duration scalar
         * @return Volume scalar as a multiplication of Duration and FlowVolume
         */
        public final Volume multiplyBy(final FlowVolume v)
        {
            return new Volume(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Duration and Acceleration, which results in a Speed scalar.
         * @param v Duration scalar
         * @return Speed scalar as a multiplication of Duration and Acceleration
         */
        public final Speed multiplyBy(final Acceleration v)
        {
            return new Speed(this.si * v.si, SpeedUnit.SI);
        }

        /**
         * Calculate the multiplication of Duration and Power, which results in a Energy scalar.
         * @param v Duration scalar
         * @return Energy scalar as a multiplication of Duration and Power
         */
        public final Energy multiplyBy(final Power v)
        {
            return new Energy(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the multiplication of Duration and Speed, which results in a Length scalar.
         * @param v Duration scalar
         * @return Length scalar as a multiplication of Duration and Speed
         */
        public final Length multiplyBy(final Speed v)
        {
            return new Length(this.si * v.si, LengthUnit.SI);
        }


    
}
