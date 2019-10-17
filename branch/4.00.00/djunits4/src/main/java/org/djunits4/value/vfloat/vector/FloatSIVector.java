package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.AbsorbedDoseUnit;
import org.djunits4.unit.AccelerationUnit;
import org.djunits4.unit.AmountOfSubstanceUnit;
import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.CatalyticActivityUnit;
import org.djunits4.unit.DensityUnit;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.ElectricalCapacitanceUnit;
import org.djunits4.unit.ElectricalChargeUnit;
import org.djunits4.unit.ElectricalConductanceUnit;
import org.djunits4.unit.ElectricalCurrentUnit;
import org.djunits4.unit.ElectricalInductanceUnit;
import org.djunits4.unit.ElectricalPotentialUnit;
import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.unit.EnergyUnit;
import org.djunits4.unit.EquivalentDoseUnit;
import org.djunits4.unit.FlowMassUnit;
import org.djunits4.unit.FlowVolumeUnit;
import org.djunits4.unit.ForceUnit;
import org.djunits4.unit.FrequencyUnit;
import org.djunits4.unit.IlluminanceUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.LinearDensityUnit;
import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.unit.LuminousIntensityUnit;
import org.djunits4.unit.MagneticFluxDensityUnit;
import org.djunits4.unit.MagneticFluxUnit;
import org.djunits4.unit.MassUnit;
import org.djunits4.unit.PowerUnit;
import org.djunits4.unit.PressureUnit;
import org.djunits4.unit.RadioActivityUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.SolidAngleUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.unit.TorqueUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.VolumeUnit;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatSIScalar;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRel;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.base.FloatVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Easy access methods for the generic Relative SI FloatVector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatSIVector extends AbstractFloatVectorRel<SIUnit, FloatSIScalar, FloatSIVector>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct a new Relative Float SIVector.
     * @param values float[]; the values of the entries in the new Relative Float SIVector
     * @param unit SIUnit; the unit of the new Relative Float SIVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return SIVector; the SIVector of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static FloatSIVector instantiate(final float[] values, final SIUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        return new FloatSIVector(FloatVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Float SIVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Float SIVector
     * @param unit SIUnit; the unit of the new Relative Float SIVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return SIVector; the SIVector of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static FloatSIVector instantiate(final List<Float> values, final SIUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        return new FloatSIVector(FloatVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Float SIVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Float SIVector
     * @param length int; the size of the vector
     * @param unit SIUnit; the unit of the new Relative Sparse Float SIVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return SIVector; the SIVector of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static FloatSIVector instantiate(final SortedMap<Integer, Float> values, final int length, final SIUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        return new FloatSIVector(FloatVectorData.instantiate(values, length, unit.getScale(), storageType), unit);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit SIUnit; the unit
     */
    public FloatSIVector(final FloatVectorData data, final SIUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatSIScalar> getScalarClass()
    {
        return FloatSIScalar.class;
    }

    /**
     * Returns an SIVector based on an array of values and the textual representation of the unit.
     * @param value float[]; the values to use
     * @param unitString String; the textual representation of the unit
     * @param storageType StorageType; the storage type to use
     * @return SIVector; the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIVector of(final float[] value, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(value, "Error parsing SIVector: value is null");
        Throw.whenNull(storageType, "Error parsing SIVector: storageType is null");
        try
        {
            return FloatSIVector.instantiate(value, Unit.getUnit(unitString), storageType);
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
    }

    /**
     * Returns an SIVector based on an array of values and the textual representation of the unit.
     * @param valueList List&lt;Float&gt;; the values to use
     * @param unitString String; the textual representation of the unit
     * @param storageType StorageType; the storage type to use
     * @return SIVector; the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIVector of(final List<Float> valueList, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(valueList, "Error parsing SIVector: valueList is null");
        Throw.whenNull(storageType, "Error parsing SIVector: storageType is null");
        try
        {
            return FloatSIVector.instantiate(valueList, Unit.getUnit(unitString), storageType);
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
    }

    /**
     * Returns an SIVector based on a (sparse) map of values and the textual representation of the unit.
     * @param valueMap SortedMap&lt;Integer, Float&gt;; the values to use
     * @param unitString String; the textual representation of the unit
     * @param length int; the size of the vector
     * @param storageType StorageType; the storage type to use
     * @return SIVector; the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIVector of(final SortedMap<Integer, Float> valueMap, final String unitString, final int length,
            final StorageType storageType)
    {
        Throw.whenNull(valueMap, "Error parsing SIVector: valueMap is null");
        Throw.whenNull(storageType, "Error parsing SIVector: storageType is null");
        try
        {
            return FloatSIVector.instantiate(valueMap, length, Unit.getUnit(unitString), storageType);
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
    }

    /** {@inheritDoc} */
    @Override
    public FloatSIVector instantiateVector(final FloatVectorData fvd, final SIUnit unit)
    {
        return new FloatSIVector(fvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatSIScalar instantiateScalarSI(final float valueSI, final SIUnit unit)
    {
        return new FloatSIScalar(valueSI, unit);
    }

    /**********************************************************************************/
    /******************************** 'CAST AS' METHODS *******************************/
    /**********************************************************************************/

    /**
     * Return the current vector transformed to a vector in the given unit. Of course the SI dimensionality has to match,
     * otherwise the vector cannot be transformed. The compiler will check the alignment between the return value and the unit.
     * @param displayUnit KU; the unit in which the vector needs to be expressed
     * @return K; the vector that has been transformed into the right vector type and unit
     */
    public final <U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>,
            V extends AbstractFloatVectorRel<U, S, V>> V as(final U displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(displayUnit.getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "SIVector with unit %s cannot be converted to a FloatVector with unit %s",
                getDisplayUnit(), displayUnit);
        V result = FloatVector.instantiate(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a absorbeddose vector.
     * @return FloatAbsorbedDoseVector; the current vector as a absorbeddose vector
     */
    public final FloatAbsorbedDoseVector asAbsorbedDose()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAbsorbedDoseVector", this.toString());
        return new FloatAbsorbedDoseVector(getData(), AbsorbedDoseUnit.SI);
    }

    /**
     * Return the current vector as a absorbeddose vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAbsorbedDoseVector; the current vector as a absorbeddose vector
     */
    public final FloatAbsorbedDoseVector asAbsorbedDose(final AbsorbedDoseUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAbsorbedDoseVector", this.toString());
        FloatAbsorbedDoseVector result = new FloatAbsorbedDoseVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a acceleration vector.
     * @return FloatAccelerationVector; the current vector as a acceleration vector
     */
    public final FloatAccelerationVector asAcceleration()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAccelerationVector", this.toString());
        return new FloatAccelerationVector(getData(), AccelerationUnit.SI);
    }

    /**
     * Return the current vector as a acceleration vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAccelerationVector; the current vector as a acceleration vector
     */
    public final FloatAccelerationVector asAcceleration(final AccelerationUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAccelerationVector", this.toString());
        FloatAccelerationVector result = new FloatAccelerationVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a amountofsubstance vector.
     * @return FloatAmountOfSubstanceVector; the current vector as a amountofsubstance vector
     */
    public final FloatAmountOfSubstanceVector asAmountOfSubstance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAmountOfSubstanceVector", this.toString());
        return new FloatAmountOfSubstanceVector(getData(), AmountOfSubstanceUnit.SI);
    }

    /**
     * Return the current vector as a amountofsubstance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAmountOfSubstanceVector; the current vector as a amountofsubstance vector
     */
    public final FloatAmountOfSubstanceVector asAmountOfSubstance(final AmountOfSubstanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAmountOfSubstanceVector", this.toString());
        FloatAmountOfSubstanceVector result = new FloatAmountOfSubstanceVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a area vector.
     * @return FloatAreaVector; the current vector as a area vector
     */
    public final FloatAreaVector asArea()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAreaVector", this.toString());
        return new FloatAreaVector(getData(), AreaUnit.SI);
    }

    /**
     * Return the current vector as a area vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAreaVector; the current vector as a area vector
     */
    public final FloatAreaVector asArea(final AreaUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAreaVector", this.toString());
        FloatAreaVector result = new FloatAreaVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a catalyticactivity vector.
     * @return FloatCatalyticActivityVector; the current vector as a catalyticactivity vector
     */
    public final FloatCatalyticActivityVector asCatalyticActivity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatCatalyticActivityVector", this.toString());
        return new FloatCatalyticActivityVector(getData(), CatalyticActivityUnit.SI);
    }

    /**
     * Return the current vector as a catalyticactivity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatCatalyticActivityVector; the current vector as a catalyticactivity vector
     */
    public final FloatCatalyticActivityVector asCatalyticActivity(final CatalyticActivityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatCatalyticActivityVector", this.toString());
        FloatCatalyticActivityVector result = new FloatCatalyticActivityVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a density vector.
     * @return FloatDensityVector; the current vector as a density vector
     */
    public final FloatDensityVector asDensity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDensityVector", this.toString());
        return new FloatDensityVector(getData(), DensityUnit.SI);
    }

    /**
     * Return the current vector as a density vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatDensityVector; the current vector as a density vector
     */
    public final FloatDensityVector asDensity(final DensityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDensityVector", this.toString());
        FloatDensityVector result = new FloatDensityVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a dimensionless vector.
     * @return FloatDimensionlessVector; the current vector as a dimensionless vector
     */
    public final FloatDimensionlessVector asDimensionless()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDimensionlessVector", this.toString());
        return new FloatDimensionlessVector(getData(), DimensionlessUnit.SI);
    }

    /**
     * Return the current vector as a dimensionless vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatDimensionlessVector; the current vector as a dimensionless vector
     */
    public final FloatDimensionlessVector asDimensionless(final DimensionlessUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDimensionlessVector", this.toString());
        FloatDimensionlessVector result = new FloatDimensionlessVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalcapacitance vector.
     * @return FloatElectricalCapacitanceVector; the current vector as a electricalcapacitance vector
     */
    public final FloatElectricalCapacitanceVector asElectricalCapacitance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCapacitanceVector", this.toString());
        return new FloatElectricalCapacitanceVector(getData(), ElectricalCapacitanceUnit.SI);
    }

    /**
     * Return the current vector as a electricalcapacitance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalCapacitanceVector; the current vector as a electricalcapacitance vector
     */
    public final FloatElectricalCapacitanceVector asElectricalCapacitance(final ElectricalCapacitanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCapacitanceVector", this.toString());
        FloatElectricalCapacitanceVector result =
                new FloatElectricalCapacitanceVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalcharge vector.
     * @return FloatElectricalChargeVector; the current vector as a electricalcharge vector
     */
    public final FloatElectricalChargeVector asElectricalCharge()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalChargeVector", this.toString());
        return new FloatElectricalChargeVector(getData(), ElectricalChargeUnit.SI);
    }

    /**
     * Return the current vector as a electricalcharge vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalChargeVector; the current vector as a electricalcharge vector
     */
    public final FloatElectricalChargeVector asElectricalCharge(final ElectricalChargeUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalChargeVector", this.toString());
        FloatElectricalChargeVector result = new FloatElectricalChargeVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalconductance vector.
     * @return FloatElectricalConductanceVector; the current vector as a electricalconductance vector
     */
    public final FloatElectricalConductanceVector asElectricalConductance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalConductanceVector", this.toString());
        return new FloatElectricalConductanceVector(getData(), ElectricalConductanceUnit.SI);
    }

    /**
     * Return the current vector as a electricalconductance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalConductanceVector; the current vector as a electricalconductance vector
     */
    public final FloatElectricalConductanceVector asElectricalConductance(final ElectricalConductanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalConductanceVector", this.toString());
        FloatElectricalConductanceVector result =
                new FloatElectricalConductanceVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalcurrent vector.
     * @return FloatElectricalCurrentVector; the current vector as a electricalcurrent vector
     */
    public final FloatElectricalCurrentVector asElectricalCurrent()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCurrentVector", this.toString());
        return new FloatElectricalCurrentVector(getData(), ElectricalCurrentUnit.SI);
    }

    /**
     * Return the current vector as a electricalcurrent vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalCurrentVector; the current vector as a electricalcurrent vector
     */
    public final FloatElectricalCurrentVector asElectricalCurrent(final ElectricalCurrentUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCurrentVector", this.toString());
        FloatElectricalCurrentVector result = new FloatElectricalCurrentVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalinductance vector.
     * @return FloatElectricalInductanceVector; the current vector as a electricalinductance vector
     */
    public final FloatElectricalInductanceVector asElectricalInductance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalInductanceVector", this.toString());
        return new FloatElectricalInductanceVector(getData(), ElectricalInductanceUnit.SI);
    }

    /**
     * Return the current vector as a electricalinductance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalInductanceVector; the current vector as a electricalinductance vector
     */
    public final FloatElectricalInductanceVector asElectricalInductance(final ElectricalInductanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalInductanceVector", this.toString());
        FloatElectricalInductanceVector result = new FloatElectricalInductanceVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalpotential vector.
     * @return FloatElectricalPotentialVector; the current vector as a electricalpotential vector
     */
    public final FloatElectricalPotentialVector asElectricalPotential()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalPotentialVector", this.toString());
        return new FloatElectricalPotentialVector(getData(), ElectricalPotentialUnit.SI);
    }

    /**
     * Return the current vector as a electricalpotential vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalPotentialVector; the current vector as a electricalpotential vector
     */
    public final FloatElectricalPotentialVector asElectricalPotential(final ElectricalPotentialUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalPotentialVector", this.toString());
        FloatElectricalPotentialVector result = new FloatElectricalPotentialVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalresistance vector.
     * @return FloatElectricalResistanceVector; the current vector as a electricalresistance vector
     */
    public final FloatElectricalResistanceVector asElectricalResistance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalResistanceVector", this.toString());
        return new FloatElectricalResistanceVector(getData(), ElectricalResistanceUnit.SI);
    }

    /**
     * Return the current vector as a electricalresistance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalResistanceVector; the current vector as a electricalresistance vector
     */
    public final FloatElectricalResistanceVector asElectricalResistance(final ElectricalResistanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalResistanceVector", this.toString());
        FloatElectricalResistanceVector result = new FloatElectricalResistanceVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a energy vector.
     * @return FloatEnergyVector; the current vector as a energy vector
     */
    public final FloatEnergyVector asEnergy()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEnergyVector", this.toString());
        return new FloatEnergyVector(getData(), EnergyUnit.SI);
    }

    /**
     * Return the current vector as a energy vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatEnergyVector; the current vector as a energy vector
     */
    public final FloatEnergyVector asEnergy(final EnergyUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEnergyVector", this.toString());
        FloatEnergyVector result = new FloatEnergyVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a equivalentdose vector.
     * @return FloatEquivalentDoseVector; the current vector as a equivalentdose vector
     */
    public final FloatEquivalentDoseVector asEquivalentDose()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEquivalentDoseVector", this.toString());
        return new FloatEquivalentDoseVector(getData(), EquivalentDoseUnit.SI);
    }

    /**
     * Return the current vector as a equivalentdose vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatEquivalentDoseVector; the current vector as a equivalentdose vector
     */
    public final FloatEquivalentDoseVector asEquivalentDose(final EquivalentDoseUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEquivalentDoseVector", this.toString());
        FloatEquivalentDoseVector result = new FloatEquivalentDoseVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a flowmass vector.
     * @return FloatFlowMassVector; the current vector as a flowmass vector
     */
    public final FloatFlowMassVector asFlowMass()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowMassVector", this.toString());
        return new FloatFlowMassVector(getData(), FlowMassUnit.SI);
    }

    /**
     * Return the current vector as a flowmass vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatFlowMassVector; the current vector as a flowmass vector
     */
    public final FloatFlowMassVector asFlowMass(final FlowMassUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowMassVector", this.toString());
        FloatFlowMassVector result = new FloatFlowMassVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a flowvolume vector.
     * @return FloatFlowVolumeVector; the current vector as a flowvolume vector
     */
    public final FloatFlowVolumeVector asFlowVolume()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowVolumeVector", this.toString());
        return new FloatFlowVolumeVector(getData(), FlowVolumeUnit.SI);
    }

    /**
     * Return the current vector as a flowvolume vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatFlowVolumeVector; the current vector as a flowvolume vector
     */
    public final FloatFlowVolumeVector asFlowVolume(final FlowVolumeUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowVolumeVector", this.toString());
        FloatFlowVolumeVector result = new FloatFlowVolumeVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a force vector.
     * @return FloatForceVector; the current vector as a force vector
     */
    public final FloatForceVector asForce()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatForceVector", this.toString());
        return new FloatForceVector(getData(), ForceUnit.SI);
    }

    /**
     * Return the current vector as a force vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatForceVector; the current vector as a force vector
     */
    public final FloatForceVector asForce(final ForceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatForceVector", this.toString());
        FloatForceVector result = new FloatForceVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a frequency vector.
     * @return FloatFrequencyVector; the current vector as a frequency vector
     */
    public final FloatFrequencyVector asFrequency()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFrequencyVector", this.toString());
        return new FloatFrequencyVector(getData(), FrequencyUnit.SI);
    }

    /**
     * Return the current vector as a frequency vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatFrequencyVector; the current vector as a frequency vector
     */
    public final FloatFrequencyVector asFrequency(final FrequencyUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFrequencyVector", this.toString());
        FloatFrequencyVector result = new FloatFrequencyVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a illuminance vector.
     * @return FloatIlluminanceVector; the current vector as a illuminance vector
     */
    public final FloatIlluminanceVector asIlluminance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatIlluminanceVector", this.toString());
        return new FloatIlluminanceVector(getData(), IlluminanceUnit.SI);
    }

    /**
     * Return the current vector as a illuminance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatIlluminanceVector; the current vector as a illuminance vector
     */
    public final FloatIlluminanceVector asIlluminance(final IlluminanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatIlluminanceVector", this.toString());
        FloatIlluminanceVector result = new FloatIlluminanceVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a lineardensity vector.
     * @return FloatLinearDensityVector; the current vector as a lineardensity vector
     */
    public final FloatLinearDensityVector asLinearDensity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLinearDensityVector", this.toString());
        return new FloatLinearDensityVector(getData(), LinearDensityUnit.SI);
    }

    /**
     * Return the current vector as a lineardensity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLinearDensityVector; the current vector as a lineardensity vector
     */
    public final FloatLinearDensityVector asLinearDensity(final LinearDensityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLinearDensityVector", this.toString());
        FloatLinearDensityVector result = new FloatLinearDensityVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a luminousflux vector.
     * @return FloatLuminousFluxVector; the current vector as a luminousflux vector
     */
    public final FloatLuminousFluxVector asLuminousFlux()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousFluxVector", this.toString());
        return new FloatLuminousFluxVector(getData(), LuminousFluxUnit.SI);
    }

    /**
     * Return the current vector as a luminousflux vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLuminousFluxVector; the current vector as a luminousflux vector
     */
    public final FloatLuminousFluxVector asLuminousFlux(final LuminousFluxUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousFluxVector", this.toString());
        FloatLuminousFluxVector result = new FloatLuminousFluxVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a luminousintensity vector.
     * @return FloatLuminousIntensityVector; the current vector as a luminousintensity vector
     */
    public final FloatLuminousIntensityVector asLuminousIntensity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousIntensityVector", this.toString());
        return new FloatLuminousIntensityVector(getData(), LuminousIntensityUnit.SI);
    }

    /**
     * Return the current vector as a luminousintensity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLuminousIntensityVector; the current vector as a luminousintensity vector
     */
    public final FloatLuminousIntensityVector asLuminousIntensity(final LuminousIntensityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousIntensityVector", this.toString());
        FloatLuminousIntensityVector result = new FloatLuminousIntensityVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a magneticfluxdensity vector.
     * @return FloatMagneticFluxDensityVector; the current vector as a magneticfluxdensity vector
     */
    public final FloatMagneticFluxDensityVector asMagneticFluxDensity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxDensityVector", this.toString());
        return new FloatMagneticFluxDensityVector(getData(), MagneticFluxDensityUnit.SI);
    }

    /**
     * Return the current vector as a magneticfluxdensity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatMagneticFluxDensityVector; the current vector as a magneticfluxdensity vector
     */
    public final FloatMagneticFluxDensityVector asMagneticFluxDensity(final MagneticFluxDensityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxDensityVector", this.toString());
        FloatMagneticFluxDensityVector result = new FloatMagneticFluxDensityVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a magneticflux vector.
     * @return FloatMagneticFluxVector; the current vector as a magneticflux vector
     */
    public final FloatMagneticFluxVector asMagneticFlux()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxVector", this.toString());
        return new FloatMagneticFluxVector(getData(), MagneticFluxUnit.SI);
    }

    /**
     * Return the current vector as a magneticflux vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatMagneticFluxVector; the current vector as a magneticflux vector
     */
    public final FloatMagneticFluxVector asMagneticFlux(final MagneticFluxUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxVector", this.toString());
        FloatMagneticFluxVector result = new FloatMagneticFluxVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a mass vector.
     * @return FloatMassVector; the current vector as a mass vector
     */
    public final FloatMassVector asMass()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMassVector", this.toString());
        return new FloatMassVector(getData(), MassUnit.SI);
    }

    /**
     * Return the current vector as a mass vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatMassVector; the current vector as a mass vector
     */
    public final FloatMassVector asMass(final MassUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMassVector", this.toString());
        FloatMassVector result = new FloatMassVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a power vector.
     * @return FloatPowerVector; the current vector as a power vector
     */
    public final FloatPowerVector asPower()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPowerVector", this.toString());
        return new FloatPowerVector(getData(), PowerUnit.SI);
    }

    /**
     * Return the current vector as a power vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatPowerVector; the current vector as a power vector
     */
    public final FloatPowerVector asPower(final PowerUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPowerVector", this.toString());
        FloatPowerVector result = new FloatPowerVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a pressure vector.
     * @return FloatPressureVector; the current vector as a pressure vector
     */
    public final FloatPressureVector asPressure()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPressureVector", this.toString());
        return new FloatPressureVector(getData(), PressureUnit.SI);
    }

    /**
     * Return the current vector as a pressure vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatPressureVector; the current vector as a pressure vector
     */
    public final FloatPressureVector asPressure(final PressureUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPressureVector", this.toString());
        FloatPressureVector result = new FloatPressureVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a radioactivity vector.
     * @return FloatRadioActivityVector; the current vector as a radioactivity vector
     */
    public final FloatRadioActivityVector asRadioActivity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatRadioActivityVector", this.toString());
        return new FloatRadioActivityVector(getData(), RadioActivityUnit.SI);
    }

    /**
     * Return the current vector as a radioactivity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatRadioActivityVector; the current vector as a radioactivity vector
     */
    public final FloatRadioActivityVector asRadioActivity(final RadioActivityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatRadioActivityVector", this.toString());
        FloatRadioActivityVector result = new FloatRadioActivityVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a solidangle vector.
     * @return FloatSolidAngleVector; the current vector as a solidangle vector
     */
    public final FloatSolidAngleVector asSolidAngle()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(SolidAngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSolidAngleVector", this.toString());
        return new FloatSolidAngleVector(getData(), SolidAngleUnit.SI);
    }

    /**
     * Return the current vector as a solidangle vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatSolidAngleVector; the current vector as a solidangle vector
     */
    public final FloatSolidAngleVector asSolidAngle(final SolidAngleUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(SolidAngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSolidAngleVector", this.toString());
        FloatSolidAngleVector result = new FloatSolidAngleVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a speed vector.
     * @return FloatSpeedVector; the current vector as a speed vector
     */
    public final FloatSpeedVector asSpeed()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSpeedVector", this.toString());
        return new FloatSpeedVector(getData(), SpeedUnit.SI);
    }

    /**
     * Return the current vector as a speed vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatSpeedVector; the current vector as a speed vector
     */
    public final FloatSpeedVector asSpeed(final SpeedUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSpeedVector", this.toString());
        FloatSpeedVector result = new FloatSpeedVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a torque vector.
     * @return FloatTorqueVector; the current vector as a torque vector
     */
    public final FloatTorqueVector asTorque()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTorqueVector", this.toString());
        return new FloatTorqueVector(getData(), TorqueUnit.SI);
    }

    /**
     * Return the current vector as a torque vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatTorqueVector; the current vector as a torque vector
     */
    public final FloatTorqueVector asTorque(final TorqueUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTorqueVector", this.toString());
        FloatTorqueVector result = new FloatTorqueVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a volume vector.
     * @return FloatVolumeVector; the current vector as a volume vector
     */
    public final FloatVolumeVector asVolume()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatVolumeVector", this.toString());
        return new FloatVolumeVector(getData(), VolumeUnit.SI);
    }

    /**
     * Return the current vector as a volume vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatVolumeVector; the current vector as a volume vector
     */
    public final FloatVolumeVector asVolume(final VolumeUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatVolumeVector", this.toString());
        FloatVolumeVector result = new FloatVolumeVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a angle vector.
     * @return FloatAngleVector; the current vector as a angle vector
     */
    public final FloatAngleVector asAngle()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAngleVector", this.toString());
        return new FloatAngleVector(getData(), AngleUnit.SI);
    }

    /**
     * Return the current vector as a angle vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAngleVector; the current vector as a angle vector
     */
    public final FloatAngleVector asAngle(final AngleUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAngleVector", this.toString());
        FloatAngleVector result = new FloatAngleVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a length vector.
     * @return FloatLengthVector; the current vector as a length vector
     */
    public final FloatLengthVector asLength()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLengthVector", this.toString());
        return new FloatLengthVector(getData(), LengthUnit.SI);
    }

    /**
     * Return the current vector as a length vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLengthVector; the current vector as a length vector
     */
    public final FloatLengthVector asLength(final LengthUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLengthVector", this.toString());
        FloatLengthVector result = new FloatLengthVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a temperature vector.
     * @return FloatTemperatureVector; the current vector as a temperature vector
     */
    public final FloatTemperatureVector asTemperature()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTemperatureVector", this.toString());
        return new FloatTemperatureVector(getData(), TemperatureUnit.SI);
    }

    /**
     * Return the current vector as a temperature vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatTemperatureVector; the current vector as a temperature vector
     */
    public final FloatTemperatureVector asTemperature(final TemperatureUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTemperatureVector", this.toString());
        FloatTemperatureVector result = new FloatTemperatureVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a duration vector.
     * @return FloatDurationVector; the current vector as a duration vector
     */
    public final FloatDurationVector asDuration()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDurationVector", this.toString());
        return new FloatDurationVector(getData(), DurationUnit.SI);
    }

    /**
     * Return the current vector as a duration vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatDurationVector; the current vector as a duration vector
     */
    public final FloatDurationVector asDuration(final DurationUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDurationVector", this.toString());
        FloatDurationVector result = new FloatDurationVector(getData(), displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
