package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.unit.*;

/**
 * Easy access methods for the ElectricalCurrent DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class ElectricalCurrent extends AbstractDoubleScalarRel<ElectricalCurrentUnit, ElectricalCurrent> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final ElectricalCurrent ZERO = new ElectricalCurrent(0.0, ElectricalCurrentUnit.SI);

    /** constant with value one. */
    public static final ElectricalCurrent ONE = new ElectricalCurrent(1.0, ElectricalCurrentUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final ElectricalCurrent NaN = new ElectricalCurrent(Double.NaN, ElectricalCurrentUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final ElectricalCurrent POSITIVE_INFINITY = new ElectricalCurrent(Double.POSITIVE_INFINITY, ElectricalCurrentUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final ElectricalCurrent NEGATIVE_INFINITY = new ElectricalCurrent(Double.NEGATIVE_INFINITY, ElectricalCurrentUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final ElectricalCurrent POS_MAXVALUE = new ElectricalCurrent(Double.MAX_VALUE, ElectricalCurrentUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final ElectricalCurrent NEG_MAXVALUE = new ElectricalCurrent(-Double.MAX_VALUE, ElectricalCurrentUnit.SI);

    /**
     * Construct ElectricalCurrent scalar.
     * @param value double; the double value
     * @param unit ElectricalCurrentUnit; unit for the double value
     */
    public ElectricalCurrent(final double value, final ElectricalCurrentUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalCurrent scalar.
     * @param value ElectricalCurrent; Scalar from which to construct this instance
     */
    public ElectricalCurrent(final ElectricalCurrent value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent instantiateRel(final double value, final ElectricalCurrentUnit unit)
    {
        return new ElectricalCurrent(value, unit);
    }

    /**
     * Construct ElectricalCurrent scalar.
     * @param value double; the double value in SI units
     * @return ElectricalCurrent; the new scalar with the SI value
     */
    public static final ElectricalCurrent createSI(final double value)
    {
        return new ElectricalCurrent(value, ElectricalCurrentUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero ElectricalCurrent; the low value
     * @param one ElectricalCurrent; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return ElectricalCurrent; a Scalar at the ratio between
     */
    public static ElectricalCurrent interpolate(final ElectricalCurrent zero, final ElectricalCurrent one, final double ratio)
    {
        return new ElectricalCurrent(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 ElectricalCurrent; the first scalar
     * @param r2 ElectricalCurrent; the second scalar
     * @return ElectricalCurrent; the maximum value of two relative scalars
     */
    public static ElectricalCurrent max(final ElectricalCurrent r1, final ElectricalCurrent r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 ElectricalCurrent; the first scalar
     * @param r2 ElectricalCurrent; the second scalar
     * @param rn ElectricalCurrent...; the other scalars
     * @return ElectricalCurrent; the maximum value of more than two relative scalars
     */
    public static ElectricalCurrent max(final ElectricalCurrent r1, final ElectricalCurrent r2, final ElectricalCurrent... rn)
    {
        ElectricalCurrent maxr = (r1.gt(r2)) ? r1 : r2;
        for (ElectricalCurrent r : rn)
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
     * @param r1 ElectricalCurrent; the first scalar
     * @param r2 ElectricalCurrent; the second scalar
     * @return ElectricalCurrent; the minimum value of two relative scalars
     */
    public static ElectricalCurrent min(final ElectricalCurrent r1, final ElectricalCurrent r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 ElectricalCurrent; the first scalar
     * @param r2 ElectricalCurrent; the second scalar
     * @param rn ElectricalCurrent...; the other scalars
     * @return ElectricalCurrent; the minimum value of more than two relative scalars
     */
    public static ElectricalCurrent min(final ElectricalCurrent r1, final ElectricalCurrent r2, final ElectricalCurrent... rn)
    {
        ElectricalCurrent minr = (r1.lt(r2)) ? r1 : r2;
        for (ElectricalCurrent r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a ElectricalCurrent representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a ElectricalCurrent
     * @return ElectricalCurrent; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static ElectricalCurrent valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing ElectricalCurrent -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ElectricalCurrentUnit unit : ElectricalCurrentUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new ElectricalCurrent(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing ElectricalCurrent from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing ElectricalCurrent from " + text);
    }
    
            /**
         * Calculate the division of ElectricalCurrent and ElectricalCurrent, which results in a Dimensionless scalar.
         * @param v ElectricalCurrent scalar
         * @return Dimensionless scalar as a division of ElectricalCurrent and ElectricalCurrent
         */
        public final Dimensionless divideBy(final ElectricalCurrent v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalCurrent and ElectricalPotential, which results in a Power scalar.
         * @param v ElectricalCurrent scalar
         * @return Power scalar as a multiplication of ElectricalCurrent and ElectricalPotential
         */
        public final Power multiplyBy(final ElectricalPotential v)
        {
            return new Power(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalCurrent and Duration, which results in a ElectricalCharge scalar.
         * @param v ElectricalCurrent scalar
         * @return ElectricalCharge scalar as a multiplication of ElectricalCurrent and Duration
         */
        public final ElectricalCharge multiplyBy(final Duration v)
        {
            return new ElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalCurrent and ElectricalResistance, which results in a ElectricalPotential scalar.
         * @param v ElectricalCurrent scalar
         * @return ElectricalPotential scalar as a multiplication of ElectricalCurrent and ElectricalResistance
         */
        public final ElectricalPotential multiplyBy(final ElectricalResistance v)
        {
            return new ElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
        }


}

