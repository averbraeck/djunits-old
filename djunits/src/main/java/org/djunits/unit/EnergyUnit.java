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
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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
    private final TimeUnit timeUnit;

    /** The SI unit for energy is Joule. */
    public static final EnergyUnit SI;

    /** Joule. */
    public static final EnergyUnit JOULE;

    /** kilojoule. */
    public static final EnergyUnit KILOJOULE;

    /** megajoule. */
    public static final EnergyUnit MEGAJOULE;

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

    /** kilocalorie. */
    public static final EnergyUnit KILOCALORIE;

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

    /** milliwatt-hour. */
    public static final EnergyUnit MILLIWATT_HOUR;

    /** microwatt-hour. */
    public static final EnergyUnit MICROWATT_HOUR;

    /** electronvolt. */
    public static final EnergyUnit ELECTRONVOLT;

    /** milli-electronvolt. */
    public static final EnergyUnit MILLI_ELECTRONVOLT;

    /** kilo-electronvolt. */
    public static final EnergyUnit KILO_ELECTRONVOLT;

    /** mega-electronvolt. */
    public static final EnergyUnit MEGA_ELECTRONVOLT;

    /** giga-electronvolt. */
    public static final EnergyUnit GIGA_ELECTRONVOLT;

    /** tera-electronvolt. */
    public static final EnergyUnit TERA_ELECTRONVOLT;

    /** peta-electronvolt. */
    public static final EnergyUnit PETA_ELECTRONVOLT;

    /** exa-electronvolt. */
    public static final EnergyUnit EXA_ELECTRONVOLT;

    /** sthene-meter (mts). */
    public static final EnergyUnit STHENE_METER;

    /** erg (cgs). */
    public static final EnergyUnit ERG;

    static
    {
        SI =
                new EnergyUnit(MassUnit.KILOGRAM, LengthUnit.METER, TimeUnit.SECOND, "EnergyUnit.Joule", "EnergyUnit.J",
                        SI_DERIVED, true);
        JOULE = SI;
        KILOJOULE = new EnergyUnit("EnergyUnit.kilojoule", "EnergyUnit.kJ", SI_BASE, JOULE, 1000.0, true);
        MEGAJOULE = new EnergyUnit("EnergyUnit.megajoule", "EnergyUnit.MJ", SI_BASE, JOULE, 1E9, true);
        FOOT_POUND_FORCE =
                new EnergyUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, "EnergyUnit.foot_pound-force", "EnergyUnit.ft.lbf",
                        IMPERIAL, true);
        INCH_POUND_FORCE =
                new EnergyUnit(ForceUnit.POUND_FORCE, LengthUnit.INCH, "EnergyUnit.inch_pound-force", "EnergyUnit.in.lbf",
                        IMPERIAL, true);
        BTU_ISO =
                new EnergyUnit("EnergyUnit.British_thermal_unit_(ISO)", "EnergyUnit.BTU(ISO)", IMPERIAL, JOULE, 1.0545E3, true);
        BTU_IT =
                new EnergyUnit("EnergyUnit.British_thermal_unit_(International_Table)", "EnergyUnit.BTU(IT)", IMPERIAL, JOULE,
                        1.05505585262E3, true);
        CALORIE_IT =
                new EnergyUnit("EnergyUnit.calorie_(International_Table)", "EnergyUnit.cal(IT)", OTHER, JOULE, 4.1868, true);
        KILOCALORIE = new EnergyUnit("EnergyUnit.kilocalorie", "EnergyUnit.kcal", OTHER, CALORIE_IT, 1000.0, true);
        WATT_HOUR = new EnergyUnit("EnergyUnit.watt-hour", "EnergyUnit.Wh", SI_DERIVED, JOULE, 3600.0, true);
        KILOWATT_HOUR = new EnergyUnit("EnergyUnit.kilowatt-hour", "EnergyUnit.kWh", SI_DERIVED, WATT_HOUR, 1000.0, true);
        MEGAWATT_HOUR = new EnergyUnit("EnergyUnit.megawatt-hour", "EnergyUnit.MWh", SI_DERIVED, WATT_HOUR, 1.0E6, true);
        GIGAWATT_HOUR = new EnergyUnit("EnergyUnit.gigawatt-hour", "EnergyUnit.GWh", SI_DERIVED, WATT_HOUR, 1.0E9, true);
        TERAWATT_HOUR = new EnergyUnit("EnergyUnit.terawatt-hour", "EnergyUnit.TWh", SI_DERIVED, WATT_HOUR, 1.0E12, true);
        MILLIWATT_HOUR = new EnergyUnit("EnergyUnit.milliwatt-hour", "EnergyUnit.mWh", SI_DERIVED, WATT_HOUR, 1.0E-3, true);
        MICROWATT_HOUR = new EnergyUnit("EnergyUnit.microwatt-hour", "EnergyUnit.muWh", SI_DERIVED, WATT_HOUR, 1.0E-6, true);
        ELECTRONVOLT = new EnergyUnit("EnergyUnit.electronvolt", "EnergyUnit.eV", SI_ACCEPTED, JOULE, 1.602176565314E-19, true);
        MILLI_ELECTRONVOLT =
                new EnergyUnit("EnergyUnit.milli-electronvolt", "EnergyUnit.meV", SI_ACCEPTED, ELECTRONVOLT, 1.0E-3, true);
        KILO_ELECTRONVOLT =
                new EnergyUnit("EnergyUnit.kilo-electronvolt", "EnergyUnit.keV", SI_ACCEPTED, ELECTRONVOLT, 1.0E3, true);
        MEGA_ELECTRONVOLT =
                new EnergyUnit("EnergyUnit.mega-electronvolt", "EnergyUnit.MeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E6, true);
        GIGA_ELECTRONVOLT =
                new EnergyUnit("EnergyUnit.giga-electronvolt", "EnergyUnit.GeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E9, true);
        TERA_ELECTRONVOLT =
                new EnergyUnit("EnergyUnit.tera-electronvolt", "EnergyUnit.TeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E12, true);
        PETA_ELECTRONVOLT =
                new EnergyUnit("EnergyUnit.peta-electronvolt", "EnergyUnit.PeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E15, true);
        EXA_ELECTRONVOLT =
                new EnergyUnit("EnergyUnit.exa-electronvolt", "EnergyUnit.EeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E18, true);
        STHENE_METER = new EnergyUnit("EnergyUnit.sthene_meter", "EnergyUnit.sn.m", MTS, JOULE, 1000.0, true);
        ERG = new EnergyUnit("EnergyUnit.erg_(full)", "EnergyUnit.erg", CGS, JOULE, 1.0E-7, true);
    }

    /**
     * Define an EnergyUnit based on its constituent base units, e.g. a J = km.m^2/s^2.
     * @param massUnit the unit of mass for the energy unit, e.g., kilogram
     * @param lengthUnit the unit of length for the energy unit, e.g., meter
     * @param timeUnit the unit of time for the energy unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private EnergyUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final TimeUnit timeUnit,
            final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, JOULE, massUnit.getConversionFactorToStandardUnit()
                * lengthUnit.getConversionFactorToStandardUnit() * lengthUnit.getConversionFactorToStandardUnit()
                / (timeUnit.getConversionFactorToStandardUnit() * timeUnit.getConversionFactorToStandardUnit()), standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.timeUnit = timeUnit;
    }

    /**
     * Define a user-defined EnergyUnit based on its constituent base units, e.g. a J = km.m^2/s^2.
     * @param massUnit the unit of mass for the energy unit, e.g., kilogram
     * @param lengthUnit the unit of length for the energy unit, e.g., meter
     * @param timeUnit the unit of time for the energy unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public EnergyUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final TimeUnit timeUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, lengthUnit, timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Define an EnergyUnit based on a LengthUnit and a ForceUnit, e.g. a J = N.m.
     * @param forceUnit the unit of force for the energy unit, e.g., Newton
     * @param lengthUnit the unit of length for the energy unit, e.g., Meter
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private EnergyUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, JOULE, forceUnit.getConversionFactorToStandardUnit()
                * lengthUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = forceUnit.getLengthUnit();
        this.timeUnit = forceUnit.getTimeUnit();
    }

    /**
     * Define a user-defined EnergyUnit based on a LengthUnit and a ForceUnit, e.g. a J = N.m.
     * @param forceUnit the unit of force for the energy unit, e.g., Newton
     * @param lengthUnit the unit of length for the energy unit, e.g., Meter
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public EnergyUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        this(forceUnit, lengthUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build an EnergyUnit with a conversion factor to another EnergyUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private EnergyUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final EnergyUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
                standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.timeUnit = referenceUnit.getTimeUnit();
    }

    /**
     * Build a user-defined EnergyUnit with a conversion factor to another EnergyUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public EnergyUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final EnergyUnit referenceUnit, final double conversionFactorToReferenceUnit)
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
     * @return timeUnit
     */
    public final TimeUnit getTimeUnit()
    {
        return this.timeUnit;
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
