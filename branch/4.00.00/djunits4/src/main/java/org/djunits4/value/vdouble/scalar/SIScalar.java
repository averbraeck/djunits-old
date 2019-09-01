package org.djunits4.value.vdouble.scalar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueUtil;

/**
 * Easy access methods for the generic Relative SI DoubleScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class SIScalar extends AbstractDoubleScalarRel<SIUnit, SIScalar>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct SI scalar.
     * @param value double; double value
     * @param unit SIUnit; unit for the double value
     */
    public SIScalar(final double value, final SIUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value SIScalar; Scalar from which to construct this instance
     */
    public SIScalar(final SIScalar value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final SIScalar instantiateRel(final double value, final SIUnit unit)
    {
        return new SIScalar(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value double; double value in SI units
     * @param unit SIUnit; the unit to use for the SI scalar
     * @return the new scalar with the SI value
     */
    public static final SIScalar createSI(final double value, final SIUnit unit)
    {
        return new SIScalar(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero SIScalar; the low value
     * @param one SIScalar; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static SIScalar interpolate(final SIScalar zero, final SIScalar one, final double ratio)
    {
        return new SIScalar(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 SIScalar; the first scalar
     * @param r2 SIScalar; the second scalar
     * @return the maximum value of two relative scalars
     */
    public static SIScalar max(final SIScalar r1, final SIScalar r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 SIScalar; the first scalar
     * @param r2 SIScalar; the second scalar
     * @param rn SIScalar...; the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static SIScalar max(final SIScalar r1, final SIScalar r2, final SIScalar... rn)
    {
        SIScalar maxr = (r1.gt(r2)) ? r1 : r2;
        for (SIScalar r : rn)
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
     * @param r1 SIScalar; the first scalar
     * @param r2 SIScalar; the second scalar
     * @return the minimum value of two relative scalars
     */
    public static SIScalar min(final SIScalar r1, final SIScalar r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 SIScalar; the first scalar
     * @param r2 SIScalar; the second scalar
     * @param rn SIScalar...; the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static SIScalar min(final SIScalar r1, final SIScalar r2, final SIScalar... rn)
    {
        SIScalar minr = (r1.lt(r2)) ? r1 : r2;
        for (SIScalar r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of SI and SI, which results in a Dimensionless scalar.
     * @param v SIScalar; SI scalar
     * @return Dimensionless scalar as a division of SI and SI
     */
    public final Dimensionless divideBy(final SIScalar v)
    {
        return new Dimensionless(this.getSI() / v.getSI(), DimensionlessUnit.SI);
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
    public final <KU extends Unit<KU>, K extends AbstractDoubleScalarRel<KU, K>> K as(final K example)
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
    public final <KU extends Unit<KU>, K extends AbstractDoubleScalarRel<KU, K>> K as(final K example, final KU displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(example.getUnit().getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), example.toString());
        return example.instantiateRel(ValueUtil.expressAsUnit(this.si, displayUnit), displayUnit);
    }

    /**
     * Return the current scalar transformed to a scalar in the given class type. Of course the SI dimensionality has to match,
     * otherwise the scalar cannot be transformed.
     * @param returnClass Class&lt;K&gt;; the class of the
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    @SuppressWarnings("unchecked")
    public final <KU extends Unit<KU>, K extends AbstractDoubleScalarRel<KU, K>> K as(final Class<K> returnClass)
    {
        try
        {
            Method createSI = returnClass.getMethod("createSI", double.class);
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
     * @param returnClass Class&lt;K&gt;; the class of the
     * @param displayUnit KU; the unit in which the value will be displayed
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    @SuppressWarnings("unchecked")
    public final <KU extends Unit<KU>, K extends AbstractDoubleScalarRel<KU, K>> K as(Class<K> returnClass,
            final KU displayUnit)
    {
        try
        {
            Method createSI = returnClass.getMethod("createSI", double.class);
            K result = (K) createSI.invoke(returnClass, this.si);
            Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(result.getUnit().getUnitBase().getSiDimensions())),
                    UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), result.toString());
            return result.instantiateRel(ValueUtil.expressAsUnit(this.si, displayUnit), displayUnit);
        }
        catch (InvocationTargetException | NoSuchMethodException | SecurityException | IllegalAccessException
                | IllegalArgumentException exception)
        {
            throw new UnitRuntimeException(exception);
        }
    }

    /**
     * Return the current scalar as a absorbeddose.
     * @return AbsorbedDose; the current scalar as a absorbeddose
     */
    public final AbsorbedDose asAbsorbedDose()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AbsorbedDose", this.toString());
        return new AbsorbedDose(getSI(), AbsorbedDoseUnit.SI);
    }

    /**
     * Return the current scalar as a absorbeddose, and provide a display unit.
     * @param displayUnit AbsorbedDoseUnit; the unit in which the value will be displayed
     * @return AbsorbedDose; the current scalar as a absorbeddose
     */
    public final AbsorbedDose asAbsorbedDose(final AbsorbedDoseUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AbsorbedDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AbsorbedDose", this.toString());
        return new AbsorbedDose(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a acceleration.
     * @return Acceleration; the current scalar as a acceleration
     */
    public final Acceleration asAcceleration()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Acceleration", this.toString());
        return new Acceleration(getSI(), AccelerationUnit.SI);
    }

    /**
     * Return the current scalar as a acceleration, and provide a display unit.
     * @param displayUnit AccelerationUnit; the unit in which the value will be displayed
     * @return Acceleration; the current scalar as a acceleration
     */
    public final Acceleration asAcceleration(final AccelerationUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AccelerationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Acceleration", this.toString());
        return new Acceleration(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a amountofsubstance.
     * @return AmountOfSubstance; the current scalar as a amountofsubstance
     */
    public final AmountOfSubstance asAmountOfSubstance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AmountOfSubstance", this.toString());
        return new AmountOfSubstance(getSI(), AmountOfSubstanceUnit.SI);
    }

    /**
     * Return the current scalar as a amountofsubstance, and provide a display unit.
     * @param displayUnit AmountOfSubstanceUnit; the unit in which the value will be displayed
     * @return AmountOfSubstance; the current scalar as a amountofsubstance
     */
    public final AmountOfSubstance asAmountOfSubstance(final AmountOfSubstanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AmountOfSubstanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AmountOfSubstance", this.toString());
        return new AmountOfSubstance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a anglesolid.
     * @return AngleSolid; the current scalar as a anglesolid
     */
    public final AngleSolid asAngleSolid()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleSolidUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleSolid", this.toString());
        return new AngleSolid(getSI(), AngleSolidUnit.SI);
    }

    /**
     * Return the current scalar as a anglesolid, and provide a display unit.
     * @param displayUnit AngleSolidUnit; the unit in which the value will be displayed
     * @return AngleSolid; the current scalar as a anglesolid
     */
    public final AngleSolid asAngleSolid(final AngleSolidUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleSolidUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to AngleSolid", this.toString());
        return new AngleSolid(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a area.
     * @return Area; the current scalar as a area
     */
    public final Area asArea()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Area", this.toString());
        return new Area(getSI(), AreaUnit.SI);
    }

    /**
     * Return the current scalar as a area, and provide a display unit.
     * @param displayUnit AreaUnit; the unit in which the value will be displayed
     * @return Area; the current scalar as a area
     */
    public final Area asArea(final AreaUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AreaUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Area", this.toString());
        return new Area(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a catalyticactivity.
     * @return CatalyticActivity; the current scalar as a catalyticactivity
     */
    public final CatalyticActivity asCatalyticActivity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to CatalyticActivity", this.toString());
        return new CatalyticActivity(getSI(), CatalyticActivityUnit.SI);
    }

    /**
     * Return the current scalar as a catalyticactivity, and provide a display unit.
     * @param displayUnit CatalyticActivityUnit; the unit in which the value will be displayed
     * @return CatalyticActivity; the current scalar as a catalyticactivity
     */
    public final CatalyticActivity asCatalyticActivity(final CatalyticActivityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(CatalyticActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to CatalyticActivity", this.toString());
        return new CatalyticActivity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a density.
     * @return Density; the current scalar as a density
     */
    public final Density asDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Density", this.toString());
        return new Density(getSI(), DensityUnit.SI);
    }

    /**
     * Return the current scalar as a density, and provide a display unit.
     * @param displayUnit DensityUnit; the unit in which the value will be displayed
     * @return Density; the current scalar as a density
     */
    public final Density asDensity(final DensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Density", this.toString());
        return new Density(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a dimensionless.
     * @return Dimensionless; the current scalar as a dimensionless
     */
    public final Dimensionless asDimensionless()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Dimensionless", this.toString());
        return new Dimensionless(getSI(), DimensionlessUnit.SI);
    }

    /**
     * Return the current scalar as a dimensionless, and provide a display unit.
     * @param displayUnit DimensionlessUnit; the unit in which the value will be displayed
     * @return Dimensionless; the current scalar as a dimensionless
     */
    public final Dimensionless asDimensionless(final DimensionlessUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DimensionlessUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Dimensionless", this.toString());
        return new Dimensionless(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a electricalcapacitance.
     * @return ElectricalCapacitance; the current scalar as a electricalcapacitance
     */
    public final ElectricalCapacitance asElectricalCapacitance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCapacitance", this.toString());
        return new ElectricalCapacitance(getSI(), ElectricalCapacitanceUnit.SI);
    }

    /**
     * Return the current scalar as a electricalcapacitance, and provide a display unit.
     * @param displayUnit ElectricalCapacitanceUnit; the unit in which the value will be displayed
     * @return ElectricalCapacitance; the current scalar as a electricalcapacitance
     */
    public final ElectricalCapacitance asElectricalCapacitance(final ElectricalCapacitanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCapacitanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCapacitance", this.toString());
        return new ElectricalCapacitance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a electricalcharge.
     * @return ElectricalCharge; the current scalar as a electricalcharge
     */
    public final ElectricalCharge asElectricalCharge()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCharge", this.toString());
        return new ElectricalCharge(getSI(), ElectricalChargeUnit.SI);
    }

    /**
     * Return the current scalar as a electricalcharge, and provide a display unit.
     * @param displayUnit ElectricalChargeUnit; the unit in which the value will be displayed
     * @return ElectricalCharge; the current scalar as a electricalcharge
     */
    public final ElectricalCharge asElectricalCharge(final ElectricalChargeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalChargeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCharge", this.toString());
        return new ElectricalCharge(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a electricalconductance.
     * @return ElectricalConductance; the current scalar as a electricalconductance
     */
    public final ElectricalConductance asElectricalConductance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalConductance", this.toString());
        return new ElectricalConductance(getSI(), ElectricalConductanceUnit.SI);
    }

    /**
     * Return the current scalar as a electricalconductance, and provide a display unit.
     * @param displayUnit ElectricalConductanceUnit; the unit in which the value will be displayed
     * @return ElectricalConductance; the current scalar as a electricalconductance
     */
    public final ElectricalConductance asElectricalConductance(final ElectricalConductanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalConductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalConductance", this.toString());
        return new ElectricalConductance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a electricalcurrent.
     * @return ElectricalCurrent; the current scalar as a electricalcurrent
     */
    public final ElectricalCurrent asElectricalCurrent()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCurrent", this.toString());
        return new ElectricalCurrent(getSI(), ElectricalCurrentUnit.SI);
    }

    /**
     * Return the current scalar as a electricalcurrent, and provide a display unit.
     * @param displayUnit ElectricalCurrentUnit; the unit in which the value will be displayed
     * @return ElectricalCurrent; the current scalar as a electricalcurrent
     */
    public final ElectricalCurrent asElectricalCurrent(final ElectricalCurrentUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalCurrentUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalCurrent", this.toString());
        return new ElectricalCurrent(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a electricalinductance.
     * @return ElectricalInductance; the current scalar as a electricalinductance
     */
    public final ElectricalInductance asElectricalInductance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalInductance", this.toString());
        return new ElectricalInductance(getSI(), ElectricalInductanceUnit.SI);
    }

    /**
     * Return the current scalar as a electricalinductance, and provide a display unit.
     * @param displayUnit ElectricalInductanceUnit; the unit in which the value will be displayed
     * @return ElectricalInductance; the current scalar as a electricalinductance
     */
    public final ElectricalInductance asElectricalInductance(final ElectricalInductanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalInductanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalInductance", this.toString());
        return new ElectricalInductance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a electricalpotential.
     * @return ElectricalPotential; the current scalar as a electricalpotential
     */
    public final ElectricalPotential asElectricalPotential()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalPotential", this.toString());
        return new ElectricalPotential(getSI(), ElectricalPotentialUnit.SI);
    }

    /**
     * Return the current scalar as a electricalpotential, and provide a display unit.
     * @param displayUnit ElectricalPotentialUnit; the unit in which the value will be displayed
     * @return ElectricalPotential; the current scalar as a electricalpotential
     */
    public final ElectricalPotential asElectricalPotential(final ElectricalPotentialUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalPotentialUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalPotential", this.toString());
        return new ElectricalPotential(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a electricalresistance.
     * @return ElectricalResistance; the current scalar as a electricalresistance
     */
    public final ElectricalResistance asElectricalResistance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalResistance", this.toString());
        return new ElectricalResistance(getSI(), ElectricalResistanceUnit.SI);
    }

    /**
     * Return the current scalar as a electricalresistance, and provide a display unit.
     * @param displayUnit ElectricalResistanceUnit; the unit in which the value will be displayed
     * @return ElectricalResistance; the current scalar as a electricalresistance
     */
    public final ElectricalResistance asElectricalResistance(final ElectricalResistanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ElectricalResistanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to ElectricalResistance", this.toString());
        return new ElectricalResistance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a energy.
     * @return Energy; the current scalar as a energy
     */
    public final Energy asEnergy()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Energy", this.toString());
        return new Energy(getSI(), EnergyUnit.SI);
    }

    /**
     * Return the current scalar as a energy, and provide a display unit.
     * @param displayUnit EnergyUnit; the unit in which the value will be displayed
     * @return Energy; the current scalar as a energy
     */
    public final Energy asEnergy(final EnergyUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EnergyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Energy", this.toString());
        return new Energy(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a equivalentdose.
     * @return EquivalentDose; the current scalar as a equivalentdose
     */
    public final EquivalentDose asEquivalentDose()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EquivalentDose", this.toString());
        return new EquivalentDose(getSI(), EquivalentDoseUnit.SI);
    }

    /**
     * Return the current scalar as a equivalentdose, and provide a display unit.
     * @param displayUnit EquivalentDoseUnit; the unit in which the value will be displayed
     * @return EquivalentDose; the current scalar as a equivalentdose
     */
    public final EquivalentDose asEquivalentDose(final EquivalentDoseUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(EquivalentDoseUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to EquivalentDose", this.toString());
        return new EquivalentDose(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a flowmass.
     * @return FlowMass; the current scalar as a flowmass
     */
    public final FlowMass asFlowMass()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowMass", this.toString());
        return new FlowMass(getSI(), FlowMassUnit.SI);
    }

    /**
     * Return the current scalar as a flowmass, and provide a display unit.
     * @param displayUnit FlowMassUnit; the unit in which the value will be displayed
     * @return FlowMass; the current scalar as a flowmass
     */
    public final FlowMass asFlowMass(final FlowMassUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowMassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowMass", this.toString());
        return new FlowMass(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a flowvolume.
     * @return FlowVolume; the current scalar as a flowvolume
     */
    public final FlowVolume asFlowVolume()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowVolume", this.toString());
        return new FlowVolume(getSI(), FlowVolumeUnit.SI);
    }

    /**
     * Return the current scalar as a flowvolume, and provide a display unit.
     * @param displayUnit FlowVolumeUnit; the unit in which the value will be displayed
     * @return FlowVolume; the current scalar as a flowvolume
     */
    public final FlowVolume asFlowVolume(final FlowVolumeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FlowVolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to FlowVolume", this.toString());
        return new FlowVolume(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a force.
     * @return Force; the current scalar as a force
     */
    public final Force asForce()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Force", this.toString());
        return new Force(getSI(), ForceUnit.SI);
    }

    /**
     * Return the current scalar as a force, and provide a display unit.
     * @param displayUnit ForceUnit; the unit in which the value will be displayed
     * @return Force; the current scalar as a force
     */
    public final Force asForce(final ForceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(ForceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Force", this.toString());
        return new Force(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a frequency.
     * @return Frequency; the current scalar as a frequency
     */
    public final Frequency asFrequency()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Frequency", this.toString());
        return new Frequency(getSI(), FrequencyUnit.SI);
    }

    /**
     * Return the current scalar as a frequency, and provide a display unit.
     * @param displayUnit FrequencyUnit; the unit in which the value will be displayed
     * @return Frequency; the current scalar as a frequency
     */
    public final Frequency asFrequency(final FrequencyUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(FrequencyUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Frequency", this.toString());
        return new Frequency(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a illuminance.
     * @return Illuminance; the current scalar as a illuminance
     */
    public final Illuminance asIlluminance()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Illuminance", this.toString());
        return new Illuminance(getSI(), IlluminanceUnit.SI);
    }

    /**
     * Return the current scalar as a illuminance, and provide a display unit.
     * @param displayUnit IlluminanceUnit; the unit in which the value will be displayed
     * @return Illuminance; the current scalar as a illuminance
     */
    public final Illuminance asIlluminance(final IlluminanceUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(IlluminanceUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Illuminance", this.toString());
        return new Illuminance(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a lineardensity.
     * @return LinearDensity; the current scalar as a lineardensity
     */
    public final LinearDensity asLinearDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LinearDensity", this.toString());
        return new LinearDensity(getSI(), LinearDensityUnit.SI);
    }

    /**
     * Return the current scalar as a lineardensity, and provide a display unit.
     * @param displayUnit LinearDensityUnit; the unit in which the value will be displayed
     * @return LinearDensity; the current scalar as a lineardensity
     */
    public final LinearDensity asLinearDensity(final LinearDensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LinearDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LinearDensity", this.toString());
        return new LinearDensity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a luminousflux.
     * @return LuminousFlux; the current scalar as a luminousflux
     */
    public final LuminousFlux asLuminousFlux()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousFlux", this.toString());
        return new LuminousFlux(getSI(), LuminousFluxUnit.SI);
    }

    /**
     * Return the current scalar as a luminousflux, and provide a display unit.
     * @param displayUnit LuminousFluxUnit; the unit in which the value will be displayed
     * @return LuminousFlux; the current scalar as a luminousflux
     */
    public final LuminousFlux asLuminousFlux(final LuminousFluxUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousFlux", this.toString());
        return new LuminousFlux(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a luminousintensity.
     * @return LuminousIntensity; the current scalar as a luminousintensity
     */
    public final LuminousIntensity asLuminousIntensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousIntensity", this.toString());
        return new LuminousIntensity(getSI(), LuminousIntensityUnit.SI);
    }

    /**
     * Return the current scalar as a luminousintensity, and provide a display unit.
     * @param displayUnit LuminousIntensityUnit; the unit in which the value will be displayed
     * @return LuminousIntensity; the current scalar as a luminousintensity
     */
    public final LuminousIntensity asLuminousIntensity(final LuminousIntensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LuminousIntensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to LuminousIntensity", this.toString());
        return new LuminousIntensity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a magneticfluxdensity.
     * @return MagneticFluxDensity; the current scalar as a magneticfluxdensity
     */
    public final MagneticFluxDensity asMagneticFluxDensity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxDensity", this.toString());
        return new MagneticFluxDensity(getSI(), MagneticFluxDensityUnit.SI);
    }

    /**
     * Return the current scalar as a magneticfluxdensity, and provide a display unit.
     * @param displayUnit MagneticFluxDensityUnit; the unit in which the value will be displayed
     * @return MagneticFluxDensity; the current scalar as a magneticfluxdensity
     */
    public final MagneticFluxDensity asMagneticFluxDensity(final MagneticFluxDensityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxDensityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFluxDensity", this.toString());
        return new MagneticFluxDensity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a magneticflux.
     * @return MagneticFlux; the current scalar as a magneticflux
     */
    public final MagneticFlux asMagneticFlux()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFlux", this.toString());
        return new MagneticFlux(getSI(), MagneticFluxUnit.SI);
    }

    /**
     * Return the current scalar as a magneticflux, and provide a display unit.
     * @param displayUnit MagneticFluxUnit; the unit in which the value will be displayed
     * @return MagneticFlux; the current scalar as a magneticflux
     */
    public final MagneticFlux asMagneticFlux(final MagneticFluxUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MagneticFluxUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to MagneticFlux", this.toString());
        return new MagneticFlux(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a mass.
     * @return Mass; the current scalar as a mass
     */
    public final Mass asMass()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Mass", this.toString());
        return new Mass(getSI(), MassUnit.SI);
    }

    /**
     * Return the current scalar as a mass, and provide a display unit.
     * @param displayUnit MassUnit; the unit in which the value will be displayed
     * @return Mass; the current scalar as a mass
     */
    public final Mass asMass(final MassUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(MassUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Mass", this.toString());
        return new Mass(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a power.
     * @return Power; the current scalar as a power
     */
    public final Power asPower()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Power", this.toString());
        return new Power(getSI(), PowerUnit.SI);
    }

    /**
     * Return the current scalar as a power, and provide a display unit.
     * @param displayUnit PowerUnit; the unit in which the value will be displayed
     * @return Power; the current scalar as a power
     */
    public final Power asPower(final PowerUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PowerUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Power", this.toString());
        return new Power(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a pressure.
     * @return Pressure; the current scalar as a pressure
     */
    public final Pressure asPressure()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Pressure", this.toString());
        return new Pressure(getSI(), PressureUnit.SI);
    }

    /**
     * Return the current scalar as a pressure, and provide a display unit.
     * @param displayUnit PressureUnit; the unit in which the value will be displayed
     * @return Pressure; the current scalar as a pressure
     */
    public final Pressure asPressure(final PressureUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(PressureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Pressure", this.toString());
        return new Pressure(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a radioactivity.
     * @return RadioActivity; the current scalar as a radioactivity
     */
    public final RadioActivity asRadioActivity()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to RadioActivity", this.toString());
        return new RadioActivity(getSI(), RadioActivityUnit.SI);
    }

    /**
     * Return the current scalar as a radioactivity, and provide a display unit.
     * @param displayUnit RadioActivityUnit; the unit in which the value will be displayed
     * @return RadioActivity; the current scalar as a radioactivity
     */
    public final RadioActivity asRadioActivity(final RadioActivityUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(RadioActivityUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to RadioActivity", this.toString());
        return new RadioActivity(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a speed.
     * @return Speed; the current scalar as a speed
     */
    public final Speed asSpeed()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Speed", this.toString());
        return new Speed(getSI(), SpeedUnit.SI);
    }

    /**
     * Return the current scalar as a speed, and provide a display unit.
     * @param displayUnit SpeedUnit; the unit in which the value will be displayed
     * @return Speed; the current scalar as a speed
     */
    public final Speed asSpeed(final SpeedUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Speed", this.toString());
        return new Speed(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a torque.
     * @return Torque; the current scalar as a torque
     */
    public final Torque asTorque()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Torque", this.toString());
        return new Torque(getSI(), TorqueUnit.SI);
    }

    /**
     * Return the current scalar as a torque, and provide a display unit.
     * @param displayUnit TorqueUnit; the unit in which the value will be displayed
     * @return Torque; the current scalar as a torque
     */
    public final Torque asTorque(final TorqueUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TorqueUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Torque", this.toString());
        return new Torque(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a volume.
     * @return Volume; the current scalar as a volume
     */
    public final Volume asVolume()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Volume", this.toString());
        return new Volume(getSI(), VolumeUnit.SI);
    }

    /**
     * Return the current scalar as a volume, and provide a display unit.
     * @param displayUnit VolumeUnit; the unit in which the value will be displayed
     * @return Volume; the current scalar as a volume
     */
    public final Volume asVolume(final VolumeUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(VolumeUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Volume", this.toString());
        return new Volume(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a angle.
     * @return Angle; the current scalar as a angle
     */
    public final Angle asAngle()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Angle", this.toString());
        return new Angle(getSI(), AngleUnit.SI);
    }

    /**
     * Return the current scalar as a angle, and provide a display unit.
     * @param displayUnit AngleUnit; the unit in which the value will be displayed
     * @return Angle; the current scalar as a angle
     */
    public final Angle asAngle(final AngleUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(AngleUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Angle", this.toString());
        return new Angle(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a length.
     * @return Length; the current scalar as a length
     */
    public final Length asLength()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Length", this.toString());
        return new Length(getSI(), LengthUnit.SI);
    }

    /**
     * Return the current scalar as a length, and provide a display unit.
     * @param displayUnit LengthUnit; the unit in which the value will be displayed
     * @return Length; the current scalar as a length
     */
    public final Length asLength(final LengthUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(LengthUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Length", this.toString());
        return new Length(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a temperature.
     * @return Temperature; the current scalar as a temperature
     */
    public final Temperature asTemperature()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Temperature", this.toString());
        return new Temperature(getSI(), TemperatureUnit.SI);
    }

    /**
     * Return the current scalar as a temperature, and provide a display unit.
     * @param displayUnit TemperatureUnit; the unit in which the value will be displayed
     * @return Temperature; the current scalar as a temperature
     */
    public final Temperature asTemperature(final TemperatureUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(TemperatureUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Temperature", this.toString());
        return new Temperature(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

    /**
     * Return the current scalar as a duration.
     * @return Duration; the current scalar as a duration
     */
    public final Duration asDuration()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Duration", this.toString());
        return new Duration(getSI(), DurationUnit.SI);
    }

    /**
     * Return the current scalar as a duration, and provide a display unit.
     * @param displayUnit DurationUnit; the unit in which the value will be displayed
     * @return Duration; the current scalar as a duration
     */
    public final Duration asDuration(final DurationUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(DurationUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Duration", this.toString());
        return new Duration(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

}
