package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.AngleUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DurationUnit;
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
import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.MathFunctionsDimensionless;

/**
 * Easy access methods for the Dimensionless DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;DimensionlessUnit&gt; value = new DoubleScalar.Rel&lt;DimensionlessUnit&gt;(100.0, DimensionlessUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * Dimensionless value = new Dimensionless(100.0, DimensionlessUnit.SI);
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
public class Dimensionless extends AbstractDoubleScalarRel<DimensionlessUnit, Dimensionless>
        implements MathFunctionsDimensionless<Dimensionless>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** constant with value zero. */
    public static final Dimensionless ZERO = new Dimensionless(0.0, DimensionlessUnit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Dimensionless NaN = new Dimensionless(Double.NaN, DimensionlessUnit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Dimensionless POSITIVE_INFINITY = new Dimensionless(Double.POSITIVE_INFINITY, DimensionlessUnit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Dimensionless NEGATIVE_INFINITY = new Dimensionless(Double.NEGATIVE_INFINITY, DimensionlessUnit.SI);

    /** constant with value MAX_VALUE. */
    public static final Dimensionless POS_MAXVALUE = new Dimensionless(Double.MAX_VALUE, DimensionlessUnit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Dimensionless NEG_MAXVALUE = new Dimensionless(-Double.MAX_VALUE, DimensionlessUnit.SI);

    /**
     * Construct Dimensionless scalar.
     * @param value double; double value
     * @param unit DimensionlessUnit; unit for the double value
     */
    public Dimensionless(final double value, final DimensionlessUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Dimensionless scalar.
     * @param value Dimensionless; Scalar from which to construct this instance
     */
    public Dimensionless(final Dimensionless value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless instantiateRel(final double value, final DimensionlessUnit unit)
    {
        return new Dimensionless(value, unit);
    }

    /**
     * Construct Dimensionless scalar.
     * @param value double; double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Dimensionless createSI(final double value)
    {
        return new Dimensionless(value, DimensionlessUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero Dimensionless; the low value
     * @param one Dimensionless; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Dimensionless interpolate(final Dimensionless zero, final Dimensionless one, final double ratio)
    {
        return new Dimensionless(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 Dimensionless; the first scalar
     * @param r2 Dimensionless; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Dimensionless max(final Dimensionless r1, final Dimensionless r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 Dimensionless; the first scalar
     * @param r2 Dimensionless; the second scalar
     * @param rn Dimensionless...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static Dimensionless max(final Dimensionless r1, final Dimensionless r2, final Dimensionless... rn)
    {
        Dimensionless maxr = (r1.gt(r2)) ? r1 : r2;
        for (Dimensionless r : rn)
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
     * @param r1 Dimensionless; the first scalar
     * @param r2 Dimensionless; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Dimensionless min(final Dimensionless r1, final Dimensionless r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 Dimensionless; the first scalar
     * @param r2 Dimensionless; the second scalar
     * @param rn Dimensionless...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static Dimensionless min(final Dimensionless r1, final Dimensionless r2, final Dimensionless... rn)
    {
        Dimensionless minr = (r1.lt(r2)) ? r1 : r2;
        for (Dimensionless r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless acos()
    {
        return instantiateRel(Math.acos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless asin()
    {
        return instantiateRel(Math.asin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless atan()
    {
        return instantiateRel(Math.atan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless cbrt()
    {
        return instantiateRel(Math.cbrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless cos()
    {
        return instantiateRel(Math.cos(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless cosh()
    {
        return instantiateRel(Math.cosh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless exp()
    {
        return instantiateRel(Math.exp(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless expm1()
    {
        return instantiateRel(Math.expm1(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless log()
    {
        return instantiateRel(Math.log(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless log10()
    {
        return instantiateRel(Math.log10(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless log1p()
    {
        return instantiateRel(Math.log1p(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless pow(final double x)
    {
        return instantiateRel(Math.pow(getInUnit(), x), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless signum()
    {
        return instantiateRel(Math.signum(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless sin()
    {
        return instantiateRel(Math.sin(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless sinh()
    {
        return instantiateRel(Math.sinh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless sqrt()
    {
        return instantiateRel(Math.sqrt(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless tan()
    {
        return instantiateRel(Math.tan(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless tanh()
    {
        return instantiateRel(Math.tanh(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless inv()
    {
        return instantiateRel(1.0 / getInUnit(), getUnit());
    }

    /**
     * Calculate the division of Dimensionless and Dimensionless, which results in a Dimensionless scalar.
     * @param v Dimensionless; Dimensionless scalar
     * @return Dimensionless scalar as a division of Dimensionless and Dimensionless
     */
    public final Dimensionless divideBy(final Dimensionless v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Acceleration, which results in a Acceleration scalar.
     * @param v Acceleration; Dimensionless scalar
     * @return Acceleration scalar as a multiplication of Dimensionless and Acceleration
     */
    public final Acceleration multiplyBy(final Acceleration v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Angle, which results in a Angle scalar.
     * @param v Angle; Dimensionless scalar
     * @return Angle scalar as a multiplication of Dimensionless and Angle
     */
    public final Angle multiplyBy(final Angle v)
    {
        return new Angle(this.si * v.si, AngleUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and AngleSolid, which results in a AngleSolid scalar.
     * @param v AngleSolid; Dimensionless scalar
     * @return AngleSolid scalar as a multiplication of Dimensionless and AngleSolid
     */
    public final AngleSolid multiplyBy(final AngleSolid v)
    {
        return new AngleSolid(this.si * v.si, AngleSolidUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Area, which results in a Area scalar.
     * @param v Area; Dimensionless scalar
     * @return Area scalar as a multiplication of Dimensionless and Area
     */
    public final Area multiplyBy(final Area v)
    {
        return new Area(this.si * v.si, AreaUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Density, which results in a Density scalar.
     * @param v Density; Dimensionless scalar
     * @return Density scalar as a multiplication of Dimensionless and Density
     */
    public final Density multiplyBy(final Density v)
    {
        return new Density(this.si * v.si, DensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Dimensionless, which results in a Dimensionless scalar.
     * @param v Dimensionless; Dimensionless scalar
     * @return Dimensionless scalar as a multiplication of Dimensionless and Dimensionless
     */
    public final Dimensionless multiplyBy(final Dimensionless v)
    {
        return new Dimensionless(this.si * v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and ElectricalCharge, which results in a ElectricalCharge scalar.
     * @param v ElectricalCharge; Dimensionless scalar
     * @return ElectricalCharge scalar as a multiplication of Dimensionless and ElectricalCharge
     */
    public final ElectricalCharge multiplyBy(final ElectricalCharge v)
    {
        return new ElectricalCharge(this.si * v.si, ElectricalChargeUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and ElectricalCurrent, which results in a ElectricalCurrent scalar.
     * @param v ElectricalCurrent; Dimensionless scalar
     * @return ElectricalCurrent scalar as a multiplication of Dimensionless and ElectricalCurrent
     */
    public final ElectricalCurrent multiplyBy(final ElectricalCurrent v)
    {
        return new ElectricalCurrent(this.si * v.si, ElectricalCurrentUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and ElectricalPotential, which results in a ElectricalPotential scalar.
     * @param v ElectricalPotential; Dimensionless scalar
     * @return ElectricalPotential scalar as a multiplication of Dimensionless and ElectricalPotential
     */
    public final ElectricalPotential multiplyBy(final ElectricalPotential v)
    {
        return new ElectricalPotential(this.si * v.si, ElectricalPotentialUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and ElectricalResistance, which results in a ElectricalResistance scalar.
     * @param v ElectricalResistance; Dimensionless scalar
     * @return ElectricalResistance scalar as a multiplication of Dimensionless and ElectricalResistance
     */
    public final ElectricalResistance multiplyBy(final ElectricalResistance v)
    {
        return new ElectricalResistance(this.si * v.si, ElectricalResistanceUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Energy, which results in a Energy scalar.
     * @param v Energy; Dimensionless scalar
     * @return Energy scalar as a multiplication of Dimensionless and Energy
     */
    public final Energy multiplyBy(final Energy v)
    {
        return new Energy(this.si * v.si, EnergyUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and FlowMass, which results in a FlowMass scalar.
     * @param v FlowMass; Dimensionless scalar
     * @return FlowMass scalar as a multiplication of Dimensionless and FlowMass
     */
    public final FlowMass multiplyBy(final FlowMass v)
    {
        return new FlowMass(this.si * v.si, FlowMassUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and FlowVolume, which results in a FlowVolume scalar.
     * @param v FlowVolume; Dimensionless scalar
     * @return FlowVolume scalar as a multiplication of Dimensionless and FlowVolume
     */
    public final FlowVolume multiplyBy(final FlowVolume v)
    {
        return new FlowVolume(this.si * v.si, FlowVolumeUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Force, which results in a Force scalar.
     * @param v Force; Dimensionless scalar
     * @return Force scalar as a multiplication of Dimensionless and Force
     */
    public final Force multiplyBy(final Force v)
    {
        return new Force(this.si * v.si, ForceUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Frequency, which results in a Frequency scalar.
     * @param v Frequency; Dimensionless scalar
     * @return Frequency scalar as a multiplication of Dimensionless and Frequency
     */
    public final Frequency multiplyBy(final Frequency v)
    {
        return new Frequency(this.si * v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Length, which results in a Length scalar.
     * @param v Length; Dimensionless scalar
     * @return Length scalar as a multiplication of Dimensionless and Length
     */
    public final Length multiplyBy(final Length v)
    {
        return new Length(this.si * v.si, LengthUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and LinearDensity, which results in a LinearDensity scalar.
     * @param v LinearDensity; Dimensionless scalar
     * @return LinearDensity scalar as a multiplication of Dimensionless and LinearDensity
     */
    public final LinearDensity multiplyBy(final LinearDensity v)
    {
        return new LinearDensity(this.si * v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Mass, which results in a Mass scalar.
     * @param v Mass; Dimensionless scalar
     * @return Mass scalar as a multiplication of Dimensionless and Mass
     */
    public final Mass multiplyBy(final Mass v)
    {
        return new Mass(this.si * v.si, MassUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Money, which results in a Money scalar.
     * @param v Money; Dimensionless scalar
     * @return Money scalar as a multiplication of Dimensionless and Money
     */
    public final Money multiplyBy(final Money v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerArea, which results in a MoneyPerArea scalar.
     * @param v MoneyPerArea; Dimensionless scalar
     * @return MoneyPerArea scalar as a multiplication of Dimensionless and MoneyPerArea
     */
    public final MoneyPerArea multiplyBy(final MoneyPerArea v)
    {
        return new MoneyPerArea(this.si * v.si, MoneyPerAreaUnit.getStandardMoneyPerAreaUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerEnergy, which results in a MoneyPerEnergy scalar.
     * @param v MoneyPerEnergy; Dimensionless scalar
     * @return MoneyPerEnergy scalar as a multiplication of Dimensionless and MoneyPerEnergy
     */
    public final MoneyPerEnergy multiplyBy(final MoneyPerEnergy v)
    {
        return new MoneyPerEnergy(this.si * v.si, MoneyPerEnergyUnit.getStandardMoneyPerEnergyUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerLength, which results in a MoneyPerLength scalar.
     * @param v MoneyPerLength; Dimensionless scalar
     * @return MoneyPerLength scalar as a multiplication of Dimensionless and MoneyPerLength
     */
    public final MoneyPerLength multiplyBy(final MoneyPerLength v)
    {
        return new MoneyPerLength(this.si * v.si, MoneyPerLengthUnit.getStandardMoneyPerLengthUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerMass, which results in a MoneyPerMass scalar.
     * @param v MoneyPerMass; Dimensionless scalar
     * @return MoneyPerMass scalar as a multiplication of Dimensionless and MoneyPerMass
     */
    public final MoneyPerMass multiplyBy(final MoneyPerMass v)
    {
        return new MoneyPerMass(this.si * v.si, MoneyPerMassUnit.getStandardMoneyPerMassUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerDuration, which results in a MoneyPerDuration scalar.
     * @param v MoneyPerDuration; Dimensionless scalar
     * @return MoneyPerDuration scalar as a multiplication of Dimensionless and MoneyPerDuration
     */
    public final MoneyPerDuration multiplyBy(final MoneyPerDuration v)
    {
        return new MoneyPerDuration(this.si * v.si, MoneyPerDurationUnit.getStandardMoneyPerDurationUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and MoneyPerVolume, which results in a MoneyPerVolume scalar.
     * @param v MoneyPerVolume; Dimensionless scalar
     * @return MoneyPerVolume scalar as a multiplication of Dimensionless and MoneyPerVolume
     */
    public final MoneyPerVolume multiplyBy(final MoneyPerVolume v)
    {
        return new MoneyPerVolume(this.si * v.si, MoneyPerVolumeUnit.getStandardMoneyPerVolumeUnit());
    }

    /**
     * Calculate the multiplication of Dimensionless and Power, which results in a Power scalar.
     * @param v Power; Dimensionless scalar
     * @return Power scalar as a multiplication of Dimensionless and Power
     */
    public final Power multiplyBy(final Power v)
    {
        return new Power(this.si * v.si, PowerUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Pressure, which results in a Pressure scalar.
     * @param v Pressure; Dimensionless scalar
     * @return Pressure scalar as a multiplication of Dimensionless and Pressure
     */
    public final Pressure multiplyBy(final Pressure v)
    {
        return new Pressure(this.si * v.si, PressureUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Speed, which results in a Speed scalar.
     * @param v Speed; Dimensionless scalar
     * @return Speed scalar as a multiplication of Dimensionless and Speed
     */
    public final Speed multiplyBy(final Speed v)
    {
        return new Speed(this.si * v.si, SpeedUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Temperature, which results in a Temperature scalar.
     * @param v Temperature; Dimensionless scalar
     * @return Temperature scalar as a multiplication of Dimensionless and Temperature
     */
    public final Temperature multiplyBy(final Temperature v)
    {
        return new Temperature(this.si * v.si, TemperatureUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Duration, which results in a Duration scalar.
     * @param v Duration; Dimensionless scalar
     * @return Duration scalar as a multiplication of Dimensionless and Duration
     */
    public final Duration multiplyBy(final Duration v)
    {
        return new Duration(this.si * v.si, DurationUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Torque, which results in a Torque scalar.
     * @param v Torque; Dimensionless scalar
     * @return Torque scalar as a multiplication of Dimensionless and Torque
     */
    public final Torque multiplyBy(final Torque v)
    {
        return new Torque(this.si * v.si, TorqueUnit.SI);
    }

    /**
     * Calculate the multiplication of Dimensionless and Volume, which results in a Volume scalar.
     * @param v Volume; Dimensionless scalar
     * @return Volume scalar as a multiplication of Dimensionless and Volume
     */
    public final Volume multiplyBy(final Volume v)
    {
        return new Volume(this.si * v.si, VolumeUnit.SI);
    }

    /**
     * Calculate the division of Dimensionless and Length, which results in a LinearDensity scalar.
     * @param v Length; Dimensionless scalar
     * @return LinearDensity scalar as a division of Dimensionless and Length
     */
    public final LinearDensity divideBy(final Length v)
    {
        return new LinearDensity(this.si / v.si, LinearDensityUnit.SI);
    }

    /**
     * Calculate the division of Dimensionless and LinearDensity, which results in a Length scalar.
     * @param v LinearDensity; Dimensionless scalar
     * @return Length scalar as a division of Dimensionless and LinearDensity
     */
    public final Length divideBy(final LinearDensity v)
    {
        return new Length(this.si / v.si, LengthUnit.SI);
    }

    /**
     * Calculate the division of Dimensionless and Duration, which results in a Frequency scalar.
     * @param v Duration; Dimensionless scalar
     * @return Frequency scalar as a division of Dimensionless and Duration
     */
    public final Frequency divideBy(final Duration v)
    {
        return new Frequency(this.si / v.si, FrequencyUnit.SI);
    }

    /**
     * Calculate the division of Dimensionless and Frequency, which results in a Duration scalar.
     * @param v Frequency; Dimensionless scalar
     * @return Duration scalar as a division of Dimensionless and Frequency
     */
    public final Duration divideBy(final Frequency v)
    {
        return new Duration(this.si / v.si, DurationUnit.SI);
    }

}
