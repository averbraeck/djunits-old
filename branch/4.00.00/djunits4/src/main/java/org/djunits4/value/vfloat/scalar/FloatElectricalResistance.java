package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.ElectricalPotentialUnit;
import org.djunits4.unit.ElectricalResistanceUnit;

/**
 * Easy access methods for the ElectricalResistance FloatScalar, which is relative by definition. An example is Speed. Instead
 * of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;ElectricalResistanceUnit&gt; value =
 *         new FloatScalar.Rel&lt;ElectricalResistanceUnit&gt;(100.0, ElectricalResistanceUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatElectricalResistance value = new FloatElectricalResistance(100.0, ElectricalResistanceUnit.SI);
 * </pre>
 * 
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
public class FloatElectricalResistance extends AbstractFloatScalarRel<ElectricalResistanceUnit, FloatElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatElectricalResistance ZERO = new FloatElectricalResistance(0.0f, ElectricalResistanceUnit.SI);

    /** constant with value zero. */
    public static final FloatElectricalResistance ONE = new FloatElectricalResistance(1.0f, ElectricalResistanceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatElectricalResistance NaN = new FloatElectricalResistance(Float.NaN, ElectricalResistanceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatElectricalResistance POSITIVE_INFINITY =
            new FloatElectricalResistance(Float.POSITIVE_INFINITY, ElectricalResistanceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatElectricalResistance NEGATIVE_INFINITY =
            new FloatElectricalResistance(Float.NEGATIVE_INFINITY, ElectricalResistanceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatElectricalResistance POS_MAXVALUE =
            new FloatElectricalResistance(Float.MAX_VALUE, ElectricalResistanceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatElectricalResistance NEG_MAXVALUE =
            new FloatElectricalResistance(-Float.MAX_VALUE, ElectricalResistanceUnit.SI);

    /**
     * Construct FloatElectricalResistance scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatElectricalResistance(final float value, final ElectricalResistanceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatElectricalResistance scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatElectricalResistance(final FloatElectricalResistance value)
    {
        super(value);
    }

    /**
     * Construct FloatElectricalResistance scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatElectricalResistance(final double value, final ElectricalResistanceUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance instantiateRel(final float value, final ElectricalResistanceUnit unit)
    {
        return new FloatElectricalResistance(value, unit);
    }

    /**
     * Construct FloatElectricalResistance scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatElectricalResistance createSI(final float value)
    {
        return new FloatElectricalResistance(value, ElectricalResistanceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatElectricalResistance interpolate(final FloatElectricalResistance zero,
            final FloatElectricalResistance one, final float ratio)
    {
        return new FloatElectricalResistance(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatElectricalResistance max(final FloatElectricalResistance r1, final FloatElectricalResistance r2)
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
    public static FloatElectricalResistance max(final FloatElectricalResistance r1, final FloatElectricalResistance r2,
            final FloatElectricalResistance... rn)
    {
        FloatElectricalResistance maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatElectricalResistance r : rn)
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
    public static FloatElectricalResistance min(final FloatElectricalResistance r1, final FloatElectricalResistance r2)
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
    public static FloatElectricalResistance min(final FloatElectricalResistance r1, final FloatElectricalResistance r2,
            final FloatElectricalResistance... rn)
    {
        FloatElectricalResistance minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatElectricalResistance r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatElectricalResistance representation of a textual representation of a value with a unit. The String
     * representation that can be parsed is the double value in the unit, followed by the official abbreviation of the unit.
     * Spaces are allowed, but not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatElectricalResistance
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatElectricalResistance valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatElectricalResistance -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ElectricalResistanceUnit unit : ElectricalResistanceUnit.BASE.getUnitsById().values())
                {
                    if (unit.getAbbreviations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatElectricalResistance(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatElectricalResistance from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatElectricalResistance from " + text);
    }

    /**
     * Calculate the division of FloatElectricalResistance and FloatElectricalResistance, which results in a FloatDimensionless
     * scalar.
     * @param v FloatElectricalResistance scalar
     * @return FloatDimensionless scalar as a division of FloatElectricalResistance and FloatElectricalResistance
     */
    public final FloatDimensionless divideBy(final FloatElectricalResistance v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatElectricalResistance and FloatElectricalCurrent, which results in a
     * FloatElectricalPotential scalar.
     * @param v FloatElectricalResistance scalar
     * @return FloatElectricalPotential scalar as a multiplication of FloatElectricalResistance and FloatElectricalCurrent
     */
    public final FloatElectricalPotential multiplyBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

}
