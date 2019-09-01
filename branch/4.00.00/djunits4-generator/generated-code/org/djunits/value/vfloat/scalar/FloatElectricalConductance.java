package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.value.Relative;
import javax.annotation.Generated;

import org.djunits4.unit.*;

/**
 * Easy access methods for the FloatElectricalConductance FloatScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatElectricalConductance extends AbstractFloatScalarRel<ElectricalConductanceUnit, FloatElectricalConductance> 
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatElectricalConductance ZERO = new FloatElectricalConductance(0.0f, ElectricalConductanceUnit.SI);

    /** constant with value zero. */
    public static final FloatElectricalConductance ONE = new FloatElectricalConductance(1.0f, ElectricalConductanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatElectricalConductance NaN = new FloatElectricalConductance(Float.NaN, ElectricalConductanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatElectricalConductance POSITIVE_INFINITY = new FloatElectricalConductance(Float.POSITIVE_INFINITY, ElectricalConductanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatElectricalConductance NEGATIVE_INFINITY = new FloatElectricalConductance(Float.NEGATIVE_INFINITY, ElectricalConductanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatElectricalConductance POS_MAXVALUE = new FloatElectricalConductance(Float.MAX_VALUE, ElectricalConductanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatElectricalConductance NEG_MAXVALUE = new FloatElectricalConductance(-Float.MAX_VALUE, ElectricalConductanceUnit.SI);

    /**
     * Construct FloatElectricalConductance scalar.
     * @param value float; the float value
     * @param unit unit for the float value
     */
    public FloatElectricalConductance(final float value, final ElectricalConductanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalConductance scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalConductance(final FloatElectricalConductance value)
    {
        super(value);
    }

    /**
     * Construct FloatElectricalConductance scalar using a double value.
     * @param value double; the double value
     * @param unit unit for the resulting float value
     */
    public FloatElectricalConductance(final double value, final ElectricalConductanceUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalConductance instantiateRel(final float value, final ElectricalConductanceUnit unit)
    {
        return new FloatElectricalConductance(value, unit);
    }

    /**
     * Construct FloatElectricalConductance scalar.
     * @param value float; the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatElectricalConductance createSI(final float value)
    {
        return new FloatElectricalConductance(value, ElectricalConductanceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalConductance interpolate(final FloatElectricalConductance zero, final FloatElectricalConductance one, final float ratio)
    {
        return new FloatElectricalConductance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatElectricalConductance max(final FloatElectricalConductance r1, final FloatElectricalConductance r2)
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
    public static FloatElectricalConductance max(final FloatElectricalConductance r1, final FloatElectricalConductance r2, final FloatElectricalConductance... rn)
    {
        FloatElectricalConductance maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatElectricalConductance r : rn)
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
    public static FloatElectricalConductance min(final FloatElectricalConductance r1, final FloatElectricalConductance r2)
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
    public static FloatElectricalConductance min(final FloatElectricalConductance r1, final FloatElectricalConductance r2, final FloatElectricalConductance... rn)
    {
        FloatElectricalConductance minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatElectricalConductance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatElectricalConductance representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatElectricalConductance
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatElectricalConductance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatElectricalConductance -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ElectricalConductanceUnit unit : ElectricalConductanceUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatElectricalConductance(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatElectricalConductance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatElectricalConductance from " + text);
    }

}

