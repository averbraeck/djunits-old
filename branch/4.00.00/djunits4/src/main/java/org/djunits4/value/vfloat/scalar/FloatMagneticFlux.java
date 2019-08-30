package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.MagneticFluxUnit;

/**
 * Easy access methods for the MagneticFlux FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;MagneticFluxUnit&gt; value = new FloatScalar.Rel&lt;MagneticFluxUnit&gt;(100.0, MagneticFluxUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatMagneticFlux value = new FloatMagneticFlux(100.0, MagneticFluxUnit.SI);
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
public class FloatMagneticFlux extends AbstractFloatScalarRel<MagneticFluxUnit, FloatMagneticFlux>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatMagneticFlux ZERO = new FloatMagneticFlux(0.0f, MagneticFluxUnit.SI);

    /** constant with value zero. */
    public static final FloatMagneticFlux ONE = new FloatMagneticFlux(1.0f, MagneticFluxUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatMagneticFlux NaN = new FloatMagneticFlux(Float.NaN, MagneticFluxUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatMagneticFlux POSITIVE_INFINITY =
            new FloatMagneticFlux(Float.POSITIVE_INFINITY, MagneticFluxUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatMagneticFlux NEGATIVE_INFINITY =
            new FloatMagneticFlux(Float.NEGATIVE_INFINITY, MagneticFluxUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatMagneticFlux POS_MAXVALUE = new FloatMagneticFlux(Float.MAX_VALUE, MagneticFluxUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatMagneticFlux NEG_MAXVALUE = new FloatMagneticFlux(-Float.MAX_VALUE, MagneticFluxUnit.SI);

    /**
     * Construct FloatMagneticFlux scalar.
     * @param value float; float value
     * @param unit MagneticFluxUnit; unit for the float value
     */
    public FloatMagneticFlux(final float value, final MagneticFluxUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatMagneticFlux scalar.
     * @param value FloatMagneticFlux; Scalar from which to construct this instance
     */
    public FloatMagneticFlux(final FloatMagneticFlux value)
    {
        super(value);
    }

    /**
     * Construct FloatMagneticFlux scalar using a double value.
     * @param value double; double value
     * @param unit MagneticFluxUnit; unit for the resulting float value
     */
    public FloatMagneticFlux(final double value, final MagneticFluxUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFlux instantiateRel(final float value, final MagneticFluxUnit unit)
    {
        return new FloatMagneticFlux(value, unit);
    }

    /**
     * Construct FloatMagneticFlux scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatMagneticFlux createSI(final float value)
    {
        return new FloatMagneticFlux(value, MagneticFluxUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatMagneticFlux; the low value
     * @param one FloatMagneticFlux; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatMagneticFlux interpolate(final FloatMagneticFlux zero, final FloatMagneticFlux one, final float ratio)
    {
        return new FloatMagneticFlux(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatMagneticFlux; the first scalar
     * @param r2 FloatMagneticFlux; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatMagneticFlux max(final FloatMagneticFlux r1, final FloatMagneticFlux r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatMagneticFlux; the first scalar
     * @param r2 FloatMagneticFlux; the second scalar
     * @param rn FloatMagneticFlux...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatMagneticFlux max(final FloatMagneticFlux r1, final FloatMagneticFlux r2, final FloatMagneticFlux... rn)
    {
        FloatMagneticFlux maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatMagneticFlux r : rn)
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
     * @param r1 FloatMagneticFlux; the first scalar
     * @param r2 FloatMagneticFlux; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatMagneticFlux min(final FloatMagneticFlux r1, final FloatMagneticFlux r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatMagneticFlux; the first scalar
     * @param r2 FloatMagneticFlux; the second scalar
     * @param rn FloatMagneticFlux...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatMagneticFlux min(final FloatMagneticFlux r1, final FloatMagneticFlux r2, final FloatMagneticFlux... rn)
    {
        FloatMagneticFlux minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatMagneticFlux r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatMagneticFlux representation of a textual representation of a value with a unit. The String representation
     * that can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are
     * allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatMagneticFlux
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatMagneticFlux valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatMagneticFlux -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (MagneticFluxUnit unit : MagneticFluxUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatMagneticFlux(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatMagneticFlux from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatMagneticFlux from " + text);
    }

}
