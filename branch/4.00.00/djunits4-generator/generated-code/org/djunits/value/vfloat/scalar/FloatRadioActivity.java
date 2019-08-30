package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.value.Relative;
import org.djunits4.unit.*;

/**
 * Easy access methods for the RadioActivity FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * <pre>FloatScalar.Rel&lt;RadioActivityUnit&gt; value = new FloatScalar.Rel&lt;RadioActivityUnit&gt;(100.0, RadioActivityUnit.SI);</pre>
 * we can now write:
 * <pre>FloatRadioActivity value = new FloatRadioActivity(100.0, RadioActivityUnit.SI);</pre>
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
public class FloatRadioActivity extends AbstractFloatScalarRel<RadioActivityUnit, FloatRadioActivity> 
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatRadioActivity ZERO = new FloatRadioActivity(0.0f, RadioActivityUnit.SI);

    /** constant with value zero. */
    public static final FloatRadioActivity ONE = new FloatRadioActivity(1.0f, RadioActivityUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatRadioActivity NaN = new FloatRadioActivity(Float.NaN, RadioActivityUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatRadioActivity POSITIVE_INFINITY = new FloatRadioActivity(Float.POSITIVE_INFINITY, RadioActivityUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatRadioActivity NEGATIVE_INFINITY = new FloatRadioActivity(Float.NEGATIVE_INFINITY, RadioActivityUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatRadioActivity POS_MAXVALUE = new FloatRadioActivity(Float.MAX_VALUE, RadioActivityUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatRadioActivity NEG_MAXVALUE = new FloatRadioActivity(-Float.MAX_VALUE, RadioActivityUnit.SI);

    /**
     * Construct FloatRadioActivity scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatRadioActivity(final float value, final RadioActivityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatRadioActivity scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatRadioActivity(final FloatRadioActivity value)
    {
        super(value);
    }

    /**
     * Construct FloatRadioActivity scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatRadioActivity(final double value, final RadioActivityUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatRadioActivity instantiateRel(final float value, final RadioActivityUnit unit)
    {
        return new FloatRadioActivity(value, unit);
    }

    /**
     * Construct FloatRadioActivity scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatRadioActivity createSI(final float value)
    {
        return new FloatRadioActivity(value, RadioActivityUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatRadioActivity interpolate(final FloatRadioActivity zero, final FloatRadioActivity one, final float ratio)
    {
        return new FloatRadioActivity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatRadioActivity max(final FloatRadioActivity r1, final FloatRadioActivity r2)
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
    public static FloatRadioActivity max(final FloatRadioActivity r1, final FloatRadioActivity r2, final FloatRadioActivity... rn)
    {
        FloatRadioActivity maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatRadioActivity r : rn)
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
    public static FloatRadioActivity min(final FloatRadioActivity r1, final FloatRadioActivity r2)
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
    public static FloatRadioActivity min(final FloatRadioActivity r1, final FloatRadioActivity r2, final FloatRadioActivity... rn)
    {
        FloatRadioActivity minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatRadioActivity r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatRadioActivity representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatRadioActivity
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatRadioActivity valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatRadioActivity -- null or empty argument");
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
                        float f = Float.parseFloat(valueString);
                        return new FloatRadioActivity(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatRadioActivity from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatRadioActivity from " + text);
    }

}

