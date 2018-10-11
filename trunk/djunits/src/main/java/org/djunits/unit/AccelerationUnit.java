package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.CGS;
import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard acceleration unit based on distance and time.
 * <p>
 * Copyright (c) 2015-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AccelerationUnit extends LinearUnit<AccelerationUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the actual length unit, e.g. KILOMETER. */
    private final LengthUnit lengthUnit;

    /** the actual time unit, e.g. HOUR. */
    private final DurationUnit durationUnit;

    /** The SI unit for acceleration is m/s^2. */
    public static final AccelerationUnit SI;

    /** m/s^2. */
    public static final AccelerationUnit METER_PER_SECOND_2;

    /** km/h^2. */
    public static final AccelerationUnit KM_PER_HOUR_2;

    /** ft/s^2. */
    public static final AccelerationUnit FOOT_PER_SECOND_2;

    /** in/s^2. */
    public static final AccelerationUnit INCH_PER_SECOND_2;

    /** mi/h^2. */
    public static final AccelerationUnit MILE_PER_HOUR_2;

    /** mi/s^2. */
    public static final AccelerationUnit MILE_PER_SECOND_2;

    /** kt/s. */
    public static final AccelerationUnit KNOT_PER_SECOND;

    /** mi/h/s. */
    public static final AccelerationUnit MILE_PER_HOUR_PER_SECOND;

    /** standard gravity. */
    public static final AccelerationUnit STANDARD_GRAVITY;

    /** standard gravity. */
    public static final AccelerationUnit GAL;

    static
    {
        SI = new AccelerationUnit(LengthUnit.METER, DurationUnit.SECOND, "AccelerationUnit.meter_per_second_squared",
                "AccelerationUnit.m/s^2", SI_DERIVED, true);
        METER_PER_SECOND_2 = SI;
        KM_PER_HOUR_2 = new AccelerationUnit(LengthUnit.KILOMETER, DurationUnit.HOUR, "AccelerationUnit.km_per_hour_squared",
                "AccelerationUnit.km/h^2", SI_DERIVED, true);
        FOOT_PER_SECOND_2 = new AccelerationUnit(LengthUnit.FOOT, DurationUnit.SECOND,
                "AccelerationUnit.foot_per_second_squared", "AccelerationUnit.ft/s^2", IMPERIAL, true);
        INCH_PER_SECOND_2 = new AccelerationUnit(LengthUnit.INCH, DurationUnit.SECOND,
                "AccelerationUnit.inch_per_second_squared", "AccelerationUnit.in/s^2", IMPERIAL, true);
        MILE_PER_HOUR_2 = new AccelerationUnit(LengthUnit.MILE, DurationUnit.HOUR, "AccelerationUnit.mile_per_hour_squared",
                "AccelerationUnit.mi/h^2", IMPERIAL, true);
        MILE_PER_SECOND_2 = new AccelerationUnit(LengthUnit.MILE, DurationUnit.SECOND,
                "AccelerationUnit.mile_per_second_squared", "AccelerationUnit.mi/s^2", IMPERIAL, true);
        KNOT_PER_SECOND = new AccelerationUnit(SpeedUnit.KNOT, DurationUnit.SECOND, "AccelerationUnit.knot_per_second",
                "AccelerationUnit.kt/s", IMPERIAL, true);
        MILE_PER_HOUR_PER_SECOND = new AccelerationUnit(SpeedUnit.MILE_PER_HOUR, DurationUnit.SECOND,
                "AccelerationUnit.mile_per_hour_per_second", "AccelerationUnit.mi/h/s", IMPERIAL, true);
        STANDARD_GRAVITY = new AccelerationUnit("AccelerationUnit.standard_gravity", "AccelerationUnit.g", SI_DERIVED,
                METER_PER_SECOND_2, 9.80665, true);
        GAL = new AccelerationUnit(LengthUnit.CENTIMETER, DurationUnit.SECOND, "AccelerationUnit.gal", "AccelerationUnit.Gal",
                CGS, true);
    }

    /**
     * Define acceleration unit based on length and time. You can define units like meter/second^2 here.
     * @param lengthUnit LengthUnit; the unit of length for the acceleration unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the acceleration unit, e.g., second
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private AccelerationUnit(final LengthUnit lengthUnit, final DurationUnit durationUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, METER_PER_SECOND_2,
                lengthUnit.getScaleFactor() / (durationUnit.getScaleFactor() * durationUnit.getScaleFactor()), standardUnit);
        this.lengthUnit = lengthUnit;
        this.durationUnit = durationUnit;
    }

    /**
     * Define user defined acceleration unit based on length and time. You can define units like meter/second^2 here.
     * @param lengthUnit LengthUnit; the unit of length for the acceleration unit, e.g., meter
     * @param durationUnit DurationUnit; the unit of time for the acceleration unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public AccelerationUnit(final LengthUnit lengthUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        this(lengthUnit, durationUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Define acceleration unit based on speed and time. You can define units like (mile/hour)/second here.
     * @param speedUnit SpeedUnit; the unit of speed for the acceleration unit, e.g., knot
     * @param durationUnit DurationUnit; the unit of time for the acceleration unit, e.g., second
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private AccelerationUnit(final SpeedUnit speedUnit, final DurationUnit durationUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, METER_PER_SECOND_2,
                speedUnit.getScaleFactor() / durationUnit.getScaleFactor(), standardUnit);
        this.lengthUnit = speedUnit.getLengthUnit();
        this.durationUnit = durationUnit;
    }

    /**
     * Define user-defined acceleration unit based on speed and time. You can define units like (mile/hour)/second here.
     * @param speedUnit SpeedUnit; the unit of speed for the acceleration unit, e.g., knot
     * @param durationUnit DurationUnit; the unit of time for the acceleration unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public AccelerationUnit(final SpeedUnit speedUnit, final DurationUnit durationUnit, final String name,
            final String abbreviation, final UnitSystem unitSystem)
    {
        this(speedUnit, durationUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a unit with a conversion factor to another unit.
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit AccelerationUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private AccelerationUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final UnitSystem unitSystem, final AccelerationUnit referenceUnit, final double scaleFactorToReferenceUnit,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined unit with a conversion factor to another unit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit AccelerationUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public AccelerationUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final AccelerationUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit, false);
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
    public final AccelerationUnit getStandardUnit()
    {
        return METER_PER_SECOND_2;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "m/s2";
    }

}
