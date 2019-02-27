package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.Unit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Volume FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;VolumeUnit&gt; value = new FloatScalar.Rel&lt;VolumeUnit&gt;(100.0, VolumeUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatVolume value = new FloatVolume(100.0, VolumeUnit.SI);
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
public class FloatVolume extends AbstractFloatScalarRel<VolumeUnit, FloatVolume>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatVolume ZERO = new FloatVolume(0.0f, VolumeUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatVolume NaN = new FloatVolume(Float.NaN, VolumeUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatVolume POSITIVE_INFINITY = new FloatVolume(Float.POSITIVE_INFINITY, VolumeUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatVolume NEGATIVE_INFINITY = new FloatVolume(Float.NEGATIVE_INFINITY, VolumeUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatVolume POS_MAXVALUE = new FloatVolume(Float.MAX_VALUE, VolumeUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatVolume NEG_MAXVALUE = new FloatVolume(-Float.MAX_VALUE, VolumeUnit.SI);

    /**
     * Construct FloatVolume scalar.
     * @param value float value
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
     * @param value double value
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
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatVolume createSI(final float value)
    {
        return new FloatVolume(value, VolumeUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatVolume interpolate(final FloatVolume zero, final FloatVolume one, final float ratio)
    {
        return new FloatVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
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
     * not necessary, between the value and the unit.
     * @param text String; the textual representation to parse into a FloatVolume
     * @return the String representation of the value in its unit, followed by the official abbreviation of the unit
     * @throws IllegalArgumentException when the text cannot be parsed
     */
    public static FloatVolume valueOf(final String text) throws IllegalArgumentException
    {
        if (text == null || text.length() == 0)
        {
            throw new IllegalArgumentException("Error parsing FloatVolume -- null or empty argument");
        }
        int index = text.length() - 1;
        while ("0123456789.".indexOf(text.charAt(index)) == -1 && index > 0)
        {
            index--;
        }
        try
        {
            String unitString = text.substring(index + 1).trim();
            String valueString = text.substring(0, index + 1).trim();
            for (VolumeUnit unit : Unit.getUnits(VolumeUnit.class))
            {
                if (unitString.equals(unit.getAbbreviation()))
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
        throw new IllegalArgumentException("Error parsing FloatVolume from " + text);
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

    /**
     * Calculate the multiplication of FloatVolume and FloatMoneyPerVolume, which results in a FloatMoney scalar.
     * @param v FloatVolume scalar
     * @return FloatMoney scalar as a multiplication of FloatVolume and FloatMoneyPerVolume
     */
    public final FloatMoney multiplyBy(final FloatMoneyPerVolume v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
