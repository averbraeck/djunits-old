package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS;
import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.MTS;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of force.
 * <p>
 * Copyright (c) 2015-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ForceUnit extends LinearUnit<ForceUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the unit of mass for the force unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** the unit of length for the force unit, e.g., length. */
    private final LengthUnit lengthUnit;

    /** the unit of time for the force unit, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for force is Newton. */
    public static final ForceUnit SI;

    /** Newton. */
    public static final ForceUnit NEWTON;

    /** Dyne. */
    public static final ForceUnit DYNE;

    /** kilogram-force. */
    public static final ForceUnit KILOGRAM_FORCE;

    /** ounce-force. */
    public static final ForceUnit OUNCE_FORCE;

    /** pound-force. */
    public static final ForceUnit POUND_FORCE;

    /** ton-force. */
    public static final ForceUnit TON_FORCE;

    /** sthene. */
    public static final ForceUnit STHENE;

    static
    {
        SI = new ForceUnit(MassUnit.KILOGRAM, LengthUnit.METER, DurationUnit.SECOND, "ForceUnit.newton", "ForceUnit.N",
                SI_DERIVED, true);
        NEWTON = SI;
        DYNE = new ForceUnit(MassUnit.GRAM, LengthUnit.CENTIMETER, DurationUnit.SECOND, "ForceUnit.dyne", "ForceUnit.dyn", CGS,
                true);
        KILOGRAM_FORCE = new ForceUnit(MassUnit.KILOGRAM, AccelerationUnit.STANDARD_GRAVITY, "ForceUnit.kilogram-force",
                "ForceUnit.kgf", OTHER, true);
        OUNCE_FORCE = new ForceUnit(MassUnit.OUNCE, AccelerationUnit.STANDARD_GRAVITY, "ForceUnit.ounce-force", "ForceUnit.ozf",
                IMPERIAL, true);
        POUND_FORCE = new ForceUnit(MassUnit.POUND, AccelerationUnit.STANDARD_GRAVITY, "ForceUnit.pound-force", "ForceUnit.lbf",
                IMPERIAL, true);
        TON_FORCE = new ForceUnit(MassUnit.TON_SHORT, AccelerationUnit.STANDARD_GRAVITY, "ForceUnit.ton-force", "ForceUnit.tnf",
                IMPERIAL, true);
        STHENE = new ForceUnit(MassUnit.TON_METRIC, AccelerationUnit.METER_PER_SECOND_2, "ForceUnit.sthene", "ForceUnit.sn",
                MTS, true);
    }

    /**
     * Build a ForceUnit based on its constituent base units, e.g. a N = km.m/s^2.
     * @param massUnit the unit of mass for the force unit, e.g., kilogram
     * @param lengthUnit the unit of length for the force unit, e.g., meter
     * @param durationUnit the unit of time for the force unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ForceUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, NEWTON, massUnit.getScaleFactor()
                * lengthUnit.getScaleFactor() / (durationUnit.getScaleFactor() * durationUnit.getScaleFactor()), standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a user-defined ForceUnit based on its constituent base units, e.g. a N = km.m/s^2.
     * @param massUnit the unit of mass for the force unit, e.g., kilogram
     * @param lengthUnit the unit of length for the force unit, e.g., meter
     * @param durationUnit the unit of time for the force unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public ForceUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, lengthUnit, durationUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a ForceUnit based on a MassUnit and an AccelerationUnit, i.e. based on F=m.a.
     * @param massUnit the unit of mass for the force unit, e.g., kilogram
     * @param accelerationUnit the unit of acceleration for the force unit, e.g., m/s^2
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ForceUnit(final MassUnit massUnit, final AccelerationUnit accelerationUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, NEWTON,
                massUnit.getScaleFactor() * accelerationUnit.getScaleFactor(), standardUnit);
        this.massUnit = massUnit;
        this.lengthUnit = accelerationUnit.getLengthUnit();
        this.durationUnit = accelerationUnit.getDurationUnit();
    }

    /**
     * Build a user-defined ForceUnit based on a MassUnit and an AccelerationUnit, i.e. based on F=m.a.
     * @param massUnit the unit of mass for the force unit, e.g., kilogram
     * @param accelerationUnit the unit of acceleration for the force unit, e.g., m/s^2
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public ForceUnit(final MassUnit massUnit, final AccelerationUnit accelerationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        this(massUnit, accelerationUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a ForceUnit with a conversion factor to another ForceUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private ForceUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final ForceUnit referenceUnit, final double scaleFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined ForceUnit with a conversion factor to another ForceUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public ForceUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final ForceUnit referenceUnit,
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
    public final ForceUnit getStandardUnit()
    {
        return NEWTON;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kgm/s2";
    }

}
