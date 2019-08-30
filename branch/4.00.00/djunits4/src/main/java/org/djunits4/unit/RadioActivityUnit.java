package org.djunits4.unit;

import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of radio activity (decays per unit of time).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: pknoppers $, initial
 * version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class RadioActivityUnit extends Unit<RadioActivityUnit>
{

    /** */
    private static final long serialVersionUID = 20190830;

    /** The base, with "/s" as the SI signature. */
    public static final BaseUnit<RadioActivityUnit> BASE = new BaseUnit<>("/s");

    /** The SI unit for radio activity is Becquerel. */
    public static final RadioActivityUnit SI = new RadioActivityUnit()
            .build(new Unit.Builder<RadioActivityUnit>().setBaseUnit(BASE).setId("Bq").setName("becquerel")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(new IdentityScale()));

    /** Becquerel. */
    public static final RadioActivityUnit BECQUEREL = SI;

}
