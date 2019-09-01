package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.ElectricalInductanceUnit;

/**
 * Easy access methods for the ElectricalInductance DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class ElectricalInductance extends AbstractDoubleScalarRel<ElectricalInductanceUnit, ElectricalInductance>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final ElectricalInductance ZERO = new ElectricalInductance(0.0, ElectricalInductanceUnit.SI);

    /** constant with value one. */
    public static final ElectricalInductance ONE = new ElectricalInductance(1.0, ElectricalInductanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final ElectricalInductance NaN = new ElectricalInductance(Double.NaN, ElectricalInductanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final ElectricalInductance POSITIVE_INFINITY =
            new ElectricalInductance(Double.POSITIVE_INFINITY, ElectricalInductanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final ElectricalInductance NEGATIVE_INFINITY =
            new ElectricalInductance(Double.NEGATIVE_INFINITY, ElectricalInductanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final ElectricalInductance POS_MAXVALUE =
            new ElectricalInductance(Double.MAX_VALUE, ElectricalInductanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final ElectricalInductance NEG_MAXVALUE =
            new ElectricalInductance(-Double.MAX_VALUE, ElectricalInductanceUnit.SI);

    /**
     * Construct ElectricalInductance scalar.
     * @param value double; the double value
     * @param unit ElectricalInductanceUnit; unit for the double value
     */
    public ElectricalInductance(final double value, final ElectricalInductanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct ElectricalInductance scalar.
     * @param value ElectricalInductance; Scalar from which to construct this instance
     */
    public ElectricalInductance(final ElectricalInductance value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalInductance instantiateRel(final double value, final ElectricalInductanceUnit unit)
    {
        return new ElectricalInductance(value, unit);
    }

    /**
     * Construct ElectricalInductance scalar.
     * @param value double; the double value in SI units
     * @return ElectricalInductance; the new scalar with the SI value
     */
    public static final ElectricalInductance createSI(final double value)
    {
        return new ElectricalInductance(value, ElectricalInductanceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero ElectricalInductance; the low value
     * @param one ElectricalInductance; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return ElectricalInductance; a Scalar at the ratio between
     */
    public static ElectricalInductance interpolate(final ElectricalInductance zero, final ElectricalInductance one,
            final double ratio)
    {
        return new ElectricalInductance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 ElectricalInductance; the first scalar
     * @param r2 ElectricalInductance; the second scalar
     * @return ElectricalInductance; the maximum value of two relative scalars
     */
    public static ElectricalInductance max(final ElectricalInductance r1, final ElectricalInductance r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 ElectricalInductance; the first scalar
     * @param r2 ElectricalInductance; the second scalar
     * @param rn ElectricalInductance...; the other scalars
     * @return ElectricalInductance; the maximum value of more than two relative scalars
     */
    public static ElectricalInductance max(final ElectricalInductance r1, final ElectricalInductance r2,
            final ElectricalInductance... rn)
    {
        ElectricalInductance maxr = (r1.gt(r2)) ? r1 : r2;
        for (ElectricalInductance r : rn)
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
     * @param r1 ElectricalInductance; the first scalar
     * @param r2 ElectricalInductance; the second scalar
     * @return ElectricalInductance; the minimum value of two relative scalars
     */
    public static ElectricalInductance min(final ElectricalInductance r1, final ElectricalInductance r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 ElectricalInductance; the first scalar
     * @param r2 ElectricalInductance; the second scalar
     * @param rn ElectricalInductance...; the other scalars
     * @return ElectricalInductance; the minimum value of more than two relative scalars
     */
    public static ElectricalInductance min(final ElectricalInductance r1, final ElectricalInductance r2,
            final ElectricalInductance... rn)
    {
        ElectricalInductance minr = (r1.lt(r2)) ? r1 : r2;
        for (ElectricalInductance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a ElectricalInductance representation of a textual representation of a value with a unit. The String
     * representation that can be parsed is the double value in the unit, followed by the official abbreviation of the unit.
     * Spaces are allowed, but not required, between the value and the unit.
     * @param text String; the textual representation to parse into a ElectricalInductance
     * @return ElectricalInductance; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static ElectricalInductance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing ElectricalInductance -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ElectricalInductanceUnit unit : ElectricalInductanceUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new ElectricalInductance(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing ElectricalInductance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing ElectricalInductance from " + text);
    }

}
