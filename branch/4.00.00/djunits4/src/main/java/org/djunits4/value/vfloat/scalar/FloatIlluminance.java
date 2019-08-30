package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.IlluminanceUnit;

/**
 * Easy access methods for the Illuminance FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;IlluminanceUnit&gt; value = new FloatScalar.Rel&lt;IlluminanceUnit&gt;(100.0, IlluminanceUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatIlluminance value = new FloatIlluminance(100.0, IlluminanceUnit.SI);
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
public class FloatIlluminance extends AbstractFloatScalarRel<IlluminanceUnit, FloatIlluminance>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatIlluminance ZERO = new FloatIlluminance(0.0f, IlluminanceUnit.SI);

    /** constant with value zero. */
    public static final FloatIlluminance ONE = new FloatIlluminance(1.0f, IlluminanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatIlluminance NaN = new FloatIlluminance(Float.NaN, IlluminanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatIlluminance POSITIVE_INFINITY = new FloatIlluminance(Float.POSITIVE_INFINITY, IlluminanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatIlluminance NEGATIVE_INFINITY = new FloatIlluminance(Float.NEGATIVE_INFINITY, IlluminanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatIlluminance POS_MAXVALUE = new FloatIlluminance(Float.MAX_VALUE, IlluminanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatIlluminance NEG_MAXVALUE = new FloatIlluminance(-Float.MAX_VALUE, IlluminanceUnit.SI);

    /**
     * Construct FloatIlluminance scalar.
     * @param value float; float value
     * @param unit IlluminanceUnit; unit for the float value
     */
    public FloatIlluminance(final float value, final IlluminanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatIlluminance scalar.
     * @param value FloatIlluminance; Scalar from which to construct this instance
     */
    public FloatIlluminance(final FloatIlluminance value)
    {
        super(value);
    }

    /**
     * Construct FloatIlluminance scalar using a double value.
     * @param value double; double value
     * @param unit IlluminanceUnit; unit for the resulting float value
     */
    public FloatIlluminance(final double value, final IlluminanceUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatIlluminance instantiateRel(final float value, final IlluminanceUnit unit)
    {
        return new FloatIlluminance(value, unit);
    }

    /**
     * Construct FloatIlluminance scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatIlluminance createSI(final float value)
    {
        return new FloatIlluminance(value, IlluminanceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatIlluminance; the low value
     * @param one FloatIlluminance; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatIlluminance interpolate(final FloatIlluminance zero, final FloatIlluminance one, final float ratio)
    {
        return new FloatIlluminance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatIlluminance; the first scalar
     * @param r2 FloatIlluminance; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatIlluminance max(final FloatIlluminance r1, final FloatIlluminance r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatIlluminance; the first scalar
     * @param r2 FloatIlluminance; the second scalar
     * @param rn FloatIlluminance...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatIlluminance max(final FloatIlluminance r1, final FloatIlluminance r2, final FloatIlluminance... rn)
    {
        FloatIlluminance maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatIlluminance r : rn)
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
     * @param r1 FloatIlluminance; the first scalar
     * @param r2 FloatIlluminance; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatIlluminance min(final FloatIlluminance r1, final FloatIlluminance r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatIlluminance; the first scalar
     * @param r2 FloatIlluminance; the second scalar
     * @param rn FloatIlluminance...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatIlluminance min(final FloatIlluminance r1, final FloatIlluminance r2, final FloatIlluminance... rn)
    {
        FloatIlluminance minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatIlluminance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatIlluminance representation of a textual representation of a value with a unit. The String representation
     * that can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are
     * allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatIlluminance
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatIlluminance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatIlluminance -- null or empty argument");
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
                        float f = Float.parseFloat(valueString);
                        return new FloatIlluminance(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatIlluminance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatIlluminance from " + text);
    }

}
