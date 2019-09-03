package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.*;

/**
 * Easy access methods for the CatalyticActivity DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class CatalyticActivity extends AbstractDoubleScalarRel<CatalyticActivityUnit, CatalyticActivity> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final CatalyticActivity ZERO = new CatalyticActivity(0.0, CatalyticActivityUnit.SI);

    /** constant with value one. */
    public static final CatalyticActivity ONE = new CatalyticActivity(1.0, CatalyticActivityUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final CatalyticActivity NaN = new CatalyticActivity(Double.NaN, CatalyticActivityUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final CatalyticActivity POSITIVE_INFINITY = new CatalyticActivity(Double.POSITIVE_INFINITY, CatalyticActivityUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final CatalyticActivity NEGATIVE_INFINITY = new CatalyticActivity(Double.NEGATIVE_INFINITY, CatalyticActivityUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final CatalyticActivity POS_MAXVALUE = new CatalyticActivity(Double.MAX_VALUE, CatalyticActivityUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final CatalyticActivity NEG_MAXVALUE = new CatalyticActivity(-Double.MAX_VALUE, CatalyticActivityUnit.SI);

    /**
     * Construct CatalyticActivity scalar.
     * @param value double; the double value
     * @param unit CatalyticActivityUnit; unit for the double value
     */
    public CatalyticActivity(final double value, final CatalyticActivityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct CatalyticActivity scalar.
     * @param value CatalyticActivity; Scalar from which to construct this instance
     */
    public CatalyticActivity(final CatalyticActivity value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final CatalyticActivity instantiateRel(final double value, final CatalyticActivityUnit unit)
    {
        return new CatalyticActivity(value, unit);
    }

    /**
     * Construct CatalyticActivity scalar.
     * @param value double; the double value in SI units
     * @return CatalyticActivity; the new scalar with the SI value
     */
    public static final CatalyticActivity createSI(final double value)
    {
        return new CatalyticActivity(value, CatalyticActivityUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero CatalyticActivity; the low value
     * @param one CatalyticActivity; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return CatalyticActivity; a Scalar at the ratio between
     */
    public static CatalyticActivity interpolate(final CatalyticActivity zero, final CatalyticActivity one, final double ratio)
    {
        return new CatalyticActivity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 CatalyticActivity; the first scalar
     * @param r2 CatalyticActivity; the second scalar
     * @return CatalyticActivity; the maximum value of two relative scalars
     */
    public static CatalyticActivity max(final CatalyticActivity r1, final CatalyticActivity r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 CatalyticActivity; the first scalar
     * @param r2 CatalyticActivity; the second scalar
     * @param rn CatalyticActivity...; the other scalars
     * @return CatalyticActivity; the maximum value of more than two relative scalars
     */
    public static CatalyticActivity max(final CatalyticActivity r1, final CatalyticActivity r2, final CatalyticActivity... rn)
    {
        CatalyticActivity maxr = (r1.gt(r2)) ? r1 : r2;
        for (CatalyticActivity r : rn)
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
     * @param r1 CatalyticActivity; the first scalar
     * @param r2 CatalyticActivity; the second scalar
     * @return CatalyticActivity; the minimum value of two relative scalars
     */
    public static CatalyticActivity min(final CatalyticActivity r1, final CatalyticActivity r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 CatalyticActivity; the first scalar
     * @param r2 CatalyticActivity; the second scalar
     * @param rn CatalyticActivity...; the other scalars
     * @return CatalyticActivity; the minimum value of more than two relative scalars
     */
    public static CatalyticActivity min(final CatalyticActivity r1, final CatalyticActivity r2, final CatalyticActivity... rn)
    {
        CatalyticActivity minr = (r1.lt(r2)) ? r1 : r2;
        for (CatalyticActivity r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a CatalyticActivity representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a CatalyticActivity
     * @return CatalyticActivity; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static CatalyticActivity valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing CatalyticActivity: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing CatalyticActivity: empty unitString");
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                CatalyticActivityUnit unit = CatalyticActivityUnit.BASE.getUnitByAbbreviation(unitString);
                if (unit != null)
                {
                    {
                        double d = Double.parseDouble(valueString);
                        return new CatalyticActivity(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing CatalyticActivity from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing CatalyticActivity from " + text);
    }

    /**
     * Returns a CatalyticActivity based on a value and the textual representation of the unit.
     * @param value double; the value to use
     * @param unitString String; the textual representation of the unit
     * @return CatalyticActivity; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static CatalyticActivity of(final double value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing CatalyticActivity: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing CatalyticActivity: empty unitString");
        CatalyticActivityUnit unit = CatalyticActivityUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new CatalyticActivity(value, unit);
        }
        throw new IllegalArgumentException("Error parsing CatalyticActivity with unit " + unitString);
    }

    
}

