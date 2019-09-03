package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of equivalent dose (of ionizing radiation).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class EquivalentDoseUnit extends Unit<EquivalentDoseUnit>
{

    /** */
    private static final long serialVersionUID = 20190830;

    /** The base, with "m2/s2" as the SI signature. */
    public static final UnitBase<EquivalentDoseUnit> BASE = new UnitBase<>("m2/s2");

    /** The SI unit for equivalent dose of ionizing radiation is Sievert. */
    public static final EquivalentDoseUnit SI = new EquivalentDoseUnit()
            .build(new Unit.Builder<EquivalentDoseUnit>().setUnitBase(BASE).setId("Sv").setName("sievert")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** Sievert. */
    public static final EquivalentDoseUnit SIEVERT = SI;

}
