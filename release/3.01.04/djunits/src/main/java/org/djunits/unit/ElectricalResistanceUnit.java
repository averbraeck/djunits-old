package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS_EMU;
import static org.djunits.unit.unitsystem.UnitSystem.CGS_ESU;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of electrical resistance.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ElectricalResistanceUnit extends LinearUnit<ElectricalResistanceUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of mass for the electrical resistance unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** the unit of length for the electrical resistance unit, e.g., meters. */
    private final LengthUnit lengthUnit;

    /** the unit of electrical current for the electrical resistance unit, e.g., Ampere. */
    private final ElectricalCurrentUnit electricalCurrentUnit;

    /** the unit of time for the electrical resistance unit, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for electrical resistance is Ohm. */
    public static final ElectricalResistanceUnit SI;

    /** Ohm. */
    public static final ElectricalResistanceUnit OHM;

    /** nano-ohm. */
    public static final ElectricalResistanceUnit NANOOHM;

    /** micro-ohm. */
    public static final ElectricalResistanceUnit MICROOHM;

    /** milli-ohm. */
    public static final ElectricalResistanceUnit MILLIOHM;

    /** kilo-ohm. */
    public static final ElectricalResistanceUnit KILOOHM;

    /** mega-ohm. */
    public static final ElectricalResistanceUnit MEGAOHM;

    /** giga-ohm. */
    public static final ElectricalResistanceUnit GIGAOHM;

    /** ab-ohm. */
    public static final ElectricalResistanceUnit ABOHM;

    /** stat-ohm. */
    public static final ElectricalResistanceUnit STATOHM;

    static
    {
        SI = new ElectricalResistanceUnit(MassUnit.KILOGRAM, LengthUnit.METER, ElectricalCurrentUnit.AMPERE,
                DurationUnit.SECOND, "ElectricalResistanceUnit.ohm", SI_DERIVED);
        OHM = SI;
        NANOOHM = new ElectricalResistanceUnit("ElectricalResistanceUnit.n_ohm", SI_DERIVED, OHM, 1.0E-9);
        MICROOHM = new ElectricalResistanceUnit("ElectricalResistanceUnit.mu_ohm", SI_DERIVED, OHM, 1.0E-6);
        MILLIOHM = new ElectricalResistanceUnit("ElectricalResistanceUnit.m_ohm", SI_DERIVED, OHM, 1.0E-3);
        KILOOHM = new ElectricalResistanceUnit("ElectricalResistanceUnit.k_ohm", SI_DERIVED, OHM, 1.0E3);
        MEGAOHM = new ElectricalResistanceUnit("ElectricalResistanceUnit.M_ohm", SI_DERIVED, OHM, 1.0E06);
        GIGAOHM = new ElectricalResistanceUnit("ElectricalResistanceUnit.G_ohm", SI_DERIVED, OHM, 1.0E9);
        ABOHM = new ElectricalResistanceUnit("ElectricalResistanceUnit.a_ohm", CGS_EMU, OHM, 1.0E-9);
        STATOHM = new ElectricalResistanceUnit("ElectricalResistanceUnit.st_ohm", CGS_ESU, OHM, 8.987551787E11);
    }

    /**
     * Define an ElectricalResistanceUnit based on its constituent base units, e.g. an Ohm = km.m^2/A^2.s^3.
     * @param massUnit MassUnit; the unit of mass for the electrical resistance unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the electrical resistance unit, e.g., meter
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical resistance unit,
     *            e.g., Ampere
     * @param durationUnit DurationUnit; the unit of time for the electrical resistance unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private ElectricalResistanceUnit(final MassUnit massUnit, final LengthUnit lengthUnit,
            final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, OHM,
                massUnit.getScaleFactor() * lengthUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                        / (electricalCurrentUnit.getScaleFactor() * electricalCurrentUnit.getScaleFactor()
                                * Math.pow(durationUnit.getScaleFactor(), 3.0)));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Define a user-defined ElectricalResistanceUnit based on its constituent base units, e.g. an Ohm = km.m^2/A^2.s^3.
     * @param massUnit MassUnit; the unit of mass for the electrical resistance unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the electrical resistance unit, e.g., meter
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical resistance unit,
     *            e.g., Ampere
     * @param durationUnit DurationUnit; the unit of time for the electrical resistance unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public ElectricalResistanceUnit(final MassUnit massUnit, final LengthUnit lengthUnit,
            final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, OHM,
                massUnit.getScaleFactor() * lengthUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                        / (electricalCurrentUnit.getScaleFactor() * electricalCurrentUnit.getScaleFactor()
                                * Math.pow(durationUnit.getScaleFactor(), 3.0)));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Define an ElectricalResistanceUnit based on an electrical potential unit and an electrical current unit, e.g. Ohm = V/A.
     * @param electricalPotentialUnit ElectricalPotentialUnit; the unit of electrical potential difference for the electrical
     *            resistance unit, e.g., Volt
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical resistance unit,
     *            e.g., Ampere
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private ElectricalResistanceUnit(final ElectricalPotentialUnit electricalPotentialUnit,
            final ElectricalCurrentUnit electricalCurrentUnit, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, OHM,
                electricalPotentialUnit.getScaleFactor() / electricalCurrentUnit.getScaleFactor());
        this.massUnit = electricalPotentialUnit.getMassUnit();
        this.lengthUnit = electricalPotentialUnit.getLengthUnit();
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = electricalPotentialUnit.getDurationUnit();
    }

    /**
     * Define a user-defined ElectricalResistanceUnit based on an electrical potential unit and an electrical current unit, e.g.
     * Ohm = V/A.
     * @param electricalPotentialUnit ElectricalPotentialUnit; the unit of electrical potential difference for the electrical
     *            resistance unit, e.g., Volt
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical resistance unit,
     *            e.g., Ampere
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public ElectricalResistanceUnit(final ElectricalPotentialUnit electricalPotentialUnit,
            final ElectricalCurrentUnit electricalCurrentUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, OHM,
                electricalPotentialUnit.getScaleFactor() / electricalCurrentUnit.getScaleFactor());
        this.massUnit = electricalPotentialUnit.getMassUnit();
        this.lengthUnit = electricalPotentialUnit.getLengthUnit();
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = electricalPotentialUnit.getDurationUnit();
    }

    /**
     * Build a ElectricalResistanceUnit with a conversion factor to another ElectricalResistanceUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ElectricalResistanceUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private ElectricalResistanceUnit(final String abbreviationKey, final UnitSystem unitSystem,
            final ElectricalResistanceUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.electricalCurrentUnit = referenceUnit.getElectricalCurrentUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined ElectricalResistanceUnit with a conversion factor to another ElectricalResistanceUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ElectricalResistanceUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public ElectricalResistanceUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final ElectricalResistanceUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.electricalCurrentUnit = referenceUnit.getElectricalCurrentUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * @return massUnit
     */
    public final MassUnit getMassUnit()
    {
        return this.massUnit;
    }

    /**
     * @return lengthUnit
     */
    public final LengthUnit getLengthUnit()
    {
        return this.lengthUnit;
    }

    /**
     * @return electricalCurrentUnit
     */
    public final ElectricalCurrentUnit getElectricalCurrentUnit()
    {
        return this.electricalCurrentUnit;
    }

    /**
     * @return durationUnit
     */
    public final DurationUnit getDurationUnit()
    {
        return this.durationUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistanceUnit getStandardUnit()
    {
        return OHM;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kgm2/s3A2";
    }

}
