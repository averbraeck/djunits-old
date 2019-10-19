package org.djunits.unit;

import org.djunits.unit.base.UnitBase;
import org.djunits.unit.scale.IdentityScale;
import org.djunits.unit.si.SIPrefixes;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of illuminance.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class IlluminanceUnit extends Unit<IlluminanceUnit>
{
    /** */
    private static final long serialVersionUID = 20190830;

    /** The base, with "lux" as the SI signature. */
    public static final UnitBase<IlluminanceUnit> BASE = new UnitBase<>("srcd/m2");

    /** The SI unit for amount of illuminance is lux. */
    public static final IlluminanceUnit SI =
            new IlluminanceUnit().build(new Unit.Builder<IlluminanceUnit>().setUnitBase(BASE).setId("lx").setName("lux")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT, 1.0).setScale(IdentityScale.SCALE));

    /** Lux. */
    public static final IlluminanceUnit LUX = SI;

}
