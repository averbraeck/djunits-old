package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the AmountOfSubstance DoubleScalar, which is relative by definition. Instead of:
 * <pre>DoubleScalar.Rel&lt;AmountOfSubstanceUnit&gt; value = new DoubleScalar.Rel&lt;AmountOfSubstanceUnit&gt;(100.0,
 * AmountOfSubstanceUnit.SI);</pre>
 * we can now write:
 * <pre>AmountOfSubstance value = new AmountOfSubstance(100.0, AmountOfSubstanceUnit.SI);</pre>
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
public class AmountOfSubstance extends AbstractDoubleScalarRel<AmountOfSubstanceUnit, AmountOfSubstance> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final AmountOfSubstance ZERO = new AmountOfSubstance(0.0, AmountOfSubstanceUnit.SI);

    /** constant with value one. */
    public static final AmountOfSubstance ONE = new AmountOfSubstance(1.0, AmountOfSubstanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final AmountOfSubstance NaN = new AmountOfSubstance(Double.NaN, AmountOfSubstanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final AmountOfSubstance POSITIVE_INFINITY = new AmountOfSubstance(Double.POSITIVE_INFINITY, AmountOfSubstanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final AmountOfSubstance NEGATIVE_INFINITY = new AmountOfSubstance(Double.NEGATIVE_INFINITY, AmountOfSubstanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final AmountOfSubstance POS_MAXVALUE = new AmountOfSubstance(Double.MAX_VALUE, AmountOfSubstanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final AmountOfSubstance NEG_MAXVALUE = new AmountOfSubstance(-Double.MAX_VALUE, AmountOfSubstanceUnit.SI);

    /**
     * Construct AmountOfSubstance scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public AmountOfSubstance(final double value, final AmountOfSubstanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AmountOfSubstance scalar.
     * @param value Scalar from which to construct this instance
     */
    public AmountOfSubstance(final AmountOfSubstance value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final AmountOfSubstance instantiateRel(final double value, final AmountOfSubstanceUnit unit)
    {
        return new AmountOfSubstance(value, unit);
    }

    /**
     * Construct AmountOfSubstance scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final AmountOfSubstance createSI(final double value)
    {
        return new AmountOfSubstance(value, AmountOfSubstanceUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static AmountOfSubstance interpolate(final AmountOfSubstance zero, final AmountOfSubstance one, final double ratio)
    {
        return new AmountOfSubstance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static AmountOfSubstance max(final AmountOfSubstance r1, final AmountOfSubstance r2)
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
    public static AmountOfSubstance max(final AmountOfSubstance r1, final AmountOfSubstance r2, final AmountOfSubstance... rn)
    {
        AmountOfSubstance maxr = (r1.gt(r2)) ? r1 : r2;
        for (AmountOfSubstance r : rn)
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
    public static AmountOfSubstance min(final AmountOfSubstance r1, final AmountOfSubstance r2)
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
    public static AmountOfSubstance min(final AmountOfSubstance r1, final AmountOfSubstance r2, final AmountOfSubstance... rn)
    {
        AmountOfSubstance minr = (r1.lt(r2)) ? r1 : r2;
        for (AmountOfSubstance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a AmountOfSubstance representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a AmountOfSubstance
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static AmountOfSubstance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing AmountOfSubstance -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (AmountOfSubstanceUnit unit : AmountOfSubstanceUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new AmountOfSubstance(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing AmountOfSubstance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing AmountOfSubstance from " + text);
    }
    
    
}

