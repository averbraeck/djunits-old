package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The volume flow rate is the volume of fluid which passes through a given surface per unit of time (wikipedia).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class FlowVolumeUnit extends Unit<FlowVolumeUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The base, with "kg/s" as the SI signature. */
    public static final UnitBase<FlowVolumeUnit> BASE = new UnitBase<>("m3/s");

    /** The SI unit for volume flow rate is m^3/s. */
    public static final FlowVolumeUnit SI = new FlowVolumeUnit()
            .build(new Unit.Builder<FlowVolumeUnit>().setUnitBase(BASE).setId("m^3/s").setName("cubic meter per second")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.NONE).setScale(IdentityScale.SCALE));

    /** m^3/s. */
    public static final FlowVolumeUnit CUBIC_METER_PER_SECOND = SI;

    /** m^3/min. */
    public static final FlowVolumeUnit CUBIC_METER_PER_MINUTE = SI.deriveLinear(
            factorVD(VolumeUnit.CUBIC_METER, DurationUnit.MINUTE), "m^3/min", "cubic meter per minute", UnitSystem.SI_ACCEPTED);

    /** m^3/hour. */
    public static final FlowVolumeUnit CUBIC_METER_PER_HOUR = SI.deriveLinear(
            factorVD(VolumeUnit.CUBIC_METER, DurationUnit.HOUR), "m^3/h", "cubic meter per hour", UnitSystem.SI_ACCEPTED);

    /** m^3/day. */
    public static final FlowVolumeUnit CUBIC_METER_PER_DAY = SI.deriveLinear(factorVD(VolumeUnit.CUBIC_METER, DurationUnit.DAY),
            "m^3/day", "cubic meter per day", UnitSystem.SI_ACCEPTED);

    /** L/s. */
    public static final FlowVolumeUnit LITER_PER_SECOND = SI.deriveLinear(factorVD(VolumeUnit.LITER, DurationUnit.SECOND),
            "L/sec", "liter per second", UnitSystem.SI_ACCEPTED);

    /** L/min. */
    public static final FlowVolumeUnit LITER_PER_MINUTE = SI.deriveLinear(factorVD(VolumeUnit.LITER, DurationUnit.MINUTE),
            "L/min", "liter per minute", UnitSystem.SI_ACCEPTED);

    /** L/hour. */
    public static final FlowVolumeUnit LITER_PER_HOUR =
            SI.deriveLinear(factorVD(VolumeUnit.LITER, DurationUnit.HOUR), "L/h", "liter per hour", UnitSystem.SI_ACCEPTED);

    /** L/day. */
    public static final FlowVolumeUnit LITER_PER_DAY =
            SI.deriveLinear(factorVD(VolumeUnit.LITER, DurationUnit.DAY), "L/day", "liter per day", UnitSystem.SI_ACCEPTED);

    /** ft^3/s. */
    public static final FlowVolumeUnit CUBIC_FEET_PER_SECOND = SI.deriveLinear(
            factorVD(VolumeUnit.CUBIC_FOOT, DurationUnit.SECOND), "ft^3/sec", "cubic foot per second", UnitSystem.IMPERIAL);

    /** ft^3/min. */
    public static final FlowVolumeUnit CUBIC_FEET_PER_MINUTE = SI.deriveLinear(
            factorVD(VolumeUnit.CUBIC_FOOT, DurationUnit.MINUTE), "ft^3/min", "cubic foot per minute", UnitSystem.IMPERIAL);

    /** in^3/s. */
    public static final FlowVolumeUnit CUBIC_INCH_PER_SECOND = SI.deriveLinear(
            factorVD(VolumeUnit.CUBIC_INCH, DurationUnit.SECOND), "in^3/sec", "cubic inch per second", UnitSystem.IMPERIAL);

    /** in^3/min. */
    public static final FlowVolumeUnit CUBIC_INCH_PER_MINUTE = SI.deriveLinear(
            factorVD(VolumeUnit.CUBIC_INCH, DurationUnit.MINUTE), "in^3/min", "cubic inch per minute", UnitSystem.IMPERIAL);

    /** gallon/s (US). */
    public static final FlowVolumeUnit GALLON_US_PER_SECOND =
            SI.deriveLinear(factorVD(VolumeUnit.GALLON_US, DurationUnit.SECOND), "gal(US)/sec", "US gallon per second",
                    UnitSystem.US_CUSTOMARY);

    /** gallon/min (US). */
    public static final FlowVolumeUnit GALLON_US_PER_MINUTE =
            SI.deriveLinear(factorVD(VolumeUnit.GALLON_US, DurationUnit.MINUTE), "gal(US)/min", "US gallon per minute",
                    UnitSystem.US_CUSTOMARY);

    /** gallon/hour (US). */
    public static final FlowVolumeUnit GALLON_US_PER_HOUR = SI.deriveLinear(factorVD(VolumeUnit.GALLON_US, DurationUnit.HOUR),
            "gal(US)/hr", "US gallon per hour", UnitSystem.US_CUSTOMARY);

    /** gallon/day (US). */
    public static final FlowVolumeUnit GALLON_US_PER_DAY = SI.deriveLinear(factorVD(VolumeUnit.GALLON_US, DurationUnit.DAY),
            "gal(US)/day", "US gallon per day", UnitSystem.US_CUSTOMARY);

    /**
     * Determine the conversion factor to the base flow volume unit, given a volume unit and a duration unit.
     * @param volume VolumeUnit; the used volume unit, e.g. m3
     * @param duration DurationUnit; the used duration unit, e.g. h
     * @return double; the conversion factor from the provided units (e.g. m3/h) to the standard unit (e.g., m3/s)
     */
    private static double factorVD(final VolumeUnit volume, final DurationUnit duration)
    {
        return volume.getScale().toStandardUnit(1.0) / duration.getScale().toStandardUnit(1.0);
    }

}
