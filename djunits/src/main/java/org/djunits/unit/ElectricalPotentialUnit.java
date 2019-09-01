package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS_EMU;
import static org.djunits.unit.unitsystem.UnitSystem.CGS_ESU;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of electrical potential (voltage).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ElectricalPotentialUnit extends LinearUnit<ElectricalPotentialUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of mass for the electrical potential difference (voltage) unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** the unit of length for the electrical potential difference (voltage) unit, e.g., meters. */
    private final LengthUnit lengthUnit;

    /** the unit of electrical current for the electrical potential difference (voltage) unit, e.g., Ampere. */
    private final ElectricalCurrentUnit electricalCurrentUnit;

    /** the unit of time for the electrical potential difference (voltage) unit, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for electrical potential is Volt. */
    public static final ElectricalPotentialUnit SI;

    /** Volt. */
    public static final ElectricalPotentialUnit VOLT;

    /** nanovolt. */
    public static final ElectricalPotentialUnit NANOVOLT;

    /** microvolt. */
    public static final ElectricalPotentialUnit MICROVOLT;

    /** millivolt. */
    public static final ElectricalPotentialUnit MILLIVOLT;

    /** kilovolt. */
    public static final ElectricalPotentialUnit KILOVOLT;

    /** megavolt. */
    public static final ElectricalPotentialUnit MEGAVOLT;

    /** gigavolt. */
    public static final ElectricalPotentialUnit GIGAVOLT;

    /** statvolt. */
    public static final ElectricalPotentialUnit STATVOLT;

    /** abvolt. */
    public static final ElectricalPotentialUnit ABVOLT;

    static
    {
        SI = new ElectricalPotentialUnit(MassUnit.KILOGRAM, LengthUnit.METER, ElectricalCurrentUnit.AMPERE, DurationUnit.SECOND,
                "ElectricalPotentialUnit.V", SI_DERIVED);
        VOLT = SI;
        NANOVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.nV", SI_DERIVED, VOLT, 1.0E-9);
        MICROVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.muV", SI_DERIVED, VOLT, 1.0E-6);
        MILLIVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.mV", SI_DERIVED, VOLT, 0.001);
        KILOVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.kV", SI_DERIVED, VOLT, 1000.0);
        MEGAVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.MV", SI_DERIVED, VOLT, 1.0E6);
        GIGAVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.GV", SI_DERIVED, VOLT, 1.0E9);
        STATVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.statV", CGS_ESU, VOLT, 299.792458);
        ABVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.abV", CGS_EMU, VOLT, 1.0E-8);
    }

    /**
     * Define an ElectricalPotentialUnit based on its constituent base units, e.g. a V = km.m^2/A.s^3.
     * @param massUnit MassUnit; the unit of mass for the electrical potential difference (voltage) unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the electrical potential difference (voltage) unit, e.g., meter
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical potential
     *            difference (voltage) unit, e.g., Ampere
     * @param durationUnit DurationUnit; the unit of time for the electrical potential difference (voltage) unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    @SuppressWarnings("checkstyle:parameternumber")
    private ElectricalPotentialUnit(final MassUnit massUnit, final LengthUnit lengthUnit,
            final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, VOLT,
                massUnit.getScaleFactor() * lengthUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                        / (electricalCurrentUnit.getScaleFactor() * Math.pow(durationUnit.getScaleFactor(), 3.0)));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Define a user-defined ElectricalPotentialUnit based on its constituent base units, e.g. a V = km.m^2/A.s^3.
     * @param massUnit MassUnit; the unit of mass for the electrical potential difference (voltage) unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the electrical potential difference (voltage) unit, e.g., meter
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical potential
     *            difference (voltage) unit, e.g., Ampere
     * @param durationUnit DurationUnit; the unit of time for the electrical potential difference (voltage) unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public ElectricalPotentialUnit(final MassUnit massUnit, final LengthUnit lengthUnit,
            final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, VOLT,
                massUnit.getScaleFactor() * lengthUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                        / (electricalCurrentUnit.getScaleFactor() * Math.pow(durationUnit.getScaleFactor(), 3.0)));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build an ElectricalPotentialUnit based on power divided by current (V=W/A).
     * @param powerUnit PowerUnit; the unit of power for the electrical potential difference (voltage) unit, e.g., Watt
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical potential
     *            difference (voltage) unit, e.g., Ampere
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private ElectricalPotentialUnit(final PowerUnit powerUnit, final ElectricalCurrentUnit electricalCurrentUnit,
            final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, VOLT, powerUnit.getScaleFactor() / electricalCurrentUnit.getScaleFactor());
        this.massUnit = powerUnit.getMassUnit();
        this.lengthUnit = powerUnit.getLengthUnit();
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = powerUnit.getDurationUnit();
    }

    /**
     * Build a user-defined ElectricalPotentialUnit based on power divided by current (V=W/A).
     * @param powerUnit PowerUnit; the unit of power for the electrical potential difference (voltage) unit, e.g., Watt
     * @param electricalCurrentUnit ElectricalCurrentUnit; the unit of electrical current for the electrical potential
     *            difference (voltage) unit, e.g., Ampere
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public ElectricalPotentialUnit(final PowerUnit powerUnit, final ElectricalCurrentUnit electricalCurrentUnit,
            final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, VOLT, powerUnit.getScaleFactor() / electricalCurrentUnit.getScaleFactor());
        this.massUnit = powerUnit.getMassUnit();
        this.lengthUnit = powerUnit.getLengthUnit();
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = powerUnit.getDurationUnit();
    }

    /**
     * Build an ElectricalPotentialUnit with a conversion factor to another ElectricalPotentialUnit, e.g. a kV = 1000 V.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ElectricalPotentialUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private ElectricalPotentialUnit(final String abbreviationKey, final UnitSystem unitSystem,
            final ElectricalPotentialUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.electricalCurrentUnit = referenceUnit.getElectricalCurrentUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined ElectricalPotentialUnit with a conversion factor to another ElectricalPotentialUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ElectricalPotentialUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public ElectricalPotentialUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final ElectricalPotentialUnit referenceUnit, final double scaleFactorToReferenceUnit)
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
    public final ElectricalPotentialUnit getStandardUnit()
    {
        return VOLT;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kgm2/s3A";
    }

}
