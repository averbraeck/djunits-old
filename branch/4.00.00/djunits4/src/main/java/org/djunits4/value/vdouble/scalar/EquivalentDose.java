package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.EquivalentDoseUnit;

/**
 * Easy access methods for the EquivalentDose DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;EquivalentDoseUnit&gt; value = new DoubleScalar.Rel&lt;EquivalentDoseUnit&gt;(100.0, EquivalentDoseUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * EquivalentDose value = new EquivalentDose(100.0, EquivalentDoseUnit.SI);
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
public class EquivalentDose extends AbstractDoubleScalarRel<EquivalentDoseUnit, EquivalentDose>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final EquivalentDose ZERO = new EquivalentDose(0.0, EquivalentDoseUnit.SI);

    /** constant with value one. */
    public static final EquivalentDose ONE = new EquivalentDose(1.0, EquivalentDoseUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final EquivalentDose NaN = new EquivalentDose(Double.NaN, EquivalentDoseUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final EquivalentDose POSITIVE_INFINITY = new EquivalentDose(Double.POSITIVE_INFINITY, EquivalentDoseUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final EquivalentDose NEGATIVE_INFINITY = new EquivalentDose(Double.NEGATIVE_INFINITY, EquivalentDoseUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final EquivalentDose POS_MAXVALUE = new EquivalentDose(Double.MAX_VALUE, EquivalentDoseUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final EquivalentDose NEG_MAXVALUE = new EquivalentDose(-Double.MAX_VALUE, EquivalentDoseUnit.SI);

    /**
     * Construct EquivalentDose scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public EquivalentDose(final double value, final EquivalentDoseUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct EquivalentDose scalar.
     * @param value Scalar from which to construct this instance
     */
    public EquivalentDose(final EquivalentDose value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final EquivalentDose instantiateRel(final double value, final EquivalentDoseUnit unit)
    {
        return new EquivalentDose(value, unit);
    }

    /**
     * Construct EquivalentDose scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final EquivalentDose createSI(final double value)
    {
        return new EquivalentDose(value, EquivalentDoseUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static EquivalentDose interpolate(final EquivalentDose zero, final EquivalentDose one, final double ratio)
    {
        return new EquivalentDose(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static EquivalentDose max(final EquivalentDose r1, final EquivalentDose r2)
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
    public static EquivalentDose max(final EquivalentDose r1, final EquivalentDose r2, final EquivalentDose... rn)
    {
        EquivalentDose maxr = (r1.gt(r2)) ? r1 : r2;
        for (EquivalentDose r : rn)
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
    public static EquivalentDose min(final EquivalentDose r1, final EquivalentDose r2)
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
    public static EquivalentDose min(final EquivalentDose r1, final EquivalentDose r2, final EquivalentDose... rn)
    {
        EquivalentDose minr = (r1.lt(r2)) ? r1 : r2;
        for (EquivalentDose r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a EquivalentDose representation of a textual representation of a value with a unit. The String representation
     * that can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are
     * allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a EquivalentDose
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static EquivalentDose valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing EquivalentDose -- null or empty argument");
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
                        double d = Double.parseDouble(valueString);
                        return new EquivalentDose(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing EquivalentDose from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing EquivalentDose from " + text);
    }

}
