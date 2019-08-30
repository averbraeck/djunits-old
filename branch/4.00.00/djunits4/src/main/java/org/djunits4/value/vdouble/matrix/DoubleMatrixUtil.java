package org.djunits4.value.vdouble.matrix;

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
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;

/**
 * Class to instantiate any DoubleMatrix based on the provided unit.
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
    @SuppressWarnings({"unchecked", "checkstyle:needbraces"})
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
    @SuppressWarnings({"unchecked", "checkstyle:needbraces", "cast", "rawtypes"})
    public static <S extends AbstractDoubleMatrix<?, S>> S instantiateAnonymousSI(final double[][] si,
            final Unit<?> displayUnit, final StorageType storageType) throws ValueException
    {
        S value;
        value = (S) instantiateAnonymous(si, displayUnit.getStandardUnit(), storageType);
        ((AbstractDoubleMatrix) value).setDisplayUnit((Unit) displayUnit);
        return value;
    }
}
