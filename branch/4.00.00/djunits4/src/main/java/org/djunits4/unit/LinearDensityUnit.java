package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Objects per unit of distance.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version 11 nov. 2014 <br>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class LinearDensityUnit extends Unit<LinearDensityUnit>
{
    /** */
    private static final long serialVersionUID = 20141111L;

    /** The base, with "/m" as the SI signature. */
    public static final UnitBase<LinearDensityUnit> BASE = new UnitBase<>("m-1");

    /** The SI unit for objects per unit of distance is 1/meter. */
    public static final LinearDensityUnit SI = new LinearDensityUnit()
            .build(new Unit.Builder<LinearDensityUnit>().setBaseUnit(BASE).setId("/m").setName("per meter")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** 1/meter. */
    public static final LinearDensityUnit PER_METER = SI;

    /** 1/&#181;m. */
    public static final LinearDensityUnit PER_MICROMETER =
            PER_METER.deriveLinear(1.0E6, "/mum", "per micrometer", UnitSystem.SI_DERIVED, "/\u03BCm", "/mum");

    /** 1/millimeter. */
    public static final LinearDensityUnit PER_MILLIMETER = PER_METER.deriveLinear(1.0E3, "/mm", "per millimeter");

    /** 1/centimeter. */
    public static final LinearDensityUnit PER_CENTIMETER = PER_METER.deriveLinear(100.0, "/cm", "per centimeter");

    /** 1/decimeter. */
    public static final LinearDensityUnit PER_DECIMETER = PER_METER.deriveLinear(10.0, "/dm", "per decimeter");

    /** 1/decameter. */
    public static final LinearDensityUnit PER_DECAMETER = PER_METER.deriveLinear(0.1, "/dam", "per decameter");

    /** 1/hectometer. */
    public static final LinearDensityUnit PER_HECTOMETER = PER_METER.deriveLinear(0.01, "/hm", "per hectometer");

    /** 1/kilometer. */
    public static final LinearDensityUnit PER_KILOMETER = PER_METER.deriveLinear(0.001, "/km", "per kilometer");

    /** 1/foot (international) = 0.3048 m = 1/3 yd = 12 inches. */
    public static final LinearDensityUnit PER_FOOT =
            PER_METER.deriveLinear(1.0 / 0.3048, "/ft", "per foot", UnitSystem.IMPERIAL);

    /** 1/inch (international) = 2.54 cm = 1/36 yd = 1/12 ft. */
    public static final LinearDensityUnit PER_INCH = PER_FOOT.deriveLinear(12.0, "/in", "per inch", UnitSystem.IMPERIAL);

    /** 1/yard (international) = 0.9144 m = 3 ft = 36 in. */
    public static final LinearDensityUnit PER_YARD = PER_FOOT.deriveLinear(1.0 / 3.0, "/yd", "per yard", UnitSystem.IMPERIAL);

    /** 1/mile (international) = 5280 ft = 1760 yd. */
    public static final LinearDensityUnit PER_MILE =
            PER_FOOT.deriveLinear(1.0 / 5280.0, "/mi", "per mile", UnitSystem.IMPERIAL);

    /** 1/nautical mile (international) = 1852 m. */
    public static final LinearDensityUnit PER_NAUTICAL_MILE =
            PER_METER.deriveLinear(1.0 / 1852.0, "/NM", "per Nautical Mile", UnitSystem.OTHER);

    /** 1/Astronomical Unit. */
    public static final LinearDensityUnit PER_ASTRONOMICAL_UNIT =
            PER_METER.deriveLinear(1.0 / 149597870700.0, "/AU", "per Astronomical Unit", UnitSystem.OTHER);

    /** 1/Lightyear. */
    public static final LinearDensityUnit PER_LIGHTYEAR =
            PER_METER.deriveLinear(1.0 / 9460730472580800.0, "/ly", "per lightyear", UnitSystem.OTHER);

    /** 1/Parsec. */
    public static final LinearDensityUnit PER_PARSEC =
            PER_LIGHTYEAR.deriveLinear(Math.PI / 648000.0, "/pc", "per parsec", UnitSystem.OTHER);

    /** 1/Angstrom. */
    public static final LinearDensityUnit PER_ANGSTROM =
            PER_METER.deriveLinear(1.0E-10, "/A", "per Angstrom", UnitSystem.OTHER, "/\u212B", "/A");
    
}
