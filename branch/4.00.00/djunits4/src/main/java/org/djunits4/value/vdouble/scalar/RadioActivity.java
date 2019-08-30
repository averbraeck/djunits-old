package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.RadioActivityUnit;

/**
 * Easy access methods for the RadioActivity DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;RadioActivityUnit&gt; value = new DoubleScalar.Rel&lt;RadioActivityUnit&gt;(100.0, RadioActivityUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * RadioActivity value = new RadioActivity(100.0, RadioActivityUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
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
     * @param value double; double value
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
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
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
     * @return a Scalar at the ratio between
     */
    public static RadioActivity interpolate(final RadioActivity zero, final RadioActivity one, final double ratio)
    {
        return new RadioActivity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 RadioActivity; the first scalar
     * @param r2 RadioActivity; the second scalar
     * @return the maximum value of two relative scalars
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
     * @return the maximum value of more than two relative scalars
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
     * @return the minimum value of two relative scalars
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
     * @return the minimum value of more than two relative scalars
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
     * Returns a RadioActivity representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a RadioActivity
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static RadioActivity valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing RadioActivity -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (RadioActivityUnit unit : RadioActivityUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
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

}
