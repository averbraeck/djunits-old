package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.AbsorbedDoseUnit;

/**
 * Easy access methods for the AbsorbedDose DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;AbsorbedDoseUnit&gt; value = new DoubleScalar.Rel&lt;AbsorbedDoseUnit&gt;(100.0, AbsorbedDoseUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * AbsorbedDose value = new AbsorbedDose(100.0, AbsorbedDoseUnit.SI);
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
public class AbsorbedDose extends AbstractDoubleScalarRel<AbsorbedDoseUnit, AbsorbedDose>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final AbsorbedDose ZERO = new AbsorbedDose(0.0, AbsorbedDoseUnit.SI);

    /** constant with value one. */
    public static final AbsorbedDose ONE = new AbsorbedDose(1.0, AbsorbedDoseUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final AbsorbedDose NaN = new AbsorbedDose(Double.NaN, AbsorbedDoseUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final AbsorbedDose POSITIVE_INFINITY = new AbsorbedDose(Double.POSITIVE_INFINITY, AbsorbedDoseUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final AbsorbedDose NEGATIVE_INFINITY = new AbsorbedDose(Double.NEGATIVE_INFINITY, AbsorbedDoseUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final AbsorbedDose POS_MAXVALUE = new AbsorbedDose(Double.MAX_VALUE, AbsorbedDoseUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final AbsorbedDose NEG_MAXVALUE = new AbsorbedDose(-Double.MAX_VALUE, AbsorbedDoseUnit.SI);

    /**
     * Construct AbsorbedDose scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public AbsorbedDose(final double value, final AbsorbedDoseUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AbsorbedDose scalar.
     * @param value Scalar from which to construct this instance
     */
    public AbsorbedDose(final AbsorbedDose value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final AbsorbedDose instantiateRel(final double value, final AbsorbedDoseUnit unit)
    {
        return new AbsorbedDose(value, unit);
    }

    /**
     * Construct AbsorbedDose scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final AbsorbedDose createSI(final double value)
    {
        return new AbsorbedDose(value, AbsorbedDoseUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static AbsorbedDose interpolate(final AbsorbedDose zero, final AbsorbedDose one, final double ratio)
    {
        return new AbsorbedDose(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static AbsorbedDose max(final AbsorbedDose r1, final AbsorbedDose r2)
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
    public static AbsorbedDose max(final AbsorbedDose r1, final AbsorbedDose r2, final AbsorbedDose... rn)
    {
        AbsorbedDose maxr = (r1.gt(r2)) ? r1 : r2;
        for (AbsorbedDose r : rn)
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
    public static AbsorbedDose min(final AbsorbedDose r1, final AbsorbedDose r2)
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
    public static AbsorbedDose min(final AbsorbedDose r1, final AbsorbedDose r2, final AbsorbedDose... rn)
    {
        AbsorbedDose minr = (r1.lt(r2)) ? r1 : r2;
        for (AbsorbedDose r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a AbsorbedDose representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a AbsorbedDose
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static AbsorbedDose valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing AbsorbedDose -- null or empty argument");
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
                        double d = Double.parseDouble(valueString);
                        return new AbsorbedDose(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing AbsorbedDose from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing AbsorbedDose from " + text);
    }

}
