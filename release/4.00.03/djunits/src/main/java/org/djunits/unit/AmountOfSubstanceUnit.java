package org.djunits.unit;

import org.djunits.unit.base.UnitBase;
import org.djunits.unit.scale.IdentityScale;
import org.djunits.unit.si.SIPrefixes;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * The units of amount of substance.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class AmountOfSubstanceUnit extends Unit<AmountOfSubstanceUnit>
{
    /** */
    private static final long serialVersionUID = 20190830;

    /** The base, with "mol" as the SI signature. */
    public static final UnitBase<AmountOfSubstanceUnit> BASE = new UnitBase<>("mol");

    /** The SI unit for amount of substance is mole. */
    public static final AmountOfSubstanceUnit SI = new AmountOfSubstanceUnit()
            .build(new Unit.Builder<AmountOfSubstanceUnit>().setUnitBase(BASE).setId("mol").setName("mole")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT, 1.0).setScale(IdentityScale.SCALE));

    /** Mole. */
    public static final AmountOfSubstanceUnit MOLE = SI;

}