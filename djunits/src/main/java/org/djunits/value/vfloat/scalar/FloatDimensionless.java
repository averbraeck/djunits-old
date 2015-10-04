package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AnglePlaneUnit;
import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.AngleSolidUnit;
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
 * Easy access methods for the Dimensionless FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass margin = new Mass(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatDimensionless
{
    /**
     * Easy access methods for the Dimensionless FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;DimensionlessUnit&gt; value = new FloatScalar.Rel&lt;DimensionlessUnit&gt;(100.0, DimensionlessUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatDimensionless.Rel value = new FloatDimensionless.Rel(100.0, DimensionlessUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Rel extends FloatScalar.Rel<DimensionlessUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatDimensionless.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final DimensionlessUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatDimensionless.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final DimensionlessUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatDimensionless.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<DimensionlessUnit> value)
        {
            super(value);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatDimensionless.Rel interpolate(final FloatDimensionless.Rel zero, final FloatDimensionless.Rel one, final float ratio)
        {
            return new FloatDimensionless.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatDimensionless.Rel interpolate(final FloatDimensionless.Rel zero, final FloatDimensionless.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel abs()
        {
            return new FloatDimensionless.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel acos()
        {
            return new FloatDimensionless.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel asin()
        {
            return new FloatDimensionless.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel atan()
        {
            return new FloatDimensionless.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel cbrt()
        {
            return new FloatDimensionless.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel ceil()
        {
            return new FloatDimensionless.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel cos()
        {
            return new FloatDimensionless.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel cosh()
        {
            return new FloatDimensionless.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel exp()
        {
            return new FloatDimensionless.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel expm1()
        {
            return new FloatDimensionless.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel floor()
        {
            return new FloatDimensionless.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel log()
        {
            return new FloatDimensionless.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel log10()
        {
            return new FloatDimensionless.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel log1p()
        {
            return new FloatDimensionless.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel rint()
        {
            return new FloatDimensionless.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel round()
        {
            return new FloatDimensionless.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel signum()
        {
            return new FloatDimensionless.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel sin()
        {
            return new FloatDimensionless.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel sinh()
        {
            return new FloatDimensionless.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel sqrt()
        {
            return new FloatDimensionless.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel tan()
        {
            return new FloatDimensionless.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel tanh()
        {
            return new FloatDimensionless.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel inv()
        {
            return new FloatDimensionless.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel toDegrees()
        {
            return new FloatDimensionless.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel toRadians()
        {
            return new FloatDimensionless.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel pow(final double x)
        {
            return new FloatDimensionless.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel multiplyBy(final float factor)
        {
            return new FloatDimensionless.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative dimensionless
         */
        public final FloatDimensionless.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Rel divideBy(final float divisor)
        {
            return new FloatDimensionless.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative dimensionless
         */
        public final FloatDimensionless.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatDimensionless.Rel plus(final FloatDimensionless.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatDimensionless.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new FloatDimensionless.Rel(this.si + v.si, DimensionlessUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatDimensionless.Rel minus(final FloatDimensionless.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatDimensionless.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatDimensionless.Rel(this.si - v.si, DimensionlessUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatDimensionless.Abs plus(final FloatDimensionless.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatDimensionless.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatDimensionless.Abs(this.si + v.si, DimensionlessUnit.SI);
        }

        /** 
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative dimensionless scalar.
         */
        public final FloatDimensionless.Abs toAbs()
        {
            return new FloatDimensionless.Abs(getInUnit(), getUnit());
        }

         * Calculate the division of FloatDimensionless and FloatDimensionless, which results in a FloatDimensionless scalar.
         * @param v FloatDimensionless scalar
         * @return FloatDimensionless scalar as a division of FloatDimensionless and FloatDimensionless
         */
        public final FloatDimensionless.Rel divideBy(final FloatDimensionless.Rel v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
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
         * Calculate the multiplication of FloatDimensionless and FloatAnglePlane, which results in a FloatAnglePlane scalar.
         * @param v FloatDimensionless scalar
         * @return FloatAnglePlane scalar as a multiplication of FloatDimensionless and FloatAnglePlane
         */
        public final FloatAnglePlane.Rel multiplyBy(final FloatAnglePlane.Rel v)
        {
            return new FloatAnglePlane.Rel(this.si * v.si, AnglePlaneUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatDimensionless and FloatAngleSlope, which results in a FloatAngleSlope scalar.
         * @param v FloatDimensionless scalar
         * @return FloatAngleSlope scalar as a multiplication of FloatDimensionless and FloatAngleSlope
         */
        public final FloatAngleSlope.Rel multiplyBy(final FloatAngleSlope.Rel v)
        {
            return new FloatAngleSlope.Rel(this.si * v.si, AngleSlopeUnit.SI);
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
        public final FloatDimensionless.Rel multiplyBy(final FloatDimensionless.Rel v)
        {
            return new FloatDimensionless.Rel(this.si * v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatDimensionless and FloatElectricalCharge, which results in a FloatElectricalCharge scalar.
         * @param v FloatDimensionless scalar
         * @return FloatElectricalCharge scalar as a multiplication of FloatDimensionless and FloatElectricalCharge
         */
        public final FloatElectricalCharge multiplyBy(final FloatElectricalCharge v)
        {
            return new FloatElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatDimensionless and FloatElectricalCurrent, which results in a FloatElectricalCurrent scalar.
         * @param v FloatDimensionless scalar
         * @return FloatElectricalCurrent scalar as a multiplication of FloatDimensionless and FloatElectricalCurrent
         */
        public final FloatElectricalCurrent multiplyBy(final FloatElectricalCurrent v)
        {
            return new FloatElectricalCurrent(this.si * v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatDimensionless and FloatElectricalPotential, which results in a FloatElectricalPotential scalar.
         * @param v FloatDimensionless scalar
         * @return FloatElectricalPotential scalar as a multiplication of FloatDimensionless and FloatElectricalPotential
         */
        public final FloatElectricalPotential multiplyBy(final FloatElectricalPotential v)
        {
            return new FloatElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatDimensionless and FloatElectricalResistance, which results in a FloatElectricalResistance scalar.
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
        public final FloatLength.Rel multiplyBy(final FloatLength.Rel v)
        {
            return new FloatLength.Rel(this.si * v.si, LengthUnit.SI);
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
         * Calculate the multiplication of FloatDimensionless and FloatMoneyPerEnergy, which results in a FloatMoneyPerEnergy scalar.
         * @param v FloatDimensionless scalar
         * @return FloatMoneyPerEnergy scalar as a multiplication of FloatDimensionless and FloatMoneyPerEnergy
         */
        public final FloatMoneyPerEnergy multiplyBy(final FloatMoneyPerEnergy v)
        {
            return new FloatMoneyPerEnergy(this.si * v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
        }

        /**
         * Calculate the multiplication of FloatDimensionless and FloatMoneyPerLength, which results in a FloatMoneyPerLength scalar.
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
         * Calculate the multiplication of FloatDimensionless and FloatMoneyPerVolume, which results in a FloatMoneyPerVolume scalar.
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
        public final FloatTemperature.Rel multiplyBy(final FloatTemperature.Rel v)
        {
            return new FloatTemperature.Rel(this.si * v.si, TemperatureUnit.SI);
        }

        /**
         * Calculate the multiplication of FloatDimensionless and FloatTime, which results in a FloatTime scalar.
         * @param v FloatDimensionless scalar
         * @return FloatTime scalar as a multiplication of FloatDimensionless and FloatTime
         */
        public final FloatTime.Rel multiplyBy(final FloatTime.Rel v)
        {
            return new FloatTime.Rel(this.si * v.si, TimeUnit.SI);
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
        public final FloatLinearDensity divideBy(final FloatLength.Rel v)
        {
            return new FloatLinearDensity(this.si / v.si, LinearDensityUnit.SI);
        }

        /**
         * Calculate the division of FloatDimensionless and FloatLinearDensity, which results in a FloatLength scalar.
         * @param v FloatDimensionless scalar
         * @return FloatLength scalar as a division of FloatDimensionless and FloatLinearDensity
         */
        public final FloatLength.Rel divideBy(final FloatLinearDensity v)
        {
            return new FloatLength.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the division of FloatDimensionless and FloatTime, which results in a FloatFrequency scalar.
         * @param v FloatDimensionless scalar
         * @return FloatFrequency scalar as a division of FloatDimensionless and FloatTime
         */
        public final FloatFrequency divideBy(final FloatTime.Rel v)
        {
            return new FloatFrequency(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of FloatDimensionless and FloatFrequency, which results in a FloatTime scalar.
         * @param v FloatDimensionless scalar
         * @return FloatTime scalar as a division of FloatDimensionless and FloatFrequency
         */
        public final FloatTime.Rel divideBy(final FloatFrequency v)
        {
            return new FloatTime.Rel(this.si / v.si, TimeUnit.SI);
        }


    }

    /**
     * Easy access methods for the Dimensionless FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;DimensionlessUnit&gt; value = new FloatScalar.Abs&lt;DimensionlessUnit&gt;(100.0, DimensionlessUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatDimensionless.Abs value = new FloatDimensionless.Abs(100.0, DimensionlessUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Abs extends FloatScalar.Abs<DimensionlessUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatDimensionless.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final DimensionlessUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatDimensionless.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final DimensionlessUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatDimensionless.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<DimensionlessUnit> value)
        {
            super(value);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatDimensionless.Abs interpolate(final FloatDimensionless.Abs zero, final FloatDimensionless.Abs one, final float ratio)
        {
            return new FloatDimensionless.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatDimensionless.Abs interpolate(final FloatDimensionless.Abs zero, final FloatDimensionless.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs abs()
        {
            return new FloatDimensionless.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs acos()
        {
            return new FloatDimensionless.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs asin()
        {
            return new FloatDimensionless.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs atan()
        {
            return new FloatDimensionless.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs cbrt()
        {
            return new FloatDimensionless.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs ceil()
        {
            return new FloatDimensionless.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs cos()
        {
            return new FloatDimensionless.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs cosh()
        {
            return new FloatDimensionless.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs exp()
        {
            return new FloatDimensionless.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs expm1()
        {
            return new FloatDimensionless.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs floor()
        {
            return new FloatDimensionless.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs log()
        {
            return new FloatDimensionless.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs log10()
        {
            return new FloatDimensionless.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs log1p()
        {
            return new FloatDimensionless.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs rint()
        {
            return new FloatDimensionless.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs round()
        {
            return new FloatDimensionless.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs signum()
        {
            return new FloatDimensionless.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs sin()
        {
            return new FloatDimensionless.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs sinh()
        {
            return new FloatDimensionless.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs sqrt()
        {
            return new FloatDimensionless.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs tan()
        {
            return new FloatDimensionless.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs tanh()
        {
            return new FloatDimensionless.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs inv()
        {
            return new FloatDimensionless.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs toDegrees()
        {
            return new FloatDimensionless.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs toRadians()
        {
            return new FloatDimensionless.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatDimensionless.Abs pow(final double x)
        {
            return new FloatDimensionless.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatDimensionless.Abs plus(final FloatDimensionless.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatDimensionless.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FloatDimensionless.Abs(this.si + v.si, DimensionlessUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatDimensionless.Rel minus(final FloatDimensionless.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatDimensionless.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FloatDimensionless.Rel(this.si - v.si, DimensionlessUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FloatDimensionless.Abs minus(final FloatDimensionless.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FloatDimensionless.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new FloatDimensionless.Abs(this.si - v.si, DimensionlessUnit.SI);
        }

        /** 
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute dimensionless scalar.
         */
        public final FloatDimensionless.Rel toRel()
        {
            return new FloatDimensionless.Rel(getInUnit(), getUnit());
        }
        
    }
}