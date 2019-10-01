package org.djunits4.value.vfloat.matrix;

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
import org.djunits4.unit.si.SIDimensions;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.base.FloatMatrix;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatSIScalar;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRel;
import org.djunits4.value.vfloat.vector.FloatSIVector;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Easy access methods for the generic Relative SI FloatMatrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatSIMatrix extends AbstractFloatMatrixRel<SIUnit, FloatSIScalar, FloatSIVector, FloatSIMatrix>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct a new Relative Float FloatSIMatrix.
     * @param values float[][]; the values of the entries in the new Relative Float FloatSIMatrix
     * @param unit SIUnit; the unit of the new Relative Float FloatSIMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return FloatSIMatrix; the FloatSIMatrix of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static FloatSIMatrix instantiate(final float[][] values, final SIUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        return new FloatSIMatrix(FloatMatrixData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit SIUnit; the unit
     */
    public FloatSIMatrix(final FloatMatrixData data, final SIUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatSIScalar> getScalarClass()
    {
        return FloatSIScalar.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatSIVector> getVectorClass()
    {
        return FloatSIVector.class;
    }

    /**
     * Returns an FloatSIMatrix based on an array of values and the textual representation of the unit.
     * @param values float[][]; the values to use
     * @param unitString String; the textual representation of the unit
     * @param storageType StorageType; the storage type to use
     * @return FloatSIMatrix; the matrix representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIMatrix of(final float[][] values, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(values, "Error parsing FloatSIMatrix: value is null");
        Throw.whenNull(unitString, "Error parsing FloatSIMatrix: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing FloatSIMatrix: empty unitString");
        Throw.whenNull(storageType, "Error parsing FloatSIMatrix: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return FloatSIMatrix.instantiate(values, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing FloatSIMatrix with unit " + unitString);
    }

    /** {@inheritDoc} */
    @Override
    public FloatSIMatrix instantiateMatrix(final FloatMatrixData fmd, final SIUnit unit)
    {
        return new FloatSIMatrix(fmd, unit);
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
     * Return the current matrix transformed to a matrix in the given unit. Of course the SI dimensionality has to match,
     * otherwise the matrix cannot be transformed. The compiler will check the alignment between the return value and the unit.
     * @param displayUnit KU; the unit in which the matrix needs to be expressed
     * @return K; the matrix that has been transformed into the right matrix type and unit
     */
    public final <U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>, V extends AbstractFloatVectorRel<U, S, V>,
            M extends AbstractFloatMatrixRel<U, S, V, M>> M as(final U displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(displayUnit.getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "FloatSIMatrix with unit %s cannot be converted to a FloatMatrix with unit %s",
                getDisplayUnit(), displayUnit);
        M result = FloatMatrix.instantiate(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a absorbeddose matrix.
     * @return FloatAbsorbedDoseMatrix; the current matrix as a absorbeddose matrix
     */
    public final FloatAbsorbedDoseMatrix asAbsorbedDose()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAbsorbedDoseMatrix", this.toString());
        return new FloatAbsorbedDoseMatrix(this.data, AbsorbedDoseUnit.SI);
    }

    /**
     * Return the current matrix as a absorbeddose matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAbsorbedDoseMatrix; the current matrix as a absorbeddose matrix
     */
    public final FloatAbsorbedDoseMatrix asAbsorbedDose(final AbsorbedDoseUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAbsorbedDoseMatrix", this.toString());
        FloatAbsorbedDoseMatrix result = new FloatAbsorbedDoseMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a acceleration matrix.
     * @return FloatAccelerationMatrix; the current matrix as a acceleration matrix
     */
    public final FloatAccelerationMatrix asAcceleration()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAccelerationMatrix", this.toString());
        return new FloatAccelerationMatrix(this.data, AccelerationUnit.SI);
    }

    /**
     * Return the current matrix as a acceleration matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAccelerationMatrix; the current matrix as a acceleration matrix
     */
    public final FloatAccelerationMatrix asAcceleration(final AccelerationUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAccelerationMatrix", this.toString());
        FloatAccelerationMatrix result = new FloatAccelerationMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a amountofsubstance matrix.
     * @return FloatAmountOfSubstanceMatrix; the current matrix as a amountofsubstance matrix
     */
    public final FloatAmountOfSubstanceMatrix asAmountOfSubstance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAmountOfSubstanceMatrix", this.toString());
        return new FloatAmountOfSubstanceMatrix(this.data, AmountOfSubstanceUnit.SI);
    }

    /**
     * Return the current matrix as a amountofsubstance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAmountOfSubstanceMatrix; the current matrix as a amountofsubstance matrix
     */
    public final FloatAmountOfSubstanceMatrix asAmountOfSubstance(final AmountOfSubstanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAmountOfSubstanceMatrix", this.toString());
        FloatAmountOfSubstanceMatrix result = new FloatAmountOfSubstanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a area matrix.
     * @return FloatAreaMatrix; the current matrix as a area matrix
     */
    public final FloatAreaMatrix asArea()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAreaMatrix", this.toString());
        return new FloatAreaMatrix(this.data, AreaUnit.SI);
    }

    /**
     * Return the current matrix as a area matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAreaMatrix; the current matrix as a area matrix
     */
    public final FloatAreaMatrix asArea(final AreaUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAreaMatrix", this.toString());
        FloatAreaMatrix result = new FloatAreaMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a catalyticactivity matrix.
     * @return FloatCatalyticActivityMatrix; the current matrix as a catalyticactivity matrix
     */
    public final FloatCatalyticActivityMatrix asCatalyticActivity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatCatalyticActivityMatrix", this.toString());
        return new FloatCatalyticActivityMatrix(this.data, CatalyticActivityUnit.SI);
    }

    /**
     * Return the current matrix as a catalyticactivity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatCatalyticActivityMatrix; the current matrix as a catalyticactivity matrix
     */
    public final FloatCatalyticActivityMatrix asCatalyticActivity(final CatalyticActivityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatCatalyticActivityMatrix", this.toString());
        FloatCatalyticActivityMatrix result = new FloatCatalyticActivityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a density matrix.
     * @return FloatDensityMatrix; the current matrix as a density matrix
     */
    public final FloatDensityMatrix asDensity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDensityMatrix", this.toString());
        return new FloatDensityMatrix(this.data, DensityUnit.SI);
    }

    /**
     * Return the current matrix as a density matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatDensityMatrix; the current matrix as a density matrix
     */
    public final FloatDensityMatrix asDensity(final DensityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDensityMatrix", this.toString());
        FloatDensityMatrix result = new FloatDensityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a dimensionless matrix.
     * @return FloatDimensionlessMatrix; the current matrix as a dimensionless matrix
     */
    public final FloatDimensionlessMatrix asDimensionless()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDimensionlessMatrix", this.toString());
        return new FloatDimensionlessMatrix(this.data, DimensionlessUnit.SI);
    }

    /**
     * Return the current matrix as a dimensionless matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatDimensionlessMatrix; the current matrix as a dimensionless matrix
     */
    public final FloatDimensionlessMatrix asDimensionless(final DimensionlessUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDimensionlessMatrix", this.toString());
        FloatDimensionlessMatrix result = new FloatDimensionlessMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalcapacitance matrix.
     * @return FloatElectricalCapacitanceMatrix; the current matrix as a electricalcapacitance matrix
     */
    public final FloatElectricalCapacitanceMatrix asElectricalCapacitance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCapacitanceMatrix", this.toString());
        return new FloatElectricalCapacitanceMatrix(this.data, ElectricalCapacitanceUnit.SI);
    }

    /**
     * Return the current matrix as a electricalcapacitance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalCapacitanceMatrix; the current matrix as a electricalcapacitance matrix
     */
    public final FloatElectricalCapacitanceMatrix asElectricalCapacitance(final ElectricalCapacitanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCapacitanceMatrix", this.toString());
        FloatElectricalCapacitanceMatrix result =
                new FloatElectricalCapacitanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalcharge matrix.
     * @return FloatElectricalChargeMatrix; the current matrix as a electricalcharge matrix
     */
    public final FloatElectricalChargeMatrix asElectricalCharge()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalChargeMatrix", this.toString());
        return new FloatElectricalChargeMatrix(this.data, ElectricalChargeUnit.SI);
    }

    /**
     * Return the current matrix as a electricalcharge matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalChargeMatrix; the current matrix as a electricalcharge matrix
     */
    public final FloatElectricalChargeMatrix asElectricalCharge(final ElectricalChargeUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalChargeMatrix", this.toString());
        FloatElectricalChargeMatrix result = new FloatElectricalChargeMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalconductance matrix.
     * @return FloatElectricalConductanceMatrix; the current matrix as a electricalconductance matrix
     */
    public final FloatElectricalConductanceMatrix asElectricalConductance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalConductanceMatrix", this.toString());
        return new FloatElectricalConductanceMatrix(this.data, ElectricalConductanceUnit.SI);
    }

    /**
     * Return the current matrix as a electricalconductance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalConductanceMatrix; the current matrix as a electricalconductance matrix
     */
    public final FloatElectricalConductanceMatrix asElectricalConductance(final ElectricalConductanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalConductanceMatrix", this.toString());
        FloatElectricalConductanceMatrix result =
                new FloatElectricalConductanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalcurrent matrix.
     * @return FloatElectricalCurrentMatrix; the current matrix as a electricalcurrent matrix
     */
    public final FloatElectricalCurrentMatrix asElectricalCurrent()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCurrentMatrix", this.toString());
        return new FloatElectricalCurrentMatrix(this.data, ElectricalCurrentUnit.SI);
    }

    /**
     * Return the current matrix as a electricalcurrent matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalCurrentMatrix; the current matrix as a electricalcurrent matrix
     */
    public final FloatElectricalCurrentMatrix asElectricalCurrent(final ElectricalCurrentUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCurrentMatrix", this.toString());
        FloatElectricalCurrentMatrix result = new FloatElectricalCurrentMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalinductance matrix.
     * @return FloatElectricalInductanceMatrix; the current matrix as a electricalinductance matrix
     */
    public final FloatElectricalInductanceMatrix asElectricalInductance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalInductanceMatrix", this.toString());
        return new FloatElectricalInductanceMatrix(this.data, ElectricalInductanceUnit.SI);
    }

    /**
     * Return the current matrix as a electricalinductance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalInductanceMatrix; the current matrix as a electricalinductance matrix
     */
    public final FloatElectricalInductanceMatrix asElectricalInductance(final ElectricalInductanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalInductanceMatrix", this.toString());
        FloatElectricalInductanceMatrix result = new FloatElectricalInductanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalpotential matrix.
     * @return FloatElectricalPotentialMatrix; the current matrix as a electricalpotential matrix
     */
    public final FloatElectricalPotentialMatrix asElectricalPotential()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalPotentialMatrix", this.toString());
        return new FloatElectricalPotentialMatrix(this.data, ElectricalPotentialUnit.SI);
    }

    /**
     * Return the current matrix as a electricalpotential matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalPotentialMatrix; the current matrix as a electricalpotential matrix
     */
    public final FloatElectricalPotentialMatrix asElectricalPotential(final ElectricalPotentialUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalPotentialMatrix", this.toString());
        FloatElectricalPotentialMatrix result = new FloatElectricalPotentialMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalresistance matrix.
     * @return FloatElectricalResistanceMatrix; the current matrix as a electricalresistance matrix
     */
    public final FloatElectricalResistanceMatrix asElectricalResistance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalResistanceMatrix", this.toString());
        return new FloatElectricalResistanceMatrix(this.data, ElectricalResistanceUnit.SI);
    }

    /**
     * Return the current matrix as a electricalresistance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalResistanceMatrix; the current matrix as a electricalresistance matrix
     */
    public final FloatElectricalResistanceMatrix asElectricalResistance(final ElectricalResistanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalResistanceMatrix", this.toString());
        FloatElectricalResistanceMatrix result = new FloatElectricalResistanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a energy matrix.
     * @return FloatEnergyMatrix; the current matrix as a energy matrix
     */
    public final FloatEnergyMatrix asEnergy()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEnergyMatrix", this.toString());
        return new FloatEnergyMatrix(this.data, EnergyUnit.SI);
    }

    /**
     * Return the current matrix as a energy matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatEnergyMatrix; the current matrix as a energy matrix
     */
    public final FloatEnergyMatrix asEnergy(final EnergyUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEnergyMatrix", this.toString());
        FloatEnergyMatrix result = new FloatEnergyMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a equivalentdose matrix.
     * @return FloatEquivalentDoseMatrix; the current matrix as a equivalentdose matrix
     */
    public final FloatEquivalentDoseMatrix asEquivalentDose()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEquivalentDoseMatrix", this.toString());
        return new FloatEquivalentDoseMatrix(this.data, EquivalentDoseUnit.SI);
    }

    /**
     * Return the current matrix as a equivalentdose matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatEquivalentDoseMatrix; the current matrix as a equivalentdose matrix
     */
    public final FloatEquivalentDoseMatrix asEquivalentDose(final EquivalentDoseUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEquivalentDoseMatrix", this.toString());
        FloatEquivalentDoseMatrix result = new FloatEquivalentDoseMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a flowmass matrix.
     * @return FloatFlowMassMatrix; the current matrix as a flowmass matrix
     */
    public final FloatFlowMassMatrix asFlowMass()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowMassMatrix", this.toString());
        return new FloatFlowMassMatrix(this.data, FlowMassUnit.SI);
    }

    /**
     * Return the current matrix as a flowmass matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatFlowMassMatrix; the current matrix as a flowmass matrix
     */
    public final FloatFlowMassMatrix asFlowMass(final FlowMassUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowMassMatrix", this.toString());
        FloatFlowMassMatrix result = new FloatFlowMassMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a flowvolume matrix.
     * @return FloatFlowVolumeMatrix; the current matrix as a flowvolume matrix
     */
    public final FloatFlowVolumeMatrix asFlowVolume()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowVolumeMatrix", this.toString());
        return new FloatFlowVolumeMatrix(this.data, FlowVolumeUnit.SI);
    }

    /**
     * Return the current matrix as a flowvolume matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatFlowVolumeMatrix; the current matrix as a flowvolume matrix
     */
    public final FloatFlowVolumeMatrix asFlowVolume(final FlowVolumeUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowVolumeMatrix", this.toString());
        FloatFlowVolumeMatrix result = new FloatFlowVolumeMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a force matrix.
     * @return FloatForceMatrix; the current matrix as a force matrix
     */
    public final FloatForceMatrix asForce()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatForceMatrix", this.toString());
        return new FloatForceMatrix(this.data, ForceUnit.SI);
    }

    /**
     * Return the current matrix as a force matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatForceMatrix; the current matrix as a force matrix
     */
    public final FloatForceMatrix asForce(final ForceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatForceMatrix", this.toString());
        FloatForceMatrix result = new FloatForceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a frequency matrix.
     * @return FloatFrequencyMatrix; the current matrix as a frequency matrix
     */
    public final FloatFrequencyMatrix asFrequency()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFrequencyMatrix", this.toString());
        return new FloatFrequencyMatrix(this.data, FrequencyUnit.SI);
    }

    /**
     * Return the current matrix as a frequency matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatFrequencyMatrix; the current matrix as a frequency matrix
     */
    public final FloatFrequencyMatrix asFrequency(final FrequencyUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFrequencyMatrix", this.toString());
        FloatFrequencyMatrix result = new FloatFrequencyMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a illuminance matrix.
     * @return FloatIlluminanceMatrix; the current matrix as a illuminance matrix
     */
    public final FloatIlluminanceMatrix asIlluminance()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatIlluminanceMatrix", this.toString());
        return new FloatIlluminanceMatrix(this.data, IlluminanceUnit.SI);
    }

    /**
     * Return the current matrix as a illuminance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatIlluminanceMatrix; the current matrix as a illuminance matrix
     */
    public final FloatIlluminanceMatrix asIlluminance(final IlluminanceUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatIlluminanceMatrix", this.toString());
        FloatIlluminanceMatrix result = new FloatIlluminanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a lineardensity matrix.
     * @return FloatLinearDensityMatrix; the current matrix as a lineardensity matrix
     */
    public final FloatLinearDensityMatrix asLinearDensity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLinearDensityMatrix", this.toString());
        return new FloatLinearDensityMatrix(this.data, LinearDensityUnit.SI);
    }

    /**
     * Return the current matrix as a lineardensity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLinearDensityMatrix; the current matrix as a lineardensity matrix
     */
    public final FloatLinearDensityMatrix asLinearDensity(final LinearDensityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLinearDensityMatrix", this.toString());
        FloatLinearDensityMatrix result = new FloatLinearDensityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a luminousflux matrix.
     * @return FloatLuminousFluxMatrix; the current matrix as a luminousflux matrix
     */
    public final FloatLuminousFluxMatrix asLuminousFlux()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousFluxMatrix", this.toString());
        return new FloatLuminousFluxMatrix(this.data, LuminousFluxUnit.SI);
    }

    /**
     * Return the current matrix as a luminousflux matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLuminousFluxMatrix; the current matrix as a luminousflux matrix
     */
    public final FloatLuminousFluxMatrix asLuminousFlux(final LuminousFluxUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousFluxMatrix", this.toString());
        FloatLuminousFluxMatrix result = new FloatLuminousFluxMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a luminousintensity matrix.
     * @return FloatLuminousIntensityMatrix; the current matrix as a luminousintensity matrix
     */
    public final FloatLuminousIntensityMatrix asLuminousIntensity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousIntensityMatrix", this.toString());
        return new FloatLuminousIntensityMatrix(this.data, LuminousIntensityUnit.SI);
    }

    /**
     * Return the current matrix as a luminousintensity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLuminousIntensityMatrix; the current matrix as a luminousintensity matrix
     */
    public final FloatLuminousIntensityMatrix asLuminousIntensity(final LuminousIntensityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousIntensityMatrix", this.toString());
        FloatLuminousIntensityMatrix result = new FloatLuminousIntensityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a magneticfluxdensity matrix.
     * @return FloatMagneticFluxDensityMatrix; the current matrix as a magneticfluxdensity matrix
     */
    public final FloatMagneticFluxDensityMatrix asMagneticFluxDensity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxDensityMatrix", this.toString());
        return new FloatMagneticFluxDensityMatrix(this.data, MagneticFluxDensityUnit.SI);
    }

    /**
     * Return the current matrix as a magneticfluxdensity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatMagneticFluxDensityMatrix; the current matrix as a magneticfluxdensity matrix
     */
    public final FloatMagneticFluxDensityMatrix asMagneticFluxDensity(final MagneticFluxDensityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxDensityMatrix", this.toString());
        FloatMagneticFluxDensityMatrix result = new FloatMagneticFluxDensityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a magneticflux matrix.
     * @return FloatMagneticFluxMatrix; the current matrix as a magneticflux matrix
     */
    public final FloatMagneticFluxMatrix asMagneticFlux()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxMatrix", this.toString());
        return new FloatMagneticFluxMatrix(this.data, MagneticFluxUnit.SI);
    }

    /**
     * Return the current matrix as a magneticflux matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatMagneticFluxMatrix; the current matrix as a magneticflux matrix
     */
    public final FloatMagneticFluxMatrix asMagneticFlux(final MagneticFluxUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxMatrix", this.toString());
        FloatMagneticFluxMatrix result = new FloatMagneticFluxMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a mass matrix.
     * @return FloatMassMatrix; the current matrix as a mass matrix
     */
    public final FloatMassMatrix asMass()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMassMatrix", this.toString());
        return new FloatMassMatrix(this.data, MassUnit.SI);
    }

    /**
     * Return the current matrix as a mass matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatMassMatrix; the current matrix as a mass matrix
     */
    public final FloatMassMatrix asMass(final MassUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMassMatrix", this.toString());
        FloatMassMatrix result = new FloatMassMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a power matrix.
     * @return FloatPowerMatrix; the current matrix as a power matrix
     */
    public final FloatPowerMatrix asPower()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPowerMatrix", this.toString());
        return new FloatPowerMatrix(this.data, PowerUnit.SI);
    }

    /**
     * Return the current matrix as a power matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatPowerMatrix; the current matrix as a power matrix
     */
    public final FloatPowerMatrix asPower(final PowerUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPowerMatrix", this.toString());
        FloatPowerMatrix result = new FloatPowerMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a pressure matrix.
     * @return FloatPressureMatrix; the current matrix as a pressure matrix
     */
    public final FloatPressureMatrix asPressure()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPressureMatrix", this.toString());
        return new FloatPressureMatrix(this.data, PressureUnit.SI);
    }

    /**
     * Return the current matrix as a pressure matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatPressureMatrix; the current matrix as a pressure matrix
     */
    public final FloatPressureMatrix asPressure(final PressureUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPressureMatrix", this.toString());
        FloatPressureMatrix result = new FloatPressureMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a radioactivity matrix.
     * @return FloatRadioActivityMatrix; the current matrix as a radioactivity matrix
     */
    public final FloatRadioActivityMatrix asRadioActivity()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatRadioActivityMatrix", this.toString());
        return new FloatRadioActivityMatrix(this.data, RadioActivityUnit.SI);
    }

    /**
     * Return the current matrix as a radioactivity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatRadioActivityMatrix; the current matrix as a radioactivity matrix
     */
    public final FloatRadioActivityMatrix asRadioActivity(final RadioActivityUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatRadioActivityMatrix", this.toString());
        FloatRadioActivityMatrix result = new FloatRadioActivityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a solidangle matrix.
     * @return FloatSolidAngleMatrix; the current matrix as a solidangle matrix
     */
    public final FloatSolidAngleMatrix asSolidAngle()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(SolidAngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSolidAngleMatrix", this.toString());
        return new FloatSolidAngleMatrix(this.data, SolidAngleUnit.SI);
    }

    /**
     * Return the current matrix as a solidangle matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatSolidAngleMatrix; the current matrix as a solidangle matrix
     */
    public final FloatSolidAngleMatrix asSolidAngle(final SolidAngleUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(SolidAngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSolidAngleMatrix", this.toString());
        FloatSolidAngleMatrix result = new FloatSolidAngleMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a speed matrix.
     * @return FloatSpeedMatrix; the current matrix as a speed matrix
     */
    public final FloatSpeedMatrix asSpeed()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSpeedMatrix", this.toString());
        return new FloatSpeedMatrix(this.data, SpeedUnit.SI);
    }

    /**
     * Return the current matrix as a speed matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatSpeedMatrix; the current matrix as a speed matrix
     */
    public final FloatSpeedMatrix asSpeed(final SpeedUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSpeedMatrix", this.toString());
        FloatSpeedMatrix result = new FloatSpeedMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a torque matrix.
     * @return FloatTorqueMatrix; the current matrix as a torque matrix
     */
    public final FloatTorqueMatrix asTorque()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTorqueMatrix", this.toString());
        return new FloatTorqueMatrix(this.data, TorqueUnit.SI);
    }

    /**
     * Return the current matrix as a torque matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatTorqueMatrix; the current matrix as a torque matrix
     */
    public final FloatTorqueMatrix asTorque(final TorqueUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTorqueMatrix", this.toString());
        FloatTorqueMatrix result = new FloatTorqueMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a volume matrix.
     * @return FloatVolumeMatrix; the current matrix as a volume matrix
     */
    public final FloatVolumeMatrix asVolume()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatVolumeMatrix", this.toString());
        return new FloatVolumeMatrix(this.data, VolumeUnit.SI);
    }

    /**
     * Return the current matrix as a volume matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatVolumeMatrix; the current matrix as a volume matrix
     */
    public final FloatVolumeMatrix asVolume(final VolumeUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatVolumeMatrix", this.toString());
        FloatVolumeMatrix result = new FloatVolumeMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a angle matrix.
     * @return FloatAngleMatrix; the current matrix as a angle matrix
     */
    public final FloatAngleMatrix asAngle()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAngleMatrix", this.toString());
        return new FloatAngleMatrix(this.data, AngleUnit.SI);
    }

    /**
     * Return the current matrix as a angle matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAngleMatrix; the current matrix as a angle matrix
     */
    public final FloatAngleMatrix asAngle(final AngleUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAngleMatrix", this.toString());
        FloatAngleMatrix result = new FloatAngleMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a length matrix.
     * @return FloatLengthMatrix; the current matrix as a length matrix
     */
    public final FloatLengthMatrix asLength()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLengthMatrix", this.toString());
        return new FloatLengthMatrix(this.data, LengthUnit.SI);
    }

    /**
     * Return the current matrix as a length matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLengthMatrix; the current matrix as a length matrix
     */
    public final FloatLengthMatrix asLength(final LengthUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLengthMatrix", this.toString());
        FloatLengthMatrix result = new FloatLengthMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a temperature matrix.
     * @return FloatTemperatureMatrix; the current matrix as a temperature matrix
     */
    public final FloatTemperatureMatrix asTemperature()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTemperatureMatrix", this.toString());
        return new FloatTemperatureMatrix(this.data, TemperatureUnit.SI);
    }

    /**
     * Return the current matrix as a temperature matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatTemperatureMatrix; the current matrix as a temperature matrix
     */
    public final FloatTemperatureMatrix asTemperature(final TemperatureUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTemperatureMatrix", this.toString());
        FloatTemperatureMatrix result = new FloatTemperatureMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a duration matrix.
     * @return FloatDurationMatrix; the current matrix as a duration matrix
     */
    public final FloatDurationMatrix asDuration()
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDurationMatrix", this.toString());
        return new FloatDurationMatrix(this.data, DurationUnit.SI);
    }

    /**
     * Return the current matrix as a duration matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatDurationMatrix; the current matrix as a duration matrix
     */
    public final FloatDurationMatrix asDuration(final DurationUnit displayUnit)
    {
        Throw.when(!(getDisplayUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDurationMatrix", this.toString());
        FloatDurationMatrix result = new FloatDurationMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
