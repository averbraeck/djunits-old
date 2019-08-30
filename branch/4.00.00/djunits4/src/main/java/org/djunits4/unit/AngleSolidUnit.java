package org.djunits4.unit;

import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.StandardScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Standard solid angle unit.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class AngleSolidUnit extends Unit<AngleSolidUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the base, with "sr" as the SI signature. */
    public static final BaseUnit<AngleSolidUnit> BASE = new BaseUnit<>("sr");

    /** The SI unit for solid angle is steradian. */
    public static final AngleSolidUnit SI =
            new AngleSolidUnit().build(new Unit.Builder<AngleSolidUnit>().setBaseUnit(BASE).setId("sr").setName("steradian")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.NONE).setScale(new StandardScale()));

    /** steradian. */
    public static final AngleSolidUnit STERADIAN = SI;

    /** square degree. */
    public static final AngleSolidUnit SQUARE_DEGREE =
            STERADIAN.deriveLinear((Math.PI / 180.0) * (Math.PI / 180.0), "sq.deg", "square degree");
}
