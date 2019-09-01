package org.djunits.value.vdouble.matrix;

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
 * Class to instantiate any DoubleMatrix based on the provided unit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 11, 2018 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class DoubleMatrixUtil
{
    /** */
    private DoubleMatrixUtil()
    {
        // Utility class.
    }

    /**
     * Instantiate the DoubleMatrix based on its unit. Rigid check on types for the compiler.
     * @param value double[][]; the value
     * @param unit U; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return an instantiated DoubleMatrix with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     * @throws ValueException on vector init error
     */
    public static <U extends Unit<U>, S extends AbstractDoubleMatrix<U, S>> S instantiate(final double[][] value, final U unit,
            final StorageType storageType) throws ValueException
    {
        return instantiateAnonymous(value, unit, storageType);
    }

    /**
     * Instantiate the DoubleMatrix based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units. The following <u>does</u> compile:
     * 
     * <pre>
     * MoneyPerLengthUnit mlu = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.METER, "$/m", "$/m");
     * 
     * MoneyPerArea mpa = DoubleMatrixUtil.instantiateAnonymous(10.0, mlu);
     * </pre>
     * 
     * @param value double[][]; the value
     * @param unit Unit&lt;?&gt;; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return an instantiated DoubleMatrix with the value expressed in the unit
     * @param <S> the return type
     * @throws ValueException on vector init error
     */
    @SuppressWarnings({ "unchecked", "checkstyle:needbraces" })
    public static <S extends AbstractDoubleMatrix<?, S>> S instantiateAnonymous(final double[][] value, final Unit<?> unit,
            final StorageType storageType) throws ValueException
    {
        if (unit instanceof DimensionlessUnit)
            return (S) new DimensionlessMatrix(value, (DimensionlessUnit) unit, storageType);
        else if (unit instanceof AccelerationUnit)
            return (S) new AccelerationMatrix(value, (AccelerationUnit) unit, storageType);
        else if (unit instanceof AngleSolidUnit)
            return (S) new AngleSolidMatrix(value, (AngleSolidUnit) unit, storageType);
        else if (unit instanceof AngleUnit)
            return (S) new AngleMatrix(value, (AngleUnit) unit, storageType);
        else if (unit instanceof DirectionUnit)
            return (S) new DirectionMatrix(value, (DirectionUnit) unit, storageType);
        else if (unit instanceof AreaUnit)
            return (S) new AreaMatrix(value, (AreaUnit) unit, storageType);
        else if (unit instanceof DensityUnit)
            return (S) new DensityMatrix(value, (DensityUnit) unit, storageType);
        else if (unit instanceof ElectricalChargeUnit)
            return (S) new ElectricalChargeMatrix(value, (ElectricalChargeUnit) unit, storageType);
        else if (unit instanceof ElectricalCurrentUnit)
            return (S) new ElectricalCurrentMatrix(value, (ElectricalCurrentUnit) unit, storageType);
        else if (unit instanceof ElectricalPotentialUnit)
            return (S) new ElectricalPotentialMatrix(value, (ElectricalPotentialUnit) unit, storageType);
        else if (unit instanceof ElectricalResistanceUnit)
            return (S) new ElectricalResistanceMatrix(value, (ElectricalResistanceUnit) unit, storageType);
        else if (unit instanceof EnergyUnit)
            return (S) new EnergyMatrix(value, (EnergyUnit) unit, storageType);
        else if (unit instanceof FlowMassUnit)
            return (S) new FlowMassMatrix(value, (FlowMassUnit) unit, storageType);
        else if (unit instanceof FlowVolumeUnit)
            return (S) new FlowVolumeMatrix(value, (FlowVolumeUnit) unit, storageType);
        else if (unit instanceof ForceUnit)
            return (S) new ForceMatrix(value, (ForceUnit) unit, storageType);
        else if (unit instanceof FrequencyUnit)
            return (S) new FrequencyMatrix(value, (FrequencyUnit) unit, storageType);
        else if (unit instanceof LengthUnit)
            return (S) new LengthMatrix(value, (LengthUnit) unit, storageType);
        else if (unit instanceof PositionUnit)
            return (S) new PositionMatrix(value, (PositionUnit) unit, storageType);
        else if (unit instanceof LinearDensityUnit)
            return (S) new LinearDensityMatrix(value, (LinearDensityUnit) unit, storageType);
        else if (unit instanceof MassUnit)
            return (S) new MassMatrix(value, (MassUnit) unit, storageType);
        else if (unit instanceof PowerUnit)
            return (S) new PowerMatrix(value, (PowerUnit) unit, storageType);
        else if (unit instanceof PressureUnit)
            return (S) new PressureMatrix(value, (PressureUnit) unit, storageType);
        else if (unit instanceof SpeedUnit)
            return (S) new SpeedMatrix(value, (SpeedUnit) unit, storageType);
        else if (unit instanceof TemperatureUnit)
            return (S) new TemperatureMatrix(value, (TemperatureUnit) unit, storageType);
        else if (unit instanceof AbsoluteTemperatureUnit)
            return (S) new AbsoluteTemperatureMatrix(value, (AbsoluteTemperatureUnit) unit, storageType);
        else if (unit instanceof DurationUnit)
            return (S) new DurationMatrix(value, (DurationUnit) unit, storageType);
        else if (unit instanceof TimeUnit)
            return (S) new TimeMatrix(value, (TimeUnit) unit, storageType);
        else if (unit instanceof TorqueUnit)
            return (S) new TorqueMatrix(value, (TorqueUnit) unit, storageType);
        else if (unit instanceof VolumeUnit)
            return (S) new VolumeMatrix(value, (VolumeUnit) unit, storageType);
        else if (unit instanceof MoneyUnit)
            return (S) new MoneyMatrix(value, (MoneyUnit) unit, storageType);
        else if (unit instanceof MoneyPerAreaUnit)
            return (S) new MoneyPerAreaMatrix(value, (MoneyPerAreaUnit) unit, storageType);
        else if (unit instanceof MoneyPerEnergyUnit)
            return (S) new MoneyPerEnergyMatrix(value, (MoneyPerEnergyUnit) unit, storageType);
        else if (unit instanceof MoneyPerLengthUnit)
            return (S) new MoneyPerLengthMatrix(value, (MoneyPerLengthUnit) unit, storageType);
        else if (unit instanceof MoneyPerMassUnit)
            return (S) new MoneyPerMassMatrix(value, (MoneyPerMassUnit) unit, storageType);
        else if (unit instanceof MoneyPerDurationUnit)
            return (S) new MoneyPerDurationMatrix(value, (MoneyPerDurationUnit) unit, storageType);
        else if (unit instanceof MoneyPerVolumeUnit)
            return (S) new MoneyPerVolumeMatrix(value, (MoneyPerVolumeUnit) unit, storageType);
        else
            throw new RuntimeException(new UnitException("Cannot instantiate AbstractMatrix of unit " + unit.toString()));
    }

    /**
     * Instantiate the DoubleMatrix based on its unit.
     * @param si double[][]; the value in SI units
     * @param displayUnit U; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return an instantiated DoubleMatrix with the value expressed in the unit
     * @throws ValueException on vector init error
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractDoubleMatrix<U, S>> S instantiateSI(final double[][] si,
            final U displayUnit, final StorageType storageType) throws ValueException
    {
        return instantiateAnonymousSI(si, displayUnit, storageType);
    }

    /**
     * Instantiate the DoubleMatrix based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units. The following <u>does</u> compile:
     * 
     * <pre>
     * MoneyPerLengthUnit mlu = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.METER, "$/m", "$/m");
     * 
     * MoneyPerArea mpa = DoubleMatrixUtil.instantiateAnonymousSI(10.0, mlu);
     * </pre>
     * 
     * @param si double[][]; the value in SI units
     * @param displayUnit Unit&lt;?&gt;; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return an instantiated DoubleMatrix with the value expressed in the unit
     * @throws ValueException on vector init error
     * @param <S> the return type
     */
    @SuppressWarnings({ "unchecked", "checkstyle:needbraces", "cast", "rawtypes" })
    public static <S extends AbstractDoubleMatrix<?, S>> S instantiateAnonymousSI(final double[][] si,
            final Unit<?> displayUnit, final StorageType storageType) throws ValueException
    {
        S value;
        if (displayUnit instanceof MoneyPerAreaUnit)
        {
            AbstractDoubleMatrixRel matrix =
                    (AbstractDoubleMatrixRel) new MoneyPerAreaMatrix(si, (MoneyPerAreaUnit) displayUnit, storageType);
            AbstractMutableDoubleMatrixRel mvalue = (AbstractMutableDoubleMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy(((MoneyPerAreaUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerEnergyUnit)
        {
            AbstractDoubleMatrixRel matrix =
                    (AbstractDoubleMatrixRel) new MoneyPerEnergyMatrix(si, (MoneyPerEnergyUnit) displayUnit, storageType);
            AbstractMutableDoubleMatrixRel mvalue = (AbstractMutableDoubleMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy(((MoneyPerEnergyUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerLengthUnit)
        {
            AbstractDoubleMatrixRel matrix =
                    (AbstractDoubleMatrixRel) new MoneyPerLengthMatrix(si, (MoneyPerLengthUnit) displayUnit, storageType);
            AbstractMutableDoubleMatrixRel mvalue = (AbstractMutableDoubleMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy(((MoneyPerLengthUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerMassUnit)
        {
            AbstractDoubleMatrixRel matrix =
                    (AbstractDoubleMatrixRel) new MoneyPerMassMatrix(si, (MoneyPerMassUnit) displayUnit, storageType);
            AbstractMutableDoubleMatrixRel mvalue = (AbstractMutableDoubleMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy(((MoneyPerMassUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerDurationUnit)
        {
            AbstractDoubleMatrixRel matrix =
                    (AbstractDoubleMatrixRel) new MoneyPerDurationMatrix(si, (MoneyPerDurationUnit) displayUnit, storageType);
            AbstractMutableDoubleMatrixRel mvalue = (AbstractMutableDoubleMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy(((MoneyPerDurationUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerVolumeUnit)
        {
            AbstractDoubleMatrixRel matrix =
                    (AbstractDoubleMatrixRel) new MoneyPerVolumeMatrix(si, (MoneyPerVolumeUnit) displayUnit, storageType);
            AbstractMutableDoubleMatrixRel mvalue = (AbstractMutableDoubleMatrixRel) matrix.mutable();
            value = (S) mvalue.divideBy(((MoneyPerVolumeUnit) displayUnit).getScaleFactor()).immutable();
        }
        else
            value = (S) instantiateAnonymous(si, displayUnit.getStandardUnit(), storageType);
        ((AbstractDoubleMatrix) value).setDisplayUnit((Unit) displayUnit);
        return value;
    }
}
