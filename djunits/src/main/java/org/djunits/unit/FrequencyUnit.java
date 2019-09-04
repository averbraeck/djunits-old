package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard frequency unit based on time.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
        SI = new FrequencyUnit(DurationUnit.SECOND, "FrequencyUnit.Hz", SI_DERIVED);
        HERTZ = SI;
        KILOHERTZ = new FrequencyUnit("FrequencyUnit.kHz", SI_DERIVED, HERTZ, 1000.0);
        MEGAHERTZ = new FrequencyUnit("FrequencyUnit.MHz", SI_DERIVED, HERTZ, 1.0E6);
        GIGAHERTZ = new FrequencyUnit("FrequencyUnit.GHz", SI_DERIVED, HERTZ, 1.0E9);
        TERAHERTZ = new FrequencyUnit("FrequencyUnit.THz", SI_DERIVED, HERTZ, 1.0E12);
        RPM = new FrequencyUnit("FrequencyUnit.rpm", OTHER, HERTZ, 1.0 / 60.0);
        PER_ATTOSECOND = new FrequencyUnit(DurationUnit.ATTOSECOND, "FrequencyUnit.1/as", SI_DERIVED);
        PER_FEMTOSECOND = new FrequencyUnit(DurationUnit.FEMTOSECOND, "FrequencyUnit.1/fs", SI_DERIVED);
        PER_PICOSECOND = new FrequencyUnit(DurationUnit.PICOSECOND, "FrequencyUnit.1/ps", SI_DERIVED);
        PER_NANOSECOND = new FrequencyUnit(DurationUnit.NANOSECOND, "FrequencyUnit.1/ns", SI_DERIVED);
        PER_MICROSECOND = new FrequencyUnit(DurationUnit.MICROSECOND, "FrequencyUnit.1/mus", SI_DERIVED);
        PER_MILLISECOND = new FrequencyUnit(DurationUnit.MILLISECOND, "FrequencyUnit.1/ms", SI_DERIVED);
        PER_SECOND = new FrequencyUnit(DurationUnit.SECOND, "FrequencyUnit.1/s", SI_DERIVED);
        PER_MINUTE = new FrequencyUnit(DurationUnit.MINUTE, "FrequencyUnit.1/min", SI_ACCEPTED);
        PER_HOUR = new FrequencyUnit(DurationUnit.HOUR, "FrequencyUnit.1/h", SI_ACCEPTED);
        PER_DAY = new FrequencyUnit(DurationUnit.DAY, "FrequencyUnit.1/d", SI_ACCEPTED);
        PER_WEEK = new FrequencyUnit(DurationUnit.WEEK, "FrequencyUnit.1/w", OTHER);
    }

    /**
     * Define a FrequencyUnit based on duration. You can define unit like "per second" (Hertz) here.
     * @param durationUnit DurationUnit; the unit of time for the frequency unit, e.g., second
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private FrequencyUnit(final DurationUnit durationUnit, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem, HERTZ, 1.0 / durationUnit.getScaleFactor());
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
        super(name, abbreviation, unitSystem, HERTZ, 1.0 / durationUnit.getScaleFactor());
        this.durationUnit = durationUnit;
    }

    /**
     * Build a FrequencyUnit with a conversion factor to another FrequencyUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit FrequencyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private FrequencyUnit(final String abbreviationKey, final UnitSystem unitSystem, final FrequencyUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
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
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
        this.durationUnit = referenceUnit.getDurationUnit();
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
