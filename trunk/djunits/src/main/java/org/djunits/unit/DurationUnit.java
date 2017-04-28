package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard duration units.
 * <p>
 * Copyright (c) 2015-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2017-04-15 02:11:44 +0200 (Sat, 15 Apr 2017) $, @version $Revision: 239 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class DurationUnit extends LinearUnit<DurationUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for duration is second. */
    public static final DurationUnit SI;

    /** second. */
    public static final DurationUnit SECOND;

    /** attosecond. */
    public static final DurationUnit ATTOSECOND;

    /** femtosecond. */
    public static final DurationUnit FEMTOSECOND;

    /** picosecond. */
    public static final DurationUnit PICOSECOND;

    /** nanosecond. */
    public static final DurationUnit NANOSECOND;

    /** microsecond. */
    public static final DurationUnit MICROSECOND;

    /** millisecond. */
    public static final DurationUnit MILLISECOND;

    /** minute. */
    public static final DurationUnit MINUTE;

    /** hour. */
    public static final DurationUnit HOUR;

    /** day. */
    public static final DurationUnit DAY;

    /** week. */
    public static final DurationUnit WEEK;

    static
    {
        SI = new DurationUnit("DurationUnit.second", "DurationUnit.s", SI_BASE);
        SECOND = SI;
        ATTOSECOND = new DurationUnit("DurationUnit.attosecond", "DurationUnit.as", SI_BASE, SECOND, 1E-18, true);
        FEMTOSECOND = new DurationUnit("DurationUnit.femtosecond", "DurationUnit.fs", SI_BASE, SECOND, 1E-15, true);
        PICOSECOND = new DurationUnit("DurationUnit.picosecond", "DurationUnit.ps", SI_BASE, SECOND, 1E-12, true);
        NANOSECOND = new DurationUnit("DurationUnit.nanosecond", "DurationUnit.ns", SI_BASE, SECOND, 1E-9, true);
        MICROSECOND = new DurationUnit("DurationUnit.microsecond", "DurationUnit.mus", SI_BASE, SECOND, 1E-6, true);
        MILLISECOND = new DurationUnit("DurationUnit.millisecond", "DurationUnit.ms", SI_BASE, SECOND, 1E-3, true);
        MINUTE = new DurationUnit("DurationUnit.minute", "DurationUnit.m", SI_ACCEPTED, SECOND, 60.0, true);
        HOUR = new DurationUnit("DurationUnit.hour", "DurationUnit.h", SI_ACCEPTED, MINUTE, 60.0, true);
        DAY = new DurationUnit("DurationUnit.day", "DurationUnit.d", SI_ACCEPTED, HOUR, 24.0, true);
        WEEK = new DurationUnit("DurationUnit.week", "DurationUnit.w", OTHER, DAY, 7.0, true);
    }

    /**
     * Build a standard DurationUnit.
     * @param nameKey the key to the locale file for the long name of the unit
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     */
    private DurationUnit(final String nameKey, final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(nameKey, abbreviationKey, unitSystem, true);
    }

    /**
     * Build a DurationUnit with a conversion factor to another DurationUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private DurationUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final DurationUnit referenceUnit, final double scaleFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit,
                standardUnit);
    }

    /**
     * Build a user-defined DurationUnit with a conversion factor to another DurationUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param scaleFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public DurationUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final DurationUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        this(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit, false);
    }

    /** {@inheritDoc} */
    @Override
    public final DurationUnit getStandardUnit()
    {
        return SECOND;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "s";
    }

}
