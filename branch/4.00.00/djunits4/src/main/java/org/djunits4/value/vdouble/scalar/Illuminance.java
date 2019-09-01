package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.unit.IlluminanceUnit;

/**
 * Easy access methods for the Illuminance DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Illuminance extends AbstractDoubleScalarRel<IlluminanceUnit, Illuminance>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Illuminance ZERO = new Illuminance(0.0, IlluminanceUnit.SI);

    /** constant with value one. */
    public static final Illuminance ONE = new Illuminance(1.0, IlluminanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Illuminance NaN = new Illuminance(Double.NaN, IlluminanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Illuminance POSITIVE_INFINITY = new Illuminance(Double.POSITIVE_INFINITY, IlluminanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Illuminance NEGATIVE_INFINITY = new Illuminance(Double.NEGATIVE_INFINITY, IlluminanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Illuminance POS_MAXVALUE = new Illuminance(Double.MAX_VALUE, IlluminanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Illuminance NEG_MAXVALUE = new Illuminance(-Double.MAX_VALUE, IlluminanceUnit.SI);

    /**
     * Construct Illuminance scalar.
     * @param value double; the double value
     * @param unit IlluminanceUnit; unit for the double value
     */
    public Illuminance(final double value, final IlluminanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Illuminance scalar.
     * @param value Illuminance; Scalar from which to construct this instance
     */
    public Illuminance(final Illuminance value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Illuminance instantiateRel(final double value, final IlluminanceUnit unit)
    {
        return new Illuminance(value, unit);
    }

    /**
     * Construct Illuminance scalar.
     * @param value double; the double value in SI units
     * @return Illuminance; the new scalar with the SI value
     */
    public static final Illuminance createSI(final double value)
    {
        return new Illuminance(value, IlluminanceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero Illuminance; the low value
     * @param one Illuminance; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return Illuminance; a Scalar at the ratio between
     */
    public static Illuminance interpolate(final Illuminance zero, final Illuminance one, final double ratio)
    {
        return new Illuminance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 Illuminance; the first scalar
     * @param r2 Illuminance; the second scalar
     * @return Illuminance; the maximum value of two relative scalars
     */
    public static Illuminance max(final Illuminance r1, final Illuminance r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 Illuminance; the first scalar
     * @param r2 Illuminance; the second scalar
     * @param rn Illuminance...; the other scalars
     * @return Illuminance; the maximum value of more than two relative scalars
     */
    public static Illuminance max(final Illuminance r1, final Illuminance r2, final Illuminance... rn)
    {
        Illuminance maxr = (r1.gt(r2)) ? r1 : r2;
        for (Illuminance r : rn)
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
     * @param r1 Illuminance; the first scalar
     * @param r2 Illuminance; the second scalar
     * @return Illuminance; the minimum value of two relative scalars
     */
    public static Illuminance min(final Illuminance r1, final Illuminance r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 Illuminance; the first scalar
     * @param r2 Illuminance; the second scalar
     * @param rn Illuminance...; the other scalars
     * @return Illuminance; the minimum value of more than two relative scalars
     */
    public static Illuminance min(final Illuminance r1, final Illuminance r2, final Illuminance... rn)
    {
        Illuminance minr = (r1.lt(r2)) ? r1 : r2;
        for (Illuminance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a Illuminance representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not required, between the value and the unit.
     * @param text String; the textual representation to parse into a Illuminance
     * @return Illuminance; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static Illuminance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing Illuminance -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (IlluminanceUnit unit : IlluminanceUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new Illuminance(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing Illuminance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing Illuminance from " + text);
    }

}
