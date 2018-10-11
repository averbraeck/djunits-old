package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard frequency unit based on time.
 * <p>
 * Copyright (c) 2015-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class FrequencyUnit extends LinearUnit<FrequencyUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the actual time unit, e.g. second. */
    private final DurationUnit durationUnit;

    /** The SI unit for frequency is Hertz. */
    public static final FrequencyUnit SI;

    /** Hertz. */
    public static final FrequencyUnit HERTZ;

    /** kiloHertz. */
    public static final FrequencyUnit KILOHERTZ;

    /** megaHertz. */
    public static final FrequencyUnit MEGAHERTZ;

    /** gigaHertz. */
    public static final FrequencyUnit GIGAHERTZ;

    /** teraHertz. */
    public static final FrequencyUnit TERAHERTZ;

    /** Revolutions per minute = 1/60 Hz. */
    public static final FrequencyUnit RPM;

    /** 1/attosecond. */
    public static final FrequencyUnit PER_ATTOSECOND;

    /** 1/femtosecond. */
    public static final FrequencyUnit PER_FEMTOSECOND;

    /** 1/picosecond. */
    public static final FrequencyUnit PER_PICOSECOND;

    /** 1/nanosecond. */
    public static final FrequencyUnit PER_NANOSECOND;

    /** 1/microsecond. */
    public static final FrequencyUnit PER_MICROSECOND;

    /** 1/millisecond. */
    public static final FrequencyUnit PER_MILLISECOND;

    /** 1/s. */
    public static final FrequencyUnit PER_SECOND;

    /** 1/min. */
    public static final FrequencyUnit PER_MINUTE;

    /** 1/hour. */
    public static final FrequencyUnit PER_HOUR;

    /** 1/day. */
    public static final FrequencyUnit PER_DAY;

    /** 1/week. */
    public static final FrequencyUnit PER_WEEK;

    static
    {
        SI = new FrequencyUnit(DurationUnit.SECOND, "FrequencyUnit.Hertz", "FrequencyUnit.Hz", SI_DERIVED, true);
        HERTZ = SI;
        KILOHERTZ = new FrequencyUnit("FrequencyUnit.kilohertz", "FrequencyUnit.kHz", SI_DERIVED, HERTZ, 1000.0, true);
        MEGAHERTZ = new FrequencyUnit("FrequencyUnit.megahertz", "FrequencyUnit.MHz", SI_DERIVED, HERTZ, 1.0E6, true);
        GIGAHERTZ = new FrequencyUnit("FrequencyUnit.gigahertz", "FrequencyUnit.GHz", SI_DERIVED, HERTZ, 1.0E9, true);
        TERAHERTZ = new FrequencyUnit("FrequencyUnit.terahertz", "FrequencyUnit.THz", SI_DERIVED, HERTZ, 1.0E12, true);
        RPM = new FrequencyUnit("FrequencyUnit.revolutions_per_minute", "FrequencyUnit.rpm", OTHER, HERTZ, 1.0 / 60.0, true);
        PER_ATTOSECOND = new FrequencyUnit(DurationUnit.ATTOSECOND, "FrequencyUnit.per_attosecond", "FrequencyUnit.1/as",
                SI_DERIVED, true);
        PER_FEMTOSECOND = new FrequencyUnit(DurationUnit.FEMTOSECOND, "FrequencyUnit.per_femtosecond", "FrequencyUnit.1/fs",
                SI_DERIVED, true);
        PER_PICOSECOND = new FrequencyUnit(DurationUnit.PICOSECOND, "FrequencyUnit.per_picosecond", "FrequencyUnit.1/ps",
                SI_DERIVED, true);
        PER_NANOSECOND = new FrequencyUnit(DurationUnit.NANOSECOND, "FrequencyUnit.per_nanosecond", "FrequencyUnit.1/ns",
                SI_DERIVED, true);
        PER_MICROSECOND = new FrequencyUnit(DurationUnit.MICROSECOND, "FrequencyUnit.per_microsecond", "FrequencyUnit.1/mus",
                SI_DERIVED, true);
        PER_MILLISECOND = new FrequencyUnit(DurationUnit.MILLISECOND, "FrequencyUnit.per_millisecond", "FrequencyUnit.1/ms",
                SI_DERIVED, true);
        PER_SECOND = new FrequencyUnit(DurationUnit.SECOND, "FrequencyUnit.per_second", "FrequencyUnit.1/s", SI_DERIVED, true);
        PER_MINUTE =
                new FrequencyUnit(DurationUnit.MINUTE, "FrequencyUnit.per_minute", "FrequencyUnit.1/min", SI_ACCEPTED, true);
        PER_HOUR = new FrequencyUnit(DurationUnit.HOUR, "FrequencyUnit.per_hour", "FrequencyUnit.1/h", SI_ACCEPTED, true);
        PER_DAY = new FrequencyUnit(DurationUnit.DAY, "FrequencyUnit.per_day", "FrequencyUnit.1/d", SI_ACCEPTED, true);
        PER_WEEK = new FrequencyUnit(DurationUnit.WEEK, "FrequencyUnit.per_week", "FrequencyUnit.1/w", OTHER, true);
    }

    /**
     * Define a FrequencyUnit based on time. You can define unit like "per second" (Hertz) here.
     * @param durationUnit DurationUnit; the unit of time for the frequency unit, e.g., second
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private FrequencyUnit(final DurationUnit durationUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, HERTZ, 1.0 / durationUnit.getScaleFactor(),
                standardUnit);
        this.durationUnit = durationUnit;
    }

    /**
     * Define a user-defined FrequencyUnit based on time. You can define unit like "per fortnight" here.
     * @param durationUnit DurationUnit; the unit of time for the frequency unit, e.g., second
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    public FrequencyUnit(final DurationUnit durationUnit, final String name, final String abbreviation,
            final UnitSystem unitSystem)
    {
        this(durationUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a FrequencyUnit with a conversion factor to another FrequencyUnit.
     * @param nameOrNameKey String; if standardUnit: the key to the locale file for the long name of the unit, otherwise the
     *            name itself
     * @param abbreviationOrAbbreviationKey String; if standardUnit: the key to the locale file for the abbreviation of the
     *            unit, otherwise the abbreviation itself
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit FrequencyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     * @param standardUnit boolean; indicates whether it is a standard unit with a definition in the locale, or a user-defined
     *            unit
     */
    private FrequencyUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final FrequencyUnit referenceUnit, final double scaleFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
        this.durationUnit = referenceUnit.getDurationUnit();
    }

    /**
     * Build a user-defined FrequencyUnit with a conversion factor to another FrequencyUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit FrequencyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public FrequencyUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final FrequencyUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit, false);
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
    public final FrequencyUnit getStandardUnit()
    {
        return HERTZ;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1/s";
    }

}
