package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.*;

/**
 * Easy access methods for the RadioActivity DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class RadioActivity extends AbstractDoubleScalarRel<RadioActivityUnit, RadioActivity> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final RadioActivity ZERO = new RadioActivity(0.0, RadioActivityUnit.SI);

    /** constant with value one. */
    public static final RadioActivity ONE = new RadioActivity(1.0, RadioActivityUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final RadioActivity NaN = new RadioActivity(Double.NaN, RadioActivityUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final RadioActivity POSITIVE_INFINITY = new RadioActivity(Double.POSITIVE_INFINITY, RadioActivityUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final RadioActivity NEGATIVE_INFINITY = new RadioActivity(Double.NEGATIVE_INFINITY, RadioActivityUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final RadioActivity POS_MAXVALUE = new RadioActivity(Double.MAX_VALUE, RadioActivityUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final RadioActivity NEG_MAXVALUE = new RadioActivity(-Double.MAX_VALUE, RadioActivityUnit.SI);

    /**
     * Construct RadioActivity scalar.
     * @param value double; the double value
     * @param unit RadioActivityUnit; unit for the double value
     */
    public RadioActivity(final double value, final RadioActivityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct RadioActivity scalar.
     * @param value RadioActivity; Scalar from which to construct this instance
     */
    public RadioActivity(final RadioActivity value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final RadioActivity instantiateRel(final double value, final RadioActivityUnit unit)
    {
        return new RadioActivity(value, unit);
    }

    /**
     * Construct RadioActivity scalar.
     * @param value double; the double value in SI units
     * @return RadioActivity; the new scalar with the SI value
     */
    public static final RadioActivity createSI(final double value)
    {
        return new RadioActivity(value, RadioActivityUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero RadioActivity; the low value
     * @param one RadioActivity; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return RadioActivity; a Scalar at the ratio between
     */
    public static RadioActivity interpolate(final RadioActivity zero, final RadioActivity one, final double ratio)
    {
        return new RadioActivity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 RadioActivity; the first scalar
     * @param r2 RadioActivity; the second scalar
     * @return RadioActivity; the maximum value of two relative scalars
     */
    public static RadioActivity max(final RadioActivity r1, final RadioActivity r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 RadioActivity; the first scalar
     * @param r2 RadioActivity; the second scalar
     * @param rn RadioActivity...; the other scalars
     * @return RadioActivity; the maximum value of more than two relative scalars
     */
    public static RadioActivity max(final RadioActivity r1, final RadioActivity r2, final RadioActivity... rn)
    {
        RadioActivity maxr = (r1.gt(r2)) ? r1 : r2;
        for (RadioActivity r : rn)
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
     * @param r1 RadioActivity; the first scalar
     * @param r2 RadioActivity; the second scalar
     * @return RadioActivity; the minimum value of two relative scalars
     */
    public static RadioActivity min(final RadioActivity r1, final RadioActivity r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 RadioActivity; the first scalar
     * @param r2 RadioActivity; the second scalar
     * @param rn RadioActivity...; the other scalars
     * @return RadioActivity; the minimum value of more than two relative scalars
     */
    public static RadioActivity min(final RadioActivity r1, final RadioActivity r2, final RadioActivity... rn)
    {
        RadioActivity minr = (r1.lt(r2)) ? r1 : r2;
        for (RadioActivity r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a RadioActivity representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a RadioActivity
     * @return RadioActivity; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static RadioActivity valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing RadioActivity: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing RadioActivity: empty unitString");
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                RadioActivityUnit unit = RadioActivityUnit.BASE.getUnitByAbbreviation(unitString);
                if (unit != null)
                {
                    {
                        double d = Double.parseDouble(valueString);
                        return new RadioActivity(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing RadioActivity from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing RadioActivity from " + text);
    }

    /**
     * Returns a RadioActivity based on a value and the textual representation of the unit.
     * @param value double; the value to use
     * @param unitString String; the textual representation of the unit
     * @return RadioActivity; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static RadioActivity of(final double value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing RadioActivity: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing RadioActivity: empty unitString");
        RadioActivityUnit unit = RadioActivityUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new RadioActivity(value, unit);
        }
        throw new IllegalArgumentException("Error parsing RadioActivity with unit " + unitString);
    }

    
}

