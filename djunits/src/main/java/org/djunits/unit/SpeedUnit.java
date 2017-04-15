package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.IMPERIAL;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * According to <a href="http://en.wikipedia.org/wiki/Velocity">Wikipedia</a>: Speed describes only how fast an object is
 * moving, whereas speed gives both how fast and in what direction the object is moving.
 * <p>
 * Copyright (c) 2015-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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
    private final TimeUnit timeUnit;

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
        SI = new SpeedUnit(LengthUnit.METER, TimeUnit.SECOND, "SpeedUnit.meter_per_second", "SpeedUnit.m/s", SI_DERIVED, true);
        METER_PER_SECOND = SI;
        METER_PER_HOUR =
                new SpeedUnit(LengthUnit.METER, TimeUnit.HOUR, "SpeedUnit.meter_per_hour", "SpeedUnit.m/h", SI_DERIVED, true);
        KM_PER_SECOND = new SpeedUnit(LengthUnit.KILOMETER, TimeUnit.SECOND, "SpeedUnit.kilometer_per_second", "SpeedUnit.km/s",
                SI_DERIVED, true);
        KM_PER_HOUR = new SpeedUnit(LengthUnit.KILOMETER, TimeUnit.HOUR, "SpeedUnit.kilometer_per_hour", "SpeedUnit.km/h",
                SI_DERIVED, true);
        INCH_PER_SECOND =
                new SpeedUnit(LengthUnit.INCH, TimeUnit.SECOND, "SpeedUnit.inch_per_second", "SpeedUnit.in/s", IMPERIAL, true);
        INCH_PER_MINUTE = new SpeedUnit(LengthUnit.INCH, TimeUnit.MINUTE, "SpeedUnit.inch_per_minute", "SpeedUnit.in/min",
                IMPERIAL, true);
        INCH_PER_HOUR =
                new SpeedUnit(LengthUnit.INCH, TimeUnit.HOUR, "SpeedUnit.inch_per_hour", "SpeedUnit.in/h", IMPERIAL, true);
        FOOT_PER_SECOND =
                new SpeedUnit(LengthUnit.FOOT, TimeUnit.SECOND, "SpeedUnit.foot_per_second", "SpeedUnit.fps", IMPERIAL, true);
        FOOT_PER_MINUTE = new SpeedUnit(LengthUnit.FOOT, TimeUnit.MINUTE, "SpeedUnit.foot_per_minute", "SpeedUnit.ft/min",
                IMPERIAL, true);
        FOOT_PER_HOUR =
                new SpeedUnit(LengthUnit.FOOT, TimeUnit.HOUR, "SpeedUnit.foot_per_hour", "SpeedUnit.ft/h", IMPERIAL, true);
        MILE_PER_SECOND =
                new SpeedUnit(LengthUnit.MILE, TimeUnit.SECOND, "SpeedUnit.mile_per_second", "SpeedUnit.mi/s", IMPERIAL, true);
        MILE_PER_MINUTE = new SpeedUnit(LengthUnit.MILE, TimeUnit.MINUTE, "SpeedUnit.mile_per_minute", "SpeedUnit.mi/min",
                IMPERIAL, true);
        MILE_PER_HOUR =
                new SpeedUnit(LengthUnit.MILE, TimeUnit.HOUR, "SpeedUnit.mile_per_hour", "SpeedUnit.mph", IMPERIAL, true);
        KNOT = new SpeedUnit(LengthUnit.NAUTICAL_MILE, TimeUnit.HOUR, "SpeedUnit.knot", "SpeedUnit.kt", IMPERIAL, true);
    }

    /**
     * Build a speed unit from a length unit and a time unit.
     * @param lengthUnit the unit of length for the speed unit, e.g., meter
     * @param timeUnit the unit of time for the speed unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private SpeedUnit(final LengthUnit lengthUnit, final TimeUnit timeUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, METER_PER_SECOND,
                lengthUnit.getConversionFactorToStandardUnit() / timeUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.lengthUnit = lengthUnit;
        this.timeUnit = timeUnit;
    }

    /**
     * Build a user-defined speed unit from a length unit and a time unit.
     * @param lengthUnit the unit of length for the speed unit, e.g., meter
     * @param timeUnit the unit of time for the speed unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public SpeedUnit(final LengthUnit lengthUnit, final TimeUnit timeUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        this(lengthUnit, timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a SpeedUnit based on another SpeedUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private SpeedUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final SpeedUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
                standardUnit);
        this.lengthUnit = referenceUnit.getLengthUnit();
        this.timeUnit = referenceUnit.getTimeUnit();
    }

    /**
     * Build a user-defined SpeedUnit with a conversion factor to another SpeedUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public SpeedUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final SpeedUnit referenceUnit,
            final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
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
