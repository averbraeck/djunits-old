package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.AngleUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.LinearDensityUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Dimensionless FloatScalar, which is relative by definition. An example is Speed. Instead of <br>
 * <i>FloatScalar.Rel&lt;DimensionlessUnit&gt; value = new FloatScalar.Rel&lt;DimensionlessUnit&gt;(100.0,
 * DimensionlessUnit.SI);</i><br>
 * we can now write <br>
 * <i>FloatDimensionless value = new FloatDimensionless(100.0, DimensionlessUnit.SI);</i><br>
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
public class FloatDimensionless extends TypedFloatScalarDimensionless<DimensionlessUnit, FloatDimensionless>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final FloatDimensionless ZERO = new FloatDimensionless(0.0f, DimensionlessUnit.SI);

    /**
     * Construct FloatDimensionless scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public FloatDimensionless(final float value, final DimensionlessUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct FloatDimensionless scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatDimensionless(final FloatDimensionless value)
    {
        super(value);
    }

    /**
     * Construct FloatDimensionless scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public FloatDimensionless(final double value, final DimensionlessUnit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionless instantiateTypeRel(final float value, final DimensionlessUnit unit)
    {
        return new FloatDimensionless(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatDimensionless interpolate(final FloatDimensionless zero, final FloatDimensionless one, final float ratio)
    {
        return new FloatDimensionless(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of FloatDimensionless and FloatDimensionless, which results in a FloatDimensionless scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDimensionless scalar as a division of FloatDimensionless and FloatDimensionless
     */
    public final FloatDimensionless divideBy(final FloatDimensionless v)
    {
        return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatAcceleration, which results in a FloatAcceleration scalar.
     * @param v FloatDimensionless scalar
     * @return FloatAcceleration scalar as a multiplication of FloatDimensionless and FloatAcceleration
     */
    public final FloatAcceleration multiplyBy(final FloatAcceleration v)
    {
        return new FloatAcceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatAngle, which results in a FloatAngle scalar.
     * @param v FloatDimensionless scalar
     * @return FloatAngle scalar as a multiplication of FloatDimensionless and FloatAngle
     */
    public final FloatAngle multiplyBy(final FloatAngle v)
    {
        return new FloatAngle(this.si * v.si, AngleUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatAngleSolid, which results in a FloatAngleSolid scalar.
     * @param v FloatDimensionless scalar
     * @return FloatAngleSolid scalar as a multiplication of FloatDimensionless and FloatAngleSolid
     */
    public final FloatAngleSolid multiplyBy(final FloatAngleSolid v)
    {
        return new FloatAngleSolid(this.si * v.si, AngleSolidUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatArea, which results in a FloatArea scalar.
     * @param v FloatDimensionless scalar
     * @return FloatArea scalar as a multiplication of FloatDimensionless and FloatArea
     */
    public final FloatArea multiplyBy(final FloatArea v)
    {
        return new FloatArea(this.si * v.si, AreaUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatDensity, which results in a FloatDensity scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDensity scalar as a multiplication of FloatDimensionless and FloatDensity
     */
    public final FloatDensity multiplyBy(final FloatDensity v)
    {
        return new FloatDensity(this.si * v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatDimensionless, which results in a FloatDimensionless scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDimensionless scalar as a multiplication of FloatDimensionless and FloatDimensionless
     */
    public final FloatDimensionless multiplyBy(final FloatDimensionless v)
    {
        return new FloatDimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatElectricalCharge, which results in a FloatElectricalCharge
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatElectricalCharge scalar as a multiplication of FloatDimensionless and FloatElectricalCharge
     */
    public final FloatElectricalCharge multiplyBy(final FloatElectricalCharge v)
    {
        return new FloatElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatElectricalCurrent, which results in a FloatElectricalCurrent
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatElectricalCurrent scalar as a multiplication of FloatDimensionless and FloatElectricalCurrent
     */
    public final FloatElectricalCurrent multiplyBy(final FloatElectricalCurrent v)
    {
        return new FloatElectricalCurrent(this.si * v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatElectricalPotential, which results in a
     * FloatElectricalPotential scalar.
     * @param v FloatDimensionless scalar
     * @return FloatElectricalPotential scalar as a multiplication of FloatDimensionless and FloatElectricalPotential
     */
    public final FloatElectricalPotential multiplyBy(final FloatElectricalPotential v)
    {
        return new FloatElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatElectricalResistance, which results in a
     * FloatElectricalResistance scalar.
     * @param v FloatDimensionless scalar
     * @return FloatElectricalResistance scalar as a multiplication of FloatDimensionless and FloatElectricalResistance
     */
    public final FloatElectricalResistance multiplyBy(final FloatElectricalResistance v)
    {
        return new FloatElectricalResistance(this.si * v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatEnergy, which results in a FloatEnergy scalar.
     * @param v FloatDimensionless scalar
     * @return FloatEnergy scalar as a multiplication of FloatDimensionless and FloatEnergy
     */
    public final FloatEnergy multiplyBy(final FloatEnergy v)
    {
        return new FloatEnergy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatFlowMass, which results in a FloatFlowMass scalar.
     * @param v FloatDimensionless scalar
     * @return FloatFlowMass scalar as a multiplication of FloatDimensionless and FloatFlowMass
     */
    public final FloatFlowMass multiplyBy(final FloatFlowMass v)
    {
        return new FloatFlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatFlowVolume, which results in a FloatFlowVolume scalar.
     * @param v FloatDimensionless scalar
     * @return FloatFlowVolume scalar as a multiplication of FloatDimensionless and FloatFlowVolume
     */
    public final FloatFlowVolume multiplyBy(final FloatFlowVolume v)
    {
        return new FloatFlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatForce, which results in a FloatForce scalar.
     * @param v FloatDimensionless scalar
     * @return FloatForce scalar as a multiplication of FloatDimensionless and FloatForce
     */
    public final FloatForce multiplyBy(final FloatForce v)
    {
        return new FloatForce(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatFrequency, which results in a FloatFrequency scalar.
     * @param v FloatDimensionless scalar
     * @return FloatFrequency scalar as a multiplication of FloatDimensionless and FloatFrequency
     */
    public final FloatFrequency multiplyBy(final FloatFrequency v)
    {
        return new FloatFrequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatLength, which results in a FloatLength scalar.
     * @param v FloatDimensionless scalar
     * @return FloatLength scalar as a multiplication of FloatDimensionless and FloatLength
     */
    public final FloatLength multiplyBy(final FloatLength v)
    {
        return new FloatLength(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatLinearDensity, which results in a FloatLinearDensity scalar.
     * @param v FloatDimensionless scalar
     * @return FloatLinearDensity scalar as a multiplication of FloatDimensionless and FloatLinearDensity
     */
    public final FloatLinearDensity multiplyBy(final FloatLinearDensity v)
    {
        return new FloatLinearDensity(this.si * v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMass, which results in a FloatMass scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMass scalar as a multiplication of FloatDimensionless and FloatMass
     */
    public final FloatMass multiplyBy(final FloatMass v)
    {
        return new FloatMass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoney, which results in a FloatMoney scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoney scalar as a multiplication of FloatDimensionless and FloatMoney
     */
    public final FloatMoney multiplyBy(final FloatMoney v)
    {
        return new FloatMoney(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerArea, which results in a FloatMoneyPerArea scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerArea scalar as a multiplication of FloatDimensionless and FloatMoneyPerArea
     */
    public final FloatMoneyPerArea multiplyBy(final FloatMoneyPerArea v)
    {
        return new FloatMoneyPerArea(this.si * v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerEnergy, which results in a FloatMoneyPerEnergy
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerEnergy scalar as a multiplication of FloatDimensionless and FloatMoneyPerEnergy
     */
    public final FloatMoneyPerEnergy multiplyBy(final FloatMoneyPerEnergy v)
    {
        return new FloatMoneyPerEnergy(this.si * v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerLength, which results in a FloatMoneyPerLength
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerLength scalar as a multiplication of FloatDimensionless and FloatMoneyPerLength
     */
    public final FloatMoneyPerLength multiplyBy(final FloatMoneyPerLength v)
    {
        return new FloatMoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerMass, which results in a FloatMoneyPerMass scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerMass scalar as a multiplication of FloatDimensionless and FloatMoneyPerMass
     */
    public final FloatMoneyPerMass multiplyBy(final FloatMoneyPerMass v)
    {
        return new FloatMoneyPerMass(this.si * v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerTime, which results in a FloatMoneyPerTime scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerTime scalar as a multiplication of FloatDimensionless and FloatMoneyPerTime
     */
    public final FloatMoneyPerTime multiplyBy(final FloatMoneyPerTime v)
    {
        return new FloatMoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatMoneyPerVolume, which results in a FloatMoneyPerVolume
     * scalar.
     * @param v FloatDimensionless scalar
     * @return FloatMoneyPerVolume scalar as a multiplication of FloatDimensionless and FloatMoneyPerVolume
     */
    public final FloatMoneyPerVolume multiplyBy(final FloatMoneyPerVolume v)
    {
        return new FloatMoneyPerVolume(this.si * v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatPower, which results in a FloatPower scalar.
     * @param v FloatDimensionless scalar
     * @return FloatPower scalar as a multiplication of FloatDimensionless and FloatPower
     */
    public final FloatPower multiplyBy(final FloatPower v)
    {
        return new FloatPower(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatPressure, which results in a FloatPressure scalar.
     * @param v FloatDimensionless scalar
     * @return FloatPressure scalar as a multiplication of FloatDimensionless and FloatPressure
     */
    public final FloatPressure multiplyBy(final FloatPressure v)
    {
        return new FloatPressure(this.si * v.si, PressureUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatSpeed, which results in a FloatSpeed scalar.
     * @param v FloatDimensionless scalar
     * @return FloatSpeed scalar as a multiplication of FloatDimensionless and FloatSpeed
     */
    public final FloatSpeed multiplyBy(final FloatSpeed v)
    {
        return new FloatSpeed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatTemperature, which results in a FloatTemperature scalar.
     * @param v FloatDimensionless scalar
     * @return FloatTemperature scalar as a multiplication of FloatDimensionless and FloatTemperature
     */
    public final FloatTemperature multiplyBy(final FloatTemperature v)
    {
        return new FloatTemperature(this.si * v.si, TemperatureUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatDuration, which results in a FloatDuration scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDuration scalar as a multiplication of FloatDimensionless and FloatDuration
     */
    public final FloatDuration multiplyBy(final FloatDuration v)
    {
        return new FloatDuration(this.si * v.si, TimeUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatTorque, which results in a FloatTorque scalar.
     * @param v FloatDimensionless scalar
     * @return FloatTorque scalar as a multiplication of FloatDimensionless and FloatTorque
     */
    public final FloatTorque multiplyBy(final FloatTorque v)
    {
        return new FloatTorque(this.si * v.si, TorqueUnit.SI);
    }

    /**
     * Calculate the multiplication of FloatDimensionless and FloatVolume, which results in a FloatVolume scalar.
     * @param v FloatDimensionless scalar
     * @return FloatVolume scalar as a multiplication of FloatDimensionless and FloatVolume
     */
    public final FloatVolume multiplyBy(final FloatVolume v)
    {
        return new FloatVolume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of FloatDimensionless and FloatLength, which results in a FloatLinearDensity scalar.
     * @param v FloatDimensionless scalar
     * @return FloatLinearDensity scalar as a division of FloatDimensionless and FloatLength
     */
    public final FloatLinearDensity divideBy(final FloatLength v)
    {
        return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the division of FloatDimensionless and FloatLinearDensity, which results in a FloatLength scalar.
     * @param v FloatDimensionless scalar
     * @return FloatLength scalar as a division of FloatDimensionless and FloatLinearDensity
     */
    public final FloatLength divideBy(final FloatLinearDensity v)
    {
        return new FloatLength(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of FloatDimensionless and FloatDuration, which results in a FloatFrequency scalar.
     * @param v FloatDimensionless scalar
     * @return FloatFrequency scalar as a division of FloatDimensionless and FloatDuration
     */
    public final FloatFrequency divideBy(final FloatDuration v)
    {
        return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of FloatDimensionless and FloatFrequency, which results in a FloatDuration scalar.
     * @param v FloatDimensionless scalar
     * @return FloatDuration scalar as a division of FloatDimensionless and FloatFrequency
     */
    public final FloatDuration divideBy(final FloatFrequency v)
    {
        return new FloatDuration(this.si / v.si, TimeUnit.SI);
    }

}
