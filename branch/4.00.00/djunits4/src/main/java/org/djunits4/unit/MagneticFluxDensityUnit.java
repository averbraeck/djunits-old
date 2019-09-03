package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of magnetic flux density, a.k.a. magnetic induction.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version May 15, 2014 <br>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class MagneticFluxDensityUnit extends Unit<MagneticFluxDensityUnit>
{
    /** */
    private static final long serialVersionUID = 20190830;

    /** The base, with "kg/m2s2A" as the SI signature. */
    public static final UnitBase<MagneticFluxDensityUnit> BASE = new UnitBase<>("kg/s2A");

    /** The SI unit for magnetic flux density is Tesla. */
    public static final MagneticFluxDensityUnit SI = new MagneticFluxDensityUnit()
            .build(new Unit.Builder<MagneticFluxDensityUnit>().setUnitBase(BASE).setId("T").setName("tesla")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** Tesla. */
    public static final MagneticFluxDensityUnit TESLA = SI;

}
