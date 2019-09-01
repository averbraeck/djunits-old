package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.unit.*;

/**
 * Easy access methods for the AbsorbedDose DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class AbsorbedDose extends AbstractDoubleScalarRel<AbsorbedDoseUnit, AbsorbedDose> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final AbsorbedDose ZERO = new AbsorbedDose(0.0, AbsorbedDoseUnit.SI);

    /** constant with value one. */
    public static final AbsorbedDose ONE = new AbsorbedDose(1.0, AbsorbedDoseUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final AbsorbedDose NaN = new AbsorbedDose(Double.NaN, AbsorbedDoseUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final AbsorbedDose POSITIVE_INFINITY = new AbsorbedDose(Double.POSITIVE_INFINITY, AbsorbedDoseUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final AbsorbedDose NEGATIVE_INFINITY = new AbsorbedDose(Double.NEGATIVE_INFINITY, AbsorbedDoseUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final AbsorbedDose POS_MAXVALUE = new AbsorbedDose(Double.MAX_VALUE, AbsorbedDoseUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final AbsorbedDose NEG_MAXVALUE = new AbsorbedDose(-Double.MAX_VALUE, AbsorbedDoseUnit.SI);

    /**
     * Construct AbsorbedDose scalar.
     * @param value double; the double value
     * @param unit AbsorbedDoseUnit; unit for the double value
     */
    public AbsorbedDose(final double value, final AbsorbedDoseUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AbsorbedDose scalar.
     * @param value AbsorbedDose; Scalar from which to construct this instance
     */
    public AbsorbedDose(final AbsorbedDose value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final AbsorbedDose instantiateRel(final double value, final AbsorbedDoseUnit unit)
    {
        return new AbsorbedDose(value, unit);
    }

    /**
     * Construct AbsorbedDose scalar.
     * @param value double; the double value in SI units
     * @return AbsorbedDose; the new scalar with the SI value
     */
    public static final AbsorbedDose createSI(final double value)
    {
        return new AbsorbedDose(value, AbsorbedDoseUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero AbsorbedDose; the low value
     * @param one AbsorbedDose; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return AbsorbedDose; a Scalar at the ratio between
     */
    public static AbsorbedDose interpolate(final AbsorbedDose zero, final AbsorbedDose one, final double ratio)
    {
        return new AbsorbedDose(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 AbsorbedDose; the first scalar
     * @param r2 AbsorbedDose; the second scalar
     * @return AbsorbedDose; the maximum value of two relative scalars
     */
    public static AbsorbedDose max(final AbsorbedDose r1, final AbsorbedDose r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 AbsorbedDose; the first scalar
     * @param r2 AbsorbedDose; the second scalar
     * @param rn AbsorbedDose...; the other scalars
     * @return AbsorbedDose; the maximum value of more than two relative scalars
     */
    public static AbsorbedDose max(final AbsorbedDose r1, final AbsorbedDose r2, final AbsorbedDose... rn)
    {
        AbsorbedDose maxr = (r1.gt(r2)) ? r1 : r2;
        for (AbsorbedDose r : rn)
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
     * @param r1 AbsorbedDose; the first scalar
     * @param r2 AbsorbedDose; the second scalar
     * @return AbsorbedDose; the minimum value of two relative scalars
     */
    public static AbsorbedDose min(final AbsorbedDose r1, final AbsorbedDose r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 AbsorbedDose; the first scalar
     * @param r2 AbsorbedDose; the second scalar
     * @param rn AbsorbedDose...; the other scalars
     * @return AbsorbedDose; the minimum value of more than two relative scalars
     */
    public static AbsorbedDose min(final AbsorbedDose r1, final AbsorbedDose r2, final AbsorbedDose... rn)
    {
        AbsorbedDose minr = (r1.lt(r2)) ? r1 : r2;
        for (AbsorbedDose r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a AbsorbedDose representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a AbsorbedDose
     * @return AbsorbedDose; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static AbsorbedDose valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing AbsorbedDose -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (AbsorbedDoseUnit unit : AbsorbedDoseUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new AbsorbedDose(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing AbsorbedDose from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing AbsorbedDose from " + text);
    }
    
    
}

