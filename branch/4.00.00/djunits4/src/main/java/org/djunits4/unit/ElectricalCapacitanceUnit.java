package org.djunits4.unit;

import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of electrical capacitance.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: pknoppers $, initial
 * version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class ElectricalCapacitanceUnit extends Unit<ElectricalCapacitanceUnit>
{

    /** */
    private static final long serialVersionUID = 20190830;

    /** The base, with "s3A2/kgm2" as the SI signature. */
    public static final BaseUnit<ElectricalCapacitanceUnit> BASE = new BaseUnit<>("s4A2/kgm2");

    /** The SI unit for electrical conductance is Siemens. */
    public static final ElectricalCapacitanceUnit SI = new ElectricalCapacitanceUnit()
            .build(new Unit.Builder<ElectricalCapacitanceUnit>().setBaseUnit(BASE).setId("F").setName("farad")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(new IdentityScale()));

    /** Farad. */
    public static final ElectricalCapacitanceUnit FARAD = SI;

    /** mF. */
    public static final ElectricalCapacitanceUnit MILLIFARAD = FARAD.deriveLinear(1.0E-3, "mF", "milliFarad");

    /** uF. */
    public static final ElectricalCapacitanceUnit MICROFARAD =
            FARAD.deriveLinear(1.0E-6, "uF", "microFarad", UnitSystem.SI_DERIVED, "uF", "uF", "\u03BCF", "muF");

    /** nF. */
    public static final ElectricalCapacitanceUnit NANOFARAD = FARAD.deriveLinear(1.0E-9, "nF", "nanoFarad");

}
