package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS;
import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.MTS;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of energy.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class EnergyUnit extends LinearUnit<EnergyUnit>
{
    /** */
    private static final long serialVersionUID = 20140604L;

    /** the unit of mass for the energy unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** the unit of length for the energy unit, e.g., length. */
    private final LengthUnit lengthUnit;

    /** the unit of time for the energy unit, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for energy is Joule. */
    public static final EnergyUnit SI;

    /** picojoule. */
    public static final EnergyUnit PICOJOULE;

    /** nanojoule. */
    public static final EnergyUnit NANOJOULE;

    /** microjoule. */
    public static final EnergyUnit MICROJOULE;

    /** millijoule. */
    public static final EnergyUnit MILLIJOULE;

    /** Joule. */
    public static final EnergyUnit JOULE;

    /** kilojoule. */
    public static final EnergyUnit KILOJOULE;

    /** megajoule. */
    public static final EnergyUnit MEGAJOULE;

    /** gigajoule. */
    public static final EnergyUnit GIGAJOULE;

    /** terajoule. */
    public static final EnergyUnit TERAJOULE;

    /** petajoule. */
    public static final EnergyUnit PETAJOULE;

    /** foot-pound force. */
    public static final EnergyUnit FOOT_POUND_FORCE;

    /** inch-pound force. */
    public static final EnergyUnit INCH_POUND_FORCE;

    /** British thermal unit (ISO). */
    public static final EnergyUnit BTU_ISO;

    /** British thermal unit (International Table). */
    public static final EnergyUnit BTU_IT;

    /** calorie (International Table). */
    public static final EnergyUnit CALORIE_IT;

    /** calorie. */
    public static final EnergyUnit CALORIE;

    /** kilocalorie. */
    public static final EnergyUnit KILOCALORIE;

    /** femtowatt-hour. */
    public static final EnergyUnit FEMTOWATT_HOUR;

    /** picowatt-hour. */
    public static final EnergyUnit PICOWATT_HOUR;

    /** nanowatt-hour. */
    public static final EnergyUnit NANOWATT_HOUR;

    /** microwatt-hour. */
    public static final EnergyUnit MICROWATT_HOUR;

    /** milliwatt-hour. */
    public static final EnergyUnit MILLIWATT_HOUR;

    /** watt-hour. */
    public static final EnergyUnit WATT_HOUR;

    /** kilowatt-hour. */
    public static final EnergyUnit KILOWATT_HOUR;

    /** megawatt-hour. */
    public static final EnergyUnit MEGAWATT_HOUR;

    /** gigawatt-hour. */
    public static final EnergyUnit GIGAWATT_HOUR;

    /** terawatt-hour. */
    public static final EnergyUnit TERAWATT_HOUR;

    /** petawatt-hour. */
    public static final EnergyUnit PETAWATT_HOUR;

    /** electronvolt. */
    public static final EnergyUnit ELECTRONVOLT;

    /** micro-electronvolt. */
    public static final EnergyUnit MICROELECTRONVOLT;

    /** milli-electronvolt. */
    public static final EnergyUnit MILLIELECTRONVOLT;

    /** kilo-electronvolt. */
    public static final EnergyUnit KILOELECTRONVOLT;

    /** mega-electronvolt. */
    public static final EnergyUnit MEGAELECTRONVOLT;

    /** giga-electronvolt. */
    public static final EnergyUnit GIGAELECTRONVOLT;

    /** tera-electronvolt. */
    public static final EnergyUnit TERAELECTRONVOLT;

    /** peta-electronvolt. */
    public static final EnergyUnit PETAELECTRONVOLT;

    /** exa-electronvolt. */
    public static final EnergyUnit EXAELECTRONVOLT;

    /** sthene-meter (mts). */
    public static final EnergyUnit STHENE_METER;

    /** erg (cgs). */
    public static final EnergyUnit ERG;

    static
    {
        SI = new EnergyUnit(MassUnit.KILOGRAM, LengthUnit.METER, DurationUnit.SECOND, "EnergyUnit.Joule", "EnergyUnit.J",
                SI_DERIVED, true);
        JOULE = SI;
        PICOJOULE = new EnergyUnit("EnergyUnit.picojoule", "EnergyUnit.pJ", SI_BASE, JOULE, 1E-12, true);
        NANOJOULE = new EnergyUnit("EnergyUnit.nanojoule", "EnergyUnit.nJ", SI_BASE, JOULE, 1E-9, true);
        MICROJOULE = new EnergyUnit("EnergyUnit.microjoule", "EnergyUnit.muJ", SI_BASE, JOULE, 1E-6, true);
        MILLIJOULE = new EnergyUnit("EnergyUnit.millijoule", "EnergyUnit.mJ", SI_BASE, JOULE, 1E-3, true);
        KILOJOULE = new EnergyUnit("EnergyUnit.kilojoule", "EnergyUnit.kJ", SI_BASE, JOULE, 1000.0, true);
        MEGAJOULE = new EnergyUnit("EnergyUnit.megajoule", "EnergyUnit.MJ", SI_BASE, JOULE, 1E9, true);
        GIGAJOULE = new EnergyUnit("EnergyUnit.gigajoule", "EnergyUnit.GJ", SI_BASE, JOULE, 1E12, true);
        TERAJOULE = new EnergyUnit("EnergyUnit.terajoule", "EnergyUnit.TJ", SI_BASE, JOULE, 1E15, true);
        PETAJOULE = new EnergyUnit("EnergyUnit.petajoule", "EnergyUnit.PJ", SI_BASE, JOULE, 1E18, true);
        FOOT_POUND_FORCE = new EnergyUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, "EnergyUnit.foot_pound-force",
                "EnergyUnit.ft.lbf", IMPERIAL, true);
        INCH_POUND_FORCE = new EnergyUnit(ForceUnit.POUND_FORCE, LengthUnit.INCH, "EnergyUnit.inch_pound-force",
                "EnergyUnit.in.lbf", IMPERIAL, true);
        BTU_ISO =
                new EnergyUnit("EnergyUnit.British_thermal_unit_(ISO)", "EnergyUnit.BTU(ISO)", IMPERIAL, JOULE, 1.0545E3, true);
        BTU_IT = new EnergyUnit("EnergyUnit.British_thermal_unit_(International_Table)", "EnergyUnit.BTU(IT)", IMPERIAL, JOULE,
                1.05505585262E3, true);
        CALORIE_IT =
                new EnergyUnit("EnergyUnit.calorie_(International_Table)", "EnergyUnit.cal(IT)", OTHER, JOULE, 4.1868, true);
        CALORIE = new EnergyUnit("EnergyUnit.calorie", "EnergyUnit.cal", OTHER, JOULE, 4.184, true);
        KILOCALORIE = new EnergyUnit("EnergyUnit.kilocalorie", "EnergyUnit.kcal", OTHER, CALORIE, 1000.0, true);
        WATT_HOUR = new EnergyUnit("EnergyUnit.watt-hour", "EnergyUnit.Wh", SI_DERIVED, JOULE, 3600.0, true);
        FEMTOWATT_HOUR = new EnergyUnit("EnergyUnit.femtowatt-hour", "EnergyUnit.fWh", SI_DERIVED, WATT_HOUR, 1.0E-15, true);
        PICOWATT_HOUR = new EnergyUnit("EnergyUnit.picowatt-hour", "EnergyUnit.pWh", SI_DERIVED, WATT_HOUR, 1.0E-12, true);
        NANOWATT_HOUR = new EnergyUnit("EnergyUnit.nanowatt-hour", "EnergyUnit.nWh", SI_DERIVED, WATT_HOUR, 1.0E-9, true);
        MICROWATT_HOUR = new EnergyUnit("EnergyUnit.microwatt-hour", "EnergyUnit.muWh", SI_DERIVED, WATT_HOUR, 1.0E-6, true);
        MILLIWATT_HOUR = new EnergyUnit("EnergyUnit.milliwatt-hour", "EnergyUnit.mWh", SI_DERIVED, WATT_HOUR, 1.0E-3, true);
        KILOWATT_HOUR = new EnergyUnit("EnergyUnit.kilowatt-hour", "EnergyUnit.kWh", SI_DERIVED, WATT_HOUR, 1000.0, true);
        MEGAWATT_HOUR = new EnergyUnit("EnergyUnit.megawatt-hour", "EnergyUnit.MWh", SI_DERIVED, WATT_HOUR, 1.0E6, true);
        GIGAWATT_HOUR = new EnergyUnit("EnergyUnit.gigawatt-hour", "EnergyUnit.GWh", SI_DERIVED, WATT_HOUR, 1.0E9, true);
        TERAWATT_HOUR = new EnergyUnit("EnergyUnit.terawatt-hour", "EnergyUnit.TWh", SI_DERIVED, WATT_HOUR, 1.0E12, true);
        PETAWATT_HOUR = new EnergyUnit("EnergyUnit.petawatt-hour", "EnergyUnit.PWh", SI_DERIVED, WATT_HOUR, 1.0E15, true);
        ELECTRONVOLT = new EnergyUnit("EnergyUnit.electronvolt", "EnergyUnit.eV", SI_ACCEPTED, JOULE, 1.602176565314E-19, true);
        MICROELECTRONVOLT =
                new EnergyUnit("EnergyUnit.micro-electronvolt", "EnergyUnit.mueV", SI_ACCEPTED, ELECTRONVOLT, 1.0E-6, true);
        MILLIELECTRONVOLT =
                new EnergyUnit("EnergyUnit.milli-electronvolt", "EnergyUnit.meV", SI_ACCEPTED, ELECTRONVOLT, 1.0E-3, true);
        KILOELECTRONVOLT =
                new EnergyUnit("EnergyUnit.kilo-electronvolt", "EnergyUnit.keV", SI_ACCEPTED, ELECTRONVOLT, 1.0E3, true);
        MEGAELECTRONVOLT =
                new EnergyUnit("EnergyUnit.mega-electronvolt", "EnergyUnit.MeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E6, true);
        GIGAELECTRONVOLT =
                new EnergyUnit("EnergyUnit.giga-electronvolt", "EnergyUnit.GeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E9, true);
        TERAELECTRONVOLT =
                new EnergyUnit("EnergyUnit.tera-electronvolt", "EnergyUnit.TeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E12, true);
        PETAELECTRONVOLT =
                new EnergyUnit("EnergyUnit.peta-electronvolt", "EnergyUnit.PeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E15, true);
        EXAELECTRONVOLT =
                new EnergyUnit("EnergyUnit.exa-electronvolt", "EnergyUnit.EeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E18, true);
        STHENE_METER = new EnergyUnit("EnergyUnit.sthene_meter", "EnergyUnit.sn.m", MTS, JOULE, 1000.0, true);
        ERG = new EnergyUnit("EnergyUnit.erg_(full)", "EnergyUnit.erg", CGS, JOULE, 1.0E-7, true);
    }

    /**
     * Define an EnergyUnit based on its constituent base units, e.g. a J = km.m^2/s^2.
     * @param massUnit MassUnit; the unit of mass for the energy unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the energy unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the energy unit, e.g., second
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private EnergyUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final boolean standardUnit)
    {
        super(nameOrNameKey,
                abbreviationOrAbbreviationKey, unitSystem, JOULE, massUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                        * lengthUnit.getScaleFactor() / (durationUnit.getScaleFactor() * durationUnit.getScaleFactor()),
                standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Define a user-defined EnergyUnit based on its constituent base units, e.g. a J = km.m^2/s^2.
     * @param massUnit MassUnit; the unit of mass for the energy unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the energy unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the energy unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public EnergyUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, lengthUnit, durationUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Define an EnergyUnit based on a LengthUnit and a ForceUnit, e.g. a J = N.m.
     * @param forceUnit ForceUnit; the unit of force for the energy unit, e.g., Newton
     * @param lengthUnit LengthUnit; the unit of length for the energy unit, e.g., Meter
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private EnergyUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, JOULE,
                forceUnit.getScaleFactor() * lengthUnit.getScaleFactor(), standardUnit);
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = forceUnit.getLengthUnit();
        this.durationUnit = forceUnit.getDurationUnit();
    }

    /**
     * Define a user-defined EnergyUnit based on a LengthUnit and a ForceUnit, e.g. a J = N.m.
     * @param forceUnit ForceUnit; the unit of force for the energy unit, e.g., Newton
     * @param lengthUnit LengthUnit; the unit of length for the energy unit, e.g., Meter
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public EnergyUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        this(forceUnit, lengthUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build an EnergyUnit with a conversion factor to another EnergyUnit.
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit EnergyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private EnergyUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final EnergyUnit referenceUnit, final double scaleFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined EnergyUnit with a conversion factor to another EnergyUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit EnergyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public EnergyUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final EnergyUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
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
     * @return durationUnit
     */
    public final DurationUnit getDurationUnit()
    {
        return this.durationUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final EnergyUnit getStandardUnit()
    {
        return JOULE;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kgm2/s2";
    }

}
