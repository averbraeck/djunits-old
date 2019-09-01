package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.unit.*;

/**
 * Easy access methods for the ElectricalCharge DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class ElectricalCharge extends AbstractDoubleScalarRel<ElectricalChargeUnit, ElectricalCharge> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final ElectricalCharge ZERO = new ElectricalCharge(0.0, ElectricalChargeUnit.SI);

    /** constant with value one. */
    public static final ElectricalCharge ONE = new ElectricalCharge(1.0, ElectricalChargeUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final ElectricalCharge NaN = new ElectricalCharge(Double.NaN, ElectricalChargeUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final ElectricalCharge POSITIVE_INFINITY = new ElectricalCharge(Double.POSITIVE_INFINITY, ElectricalChargeUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final ElectricalCharge NEGATIVE_INFINITY = new ElectricalCharge(Double.NEGATIVE_INFINITY, ElectricalChargeUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final ElectricalCharge POS_MAXVALUE = new ElectricalCharge(Double.MAX_VALUE, ElectricalChargeUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final ElectricalCharge NEG_MAXVALUE = new ElectricalCharge(-Double.MAX_VALUE, ElectricalChargeUnit.SI);

    /**
     * Construct ElectricalCharge scalar.
     * @param value double; the double value
     * @param unit ElectricalChargeUnit; unit for the double value
     */
    public ElectricalCharge(final double value, final ElectricalChargeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalCharge scalar.
     * @param value ElectricalCharge; Scalar from which to construct this instance
     */
    public ElectricalCharge(final ElectricalCharge value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge instantiateRel(final double value, final ElectricalChargeUnit unit)
    {
        return new ElectricalCharge(value, unit);
    }

    /**
     * Construct ElectricalCharge scalar.
     * @param value double; the double value in SI units
     * @return ElectricalCharge; the new scalar with the SI value
     */
    public static final ElectricalCharge createSI(final double value)
    {
        return new ElectricalCharge(value, ElectricalChargeUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero ElectricalCharge; the low value
     * @param one ElectricalCharge; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return ElectricalCharge; a Scalar at the ratio between
     */
    public static ElectricalCharge interpolate(final ElectricalCharge zero, final ElectricalCharge one, final double ratio)
    {
        return new ElectricalCharge(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 ElectricalCharge; the first scalar
     * @param r2 ElectricalCharge; the second scalar
     * @return ElectricalCharge; the maximum value of two relative scalars
     */
    public static ElectricalCharge max(final ElectricalCharge r1, final ElectricalCharge r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 ElectricalCharge; the first scalar
     * @param r2 ElectricalCharge; the second scalar
     * @param rn ElectricalCharge...; the other scalars
     * @return ElectricalCharge; the maximum value of more than two relative scalars
     */
    public static ElectricalCharge max(final ElectricalCharge r1, final ElectricalCharge r2, final ElectricalCharge... rn)
    {
        ElectricalCharge maxr = (r1.gt(r2)) ? r1 : r2;
        for (ElectricalCharge r : rn)
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
     * @param r1 ElectricalCharge; the first scalar
     * @param r2 ElectricalCharge; the second scalar
     * @return ElectricalCharge; the minimum value of two relative scalars
     */
    public static ElectricalCharge min(final ElectricalCharge r1, final ElectricalCharge r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 ElectricalCharge; the first scalar
     * @param r2 ElectricalCharge; the second scalar
     * @param rn ElectricalCharge...; the other scalars
     * @return ElectricalCharge; the minimum value of more than two relative scalars
     */
    public static ElectricalCharge min(final ElectricalCharge r1, final ElectricalCharge r2, final ElectricalCharge... rn)
    {
        ElectricalCharge minr = (r1.lt(r2)) ? r1 : r2;
        for (ElectricalCharge r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a ElectricalCharge representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a ElectricalCharge
     * @return ElectricalCharge; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static ElectricalCharge valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing ElectricalCharge -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ElectricalChargeUnit unit : ElectricalChargeUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new ElectricalCharge(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing ElectricalCharge from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing ElectricalCharge from " + text);
    }
    
            /**
         * Calculate the division of ElectricalCharge and ElectricalCharge, which results in a Dimensionless scalar.
         * @param v ElectricalCharge scalar
         * @return Dimensionless scalar as a division of ElectricalCharge and ElectricalCharge
         */
        public final Dimensionless divideBy(final ElectricalCharge v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of ElectricalCharge and Duration, which results in a ElectricalCurrent scalar.
         * @param v ElectricalCharge scalar
         * @return ElectricalCurrent scalar as a division of ElectricalCharge and Duration
         */
        public final ElectricalCurrent divideBy(final Duration v)
        {
            return new ElectricalCurrent(this.si / v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Calculate the division of ElectricalCharge and ElectricalCurrent, which results in a Duration scalar.
         * @param v ElectricalCharge scalar
         * @return Duration scalar as a division of ElectricalCharge and ElectricalCurrent
         */
        public final Duration divideBy(final ElectricalCurrent v)
        {
            return new Duration(this.si / v.si, DurationUnit.SI);
        }


}

