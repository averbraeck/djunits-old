package org.djunits4.value.vdouble.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.AngleSolidUnit;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;

/**
 * Easy access methods for the AngleSolid DoubleScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T00:59:39.126Z")
public class AngleSolid extends AbstractDoubleScalarRel<AngleSolidUnit, AngleSolid>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** Constant with value zero. */
    public static final AngleSolid ZERO = new AngleSolid(0.0, AngleSolidUnit.SI);

    /** Constant with value one. */
    public static final AngleSolid ONE = new AngleSolid(1.0, AngleSolidUnit.SI);

    /** Constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final AngleSolid NaN = new AngleSolid(Double.NaN, AngleSolidUnit.SI);

    /** Constant with value POSITIVE_INFINITY. */
    public static final AngleSolid POSITIVE_INFINITY = new AngleSolid(Double.POSITIVE_INFINITY, AngleSolidUnit.SI);

    /** Constant with value NEGATIVE_INFINITY. */
    public static final AngleSolid NEGATIVE_INFINITY = new AngleSolid(Double.NEGATIVE_INFINITY, AngleSolidUnit.SI);

    /** Constant with value MAX_VALUE. */
    public static final AngleSolid POS_MAXVALUE = new AngleSolid(Double.MAX_VALUE, AngleSolidUnit.SI);

    /** Constant with value -MAX_VALUE. */
    public static final AngleSolid NEG_MAXVALUE = new AngleSolid(-Double.MAX_VALUE, AngleSolidUnit.SI);

    /**
     * Construct AngleSolid scalar.
     * @param value double; the double value
     * @param unit AngleSolidUnit; unit for the double value
     */
    public AngleSolid(final double value, final AngleSolidUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct AngleSolid scalar.
     * @param value AngleSolid; Scalar from which to construct this instance
     */
    public AngleSolid(final AngleSolid value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolid instantiateRel(final double value, final AngleSolidUnit unit)
    {
        return new AngleSolid(value, unit);
    }

    /**
     * Construct AngleSolid scalar.
     * @param value double; the double value in SI units
     * @return AngleSolid; the new scalar with the SI value
     */
    public static final AngleSolid instantiateSI(final double value)
    {
        return new AngleSolid(value, AngleSolidUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero AngleSolid; the low value
     * @param one AngleSolid; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return AngleSolid; a Scalar at the ratio between
     */
    public static AngleSolid interpolate(final AngleSolid zero, final AngleSolid one, final double ratio)
    {
        return new AngleSolid(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio,
                zero.getDisplayUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 AngleSolid; the first scalar
     * @param r2 AngleSolid; the second scalar
     * @return AngleSolid; the maximum value of two relative scalars
     */
    public static AngleSolid max(final AngleSolid r1, final AngleSolid r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 AngleSolid; the first scalar
     * @param r2 AngleSolid; the second scalar
     * @param rn AngleSolid...; the other scalars
     * @return AngleSolid; the maximum value of more than two relative scalars
     */
    public static AngleSolid max(final AngleSolid r1, final AngleSolid r2, final AngleSolid... rn)
    {
        AngleSolid maxr = (r1.gt(r2)) ? r1 : r2;
        for (AngleSolid r : rn)
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
     * @param r1 AngleSolid; the first scalar
     * @param r2 AngleSolid; the second scalar
     * @return AngleSolid; the minimum value of two relative scalars
     */
    public static AngleSolid min(final AngleSolid r1, final AngleSolid r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 AngleSolid; the first scalar
     * @param r2 AngleSolid; the second scalar
     * @param rn AngleSolid...; the other scalars
     * @return AngleSolid; the minimum value of more than two relative scalars
     */
    public static AngleSolid min(final AngleSolid r1, final AngleSolid r2, final AngleSolid... rn)
    {
        AngleSolid minr = (r1.lt(r2)) ? r1 : r2;
        for (AngleSolid r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a AngleSolid representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not required, between the value and the unit.
     * @param text String; the textual representation to parse into a AngleSolid
     * @return AngleSolid; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static AngleSolid valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing AngleSolid: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing AngleSolid: empty unitString");
        Matcher matcher = ValueUtil.NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                AngleSolidUnit unit = AngleSolidUnit.BASE.getUnitByAbbreviation(unitString);
                if (unit != null)
                {
                    {
                        double d = Double.parseDouble(valueString);
                        return new AngleSolid(d, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing AngleSolid from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing AngleSolid from " + text);
    }

    /**
     * Returns a AngleSolid based on a value and the textual representation of the unit.
     * @param value double; the value to use
     * @param unitString String; the textual representation of the unit
     * @return AngleSolid; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static AngleSolid of(final double value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing AngleSolid: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing AngleSolid: empty unitString");
        AngleSolidUnit unit = AngleSolidUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new AngleSolid(value, unit);
        }
        throw new IllegalArgumentException("Error parsing AngleSolid with unit " + unitString);
    }

    /**
     * Calculate the division of AngleSolid and AngleSolid, which results in a Dimensionless scalar.
     * @param v AngleSolid scalar
     * @return Dimensionless scalar as a division of AngleSolid and AngleSolid
     */
    public final Dimensionless divideBy(final AngleSolid v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of AngleSolid and LuminousIntensity, which results in a LuminousFlux scalar.
     * @param v AngleSolid scalar
     * @return LuminousFlux scalar as a multiplication of AngleSolid and LuminousIntensity
     */
    public final LuminousFlux multiplyBy(final LuminousIntensity v)
    {
        return new LuminousFlux(this.si * v.si, LuminousFluxUnit.SI);
    }

}
