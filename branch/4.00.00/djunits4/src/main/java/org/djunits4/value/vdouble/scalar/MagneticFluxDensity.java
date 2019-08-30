package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.MagneticFluxDensityUnit;

/**
 * Easy access methods for the MagneticFluxDensity DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MagneticFluxDensityUnit&gt; value =
 *         new DoubleScalar.Rel&lt;MagneticFluxDensityUnit&gt;(100.0, MagneticFluxDensityUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * MagneticFluxDensity value = new MagneticFluxDensity(100.0, MagneticFluxDensityUnit.SI);
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
public class MagneticFluxDensity extends AbstractDoubleScalarRel<MagneticFluxDensityUnit, MagneticFluxDensity>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final MagneticFluxDensity ZERO = new MagneticFluxDensity(0.0, MagneticFluxDensityUnit.SI);

    /** constant with value one. */
    public static final MagneticFluxDensity ONE = new MagneticFluxDensity(1.0, MagneticFluxDensityUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final MagneticFluxDensity NaN = new MagneticFluxDensity(Double.NaN, MagneticFluxDensityUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final MagneticFluxDensity POSITIVE_INFINITY =
            new MagneticFluxDensity(Double.POSITIVE_INFINITY, MagneticFluxDensityUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final MagneticFluxDensity NEGATIVE_INFINITY =
            new MagneticFluxDensity(Double.NEGATIVE_INFINITY, MagneticFluxDensityUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final MagneticFluxDensity POS_MAXVALUE =
            new MagneticFluxDensity(Double.MAX_VALUE, MagneticFluxDensityUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final MagneticFluxDensity NEG_MAXVALUE =
            new MagneticFluxDensity(-Double.MAX_VALUE, MagneticFluxDensityUnit.SI);

    /**
     * Construct MagneticFluxDensity scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MagneticFluxDensity(final double value, final MagneticFluxDensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MagneticFluxDensity scalar.
     * @param value Scalar from which to construct this instance
     */
    public MagneticFluxDensity(final MagneticFluxDensity value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final MagneticFluxDensity instantiateRel(final double value, final MagneticFluxDensityUnit unit)
    {
        return new MagneticFluxDensity(value, unit);
    }

    /**
     * Construct MagneticFluxDensity scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final MagneticFluxDensity createSI(final double value)
    {
        return new MagneticFluxDensity(value, MagneticFluxDensityUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MagneticFluxDensity interpolate(final MagneticFluxDensity zero, final MagneticFluxDensity one,
            final double ratio)
    {
        return new MagneticFluxDensity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static MagneticFluxDensity max(final MagneticFluxDensity r1, final MagneticFluxDensity r2)
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
    public static MagneticFluxDensity max(final MagneticFluxDensity r1, final MagneticFluxDensity r2,
            final MagneticFluxDensity... rn)
    {
        MagneticFluxDensity maxr = (r1.gt(r2)) ? r1 : r2;
        for (MagneticFluxDensity r : rn)
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
    public static MagneticFluxDensity min(final MagneticFluxDensity r1, final MagneticFluxDensity r2)
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
    public static MagneticFluxDensity min(final MagneticFluxDensity r1, final MagneticFluxDensity r2,
            final MagneticFluxDensity... rn)
    {
        MagneticFluxDensity minr = (r1.lt(r2)) ? r1 : r2;
        for (MagneticFluxDensity r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a MagneticFluxDensity representation of a textual representation of a value with a unit. The String
     * representation that can be parsed is the double value in the unit, followed by the official abbreviation of the unit.
     * Spaces are allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a MagneticFluxDensity
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static MagneticFluxDensity valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing MagneticFluxDensity -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (MagneticFluxDensityUnit unit : MagneticFluxDensityUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        double d = Double.parseDouble(valueString);
                        return new MagneticFluxDensity(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing MagneticFluxDensity from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing MagneticFluxDensity from " + text);
    }

}
