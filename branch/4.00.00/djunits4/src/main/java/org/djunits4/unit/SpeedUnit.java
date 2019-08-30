package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * According to <a href="http://en.wikipedia.org/wiki/Velocity">Wikipedia</a>: Speed describes only how fast an object is
 * moving, whereas speed gives both how fast and in what direction the object is moving.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class SpeedUnit extends Unit<SpeedUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The base, with "m/s" as the SI signature. */
    public static final UnitBase<SpeedUnit> BASE = new UnitBase<>("m/s");

    /** The SI unit for speed is m/s. */
    public static final SpeedUnit SI =
            new SpeedUnit().build(new Unit.Builder<SpeedUnit>().setBaseUnit(BASE).setId("m/s").setName("meter per second")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.NONE).setScale(IdentityScale.SCALE));

    /** m/s. */
    public static final SpeedUnit METER_PER_SECOND = SI;

    /** m/h. */
    public static final SpeedUnit METER_PER_HOUR =
            SI.deriveLinear(factorLD(LengthUnit.METER, DurationUnit.HOUR), "m/h", "meter per hour");

    /** km/s. */
    public static final SpeedUnit KM_PER_SECOND =
            SI.deriveLinear(factorLD(LengthUnit.KILOMETER, DurationUnit.SECOND), "km/s", "kilometer per second");

    /** km/h. */
    public static final SpeedUnit KM_PER_HOUR =
            SI.deriveLinear(factorLD(LengthUnit.KILOMETER, DurationUnit.HOUR), "km/h", "kilometer per hour");

    /** in/s. */
    public static final SpeedUnit INCH_PER_SECOND =
            SI.deriveLinear(factorLD(LengthUnit.INCH, DurationUnit.SECOND), "in/s", "inch per second", UnitSystem.IMPERIAL);

    /** in/min. */
    public static final SpeedUnit INCH_PER_MINUTE =
            SI.deriveLinear(factorLD(LengthUnit.INCH, DurationUnit.MINUTE), "in/min", "inch per minute", UnitSystem.IMPERIAL);

    /** in/h. */
    public static final SpeedUnit INCH_PER_HOUR =
            SI.deriveLinear(factorLD(LengthUnit.INCH, DurationUnit.HOUR), "in/h", "inch per hour", UnitSystem.IMPERIAL);

    /** ft/s. */
    public static final SpeedUnit FOOT_PER_SECOND =
            SI.deriveLinear(factorLD(LengthUnit.FOOT, DurationUnit.SECOND), "ft/s", "foot per second", UnitSystem.IMPERIAL);

    /** ft/min. */
    public static final SpeedUnit FOOT_PER_MINUTE =
            SI.deriveLinear(factorLD(LengthUnit.FOOT, DurationUnit.MINUTE), "ft/min", "inch per minute", UnitSystem.IMPERIAL);

    /** ft/h. */
    public static final SpeedUnit FOOT_PER_HOUR =
            SI.deriveLinear(factorLD(LengthUnit.FOOT, DurationUnit.HOUR), "ft/h", "foot per hour", UnitSystem.IMPERIAL);

    /** mile/s. */
    public static final SpeedUnit MILE_PER_SECOND =
            SI.deriveLinear(factorLD(LengthUnit.MILE, DurationUnit.SECOND), "mi/s", "mile per second", UnitSystem.IMPERIAL);

    /** mile/min. */
    public static final SpeedUnit MILE_PER_MINUTE =
            SI.deriveLinear(factorLD(LengthUnit.MILE, DurationUnit.MINUTE), "mi/min", "mile per minute", UnitSystem.IMPERIAL);

    /** mile/h. */
    public static final SpeedUnit MILE_PER_HOUR =
            SI.deriveLinear(factorLD(LengthUnit.MILE, DurationUnit.HOUR), "mi/h", "mile per hour", UnitSystem.IMPERIAL);

    /** knot = Nautical Mile per hour. */
    public static final SpeedUnit KNOT =
            SI.deriveLinear(factorLD(LengthUnit.NAUTICAL_MILE, DurationUnit.HOUR), "kt", "knot", UnitSystem.OTHER);

    /**
     * Determine the conversion factor to the base speed unit, given a length unit and a duration unit.
     * @param length LengthUnit; the used length unit, e.g. km
     * @param duration DurationUnit; the used duration unit, e.g. h
     * @return double; the conversion factor from the provided units (e.g. km/h) to the standard unit (e.g., m/s)
     */
    private static double factorLD(final LengthUnit length, final DurationUnit duration)
    {
        return length.getScale().toStandardUnit(1.0) / duration.getScale().toStandardUnit(1.0);
    }
    
}
