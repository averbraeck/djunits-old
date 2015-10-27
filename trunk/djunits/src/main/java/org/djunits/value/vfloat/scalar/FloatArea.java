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
 * Easy access methods for the Area FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;AreaUnit&gt; value = new FloatScalar.Rel&lt;AreaUnit&gt;(100.0, AreaUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatArea value = new FloatArea(100.0, AreaUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatArea extends TypedFloatScalarRel<AreaUnit, FloatArea>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct FloatArea scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatArea(final float value, final AreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatArea scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatArea(final FloatArea value)
    {
        super(value);
    }

    /**
     * Construct FloatArea scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatArea(final double value, final AreaUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatArea instantiateTypeRel(final float value, final AreaUnit unit)
    {
        return new FloatArea(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatArea interpolate(final FloatArea zero, final FloatArea one, final float ratio)
    {
        return new FloatArea(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of FloatArea and FloatArea, which results in a FloatDimensionless scalar.
     * @param v FloatArea scalar
     * @return FloatDimensionless scalar as a division of FloatArea and FloatArea
     */
    public final FloatDimensionless divideBy(final FloatArea v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatLength, which results in a FloatVolume scalar.
     * @param v FloatArea scalar
     * @return FloatVolume scalar as a multiplication of FloatArea and FloatLength
     */
    public final FloatVolume multiplyBy(final FloatLength.Rel v)
    {
        return new FloatVolume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatArea and FloatLinearDensity, which results in a FloatVolume scalar.
     * @param v FloatArea scalar
     * @return FloatVolume scalar as a division of FloatArea and FloatLinearDensity
     */
    public final FloatVolume divideBy(final FloatLinearDensity v)
    {
        return new FloatVolume(this.si / v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatArea and FloatVolume, which results in a FloatLinearDensity scalar.
     * @param v FloatArea scalar
     * @return FloatLinearDensity scalar as a division of FloatArea and FloatVolume
     */
    public final FloatLinearDensity divideBy(final FloatVolume v)
    {
        return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the division of FloatArea and FloatLength, which results in a FloatLength scalar.
     * @param v FloatArea scalar
     * @return FloatLength scalar as a division of FloatArea and FloatLength
     */
    public final FloatLength.Rel divideBy(final FloatLength.Rel v)
    {
        return new FloatLength.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatLinearDensity, which results in a FloatLength scalar.
     * @param v FloatArea scalar
     * @return FloatLength scalar as a multiplication of FloatArea and FloatLinearDensity
     */
    public final FloatLength.Rel multiplyBy(final FloatLinearDensity v)
    {
        return new FloatLength.Rel(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatSpeed, which results in a FloatFlowVolume scalar.
     * @param v FloatArea scalar
     * @return FloatFlowVolume scalar as a multiplication of FloatArea and FloatSpeed
     */
    public final FloatFlowVolume multiplyBy(final FloatSpeed v)
    {
        return new FloatFlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatPressure, which results in a FloatForce scalar.
     * @param v FloatArea scalar
     * @return FloatForce scalar as a multiplication of FloatArea and FloatPressure
     */
    public final FloatForce multiplyBy(final FloatPressure v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatArea and FloatMoneyPerArea, which results in a FloatMoney scalar.
     * @param v FloatArea scalar
     * @return FloatMoney scalar as a multiplication of FloatArea and FloatMoneyPerArea
     */
    public final FloatMoney multiplyBy(final FloatMoneyPerArea v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
