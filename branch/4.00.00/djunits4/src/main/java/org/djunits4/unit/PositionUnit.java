package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.OffsetLinearScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Standard absolute position units.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2017-04-15 02:11:44 +0200 (Sat, 15 Apr 2017) $, @version $Revision: 239 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class PositionUnit extends AbsoluteLinearUnit<PositionUnit, LengthUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The base, with "m" as the SI signature. */
    public static final UnitBase<PositionUnit> BASE = new UnitBase<>("m");

    /** The SI unit for position is meter. */
    public static final PositionUnit DEFAULT =
            new PositionUnit().build(new AbsoluteLinearUnit.Builder<PositionUnit, LengthUnit>().setBaseUnit(BASE).setId("m")
                    .setName("meter").setUnitSystem(UnitSystem.SI_BASE).setSiPrefixes(SIPrefixes.UNIT)
                    .setScale(new OffsetLinearScale(1.0, 0.0)).setRelativeUnit(LengthUnit.METER));

    /** meter. */
    public final static PositionUnit METER = DEFAULT;

    /** nm. */
    public static final PositionUnit NANOMETER = METER.deriveSI(SIPrefixes.getUnit("n"));

    /** &#181;m. */
    public static final PositionUnit MICROMETER = METER.deriveSI(SIPrefixes.getUnit("mu"));

    /** mm. */
    public static final PositionUnit MILLIMETER = METER.deriveSI(SIPrefixes.getUnit("m"));

    /** cm. */
    public static final PositionUnit CENTIMETER = METER.deriveSI(SIPrefixes.getUnit("c"));

    /** dm. */
    public static final PositionUnit DECIMETER = METER.deriveSI(SIPrefixes.getUnit("d"));

    /** dam. */
    public static final PositionUnit DECAMETER = METER.deriveSI(SIPrefixes.getUnit("da"));

    /** hm. */
    public static final PositionUnit HECTOMETER = METER.deriveSI(SIPrefixes.getUnit("h"));

    /** km. */
    public static final PositionUnit KILOMETER = METER.deriveSI(SIPrefixes.getUnit("k"));

    /** foot (international) = 0.3048 m = 1/3 yd = 12 inches. */
    public static final PositionUnit FOOT =
            METER.deriveLinearOffset(0.3048, 0.0, LengthUnit.FOOT, "ft", "foot", UnitSystem.IMPERIAL);

    /** inch (international) = 2.54 cm = 1/36 yd = 1/12 ft. */
    public static final PositionUnit INCH =
            METER.deriveLinearOffset(0.3048 / 12.0, 0.0, LengthUnit.INCH, "in", "inch", UnitSystem.IMPERIAL);

    /** yard (international) = 0.9144 m = 3 ft = 36 in. */
    public static final PositionUnit YARD =
            METER.deriveLinearOffset(0.3048 * 3.0, 0.0, LengthUnit.YARD, "yd", "yard", UnitSystem.IMPERIAL);

    /** mile (international) = 5280 ft = 1760 yd. */
    public static final PositionUnit MILE =
            METER.deriveLinearOffset(0.3048 * 5280.0, 0.0, LengthUnit.MILE, "mi", "mile", UnitSystem.IMPERIAL);

    /** nautical mile (international) = 1852 m. */
    public static final PositionUnit NAUTICAL_MILE =
            METER.deriveLinearOffset(1852.0, 0.0, LengthUnit.NAUTICAL_MILE, "NM", "nautical mile", UnitSystem.OTHER);

    /** Astronomical Unit = 149,597,870,700 m. */
    public static final PositionUnit ASTRONOMICAL_UNIT = METER.deriveLinearOffset(149597870700.0, 0.0,
            LengthUnit.ASTRONOMICAL_UNIT, "AU", "Astronomical Unit", UnitSystem.OTHER);

    /** Lightyear = 9,460,730,472,580,800 m. */
    public static final PositionUnit LIGHTYEAR =
            METER.deriveLinearOffset(9460730472580800.0, 0.0, LengthUnit.LIGHTYEAR, "ly", "lightyear", UnitSystem.OTHER);

    /** Parsec = 648,000 / PI ly. */
    public static final PositionUnit PARSEC = METER.deriveLinearOffset(9460730472580800.0 * 648000.0 / Math.PI, 0.0,
            LengthUnit.PARSEC, "Pc", "Parsec", UnitSystem.OTHER);

    /** Angstrom = 10^-10 m. */
    public static final PositionUnit ANGSTROM =
            METER.deriveLinearOffset(1.0E-10, 0.0, LengthUnit.ANGSTROM, "A", "Angstrom", UnitSystem.OTHER, "\u212B", "A");

}
