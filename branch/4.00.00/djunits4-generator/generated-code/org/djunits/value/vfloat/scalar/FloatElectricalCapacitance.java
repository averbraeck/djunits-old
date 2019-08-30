package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.value.Relative;
import org.djunits4.unit.*;

/**
 * Easy access methods for the ElectricalCapacitance FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * <pre>FloatScalar.Rel&lt;ElectricalCapacitanceUnit&gt; value = new FloatScalar.Rel&lt;ElectricalCapacitanceUnit&gt;(100.0, ElectricalCapacitanceUnit.SI);</pre>
 * we can now write:
 * <pre>FloatElectricalCapacitance value = new FloatElectricalCapacitance(100.0, ElectricalCapacitanceUnit.SI);</pre>
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
public class FloatElectricalCapacitance extends AbstractFloatScalarRel<ElectricalCapacitanceUnit, FloatElectricalCapacitance> 
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatElectricalCapacitance ZERO = new FloatElectricalCapacitance(0.0f, ElectricalCapacitanceUnit.SI);

    /** constant with value zero. */
    public static final FloatElectricalCapacitance ONE = new FloatElectricalCapacitance(1.0f, ElectricalCapacitanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatElectricalCapacitance NaN = new FloatElectricalCapacitance(Float.NaN, ElectricalCapacitanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatElectricalCapacitance POSITIVE_INFINITY = new FloatElectricalCapacitance(Float.POSITIVE_INFINITY, ElectricalCapacitanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatElectricalCapacitance NEGATIVE_INFINITY = new FloatElectricalCapacitance(Float.NEGATIVE_INFINITY, ElectricalCapacitanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatElectricalCapacitance POS_MAXVALUE = new FloatElectricalCapacitance(Float.MAX_VALUE, ElectricalCapacitanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatElectricalCapacitance NEG_MAXVALUE = new FloatElectricalCapacitance(-Float.MAX_VALUE, ElectricalCapacitanceUnit.SI);

    /**
     * Construct FloatElectricalCapacitance scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalCapacitance(final float value, final ElectricalCapacitanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalCapacitance scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalCapacitance(final FloatElectricalCapacitance value)
    {
        super(value);
    }

    /**
     * Construct FloatElectricalCapacitance scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatElectricalCapacitance(final double value, final ElectricalCapacitanceUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCapacitance instantiateRel(final float value, final ElectricalCapacitanceUnit unit)
    {
        return new FloatElectricalCapacitance(value, unit);
    }

    /**
     * Construct FloatElectricalCapacitance scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatElectricalCapacitance createSI(final float value)
    {
        return new FloatElectricalCapacitance(value, ElectricalCapacitanceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalCapacitance interpolate(final FloatElectricalCapacitance zero, final FloatElectricalCapacitance one, final float ratio)
    {
        return new FloatElectricalCapacitance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatElectricalCapacitance max(final FloatElectricalCapacitance r1, final FloatElectricalCapacitance r2)
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
    public static FloatElectricalCapacitance max(final FloatElectricalCapacitance r1, final FloatElectricalCapacitance r2, final FloatElectricalCapacitance... rn)
    {
        FloatElectricalCapacitance maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatElectricalCapacitance r : rn)
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
    public static FloatElectricalCapacitance min(final FloatElectricalCapacitance r1, final FloatElectricalCapacitance r2)
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
    public static FloatElectricalCapacitance min(final FloatElectricalCapacitance r1, final FloatElectricalCapacitance r2, final FloatElectricalCapacitance... rn)
    {
        FloatElectricalCapacitance minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatElectricalCapacitance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatElectricalCapacitance representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatElectricalCapacitance
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatElectricalCapacitance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatElectricalCapacitance -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ElectricalCapacitanceUnit unit : ElectricalCapacitanceUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatElectricalCapacitance(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatElectricalCapacitance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatElectricalCapacitance from " + text);
    }

}

