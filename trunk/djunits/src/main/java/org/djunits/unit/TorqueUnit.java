package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of torque (moment of force).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class TorqueUnit extends LinearUnit<TorqueUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The unit of mass for the torque unit, e.g., kilogram. */
    private final MassUnit massUnit;

    /** The unit of length for the torque unit, e.g., length. */
    private final LengthUnit lengthUnit;

    /** The unit of time for the torque unit, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for torque is Newton meter. */
    public static final TorqueUnit SI;

    /** Newton meter. */
    public static final TorqueUnit NEWTON_METER;

    /** meter kilogram-force. */
    public static final TorqueUnit METER_KILOGRAM_FORCE;

    /** Pound foot. */
    public static final TorqueUnit POUND_FOOT;

    /** Pound inch. */
    public static final TorqueUnit POUND_INCH;

    static
    {
        SI = new TorqueUnit(MassUnit.KILOGRAM, LengthUnit.METER, DurationUnit.SECOND, "TorqueUnit.N.m", SI_DERIVED);
        NEWTON_METER = SI;
        METER_KILOGRAM_FORCE = new TorqueUnit(ForceUnit.KILOGRAM_FORCE, LengthUnit.METER, "TorqueUnit.m.kgf", OTHER);
        POUND_FOOT = new TorqueUnit(ForceUnit.POUND_FORCE, LengthUnit.FOOT, "TorqueUnit.lbf.ft", IMPERIAL);
        POUND_INCH = new TorqueUnit(ForceUnit.POUND_FORCE, LengthUnit.INCH, "TorqueUnit.lbf.in", IMPERIAL);
    }

    /**
     * Create a torque unit from mass, length and time units.
     * @param massUnit MassUnit; the unit of mass for the torque unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the torque unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the torque unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private TorqueUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit,
            final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, NEWTON_METER, massUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                * lengthUnit.getScaleFactor() / (durationUnit.getScaleFactor() * durationUnit.getScaleFactor()));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Create a user-defined torque unit from mass, length and time units.
     * @param massUnit MassUnit; the unit of mass for the torque unit, e.g., kilogram
     * @param lengthUnit LengthUnit; the unit of length for the torque unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the torque unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public TorqueUnit(final MassUnit massUnit, final LengthUnit lengthUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, NEWTON_METER, massUnit.getScaleFactor() * lengthUnit.getScaleFactor()
                * lengthUnit.getScaleFactor() / (durationUnit.getScaleFactor() * durationUnit.getScaleFactor()));
        this.massUnit = massUnit;
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Create a torque unit from force and length units.
     * @param forceUnit ForceUnit; the unit of force for the torque unit, e.g., Newton
     * @param lengthUnit LengthUnit; the unit of length for the torque unit, e.g., meter
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private TorqueUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, NEWTON_METER, forceUnit.getScaleFactor() * lengthUnit.getScaleFactor());
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = forceUnit.getLengthUnit();
        this.durationUnit = forceUnit.getDurationUnit();
    }

    /**
     * Create a user-defined torque unit from force and length units.
     * @param forceUnit ForceUnit; the unit of force for the torque unit, e.g., Newton
     * @param lengthUnit LengthUnit; the unit of length for the torque unit, e.g., meter
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public TorqueUnit(final ForceUnit forceUnit, final LengthUnit lengthUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, NEWTON_METER, forceUnit.getScaleFactor() * lengthUnit.getScaleFactor());
        this.massUnit = forceUnit.getMassUnit();
        this.lengthUnit = forceUnit.getLengthUnit();
        this.durationUnit = forceUnit.getDurationUnit();
    }

    /**
     * Construct a torque unit based on another torque unit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit TorqueUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private TorqueUnit(final String abbreviationKey, final UnitSystem unitSystem, final TorqueUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.massUnit = referenceUnit.getMassUnit();
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit TorqueUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public TorqueUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final TorqueUnit referenceUnit,
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
    public final TorqueUnit getStandardUnit()
    {
        return NEWTON_METER;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "kgm2/s2";
    }

}
