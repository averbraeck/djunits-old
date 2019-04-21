package org.djunits.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.Unit;

/**
 * Easy access methods for the AngleSolid FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;AngleSolidUnit&gt; value = new FloatScalar.Rel&lt;AngleSolidUnit&gt;(100.0, AngleSolidUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatAngleSolid value = new FloatAngleSolid(100.0, AngleSolidUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAngleSolid extends AbstractFloatScalarRel<AngleSolidUnit, FloatAngleSolid>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatAngleSolid ZERO = new FloatAngleSolid(0.0f, AngleSolidUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatAngleSolid NaN = new FloatAngleSolid(Float.NaN, AngleSolidUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatAngleSolid POSITIVE_INFINITY = new FloatAngleSolid(Float.POSITIVE_INFINITY, AngleSolidUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatAngleSolid NEGATIVE_INFINITY = new FloatAngleSolid(Float.NEGATIVE_INFINITY, AngleSolidUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatAngleSolid POS_MAXVALUE = new FloatAngleSolid(Float.MAX_VALUE, AngleSolidUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatAngleSolid NEG_MAXVALUE = new FloatAngleSolid(-Float.MAX_VALUE, AngleSolidUnit.SI);

    /**
     * Construct FloatAngleSolid scalar.
     * @param value float value
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
     * @param value double value
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
     * @param value float value in SI units
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
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAngleSolid interpolate(final FloatAngleSolid zero, final FloatAngleSolid one, final float ratio)
    {
        return new FloatAngleSolid(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
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
     * allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatAngleSolid
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatAngleSolid valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatAngleSolid -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (AngleSolidUnit unit : Unit.getUnits(AngleSolidUnit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
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
     * Calculate the division of FloatAngleSolid and FloatAngleSolid, which results in a FloatDimensionless scalar.
     * @param v FloatAngleSolid scalar
     * @return FloatDimensionless scalar as a division of FloatAngleSolid and FloatAngleSolid
     */
    public final FloatDimensionless divideBy(final FloatAngleSolid v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

}
