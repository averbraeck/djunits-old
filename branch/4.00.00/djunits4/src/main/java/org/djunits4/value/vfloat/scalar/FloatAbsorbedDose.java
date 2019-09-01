package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.AbsorbedDoseUnit;

/**
 * Easy access methods for the AbsorbedDose FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;AbsorbedDoseUnit&gt; value = new FloatScalar.Rel&lt;AbsorbedDoseUnit&gt;(100.0, AbsorbedDoseUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatAbsorbedDose value = new FloatAbsorbedDose(100.0, AbsorbedDoseUnit.SI);
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
public class FloatAbsorbedDose extends AbstractFloatScalarRel<AbsorbedDoseUnit, FloatAbsorbedDose>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatAbsorbedDose ZERO = new FloatAbsorbedDose(0.0f, AbsorbedDoseUnit.SI);

    /** constant with value zero. */
    public static final FloatAbsorbedDose ONE = new FloatAbsorbedDose(1.0f, AbsorbedDoseUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatAbsorbedDose NaN = new FloatAbsorbedDose(Float.NaN, AbsorbedDoseUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatAbsorbedDose POSITIVE_INFINITY =
            new FloatAbsorbedDose(Float.POSITIVE_INFINITY, AbsorbedDoseUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatAbsorbedDose NEGATIVE_INFINITY =
            new FloatAbsorbedDose(Float.NEGATIVE_INFINITY, AbsorbedDoseUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatAbsorbedDose POS_MAXVALUE = new FloatAbsorbedDose(Float.MAX_VALUE, AbsorbedDoseUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatAbsorbedDose NEG_MAXVALUE = new FloatAbsorbedDose(-Float.MAX_VALUE, AbsorbedDoseUnit.SI);

    /**
     * Construct FloatAbsorbedDose scalar.
     * @param value float; float value
     * @param unit AbsorbedDoseUnit; unit for the float value
     */
    public FloatAbsorbedDose(final float value, final AbsorbedDoseUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAbsorbedDose scalar.
     * @param value FloatAbsorbedDose; Scalar from which to construct this instance
     */
    public FloatAbsorbedDose(final FloatAbsorbedDose value)
    {
        super(value);
    }

    /**
     * Construct FloatAbsorbedDose scalar using a double value.
     * @param value double; double value
     * @param unit AbsorbedDoseUnit; unit for the resulting float value
     */
    public FloatAbsorbedDose(final double value, final AbsorbedDoseUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAbsorbedDose instantiateRel(final float value, final AbsorbedDoseUnit unit)
    {
        return new FloatAbsorbedDose(value, unit);
    }

    /**
     * Construct FloatAbsorbedDose scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatAbsorbedDose createSI(final float value)
    {
        return new FloatAbsorbedDose(value, AbsorbedDoseUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatAbsorbedDose; the low value
     * @param one FloatAbsorbedDose; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAbsorbedDose interpolate(final FloatAbsorbedDose zero, final FloatAbsorbedDose one, final float ratio)
    {
        return new FloatAbsorbedDose(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatAbsorbedDose; the first scalar
     * @param r2 FloatAbsorbedDose; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatAbsorbedDose max(final FloatAbsorbedDose r1, final FloatAbsorbedDose r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatAbsorbedDose; the first scalar
     * @param r2 FloatAbsorbedDose; the second scalar
     * @param rn FloatAbsorbedDose...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatAbsorbedDose max(final FloatAbsorbedDose r1, final FloatAbsorbedDose r2, final FloatAbsorbedDose... rn)
    {
        FloatAbsorbedDose maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatAbsorbedDose r : rn)
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
     * @param r1 FloatAbsorbedDose; the first scalar
     * @param r2 FloatAbsorbedDose; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatAbsorbedDose min(final FloatAbsorbedDose r1, final FloatAbsorbedDose r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatAbsorbedDose; the first scalar
     * @param r2 FloatAbsorbedDose; the second scalar
     * @param rn FloatAbsorbedDose...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatAbsorbedDose min(final FloatAbsorbedDose r1, final FloatAbsorbedDose r2, final FloatAbsorbedDose... rn)
    {
        FloatAbsorbedDose minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatAbsorbedDose r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatAbsorbedDose representation of a textual representation of a value with a unit. The String representation
     * that can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are
     * allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatAbsorbedDose
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatAbsorbedDose valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatAbsorbedDose -- null or empty argument");
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
                        float f = Float.parseFloat(valueString);
                        return new FloatAbsorbedDose(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatAbsorbedDose from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatAbsorbedDose from " + text);
    }

}
