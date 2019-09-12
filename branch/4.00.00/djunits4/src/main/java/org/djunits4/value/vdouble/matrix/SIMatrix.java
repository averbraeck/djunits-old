package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.AbsorbedDoseUnit;
import org.djunits4.unit.AccelerationUnit;
import org.djunits4.unit.AmountOfSubstanceUnit;
import org.djunits4.unit.AngleSolidUnit;
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
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.unit.TorqueUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.VolumeUnit;
import org.djunits4.unit.si.SIDimensions;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.base.DoubleMatrix;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.SIScalar;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;
import org.djunits4.value.vdouble.vector.SIVector;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;

/**
 * Easy access methods for the generic Relative SI DoubleMatrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T20:33:12.910Z")
public class SIMatrix extends AbstractDoubleMatrixRel<SIUnit, SIScalar, SIVector, SIMatrix>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct a new Relative Double SIMatrix.
     * @param values double[][]; the values of the entries in the new Relative Double SIMatrix
     * @param unit SIUnit; the unit of the new Relative Double SIMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return SIMatrix; the SIMatrix of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static SIMatrix create(final double[][] values, final SIUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        return new SIMatrix(DoubleMatrixData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit SIUnit; the unit
     */
    public SIMatrix(final DoubleMatrixData data, final SIUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<SIScalar> getScalarClass()
    {
        return SIScalar.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<SIVector> getVectorClass()
    {
        return SIVector.class;
    }

    /**
     * Returns an SIMatrix based on an array of values and the textual representation of the unit.
     * @param values double[][]; the values to use
     * @param unitString String; the textual representation of the unit
     * @param storageType StorageType; the storage type to use
     * @return SIMatrix; the matrix representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static SIMatrix of(final double[][] values, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(values, "Error parsing SIMatrix: value is null");
        Throw.whenNull(unitString, "Error parsing SIMatrix: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing SIMatrix: empty unitString");
        Throw.whenNull(storageType, "Error parsing SIMatrix: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return SIMatrix.create(values, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing SIMatrix with unit " + unitString);
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
    public final <U extends Unit<U>, S extends AbstractDoubleScalarRel<U, S>, V extends AbstractDoubleVectorRel<U, S, V>,
            M extends AbstractDoubleMatrixRel<U, S, V, M>> M as(final U displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(displayUnit.getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "SIMatrix with unit %s cannot be converted to a matrix with unit %s", getUnit(),
                displayUnit);
        M result = DoubleMatrix.instantiate(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a absorbeddose matrix.
     * @return AbsorbedDoseMatrix; the current matrix as a absorbeddose matrix
     */
    public final AbsorbedDoseMatrix asAbsorbedDose()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AbsorbedDoseMatrix", this.toString());
        return new AbsorbedDoseMatrix(this.data, AbsorbedDoseUnit.SI);
    }

    /**
     * Return the current matrix as a absorbeddose matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AbsorbedDoseMatrix; the current matrix as a absorbeddose matrix
     */
    public final AbsorbedDoseMatrix asAbsorbedDose(final AbsorbedDoseUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AbsorbedDoseMatrix", this.toString());
        AbsorbedDoseMatrix result = new AbsorbedDoseMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a acceleration matrix.
     * @return AccelerationMatrix; the current matrix as a acceleration matrix
     */
    public final AccelerationMatrix asAcceleration()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AccelerationMatrix", this.toString());
        return new AccelerationMatrix(this.data, AccelerationUnit.SI);
    }

    /**
     * Return the current matrix as a acceleration matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AccelerationMatrix; the current matrix as a acceleration matrix
     */
    public final AccelerationMatrix asAcceleration(final AccelerationUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AccelerationMatrix", this.toString());
        AccelerationMatrix result = new AccelerationMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a amountofsubstance matrix.
     * @return AmountOfSubstanceMatrix; the current matrix as a amountofsubstance matrix
     */
    public final AmountOfSubstanceMatrix asAmountOfSubstance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AmountOfSubstanceMatrix", this.toString());
        return new AmountOfSubstanceMatrix(this.data, AmountOfSubstanceUnit.SI);
    }

    /**
     * Return the current matrix as a amountofsubstance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AmountOfSubstanceMatrix; the current matrix as a amountofsubstance matrix
     */
    public final AmountOfSubstanceMatrix asAmountOfSubstance(final AmountOfSubstanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AmountOfSubstanceMatrix", this.toString());
        AmountOfSubstanceMatrix result = new AmountOfSubstanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a anglesolid matrix.
     * @return AngleSolidMatrix; the current matrix as a anglesolid matrix
     */
    public final AngleSolidMatrix asAngleSolid()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleSolidUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleSolidMatrix", this.toString());
        return new AngleSolidMatrix(this.data, AngleSolidUnit.SI);
    }

    /**
     * Return the current matrix as a anglesolid matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AngleSolidMatrix; the current matrix as a anglesolid matrix
     */
    public final AngleSolidMatrix asAngleSolid(final AngleSolidUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleSolidUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleSolidMatrix", this.toString());
        AngleSolidMatrix result = new AngleSolidMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a area matrix.
     * @return AreaMatrix; the current matrix as a area matrix
     */
    public final AreaMatrix asArea()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AreaMatrix", this.toString());
        return new AreaMatrix(this.data, AreaUnit.SI);
    }

    /**
     * Return the current matrix as a area matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AreaMatrix; the current matrix as a area matrix
     */
    public final AreaMatrix asArea(final AreaUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AreaMatrix", this.toString());
        AreaMatrix result = new AreaMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a catalyticactivity matrix.
     * @return CatalyticActivityMatrix; the current matrix as a catalyticactivity matrix
     */
    public final CatalyticActivityMatrix asCatalyticActivity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to CatalyticActivityMatrix", this.toString());
        return new CatalyticActivityMatrix(this.data, CatalyticActivityUnit.SI);
    }

    /**
     * Return the current matrix as a catalyticactivity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return CatalyticActivityMatrix; the current matrix as a catalyticactivity matrix
     */
    public final CatalyticActivityMatrix asCatalyticActivity(final CatalyticActivityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to CatalyticActivityMatrix", this.toString());
        CatalyticActivityMatrix result = new CatalyticActivityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a density matrix.
     * @return DensityMatrix; the current matrix as a density matrix
     */
    public final DensityMatrix asDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DensityMatrix", this.toString());
        return new DensityMatrix(this.data, DensityUnit.SI);
    }

    /**
     * Return the current matrix as a density matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return DensityMatrix; the current matrix as a density matrix
     */
    public final DensityMatrix asDensity(final DensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DensityMatrix", this.toString());
        DensityMatrix result = new DensityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a dimensionless matrix.
     * @return DimensionlessMatrix; the current matrix as a dimensionless matrix
     */
    public final DimensionlessMatrix asDimensionless()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DimensionlessMatrix", this.toString());
        return new DimensionlessMatrix(this.data, DimensionlessUnit.SI);
    }

    /**
     * Return the current matrix as a dimensionless matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return DimensionlessMatrix; the current matrix as a dimensionless matrix
     */
    public final DimensionlessMatrix asDimensionless(final DimensionlessUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DimensionlessMatrix", this.toString());
        DimensionlessMatrix result = new DimensionlessMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalcapacitance matrix.
     * @return ElectricalCapacitanceMatrix; the current matrix as a electricalcapacitance matrix
     */
    public final ElectricalCapacitanceMatrix asElectricalCapacitance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCapacitanceMatrix", this.toString());
        return new ElectricalCapacitanceMatrix(this.data, ElectricalCapacitanceUnit.SI);
    }

    /**
     * Return the current matrix as a electricalcapacitance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalCapacitanceMatrix; the current matrix as a electricalcapacitance matrix
     */
    public final ElectricalCapacitanceMatrix asElectricalCapacitance(final ElectricalCapacitanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCapacitanceMatrix", this.toString());
        ElectricalCapacitanceMatrix result = new ElectricalCapacitanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalcharge matrix.
     * @return ElectricalChargeMatrix; the current matrix as a electricalcharge matrix
     */
    public final ElectricalChargeMatrix asElectricalCharge()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalChargeMatrix", this.toString());
        return new ElectricalChargeMatrix(this.data, ElectricalChargeUnit.SI);
    }

    /**
     * Return the current matrix as a electricalcharge matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalChargeMatrix; the current matrix as a electricalcharge matrix
     */
    public final ElectricalChargeMatrix asElectricalCharge(final ElectricalChargeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalChargeMatrix", this.toString());
        ElectricalChargeMatrix result = new ElectricalChargeMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalconductance matrix.
     * @return ElectricalConductanceMatrix; the current matrix as a electricalconductance matrix
     */
    public final ElectricalConductanceMatrix asElectricalConductance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalConductanceMatrix", this.toString());
        return new ElectricalConductanceMatrix(this.data, ElectricalConductanceUnit.SI);
    }

    /**
     * Return the current matrix as a electricalconductance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalConductanceMatrix; the current matrix as a electricalconductance matrix
     */
    public final ElectricalConductanceMatrix asElectricalConductance(final ElectricalConductanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalConductanceMatrix", this.toString());
        ElectricalConductanceMatrix result = new ElectricalConductanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalcurrent matrix.
     * @return ElectricalCurrentMatrix; the current matrix as a electricalcurrent matrix
     */
    public final ElectricalCurrentMatrix asElectricalCurrent()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCurrentMatrix", this.toString());
        return new ElectricalCurrentMatrix(this.data, ElectricalCurrentUnit.SI);
    }

    /**
     * Return the current matrix as a electricalcurrent matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalCurrentMatrix; the current matrix as a electricalcurrent matrix
     */
    public final ElectricalCurrentMatrix asElectricalCurrent(final ElectricalCurrentUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCurrentMatrix", this.toString());
        ElectricalCurrentMatrix result = new ElectricalCurrentMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalinductance matrix.
     * @return ElectricalInductanceMatrix; the current matrix as a electricalinductance matrix
     */
    public final ElectricalInductanceMatrix asElectricalInductance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalInductanceMatrix", this.toString());
        return new ElectricalInductanceMatrix(this.data, ElectricalInductanceUnit.SI);
    }

    /**
     * Return the current matrix as a electricalinductance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalInductanceMatrix; the current matrix as a electricalinductance matrix
     */
    public final ElectricalInductanceMatrix asElectricalInductance(final ElectricalInductanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalInductanceMatrix", this.toString());
        ElectricalInductanceMatrix result = new ElectricalInductanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalpotential matrix.
     * @return ElectricalPotentialMatrix; the current matrix as a electricalpotential matrix
     */
    public final ElectricalPotentialMatrix asElectricalPotential()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalPotentialMatrix", this.toString());
        return new ElectricalPotentialMatrix(this.data, ElectricalPotentialUnit.SI);
    }

    /**
     * Return the current matrix as a electricalpotential matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalPotentialMatrix; the current matrix as a electricalpotential matrix
     */
    public final ElectricalPotentialMatrix asElectricalPotential(final ElectricalPotentialUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalPotentialMatrix", this.toString());
        ElectricalPotentialMatrix result = new ElectricalPotentialMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a electricalresistance matrix.
     * @return ElectricalResistanceMatrix; the current matrix as a electricalresistance matrix
     */
    public final ElectricalResistanceMatrix asElectricalResistance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalResistanceMatrix", this.toString());
        return new ElectricalResistanceMatrix(this.data, ElectricalResistanceUnit.SI);
    }

    /**
     * Return the current matrix as a electricalresistance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalResistanceMatrix; the current matrix as a electricalresistance matrix
     */
    public final ElectricalResistanceMatrix asElectricalResistance(final ElectricalResistanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalResistanceMatrix", this.toString());
        ElectricalResistanceMatrix result = new ElectricalResistanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a energy matrix.
     * @return EnergyMatrix; the current matrix as a energy matrix
     */
    public final EnergyMatrix asEnergy()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EnergyMatrix", this.toString());
        return new EnergyMatrix(this.data, EnergyUnit.SI);
    }

    /**
     * Return the current matrix as a energy matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return EnergyMatrix; the current matrix as a energy matrix
     */
    public final EnergyMatrix asEnergy(final EnergyUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EnergyMatrix", this.toString());
        EnergyMatrix result = new EnergyMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a equivalentdose matrix.
     * @return EquivalentDoseMatrix; the current matrix as a equivalentdose matrix
     */
    public final EquivalentDoseMatrix asEquivalentDose()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EquivalentDoseMatrix", this.toString());
        return new EquivalentDoseMatrix(this.data, EquivalentDoseUnit.SI);
    }

    /**
     * Return the current matrix as a equivalentdose matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return EquivalentDoseMatrix; the current matrix as a equivalentdose matrix
     */
    public final EquivalentDoseMatrix asEquivalentDose(final EquivalentDoseUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EquivalentDoseMatrix", this.toString());
        EquivalentDoseMatrix result = new EquivalentDoseMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a flowmass matrix.
     * @return FlowMassMatrix; the current matrix as a flowmass matrix
     */
    public final FlowMassMatrix asFlowMass()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowMassMatrix", this.toString());
        return new FlowMassMatrix(this.data, FlowMassUnit.SI);
    }

    /**
     * Return the current matrix as a flowmass matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FlowMassMatrix; the current matrix as a flowmass matrix
     */
    public final FlowMassMatrix asFlowMass(final FlowMassUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowMassMatrix", this.toString());
        FlowMassMatrix result = new FlowMassMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a flowvolume matrix.
     * @return FlowVolumeMatrix; the current matrix as a flowvolume matrix
     */
    public final FlowVolumeMatrix asFlowVolume()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowVolumeMatrix", this.toString());
        return new FlowVolumeMatrix(this.data, FlowVolumeUnit.SI);
    }

    /**
     * Return the current matrix as a flowvolume matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FlowVolumeMatrix; the current matrix as a flowvolume matrix
     */
    public final FlowVolumeMatrix asFlowVolume(final FlowVolumeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowVolumeMatrix", this.toString());
        FlowVolumeMatrix result = new FlowVolumeMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a force matrix.
     * @return ForceMatrix; the current matrix as a force matrix
     */
    public final ForceMatrix asForce()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ForceMatrix", this.toString());
        return new ForceMatrix(this.data, ForceUnit.SI);
    }

    /**
     * Return the current matrix as a force matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ForceMatrix; the current matrix as a force matrix
     */
    public final ForceMatrix asForce(final ForceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ForceMatrix", this.toString());
        ForceMatrix result = new ForceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a frequency matrix.
     * @return FrequencyMatrix; the current matrix as a frequency matrix
     */
    public final FrequencyMatrix asFrequency()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FrequencyMatrix", this.toString());
        return new FrequencyMatrix(this.data, FrequencyUnit.SI);
    }

    /**
     * Return the current matrix as a frequency matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FrequencyMatrix; the current matrix as a frequency matrix
     */
    public final FrequencyMatrix asFrequency(final FrequencyUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FrequencyMatrix", this.toString());
        FrequencyMatrix result = new FrequencyMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a illuminance matrix.
     * @return IlluminanceMatrix; the current matrix as a illuminance matrix
     */
    public final IlluminanceMatrix asIlluminance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to IlluminanceMatrix", this.toString());
        return new IlluminanceMatrix(this.data, IlluminanceUnit.SI);
    }

    /**
     * Return the current matrix as a illuminance matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return IlluminanceMatrix; the current matrix as a illuminance matrix
     */
    public final IlluminanceMatrix asIlluminance(final IlluminanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to IlluminanceMatrix", this.toString());
        IlluminanceMatrix result = new IlluminanceMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a lineardensity matrix.
     * @return LinearDensityMatrix; the current matrix as a lineardensity matrix
     */
    public final LinearDensityMatrix asLinearDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LinearDensityMatrix", this.toString());
        return new LinearDensityMatrix(this.data, LinearDensityUnit.SI);
    }

    /**
     * Return the current matrix as a lineardensity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return LinearDensityMatrix; the current matrix as a lineardensity matrix
     */
    public final LinearDensityMatrix asLinearDensity(final LinearDensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LinearDensityMatrix", this.toString());
        LinearDensityMatrix result = new LinearDensityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a luminousflux matrix.
     * @return LuminousFluxMatrix; the current matrix as a luminousflux matrix
     */
    public final LuminousFluxMatrix asLuminousFlux()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousFluxMatrix", this.toString());
        return new LuminousFluxMatrix(this.data, LuminousFluxUnit.SI);
    }

    /**
     * Return the current matrix as a luminousflux matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return LuminousFluxMatrix; the current matrix as a luminousflux matrix
     */
    public final LuminousFluxMatrix asLuminousFlux(final LuminousFluxUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousFluxMatrix", this.toString());
        LuminousFluxMatrix result = new LuminousFluxMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a luminousintensity matrix.
     * @return LuminousIntensityMatrix; the current matrix as a luminousintensity matrix
     */
    public final LuminousIntensityMatrix asLuminousIntensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousIntensityMatrix", this.toString());
        return new LuminousIntensityMatrix(this.data, LuminousIntensityUnit.SI);
    }

    /**
     * Return the current matrix as a luminousintensity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return LuminousIntensityMatrix; the current matrix as a luminousintensity matrix
     */
    public final LuminousIntensityMatrix asLuminousIntensity(final LuminousIntensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousIntensityMatrix", this.toString());
        LuminousIntensityMatrix result = new LuminousIntensityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a magneticfluxdensity matrix.
     * @return MagneticFluxDensityMatrix; the current matrix as a magneticfluxdensity matrix
     */
    public final MagneticFluxDensityMatrix asMagneticFluxDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxDensityMatrix", this.toString());
        return new MagneticFluxDensityMatrix(this.data, MagneticFluxDensityUnit.SI);
    }

    /**
     * Return the current matrix as a magneticfluxdensity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return MagneticFluxDensityMatrix; the current matrix as a magneticfluxdensity matrix
     */
    public final MagneticFluxDensityMatrix asMagneticFluxDensity(final MagneticFluxDensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxDensityMatrix", this.toString());
        MagneticFluxDensityMatrix result = new MagneticFluxDensityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a magneticflux matrix.
     * @return MagneticFluxMatrix; the current matrix as a magneticflux matrix
     */
    public final MagneticFluxMatrix asMagneticFlux()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxMatrix", this.toString());
        return new MagneticFluxMatrix(this.data, MagneticFluxUnit.SI);
    }

    /**
     * Return the current matrix as a magneticflux matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return MagneticFluxMatrix; the current matrix as a magneticflux matrix
     */
    public final MagneticFluxMatrix asMagneticFlux(final MagneticFluxUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxMatrix", this.toString());
        MagneticFluxMatrix result = new MagneticFluxMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a mass matrix.
     * @return MassMatrix; the current matrix as a mass matrix
     */
    public final MassMatrix asMass()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MassMatrix", this.toString());
        return new MassMatrix(this.data, MassUnit.SI);
    }

    /**
     * Return the current matrix as a mass matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return MassMatrix; the current matrix as a mass matrix
     */
    public final MassMatrix asMass(final MassUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MassMatrix", this.toString());
        MassMatrix result = new MassMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a power matrix.
     * @return PowerMatrix; the current matrix as a power matrix
     */
    public final PowerMatrix asPower()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to PowerMatrix", this.toString());
        return new PowerMatrix(this.data, PowerUnit.SI);
    }

    /**
     * Return the current matrix as a power matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return PowerMatrix; the current matrix as a power matrix
     */
    public final PowerMatrix asPower(final PowerUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to PowerMatrix", this.toString());
        PowerMatrix result = new PowerMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a pressure matrix.
     * @return PressureMatrix; the current matrix as a pressure matrix
     */
    public final PressureMatrix asPressure()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to PressureMatrix", this.toString());
        return new PressureMatrix(this.data, PressureUnit.SI);
    }

    /**
     * Return the current matrix as a pressure matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return PressureMatrix; the current matrix as a pressure matrix
     */
    public final PressureMatrix asPressure(final PressureUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to PressureMatrix", this.toString());
        PressureMatrix result = new PressureMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a radioactivity matrix.
     * @return RadioActivityMatrix; the current matrix as a radioactivity matrix
     */
    public final RadioActivityMatrix asRadioActivity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to RadioActivityMatrix", this.toString());
        return new RadioActivityMatrix(this.data, RadioActivityUnit.SI);
    }

    /**
     * Return the current matrix as a radioactivity matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return RadioActivityMatrix; the current matrix as a radioactivity matrix
     */
    public final RadioActivityMatrix asRadioActivity(final RadioActivityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to RadioActivityMatrix", this.toString());
        RadioActivityMatrix result = new RadioActivityMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a speed matrix.
     * @return SpeedMatrix; the current matrix as a speed matrix
     */
    public final SpeedMatrix asSpeed()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to SpeedMatrix", this.toString());
        return new SpeedMatrix(this.data, SpeedUnit.SI);
    }

    /**
     * Return the current matrix as a speed matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return SpeedMatrix; the current matrix as a speed matrix
     */
    public final SpeedMatrix asSpeed(final SpeedUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to SpeedMatrix", this.toString());
        SpeedMatrix result = new SpeedMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a torque matrix.
     * @return TorqueMatrix; the current matrix as a torque matrix
     */
    public final TorqueMatrix asTorque()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to TorqueMatrix", this.toString());
        return new TorqueMatrix(this.data, TorqueUnit.SI);
    }

    /**
     * Return the current matrix as a torque matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return TorqueMatrix; the current matrix as a torque matrix
     */
    public final TorqueMatrix asTorque(final TorqueUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to TorqueMatrix", this.toString());
        TorqueMatrix result = new TorqueMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a volume matrix.
     * @return VolumeMatrix; the current matrix as a volume matrix
     */
    public final VolumeMatrix asVolume()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to VolumeMatrix", this.toString());
        return new VolumeMatrix(this.data, VolumeUnit.SI);
    }

    /**
     * Return the current matrix as a volume matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return VolumeMatrix; the current matrix as a volume matrix
     */
    public final VolumeMatrix asVolume(final VolumeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to VolumeMatrix", this.toString());
        VolumeMatrix result = new VolumeMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a angle matrix.
     * @return AngleMatrix; the current matrix as a angle matrix
     */
    public final AngleMatrix asAngle()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleMatrix", this.toString());
        return new AngleMatrix(this.data, AngleUnit.SI);
    }

    /**
     * Return the current matrix as a angle matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AngleMatrix; the current matrix as a angle matrix
     */
    public final AngleMatrix asAngle(final AngleUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleMatrix", this.toString());
        AngleMatrix result = new AngleMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a length matrix.
     * @return LengthMatrix; the current matrix as a length matrix
     */
    public final LengthMatrix asLength()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LengthMatrix", this.toString());
        return new LengthMatrix(this.data, LengthUnit.SI);
    }

    /**
     * Return the current matrix as a length matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return LengthMatrix; the current matrix as a length matrix
     */
    public final LengthMatrix asLength(final LengthUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LengthMatrix", this.toString());
        LengthMatrix result = new LengthMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a temperature matrix.
     * @return TemperatureMatrix; the current matrix as a temperature matrix
     */
    public final TemperatureMatrix asTemperature()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to TemperatureMatrix", this.toString());
        return new TemperatureMatrix(this.data, TemperatureUnit.SI);
    }

    /**
     * Return the current matrix as a temperature matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return TemperatureMatrix; the current matrix as a temperature matrix
     */
    public final TemperatureMatrix asTemperature(final TemperatureUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to TemperatureMatrix", this.toString());
        TemperatureMatrix result = new TemperatureMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current matrix as a duration matrix.
     * @return DurationMatrix; the current matrix as a duration matrix
     */
    public final DurationMatrix asDuration()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DurationMatrix", this.toString());
        return new DurationMatrix(this.data, DurationUnit.SI);
    }

    /**
     * Return the current matrix as a duration matrix, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return DurationMatrix; the current matrix as a duration matrix
     */
    public final DurationMatrix asDuration(final DurationUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DurationMatrix", this.toString());
        DurationMatrix result = new DurationMatrix(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
