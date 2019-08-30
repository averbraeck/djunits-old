package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.value.Relative;
import org.djunits4.unit.*;

/**
 * Easy access methods for the LuminousFlux FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * <pre>FloatScalar.Rel&lt;LuminousFluxUnit&gt; value = new FloatScalar.Rel&lt;LuminousFluxUnit&gt;(100.0, LuminousFluxUnit.SI);</pre>
 * we can now write:
 * <pre>FloatLuminousFlux value = new FloatLuminousFlux(100.0, LuminousFluxUnit.SI);</pre>
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
public class FloatLuminousFlux extends AbstractFloatScalarRel<LuminousFluxUnit, FloatLuminousFlux> 
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatLuminousFlux ZERO = new FloatLuminousFlux(0.0f, LuminousFluxUnit.SI);

    /** constant with value zero. */
    public static final FloatLuminousFlux ONE = new FloatLuminousFlux(1.0f, LuminousFluxUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatLuminousFlux NaN = new FloatLuminousFlux(Float.NaN, LuminousFluxUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatLuminousFlux POSITIVE_INFINITY = new FloatLuminousFlux(Float.POSITIVE_INFINITY, LuminousFluxUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatLuminousFlux NEGATIVE_INFINITY = new FloatLuminousFlux(Float.NEGATIVE_INFINITY, LuminousFluxUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatLuminousFlux POS_MAXVALUE = new FloatLuminousFlux(Float.MAX_VALUE, LuminousFluxUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatLuminousFlux NEG_MAXVALUE = new FloatLuminousFlux(-Float.MAX_VALUE, LuminousFluxUnit.SI);

    /**
     * Construct FloatLuminousFlux scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatLuminousFlux(final float value, final LuminousFluxUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatLuminousFlux scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatLuminousFlux(final FloatLuminousFlux value)
    {
        super(value);
    }

    /**
     * Construct FloatLuminousFlux scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatLuminousFlux(final double value, final LuminousFluxUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLuminousFlux instantiateRel(final float value, final LuminousFluxUnit unit)
    {
        return new FloatLuminousFlux(value, unit);
    }

    /**
     * Construct FloatLuminousFlux scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatLuminousFlux createSI(final float value)
    {
        return new FloatLuminousFlux(value, LuminousFluxUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatLuminousFlux interpolate(final FloatLuminousFlux zero, final FloatLuminousFlux one, final float ratio)
    {
        return new FloatLuminousFlux(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatLuminousFlux max(final FloatLuminousFlux r1, final FloatLuminousFlux r2)
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
    public static FloatLuminousFlux max(final FloatLuminousFlux r1, final FloatLuminousFlux r2, final FloatLuminousFlux... rn)
    {
        FloatLuminousFlux maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatLuminousFlux r : rn)
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
    public static FloatLuminousFlux min(final FloatLuminousFlux r1, final FloatLuminousFlux r2)
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
    public static FloatLuminousFlux min(final FloatLuminousFlux r1, final FloatLuminousFlux r2, final FloatLuminousFlux... rn)
    {
        FloatLuminousFlux minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatLuminousFlux r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatLuminousFlux representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatLuminousFlux
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatLuminousFlux valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatLuminousFlux -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (LuminousFluxUnit unit : LuminousFluxUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatLuminousFlux(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatLuminousFlux from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatLuminousFlux from " + text);
    }

}

