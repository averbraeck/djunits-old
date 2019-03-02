package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * According to <a href="http://en.wikipedia.org/wiki/Velocity">Wikipedia</a>: Speed describes only how fast an object is
 * moving, whereas speed gives both how fast and in what direction the object is moving.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class SpeedUnit extends LinearUnit<SpeedUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The unit of length for the speed unit, e.g., meter. */
    private final LengthUnit lengthUnit;

    /** The unit of time for the speed unit, e.g., second. */
    private final DurationUnit durationUnit;

    /** The SI unit for speed is m/s. */
    public static final SpeedUnit SI;

    /** m/s. */
    public static final SpeedUnit METER_PER_SECOND;

    /** m/h. */
    public static final SpeedUnit METER_PER_HOUR;

    /** km/s. */
    public static final SpeedUnit KM_PER_SECOND;

    /** km/h. */
    public static final SpeedUnit KM_PER_HOUR;

    /** in/s. */
    public static final SpeedUnit INCH_PER_SECOND;

    /** in/min. */
    public static final SpeedUnit INCH_PER_MINUTE;

    /** in/h. */
    public static final SpeedUnit INCH_PER_HOUR;

    /** ft/s. */
    public static final SpeedUnit FOOT_PER_SECOND;

    /** ft/min. */
    public static final SpeedUnit FOOT_PER_MINUTE;

    /** ft/h. */
    public static final SpeedUnit FOOT_PER_HOUR;

    /** mile/s. */
    public static final SpeedUnit MILE_PER_SECOND;

    /** mile/min. */
    public static final SpeedUnit MILE_PER_MINUTE;

    /** mile/h. */
    public static final SpeedUnit MILE_PER_HOUR;

    /** knot. */
    public static final SpeedUnit KNOT;

    static
    {
        SI = new SpeedUnit(LengthUnit.METER, DurationUnit.SECOND, "SpeedUnit.m/s", SI_DERIVED);
        METER_PER_SECOND = SI;
        METER_PER_HOUR = new SpeedUnit(LengthUnit.METER, DurationUnit.HOUR, "SpeedUnit.m/h", SI_DERIVED);
        KM_PER_SECOND = new SpeedUnit(LengthUnit.KILOMETER, DurationUnit.SECOND, "SpeedUnit.km/s", SI_DERIVED);
        KM_PER_HOUR = new SpeedUnit(LengthUnit.KILOMETER, DurationUnit.HOUR, "SpeedUnit.km/h", SI_DERIVED);
        INCH_PER_SECOND = new SpeedUnit(LengthUnit.INCH, DurationUnit.SECOND, "SpeedUnit.in/s", IMPERIAL);
        INCH_PER_MINUTE = new SpeedUnit(LengthUnit.INCH, DurationUnit.MINUTE, "SpeedUnit.in/min", IMPERIAL);
        INCH_PER_HOUR = new SpeedUnit(LengthUnit.INCH, DurationUnit.HOUR, "SpeedUnit.in/h", IMPERIAL);
        FOOT_PER_SECOND = new SpeedUnit(LengthUnit.FOOT, DurationUnit.SECOND, "SpeedUnit.fps", IMPERIAL);
        FOOT_PER_MINUTE = new SpeedUnit(LengthUnit.FOOT, DurationUnit.MINUTE, "SpeedUnit.ft/min", IMPERIAL);
        FOOT_PER_HOUR = new SpeedUnit(LengthUnit.FOOT, DurationUnit.HOUR, "SpeedUnit.ft/h", IMPERIAL);
        MILE_PER_SECOND = new SpeedUnit(LengthUnit.MILE, DurationUnit.SECOND, "SpeedUnit.mi/s", IMPERIAL);
        MILE_PER_MINUTE = new SpeedUnit(LengthUnit.MILE, DurationUnit.MINUTE, "SpeedUnit.mi/min", IMPERIAL);
        MILE_PER_HOUR = new SpeedUnit(LengthUnit.MILE, DurationUnit.HOUR, "SpeedUnit.mph", IMPERIAL);
        KNOT = new SpeedUnit(LengthUnit.NAUTICAL_MILE, DurationUnit.HOUR, "SpeedUnit.kt", IMPERIAL);
    }

    /**
     * Build a speed unit from a length unit and a time unit.
     * @param lengthUnit LengthUnit; the unit of length for the speed unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the speed unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private SpeedUnit(final LengthUnit lengthUnit, final DurationUnit durationUnit, final String abbreviationKey,
            final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, METER_PER_SECOND, lengthUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a user-defined speed unit from a length unit and a time unit.
     * @param lengthUnit LengthUnit; the unit of length for the speed unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the speed unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public SpeedUnit(final LengthUnit lengthUnit, final DurationUnit durationUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        super(name, abbreviation, unitSystem, METER_PER_SECOND, lengthUnit.getScaleFactor() / durationUnit.getScaleFactor());
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Build a SpeedUnit based on another SpeedUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit SpeedUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private SpeedUnit(final String abbreviationKey, final UnitSystem unitSystem, final SpeedUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined SpeedUnit with a conversion factor to another SpeedUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit SpeedUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public SpeedUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final SpeedUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
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
    public final SpeedUnit getStandardUnit()
    {
        return METER_PER_SECOND;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "m/s";
    }

}
