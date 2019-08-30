package org.djunits4.unit;

import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.GradeScale;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Standard angle unit. Several conversion factors have been taken from
 * <a href="http://en.wikipedia.org/wiki/Conversion_of_units">http://en.wikipedia.org/wiki/Conversion_of_units</a>.
 * <p>
 * Note that the Angle is <b>counter</b>clockwise.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AngleUnit extends Unit<AngleUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The base, with "rad" as the SI signature. */
    public static final BaseUnit<AngleUnit> BASE = new BaseUnit<>("rad");

    /** The SI unit for angle is radian. */
    public static final AngleUnit SI =
            new AngleUnit().build(new Unit.Builder<AngleUnit>().setBaseUnit(BASE).setId("rad").setName("radians")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.NONE).setScale(new IdentityScale()));

    /** radian. */
    public static final AngleUnit RADIAN = SI;

    /** percent (non-linear, 100% is 45 degrees; 90 degrees is infinite). */
    public static final AngleUnit PERCENT = new AngleUnit().build(new Unit.Builder<AngleUnit>().setBaseUnit(BASE).setId("%")
            .setName("percent").setUnitSystem(UnitSystem.OTHER).setSiPrefixes(SIPrefixes.NONE).setScale(new GradeScale(0.01)));

    /** degree. */
    public static final AngleUnit DEGREE =
            RADIAN.deriveLinear(Math.PI / 180.0, "deg", "degree", UnitSystem.SI_ACCEPTED, "\u00b0", "deg", "dg");

    /** arcminute. */
    public static final AngleUnit ARCMINUTE =
            DEGREE.deriveLinear(1.0 / 60.0, "arcmin", "arcminute", UnitSystem.SI_ACCEPTED, "'", "'", "arcmin");

    /** arcsecond. */
    public static final AngleUnit ARCSECOND = DEGREE.deriveLinear(1.0 / 3600.0, "arcsec", "arcsecond", UnitSystem.SI_ACCEPTED,
            "\"", "\"", new String[] {"arcsec"});

    /** grad. */
    public static final AngleUnit GRAD = RADIAN.deriveLinear(2.0 * Math.PI / 400.0, "grad", "gradian", UnitSystem.OTHER);

    /** centesimal arcminute. */
    public static final AngleUnit CENTESIMAL_ARCMINUTE = GRAD.deriveLinear(1.0 / 100.0, "c'", "centesimal arcminute");

    /** centesimal arcsecond. */
    public static final AngleUnit CENTESIMAL_ARCSECOND = GRAD.deriveLinear(1.0 / 10000.0, "c\"", "centesimal arcsecond");
    
}
