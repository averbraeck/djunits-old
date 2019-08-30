package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the %Type% FloatScalar. Instead of:
 * <pre>FloatScalar.Rel&lt;AngleUnit&gt; value = new FloatScalar.Rel&lt;AngleUnit&gt;(100.0, AngleUnit.SI);</pre>
 * we can now write:
 * <pre>FloatAngle value = new FloatAngle(100.0, AngleUnit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
 * unit used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAngle extends AbstractFloatScalarRel<AngleUnit, FloatAngle>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatAngle ZERO = new FloatAngle(0.0f, AngleUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatAngle NaN = new FloatAngle(Float.NaN, AngleUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatAngle POSITIVE_INFINITY = new FloatAngle(Float.POSITIVE_INFINITY, AngleUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatAngle NEGATIVE_INFINITY = new FloatAngle(Float.NEGATIVE_INFINITY, AngleUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatAngle POS_MAXVALUE = new FloatAngle(Float.MAX_VALUE, AngleUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatAngle NEG_MAXVALUE = new FloatAngle(-Float.MAX_VALUE, AngleUnit.SI);

    /**
     * Construct FloatAngle scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatAngle(final float value, final AngleUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatAngle scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatAngle(final FloatAngle value)
    {
        super(value);
    }

    /**
     * Construct FloatAngle scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatAngle(final double value, final AngleUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngle instantiateRel(final float value, final AngleUnit unit)
    {
        return new FloatAngle(value, unit);
    }

    /**
     * Construct FloatAngle scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatAngle createSI(final float value)
    {
        return new FloatAngle(value, AngleUnit.SI);
    }

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return A a new absolute instance of the FloatScalar of the right type
     */
    public final FloatDirection instantiateAbs(final float value, final DirectionUnit unit)
    {
        return new FloatDirection(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatAngle interpolate(final FloatAngle zero, final FloatAngle one, final float ratio)
    {
        return new FloatAngle(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }
    
    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatDirection plus(final FloatDirection v)
    {
        DirectionUnit targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatAngle max(final FloatAngle r1, final FloatAngle r2)
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
    public static FloatAngle max(final FloatAngle r1, final FloatAngle r2, final FloatAngle... rn)
    {
        FloatAngle maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatAngle r : rn)
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
    public static FloatAngle min(final FloatAngle r1, final FloatAngle r2)
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
    public static FloatAngle min(final FloatAngle r1, final FloatAngle r2, final FloatAngle... rn)
    {
        FloatAngle minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatAngle r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatAngle representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatAngle
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatAngle valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatAngle -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (AngleUnit unit : AngleUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatAngle(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatAngle from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatAngle from " + text);
    }
        /**
         * Calculate the division of FloatAngle and FloatAngle, which results in a FloatDimensionless scalar.
         * @param v FloatAngle scalar
         * @return FloatDimensionless scalar as a division of FloatAngle and FloatAngle
         */
        public final FloatDimensionless divideBy(final FloatAngle v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
        }


}
