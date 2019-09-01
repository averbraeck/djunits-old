package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.AmountOfSubstanceUnit;

/**
 * Easy access methods for the AmountOfSubstance FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;AmountOfSubstanceUnit&gt; value = new FloatScalar.Rel&lt;AmountOfSubstanceUnit&gt;(100.0, AmountOfSubstanceUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatAmountOfSubstance value = new FloatAmountOfSubstance(100.0, AmountOfSubstanceUnit.SI);
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
public class FloatAmountOfSubstance extends AbstractFloatScalarRel<AmountOfSubstanceUnit, FloatAmountOfSubstance>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatAmountOfSubstance ZERO = new FloatAmountOfSubstance(0.0f, AmountOfSubstanceUnit.SI);

    /** constant with value zero. */
    public static final FloatAmountOfSubstance ONE = new FloatAmountOfSubstance(1.0f, AmountOfSubstanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatAmountOfSubstance NaN = new FloatAmountOfSubstance(Float.NaN, AmountOfSubstanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatAmountOfSubstance POSITIVE_INFINITY =
            new FloatAmountOfSubstance(Float.POSITIVE_INFINITY, AmountOfSubstanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatAmountOfSubstance NEGATIVE_INFINITY =
            new FloatAmountOfSubstance(Float.NEGATIVE_INFINITY, AmountOfSubstanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatAmountOfSubstance POS_MAXVALUE =
            new FloatAmountOfSubstance(Float.MAX_VALUE, AmountOfSubstanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatAmountOfSubstance NEG_MAXVALUE =
            new FloatAmountOfSubstance(-Float.MAX_VALUE, AmountOfSubstanceUnit.SI);

    /**
     * Construct FloatAmountOfSubstance scalar.
     * @param value float; float value
     * @param unit AmountOfSubstanceUnit; unit for the float value
     */
    public FloatAmountOfSubstance(final float value, final AmountOfSubstanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAmountOfSubstance scalar.
     * @param value FloatAmountOfSubstance; Scalar from which to construct this instance
     */
    public FloatAmountOfSubstance(final FloatAmountOfSubstance value)
    {
        super(value);
    }

    /**
     * Construct FloatAmountOfSubstance scalar using a double value.
     * @param value double; double value
     * @param unit AmountOfSubstanceUnit; unit for the resulting float value
     */
    public FloatAmountOfSubstance(final double value, final AmountOfSubstanceUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAmountOfSubstance instantiateRel(final float value, final AmountOfSubstanceUnit unit)
    {
        return new FloatAmountOfSubstance(value, unit);
    }

    /**
     * Construct FloatAmountOfSubstance scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatAmountOfSubstance createSI(final float value)
    {
        return new FloatAmountOfSubstance(value, AmountOfSubstanceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatAmountOfSubstance; the low value
     * @param one FloatAmountOfSubstance; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAmountOfSubstance interpolate(final FloatAmountOfSubstance zero, final FloatAmountOfSubstance one,
            final float ratio)
    {
        return new FloatAmountOfSubstance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatAmountOfSubstance; the first scalar
     * @param r2 FloatAmountOfSubstance; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatAmountOfSubstance max(final FloatAmountOfSubstance r1, final FloatAmountOfSubstance r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatAmountOfSubstance; the first scalar
     * @param r2 FloatAmountOfSubstance; the second scalar
     * @param rn FloatAmountOfSubstance...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatAmountOfSubstance max(final FloatAmountOfSubstance r1, final FloatAmountOfSubstance r2,
            final FloatAmountOfSubstance... rn)
    {
        FloatAmountOfSubstance maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatAmountOfSubstance r : rn)
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
     * @param r1 FloatAmountOfSubstance; the first scalar
     * @param r2 FloatAmountOfSubstance; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatAmountOfSubstance min(final FloatAmountOfSubstance r1, final FloatAmountOfSubstance r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatAmountOfSubstance; the first scalar
     * @param r2 FloatAmountOfSubstance; the second scalar
     * @param rn FloatAmountOfSubstance...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatAmountOfSubstance min(final FloatAmountOfSubstance r1, final FloatAmountOfSubstance r2,
            final FloatAmountOfSubstance... rn)
    {
        FloatAmountOfSubstance minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatAmountOfSubstance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatAmountOfSubstance representation of a textual representation of a value with a unit. The String
     * representation that can be parsed is the double value in the unit, followed by the official abbreviation of the unit.
     * Spaces are allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatAmountOfSubstance
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatAmountOfSubstance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatAmountOfSubstance -- null or empty argument");
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
                        float f = Float.parseFloat(valueString);
                        return new FloatAmountOfSubstance(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatAmountOfSubstance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatAmountOfSubstance from " + text);
    }

}
