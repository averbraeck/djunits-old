package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.AngleUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DirectionUnit;
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
import org.djunits.unit.PositionUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.TorqueUnit;
import org.djunits.unit.Unit;
import org.djunits.unit.UnitException;
import org.djunits.unit.VolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;

/**
 * Class to instantiate any FloatMatrix based on the provided unit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class FloatMatrixUtil
{
    /** */
    private FloatMatrixUtil()
    {
        // Utility class.
    }

    /**
     * Instantiate the FloatMatrix based on its unit. Rigid check on types for the compiler.
     * @param value float[][]; the value
     * @param unit U; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return an instantiated FloatMatrix with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     * @throws ValueException on vector init error
     */
    public static <U extends Unit<U>, S extends AbstractFloatMatrix<U, S>> S instantiate(final float[][] value, final U unit,
            final StorageType storageType) throws ValueException
    {
        return instantiateAnonymous(value, unit, storageType);
    }

    /**
     * Instantiate the FloatMatrix based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units. The following <u>does</u> compile:
     * 
     * <pre>
     * MoneyPerLengthUnit mlu = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.METER, "$/m", "$/m");
     * 
     * MoneyPerArea mpa = FloatMatrixUtil.instantiateAnonymous(10.0, mlu);
     * </pre>
     * 
     * @param value float[][]; the value
     * @param unit Unit&lt;?&gt;; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return an instantiated FloatMatrix with the value expressed in the unit
     * @param <S> the return type
     * @throws ValueException on vector init error
     */
    @SuppressWarnings({"unchecked", "checkstyle:needbraces"})
    public static <S extends AbstractFloatMatrix<?, S>> S instantiateAnonymous(final float[][] value, final Unit<?> unit,
            final StorageType storageType) throws ValueException
    {
        if (unit instanceof DimensionlessUnit)
            return (S) new FloatDimensionlessMatrix(value, (DimensionlessUnit) unit, storageType);
        else if (unit instanceof AccelerationUnit)
            return (S) new FloatAccelerationMatrix(value, (AccelerationUnit) unit, storageType);
        else if (unit instanceof AngleSolidUnit)
            return (S) new FloatAngleSolidMatrix(value, (AngleSolidUnit) unit, storageType);
        else if (unit instanceof AngleUnit)
            return (S) new FloatAngleMatrix(value, (AngleUnit) unit, storageType);
        else if (unit instanceof DirectionUnit)
            return (S) new FloatDirectionMatrix(value, (DirectionUnit) unit, storageType);
        else if (unit instanceof AreaUnit)
            return (S) new FloatAreaMatrix(value, (AreaUnit) unit, storageType);
        else if (unit instanceof DensityUnit)
            return (S) new FloatDensityMatrix(value, (DensityUnit) unit, storageType);
        else if (unit instanceof ElectricalChargeUnit)
            return (S) new FloatElectricalChargeMatrix(value, (ElectricalChargeUnit) unit, storageType);
        else if (unit instanceof ElectricalCurrentUnit)
            return (S) new FloatElectricalCurrentMatrix(value, (ElectricalCurrentUnit) unit, storageType);
        else if (unit instanceof ElectricalPotentialUnit)
            return (S) new FloatElectricalPotentialMatrix(value, (ElectricalPotentialUnit) unit, storageType);
        else if (unit instanceof ElectricalResistanceUnit)
            return (S) new FloatElectricalResistanceMatrix(value, (ElectricalResistanceUnit) unit, storageType);
        else if (unit instanceof EnergyUnit)
            return (S) new FloatEnergyMatrix(value, (EnergyUnit) unit, storageType);
        else if (unit instanceof FlowMassUnit)
            return (S) new FloatFlowMassMatrix(value, (FlowMassUnit) unit, storageType);
        else if (unit instanceof FlowVolumeUnit)
            return (S) new FloatFlowVolumeMatrix(value, (FlowVolumeUnit) unit, storageType);
        else if (unit instanceof ForceUnit)
            return (S) new FloatForceMatrix(value, (ForceUnit) unit, storageType);
        else if (unit instanceof FrequencyUnit)
            return (S) new FloatFrequencyMatrix(value, (FrequencyUnit) unit, storageType);
        else if (unit instanceof LengthUnit)
            return (S) new FloatLengthMatrix(value, (LengthUnit) unit, storageType);
        else if (unit instanceof PositionUnit)
            return (S) new FloatPositionMatrix(value, (PositionUnit) unit, storageType);
        else if (unit instanceof LinearDensityUnit)
            return (S) new FloatLinearDensityMatrix(value, (LinearDensityUnit) unit, storageType);
        else if (unit instanceof MassUnit)
            return (S) new FloatMassMatrix(value, (MassUnit) unit, storageType);
        else if (unit instanceof PowerUnit)
            return (S) new FloatPowerMatrix(value, (PowerUnit) unit, storageType);
        else if (unit instanceof PressureUnit)
            return (S) new FloatPressureMatrix(value, (PressureUnit) unit, storageType);
        else if (unit instanceof SpeedUnit)
            return (S) new FloatSpeedMatrix(value, (SpeedUnit) unit, storageType);
        else if (unit instanceof TemperatureUnit)
            return (S) new FloatTemperatureMatrix(value, (TemperatureUnit) unit, storageType);
        else if (unit instanceof AbsoluteTemperatureUnit)
            return (S) new FloatAbsoluteTemperatureMatrix(value, (AbsoluteTemperatureUnit) unit, storageType);
        else if (unit instanceof DurationUnit)
            return (S) new FloatDurationMatrix(value, (DurationUnit) unit, storageType);
        else if (unit instanceof TimeUnit)
            return (S) new FloatTimeMatrix(value, (TimeUnit) unit, storageType);
        else if (unit instanceof TorqueUnit)
            return (S) new FloatTorqueMatrix(value, (TorqueUnit) unit, storageType);
        else if (unit instanceof VolumeUnit)
            return (S) new FloatVolumeMatrix(value, (VolumeUnit) unit, storageType);
        else if (unit instanceof MoneyUnit)
            return (S) new FloatMoneyMatrix(value, (MoneyUnit) unit, storageType);
        else if (unit instanceof MoneyPerAreaUnit)
            return (S) new FloatMoneyPerAreaMatrix(value, (MoneyPerAreaUnit) unit, storageType);
        else if (unit instanceof MoneyPerEnergyUnit)
            return (S) new FloatMoneyPerEnergyMatrix(value, (MoneyPerEnergyUnit) unit, storageType);
        else if (unit instanceof MoneyPerLengthUnit)
            return (S) new FloatMoneyPerLengthMatrix(value, (MoneyPerLengthUnit) unit, storageType);
        else if (unit instanceof MoneyPerMassUnit)
            return (S) new FloatMoneyPerMassMatrix(value, (MoneyPerMassUnit) unit, storageType);
        else if (unit instanceof MoneyPerDurationUnit)
            return (S) new FloatMoneyPerDurationMatrix(value, (MoneyPerDurationUnit) unit, storageType);
        else if (unit instanceof MoneyPerVolumeUnit)
            return (S) new FloatMoneyPerVolumeMatrix(value, (MoneyPerVolumeUnit) unit, storageType);
        else
            throw new RuntimeException(new UnitException("Cannot instantiate AbstractMatrix of unit " + unit.toString()));
    }

    /**
     * Instantiate the FloatMatrix based on its unit.
     * @param si float[][]; the value in SI units
     * @param displayUnit U; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return an instantiated FloatMatrix with the value expressed in the unit
     * @throws ValueException on vector init error
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractFloatMatrix<U, S>> S instantiateSI(final float[][] si,
            final U displayUnit, final StorageType storageType) throws ValueException
    {
        return instantiateAnonymousSI(si, displayUnit, storageType);
    }

    /**
     * Instantiate the FloatMatrix based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units. The following <u>does</u> compile:
     * 
     * <pre>
     * MoneyPerLengthUnit mlu = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.METER, "$/m", "$/m");
     * 
     * MoneyPerArea mpa = FloatMatrixUtil.instantiateAnonymousSI(10.0, mlu);
     * </pre>
     * 
     * @param si float[][]; the value in SI units
     * @param displayUnit Unit&lt;?&gt;; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return an instantiated FloatMatrix with the value expressed in the unit
     * @throws ValueException on vector init error
     * @param <S> the return type
     */
    @SuppressWarnings({"unchecked", "checkstyle:needbraces", "cast", "rawtypes"})
    public static <S extends AbstractFloatMatrix<?, S>> S instantiateAnonymousSI(final float[][] si, final Unit<?> displayUnit,
            final StorageType storageType) throws ValueException
    {
        S value;
        if (displayUnit instanceof MoneyPerAreaUnit)
        {
            AbstractFloatMatrixRel matrix =
                    (AbstractFloatMatrixRel) new FloatMoneyPerAreaMatrix(si, (MoneyPerAreaUnit) displayUnit, storageType);
            AbstractMutableFloatMatrixRel mvalue = (AbstractMutableFloatMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy((float) ((MoneyPerAreaUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerEnergyUnit)
        {
            AbstractFloatMatrixRel matrix =
                    (AbstractFloatMatrixRel) new FloatMoneyPerEnergyMatrix(si, (MoneyPerEnergyUnit) displayUnit, storageType);
            AbstractMutableFloatMatrixRel mvalue = (AbstractMutableFloatMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy((float) ((MoneyPerEnergyUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerLengthUnit)
        {
            AbstractFloatMatrixRel matrix =
                    (AbstractFloatMatrixRel) new FloatMoneyPerLengthMatrix(si, (MoneyPerLengthUnit) displayUnit, storageType);
            AbstractMutableFloatMatrixRel mvalue = (AbstractMutableFloatMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy((float) ((MoneyPerLengthUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerMassUnit)
        {
            AbstractFloatMatrixRel matrix =
                    (AbstractFloatMatrixRel) new FloatMoneyPerMassMatrix(si, (MoneyPerMassUnit) displayUnit, storageType);
            AbstractMutableFloatMatrixRel mvalue = (AbstractMutableFloatMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy((float) ((MoneyPerMassUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerDurationUnit)
        {
            AbstractFloatMatrixRel matrix = (AbstractFloatMatrixRel) new FloatMoneyPerDurationMatrix(si,
                    (MoneyPerDurationUnit) displayUnit, storageType);
            AbstractMutableFloatMatrixRel mvalue = (AbstractMutableFloatMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy((float) ((MoneyPerDurationUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerVolumeUnit)
        {
            AbstractFloatMatrixRel matrix =
                    (AbstractFloatMatrixRel) new FloatMoneyPerVolumeMatrix(si, (MoneyPerVolumeUnit) displayUnit, storageType);
            AbstractMutableFloatMatrixRel mvalue = (AbstractMutableFloatMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy((float) ((MoneyPerVolumeUnit) displayUnit).getScaleFactor()).immutable();
        }
        else
            value = (S) instantiateAnonymous(si, displayUnit.getStandardUnit(), storageType);
        ((AbstractFloatMatrix) value).setDisplayUnit((Unit) displayUnit);
        return value;
    }
}
