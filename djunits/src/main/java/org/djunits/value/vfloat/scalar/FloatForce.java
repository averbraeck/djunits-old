package org.djunits.value.vfloat.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.Unit;

/**
 * Easy access methods for the Force FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;ForceUnit&gt; value = new FloatScalar.Rel&lt;ForceUnit&gt;(100.0, ForceUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatForce value = new FloatForce(100.0, ForceUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatForce extends AbstractFloatScalarRel<ForceUnit, FloatForce>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatForce ZERO = new FloatForce(0.0f, ForceUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatForce NaN = new FloatForce(Float.NaN, ForceUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatForce POSITIVE_INFINITY = new FloatForce(Float.POSITIVE_INFINITY, ForceUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatForce NEGATIVE_INFINITY = new FloatForce(Float.NEGATIVE_INFINITY, ForceUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatForce POS_MAXVALUE = new FloatForce(Float.MAX_VALUE, ForceUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatForce NEG_MAXVALUE = new FloatForce(-Float.MAX_VALUE, ForceUnit.SI);

    /**
     * Construct FloatForce scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatForce(final float value, final ForceUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatForce scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatForce(final FloatForce value)
    {
        super(value);
    }

    /**
     * Construct FloatForce scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatForce(final double value, final ForceUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForce instantiateRel(final float value, final ForceUnit unit)
    {
        return new FloatForce(value, unit);
    }

    /**
     * Construct FloatForce scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatForce createSI(final float value)
    {
        return new FloatForce(value, ForceUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatForce interpolate(final FloatForce zero, final FloatForce one, final float ratio)
    {
        return new FloatForce(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatForce max(final FloatForce r1, final FloatForce r2)
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
    public static FloatForce max(final FloatForce r1, final FloatForce r2, final FloatForce... rn)
    {
        FloatForce maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatForce r : rn)
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
    public static FloatForce min(final FloatForce r1, final FloatForce r2)
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
    public static FloatForce min(final FloatForce r1, final FloatForce r2, final FloatForce... rn)
    {
        FloatForce minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatForce r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatForce representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatForce
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatForce valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatForce -- null or empty argument");
        }
        Matcher matcher = NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                for (ForceUnit unit : Unit.getUnits(ForceUnit.class))
                {
                    if (unit.getDefaultLocaleTextualRepresentations().contains(unitString))
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatForce(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatForce from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatForce from " + text);
    }

    /**
     * Calculate the division of FloatForce and FloatForce, which results in a FloatDimensionless scalar.
     * @param v FloatForce scalar
     * @return FloatDimensionless scalar as a division of FloatForce and FloatForce
     */
    public final FloatDimensionless divideBy(final FloatForce v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatForce and FloatLength, which results in a FloatEnergy scalar.
     * @param v FloatForce scalar
     * @return FloatEnergy scalar as a multiplication of FloatForce and FloatLength
     */
    public final FloatEnergy multiplyBy(final FloatLength v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of FloatForce and FloatLinearDensity, which results in a FloatEnergy scalar.
     * @param v FloatForce scalar
     * @return FloatEnergy scalar as a division of FloatForce and FloatLinearDensity
     */
    public final FloatEnergy divideBy(final FloatLinearDensity v)
    {
        return new FloatEnergy(this.si / v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of FloatForce and FloatEnergy, which results in a FloatLinearDensity scalar.
     * @param v FloatForce scalar
     * @return FloatLinearDensity scalar as a division of FloatForce and FloatEnergy
     */
    public final FloatLinearDensity divideBy(final FloatEnergy v)
    {
        return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatForce and FloatSpeed, which results in a FloatPower scalar.
     * @param v FloatForce scalar
     * @return FloatPower scalar as a multiplication of FloatForce and FloatSpeed
     */
    public final FloatPower multiplyBy(final FloatSpeed v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the division of FloatForce and FloatMass, which results in a FloatAcceleration scalar.
     * @param v FloatForce scalar
     * @return FloatAcceleration scalar as a division of FloatForce and FloatMass
     */
    public final FloatAcceleration divideBy(final FloatMass v)
    {
        return new FloatAcceleration(this.si / v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of FloatForce and FloatAcceleration, which results in a FloatMass scalar.
     * @param v FloatForce scalar
     * @return FloatMass scalar as a division of FloatForce and FloatAcceleration
     */
    public final FloatMass divideBy(final FloatAcceleration v)
    {
        return new FloatMass(this.si / v.si, MassUnit.SI);
    }

    /**
     * Calculate the division of FloatForce and FloatArea, which results in a FloatPressure scalar.
     * @param v FloatForce scalar
     * @return FloatPressure scalar as a division of FloatForce and FloatArea
     */
    public final FloatPressure divideBy(final FloatArea v)
    {
        return new FloatPressure(this.si / v.si, PressureUnit.SI);
    }

    /**
     * Calculate the division of FloatForce and FloatPressure, which results in a FloatArea scalar.
     * @param v FloatForce scalar
     * @return FloatArea scalar as a division of FloatForce and FloatPressure
     */
    public final FloatArea divideBy(final FloatPressure v)
    {
        return new FloatArea(this.si / v.si, AreaUnit.SI);
    }

}
