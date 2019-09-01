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
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
        SI = new EnergyUnit(MassUnit.KILOGRAM, LengthUnit.METER, DurationUnit.SECOND, "EnergyUnit.J", SI_DERIVED);
        JOULE = SI;
        PICOJOULE = new EnergyUnit("EnergyUnit.pJ", SI_BASE, JOULE, 1E-12);
        NANOJOULE = new EnergyUnit("EnergyUnit.nJ", SI_BASE, JOULE, 1E-9);
        MICROJOULE = new EnergyUnit("EnergyUnit.muJ", SI_BASE, JOULE, 1E-6);
        MILLIJOULE = new EnergyUnit("EnergyUnit.mJ", SI_BASE, JOULE, 1E-3);
        KILOJOULE = new EnergyUnit("EnergyUnit.kJ", SI_BASE, JOULE, 1000.0);
        MEGAJOULE = new EnergyUnit("EnergyUnit.MJ", SI_BASE, JOULE, 1E9);
        GIGAJOULE = new EnergyUnit("EnergyUnit.GJ", SI_BASE, JOULE, 1E12);
        TERAJOULE = new EnergyUnit("EnergyUnit.TJ", SI_BASE, JOULE, 1E15);
        PETAJOULE = new EnergyUnit("EnergyUnit.PJ", SI_BASE, JOULE, 1E18);
        FOOT_POUND_FORCE = new EnergyUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, "EnergyUnit.ft.lbf", IMPERIAL);
        INCH_POUND_FORCE = new EnergyUnit(ForceUnit.POUND_FORCE, LengthUnit.INCH, "EnergyUnit.in.lbf", IMPERIAL);
        BTU_ISO = new EnergyUnit("EnergyUnit.BTU(ISO)", IMPERIAL, JOULE, 1.0545E3);
        BTU_IT = new EnergyUnit("EnergyUnit.BTU(IT)", IMPERIAL, JOULE, 1.05505585262E3);
        CALORIE_IT = new EnergyUnit("EnergyUnit.cal(IT)", OTHER, JOULE, 4.1868);
        CALORIE = new EnergyUnit("EnergyUnit.cal", OTHER, JOULE, 4.184);
        KILOCALORIE = new EnergyUnit("EnergyUnit.kcal", OTHER, CALORIE, 1000.0);
        WATT_HOUR = new EnergyUnit("EnergyUnit.Wh", SI_DERIVED, JOULE, 3600.0);
        FEMTOWATT_HOUR = new EnergyUnit("EnergyUnit.fWh", SI_DERIVED, WATT_HOUR, 1.0E-15);
        PICOWATT_HOUR = new EnergyUnit("EnergyUnit.pWh", SI_DERIVED, WATT_HOUR, 1.0E-12);
        NANOWATT_HOUR = new EnergyUnit("EnergyUnit.nWh", SI_DERIVED, WATT_HOUR, 1.0E-9);
        MICROWATT_HOUR = new EnergyUnit("EnergyUnit.muWh", SI_DERIVED, WATT_HOUR, 1.0E-6);
        MILLIWATT_HOUR = new EnergyUnit("EnergyUnit.mWh", SI_DERIVED, WATT_HOUR, 1.0E-3);
        KILOWATT_HOUR = new EnergyUnit("EnergyUnit.kWh", SI_DERIVED, WATT_HOUR, 1000.0);
        MEGAWATT_HOUR = new EnergyUnit("EnergyUnit.MWh", SI_DERIVED, WATT_HOUR, 1.0E6);
        GIGAWATT_HOUR = new EnergyUnit("EnergyUnit.GWh", SI_DERIVED, WATT_HOUR, 1.0E9);
        TERAWATT_HOUR = new EnergyUnit("EnergyUnit.TWh", SI_DERIVED, WATT_HOUR, 1.0E12);
        PETAWATT_HOUR = new EnergyUnit("EnergyUnit.PWh", SI_DERIVED, WATT_HOUR, 1.0E15);
        ELECTRONVOLT = new EnergyUnit("EnergyUnit.eV", SI_ACCEPTED, JOULE, 1.602176565314E-19);
        MICROELECTRONVOLT = new EnergyUnit("EnergyUnit.mueV", SI_ACCEPTED, ELECTRONVOLT, 1.0E-6);
        MILLIELECTRONVOLT = new EnergyUnit("EnergyUnit.meV", SI_ACCEPTED, ELECTRONVOLT, 1.0E-3);
        KILOELECTRONVOLT = new EnergyUnit("EnergyUnit.keV", SI_ACCEPTED, ELECTRONVOLT, 1.0E3);
        MEGAELECTRONVOLT = new EnergyUnit("EnergyUnit.MeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E6);
        GIGAELECTRONVOLT = new EnergyUnit("EnergyUnit.GeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E9);
        TERAELECTRONVOLT = new EnergyUnit("EnergyUnit.TeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E12);
        PETAELECTRONVOLT = new EnergyUnit("EnergyUnit.PeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E15);
        EXAELECTRONVOLT = new EnergyUnit("EnergyUnit.EeV", SI_ACCEPTED, ELECTRONVOLT, 1.0E18);
        STHENE_METER = new EnergyUnit("EnergyUnit.sn.m", MTS, JOULE, 1000.0);
        ERG = new EnergyUnit("EnergyUnit.erg", CGS, JOULE, 1.0E-7);
    }

    /**
     * Define an EnergyUnit based on its constituent base units, e.g. a J = km.m^2/s^2.
     * @param massUnit MassUnit; the unit of mass for the energy unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the energy unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the energy unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private EnergyUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, JOULE, massUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                * lengthUnit.getScaleFactor() / (durationUnit.getScaleFactor() * durationUnit.getScaleFactor()));
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
        super(name, abbreviation, unitSystem, JOULE, massUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                * lengthUnit.getScaleFactor() / (durationUnit.getScaleFactor() * durationUnit.getScaleFactor()));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Define an EnergyUnit based on a LengthUnit and a ForceUnit, e.g. a J = N.m.
     * @param forceUnit ForceUnit; the unit of force for the energy unit, e.g., Newton
     * @param lengthUnit LengthUnit; the unit of length for the energy unit, e.g., Meter
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private EnergyUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, JOULE, forceUnit.getScaleFactor() * lengthUnit.getScaleFactor());
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
        super(name, abbreviation, unitSystem, JOULE, forceUnit.getScaleFactor() * lengthUnit.getScaleFactor());
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = forceUnit.getLengthUnit();
        this.durationUnit = forceUnit.getDurationUnit();
    }

    /**
     * Build an EnergyUnit with a conversion factor to another EnergyUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit EnergyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private EnergyUnit(final String abbreviationKey, final UnitSystem unitSystem, final EnergyUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
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
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
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
