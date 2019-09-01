package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.CatalyticActivityUnit;

/**
 * Easy access methods for the CatalyticActivity FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;CatalyticActivityUnit&gt; value = new FloatScalar.Rel&lt;CatalyticActivityUnit&gt;(100.0, CatalyticActivityUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatCatalyticActivity value = new FloatCatalyticActivity(100.0, CatalyticActivityUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $,
 * initial version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatCatalyticActivity extends AbstractFloatScalarRel<CatalyticActivityUnit, FloatCatalyticActivity>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatCatalyticActivity ZERO = new FloatCatalyticActivity(0.0f, CatalyticActivityUnit.SI);

    /** constant with value zero. */
    public static final FloatCatalyticActivity ONE = new FloatCatalyticActivity(1.0f, CatalyticActivityUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatCatalyticActivity NaN = new FloatCatalyticActivity(Float.NaN, CatalyticActivityUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatCatalyticActivity POSITIVE_INFINITY =
            new FloatCatalyticActivity(Float.POSITIVE_INFINITY, CatalyticActivityUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatCatalyticActivity NEGATIVE_INFINITY =
            new FloatCatalyticActivity(Float.NEGATIVE_INFINITY, CatalyticActivityUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatCatalyticActivity POS_MAXVALUE =
            new FloatCatalyticActivity(Float.MAX_VALUE, CatalyticActivityUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatCatalyticActivity NEG_MAXVALUE =
            new FloatCatalyticActivity(-Float.MAX_VALUE, CatalyticActivityUnit.SI);

    /**
     * Construct FloatCatalyticActivity scalar.
     * @param value float; float value
     * @param unit CatalyticActivityUnit; unit for the float value
     */
    public FloatCatalyticActivity(final float value, final CatalyticActivityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatCatalyticActivity scalar.
     * @param value FloatCatalyticActivity; Scalar from which to construct this instance
     */
    public FloatCatalyticActivity(final FloatCatalyticActivity value)
    {
        super(value);
    }

    /**
     * Construct FloatCatalyticActivity scalar using a double value.
     * @param value double; double value
     * @param unit CatalyticActivityUnit; unit for the resulting float value
     */
    public FloatCatalyticActivity(final double value, final CatalyticActivityUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatCatalyticActivity instantiateRel(final float value, final CatalyticActivityUnit unit)
    {
        return new FloatCatalyticActivity(value, unit);
    }

    /**
     * Construct FloatCatalyticActivity scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatCatalyticActivity createSI(final float value)
    {
        return new FloatCatalyticActivity(value, CatalyticActivityUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatCatalyticActivity; the low value
     * @param one FloatCatalyticActivity; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatCatalyticActivity interpolate(final FloatCatalyticActivity zero, final FloatCatalyticActivity one,
            final float ratio)
    {
        return new FloatCatalyticActivity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatCatalyticActivity; the first scalar
     * @param r2 FloatCatalyticActivity; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatCatalyticActivity max(final FloatCatalyticActivity r1, final FloatCatalyticActivity r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatCatalyticActivity; the first scalar
     * @param r2 FloatCatalyticActivity; the second scalar
     * @param rn FloatCatalyticActivity...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatCatalyticActivity max(final FloatCatalyticActivity r1, final FloatCatalyticActivity r2,
            final FloatCatalyticActivity... rn)
    {
        FloatCatalyticActivity maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatCatalyticActivity r : rn)
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
     * @param r1 FloatCatalyticActivity; the first scalar
     * @param r2 FloatCatalyticActivity; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatCatalyticActivity min(final FloatCatalyticActivity r1, final FloatCatalyticActivity r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatCatalyticActivity; the first scalar
     * @param r2 FloatCatalyticActivity; the second scalar
     * @param rn FloatCatalyticActivity...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatCatalyticActivity min(final FloatCatalyticActivity r1, final FloatCatalyticActivity r2,
            final FloatCatalyticActivity... rn)
    {
        FloatCatalyticActivity minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatCatalyticActivity r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatCatalyticActivity representation of a textual representation of a value with a unit. The String
     * representation that can be parsed is the double value in the unit, followed by the official abbreviation of the unit.
     * Spaces are allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatCatalyticActivity
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatCatalyticActivity valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatCatalyticActivity -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (CatalyticActivityUnit unit : CatalyticActivityUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatCatalyticActivity(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatCatalyticActivity from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatCatalyticActivity from " + text);
    }

}
