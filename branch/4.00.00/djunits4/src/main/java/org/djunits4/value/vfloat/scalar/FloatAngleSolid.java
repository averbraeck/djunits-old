package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.AngleSolidUnit;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRel;

/**
 * Easy access methods for the FloatAngleSolid FloatScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatAngleSolid extends AbstractFloatScalarRel<AngleSolidUnit, FloatAngleSolid>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** Constant with value zero. */
    public static final FloatAngleSolid ZERO = new FloatAngleSolid(0.0f, AngleSolidUnit.SI);

    /** Constant with value one. */
    public static final FloatAngleSolid ONE = new FloatAngleSolid(1.0f, AngleSolidUnit.SI);

    /** Constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatAngleSolid NaN = new FloatAngleSolid(Float.NaN, AngleSolidUnit.SI);

    /** Constant with value POSITIVE_INFINITY. */
    public static final FloatAngleSolid POSITIVE_INFINITY = new FloatAngleSolid(Float.POSITIVE_INFINITY, AngleSolidUnit.SI);

    /** Constant with value NEGATIVE_INFINITY. */
    public static final FloatAngleSolid NEGATIVE_INFINITY = new FloatAngleSolid(Float.NEGATIVE_INFINITY, AngleSolidUnit.SI);

    /** Constant with value MAX_VALUE. */
    public static final FloatAngleSolid POS_MAXVALUE = new FloatAngleSolid(Float.MAX_VALUE, AngleSolidUnit.SI);

    /** Constant with value -MAX_VALUE. */
    public static final FloatAngleSolid NEG_MAXVALUE = new FloatAngleSolid(-Float.MAX_VALUE, AngleSolidUnit.SI);

    /**
     * Construct FloatAngleSolid scalar.
     * @param value float; the float value
     * @param unit unit for the float value
     */
    public FloatAngleSolid(final float value, final AngleSolidUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAngleSolid scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatAngleSolid(final FloatAngleSolid value)
    {
        super(value);
    }

    /**
     * Construct FloatAngleSolid scalar using a double value.
     * @param value double; the double value
     * @param unit unit for the resulting float value
     */
    public FloatAngleSolid(final double value, final AngleSolidUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolid instantiateRel(final float value, final AngleSolidUnit unit)
    {
        return new FloatAngleSolid(value, unit);
    }

    /**
     * Construct FloatAngleSolid scalar.
     * @param value float; the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatAngleSolid createSI(final float value)
    {
        return new FloatAngleSolid(value, AngleSolidUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAngleSolid interpolate(final FloatAngleSolid zero, final FloatAngleSolid one, final float ratio)
    {
        return new FloatAngleSolid(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio,
                zero.getDisplayUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatAngleSolid max(final FloatAngleSolid r1, final FloatAngleSolid r2)
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
    public static FloatAngleSolid max(final FloatAngleSolid r1, final FloatAngleSolid r2, final FloatAngleSolid... rn)
    {
        FloatAngleSolid maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatAngleSolid r : rn)
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
    public static FloatAngleSolid min(final FloatAngleSolid r1, final FloatAngleSolid r2)
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
    public static FloatAngleSolid min(final FloatAngleSolid r1, final FloatAngleSolid r2, final FloatAngleSolid... rn)
    {
        FloatAngleSolid minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatAngleSolid r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatAngleSolid representation of a textual representation of a value with a unit. The String representation
     * that can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are
     * allowed, but not required, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatAngleSolid
     * @return FloatAngleSolid; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static FloatAngleSolid valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing FloatAngleSolid: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing FloatAngleSolid: empty unitString");
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
                        float f = Float.parseFloat(valueString);
                        return new FloatAngleSolid(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatAngleSolid from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatAngleSolid from " + text);
    }

    /**
     * Returns a FloatAngleSolid based on a value and the textual representation of the unit.
     * @param value double; the value to use
     * @param unitString String; the textual representation of the unit
     * @return FloatAngleSolid; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatAngleSolid of(final float value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing FloatAngleSolid: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing FloatAngleSolid: empty unitString");
        AngleSolidUnit unit = AngleSolidUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new FloatAngleSolid(value, unit);
        }
        throw new IllegalArgumentException("Error parsing FloatAngleSolid with unit " + unitString);
    }

    /**
     * Calculate the division of FloatAngleSolid and FloatAngleSolid, which results in a FloatDimensionless scalar.
     * @param v FloatAngleSolid scalar
     * @return FloatDimensionless scalar as a division of FloatAngleSolid and FloatAngleSolid
     */
    public final FloatDimensionless divideBy(final FloatAngleSolid v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

}
