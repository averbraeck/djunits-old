package org.djunits.value.vdouble.vector;

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
 * Class to instantiate any DoubleVector based on the provided unit.
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
public final class DoubleVectorUtil
{
    /** */
    private DoubleVectorUtil()
    {
        // Utility class.
    }

    /**
     * Instantiate the DoubleVector based on its unit. Rigid check on types for the compiler.
     * @param value the value
     * @param unit the unit in which the value is expressed
     * @param storageType whether the vector is SPARSE or DENSE
     * @return an instantiated DoubleVector with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     * @throws ValueException on vector init error
     */
    public static <U extends Unit<U>, S extends AbstractDoubleVector<U, S>> S instantiate(final double[] value, final U unit,
            final StorageType storageType) throws ValueException
    {
        return instantiateAnonymous(value, unit, storageType);
    }

    /**
     * Instantiate the DoubleVector based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units. The following <u>does</u> compile:
     * 
     * <pre>
     * MoneyPerLengthUnit mlu = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.METER, "$/m", "$/m");
     * 
     * MoneyPerArea mpa = DoubleVectorUtil.instantiateAnonymous(10.0, mlu);
     * </pre>
     * 
     * @param value the value
     * @param unit the unit in which the value is expressed
     * @param storageType whether the vector is SPARSE or DENSE
     * @return an instantiated DoubleVector with the value expressed in the unit
     * @param <S> the return type
     * @throws ValueException on vector init error
     */
    @SuppressWarnings({ "unchecked", "checkstyle:needbraces" })
    public static <S extends AbstractDoubleVector<?, S>> S instantiateAnonymous(final double[] value, final Unit<?> unit,
            final StorageType storageType) throws ValueException
    {
        if (unit instanceof DimensionlessUnit)
            return (S) new DimensionlessVector(value, (DimensionlessUnit) unit, storageType);
        else if (unit instanceof AccelerationUnit)
            return (S) new AccelerationVector(value, (AccelerationUnit) unit, storageType);
        else if (unit instanceof AngleSolidUnit)
            return (S) new AngleSolidVector(value, (AngleSolidUnit) unit, storageType);
        else if (unit instanceof AngleUnit)
            return (S) new AngleVector(value, (AngleUnit) unit, storageType);
        else if (unit instanceof DirectionUnit)
            return (S) new DirectionVector(value, (DirectionUnit) unit, storageType);
        else if (unit instanceof AreaUnit)
            return (S) new AreaVector(value, (AreaUnit) unit, storageType);
        else if (unit instanceof DensityUnit)
            return (S) new DensityVector(value, (DensityUnit) unit, storageType);
        else if (unit instanceof ElectricalChargeUnit)
            return (S) new ElectricalChargeVector(value, (ElectricalChargeUnit) unit, storageType);
        else if (unit instanceof ElectricalCurrentUnit)
            return (S) new ElectricalCurrentVector(value, (ElectricalCurrentUnit) unit, storageType);
        else if (unit instanceof ElectricalPotentialUnit)
            return (S) new ElectricalPotentialVector(value, (ElectricalPotentialUnit) unit, storageType);
        else if (unit instanceof ElectricalResistanceUnit)
            return (S) new ElectricalResistanceVector(value, (ElectricalResistanceUnit) unit, storageType);
        else if (unit instanceof EnergyUnit)
            return (S) new EnergyVector(value, (EnergyUnit) unit, storageType);
        else if (unit instanceof FlowMassUnit)
            return (S) new FlowMassVector(value, (FlowMassUnit) unit, storageType);
        else if (unit instanceof FlowVolumeUnit)
            return (S) new FlowVolumeVector(value, (FlowVolumeUnit) unit, storageType);
        else if (unit instanceof ForceUnit)
            return (S) new ForceVector(value, (ForceUnit) unit, storageType);
        else if (unit instanceof FrequencyUnit)
            return (S) new FrequencyVector(value, (FrequencyUnit) unit, storageType);
        else if (unit instanceof LengthUnit)
            return (S) new LengthVector(value, (LengthUnit) unit, storageType);
        else if (unit instanceof PositionUnit)
            return (S) new PositionVector(value, (PositionUnit) unit, storageType);
        else if (unit instanceof LinearDensityUnit)
            return (S) new LinearDensityVector(value, (LinearDensityUnit) unit, storageType);
        else if (unit instanceof MassUnit)
            return (S) new MassVector(value, (MassUnit) unit, storageType);
        else if (unit instanceof PowerUnit)
            return (S) new PowerVector(value, (PowerUnit) unit, storageType);
        else if (unit instanceof PressureUnit)
            return (S) new PressureVector(value, (PressureUnit) unit, storageType);
        else if (unit instanceof SpeedUnit)
            return (S) new SpeedVector(value, (SpeedUnit) unit, storageType);
        else if (unit instanceof TemperatureUnit)
            return (S) new TemperatureVector(value, (TemperatureUnit) unit, storageType);
        else if (unit instanceof AbsoluteTemperatureUnit)
            return (S) new AbsoluteTemperatureVector(value, (AbsoluteTemperatureUnit) unit, storageType);
        else if (unit instanceof DurationUnit)
            return (S) new DurationVector(value, (DurationUnit) unit, storageType);
        else if (unit instanceof TimeUnit)
            return (S) new TimeVector(value, (TimeUnit) unit, storageType);
        else if (unit instanceof TorqueUnit)
            return (S) new TorqueVector(value, (TorqueUnit) unit, storageType);
        else if (unit instanceof VolumeUnit)
            return (S) new VolumeVector(value, (VolumeUnit) unit, storageType);
        else if (unit instanceof MoneyUnit)
            return (S) new MoneyVector(value, (MoneyUnit) unit, storageType);
        else if (unit instanceof MoneyPerAreaUnit)
            return (S) new MoneyPerAreaVector(value, (MoneyPerAreaUnit) unit, storageType);
        else if (unit instanceof MoneyPerEnergyUnit)
            return (S) new MoneyPerEnergyVector(value, (MoneyPerEnergyUnit) unit, storageType);
        else if (unit instanceof MoneyPerLengthUnit)
            return (S) new MoneyPerLengthVector(value, (MoneyPerLengthUnit) unit, storageType);
        else if (unit instanceof MoneyPerMassUnit)
            return (S) new MoneyPerMassVector(value, (MoneyPerMassUnit) unit, storageType);
        else if (unit instanceof MoneyPerDurationUnit)
            return (S) new MoneyPerDurationVector(value, (MoneyPerDurationUnit) unit, storageType);
        else if (unit instanceof MoneyPerVolumeUnit)
            return (S) new MoneyPerVolumeVector(value, (MoneyPerVolumeUnit) unit, storageType);
        else
            throw new RuntimeException(new UnitException("Cannot instantiate AbstractVector of unit " + unit.toString()));
    }

