package org.djunits4.unit;

import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.StandardScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Standard duration units.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class DurationUnit extends Unit<DurationUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the base, with "s" as the SI signature. */
    public static final BaseUnit<DurationUnit> BASE = new BaseUnit<>("s");

    /** The SI unit for duration is second. */
    public static final DurationUnit SI = new DurationUnit().build(new Unit.Builder<DurationUnit>().setBaseUnit(BASE).setId("s")
            .setName("second").setUnitSystem(UnitSystem.SI_BASE).setSiPrefixes(SIPrefixes.UNIT).setScale(new StandardScale()));

    /** second. */
    public static final DurationUnit SECOND = SI;

    /** microsecond. */
    public static final DurationUnit MICROSECOND =
            SI.deriveLinear(1.0E-6, "mus", "microsecond", UnitSystem.SI_DERIVED, "\u03BCs", "mus");

    /** millisecond. */
    public static final DurationUnit MILLISECOND = SI.deriveLinear(1.0E-3, "ms", "millisecond", UnitSystem.SI_DERIVED);

    /** minute. */
    public static final DurationUnit MINUTE =
            SI.deriveLinear(60.0, "min", "minute", UnitSystem.SI_ACCEPTED, "min", "min", new String[] {"m"});

    /** hour. */
    public static final DurationUnit HOUR =
            MINUTE.deriveLinear(60.0, "hr", "hour", UnitSystem.SI_ACCEPTED, "hr", "hr", new String[] {"h", "hour"});

    /** day. */
    public static final DurationUnit DAY =
            HOUR.deriveLinear(24.0, "day", "day", UnitSystem.SI_ACCEPTED, "day", "day", new String[] {"d"});

    /** week. */
    public static final DurationUnit WEEK =
            DAY.deriveLinear(7.0, "wk", "week", UnitSystem.OTHER, "wk", "wk", new String[] {"w", "wk", "week"});
}
