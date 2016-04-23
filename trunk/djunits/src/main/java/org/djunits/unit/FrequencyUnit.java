package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_DERIVED;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard frequency unit based on time.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class FrequencyUnit extends LinearUnit<FrequencyUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the actual time unit, e.g. second. */
    private final TimeUnit timeUnit;

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
        SI = new FrequencyUnit(TimeUnit.SECOND, "FrequencyUnit.Hertz", "FrequencyUnit.Hz", SI_DERIVED, true);
        HERTZ = SI;
        KILOHERTZ = new FrequencyUnit("FrequencyUnit.kilohertz", "FrequencyUnit.kHz", SI_DERIVED, HERTZ, 1000.0, true);
        MEGAHERTZ = new FrequencyUnit("FrequencyUnit.megahertz", "FrequencyUnit.MHz", SI_DERIVED, HERTZ, 1.0E6, true);
        GIGAHERTZ = new FrequencyUnit("FrequencyUnit.gigahertz", "FrequencyUnit.GHz", SI_DERIVED, HERTZ, 1.0E9, true);
        TERAHERTZ = new FrequencyUnit("FrequencyUnit.terahertz", "FrequencyUnit.THz", SI_DERIVED, HERTZ, 1.0E12, true);
        RPM = new FrequencyUnit("FrequencyUnit.revolutions_per_minute", "FrequencyUnit.rpm", OTHER, HERTZ, 1.0 / 60.0, true);
        PER_MILLISECOND =
                new FrequencyUnit(TimeUnit.MILLISECOND, "FrequencyUnit.per_millisecond", "FrequencyUnit.1/ms", SI_DERIVED, true);
        PER_SECOND = new FrequencyUnit(TimeUnit.SECOND, "FrequencyUnit.per_second", "FrequencyUnit.1/s", SI_DERIVED, true);
        PER_MINUTE = new FrequencyUnit(TimeUnit.MINUTE, "FrequencyUnit.per_minute", "FrequencyUnit.1/min", SI_ACCEPTED, true);
        PER_HOUR = new FrequencyUnit(TimeUnit.HOUR, "FrequencyUnit.per_hour", "FrequencyUnit.1/h", SI_ACCEPTED, true);
        PER_DAY = new FrequencyUnit(TimeUnit.DAY, "FrequencyUnit.per_day", "FrequencyUnit.1/d", SI_ACCEPTED, true);
        PER_WEEK = new FrequencyUnit(TimeUnit.WEEK, "FrequencyUnit.per_week", "FrequencyUnit.1/w", OTHER, true);
    }

    /**
     * Define a FrequencyUnit based on time. You can define unit like "per second" (Hertz) here.
     * @param timeUnit the unit of time for the frequency unit, e.g., second
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private FrequencyUnit(final TimeUnit timeUnit, final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final UnitSystem unitSystem, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, HERTZ, 1.0 / timeUnit
                .getConversionFactorToStandardUnit(), standardUnit);
        this.timeUnit = timeUnit;
    }

    /**
     * Define a user-defined FrequencyUnit based on time. You can define unit like "per fortnight" here.
     * @param timeUnit the unit of time for the frequency unit, e.g., second
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    public FrequencyUnit(final TimeUnit timeUnit, final String name, final String abbreviation, final UnitSystem unitSystem)
    {
        this(timeUnit, name, abbreviation, unitSystem, false);
    }

    /**
     * Build a FrequencyUnit with a conversion factor to another FrequencyUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private FrequencyUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final FrequencyUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, conversionFactorToReferenceUnit,
                standardUnit);
        this.timeUnit = referenceUnit.getTimeUnit();
    }

    /**
     * Build a user-defined FrequencyUnit with a conversion factor to another FrequencyUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public FrequencyUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final FrequencyUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, conversionFactorToReferenceUnit, false);
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
