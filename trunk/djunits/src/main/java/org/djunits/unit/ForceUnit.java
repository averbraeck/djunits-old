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
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
        SI = new ForceUnit(MassUnit.KILOGRAM, LengthUnit.METER, DurationUnit.SECOND, "ForceUnit.N", SI_DERIVED);
        NEWTON = SI;
        DYNE = new ForceUnit(MassUnit.GRAM, LengthUnit.CENTIMETER, DurationUnit.SECOND, "ForceUnit.dyn", CGS);
        KILOGRAM_FORCE = new ForceUnit(MassUnit.KILOGRAM, AccelerationUnit.STANDARD_GRAVITY, "ForceUnit.kgf", OTHER);
        OUNCE_FORCE = new ForceUnit(MassUnit.OUNCE, AccelerationUnit.STANDARD_GRAVITY, "ForceUnit.ozf", IMPERIAL);
        POUND_FORCE = new ForceUnit(MassUnit.POUND, AccelerationUnit.STANDARD_GRAVITY, "ForceUnit.lbf", IMPERIAL);
        TON_FORCE = new ForceUnit(MassUnit.TON_SHORT, AccelerationUnit.STANDARD_GRAVITY, "ForceUnit.tnf", IMPERIAL);
        STHENE = new ForceUnit(MassUnit.TON_METRIC, AccelerationUnit.METER_PER_SECOND_2, "ForceUnit.sn", MTS);
    }

    /**
     * Build a ForceUnit based on its constituent base units, e.g. a N = km.m/s^2.
     * @param massUnit MassUnit; the unit of mass for the force unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the force unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the force unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private ForceUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, NEWTON, massUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                / (durationUnit.getScaleFactor() * durationUnit.getScaleFactor()));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a user-defined ForceUnit based on its constituent base units, e.g. a N = km.m/s^2.
     * @param massUnit MassUnit; the unit of mass for the force unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the force unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the force unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public ForceUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, NEWTON, massUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                / (durationUnit.getScaleFactor() * durationUnit.getScaleFactor()));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a ForceUnit based on a MassUnit and an AccelerationUnit, i.e. based on F=m.a.
     * @param massUnit MassUnit; the unit of mass for the force unit, e.g., kilogram
     * @param accelerationUnit AccelerationUnit; the unit of acceleration for the force unit, e.g., m/s^2
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private ForceUnit(final MassUnit massUnit, final AccelerationUnit accelerationUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, NEWTON, massUnit.getScaleFactor() * accelerationUnit.getScaleFactor());
        this.massUnit = massUnit;
        this.lengthUnit = accelerationUnit.getLengthUnit();
        this.durationUnit = accelerationUnit.getDurationUnit();
    }

    /**
     * Build a user-defined ForceUnit based on a MassUnit and an AccelerationUnit, i.e. based on F=m.a.
     * @param massUnit MassUnit; the unit of mass for the force unit, e.g., kilogram
     * @param accelerationUnit AccelerationUnit; the unit of acceleration for the force unit, e.g., m/s^2
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public ForceUnit(final MassUnit massUnit, final AccelerationUnit accelerationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, NEWTON, massUnit.getScaleFactor() * accelerationUnit.getScaleFactor());
        this.massUnit = massUnit;
        this.lengthUnit = accelerationUnit.getLengthUnit();
        this.durationUnit = accelerationUnit.getDurationUnit();
    }

    /**
     * Build a ForceUnit with a conversion factor to another ForceUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ForceUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private ForceUnit(final String abbreviationKey, final UnitSystem unitSystem, final ForceUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined ForceUnit with a conversion factor to another ForceUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit ForceUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public ForceUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final ForceUnit referenceUnit,
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
