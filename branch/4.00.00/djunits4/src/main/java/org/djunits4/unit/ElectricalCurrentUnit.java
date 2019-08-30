package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Standard units for electrical current.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ElectricalCurrentUnit extends Unit<ElectricalCurrentUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The base, with "A" as the SI signature. */
    public static final UnitBase<ElectricalCurrentUnit> BASE = new UnitBase<>("A");

    /** The SI unit for electrical current is Ampere. */
    public static final ElectricalCurrentUnit SI = new ElectricalCurrentUnit()
            .build(new Unit.Builder<ElectricalCurrentUnit>().setBaseUnit(BASE).setId("A").setName("ampere")
                    .setUnitSystem(UnitSystem.SI_BASE).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** Ampere. */
    public static final ElectricalCurrentUnit AMPERE = SI;

    /** microampere. */
    public static final ElectricalCurrentUnit MICROAMPERE = AMPERE.deriveSI(SIPrefixes.getUnit("mu"));

    /** milliampere. */
    public static final ElectricalCurrentUnit MILLIAMPERE = AMPERE.deriveSI(SIPrefixes.getUnit("m"));

    /** kiloampere. */
    public static final ElectricalCurrentUnit KILOAMPERE = AMPERE.deriveSI(SIPrefixes.getUnit("k"));

    /** megaampere. */
    public static final ElectricalCurrentUnit MEGAAMPERE = AMPERE.deriveSI(SIPrefixes.getUnit("M"));

    /** statampere (GCS ESU). */
    public static final ElectricalCurrentUnit STATAMPERE = AMPERE.deriveLinear(3.335641E-10, "statA", "statampere", UnitSystem.CGS_ESU);

    /** abampere (GCS EMU). */
    public static final ElectricalCurrentUnit ABAMPERE = AMPERE.deriveLinear(10.0, "abA", "abampere", UnitSystem.CGS_EMU);
    
}
