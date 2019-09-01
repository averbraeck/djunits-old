package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.djunits.unit.unitsystem.UnitSystem.SI_ACCEPTED;
import static org.djunits.unit.unitsystem.UnitSystem.SI_BASE;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Standard duration units.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2017-04-15 02:11:44 +0200 (Sat, 15 Apr 2017) $, @version $Revision: 239 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
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
        SI = new DurationUnit("DurationUnit.s", SI_BASE);
        SECOND = SI;
        ATTOSECOND = new DurationUnit("DurationUnit.as", SI_BASE, SECOND, 1E-18);
        FEMTOSECOND = new DurationUnit("DurationUnit.fs", SI_BASE, SECOND, 1E-15);
        PICOSECOND = new DurationUnit("DurationUnit.ps", SI_BASE, SECOND, 1E-12);
        NANOSECOND = new DurationUnit("DurationUnit.ns", SI_BASE, SECOND, 1E-9);
        MICROSECOND = new DurationUnit("DurationUnit.mus", SI_BASE, SECOND, 1E-6);
        MILLISECOND = new DurationUnit("DurationUnit.ms", SI_BASE, SECOND, 1E-3);
        MINUTE = new DurationUnit("DurationUnit.m", SI_ACCEPTED, SECOND, 60.0);
        HOUR = new DurationUnit("DurationUnit.h", SI_ACCEPTED, MINUTE, 60.0);
        DAY = new DurationUnit("DurationUnit.d", SI_ACCEPTED, HOUR, 24.0);
        WEEK = new DurationUnit("DurationUnit.w", OTHER, DAY, 7.0);
    }

    /**
     * Build a standard DurationUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     */
    private DurationUnit(final String abbreviationKey, final UnitSystem unitSystem)
    {
        super(abbreviationKey, unitSystem);
    }

    /**
     * Build a DurationUnit with a conversion factor to another DurationUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit DurationUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private DurationUnit(final String abbreviationKey, final UnitSystem unitSystem, final DurationUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
    }

    /**
     * Build a user-defined DurationUnit with a conversion factor to another DurationUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param unitSystem UnitSystem; the unit system, e.g. SI or Imperial
     * @param referenceUnit DurationUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public DurationUnit(final String name, final String abbreviation, final UnitSystem unitSystem,
            final DurationUnit referenceUnit, final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, unitSystem, referenceUnit, scaleFactorToReferenceUnit);
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
