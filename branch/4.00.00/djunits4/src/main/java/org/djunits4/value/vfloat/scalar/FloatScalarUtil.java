package org.djunits4.value.vfloat.scalar;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.AccelerationUnit;
import org.djunits4.unit.AngleSolidUnit;
import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.DensityUnit;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.ElectricalChargeUnit;
import org.djunits4.unit.ElectricalCurrentUnit;
import org.djunits4.unit.ElectricalPotentialUnit;
import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.unit.EnergyUnit;
import org.djunits4.unit.FlowMassUnit;
import org.djunits4.unit.FlowVolumeUnit;
import org.djunits4.unit.ForceUnit;
import org.djunits4.unit.FrequencyUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.LinearDensityUnit;
import org.djunits4.unit.MassUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.unit.PowerUnit;
import org.djunits4.unit.PressureUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.unit.TorqueUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.UnitException;
import org.djunits4.unit.VolumeUnit;

/**
 * Class to instantiate any FloatScalar based on the provided unit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 11, 2018 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class FloatScalarUtil
{
    /** */
    private FloatScalarUtil()
    {
        // Utility class.
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Rigid check on types for the compiler.
     * @param value float; the value
     * @param unit U; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>> S instantiate(final float value, final U unit)
    {
        return instantiateAnonymous(value, unit);
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units. The following <u>does</u> compile:
     * 
     * <pre>
     * MoneyPerLengthUnit mlu = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.METER, "$/m", "$/m");
     * 
     * MoneyPerArea mpa = DoubleScalarUtil.instantiateAnonymous(10.0, mlu);
     * </pre>
     * 
     * @param value float; the value
     * @param unit Unit&lt;?&gt;; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <S> the return type
     */
    @SuppressWarnings({"unchecked", "checkstyle:needbraces"})
    public static <S extends AbstractFloatScalar<?, S>> S instantiateAnonymous(final float value, final Unit<?> unit)
    {
        if (unit instanceof DimensionlessUnit)
            return (S) new FloatDimensionless(value, (DimensionlessUnit) unit);
        else if (unit instanceof AccelerationUnit)
            return (S) new FloatAcceleration(value, (AccelerationUnit) unit);
        else if (unit instanceof AngleSolidUnit)
            return (S) new FloatAngleSolid(value, (AngleSolidUnit) unit);
        else if (unit instanceof AngleUnit)
            return (S) new FloatAngle(value, (AngleUnit) unit);
        else if (unit instanceof DirectionUnit)
            return (S) new FloatDirection(value, (DirectionUnit) unit);
        else if (unit instanceof AreaUnit)
            return (S) new FloatArea(value, (AreaUnit) unit);
        else if (unit instanceof DensityUnit)
            return (S) new FloatDensity(value, (DensityUnit) unit);
        else if (unit instanceof ElectricalChargeUnit)
            return (S) new FloatElectricalCharge(value, (ElectricalChargeUnit) unit);
        else if (unit instanceof ElectricalCurrentUnit)
            return (S) new FloatElectricalCurrent(value, (ElectricalCurrentUnit) unit);
        else if (unit instanceof ElectricalPotentialUnit)
            return (S) new FloatElectricalPotential(value, (ElectricalPotentialUnit) unit);
        else if (unit instanceof ElectricalResistanceUnit)
            return (S) new FloatElectricalResistance(value, (ElectricalResistanceUnit) unit);
        else if (unit instanceof EnergyUnit)
            return (S) new FloatEnergy(value, (EnergyUnit) unit);
        else if (unit instanceof FlowMassUnit)
            return (S) new FloatFlowMass(value, (FlowMassUnit) unit);
        else if (unit instanceof FlowVolumeUnit)
            return (S) new FloatFlowVolume(value, (FlowVolumeUnit) unit);
        else if (unit instanceof ForceUnit)
            return (S) new FloatForce(value, (ForceUnit) unit);
        else if (unit instanceof FrequencyUnit)
            return (S) new FloatFrequency(value, (FrequencyUnit) unit);
        else if (unit instanceof LengthUnit)
            return (S) new FloatLength(value, (LengthUnit) unit);
        else if (unit instanceof PositionUnit)
            return (S) new FloatPosition(value, (PositionUnit) unit);
        else if (unit instanceof LinearDensityUnit)
            return (S) new FloatLinearDensity(value, (LinearDensityUnit) unit);
        else if (unit instanceof MassUnit)
            return (S) new FloatMass(value, (MassUnit) unit);
        else if (unit instanceof PowerUnit)
            return (S) new FloatPower(value, (PowerUnit) unit);
        else if (unit instanceof PressureUnit)
            return (S) new FloatPressure(value, (PressureUnit) unit);
        else if (unit instanceof SpeedUnit)
            return (S) new FloatSpeed(value, (SpeedUnit) unit);
        else if (unit instanceof TemperatureUnit)
            return (S) new FloatTemperature(value, (TemperatureUnit) unit);
        else if (unit instanceof AbsoluteTemperatureUnit)
            return (S) new FloatAbsoluteTemperature(value, (AbsoluteTemperatureUnit) unit);
        else if (unit instanceof DurationUnit)
            return (S) new FloatDuration(value, (DurationUnit) unit);
        else if (unit instanceof TimeUnit)
            return (S) new FloatTime(value, (TimeUnit) unit);
        else if (unit instanceof TorqueUnit)
            return (S) new FloatTorque(value, (TorqueUnit) unit);
        else if (unit instanceof VolumeUnit)
            return (S) new FloatVolume(value, (VolumeUnit) unit);
        else
            throw new RuntimeException(new UnitException("Cannot instantiate AbstractScalar of unit " + unit.toString()));
    }

    /**
     * Instantiate the DoubleScalar based on its unit.
     * @param si float; the value in SI units
     * @param displayUnit U; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>> S instantiateSI(final float si, final U displayUnit)
    {
        return instantiateAnonymousSI(si, displayUnit);
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units. The following <u>does</u> compile:
     * 
     * <pre>
     * MoneyPerLengthUnit mlu = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.METER, "$/m", "$/m");
     * 
     * MoneyPerArea mpa = DoubleScalarUtil.instantiateAnonymousSI(10.0, mlu);
     * </pre>
     * 
     * @param si float; the value in SI units
     * @param displayUnit Unit&lt;?&gt;; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <S> the return type
     */
    @SuppressWarnings({"unchecked", "checkstyle:needbraces", "cast", "rawtypes"})
    public static <S extends AbstractFloatScalar<?, S>> S instantiateAnonymousSI(final float si, final Unit<?> displayUnit)
    {
        S value;
        value = (S) instantiateAnonymous(si, displayUnit.getStandardUnit());
        ((AbstractFloatScalar) value).setDisplayUnit((Unit) displayUnit);
        return value;
    }
}
