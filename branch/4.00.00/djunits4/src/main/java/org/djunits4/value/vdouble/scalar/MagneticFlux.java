package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.MagneticFluxUnit;

/**
 * Easy access methods for the MagneticFlux DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MagneticFluxUnit&gt; value = new DoubleScalar.Rel&lt;MagneticFluxUnit&gt;(100.0, MagneticFluxUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * MagneticFlux value = new MagneticFlux(100.0, MagneticFluxUnit.SI);
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
public class MagneticFlux extends AbstractDoubleScalarRel<MagneticFluxUnit, MagneticFlux>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final MagneticFlux ZERO = new MagneticFlux(0.0, MagneticFluxUnit.SI);

    /** constant with value one. */
    public static final MagneticFlux ONE = new MagneticFlux(1.0, MagneticFluxUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final MagneticFlux NaN = new MagneticFlux(Double.NaN, MagneticFluxUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final MagneticFlux POSITIVE_INFINITY = new MagneticFlux(Double.POSITIVE_INFINITY, MagneticFluxUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final MagneticFlux NEGATIVE_INFINITY = new MagneticFlux(Double.NEGATIVE_INFINITY, MagneticFluxUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final MagneticFlux POS_MAXVALUE = new MagneticFlux(Double.MAX_VALUE, MagneticFluxUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final MagneticFlux NEG_MAXVALUE = new MagneticFlux(-Double.MAX_VALUE, MagneticFluxUnit.SI);

    /**
     * Construct MagneticFlux scalar.
     * @param value double; double value
     * @param unit MagneticFluxUnit; unit for the double value
     */
    public MagneticFlux(final double value, final MagneticFluxUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MagneticFlux scalar.
     * @param value MagneticFlux; Scalar from which to construct this instance
     */
    public MagneticFlux(final MagneticFlux value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final MagneticFlux instantiateRel(final double value, final MagneticFluxUnit unit)
    {
        return new MagneticFlux(value, unit);
    }

    /**
     * Construct MagneticFlux scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final MagneticFlux createSI(final double value)
    {
        return new MagneticFlux(value, MagneticFluxUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero MagneticFlux; the low value
     * @param one MagneticFlux; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MagneticFlux interpolate(final MagneticFlux zero, final MagneticFlux one, final double ratio)
    {
        return new MagneticFlux(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 MagneticFlux; the first scalar
     * @param r2 MagneticFlux; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static MagneticFlux max(final MagneticFlux r1, final MagneticFlux r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 MagneticFlux; the first scalar
     * @param r2 MagneticFlux; the second scalar
     * @param rn MagneticFlux...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static MagneticFlux max(final MagneticFlux r1, final MagneticFlux r2, final MagneticFlux... rn)
    {
        MagneticFlux maxr = (r1.gt(r2)) ? r1 : r2;
        for (MagneticFlux r : rn)
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
     * @param r1 MagneticFlux; the first scalar
     * @param r2 MagneticFlux; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static MagneticFlux min(final MagneticFlux r1, final MagneticFlux r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 MagneticFlux; the first scalar
     * @param r2 MagneticFlux; the second scalar
     * @param rn MagneticFlux...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static MagneticFlux min(final MagneticFlux r1, final MagneticFlux r2, final MagneticFlux... rn)
    {
        MagneticFlux minr = (r1.lt(r2)) ? r1 : r2;
        for (MagneticFlux r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a MagneticFlux representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a MagneticFlux
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static MagneticFlux valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing MagneticFlux -- null or empty argument");
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
                        double d = Double.parseDouble(valueString);
                        return new MagneticFlux(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing MagneticFlux from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing MagneticFlux from " + text);
    }

}
