package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.*;

/**
 * Easy access methods for the %Type% FloatScalar. Instead of:
 * <pre>FloatScalar.Rel&lt;TemperatureUnit&gt; value = new FloatScalar.Rel&lt;TemperatureUnit&gt;(100.0, TemperatureUnit.SI);</pre>
 * we can now write:
 * <pre>FloatTemperature value = new FloatTemperature(100.0, TemperatureUnit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
 * unit used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatTemperature extends AbstractFloatScalarRel<TemperatureUnit, FloatTemperature>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatTemperature ZERO = new FloatTemperature(0.0f, TemperatureUnit.SI);

    /** constant with value one. */
    public static final FloatTemperature ONE = new FloatTemperature(1.0f, TemperatureUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatTemperature NaN = new FloatTemperature(Float.NaN, TemperatureUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatTemperature POSITIVE_INFINITY = new FloatTemperature(Float.POSITIVE_INFINITY, TemperatureUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatTemperature NEGATIVE_INFINITY = new FloatTemperature(Float.NEGATIVE_INFINITY, TemperatureUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatTemperature POS_MAXVALUE = new FloatTemperature(Float.MAX_VALUE, TemperatureUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatTemperature NEG_MAXVALUE = new FloatTemperature(-Float.MAX_VALUE, TemperatureUnit.SI);

    /**
     * Construct FloatTemperature scalar.
     * @param value float; the float value
     * @param unit unit for the float value
     */
    public FloatTemperature(final float value, final TemperatureUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatTemperature scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatTemperature(final FloatTemperature value)
    {
        super(value);
    }

    /**
     * Construct FloatTemperature scalar using a double value.
     * @param value double; the double value
     * @param unit unit for the resulting float value
     */
    public FloatTemperature(final double value, final TemperatureUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTemperature instantiateRel(final float value, final TemperatureUnit unit)
    {
        return new FloatTemperature(value, unit);
    }

    /**
     * Construct FloatTemperature scalar.
     * @param value float; the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatTemperature createSI(final float value)
    {
        return new FloatTemperature(value, TemperatureUnit.SI);
    }

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value float; the float value
     * @param unit the unit
     * @return A a new absolute instance of the FloatScalar of the right type
     */
    public final FloatAbsoluteTemperature instantiateAbs(final float value, final AbsoluteTemperatureUnit unit)
    {
        return new FloatAbsoluteTemperature(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatTemperature interpolate(final FloatTemperature zero, final FloatTemperature one, final float ratio)
    {
        return new FloatTemperature(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }
    
    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatAbsoluteTemperature plus(final FloatAbsoluteTemperature v)
    {
        AbsoluteTemperatureUnit targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatTemperature max(final FloatTemperature r1, final FloatTemperature r2)
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
    public static FloatTemperature max(final FloatTemperature r1, final FloatTemperature r2, final FloatTemperature... rn)
    {
        FloatTemperature maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatTemperature r : rn)
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
    public static FloatTemperature min(final FloatTemperature r1, final FloatTemperature r2)
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
    public static FloatTemperature min(final FloatTemperature r1, final FloatTemperature r2, final FloatTemperature... rn)
    {
        FloatTemperature minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatTemperature r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatTemperature representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatTemperature
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatTemperature valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatTemperature -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (TemperatureUnit unit : TemperatureUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatTemperature(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatTemperature from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatTemperature from " + text);
    }
        /**
         * Calculate the division of FloatTemperature and FloatTemperature, which results in a FloatDimensionless scalar.
         * @param v FloatTemperature scalar
         * @return FloatDimensionless scalar as a division of FloatTemperature and FloatTemperature
         */
        public final FloatDimensionless divideBy(final FloatTemperature v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
        }


}
