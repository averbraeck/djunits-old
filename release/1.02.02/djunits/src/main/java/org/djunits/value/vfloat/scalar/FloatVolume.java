package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Volume FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;VolumeUnit&gt; value = new FloatScalar.Rel&lt;VolumeUnit&gt;(100.0, VolumeUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatVolume value = new FloatVolume(100.0, VolumeUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatVolume extends TypedFloatScalarRel<VolumeUnit, FloatVolume>
{
    /** */
    private static final long serialVersionUID = 20150901L;

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
    protected final FloatVolume instantiateTypeRel(final float value, final VolumeUnit unit)
    {
        return new FloatVolume(value, unit);
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
     * Calculate the division of FloatVolume and FloatVolume, which results in a FloatDimensionless scalar.
     * @param v FloatVolume scalar
     * @return FloatDimensionless scalar as a division of FloatVolume and FloatVolume
     */
    public final FloatDimensionless.Rel divideBy(final FloatVolume v)
    {
        return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
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
    public final FloatArea divideBy(final FloatLength.Rel v)
    {
        return new FloatArea(this.si / v.si, AreaUnit.SI);
    }

    /**
     * Calculate the division of FloatVolume and FloatArea, which results in a FloatLength scalar.
     * @param v FloatVolume scalar
     * @return FloatLength scalar as a division of FloatVolume and FloatArea
     */
    public final FloatLength.Rel divideBy(final FloatArea v)
    {
        return new FloatLength.Rel(this.si / v.si, LengthUnit.SI);
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
     * Calculate the division of FloatVolume and FloatTime, which results in a FloatFlowVolume scalar.
     * @param v FloatVolume scalar
     * @return FloatFlowVolume scalar as a division of FloatVolume and FloatTime
     */
    public final FloatFlowVolume divideBy(final FloatTime.Rel v)
    {
        return new FloatFlowVolume(this.si / v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatVolume and FloatFlowVolume, which results in a FloatTime scalar.
     * @param v FloatVolume scalar
     * @return FloatTime scalar as a division of FloatVolume and FloatFlowVolume
     */
    public final FloatTime.Rel divideBy(final FloatFlowVolume v)
    {
        return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
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