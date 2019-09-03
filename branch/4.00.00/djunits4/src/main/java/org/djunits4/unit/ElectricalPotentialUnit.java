package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of electrical potential (voltage).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ElectricalPotentialUnit extends Unit<ElectricalPotentialUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The base, with "kgm2/s3A" as the SI signature. */
    public static final UnitBase<ElectricalPotentialUnit> BASE = new UnitBase<>("kgm2/s3A");

    /** The SI unit for electrical potential is Volt. */
    public static final ElectricalPotentialUnit SI = new ElectricalPotentialUnit()
            .build(new Unit.Builder<ElectricalPotentialUnit>().setUnitBase(BASE).setId("V").setName("volt")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** Volt. */
    public static final ElectricalPotentialUnit VOLT = SI;

    /** microvolt. */
    public static final ElectricalPotentialUnit MICROVOLT = VOLT.deriveSI(SIPrefixes.getUnit("mu"));

    /** millivolt. */
    public static final ElectricalPotentialUnit MILLIVOLT = VOLT.deriveSI(SIPrefixes.getUnit("m"));

    /** kilovolt. */
    public static final ElectricalPotentialUnit KILOVOLT = VOLT.deriveSI(SIPrefixes.getUnit("k"));

    /** megavolt. */
    public static final ElectricalPotentialUnit MEGAVOLT = VOLT.deriveSI(SIPrefixes.getUnit("M"));

    /** gigavolt. */
    public static final ElectricalPotentialUnit GIGAVOLT = VOLT.deriveSI(SIPrefixes.getUnit("G"));

    /** statvolt. */
    public static final ElectricalPotentialUnit STATVOLT = VOLT.deriveLinear(299.792458, "stV", "statvolt", UnitSystem.CGS_ESU);

    /** abvolt. */
    public static final ElectricalPotentialUnit ABVOLT = VOLT.deriveLinear(1.0E-8, "abV", "abvolt", UnitSystem.CGS_EMU);

}
