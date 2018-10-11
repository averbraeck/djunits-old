package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Area FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * 
 * <pre>
 * FloatScalar.Rel&lt;AreaUnit&gt; value = new FloatScalar.Rel&lt;AreaUnit&gt;(100.0, AreaUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * FloatArea value = new FloatArea(100.0, AreaUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatArea extends AbstractFloatScalarRel<AreaUnit, FloatArea>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatArea ZERO = new FloatArea(0.0f, AreaUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final FloatArea NaN = new FloatArea(Float.NaN, AreaUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final FloatArea POSITIVE_INFINITY = new FloatArea(Float.POSITIVE_INFINITY, AreaUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final FloatArea NEGATIVE_INFINITY = new FloatArea(Float.NEGATIVE_INFINITY, AreaUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final FloatArea POS_MAXVALUE = new FloatArea(Float.MAX_VALUE, AreaUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final FloatArea NEG_MAXVALUE = new FloatArea(-Float.MAX_VALUE, AreaUnit.SI);

    /**
     * Construct FloatArea scalar.
     * @param value float; float value
     * @param unit AreaUnit; unit for the float value
     */
    public FloatArea(final float value, final AreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatArea scalar.
     * @param value FloatArea; Scalar from which to construct this instance
     */
    public FloatArea(final FloatArea value)
    {
        super(value);
    }

    /**
     * Construct FloatArea scalar using a double value.
     * @param value double; double value
     * @param unit AreaUnit; unit for the resulting float value
     */
    public FloatArea(final double value, final AreaUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatArea instantiateRel(final float value, final AreaUnit unit)
    {
        return new FloatArea(value, unit);
    }

    /**
     * Construct FloatArea scalar.
     * @param value float; float value in SI units
     * @return the new scalar with the SI value
     */
    public static final FloatArea createSI(final float value)
    {
        return new FloatArea(value, AreaUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatArea; the low value
     * @param one FloatArea; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatArea interpolate(final FloatArea zero, final FloatArea one, final float ratio)
    {
        return new FloatArea(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatArea; the first scalar
     * @param r2 FloatArea; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static FloatArea max(final FloatArea r1, final FloatArea r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatArea; the first scalar
     * @param r2 FloatArea; the second scalar
     * @param rn FloatArea...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static FloatArea max(final FloatArea r1, final FloatArea r2, final FloatArea... rn)
    {
        FloatArea maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatArea r : rn)
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
     * @param r1 FloatArea; the first scalar
     * @param r2 FloatArea; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static FloatArea min(final FloatArea r1, final FloatArea r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatArea; the first scalar
     * @param r2 FloatArea; the second scalar
     * @param rn FloatArea...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static FloatArea min(final FloatArea r1, final FloatArea r2, final FloatArea... rn)
    {
        FloatArea minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatArea r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of FloatArea and FloatArea, which results in a FloatDimensionless scalar.
     * @param v FloatArea; FloatArea scalar
     * @return FloatDimensionless scalar as a division of FloatArea and FloatArea
     */
    public final FloatDimensionless divideBy(final FloatArea v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatLength, which results in a FloatVolume scalar.
     * @param v FloatLength; FloatArea scalar
     * @return FloatVolume scalar as a multiplication of FloatArea and FloatLength
     */
    public final FloatVolume multiplyBy(final FloatLength v)
    {
        return new FloatVolume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatArea and FloatLinearDensity, which results in a FloatVolume scalar.
     * @param v FloatLinearDensity; FloatArea scalar
     * @return FloatVolume scalar as a division of FloatArea and FloatLinearDensity
     */
    public final FloatVolume divideBy(final FloatLinearDensity v)
    {
        return new FloatVolume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatArea and FloatVolume, which results in a FloatLinearDensity scalar.
     * @param v FloatVolume; FloatArea scalar
     * @return FloatLinearDensity scalar as a division of FloatArea and FloatVolume
     */
    public final FloatLinearDensity divideBy(final FloatVolume v)
    {
        return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the division of FloatArea and FloatLength, which results in a FloatLength scalar.
     * @param v FloatLength; FloatArea scalar
     * @return FloatLength scalar as a division of FloatArea and FloatLength
     */
    public final FloatLength divideBy(final FloatLength v)
    {
        return new FloatLength(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatLinearDensity, which results in a FloatLength scalar.
     * @param v FloatLinearDensity; FloatArea scalar
     * @return FloatLength scalar as a multiplication of FloatArea and FloatLinearDensity
     */
    public final FloatLength multiplyBy(final FloatLinearDensity v)
    {
        return new FloatLength(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatSpeed, which results in a FloatFlowVolume scalar.
     * @param v FloatSpeed; FloatArea scalar
     * @return FloatFlowVolume scalar as a multiplication of FloatArea and FloatSpeed
     */
    public final FloatFlowVolume multiplyBy(final FloatSpeed v)
    {
        return new FloatFlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatPressure, which results in a FloatForce scalar.
     * @param v FloatPressure; FloatArea scalar
     * @return FloatForce scalar as a multiplication of FloatArea and FloatPressure
     */
    public final FloatForce multiplyBy(final FloatPressure v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatMoneyPerArea, which results in a FloatMoney scalar.
     * @param v FloatMoneyPerArea; FloatArea scalar
     * @return FloatMoney scalar as a multiplication of FloatArea and FloatMoneyPerArea
     */
    public final FloatMoney multiplyBy(final FloatMoneyPerArea v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
