package org.djunits4.value.vfloat.scalar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits4.Throw;
import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueUtil;

/**
 * Easy access methods for the Relative SI FloatScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatSIScalar extends AbstractFloatScalarRel<SIUnit, FloatSIScalar>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct SI scalar.
     * @param value float; the float value
     * @param unit unit for the float value
     */
    public FloatSIScalar(final float value, final SIUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatSIScalar(final FloatSIScalar value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSIScalar instantiateRel(final float value, final SIUnit unit)
    {
        return new FloatSIScalar(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value float; the float value in SI units
     * @param unit SIUnit; the unit to use for the SI scalar
     * @return FloatSIScalar; the new scalar with the SI value
     */
    public static final FloatSIScalar createSI(final float value, final SIUnit unit)
    {
        return new FloatSIScalar(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatSIScalar; the low value
     * @param one FloatSIScalar; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return FloatSIScalar; a Scalar at the ratio between
     */
    public static FloatSIScalar interpolate(final FloatSIScalar zero, final FloatSIScalar one, final float ratio)
    {
        return new FloatSIScalar(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @return FloatSIScalar; the maximum value of two relative scalars
     */
    public static FloatSIScalar max(final FloatSIScalar r1, final FloatSIScalar r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @param rn FloatSIScalar...; the other scalars
     * @return FloatSIScalar; the maximum value of more than two relative scalars
     */
    public static FloatSIScalar max(final FloatSIScalar r1, final FloatSIScalar r2, final FloatSIScalar... rn)
    {
        FloatSIScalar maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatSIScalar r : rn)
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
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @return FloatSIScalar; the minimum value of two relative scalars
     */
    public static FloatSIScalar min(final FloatSIScalar r1, final FloatSIScalar r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @param rn FloatSIScalar...; the other scalars
     * @return FloatSIScalar; the minimum value of more than two relative scalars
     */
    public static FloatSIScalar min(final FloatSIScalar r1, final FloatSIScalar r2, final FloatSIScalar... rn)
    {
        FloatSIScalar minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatSIScalar r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of SI and SI, which results in a FloatDimensionless scalar.
     * @param v FloatSIScalar; SI scalar
     * @return FloatDimensionless scalar as a division of SI and SI
     */
    public final FloatDimensionless divideBy(final FloatSIScalar v)
    {
        return new FloatDimensionless(this.getSI() / v.getSI(), DimensionlessUnit.SI);
    }

    /**********************************************************************************/
    /******************************** 'CAST AS' METHODS *******************************/
    /**********************************************************************************/

    /**
     * Return the current scalar transformed to a scalar in the same scalar type as the example. Of course the SI dimensionality
     * has to match, otherwise the scalar cannot be transformed.
     * @param example K; an example object that serves as the 'template', e.g. Speed.ZERO
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    public final <KU extends Unit<KU>, K extends AbstractFloatScalarRel<KU, K>> K as(final K example)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(example.getUnit().getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), example.toString());
        return example.instantiateRel(this.si, example.getUnit().getUnitBase().getStandardUnit());
    }

    /**
     * Return the current scalar transformed to a scalar in the same scalar type as the example. Of course the SI dimensionality
     * has to match, otherwise the scalar cannot be transformed.
     * @param example K; an example object that serves as the 'template', e.g. Speed.ZERO
     * @param displayUnit KU; the unit in which the value will be displayed
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    public final <KU extends Unit<KU>, K extends AbstractFloatScalarRel<KU, K>> K as(final K example, final KU displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(example.getUnit().getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), example.toString());
        return example.instantiateRel((float) ValueUtil.expressAsUnit(this.si, displayUnit), displayUnit);
    }

    /**
     * Return the current scalar transformed to a scalar in the given class type. Of course the SI dimensionality has to match,
     * otherwise the scalar cannot be transformed.
     * @param returnClass K; the class of the FloatScalar to be constructed
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    @SuppressWarnings("unchecked")
    public final <KU extends Unit<KU>, K extends AbstractFloatScalarRel<KU, K>> K as(final Class<K> returnClass)
    {
        try
        {
            Method createSI = returnClass.getMethod("createSI", float.class);
            K result = (K) createSI.invoke(returnClass, this.si);
            Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(result.getUnit().getUnitBase().getSiDimensions())),
                    UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), result.toString());
            return result;
        }
        catch (InvocationTargetException | NoSuchMethodException | SecurityException | IllegalAccessException
                | IllegalArgumentException exception)
        {
            throw new UnitRuntimeException(exception);
        }
    }

    /**
     * Return the current scalar transformed to a scalar in the given class type. Of course the SI dimensionality has to match,
     * otherwise the scalar cannot be transformed.
     * @param returnClass K; the class of the FloatScalar to be constructed
     * @param displayUnit KU; the unit in which the value will be displayed
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    @SuppressWarnings("unchecked")
    public final <KU extends Unit<KU>, K extends AbstractFloatScalarRel<KU, K>> K as(Class<K> returnClass, final KU displayUnit)
    {
        try
        {
            Method createSI = returnClass.getMethod("createSI", float.class);
            K result = (K) createSI.invoke(returnClass, this.si);
            Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(result.getUnit().getUnitBase().getSiDimensions())),
                    UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), result.toString());
            return result.instantiateRel((float) ValueUtil.expressAsUnit(this.si, displayUnit), displayUnit);
        }
        catch (InvocationTargetException | NoSuchMethodException | SecurityException | IllegalAccessException
                | IllegalArgumentException exception)
        {
            throw new UnitRuntimeException(exception);
        }
    }

        /**
     * Return the current scalar as a absorbeddose.
     * @return FloatAbsorbedDose; the current scalar as a absorbeddose
     */
    public final FloatAbsorbedDose asAbsorbedDose()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAbsorbedDose", this.toString());
        return new FloatAbsorbedDose(getSI(), AbsorbedDoseUnit.SI);
    }

    /**
     * Return the current scalar as a absorbeddose, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAbsorbedDose; the current scalar as a absorbeddose
     */
    public final FloatAbsorbedDose asAbsorbedDose(final AbsorbedDoseUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAbsorbedDose", this.toString());
        return new FloatAbsorbedDose(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a acceleration.
     * @return FloatAcceleration; the current scalar as a acceleration
     */
    public final FloatAcceleration asAcceleration()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAcceleration", this.toString());
        return new FloatAcceleration(getSI(), AccelerationUnit.SI);
    }

    /**
     * Return the current scalar as a acceleration, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAcceleration; the current scalar as a acceleration
     */
    public final FloatAcceleration asAcceleration(final AccelerationUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAcceleration", this.toString());
        return new FloatAcceleration(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a amountofsubstance.
     * @return FloatAmountOfSubstance; the current scalar as a amountofsubstance
     */
    public final FloatAmountOfSubstance asAmountOfSubstance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAmountOfSubstance", this.toString());
        return new FloatAmountOfSubstance(getSI(), AmountOfSubstanceUnit.SI);
    }

    /**
     * Return the current scalar as a amountofsubstance, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAmountOfSubstance; the current scalar as a amountofsubstance
     */
    public final FloatAmountOfSubstance asAmountOfSubstance(final AmountOfSubstanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAmountOfSubstance", this.toString());
        return new FloatAmountOfSubstance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a anglesolid.
     * @return FloatAngleSolid; the current scalar as a anglesolid
     */
    public final FloatAngleSolid asAngleSolid()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleSolidUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAngleSolid", this.toString());
        return new FloatAngleSolid(getSI(), AngleSolidUnit.SI);
    }

    /**
     * Return the current scalar as a anglesolid, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAngleSolid; the current scalar as a anglesolid
     */
    public final FloatAngleSolid asAngleSolid(final AngleSolidUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleSolidUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAngleSolid", this.toString());
        return new FloatAngleSolid(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a area.
     * @return FloatArea; the current scalar as a area
     */
    public final FloatArea asArea()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatArea", this.toString());
        return new FloatArea(getSI(), AreaUnit.SI);
    }

    /**
     * Return the current scalar as a area, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatArea; the current scalar as a area
     */
    public final FloatArea asArea(final AreaUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatArea", this.toString());
        return new FloatArea(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a catalyticactivity.
     * @return FloatCatalyticActivity; the current scalar as a catalyticactivity
     */
    public final FloatCatalyticActivity asCatalyticActivity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatCatalyticActivity", this.toString());
        return new FloatCatalyticActivity(getSI(), CatalyticActivityUnit.SI);
    }

    /**
     * Return the current scalar as a catalyticactivity, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatCatalyticActivity; the current scalar as a catalyticactivity
     */
    public final FloatCatalyticActivity asCatalyticActivity(final CatalyticActivityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatCatalyticActivity", this.toString());
        return new FloatCatalyticActivity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a density.
     * @return FloatDensity; the current scalar as a density
     */
    public final FloatDensity asDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDensity", this.toString());
        return new FloatDensity(getSI(), DensityUnit.SI);
    }

    /**
     * Return the current scalar as a density, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatDensity; the current scalar as a density
     */
    public final FloatDensity asDensity(final DensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDensity", this.toString());
        return new FloatDensity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a dimensionless.
     * @return FloatDimensionless; the current scalar as a dimensionless
     */
    public final FloatDimensionless asDimensionless()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDimensionless", this.toString());
        return new FloatDimensionless(getSI(), DimensionlessUnit.SI);
    }

    /**
     * Return the current scalar as a dimensionless, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatDimensionless; the current scalar as a dimensionless
     */
    public final FloatDimensionless asDimensionless(final DimensionlessUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDimensionless", this.toString());
        return new FloatDimensionless(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a electricalcapacitance.
     * @return FloatElectricalCapacitance; the current scalar as a electricalcapacitance
     */
    public final FloatElectricalCapacitance asElectricalCapacitance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCapacitance", this.toString());
        return new FloatElectricalCapacitance(getSI(), ElectricalCapacitanceUnit.SI);
    }

    /**
     * Return the current scalar as a electricalcapacitance, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalCapacitance; the current scalar as a electricalcapacitance
     */
    public final FloatElectricalCapacitance asElectricalCapacitance(final ElectricalCapacitanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCapacitance", this.toString());
        return new FloatElectricalCapacitance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a electricalcharge.
     * @return FloatElectricalCharge; the current scalar as a electricalcharge
     */
    public final FloatElectricalCharge asElectricalCharge()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCharge", this.toString());
        return new FloatElectricalCharge(getSI(), ElectricalChargeUnit.SI);
    }

    /**
     * Return the current scalar as a electricalcharge, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalCharge; the current scalar as a electricalcharge
     */
    public final FloatElectricalCharge asElectricalCharge(final ElectricalChargeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCharge", this.toString());
        return new FloatElectricalCharge(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a electricalconductance.
     * @return FloatElectricalConductance; the current scalar as a electricalconductance
     */
    public final FloatElectricalConductance asElectricalConductance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalConductance", this.toString());
        return new FloatElectricalConductance(getSI(), ElectricalConductanceUnit.SI);
    }

    /**
     * Return the current scalar as a electricalconductance, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalConductance; the current scalar as a electricalconductance
     */
    public final FloatElectricalConductance asElectricalConductance(final ElectricalConductanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalConductance", this.toString());
        return new FloatElectricalConductance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a electricalcurrent.
     * @return FloatElectricalCurrent; the current scalar as a electricalcurrent
     */
    public final FloatElectricalCurrent asElectricalCurrent()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCurrent", this.toString());
        return new FloatElectricalCurrent(getSI(), ElectricalCurrentUnit.SI);
    }

    /**
     * Return the current scalar as a electricalcurrent, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalCurrent; the current scalar as a electricalcurrent
     */
    public final FloatElectricalCurrent asElectricalCurrent(final ElectricalCurrentUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalCurrent", this.toString());
        return new FloatElectricalCurrent(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a electricalinductance.
     * @return FloatElectricalInductance; the current scalar as a electricalinductance
     */
    public final FloatElectricalInductance asElectricalInductance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalInductance", this.toString());
        return new FloatElectricalInductance(getSI(), ElectricalInductanceUnit.SI);
    }

    /**
     * Return the current scalar as a electricalinductance, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalInductance; the current scalar as a electricalinductance
     */
    public final FloatElectricalInductance asElectricalInductance(final ElectricalInductanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalInductance", this.toString());
        return new FloatElectricalInductance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a electricalpotential.
     * @return FloatElectricalPotential; the current scalar as a electricalpotential
     */
    public final FloatElectricalPotential asElectricalPotential()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalPotential", this.toString());
        return new FloatElectricalPotential(getSI(), ElectricalPotentialUnit.SI);
    }

    /**
     * Return the current scalar as a electricalpotential, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalPotential; the current scalar as a electricalpotential
     */
    public final FloatElectricalPotential asElectricalPotential(final ElectricalPotentialUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalPotential", this.toString());
        return new FloatElectricalPotential(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a electricalresistance.
     * @return FloatElectricalResistance; the current scalar as a electricalresistance
     */
    public final FloatElectricalResistance asElectricalResistance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalResistance", this.toString());
        return new FloatElectricalResistance(getSI(), ElectricalResistanceUnit.SI);
    }

    /**
     * Return the current scalar as a electricalresistance, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatElectricalResistance; the current scalar as a electricalresistance
     */
    public final FloatElectricalResistance asElectricalResistance(final ElectricalResistanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatElectricalResistance", this.toString());
        return new FloatElectricalResistance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a energy.
     * @return FloatEnergy; the current scalar as a energy
     */
    public final FloatEnergy asEnergy()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEnergy", this.toString());
        return new FloatEnergy(getSI(), EnergyUnit.SI);
    }

    /**
     * Return the current scalar as a energy, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatEnergy; the current scalar as a energy
     */
    public final FloatEnergy asEnergy(final EnergyUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEnergy", this.toString());
        return new FloatEnergy(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a equivalentdose.
     * @return FloatEquivalentDose; the current scalar as a equivalentdose
     */
    public final FloatEquivalentDose asEquivalentDose()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEquivalentDose", this.toString());
        return new FloatEquivalentDose(getSI(), EquivalentDoseUnit.SI);
    }

    /**
     * Return the current scalar as a equivalentdose, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatEquivalentDose; the current scalar as a equivalentdose
     */
    public final FloatEquivalentDose asEquivalentDose(final EquivalentDoseUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatEquivalentDose", this.toString());
        return new FloatEquivalentDose(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a flowmass.
     * @return FloatFlowMass; the current scalar as a flowmass
     */
    public final FloatFlowMass asFlowMass()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowMass", this.toString());
        return new FloatFlowMass(getSI(), FlowMassUnit.SI);
    }

    /**
     * Return the current scalar as a flowmass, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatFlowMass; the current scalar as a flowmass
     */
    public final FloatFlowMass asFlowMass(final FlowMassUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowMass", this.toString());
        return new FloatFlowMass(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a flowvolume.
     * @return FloatFlowVolume; the current scalar as a flowvolume
     */
    public final FloatFlowVolume asFlowVolume()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowVolume", this.toString());
        return new FloatFlowVolume(getSI(), FlowVolumeUnit.SI);
    }

    /**
     * Return the current scalar as a flowvolume, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatFlowVolume; the current scalar as a flowvolume
     */
    public final FloatFlowVolume asFlowVolume(final FlowVolumeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFlowVolume", this.toString());
        return new FloatFlowVolume(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a force.
     * @return FloatForce; the current scalar as a force
     */
    public final FloatForce asForce()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatForce", this.toString());
        return new FloatForce(getSI(), ForceUnit.SI);
    }

    /**
     * Return the current scalar as a force, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatForce; the current scalar as a force
     */
    public final FloatForce asForce(final ForceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatForce", this.toString());
        return new FloatForce(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a frequency.
     * @return FloatFrequency; the current scalar as a frequency
     */
    public final FloatFrequency asFrequency()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFrequency", this.toString());
        return new FloatFrequency(getSI(), FrequencyUnit.SI);
    }

    /**
     * Return the current scalar as a frequency, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatFrequency; the current scalar as a frequency
     */
    public final FloatFrequency asFrequency(final FrequencyUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatFrequency", this.toString());
        return new FloatFrequency(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a illuminance.
     * @return FloatIlluminance; the current scalar as a illuminance
     */
    public final FloatIlluminance asIlluminance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatIlluminance", this.toString());
        return new FloatIlluminance(getSI(), IlluminanceUnit.SI);
    }

    /**
     * Return the current scalar as a illuminance, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatIlluminance; the current scalar as a illuminance
     */
    public final FloatIlluminance asIlluminance(final IlluminanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatIlluminance", this.toString());
        return new FloatIlluminance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a lineardensity.
     * @return FloatLinearDensity; the current scalar as a lineardensity
     */
    public final FloatLinearDensity asLinearDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLinearDensity", this.toString());
        return new FloatLinearDensity(getSI(), LinearDensityUnit.SI);
    }

    /**
     * Return the current scalar as a lineardensity, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLinearDensity; the current scalar as a lineardensity
     */
    public final FloatLinearDensity asLinearDensity(final LinearDensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLinearDensity", this.toString());
        return new FloatLinearDensity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a luminousflux.
     * @return FloatLuminousFlux; the current scalar as a luminousflux
     */
    public final FloatLuminousFlux asLuminousFlux()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousFlux", this.toString());
        return new FloatLuminousFlux(getSI(), LuminousFluxUnit.SI);
    }

    /**
     * Return the current scalar as a luminousflux, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLuminousFlux; the current scalar as a luminousflux
     */
    public final FloatLuminousFlux asLuminousFlux(final LuminousFluxUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousFlux", this.toString());
        return new FloatLuminousFlux(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a luminousintensity.
     * @return FloatLuminousIntensity; the current scalar as a luminousintensity
     */
    public final FloatLuminousIntensity asLuminousIntensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousIntensity", this.toString());
        return new FloatLuminousIntensity(getSI(), LuminousIntensityUnit.SI);
    }

    /**
     * Return the current scalar as a luminousintensity, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLuminousIntensity; the current scalar as a luminousintensity
     */
    public final FloatLuminousIntensity asLuminousIntensity(final LuminousIntensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLuminousIntensity", this.toString());
        return new FloatLuminousIntensity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a magneticfluxdensity.
     * @return FloatMagneticFluxDensity; the current scalar as a magneticfluxdensity
     */
    public final FloatMagneticFluxDensity asMagneticFluxDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxDensity", this.toString());
        return new FloatMagneticFluxDensity(getSI(), MagneticFluxDensityUnit.SI);
    }

    /**
     * Return the current scalar as a magneticfluxdensity, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatMagneticFluxDensity; the current scalar as a magneticfluxdensity
     */
    public final FloatMagneticFluxDensity asMagneticFluxDensity(final MagneticFluxDensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFluxDensity", this.toString());
        return new FloatMagneticFluxDensity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a magneticflux.
     * @return FloatMagneticFlux; the current scalar as a magneticflux
     */
    public final FloatMagneticFlux asMagneticFlux()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFlux", this.toString());
        return new FloatMagneticFlux(getSI(), MagneticFluxUnit.SI);
    }

    /**
     * Return the current scalar as a magneticflux, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatMagneticFlux; the current scalar as a magneticflux
     */
    public final FloatMagneticFlux asMagneticFlux(final MagneticFluxUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMagneticFlux", this.toString());
        return new FloatMagneticFlux(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a mass.
     * @return FloatMass; the current scalar as a mass
     */
    public final FloatMass asMass()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMass", this.toString());
        return new FloatMass(getSI(), MassUnit.SI);
    }

    /**
     * Return the current scalar as a mass, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatMass; the current scalar as a mass
     */
    public final FloatMass asMass(final MassUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatMass", this.toString());
        return new FloatMass(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a power.
     * @return FloatPower; the current scalar as a power
     */
    public final FloatPower asPower()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPower", this.toString());
        return new FloatPower(getSI(), PowerUnit.SI);
    }

    /**
     * Return the current scalar as a power, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatPower; the current scalar as a power
     */
    public final FloatPower asPower(final PowerUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPower", this.toString());
        return new FloatPower(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a pressure.
     * @return FloatPressure; the current scalar as a pressure
     */
    public final FloatPressure asPressure()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPressure", this.toString());
        return new FloatPressure(getSI(), PressureUnit.SI);
    }

    /**
     * Return the current scalar as a pressure, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatPressure; the current scalar as a pressure
     */
    public final FloatPressure asPressure(final PressureUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatPressure", this.toString());
        return new FloatPressure(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a radioactivity.
     * @return FloatRadioActivity; the current scalar as a radioactivity
     */
    public final FloatRadioActivity asRadioActivity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatRadioActivity", this.toString());
        return new FloatRadioActivity(getSI(), RadioActivityUnit.SI);
    }

    /**
     * Return the current scalar as a radioactivity, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatRadioActivity; the current scalar as a radioactivity
     */
    public final FloatRadioActivity asRadioActivity(final RadioActivityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatRadioActivity", this.toString());
        return new FloatRadioActivity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a speed.
     * @return FloatSpeed; the current scalar as a speed
     */
    public final FloatSpeed asSpeed()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSpeed", this.toString());
        return new FloatSpeed(getSI(), SpeedUnit.SI);
    }

    /**
     * Return the current scalar as a speed, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatSpeed; the current scalar as a speed
     */
    public final FloatSpeed asSpeed(final SpeedUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatSpeed", this.toString());
        return new FloatSpeed(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a torque.
     * @return FloatTorque; the current scalar as a torque
     */
    public final FloatTorque asTorque()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTorque", this.toString());
        return new FloatTorque(getSI(), TorqueUnit.SI);
    }

    /**
     * Return the current scalar as a torque, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatTorque; the current scalar as a torque
     */
    public final FloatTorque asTorque(final TorqueUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTorque", this.toString());
        return new FloatTorque(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a volume.
     * @return FloatVolume; the current scalar as a volume
     */
    public final FloatVolume asVolume()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatVolume", this.toString());
        return new FloatVolume(getSI(), VolumeUnit.SI);
    }

    /**
     * Return the current scalar as a volume, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatVolume; the current scalar as a volume
     */
    public final FloatVolume asVolume(final VolumeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatVolume", this.toString());
        return new FloatVolume(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a angle.
     * @return FloatAngle; the current scalar as a angle
     */
    public final FloatAngle asAngle()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAngle", this.toString());
        return new FloatAngle(getSI(), AngleUnit.SI);
    }

    /**
     * Return the current scalar as a angle, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatAngle; the current scalar as a angle
     */
    public final FloatAngle asAngle(final AngleUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatAngle", this.toString());
        return new FloatAngle(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a length.
     * @return FloatLength; the current scalar as a length
     */
    public final FloatLength asLength()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLength", this.toString());
        return new FloatLength(getSI(), LengthUnit.SI);
    }

    /**
     * Return the current scalar as a length, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatLength; the current scalar as a length
     */
    public final FloatLength asLength(final LengthUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatLength", this.toString());
        return new FloatLength(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a temperature.
     * @return FloatTemperature; the current scalar as a temperature
     */
    public final FloatTemperature asTemperature()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTemperature", this.toString());
        return new FloatTemperature(getSI(), TemperatureUnit.SI);
    }

    /**
     * Return the current scalar as a temperature, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatTemperature; the current scalar as a temperature
     */
    public final FloatTemperature asTemperature(final TemperatureUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatTemperature", this.toString());
        return new FloatTemperature(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }
    /**
     * Return the current scalar as a duration.
     * @return FloatDuration; the current scalar as a duration
     */
    public final FloatDuration asDuration()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDuration", this.toString());
        return new FloatDuration(getSI(), DurationUnit.SI);
    }

    /**
     * Return the current scalar as a duration, and provide a display unit.
     * @param displayUnit the unit in which the value will be displayed
     * @return FloatDuration; the current scalar as a duration
     */
    public final FloatDuration asDuration(final DurationUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FloatDuration", this.toString());
        return new FloatDuration(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }


}
