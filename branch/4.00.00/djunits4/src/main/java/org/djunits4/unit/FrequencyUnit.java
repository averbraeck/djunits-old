package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Standard frequency unit based on time.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-08-12 00:52:51 +0200 (Mon, 12 Aug 2019) $, @version $Revision: 412 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class FrequencyUnit extends Unit<FrequencyUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The SI unit for frequency is Hertz or 1/s. */
    public static final UnitBase<FrequencyUnit> BASE = new UnitBase<>("/s");

    /** The SI unit for frequency is Hertz. */
    public static final FrequencyUnit SI =
            new FrequencyUnit().build(new Unit.Builder<FrequencyUnit>().setBaseUnit(BASE).setId("Hz").setName("hertz")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** Hertz. */
    public static final FrequencyUnit HERTZ = SI;

    /** kiloHertz. */
    public static final FrequencyUnit KILOHERTZ = HERTZ.deriveSI(SIPrefixes.getUnit("k"));

    /** megaHertz. */
    public static final FrequencyUnit MEGAHERTZ = HERTZ.deriveSI(SIPrefixes.getUnit("M"));

    /** gigaHertz. */
    public static final FrequencyUnit GIGAHERTZ = HERTZ.deriveSI(SIPrefixes.getUnit("G"));

    /** teraHertz. */
    public static final FrequencyUnit TERAHERTZ = HERTZ.deriveSI(SIPrefixes.getUnit("T"));

    /** Revolutions per minute = 1/60 Hz. */
    public static final FrequencyUnit RPM = HERTZ.deriveLinear(1.0 / 60.0, "rpm", "revolutions per minute", UnitSystem.OTHER);

    /** 1/s. */
    public static final FrequencyUnit PER_SECOND = HERTZ.deriveLinear(1.0, "1/s", "per second");

    /** 1/microsecond. */
    public static final FrequencyUnit PER_MICROSECOND =
            PER_SECOND.deriveLinear(1.0E6, "1/mus", "per microsecond", UnitSystem.SI_DERIVED, "1/mus", "1/\u03BCs");

    /** 1/millisecond. */
    public static final FrequencyUnit PER_MILLISECOND =
            PER_SECOND.deriveLinear(1.0E3, "1/ms", "per millisecond", UnitSystem.SI_DERIVED);

    /** 1/min. */
    public static final FrequencyUnit PER_MINUTE =
            PER_SECOND.deriveLinear(1.0 / 60.0, "1/min", "per minute", UnitSystem.SI_ACCEPTED);

    /** 1/hour. */
    public static final FrequencyUnit PER_HOUR =
            PER_SECOND.deriveLinear(1.0 / 3600.0, "1/hr", "per hour", UnitSystem.SI_ACCEPTED);

    /** 1/day. */
    public static final FrequencyUnit PER_DAY = PER_HOUR.deriveLinear(1.0 / 24.0, "1/day", "per day", UnitSystem.SI_ACCEPTED);

    /** 1/week. */
    public static final FrequencyUnit PER_WEEK = PER_DAY.deriveLinear(1.0 / 7.0, "1/wk", "per week", UnitSystem.OTHER);

}
