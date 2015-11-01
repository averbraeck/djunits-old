package org.djunits.value.vdouble.scalar;

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
 * Easy access methods for the Dimensionless DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;DimensionlessUnit&gt; value = new DoubleScalar.Rel&lt;DimensionlessUnit&gt;(100.0,
 * DimensionlessUnit.SI);</i><br>
 * we can now write <br>
 * <i>Dimensionless value = new Dimensionless(100.0, DimensionlessUnit.SI);</i><br>
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
public class Dimensionless extends TypedDoubleScalarRel<DimensionlessUnit, Dimensionless>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct Dimensionless scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public Dimensionless(final double value, final DimensionlessUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Dimensionless scalar.
     * @param value Scalar from which to construct this instance
     */
    public Dimensionless(final Dimensionless value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final Dimensionless instantiateTypeRel(final double value, final DimensionlessUnit unit)
    {
        return new Dimensionless(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Dimensionless interpolate(final Dimensionless zero, final Dimensionless one, final double ratio)
    {
        return new Dimensionless(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of Dimensionless and Dimensionless, which results in a Dimensionless scalar.
     * @param v Dimensionless scalar
     * @return Dimensionless scalar as a division of Dimensionless and Dimensionless
     */
    public final Dimensionless divideBy(final Dimensionless v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Acceleration, which results in a Acceleration scalar.
     * @param v Dimensionless scalar
     * @return Acceleration scalar as a multiplication of Dimensionless and Acceleration
     */
    public final Acceleration multiplyBy(final Acceleration v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Angle, which results in a Angle scalar.
     * @param v Dimensionless scalar
     * @return Angle scalar as a multiplication of Dimensionless and Angle
     */
    public final Angle.Rel multiplyBy(final Angle.Rel v)
    {
        return new Angle.Rel(this.si * v.si, AngleUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and AngleSolid, which results in a AngleSolid scalar.
     * @param v Dimensionless scalar
     * @return AngleSolid scalar as a multiplication of Dimensionless and AngleSolid
     */
    public final AngleSolid multiplyBy(final AngleSolid v)
    {
        return new AngleSolid(this.si * v.si, AngleSolidUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Area, which results in a Area scalar.
     * @param v Dimensionless scalar
     * @return Area scalar as a multiplication of Dimensionless and Area
     */
    public final Area multiplyBy(final Area v)
    {
        return new Area(this.si * v.si, AreaUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Density, which results in a Density scalar.
     * @param v Dimensionless scalar
     * @return Density scalar as a multiplication of Dimensionless and Density
     */
    public final Density multiplyBy(final Density v)
    {
        return new Density(this.si * v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Dimensionless, which results in a Dimensionless scalar.
     * @param v Dimensionless scalar
     * @return Dimensionless scalar as a multiplication of Dimensionless and Dimensionless
     */
    public final Dimensionless multiplyBy(final Dimensionless v)
    {
        return new Dimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and ElectricalCharge, which results in a ElectricalCharge scalar.
     * @param v Dimensionless scalar
     * @return ElectricalCharge scalar as a multiplication of Dimensionless and ElectricalCharge
     */
    public final ElectricalCharge multiplyBy(final ElectricalCharge v)
    {
        return new ElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and ElectricalCurrent, which results in a ElectricalCurrent scalar.
     * @param v Dimensionless scalar
     * @return ElectricalCurrent scalar as a multiplication of Dimensionless and ElectricalCurrent
     */
    public final ElectricalCurrent multiplyBy(final ElectricalCurrent v)
    {
        return new ElectricalCurrent(this.si * v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and ElectricalPotential, which results in a ElectricalPotential scalar.
     * @param v Dimensionless scalar
     * @return ElectricalPotential scalar as a multiplication of Dimensionless and ElectricalPotential
     */
    public final ElectricalPotential multiplyBy(final ElectricalPotential v)
    {
        return new ElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and ElectricalResistance, which results in a ElectricalResistance scalar.
     * @param v Dimensionless scalar
     * @return ElectricalResistance scalar as a multiplication of Dimensionless and ElectricalResistance
     */
    public final ElectricalResistance multiplyBy(final ElectricalResistance v)
    {
        return new ElectricalResistance(this.si * v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Energy, which results in a Energy scalar.
     * @param v Dimensionless scalar
     * @return Energy scalar as a multiplication of Dimensionless and Energy
     */
    public final Energy multiplyBy(final Energy v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and FlowMass, which results in a FlowMass scalar.
     * @param v Dimensionless scalar
     * @return FlowMass scalar as a multiplication of Dimensionless and FlowMass
     */
    public final FlowMass multiplyBy(final FlowMass v)
    {
        return new FlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and FlowVolume, which results in a FlowVolume scalar.
     * @param v Dimensionless scalar
     * @return FlowVolume scalar as a multiplication of Dimensionless and FlowVolume
     */
    public final FlowVolume multiplyBy(final FlowVolume v)
    {
        return new FlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Force, which results in a Force scalar.
     * @param v Dimensionless scalar
     * @return Force scalar as a multiplication of Dimensionless and Force
     */
    public final Force multiplyBy(final Force v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Frequency, which results in a Frequency scalar.
     * @param v Dimensionless scalar
     * @return Frequency scalar as a multiplication of Dimensionless and Frequency
     */
    public final Frequency multiplyBy(final Frequency v)
    {
        return new Frequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Length, which results in a Length scalar.
     * @param v Dimensionless scalar
     * @return Length scalar as a multiplication of Dimensionless and Length
     */
    public final Length.Rel multiplyBy(final Length.Rel v)
    {
        return new Length.Rel(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and LinearDensity, which results in a LinearDensity scalar.
     * @param v Dimensionless scalar
     * @return LinearDensity scalar as a multiplication of Dimensionless and LinearDensity
     */
    public final LinearDensity multiplyBy(final LinearDensity v)
    {
        return new LinearDensity(this.si * v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Mass, which results in a Mass scalar.
     * @param v Dimensionless scalar
     * @return Mass scalar as a multiplication of Dimensionless and Mass
     */
    public final Mass multiplyBy(final Mass v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Money, which results in a Money scalar.
     * @param v Dimensionless scalar
     * @return Money scalar as a multiplication of Dimensionless and Money
     */
    public final Money multiplyBy(final Money v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerArea, which results in a MoneyPerArea scalar.
     * @param v Dimensionless scalar
     * @return MoneyPerArea scalar as a multiplication of Dimensionless and MoneyPerArea
     */
    public final MoneyPerArea multiplyBy(final MoneyPerArea v)
    {
        return new MoneyPerArea(this.si * v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerEnergy, which results in a MoneyPerEnergy scalar.
     * @param v Dimensionless scalar
     * @return MoneyPerEnergy scalar as a multiplication of Dimensionless and MoneyPerEnergy
     */
    public final MoneyPerEnergy multiplyBy(final MoneyPerEnergy v)
    {
        return new MoneyPerEnergy(this.si * v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerLength, which results in a MoneyPerLength scalar.
     * @param v Dimensionless scalar
     * @return MoneyPerLength scalar as a multiplication of Dimensionless and MoneyPerLength
     */
    public final MoneyPerLength multiplyBy(final MoneyPerLength v)
    {
        return new MoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerMass, which results in a MoneyPerMass scalar.
     * @param v Dimensionless scalar
     * @return MoneyPerMass scalar as a multiplication of Dimensionless and MoneyPerMass
     */
    public final MoneyPerMass multiplyBy(final MoneyPerMass v)
    {
        return new MoneyPerMass(this.si * v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerTime, which results in a MoneyPerTime scalar.
     * @param v Dimensionless scalar
     * @return MoneyPerTime scalar as a multiplication of Dimensionless and MoneyPerTime
     */
    public final MoneyPerTime multiplyBy(final MoneyPerTime v)
    {
        return new MoneyPerTime(this.si * v.si, MoneyPerTimeUnit.getStandardMoneyPerTimeUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerVolume, which results in a MoneyPerVolume scalar.
     * @param v Dimensionless scalar
     * @return MoneyPerVolume scalar as a multiplication of Dimensionless and MoneyPerVolume
     */
    public final MoneyPerVolume multiplyBy(final MoneyPerVolume v)
    {
        return new MoneyPerVolume(this.si * v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and Power, which results in a Power scalar.
     * @param v Dimensionless scalar
     * @return Power scalar as a multiplication of Dimensionless and Power
     */
    public final Power multiplyBy(final Power v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Pressure, which results in a Pressure scalar.
     * @param v Dimensionless scalar
     * @return Pressure scalar as a multiplication of Dimensionless and Pressure
     */
    public final Pressure multiplyBy(final Pressure v)
    {
        return new Pressure(this.si * v.si, PressureUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Speed, which results in a Speed scalar.
     * @param v Dimensionless scalar
     * @return Speed scalar as a multiplication of Dimensionless and Speed
     */
    public final Speed multiplyBy(final Speed v)
    {
        return new Speed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Temperature, which results in a Temperature scalar.
     * @param v Dimensionless scalar
     * @return Temperature scalar as a multiplication of Dimensionless and Temperature
     */
    public final Temperature.Rel multiplyBy(final Temperature.Rel v)
    {
        return new Temperature.Rel(this.si * v.si, TemperatureUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Time, which results in a Time scalar.
     * @param v Dimensionless scalar
     * @return Time scalar as a multiplication of Dimensionless and Time
     */
    public final Time.Rel multiplyBy(final Time.Rel v)
    {
        return new Time.Rel(this.si * v.si, TimeUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Torque, which results in a Torque scalar.
     * @param v Dimensionless scalar
     * @return Torque scalar as a multiplication of Dimensionless and Torque
     */
    public final Torque multiplyBy(final Torque v)
    {
        return new Torque(this.si * v.si, TorqueUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Volume, which results in a Volume scalar.
     * @param v Dimensionless scalar
     * @return Volume scalar as a multiplication of Dimensionless and Volume
     */
    public final Volume multiplyBy(final Volume v)
    {
        return new Volume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of Dimensionless and Length, which results in a LinearDensity scalar.
     * @param v Dimensionless scalar
     * @return LinearDensity scalar as a division of Dimensionless and Length
     */
    public final LinearDensity divideBy(final Length.Rel v)
    {
        return new LinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the division of Dimensionless and LinearDensity, which results in a Length scalar.
     * @param v Dimensionless scalar
     * @return Length scalar as a division of Dimensionless and LinearDensity
     */
    public final Length.Rel divideBy(final LinearDensity v)
    {
        return new Length.Rel(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Dimensionless and Time, which results in a Frequency scalar.
     * @param v Dimensionless scalar
     * @return Frequency scalar as a division of Dimensionless and Time
     */
    public final Frequency divideBy(final Time.Rel v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of Dimensionless and Frequency, which results in a Time scalar.
     * @param v Dimensionless scalar
     * @return Time scalar as a division of Dimensionless and Frequency
     */
    public final Time.Rel divideBy(final Frequency v)
    {
        return new Time.Rel(this.si / v.si, TimeUnit.SI);
    }

}
