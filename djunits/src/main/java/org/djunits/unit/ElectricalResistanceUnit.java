package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of electrical resistance.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ElectricalResistanceUnit extends Unit<ElectricalResistanceUnit>
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
    private final TimeUnit timeUnit;

    /** The SI unit for electrical resistance is Ohm. */
    public static final ElectricalResistanceUnit SI;

    /** Ohm. */
    public static final ElectricalResistanceUnit OHM;

    /** milli-ohm. */
    public static final ElectricalResistanceUnit MILLIOHM;

    /** kilo-ohm. */
    public static final ElectricalResistanceUnit KILOOHM;

    /** mega-ohm. */
    public static final ElectricalResistanceUnit MEGAOHM;

    static
    {
        SI =
            new ElectricalResistanceUnit(MassUnit.KILOGRAM, LengthUnit.METER, ElectricalCurrentUnit.AMPERE,
                TimeUnit.SECOND, "ElectricalResistanceUnit.ohm_(name)", "ElectricalResistanceUnit.ohm", SI_DERIVED,
                true);
        OHM = SI;
        MILLIOHM =
            new ElectricalResistanceUnit("ElectricalResistanceUnit.milli_ohm", "ElectricalResistanceUnit.m_ohm",
                SI_DERIVED, OHM, 0.001, true);
        KILOOHM =
            new ElectricalResistanceUnit("ElectricalResistanceUnit.kilo_ohm", "ElectricalResistanceUnit.k_ohm",
                SI_DERIVED, OHM, 1000.0, true);
        MEGAOHM =
            new ElectricalResistanceUnit("ElectricalResistanceUnit.mega_ohm", "ElectricalResistanceUnit.M_ohm",
                SI_DERIVED, OHM, 1E06, true);
    }

    /**
     * Define an ElectricalResistanceUnit based on its constituent base units, e.g. an Ohm = km.m^2/A^2.s^3.
     * @param massUnit the unit of mass for the electrical resistance unit, e.g., kilogram
     * @param lengthUnit the unit of length for the electrical resistance unit, e.g., meter
     * @param electricalCurrentUnit the unit of electrical current for the electrical resistance unit, e.g., Ampere
     * @param timeUnit the unit of time for the electrical resistance unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    @SuppressWarnings("checkstyle:parameternumber")
    private ElectricalResistanceUnit(final MassUnit massUnit, final LengthUnit lengthUnit,
        final ElectricalCurrentUnit electricalCurrentUnit, final TimeUnit timeUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, OHM, massUnit
            .getConversionFactorToStandardUnit()
            * lengthUnit.getConversionFactorToStandardUnit()
            * lengthUnit.getConversionFactorToStandardUnit()
            / (electricalCurrentUnit.getConversionFactorToStandardUnit()
                * electricalCurrentUnit.getConversionFactorToStandardUnit() * Math.pow(timeUnit
                .getConversionFactorToStandardUnit(), 3.0)), standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.timeUnit = timeUnit;
    }

    /**
     * Define a user-defined ElectricalResistanceUnit based on its constituent base units, e.g. an Ohm = km.m^2/A^2.s^3.
     * @param massUnit the unit of mass for the electrical resistance unit, e.g., kilogram
     * @param lengthUnit the unit of length for the electrical resistance unit, e.g., meter
     * @param electricalCurrentUnit the unit of electrical current for the electrical resistance unit, e.g., Ampere
     * @param timeUnit the unit of time for the electrical resistance unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public ElectricalResistanceUnit(final MassUnit massUnit, final LengthUnit lengthUnit,
        final ElectricalCurrentUnit electricalCurrentUnit, final TimeUnit timeUnit, final String name,
        final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, lengthUnit, electricalCurrentUnit, timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Define an ElectricalResistanceUnit based on an electrical potential unit and an electrical current unit, e.g. Ohm = V/A.
     * @param electricalPotentialUnit the unit of electrical potential difference for the electrical resistance unit, e.g., Volt
     * @param electricalCurrentUnit the unit of electrical current for the electrical resistance unit, e.g., Ampere
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ElectricalResistanceUnit(final ElectricalPotentialUnit electricalPotentialUnit,
        final ElectricalCurrentUnit electricalCurrentUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, OHM, electricalPotentialUnit
            .getConversionFactorToStandardUnit()
            / electricalCurrentUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.massUnit = electricalPotentialUnit.getMassUnit();
        this.lengthUnit = electricalPotentialUnit.getLengthUnit();
        this.electricalCurrentUnit = electricalCurrentUnit;
        this.timeUnit = electricalPotentialUnit.getTimeUnit();
    }

    /**
     * Define a user-defined ElectricalResistanceUnit based on an electrical potential unit and an electrical current unit, e.g.
     * Ohm = V/A.
     * @param electricalPotentialUnit the unit of electrical potential difference for the electrical resistance unit, e.g., Volt
     * @param electricalCurrentUnit the unit of electrical current for the electrical resistance unit, e.g., Ampere
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public ElectricalResistanceUnit(final ElectricalPotentialUnit electricalPotentialUnit,
        final ElectricalCurrentUnit electricalCurrentUnit, final String name, final String abbreviation,
        final UnitSystem unitSystem)
    {
        this(electricalPotentialUnit, electricalCurrentUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a ElectricalResistanceUnit with a conversion factor to another ElectricalResistanceUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ElectricalResistanceUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final UnitSystem unitSystem, final ElectricalResistanceUnit referenceUnit,
        final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
            standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.electricalCurrentUnit = referenceUnit.getElectricalCurrentUnit();
        this.timeUnit = referenceUnit.getTimeUnit();
    }

    /**
     * Build a user-defined ElectricalResistanceUnit with a conversion factor to another ElectricalResistanceUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public ElectricalResistanceUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
        final ElectricalResistanceUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
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
     * @return timeUnit
     */
    public final TimeUnit getTimeUnit()
    {
        return this.timeUnit;
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
