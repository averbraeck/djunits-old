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
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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
        SI = new PressureUnit(MassUnit.KILOGRAM, LengthUnit.METER, DurationUnit.SECOND, "PressureUnit.Pa", SI_DERIVED);
        PASCAL = SI;
        HECTOPASCAL = new PressureUnit("PressureUnit.hPa", SI_DERIVED, PASCAL, 100.0);
        KILOPASCAL = new PressureUnit("PressureUnit.kPa", SI_DERIVED, PASCAL, 1000.0);
        ATMOSPHERE_STANDARD = new PressureUnit("PressureUnit.atm", OTHER, PASCAL, 101325.0);
        TORR = new PressureUnit("PressureUnit.Torr", OTHER, ATMOSPHERE_STANDARD, 1.0 / 760.0);
        ATMOSPHERE_TECHNICAL = new PressureUnit(ForceUnit.KILOGRAM_FORCE, AreaUnit.SQUARE_CENTIMETER, "PressureUnit.at", OTHER);
        BARYE = new PressureUnit(ForceUnit.DYNE, AreaUnit.SQUARE_CENTIMETER, "PressureUnit.Ba", CGS);
        BAR = new PressureUnit("PressureUnit.bar", OTHER, PASCAL, 1E5);
        MILLIBAR = new PressureUnit("PressureUnit.mbar", OTHER, PressureUnit.BAR, 0.001);
        CENTIMETER_MERCURY = new PressureUnit("PressureUnit.cmHg", OTHER, PASCAL, 1333.224);
        MILLIMETER_MERCURY = new PressureUnit("PressureUnit.mmHg", OTHER, PASCAL, 133.3224);
        FOOT_MERCURY = new PressureUnit("PressureUnit.ftHg", IMPERIAL, PASCAL, 40.63666E3);
        INCH_MERCURY = new PressureUnit("PressureUnit.inHg", IMPERIAL, PASCAL, 3.386389E3);
        KGF_PER_SQUARE_MM =
                new PressureUnit(ForceUnit.KILOGRAM_FORCE, AreaUnit.SQUARE_MILLIMETER, "PressureUnit.kgf/mm^2", OTHER);
        POUND_PER_SQUARE_FOOT =
                new PressureUnit(ForceUnit.POUND_FORCE, AreaUnit.SQUARE_FOOT, "PressureUnit.lbf/ft^2", IMPERIAL);
        POUND_PER_SQUARE_INCH =
                new PressureUnit(ForceUnit.POUND_FORCE, AreaUnit.SQUARE_INCH, "PressureUnit.lbf/in^2", IMPERIAL);
        PIEZE = new PressureUnit(MassUnit.TONNE, LengthUnit.METER, DurationUnit.SECOND, "PressureUnit.pz", MTS);
    }

    /**
     * Construct a pressure unit from mass, length and time units, e.g., a Pascal = kg/m.s^2.
     * @param massUnit MassUnit; the unit of mass for the pressure unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the pressure unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the pressure unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private PressureUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, PASCAL, massUnit.getScaleFactor()
                / (lengthUnit.getScaleFactor() * durationUnit.getScaleFactor() * durationUnit.getScaleFactor()));
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
        super(name, abbreviation, unitSystem, PASCAL, massUnit.getScaleFactor()
                / (lengthUnit.getScaleFactor() * durationUnit.getScaleFactor() * durationUnit.getScaleFactor()));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Construct a pressure unit from force and area units, e.g. a Pascal = N/m^2.
     * @param forceUnit ForceUnit; the unit of force for the pressure unit, e.g., Newton
     * @param areaUnit AreaUnit; the unit of area for the pressure unit, e.g., m^2
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private PressureUnit(final ForceUnit forceUnit, final AreaUnit areaUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, PASCAL, forceUnit.getScaleFactor() / areaUnit.getScaleFactor());
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
        super(name, abbreviation, unitSystem, PASCAL, forceUnit.getScaleFactor() / areaUnit.getScaleFactor());
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = areaUnit.getLengthUnit();
        this.durationUnit = forceUnit.getDurationUnit();
    }

    /**
     * Build a PressureUnit with a conversion factor to another PressureUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit PressureUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private PressureUnit(final String abbreviationKey, final UnitSystem unitSystem, final PressureUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
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
