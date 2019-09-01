package org.djunits.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.Unit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the %Type% FloatScalar. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;LengthUnit&gt; value = new FloatScalar.Rel&lt;LengthUnit&gt;(100.0, LengthUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatLength value = new FloatLength(100.0, LengthUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 1, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatLength extends AbstractFloatScalarRel<LengthUnit, FloatLength>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatLength ZERO = new FloatLength(0.0f, LengthUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatLength NaN = new FloatLength(Float.NaN, LengthUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatLength POSITIVE_INFINITY = new FloatLength(Float.POSITIVE_INFINITY, LengthUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatLength NEGATIVE_INFINITY = new FloatLength(Float.NEGATIVE_INFINITY, LengthUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatLength POS_MAXVALUE = new FloatLength(Float.MAX_VALUE, LengthUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatLength NEG_MAXVALUE = new FloatLength(-Float.MAX_VALUE, LengthUnit.SI);

    /**
     * Construct FloatLength scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatLength(final float value, final LengthUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatLength scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatLength(final FloatLength value)
    {
        super(value);
    }

    /**
     * Construct FloatLength scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatLength(final double value, final LengthUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLength instantiateRel(final float value, final LengthUnit unit)
    {
        return new FloatLength(value, unit);
    }

    /**
     * Construct FloatLength scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatLength createSI(final float value)
    {
        return new FloatLength(value, LengthUnit.SI);
    }

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return A a new absolute instance of the FloatScalar of the right type
     */
    public final FloatPosition instantiateAbs(final float value, final PositionUnit unit)
    {
        return new FloatPosition(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatLength interpolate(final FloatLength zero, final FloatLength one, final float ratio)
    {
        return new FloatLength(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final FloatPosition plus(final FloatPosition v)
    {
        PositionUnit targetUnit = v.getUnit();
        return instantiateAbs(v.getInUnit() + getInUnit(targetUnit.getRelativeUnit()), targetUnit);
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatLength max(final FloatLength r1, final FloatLength r2)
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
    public static FloatLength max(final FloatLength r1, final FloatLength r2, final FloatLength... rn)
    {
        FloatLength maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatLength r : rn)
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
    public static FloatLength min(final FloatLength r1, final FloatLength r2)
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
    public static FloatLength min(final FloatLength r1, final FloatLength r2, final FloatLength... rn)
    {
        FloatLength minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatLength r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatLength representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatLength
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatLength valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatLength -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (LengthUnit unit : Unit.getUnits(LengthUnit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatLength(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatLength from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatLength from " + text);
    }

    /**
     * Calculate the division of FloatLength and FloatLength, which results in a FloatDimensionless scalar.
     * @param v FloatLength scalar
     * @return FloatDimensionless scalar as a division of FloatLength and FloatLength
     */
    public final FloatDimensionless divideBy(final FloatLength v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatLength and FloatLength, which results in a FloatArea scalar.
     * @param v FloatLength scalar
     * @return FloatArea scalar as a multiplication of FloatLength and FloatLength
     */
    public final FloatArea multiplyBy(final FloatLength v)
    {
        return new FloatArea(this.si * v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of FloatLength and FloatLinearDensity, which results in a FloatArea scalar.
     * @param v FloatLength scalar
     * @return FloatArea scalar as a division of FloatLength and FloatLinearDensity
     */
    public final FloatArea divideBy(final FloatLinearDensity v)
    {
        return new FloatArea(this.si / v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of FloatLength and FloatArea, which results in a FloatLinearDensity scalar.
     * @param v FloatLength scalar
     * @return FloatLinearDensity scalar as a division of FloatLength and FloatArea
     */
    public final FloatLinearDensity divideBy(final FloatArea v)
    {
        return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatLength and FloatArea, which results in a FloatVolume scalar.
     * @param v FloatLength scalar
     * @return FloatVolume scalar as a multiplication of FloatLength and FloatArea
     */
    public final FloatVolume multiplyBy(final FloatArea v)
    {
        return new FloatVolume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatLength and FloatForce, which results in a FloatEnergy scalar.
     * @param v FloatLength scalar
     * @return FloatEnergy scalar as a multiplication of FloatLength and FloatForce
     */
    public final FloatEnergy multiplyBy(final FloatForce v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatLength and FloatFrequency, which results in a FloatSpeed scalar.
     * @param v FloatLength scalar
     * @return FloatSpeed scalar as a multiplication of FloatLength and FloatFrequency
     */
    public final FloatSpeed multiplyBy(final FloatFrequency v)
    {
        return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatLength and FloatDuration, which results in a FloatSpeed scalar.
     * @param v FloatLength scalar
     * @return FloatSpeed scalar as a division of FloatLength and FloatDuration
     */
    public final FloatSpeed divideBy(final FloatDuration v)
    {
        return new FloatSpeed(this.si / v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the division of FloatLength and FloatSpeed, which results in a FloatDuration scalar.
     * @param v FloatLength scalar
     * @return FloatDuration scalar as a division of FloatLength and FloatSpeed
     */
    public final FloatDuration divideBy(final FloatSpeed v)
    {
        return new FloatDuration(this.si / v.si, DurationUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatLength and FloatMoneyPerLength, which results in a FloatMoney scalar.
     * @param v FloatLength scalar
     * @return FloatMoney scalar as a multiplication of FloatLength and FloatMoneyPerLength
     */
    public final FloatMoney multiplyBy(final FloatMoneyPerLength v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
