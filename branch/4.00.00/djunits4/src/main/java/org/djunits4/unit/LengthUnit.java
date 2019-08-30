package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Standard length units. Several conversion factors have been taken from
 * <a href="https://en.wikipedia.org/wiki/Conversion_of_units">https://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class LengthUnit extends Unit<LengthUnit>
{
    /** */
    private static final long serialVersionUID = 20190818L;

    /** The base, with "m" as the SI signature. */
    public static final UnitBase<LengthUnit> BASE = new UnitBase<>("m");

    /** The SI unit for length is meter. */
    public static final LengthUnit SI = new LengthUnit().build(new Unit.Builder<LengthUnit>().setBaseUnit(BASE).setId("m")
            .setName("meter").setUnitSystem(UnitSystem.SI_BASE).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** meter. */
    public final static LengthUnit METER = SI;

    /** nm. */
    public static final LengthUnit NANOMETER = METER.deriveSI(SIPrefixes.getUnit("n"));

    /** &#181;m. */
    public static final LengthUnit MICROMETER = METER.deriveSI(SIPrefixes.getUnit("mu"));

    /** mm. */
    public static final LengthUnit MILLIMETER = METER.deriveSI(SIPrefixes.getUnit("m"));

    /** cm. */
    public static final LengthUnit CENTIMETER = METER.deriveSI(SIPrefixes.getUnit("c"));

    /** dm. */
    public static final LengthUnit DECIMETER = METER.deriveSI(SIPrefixes.getUnit("d"));

    /** dam. */
    public static final LengthUnit DECAMETER = METER.deriveSI(SIPrefixes.getUnit("da"));

    /** hm. */
    public static final LengthUnit HECTOMETER = METER.deriveSI(SIPrefixes.getUnit("h"));

    /** km. */
    public static final LengthUnit KILOMETER = METER.deriveSI(SIPrefixes.getUnit("k"));

    /** foot (international) = 0.3048 m = 1/3 yd = 12 inches. */
    public static final LengthUnit FOOT = METER.deriveLinear(0.3048, "ft", "foot", UnitSystem.IMPERIAL);

    /** inch (international) = 2.54 cm = 1/36 yd = 1/12 ft. */
    public static final LengthUnit INCH = FOOT.deriveLinear(1.0 / 12.0, "in", "inch");

    /** yard (international) = 0.9144 m = 3 ft = 36 in. */
    public static final LengthUnit YARD = FOOT.deriveLinear(3.0, "yd", "yard");

    /** mile (international) = 5280 ft = 1760 yd. */
    public static final LengthUnit MILE = FOOT.deriveLinear(5280.0, "mi", "mile");

    /** nautical mile (international) = 1852 m. */
    public static final LengthUnit NAUTICAL_MILE = METER.deriveLinear(1852.0, "NM", "nautical mile", UnitSystem.OTHER);

    /** Astronomical Unit = 149,597,870,700 m. */
    public static final LengthUnit ASTRONOMICAL_UNIT =
            METER.deriveLinear(149597870700.0, "AU", "Astronomical Unit", UnitSystem.OTHER);

    /** Lightyear = 9,460,730,472,580,800 m. */
    public static final LengthUnit LIGHTYEAR = METER.deriveLinear(9460730472580800.0, "ly", "lightyear", UnitSystem.OTHER);

    /** Parsec = 648,000 / PI ly. */
    public static final LengthUnit PARSEC = LIGHTYEAR.deriveLinear(648000.0 / Math.PI, "Pc", "Parsec");

    /** Angstrom = 10^-10 m. */
    public static final LengthUnit ANGSTROM = METER.deriveLinear(1.0E-10, "A", "Angstrom", UnitSystem.OTHER, "\u212B", "A");
    
}