    /**
     * Instantiate the DoubleVector based on its unit.
     * @param si the value in SI units
     * @param displayUnit the unit in which the value is expressed
     * @param storageType whether the vector is SPARSE or DENSE
     * @return an instantiated DoubleVector with the value expressed in the unit
     * @throws ValueException on vector init error
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractDoubleVector<U, S>> S instantiateSI(final double[] si,
            final U displayUnit, final StorageType storageType) throws ValueException
    {
        return instantiateAnonymousSI(si, displayUnit, storageType);
    }

    /**
     * Instantiate the DoubleVector based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units. The following <u>does</u> compile:
     * 
     * <pre>
     * MoneyPerLengthUnit mlu = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.METER, "$/m", "$/m");
     * 
     * MoneyPerArea mpa = DoubleVectorUtil.instantiateAnonymousSI(10.0, mlu);
     * </pre>
     * 
     * @param si the value in SI units
     * @param displayUnit the unit in which the value is expressed
     * @param storageType whether the vector is SPARSE or DENSE
     * @return an instantiated DoubleVector with the value expressed in the unit
     * @throws ValueException on vector init error
     * @param <S> the return type
     */
    @SuppressWarnings({ "unchecked", "checkstyle:needbraces", "cast", "rawtypes" })
    public static <S extends AbstractDoubleVector<?, S>> S instantiateAnonymousSI(final double[] si, final Unit<?> displayUnit,
            final StorageType storageType) throws ValueException
    {
        S value;
        if (displayUnit instanceof MoneyPerAreaUnit)
        {
            value = (S) new MoneyPerAreaVector(si, (MoneyPerAreaUnit) displayUnit, storageType);
            AbstractMutableDoubleVectorRel mvalue = (AbstractMutableDoubleVectorRel) value.mutable();
            value = (S) mvalue.divideBy(((MoneyPerAreaUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerEnergyUnit)
        {
            value = (S) new MoneyPerEnergyVector(si, (MoneyPerEnergyUnit) displayUnit, storageType);
            AbstractMutableDoubleVectorRel mvalue = (AbstractMutableDoubleVectorRel) value.mutable();
            value = (S) mvalue.divideBy(((MoneyPerEnergyUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerLengthUnit)
        {
            value = (S) new MoneyPerLengthVector(si, (MoneyPerLengthUnit) displayUnit, storageType);
            AbstractMutableDoubleVectorRel mvalue = (AbstractMutableDoubleVectorRel) value.mutable();
            value = (S) mvalue.divideBy(((MoneyPerLengthUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerMassUnit)
        {
            value = (S) new MoneyPerMassVector(si, (MoneyPerMassUnit) displayUnit, storageType);
            AbstractMutableDoubleVectorRel mvalue = (AbstractMutableDoubleVectorRel) value.mutable();
            value = (S) mvalue.divideBy(((MoneyPerMassUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerDurationUnit)
        {
            value = (S) new MoneyPerDurationVector(si, (MoneyPerDurationUnit) displayUnit, storageType);
            AbstractMutableDoubleVectorRel mvalue = (AbstractMutableDoubleVectorRel) value.mutable();
            value = (S) mvalue.divideBy(((MoneyPerDurationUnit) displayUnit).getScaleFactor()).immutable();
        }
        else if (displayUnit instanceof MoneyPerVolumeUnit)
        {
            value = (S) new MoneyPerVolumeVector(si, (MoneyPerVolumeUnit) displayUnit, storageType);
            AbstractMutableDoubleVectorRel mvalue = (AbstractMutableDoubleVectorRel) value.mutable();
            value = (S) mvalue.divideBy(((MoneyPerVolumeUnit) displayUnit).getScaleFactor()).immutable();
        }
        else
            value = (S) instantiateAnonymous(si, displayUnit.getStandardUnit(), storageType);
        ((AbstractDoubleVector) value).setDisplayUnit((Unit) displayUnit);
        return value;
    }
}
