package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of electrical conductance.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: pknoppers $, initial
 * version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class ElectricalConductanceUnit extends Unit<ElectricalConductanceUnit>
{
    /** */
    private static final long serialVersionUID = 20190830;

    /** The base, with "s3A2/kgm2" as the SI signature. */
    public static final UnitBase<ElectricalConductanceUnit> BASE = new UnitBase<>("s3A2/kgm2");

    /** The SI unit for electrical conductance is Siemens. */
    public static final ElectricalConductanceUnit SI = new ElectricalConductanceUnit()
            .build(new Unit.Builder<ElectricalConductanceUnit>().setBaseUnit(BASE).setId("S").setName("siemens")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** Siemens. */
    public static final ElectricalConductanceUnit SIEMENS = SI;

}
