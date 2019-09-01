package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.value.Relative;
import org.djunits4.unit.*;

/**
 * Easy access methods for the EquivalentDose FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * <pre>FloatScalar.Rel&lt;EquivalentDoseUnit&gt; value = new FloatScalar.Rel&lt;EquivalentDoseUnit&gt;(100.0, EquivalentDoseUnit.SI);</pre>
 * we can now write:
 * <pre>FloatEquivalentDose value = new FloatEquivalentDose(100.0, EquivalentDoseUnit.SI);</pre>
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
public class FloatEquivalentDose extends AbstractFloatScalarRel<EquivalentDoseUnit, FloatEquivalentDose> 
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatEquivalentDose ZERO = new FloatEquivalentDose(0.0f, EquivalentDoseUnit.SI);

    /** constant with value zero. */
    public static final FloatEquivalentDose ONE = new FloatEquivalentDose(1.0f, EquivalentDoseUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatEquivalentDose NaN = new FloatEquivalentDose(Float.NaN, EquivalentDoseUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatEquivalentDose POSITIVE_INFINITY = new FloatEquivalentDose(Float.POSITIVE_INFINITY, EquivalentDoseUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatEquivalentDose NEGATIVE_INFINITY = new FloatEquivalentDose(Float.NEGATIVE_INFINITY, EquivalentDoseUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatEquivalentDose POS_MAXVALUE = new FloatEquivalentDose(Float.MAX_VALUE, EquivalentDoseUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatEquivalentDose NEG_MAXVALUE = new FloatEquivalentDose(-Float.MAX_VALUE, EquivalentDoseUnit.SI);

    /**
     * Construct FloatEquivalentDose scalar.
     * @param value float; the float value
     * @param unit unit for the float value
     */
    public FloatEquivalentDose(final float value, final EquivalentDoseUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatEquivalentDose scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatEquivalentDose(final FloatEquivalentDose value)
    {
        super(value);
    }

    /**
     * Construct FloatEquivalentDose scalar using a double value.
     * @param value double; the double value
     * @param unit unit for the resulting float value
     */
    public FloatEquivalentDose(final double value, final EquivalentDoseUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEquivalentDose instantiateRel(final float value, final EquivalentDoseUnit unit)
    {
        return new FloatEquivalentDose(value, unit);
    }

    /**
     * Construct FloatEquivalentDose scalar.
     * @param value float; the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatEquivalentDose createSI(final float value)
    {
        return new FloatEquivalentDose(value, EquivalentDoseUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatEquivalentDose interpolate(final FloatEquivalentDose zero, final FloatEquivalentDose one, final float ratio)
    {
        return new FloatEquivalentDose(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatEquivalentDose max(final FloatEquivalentDose r1, final FloatEquivalentDose r2)
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
    public static FloatEquivalentDose max(final FloatEquivalentDose r1, final FloatEquivalentDose r2, final FloatEquivalentDose... rn)
    {
        FloatEquivalentDose maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatEquivalentDose r : rn)
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
    public static FloatEquivalentDose min(final FloatEquivalentDose r1, final FloatEquivalentDose r2)
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
    public static FloatEquivalentDose min(final FloatEquivalentDose r1, final FloatEquivalentDose r2, final FloatEquivalentDose... rn)
    {
        FloatEquivalentDose minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatEquivalentDose r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatEquivalentDose representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatEquivalentDose
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatEquivalentDose valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatEquivalentDose -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (EquivalentDoseUnit unit : EquivalentDoseUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatEquivalentDose(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatEquivalentDose from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatEquivalentDose from " + text);
    }

}

