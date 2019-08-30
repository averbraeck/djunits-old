package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.MagneticFluxDensityUnit;

/**
 * Easy access methods for the MagneticFluxDensity FloatScalar, which is relative by definition. An example is Speed. Instead
 * of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MagneticFluxDensityUnit&gt; value =
 *         new FloatScalar.Rel&lt;MagneticFluxDensityUnit&gt;(100.0, MagneticFluxDensityUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMagneticFluxDensity value = new FloatMagneticFluxDensity(100.0, MagneticFluxDensityUnit.SI);
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
public class FloatMagneticFluxDensity extends AbstractFloatScalarRel<MagneticFluxDensityUnit, FloatMagneticFluxDensity>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatMagneticFluxDensity ZERO = new FloatMagneticFluxDensity(0.0f, MagneticFluxDensityUnit.SI);

    /** constant with value zero. */
    public static final FloatMagneticFluxDensity ONE = new FloatMagneticFluxDensity(1.0f, MagneticFluxDensityUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatMagneticFluxDensity NaN = new FloatMagneticFluxDensity(Float.NaN, MagneticFluxDensityUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatMagneticFluxDensity POSITIVE_INFINITY =
            new FloatMagneticFluxDensity(Float.POSITIVE_INFINITY, MagneticFluxDensityUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatMagneticFluxDensity NEGATIVE_INFINITY =
            new FloatMagneticFluxDensity(Float.NEGATIVE_INFINITY, MagneticFluxDensityUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatMagneticFluxDensity POS_MAXVALUE =
            new FloatMagneticFluxDensity(Float.MAX_VALUE, MagneticFluxDensityUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatMagneticFluxDensity NEG_MAXVALUE =
            new FloatMagneticFluxDensity(-Float.MAX_VALUE, MagneticFluxDensityUnit.SI);

    /**
     * Construct FloatMagneticFluxDensity scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatMagneticFluxDensity(final float value, final MagneticFluxDensityUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMagneticFluxDensity scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatMagneticFluxDensity(final FloatMagneticFluxDensity value)
    {
        super(value);
    }

    /**
     * Construct FloatMagneticFluxDensity scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatMagneticFluxDensity(final double value, final MagneticFluxDensityUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxDensity instantiateRel(final float value, final MagneticFluxDensityUnit unit)
    {
        return new FloatMagneticFluxDensity(value, unit);
    }

    /**
     * Construct FloatMagneticFluxDensity scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatMagneticFluxDensity createSI(final float value)
    {
        return new FloatMagneticFluxDensity(value, MagneticFluxDensityUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMagneticFluxDensity interpolate(final FloatMagneticFluxDensity zero, final FloatMagneticFluxDensity one,
            final float ratio)
    {
        return new FloatMagneticFluxDensity(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatMagneticFluxDensity max(final FloatMagneticFluxDensity r1, final FloatMagneticFluxDensity r2)
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
    public static FloatMagneticFluxDensity max(final FloatMagneticFluxDensity r1, final FloatMagneticFluxDensity r2,
            final FloatMagneticFluxDensity... rn)
    {
        FloatMagneticFluxDensity maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMagneticFluxDensity r : rn)
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
    public static FloatMagneticFluxDensity min(final FloatMagneticFluxDensity r1, final FloatMagneticFluxDensity r2)
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
    public static FloatMagneticFluxDensity min(final FloatMagneticFluxDensity r1, final FloatMagneticFluxDensity r2,
            final FloatMagneticFluxDensity... rn)
    {
        FloatMagneticFluxDensity minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMagneticFluxDensity r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatMagneticFluxDensity representation of a textual representation of a value with a unit. The String
     * representation that can be parsed is the double value in the unit, followed by the official abbreviation of the unit.
     * Spaces are allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatMagneticFluxDensity
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatMagneticFluxDensity valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatMagneticFluxDensity -- null or empty argument");
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
                        float f = Float.parseFloat(valueString);
                        return new FloatMagneticFluxDensity(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatMagneticFluxDensity from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatMagneticFluxDensity from " + text);
    }

}
