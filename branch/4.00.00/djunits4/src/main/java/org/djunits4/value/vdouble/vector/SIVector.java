package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

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
import org.djunits4.value.vdouble.scalar.SIScalar;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.base.DoubleVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Easy access methods for the generic Relative SI DoubleVector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class SIVector extends AbstractDoubleVectorRel<SIUnit, SIScalar, SIVector>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct a new Relative Double SIVector.
     * @param values double[]; the values of the entries in the new Relative Double SIVector
     * @param unit SIUnit; the unit of the new Relative Double SIVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return SIVector; the SIVector of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static SIVector create(final double[] values, final SIUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        return new SIVector(DoubleVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Double SIVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Double SIVector
     * @param unit SIUnit; the unit of the new Relative Double SIVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return SIVector; the SIVector of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static SIVector create(final List<Double> values, final SIUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        return new SIVector(DoubleVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Double SIVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Double SIVector
     * @param unit SIUnit; the unit of the new Relative Sparse Double SIVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return SIVector; the SIVector of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static SIVector create(final SortedMap<Integer, Double> values, final SIUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        return DoubleVector.create(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit SIUnit; the unit
     */
    public SIVector(final DoubleVectorData data, final SIUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<SIScalar> getScalarClass()
    {
        return SIScalar.class;
    }

    /**
     * Returns an SIVector based on an array of values and the textual representation of the unit.
     * @param value double[]; the values to use
     * @param unitString String; the textual representation of the unit
     * @param storageType StorageType; the storage type to use
     * @return SIVector; the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static SIVector of(final double[] value, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(value, "Error parsing SIVector: value is null");
        Throw.whenNull(unitString, "Error parsing SIVector: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing SIVector: empty unitString");
        Throw.whenNull(storageType, "Error parsing SIVector: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return SIVector.create(value, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing SIVector with unit " + unitString);
    }

    /**
     * Returns an SIVector based on an array of values and the textual representation of the unit.
     * @param valueList List&lt;Double&gt;; the values to use
     * @param unitString String; the textual representation of the unit
     * @param storageType StorageType; the storage type to use
     * @return SIVector; the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static SIVector of(final List<Double> valueList, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(valueList, "Error parsing SIVector: valueList is null");
        Throw.whenNull(unitString, "Error parsing SIVector: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing SIVector: empty unitString");
        Throw.whenNull(storageType, "Error parsing SIVector: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return SIVector.create(valueList, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing SIVector with unit " + unitString);
    }

    /**
     * Returns an SIVector based on a (sparse) map of values and the textual representation of the unit.
     * @param valueMap SortedMap&lt;Integer, Double&gt;; the values to use
     * @param unitString String; the textual representation of the unit
     * @param length int; the size of the vector
     * @param storageType StorageType; the storage type to use
     * @return SIVector; the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static SIVector of(final SortedMap<Integer, Double> valueMap, final String unitString, final int length,
            final StorageType storageType)
    {
        Throw.whenNull(valueMap, "Error parsing SIVector: valueMap is null");
        Throw.whenNull(unitString, "Error parsing SIVector: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing SIVector: empty unitString");
        Throw.whenNull(storageType, "Error parsing SIVector: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return SIVector.create(valueMap, unit, length, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing SIVector with unit " + unitString);
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
    public final <U extends Unit<U>, S extends AbstractDoubleScalarRel<U, S>,
            V extends AbstractDoubleVectorRel<U, S, V>> V as(final U displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(displayUnit.getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "SIVector with unit %s cannot be converted to a vector with unit %s", getUnit(),
                displayUnit);
        V result = DoubleVector.instantiate(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a absorbeddose vector.
     * @return AbsorbedDoseVector; the current vector as a absorbeddose vector
     */
    public final AbsorbedDoseVector asAbsorbedDose()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AbsorbedDoseVector", this.toString());
        return new AbsorbedDoseVector(this.data, AbsorbedDoseUnit.SI);
    }

    /**
     * Return the current vector as a absorbeddose vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AbsorbedDoseVector; the current vector as a absorbeddose vector
     */
    public final AbsorbedDoseVector asAbsorbedDose(final AbsorbedDoseUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AbsorbedDoseVector", this.toString());
        AbsorbedDoseVector result = new AbsorbedDoseVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a acceleration vector.
     * @return AccelerationVector; the current vector as a acceleration vector
     */
    public final AccelerationVector asAcceleration()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AccelerationVector", this.toString());
        return new AccelerationVector(this.data, AccelerationUnit.SI);
    }

    /**
     * Return the current vector as a acceleration vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AccelerationVector; the current vector as a acceleration vector
     */
    public final AccelerationVector asAcceleration(final AccelerationUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AccelerationVector", this.toString());
        AccelerationVector result = new AccelerationVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a amountofsubstance vector.
     * @return AmountOfSubstanceVector; the current vector as a amountofsubstance vector
     */
    public final AmountOfSubstanceVector asAmountOfSubstance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AmountOfSubstanceVector", this.toString());
        return new AmountOfSubstanceVector(this.data, AmountOfSubstanceUnit.SI);
    }

    /**
     * Return the current vector as a amountofsubstance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AmountOfSubstanceVector; the current vector as a amountofsubstance vector
     */
    public final AmountOfSubstanceVector asAmountOfSubstance(final AmountOfSubstanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AmountOfSubstanceVector", this.toString());
        AmountOfSubstanceVector result = new AmountOfSubstanceVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a anglesolid vector.
     * @return AngleSolidVector; the current vector as a anglesolid vector
     */
    public final AngleSolidVector asAngleSolid()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleSolidUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleSolidVector", this.toString());
        return new AngleSolidVector(this.data, AngleSolidUnit.SI);
    }

    /**
     * Return the current vector as a anglesolid vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AngleSolidVector; the current vector as a anglesolid vector
     */
    public final AngleSolidVector asAngleSolid(final AngleSolidUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleSolidUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleSolidVector", this.toString());
        AngleSolidVector result = new AngleSolidVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a area vector.
     * @return AreaVector; the current vector as a area vector
     */
    public final AreaVector asArea()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AreaVector", this.toString());
        return new AreaVector(this.data, AreaUnit.SI);
    }

    /**
     * Return the current vector as a area vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AreaVector; the current vector as a area vector
     */
    public final AreaVector asArea(final AreaUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AreaVector", this.toString());
        AreaVector result = new AreaVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a catalyticactivity vector.
     * @return CatalyticActivityVector; the current vector as a catalyticactivity vector
     */
    public final CatalyticActivityVector asCatalyticActivity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to CatalyticActivityVector", this.toString());
        return new CatalyticActivityVector(this.data, CatalyticActivityUnit.SI);
    }

    /**
     * Return the current vector as a catalyticactivity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return CatalyticActivityVector; the current vector as a catalyticactivity vector
     */
    public final CatalyticActivityVector asCatalyticActivity(final CatalyticActivityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to CatalyticActivityVector", this.toString());
        CatalyticActivityVector result = new CatalyticActivityVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a density vector.
     * @return DensityVector; the current vector as a density vector
     */
    public final DensityVector asDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DensityVector", this.toString());
        return new DensityVector(this.data, DensityUnit.SI);
    }

    /**
     * Return the current vector as a density vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return DensityVector; the current vector as a density vector
     */
    public final DensityVector asDensity(final DensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DensityVector", this.toString());
        DensityVector result = new DensityVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a dimensionless vector.
     * @return DimensionlessVector; the current vector as a dimensionless vector
     */
    public final DimensionlessVector asDimensionless()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DimensionlessVector", this.toString());
        return new DimensionlessVector(this.data, DimensionlessUnit.SI);
    }

    /**
     * Return the current vector as a dimensionless vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return DimensionlessVector; the current vector as a dimensionless vector
     */
    public final DimensionlessVector asDimensionless(final DimensionlessUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DimensionlessVector", this.toString());
        DimensionlessVector result = new DimensionlessVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalcapacitance vector.
     * @return ElectricalCapacitanceVector; the current vector as a electricalcapacitance vector
     */
    public final ElectricalCapacitanceVector asElectricalCapacitance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCapacitanceVector", this.toString());
        return new ElectricalCapacitanceVector(this.data, ElectricalCapacitanceUnit.SI);
    }

    /**
     * Return the current vector as a electricalcapacitance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalCapacitanceVector; the current vector as a electricalcapacitance vector
     */
    public final ElectricalCapacitanceVector asElectricalCapacitance(final ElectricalCapacitanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCapacitanceVector", this.toString());
        ElectricalCapacitanceVector result = new ElectricalCapacitanceVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalcharge vector.
     * @return ElectricalChargeVector; the current vector as a electricalcharge vector
     */
    public final ElectricalChargeVector asElectricalCharge()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalChargeVector", this.toString());
        return new ElectricalChargeVector(this.data, ElectricalChargeUnit.SI);
    }

    /**
     * Return the current vector as a electricalcharge vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalChargeVector; the current vector as a electricalcharge vector
     */
    public final ElectricalChargeVector asElectricalCharge(final ElectricalChargeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalChargeVector", this.toString());
        ElectricalChargeVector result = new ElectricalChargeVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalconductance vector.
     * @return ElectricalConductanceVector; the current vector as a electricalconductance vector
     */
    public final ElectricalConductanceVector asElectricalConductance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalConductanceVector", this.toString());
        return new ElectricalConductanceVector(this.data, ElectricalConductanceUnit.SI);
    }

    /**
     * Return the current vector as a electricalconductance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalConductanceVector; the current vector as a electricalconductance vector
     */
    public final ElectricalConductanceVector asElectricalConductance(final ElectricalConductanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalConductanceVector", this.toString());
        ElectricalConductanceVector result = new ElectricalConductanceVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalcurrent vector.
     * @return ElectricalCurrentVector; the current vector as a electricalcurrent vector
     */
    public final ElectricalCurrentVector asElectricalCurrent()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCurrentVector", this.toString());
        return new ElectricalCurrentVector(this.data, ElectricalCurrentUnit.SI);
    }

    /**
     * Return the current vector as a electricalcurrent vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalCurrentVector; the current vector as a electricalcurrent vector
     */
    public final ElectricalCurrentVector asElectricalCurrent(final ElectricalCurrentUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCurrentVector", this.toString());
        ElectricalCurrentVector result = new ElectricalCurrentVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalinductance vector.
     * @return ElectricalInductanceVector; the current vector as a electricalinductance vector
     */
    public final ElectricalInductanceVector asElectricalInductance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalInductanceVector", this.toString());
        return new ElectricalInductanceVector(this.data, ElectricalInductanceUnit.SI);
    }

    /**
     * Return the current vector as a electricalinductance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalInductanceVector; the current vector as a electricalinductance vector
     */
    public final ElectricalInductanceVector asElectricalInductance(final ElectricalInductanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalInductanceVector", this.toString());
        ElectricalInductanceVector result = new ElectricalInductanceVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalpotential vector.
     * @return ElectricalPotentialVector; the current vector as a electricalpotential vector
     */
    public final ElectricalPotentialVector asElectricalPotential()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalPotentialVector", this.toString());
        return new ElectricalPotentialVector(this.data, ElectricalPotentialUnit.SI);
    }

    /**
     * Return the current vector as a electricalpotential vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalPotentialVector; the current vector as a electricalpotential vector
     */
    public final ElectricalPotentialVector asElectricalPotential(final ElectricalPotentialUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalPotentialVector", this.toString());
        ElectricalPotentialVector result = new ElectricalPotentialVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a electricalresistance vector.
     * @return ElectricalResistanceVector; the current vector as a electricalresistance vector
     */
    public final ElectricalResistanceVector asElectricalResistance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalResistanceVector", this.toString());
        return new ElectricalResistanceVector(this.data, ElectricalResistanceUnit.SI);
    }

    /**
     * Return the current vector as a electricalresistance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ElectricalResistanceVector; the current vector as a electricalresistance vector
     */
    public final ElectricalResistanceVector asElectricalResistance(final ElectricalResistanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalResistanceVector", this.toString());
        ElectricalResistanceVector result = new ElectricalResistanceVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a energy vector.
     * @return EnergyVector; the current vector as a energy vector
     */
    public final EnergyVector asEnergy()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EnergyVector", this.toString());
        return new EnergyVector(this.data, EnergyUnit.SI);
    }

    /**
     * Return the current vector as a energy vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return EnergyVector; the current vector as a energy vector
     */
    public final EnergyVector asEnergy(final EnergyUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EnergyVector", this.toString());
        EnergyVector result = new EnergyVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a equivalentdose vector.
     * @return EquivalentDoseVector; the current vector as a equivalentdose vector
     */
    public final EquivalentDoseVector asEquivalentDose()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EquivalentDoseVector", this.toString());
        return new EquivalentDoseVector(this.data, EquivalentDoseUnit.SI);
    }

    /**
     * Return the current vector as a equivalentdose vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return EquivalentDoseVector; the current vector as a equivalentdose vector
     */
    public final EquivalentDoseVector asEquivalentDose(final EquivalentDoseUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EquivalentDoseVector", this.toString());
        EquivalentDoseVector result = new EquivalentDoseVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a flowmass vector.
     * @return FlowMassVector; the current vector as a flowmass vector
     */
    public final FlowMassVector asFlowMass()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowMassVector", this.toString());
        return new FlowMassVector(this.data, FlowMassUnit.SI);
    }

    /**
     * Return the current vector as a flowmass vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FlowMassVector; the current vector as a flowmass vector
     */
    public final FlowMassVector asFlowMass(final FlowMassUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowMassVector", this.toString());
        FlowMassVector result = new FlowMassVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a flowvolume vector.
     * @return FlowVolumeVector; the current vector as a flowvolume vector
     */
    public final FlowVolumeVector asFlowVolume()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowVolumeVector", this.toString());
        return new FlowVolumeVector(this.data, FlowVolumeUnit.SI);
    }

    /**
     * Return the current vector as a flowvolume vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FlowVolumeVector; the current vector as a flowvolume vector
     */
    public final FlowVolumeVector asFlowVolume(final FlowVolumeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowVolumeVector", this.toString());
        FlowVolumeVector result = new FlowVolumeVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a force vector.
     * @return ForceVector; the current vector as a force vector
     */
    public final ForceVector asForce()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ForceVector", this.toString());
        return new ForceVector(this.data, ForceUnit.SI);
    }

    /**
     * Return the current vector as a force vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return ForceVector; the current vector as a force vector
     */
    public final ForceVector asForce(final ForceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ForceVector", this.toString());
        ForceVector result = new ForceVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a frequency vector.
     * @return FrequencyVector; the current vector as a frequency vector
     */
    public final FrequencyVector asFrequency()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FrequencyVector", this.toString());
        return new FrequencyVector(this.data, FrequencyUnit.SI);
    }

    /**
     * Return the current vector as a frequency vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FrequencyVector; the current vector as a frequency vector
     */
    public final FrequencyVector asFrequency(final FrequencyUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FrequencyVector", this.toString());
        FrequencyVector result = new FrequencyVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a illuminance vector.
     * @return IlluminanceVector; the current vector as a illuminance vector
     */
    public final IlluminanceVector asIlluminance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to IlluminanceVector", this.toString());
        return new IlluminanceVector(this.data, IlluminanceUnit.SI);
    }

    /**
     * Return the current vector as a illuminance vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return IlluminanceVector; the current vector as a illuminance vector
     */
    public final IlluminanceVector asIlluminance(final IlluminanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to IlluminanceVector", this.toString());
        IlluminanceVector result = new IlluminanceVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a lineardensity vector.
     * @return LinearDensityVector; the current vector as a lineardensity vector
     */
    public final LinearDensityVector asLinearDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LinearDensityVector", this.toString());
        return new LinearDensityVector(this.data, LinearDensityUnit.SI);
    }

    /**
     * Return the current vector as a lineardensity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return LinearDensityVector; the current vector as a lineardensity vector
     */
    public final LinearDensityVector asLinearDensity(final LinearDensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LinearDensityVector", this.toString());
        LinearDensityVector result = new LinearDensityVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a luminousflux vector.
     * @return LuminousFluxVector; the current vector as a luminousflux vector
     */
    public final LuminousFluxVector asLuminousFlux()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousFluxVector", this.toString());
        return new LuminousFluxVector(this.data, LuminousFluxUnit.SI);
    }

    /**
     * Return the current vector as a luminousflux vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return LuminousFluxVector; the current vector as a luminousflux vector
     */
    public final LuminousFluxVector asLuminousFlux(final LuminousFluxUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousFluxVector", this.toString());
        LuminousFluxVector result = new LuminousFluxVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a luminousintensity vector.
     * @return LuminousIntensityVector; the current vector as a luminousintensity vector
     */
    public final LuminousIntensityVector asLuminousIntensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousIntensityVector", this.toString());
        return new LuminousIntensityVector(this.data, LuminousIntensityUnit.SI);
    }

    /**
     * Return the current vector as a luminousintensity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return LuminousIntensityVector; the current vector as a luminousintensity vector
     */
    public final LuminousIntensityVector asLuminousIntensity(final LuminousIntensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousIntensityVector", this.toString());
        LuminousIntensityVector result = new LuminousIntensityVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a magneticfluxdensity vector.
     * @return MagneticFluxDensityVector; the current vector as a magneticfluxdensity vector
     */
    public final MagneticFluxDensityVector asMagneticFluxDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxDensityVector", this.toString());
        return new MagneticFluxDensityVector(this.data, MagneticFluxDensityUnit.SI);
    }

    /**
     * Return the current vector as a magneticfluxdensity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return MagneticFluxDensityVector; the current vector as a magneticfluxdensity vector
     */
    public final MagneticFluxDensityVector asMagneticFluxDensity(final MagneticFluxDensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxDensityVector", this.toString());
        MagneticFluxDensityVector result = new MagneticFluxDensityVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a magneticflux vector.
     * @return MagneticFluxVector; the current vector as a magneticflux vector
     */
    public final MagneticFluxVector asMagneticFlux()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxVector", this.toString());
        return new MagneticFluxVector(this.data, MagneticFluxUnit.SI);
    }

    /**
     * Return the current vector as a magneticflux vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return MagneticFluxVector; the current vector as a magneticflux vector
     */
    public final MagneticFluxVector asMagneticFlux(final MagneticFluxUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxVector", this.toString());
        MagneticFluxVector result = new MagneticFluxVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a mass vector.
     * @return MassVector; the current vector as a mass vector
     */
    public final MassVector asMass()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MassVector", this.toString());
        return new MassVector(this.data, MassUnit.SI);
    }

    /**
     * Return the current vector as a mass vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return MassVector; the current vector as a mass vector
     */
    public final MassVector asMass(final MassUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MassVector", this.toString());
        MassVector result = new MassVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a power vector.
     * @return PowerVector; the current vector as a power vector
     */
    public final PowerVector asPower()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to PowerVector", this.toString());
        return new PowerVector(this.data, PowerUnit.SI);
    }

    /**
     * Return the current vector as a power vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return PowerVector; the current vector as a power vector
     */
    public final PowerVector asPower(final PowerUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to PowerVector", this.toString());
        PowerVector result = new PowerVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a pressure vector.
     * @return PressureVector; the current vector as a pressure vector
     */
    public final PressureVector asPressure()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to PressureVector", this.toString());
        return new PressureVector(this.data, PressureUnit.SI);
    }

    /**
     * Return the current vector as a pressure vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return PressureVector; the current vector as a pressure vector
     */
    public final PressureVector asPressure(final PressureUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to PressureVector", this.toString());
        PressureVector result = new PressureVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a radioactivity vector.
     * @return RadioActivityVector; the current vector as a radioactivity vector
     */
    public final RadioActivityVector asRadioActivity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to RadioActivityVector", this.toString());
        return new RadioActivityVector(this.data, RadioActivityUnit.SI);
    }

    /**
     * Return the current vector as a radioactivity vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return RadioActivityVector; the current vector as a radioactivity vector
     */
    public final RadioActivityVector asRadioActivity(final RadioActivityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to RadioActivityVector", this.toString());
        RadioActivityVector result = new RadioActivityVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a speed vector.
     * @return SpeedVector; the current vector as a speed vector
     */
    public final SpeedVector asSpeed()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to SpeedVector", this.toString());
        return new SpeedVector(this.data, SpeedUnit.SI);
    }

    /**
     * Return the current vector as a speed vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return SpeedVector; the current vector as a speed vector
     */
    public final SpeedVector asSpeed(final SpeedUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to SpeedVector", this.toString());
        SpeedVector result = new SpeedVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a torque vector.
     * @return TorqueVector; the current vector as a torque vector
     */
    public final TorqueVector asTorque()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to TorqueVector", this.toString());
        return new TorqueVector(this.data, TorqueUnit.SI);
    }

    /**
     * Return the current vector as a torque vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return TorqueVector; the current vector as a torque vector
     */
    public final TorqueVector asTorque(final TorqueUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to TorqueVector", this.toString());
        TorqueVector result = new TorqueVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a volume vector.
     * @return VolumeVector; the current vector as a volume vector
     */
    public final VolumeVector asVolume()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to VolumeVector", this.toString());
        return new VolumeVector(this.data, VolumeUnit.SI);
    }

    /**
     * Return the current vector as a volume vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return VolumeVector; the current vector as a volume vector
     */
    public final VolumeVector asVolume(final VolumeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to VolumeVector", this.toString());
        VolumeVector result = new VolumeVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a angle vector.
     * @return AngleVector; the current vector as a angle vector
     */
    public final AngleVector asAngle()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleVector", this.toString());
        return new AngleVector(this.data, AngleUnit.SI);
    }

    /**
     * Return the current vector as a angle vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return AngleVector; the current vector as a angle vector
     */
    public final AngleVector asAngle(final AngleUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleVector", this.toString());
        AngleVector result = new AngleVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a length vector.
     * @return LengthVector; the current vector as a length vector
     */
    public final LengthVector asLength()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LengthVector", this.toString());
        return new LengthVector(this.data, LengthUnit.SI);
    }

    /**
     * Return the current vector as a length vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return LengthVector; the current vector as a length vector
     */
    public final LengthVector asLength(final LengthUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LengthVector", this.toString());
        LengthVector result = new LengthVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a temperature vector.
     * @return TemperatureVector; the current vector as a temperature vector
     */
    public final TemperatureVector asTemperature()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to TemperatureVector", this.toString());
        return new TemperatureVector(this.data, TemperatureUnit.SI);
    }

    /**
     * Return the current vector as a temperature vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return TemperatureVector; the current vector as a temperature vector
     */
    public final TemperatureVector asTemperature(final TemperatureUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to TemperatureVector", this.toString());
        TemperatureVector result = new TemperatureVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /**
     * Return the current vector as a duration vector.
     * @return DurationVector; the current vector as a duration vector
     */
    public final DurationVector asDuration()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DurationVector", this.toString());
        return new DurationVector(this.data, DurationUnit.SI);
    }

    /**
     * Return the current vector as a duration vector, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return DurationVector; the current vector as a duration vector
     */
    public final DurationVector asDuration(final DurationUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to DurationVector", this.toString());
        DurationVector result = new DurationVector(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
