package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS;
import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.MTS;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of pressure.
 * <p>
 * Copyright (c) 2015-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class PressureUnit extends LinearUnit<PressureUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of mass for the pressure unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** the unit of length for the pressure unit, e.g., meter. */
    private final LengthUnit lengthUnit;

    /** the unit of time for the pressure unit, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for pressure is Pascal. */
    public static final PressureUnit SI;

    /** Pascal. */
    public static final PressureUnit PASCAL;

    /** hectoPascal. */
    public static final PressureUnit HECTOPASCAL;

    /** kiloPascal. */
    public static final PressureUnit KILOPASCAL;

    /** standard atmosphere. */
    public static final PressureUnit ATMOSPHERE_STANDARD;

    /** torr. */
    public static final PressureUnit TORR;

    /** technical atmosphere. */
    public static final PressureUnit ATMOSPHERE_TECHNICAL;

    /** barye. */
    public static final PressureUnit BARYE;

    /** bar. */
    public static final PressureUnit BAR;

    /** millibar. */
    public static final PressureUnit MILLIBAR;

    /** cm Hg. */
    public static final PressureUnit CENTIMETER_MERCURY;

    /** mm Hg. */
    public static final PressureUnit MILLIMETER_MERCURY;

    /** foot Hg. */
    public static final PressureUnit FOOT_MERCURY;

    /** inch Hg. */
    public static final PressureUnit INCH_MERCURY;

    /** kilogram-force per square millimeter. */
    public static final PressureUnit KGF_PER_SQUARE_MM;

    /** pound per square foot. */
    public static final PressureUnit POUND_PER_SQUARE_FOOT;

    /** pound per square inch. */
    public static final PressureUnit POUND_PER_SQUARE_INCH;

    /** pieze. */
    public static final PressureUnit PIEZE;

    static
    {
        SI = new PressureUnit(MassUnit.KILOGRAM, LengthUnit.METER, DurationUnit.SECOND, "PressureUnit.pascal",
                "PressureUnit.Pa", SI_DERIVED, true);
        PASCAL = SI;
        HECTOPASCAL = new PressureUnit("PressureUnit.hectopascal", "PressureUnit.hPa", SI_DERIVED, PASCAL, 100.0, true);
        KILOPASCAL = new PressureUnit("PressureUnit.kilopascal", "PressureUnit.kPa", SI_DERIVED, PASCAL, 1000.0, true);
        ATMOSPHERE_STANDARD =
                new PressureUnit("PressureUnit.atmosphere_(standard)", "PressureUnit.atm", OTHER, PASCAL, 101325.0, true);
        TORR = new PressureUnit("PressureUnit.torr", "PressureUnit.Torr", OTHER, ATMOSPHERE_STANDARD, 1.0 / 760.0, true);
        ATMOSPHERE_TECHNICAL = new PressureUnit(ForceUnit.KILOGRAM_FORCE, AreaUnit.SQUARE_CENTIMETER,
                "PressureUnit.atmosphere_(technical)", "PressureUnit.at", OTHER, true);
        BARYE = new PressureUnit(ForceUnit.DYNE, AreaUnit.SQUARE_CENTIMETER, "PressureUnit.barye", "PressureUnit.Ba", CGS,
                true);
        BAR = new PressureUnit("PressureUnit.bar_(full)", "PressureUnit.bar", OTHER, PASCAL, 1E5, true);
        MILLIBAR = new PressureUnit("PressureUnit.millibar", "PressureUnit.mbar", OTHER, PressureUnit.BAR, 0.001, true);
        CENTIMETER_MERCURY =
                new PressureUnit("PressureUnit.centimeter_mercury", "PressureUnit.cmHg", OTHER, PASCAL, 1333.224, true);
        MILLIMETER_MERCURY =
                new PressureUnit("PressureUnit.millimeter_mercury", "PressureUnit.mmHg", OTHER, PASCAL, 133.3224, true);
        FOOT_MERCURY = new PressureUnit("PressureUnit.foot_mercury", "PressureUnit.ftHg", IMPERIAL, PASCAL, 40.63666E3, true);
        INCH_MERCURY = new PressureUnit("PressureUnit.inch_mercury", "PressureUnit.inHg", IMPERIAL, PASCAL, 3.386389E3, true);
        KGF_PER_SQUARE_MM = new PressureUnit(ForceUnit.KILOGRAM_FORCE, AreaUnit.SQUARE_MILLIMETER,
                "PressureUnit.kilogram-force_per_square_millimeter", "PressureUnit.kgf/mm^2", OTHER, true);
        POUND_PER_SQUARE_FOOT = new PressureUnit(ForceUnit.POUND_FORCE, AreaUnit.SQUARE_FOOT,
                "PressureUnit.pound_per_square_foot", "PressureUnit.lbf/ft^2", IMPERIAL, true);
        POUND_PER_SQUARE_INCH = new PressureUnit(ForceUnit.POUND_FORCE, AreaUnit.SQUARE_INCH,
                "PressureUnit.pound_per_square_inch", "PressureUnit.lbf/in^2", IMPERIAL, true);
        PIEZE = new PressureUnit(MassUnit.TONNE, LengthUnit.METER, DurationUnit.SECOND, "PressureUnit.pieze", "PressureUnit.pz",
                MTS, true);
    }

    /**
     * Construct a pressure unit from mass, length and time units, e.g., a Pascal = kg/m.s^2.
     * @param massUnit MassUnit; the unit of mass for the pressure unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the pressure unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the pressure unit, e.g., second
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private PressureUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, PASCAL,
                massUnit.getScaleFactor()
                        / (lengthUnit.getScaleFactor() * durationUnit.getScaleFactor() * durationUnit.getScaleFactor()),
                standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Construct a user-defined pressure unit from mass, length and time units, e.g., a Pascal = kg/m.s^2.
     * @param massUnit MassUnit; the unit of mass for the pressure unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the pressure unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the pressure unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public PressureUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, lengthUnit, durationUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Construct a pressure unit from force and area units, e.g. a Pascal = N/m^2.
     * @param forceUnit ForceUnit; the unit of force for the pressure unit, e.g., Newton
     * @param areaUnit AreaUnit; the unit of area for the pressure unit, e.g., m^2
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private PressureUnit(final ForceUnit forceUnit, final AreaUnit areaUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, PASCAL,
                forceUnit.getScaleFactor() / areaUnit.getScaleFactor(), standardUnit);
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = areaUnit.getLengthUnit();
        this.durationUnit = forceUnit.getDurationUnit();
    }

    /**
     * Construct a user-defined pressure unit from force and area units, e.g. a Pascal = N/m^2.
     * @param forceUnit ForceUnit; the unit of force for the pressure unit, e.g., Newton
     * @param areaUnit AreaUnit; the unit of area for the pressure unit, e.g., m^2
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public PressureUnit(final ForceUnit forceUnit, final AreaUnit areaUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        this(forceUnit, areaUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a PressureUnit with a conversion factor to another PressureUnit.
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit PressureUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private PressureUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final PressureUnit referenceUnit, final double scaleFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined PressureUnit with a conversion factor to another PressureUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit PressureUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public PressureUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final PressureUnit referenceUnit, final double scaleFactorToReferenceUnit)
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
    public final PressureUnit getStandardUnit()
    {
        return PASCAL;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kg/ms2";
    }

}
