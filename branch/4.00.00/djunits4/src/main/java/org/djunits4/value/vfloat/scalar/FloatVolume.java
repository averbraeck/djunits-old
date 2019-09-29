package org.djunits4.value.vfloat.scalar;

import java.util.regex.Matcher;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.EnergyUnit;
import org.djunits4.unit.FlowVolumeUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.MassUnit;
import org.djunits4.unit.VolumeUnit;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRel;

/**
 * Easy access methods for the FloatVolume FloatScalar, which is relative by definition.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class FloatVolume extends AbstractFloatScalarRel<VolumeUnit, FloatVolume>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** Constant with value zero. */
    public static final FloatVolume ZERO = new FloatVolume(0.0f, VolumeUnit.SI);

    /** Constant with value one. */
    public static final FloatVolume ONE = new FloatVolume(1.0f, VolumeUnit.SI);

    /** Constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatVolume NaN = new FloatVolume(Float.NaN, VolumeUnit.SI);

    /** Constant with value POSITIVE_INFINITY. */
    public static final FloatVolume POSITIVE_INFINITY = new FloatVolume(Float.POSITIVE_INFINITY, VolumeUnit.SI);

    /** Constant with value NEGATIVE_INFINITY. */
    public static final FloatVolume NEGATIVE_INFINITY = new FloatVolume(Float.NEGATIVE_INFINITY, VolumeUnit.SI);

    /** Constant with value MAX_VALUE. */
    public static final FloatVolume POS_MAXVALUE = new FloatVolume(Float.MAX_VALUE, VolumeUnit.SI);

    /** Constant with value -MAX_VALUE. */
    public static final FloatVolume NEG_MAXVALUE = new FloatVolume(-Float.MAX_VALUE, VolumeUnit.SI);

    /**
     * Construct FloatVolume scalar.
     * @param value float; the float value
     * @param unit unit for the float value
     */
    public FloatVolume(final float value, final VolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatVolume(final FloatVolume value)
    {
        super(value);
    }

    /**
     * Construct FloatVolume scalar using a double value.
     * @param value double; the double value
     * @param unit unit for the resulting float value
     */
    public FloatVolume(final double value, final VolumeUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolume instantiateRel(final float value, final VolumeUnit unit)
    {
        return new FloatVolume(value, unit);
    }

    /**
     * Construct FloatVolume scalar.
     * @param value float; the float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatVolume instantiateSI(final float value)
    {
        return new FloatVolume(value, VolumeUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatVolume interpolate(final FloatVolume zero, final FloatVolume one, final float ratio)
    {
        return new FloatVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio,
                zero.getDisplayUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatVolume max(final FloatVolume r1, final FloatVolume r2)
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
    public static FloatVolume max(final FloatVolume r1, final FloatVolume r2, final FloatVolume... rn)
    {
        FloatVolume maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatVolume r : rn)
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
    public static FloatVolume min(final FloatVolume r1, final FloatVolume r2)
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
    public static FloatVolume min(final FloatVolume r1, final FloatVolume r2, final FloatVolume... rn)
    {
        FloatVolume minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatVolume r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a FloatVolume representation of a textual representation of a value with a unit. The String representation that
     * can be parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but
     * not required, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatVolume
     * @return FloatVolume; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static FloatVolume valueOf(final String text)
    {
        Throw.whenNull(text, "Error parsing FloatVolume: unitString is null");
        Throw.when(text.length() == 0, IllegalArgumentException.class, "Error parsing FloatVolume: empty unitString");
        Matcher matcher = ValueUtil.NUMBER_PATTERN.matcher(text);
        if (matcher.find())
        {
            int index = matcher.end();
            try
            {
                String unitString = text.substring(index).trim();
                String valueString = text.substring(0, index).trim();
                VolumeUnit unit = VolumeUnit.BASE.getUnitByAbbreviation(unitString);
                if (unit != null)
                {
                    {
                        float f = Float.parseFloat(valueString);
                        return new FloatVolume(f, unit);
                    }
                }
            }
            catch (Exception exception)
            {
                throw new IllegalArgumentException("Error parsing FloatVolume from " + text, exception);
            }
        }
        throw new IllegalArgumentException("Error parsing FloatVolume from " + text);
    }

    /**
     * Returns a FloatVolume based on a value and the textual representation of the unit.
     * @param value double; the value to use
     * @param unitString String; the textual representation of the unit
     * @return FloatVolume; the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatVolume of(final float value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing FloatVolume: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing FloatVolume: empty unitString");
        VolumeUnit unit = VolumeUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new FloatVolume(value, unit);
        }
        throw new IllegalArgumentException("Error parsing FloatVolume with unit " + unitString);
    }

    /**
     * Calculate the division of FloatVolume and FloatVolume, which results in a FloatDimensionless scalar.
     * @param v FloatVolume scalar
     * @return FloatDimensionless scalar as a division of FloatVolume and FloatVolume
     */
    public final FloatDimensionless divideBy(final FloatVolume v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatVolume and FloatDensity, which results in a FloatMass scalar.
     * @param v FloatVolume scalar
     * @return FloatMass scalar as a multiplication of FloatVolume and FloatDensity
     */
    public final FloatMass multiplyBy(final FloatDensity v)
    {
        return new FloatMass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatVolume and FloatPressure, which results in a FloatEnergy scalar.
     * @param v FloatVolume scalar
     * @return FloatEnergy scalar as a multiplication of FloatVolume and FloatPressure
     */
    public final FloatEnergy multiplyBy(final FloatPressure v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the division of FloatVolume and FloatLength, which results in a FloatArea scalar.
     * @param v FloatVolume scalar
     * @return FloatArea scalar as a division of FloatVolume and FloatLength
     */
    public final FloatArea divideBy(final FloatLength v)
    {
        return new FloatArea(this.si / v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of FloatVolume and FloatArea, which results in a FloatLength scalar.
     * @param v FloatVolume scalar
     * @return FloatLength scalar as a division of FloatVolume and FloatArea
     */
    public final FloatLength divideBy(final FloatArea v)
    {
        return new FloatLength(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatVolume and FloatLinearDensity, which results in a FloatArea scalar.
     * @param v FloatVolume scalar
     * @return FloatArea scalar as a multiplication of FloatVolume and FloatLinearDensity
     */
    public final FloatArea multiplyBy(final FloatLinearDensity v)
    {
        return new FloatArea(this.si * v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of FloatVolume and FloatDuration, which results in a FloatFlowVolume scalar.
     * @param v FloatVolume scalar
     * @return FloatFlowVolume scalar as a division of FloatVolume and FloatDuration
     */
    public final FloatFlowVolume divideBy(final FloatDuration v)
    {
        return new FloatFlowVolume(this.si / v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatVolume and FloatFlowVolume, which results in a FloatDuration scalar.
     * @param v FloatVolume scalar
     * @return FloatDuration scalar as a division of FloatVolume and FloatFlowVolume
     */
    public final FloatDuration divideBy(final FloatFlowVolume v)
    {
        return new FloatDuration(this.si / v.si, DurationUnit.SI);
    }

}
