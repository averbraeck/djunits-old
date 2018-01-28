package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;

import java.util.GregorianCalendar;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard absolute time units. Note that when the offset of a stored absolute Time becomes large, precision of a float or
 * double might not be enough for the required resolution of a Time. A float has around 7 significant digits (23 bit mantissa),
 * whereas a double has around 16 significant digits (52 bit mantissa). This means that when we need to have a float time that
 * is precise to microseconds, the Time value should not go above 2^22 = 4.0E6. This is <b>not</b> enough to store Epoch values!
 * So feeding System.TimeInMillis() to a FloatTime with TimeUnit.BASE as its unit is not having the required precision. For a
 * (double) Time with TimeUnit.BASE as its unit, the largest value where the ms precision is reached is 2^51 = 2.3E15, which is
 * around 71000 years. This is sufficient to store a date on an Epoch level precise to a ms.
 * <p>
 * Copyright (c) 2015-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class TimeUnit extends AbsoluteLinearUnit<TimeUnit, DurationUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /**
     * The base unit for time with an artifical "zero" point.
     */
    public static final TimeUnit BASE;

    /**
     * The base unit for time with an artifical "zero" point with a calculation in seconds. Note that when the offset becomes
     * large, precision of a float or double might not be enough for the required resolution of a Time. A float has around 7
     * significant digits (23 bit mantissa), whereas a double has around 16 significant digits (52 bit mantissa). This means
     * that when we need to have a float time that is precise to microseconds, the Time value should not go above 2^22 = 4.0E6.
     * This is <b>not</b> enough to store Epoch values! So feeding System.TimeInMillis() to a FloatTime with TimeUnit.BASE as
     * its unit is not having the required precision. For a (double) Time with TimeUnit.BASE as its unit, the largest value
     * where the ms precision is reached is 2^51 = 2.3E15, which is around 71000 years. This is sufficient to store a date on an
     * Epoch level precise to a ms.
     */
    public static final TimeUnit BASE_SECOND;

    /** The base unit for time with an artifical "zero" point with a calculation in microseconds. */
    public static final TimeUnit BASE_MICROSECOND;

    /** The base unit for time with an artifical "zero" point with a calculation in milliseconds. */
    public static final TimeUnit BASE_MILLISECOND;

    /** The base unit for time with an artifical "zero" point with a calculation in minutes. */
    public static final TimeUnit BASE_MINUTE;

    /** The base unit for time with an artifical "zero" point with a calculation in hours. */
    public static final TimeUnit BASE_HOUR;

    /** The base unit for time with an artifical "zero" point with a calculation in days. */
    public static final TimeUnit BASE_DAY;

    /** The base unit for time with an artifical "zero" point with a calculation in weeks. */
    public static final TimeUnit BASE_WEEK;

    /**
     * The POSIX and Gregorian Epoch: January 1, 1970 at 00:00 UTC with a calculation in seconds. The base should be taken in
     * such a way that a resolution of a millisecond is still 'visible' on a date in, say, 2020. When 1-1-1970 is used as the
     * origin, 1-1-2020 has a value of 1,577,836,800,000 milliseconds = 1.6E12 ms. If we want to be precise on the ms level, we
     * need 12 significant digits. A float has around 7 significant digits (23 bit mantissa), whereas a double has around 16
     * significant digits (52 bit mantissa). This means that a float time with an offset of 1-1-1970 is at best precise to a
     * minute level. A double time is precise to microseconds. Therefore, avoid using float times that use the EPOCH.
     */
    public static final TimeUnit EPOCH;

    /** The POSIX and Gregorian Epoch: January 1, 1970 at 00:00 UTC with a calculation in seconds. */
    public static final TimeUnit EPOCH_SECOND;

    /** The POSIX and Gregorian Epoch: January 1, 1970 at 00:00 UTC with a calculation in microseconds. */
    public static final TimeUnit EPOCH_MICROSECOND;

    /** The POSIX and Gregorian Epoch: January 1, 1970 at 00:00 UTC with a calculation in milliseconds. */
    public static final TimeUnit EPOCH_MILLISECOND;

    /** The POSIX and Gregorian Epoch: January 1, 1970 at 00:00 UTC with a calculation in minutes. */
    public static final TimeUnit EPOCH_MINUTE;

    /** The POSIX and Gregorian Epoch: January 1, 1970 at 00:00 UTC with a calculation in hours. */
    public static final TimeUnit EPOCH_HOUR;

    /** The POSIX and Gregorian Epoch: January 1, 1970 at 00:00 UTC with a calculation in days. */
    public static final TimeUnit EPOCH_DAY;

    /** The POSIX and Gregorian Epoch: January 1, 1970 at 00:00 UTC with a calculation in weeks. */
    public static final TimeUnit EPOCH_WEEK;

    /**
     * The Epoch with 0001-01-01 AD at 00:00 as the origin with a calculation in seconds. When 1-1-0001 is used as the origin,
     * 1-1-2020 has a value of around 6.4E13 ms. If we want to be precise on the ms level, we need 13 significant digits. A
     * float has around 7 significant digits (23 bit mantissa), whereas a double has around 16 significant digits (52 bit
     * mantissa). This means that a float time with an offset of 1-1-0001 is at best precise to an hour level. A double time is
     * precise to microseconds. Therefore, avoid using float times that use the EPOCH_YEAR_1.
     */
    public static final TimeUnit EPOCH_YEAR_1;

    /**
     * The Epoch with J2000.0 as the origin, which is The Gregorian date January 1, 2000 at 12:00 GMT (noon) with a calculation
     * in seconds. When 1-1-2000 is used as the origin, 1-1-2020 has a value of around 6.3E11 ms. If we want to be precise on
     * the ms level, we need 11 significant digits. A float has around 7 significant digits (23 bit mantissa), whereas a double
     * has around 16 significant digits (52 bit mantissa). This means that a float time with an offset of 1-1-2000 is at best
     * precise to a minute level. A double time is precise to fractions of microseconds. Therefore, avoid using float times that
     * use the EPOCH_J2000_1.
     */
    public static final TimeUnit EPOCH_J2000_1;

    static
    {
        BASE = new TimeUnit("TimeUnit.epoch.second", "TimeUnit.epoch.s", OTHER, 1.0, 0.0, true, DurationUnit.SECOND);
        EPOCH = BASE;
        EPOCH_SECOND = BASE;
        BASE_SECOND = EPOCH_SECOND;
        EPOCH_MICROSECOND = new TimeUnit("TimeUnit.epoch.microsecond", "TimeUnit.epoch.mus", OTHER, 1E-6, 0.0, true,
                DurationUnit.MICROSECOND);
        BASE_MICROSECOND = EPOCH_MICROSECOND;
        EPOCH_MILLISECOND = new TimeUnit("TimeUnit.epoch.millisecond", "TimeUnit.epoch.ms", OTHER, 1E-3, 0.0, true,
                DurationUnit.MILLISECOND);
        BASE_MILLISECOND = EPOCH_MILLISECOND;
        EPOCH_MINUTE = new TimeUnit("TimeUnit.epoch.minute", "TimeUnit.epoch.m", OTHER, 60.0, 0.0, true, DurationUnit.MINUTE);
        BASE_MINUTE = EPOCH_MINUTE;
        EPOCH_HOUR = new TimeUnit("TimeUnit.epoch.hour", "TimeUnit.epoch.h", OTHER, 3600.0, 0.0, true, DurationUnit.HOUR);
        BASE_HOUR = EPOCH_HOUR;
        EPOCH_DAY = new TimeUnit("TimeUnit.epoch.day", "TimeUnit.epoch.d", OTHER, 3600 * 24.0, 0.0, true, DurationUnit.DAY);
        BASE_DAY = EPOCH_DAY;
        EPOCH_WEEK =
                new TimeUnit("TimeUnit.epoch.week", "TimeUnit.epoch.w", OTHER, 3600 * 24 * 7.0, 0.0, true, DurationUnit.WEEK);
        BASE_WEEK = EPOCH_WEEK;

        double seconds00010101 = new GregorianCalendar(1, 0, 1, 0, 0, 0).getTimeInMillis() / 1000.0;
        EPOCH_YEAR_1 =
                new TimeUnit("TimeUnit.epoch_1", "TimeUnit.epoch_1", OTHER, 1.0, seconds00010101, false, DurationUnit.SECOND);

        double seconds20000101 = new GregorianCalendar(2000, 0, 1, 12, 0, 0).getTimeInMillis() / 1000.0;
        EPOCH_J2000_1 = new TimeUnit("TimeUnit.epoch_j2000", "TimeUnit.epoch_j2000", OTHER, 1.0, seconds20000101, false,
                DurationUnit.SECOND);
    }

    /**
     * Build a TimeUnit with a scale factor and offset to the base TimeUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param scaleFactor multiply a value in this unit by the factor to convert to the given reference unit
     * @param offset the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     * @param relativeUnit the corresponding relative unit belonging to this absolute unit
     */
    private TimeUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final double scaleFactor, final double offset, final boolean standardUnit, final DurationUnit relativeUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, scaleFactor, offset, standardUnit, relativeUnit);
    }

    /**
     * Build a user-defined TimeUnit with a scale factor and offset to the base TimeUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param scaleFactor multiply a value in this unit by the factor to convert to the given reference unit
     * @param offset the offset to the reference unit to add to convert to the standard (e.g., BASE) unit
     * @param relativeUnit the corresponding relative unit belonging to this absolute unit
     */
    public TimeUnit(final String name, final String abbreviation, final UnitSystem unitSystem, final double scaleFactor,
            final double offset, final DurationUnit relativeUnit)
    {
        this(name, abbreviation, unitSystem, scaleFactor, offset, false, relativeUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final TimeUnit getStandardUnit()
    {
        return BASE;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "s";
    }
}
