package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.ElectricalInductanceUnit;

/**
 * Easy access methods for the FloatElectricalInductance FloatScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatElectricalInductance extends AbstractFloatScalarRel<ElectricalInductanceUnit, FloatElectricalInductance>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatElectricalInductance ZERO = new FloatElectricalInductance(0.0f, ElectricalInductanceUnit.SI);

    /** constant with value zero. */
    public static final FloatElectricalInductance ONE = new FloatElectricalInductance(1.0f, ElectricalInductanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatElectricalInductance NaN = new FloatElectricalInductance(Float.NaN, ElectricalInductanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatElectricalInductance POSITIVE_INFINITY =
            new FloatElectricalInductance(Float.POSITIVE_INFINITY, ElectricalInductanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatElectricalInductance NEGATIVE_INFINITY =
            new FloatElectricalInductance(Float.NEGATIVE_INFINITY, ElectricalInductanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatElectricalInductance POS_MAXVALUE =
            new FloatElectricalInductance(Float.MAX_VALUE, ElectricalInductanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatElectricalInductance NEG_MAXVALUE =
            new FloatElectricalInductance(-Float.MAX_VALUE, ElectricalInductanceUnit.SI);

    /**
     * Construct FloatElectricalInductance scalar.
     * @param value float; the float value
     * @param unit unit for the float value
     */
    public FloatElectricalInductance(final float value, final ElectricalInductanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalInductance scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalInductance(final FloatElectricalInductance value)
    {
        super(value);
    }

    /**
     * Construct FloatElectricalInductance scalar using a double value.
     * @param value double; the double value
     * @param unit unit for the resulting float value
     */
    public FloatElectricalInductance(final double value, final ElectricalInductanceUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalInductance instantiateRel(final float value, final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductance(value, unit);
    }

    /**
     * Construct FloatElectricalInductance scalar.
     * @param value float; the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatElectricalInductance createSI(final float value)
    {
        return new FloatElectricalInductance(value, ElectricalInductanceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalInductance interpolate(final FloatElectricalInductance zero,
            final FloatElectricalInductance one, final float ratio)
    {
        return new FloatElectricalInductance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatElectricalInductance max(final FloatElectricalInductance r1, final FloatElectricalInductance r2)
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
    public static FloatElectricalInductance max(final FloatElectricalInductance r1, final FloatElectricalInductance r2,
            final FloatElectricalInductance... rn)
    {
        FloatElectricalInductance maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatElectricalInductance r : rn)
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
    public static FloatElectricalInductance min(final FloatElectricalInductance r1, final FloatElectricalInductance r2)
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
    public static FloatElectricalInductance min(final FloatElectricalInductance r1, final FloatElectricalInductance r2,
            final FloatElectricalInductance... rn)
    {
        FloatElectricalInductance minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatElectricalInductance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatElectricalInductance representation of a textual representation of a value with a unit. The String
     * representation that can be parsed is the double value in the unit, followed by the official abbreviation of the unit.
     * Spaces are allowed, but not required, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatElectricalInductance
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatElectricalInductance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatElectricalInductance -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ElectricalInductanceUnit unit : ElectricalInductanceUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatElectricalInductance(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatElectricalInductance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatElectricalInductance from " + text);
    }

}
