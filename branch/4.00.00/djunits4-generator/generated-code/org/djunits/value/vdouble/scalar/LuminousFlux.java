package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the LuminousFlux DoubleScalar, which is relative by definition. Instead of:
 * <pre>DoubleScalar.Rel&lt;LuminousFluxUnit&gt; value = new DoubleScalar.Rel&lt;LuminousFluxUnit&gt;(100.0,
 * LuminousFluxUnit.SI);</pre>
 * we can now write:
 * <pre>LuminousFlux value = new LuminousFlux(100.0, LuminousFluxUnit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-03 00:54:10 +0100 (Sun, 03 Mar 2019) $, @version $Revision: 350 $, by $Author: averbraeck $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class LuminousFlux extends AbstractDoubleScalarRel<LuminousFluxUnit, LuminousFlux> 
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final LuminousFlux ZERO = new LuminousFlux(0.0, LuminousFluxUnit.SI);

    /** constant with value one. */
    public static final LuminousFlux ONE = new LuminousFlux(1.0, LuminousFluxUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final LuminousFlux NaN = new LuminousFlux(Double.NaN, LuminousFluxUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final LuminousFlux POSITIVE_INFINITY = new LuminousFlux(Double.POSITIVE_INFINITY, LuminousFluxUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final LuminousFlux NEGATIVE_INFINITY = new LuminousFlux(Double.NEGATIVE_INFINITY, LuminousFluxUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final LuminousFlux POS_MAXVALUE = new LuminousFlux(Double.MAX_VALUE, LuminousFluxUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final LuminousFlux NEG_MAXVALUE = new LuminousFlux(-Double.MAX_VALUE, LuminousFluxUnit.SI);

    /**
     * Construct LuminousFlux scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public LuminousFlux(final double value, final LuminousFluxUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct LuminousFlux scalar.
     * @param value Scalar from which to construct this instance
     */
    public LuminousFlux(final LuminousFlux value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final LuminousFlux instantiateRel(final double value, final LuminousFluxUnit unit)
    {
        return new LuminousFlux(value, unit);
    }

    /**
     * Construct LuminousFlux scalar.
     * @param value double value in SI units
     * @return the new scalar with the SI value
     */
    public static final LuminousFlux createSI(final double value)
    {
        return new LuminousFlux(value, LuminousFluxUnit.SI);
    }
    
    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static LuminousFlux interpolate(final LuminousFlux zero, final LuminousFlux one, final double ratio)
    {
        return new LuminousFlux(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static LuminousFlux max(final LuminousFlux r1, final LuminousFlux r2)
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
    public static LuminousFlux max(final LuminousFlux r1, final LuminousFlux r2, final LuminousFlux... rn)
    {
        LuminousFlux maxr = (r1.gt(r2)) ? r1 : r2;
        for (LuminousFlux r : rn)
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
    public static LuminousFlux min(final LuminousFlux r1, final LuminousFlux r2)
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
    public static LuminousFlux min(final LuminousFlux r1, final LuminousFlux r2, final LuminousFlux... rn)
    {
        LuminousFlux minr = (r1.lt(r2)) ? r1 : r2;
        for (LuminousFlux r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a LuminousFlux representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a LuminousFlux
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static LuminousFlux valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing LuminousFlux -- null or empty argument");
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
                        double d = Double.parseDouble(valueString);
                        return new LuminousFlux(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing LuminousFlux from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing LuminousFlux from " + text);
    }
    
    
}

