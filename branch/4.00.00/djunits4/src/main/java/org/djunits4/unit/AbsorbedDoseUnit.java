package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of absorbed dose (of ionizing radiation).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: pknoppers $, initial
 * version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class AbsorbedDoseUnit extends Unit<AbsorbedDoseUnit>
{

    /** */
    private static final long serialVersionUID = 20190830;

    /** The base, with "m2/s2" as the SI signature. */
    public static final UnitBase<AbsorbedDoseUnit> BASE = new UnitBase<>("m2/s2");

    /** The SI unit for absorbed dose of ionizing radiation is Gray. */
    public static final AbsorbedDoseUnit SI =
            new AbsorbedDoseUnit().build(new Unit.Builder<AbsorbedDoseUnit>().setUnitBase(BASE).setId("Gy").setName("gray")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** Gray. */
    public static final AbsorbedDoseUnit GRAY = SI;

}
