package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS_EMU;
import static org.djunits.unit.unitsystem.UnitSystem.CGS_ESU;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of electrical potential (voltage).
 * <p>
 * Copyright (c) 2015-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
                "ElectricalPotentialUnit.volt", "ElectricalPotentialUnit.V", SI_DERIVED, true);
        VOLT = SI;
        NANOVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.nanovolt", "ElectricalPotentialUnit.nV", SI_DERIVED,
                VOLT, 1.0E-9, true);
        MICROVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.microvolt", "ElectricalPotentialUnit.muV", SI_DERIVED,
                VOLT, 1.0E-6, true);
        MILLIVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.millivolt", "ElectricalPotentialUnit.mV", SI_DERIVED,
                VOLT, 0.001, true);
        KILOVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.kilovolt", "ElectricalPotentialUnit.kV", SI_DERIVED,
                VOLT, 1000.0, true);
        MEGAVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.megavolt", "ElectricalPotentialUnit.MV", SI_DERIVED,
                VOLT, 1.0E6, true);
        GIGAVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.gigavolt", "ElectricalPotentialUnit.GV", SI_DERIVED,
                VOLT, 1.0E9, true);
        STATVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.statvolt", "ElectricalPotentialUnit.statV", CGS_ESU,
                VOLT, 299.792458, true);
        ABVOLT = new ElectricalPotentialUnit("ElectricalPotentialUnit.abvolt", "ElectricalPotentialUnit.abV", CGS_EMU, VOLT,
                1.0E-8, true);
    }

    /**
     * Define an ElectricalPotentialUnit based on its constituent base units, e.g. a V = km.m^2/A.s^3.
     * @param massUnit the unit of mass for the electrical potential difference (voltage) unit, e.g., kilogram
     * @param lengthUnit the unit of length for the electrical potential difference (voltage) unit, e.g., meter
     * @param electricalCurrentUnit the unit of electrical current for the electrical potential difference (voltage) unit, e.g.,
     *            Ampere
     * @param durationUnit the unit of time for the electrical potential difference (voltage) unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    @SuppressWarnings("checkstyle:parameternumber")
    private ElectricalPotentialUnit(final MassUnit massUnit, final LengthUnit lengthUnit,
            final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, VOLT,
                massUnit.getScaleFactor() * lengthUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                        / (electricalCurrentUnit.getScaleFactor() * Math.pow(durationUnit.getScaleFactor(), 3.0)),
                standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Define a user-defined ElectricalPotentialUnit based on its constituent base units, e.g. a V = km.m^2/A.s^3.
     * @param massUnit the unit of mass for the electrical potential difference (voltage) unit, e.g., kilogram
     * @param lengthUnit the unit of length for the electrical potential difference (voltage) unit, e.g., meter
     * @param electricalCurrentUnit the unit of electrical current for the electrical potential difference (voltage) unit, e.g.,
     *            Ampere
     * @param durationUnit the unit of time for the electrical potential difference (voltage) unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public ElectricalPotentialUnit(final MassUnit massUnit, final LengthUnit lengthUnit,
            final ElectricalCurrentUnit electricalCurrentUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, lengthUnit, electricalCurrentUnit, durationUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build an ElectricalPotentialUnit based on power divided by current (V=W/A).
     * @param powerUnit the unit of power for the electrical potential difference (voltage) unit, e.g., Watt
     * @param electricalCurrentUnit the unit of electrical current for the electrical potential difference (voltage) unit, e.g.,
     *            Ampere
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ElectricalPotentialUnit(final PowerUnit powerUnit, final ElectricalCurrentUnit electricalCurrentUnit,
            final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, VOLT,
                powerUnit.getScaleFactor() / electricalCurrentUnit.getScaleFactor(), standardUnit);
        this.massUnit = powerUnit.getMassUnit();
        this.lengthUnit = powerUnit.getLengthUnit();
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.durationUnit = powerUnit.getDurationUnit();
    }

    /**
     * Build a user-defined ElectricalPotentialUnit based on power divided by current (V=W/A).
     * @param powerUnit the unit of power for the electrical potential difference (voltage) unit, e.g., Watt
     * @param electricalCurrentUnit the unit of electrical current for the electrical potential difference (voltage) unit, e.g.,
     *            Ampere
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public ElectricalPotentialUnit(final PowerUnit powerUnit, final ElectricalCurrentUnit electricalCurrentUnit,
            final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        this(powerUnit, electricalCurrentUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build an ElectricalPotentialUnit with a conversion factor to another ElectricalPotentialUnit, e.g. a kV = 1000 V.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ElectricalPotentialUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final UnitSystem unitSystem, final ElectricalPotentialUnit referenceUnit, final double scaleFactorToReferenceUnit,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.electricalCurrentUnit = referenceUnit.getElectricalCurrentUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined ElectricalPotentialUnit with a conversion factor to another ElectricalPotentialUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public ElectricalPotentialUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final ElectricalPotentialUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit, false);
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
