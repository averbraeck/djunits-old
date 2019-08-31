package org.djunits4.unit;

import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.scale.LinearScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Units for electrical charge.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-08-16 21:32:16 +0200 (Fri, 16 Aug 2019) $, @version $Revision: 417 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ElectricalChargeUnit extends Unit<ElectricalChargeUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The base, with "sA" as the SI signature. */
    public static final UnitBase<ElectricalChargeUnit> BASE = new UnitBase<>("sA");

    /** The SI unit for electrical charge is Coulomb = A.s. */
    public static final ElectricalChargeUnit SI = new ElectricalChargeUnit()
            .build(new Unit.Builder<ElectricalChargeUnit>().setUnitBase(BASE).setId("C").setName("coulomb")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(IdentityScale.SCALE));

    /** Coulomb = A.s. */
    public static final ElectricalChargeUnit COULOMB = SI;

    /** microCoulomb = muA.s. */
    public static final ElectricalChargeUnit MICROCOULOMB = COULOMB.deriveSI(SIPrefixes.getUnit("mu"));

    /** milliCoulomb = mA.s. */
    public static final ElectricalChargeUnit MILLICOULOMB = COULOMB.deriveSI(SIPrefixes.getUnit("m"));

    /** ampere hour. */
    public static final ElectricalChargeUnit AMPERE_HOUR = new ElectricalChargeUnit()
            .build(new Unit.Builder<ElectricalChargeUnit>().setUnitBase(BASE).setId("Ah").setName("ampere hour")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.UNIT).setScale(new LinearScale(3600.0)));

    /** milliampere hour. */
    public static final ElectricalChargeUnit MILLIAMPERE_HOUR = AMPERE_HOUR.deriveSI(SIPrefixes.getUnit("m"));

    /** milliampere second. */
    public static final ElectricalChargeUnit MILLIAMPERE_SECOND =
            AMPERE_HOUR.deriveLinear(1.0 / 3600.0, "mAs", "milliampere second");

    /** kiloampere hour. */
    public static final ElectricalChargeUnit KILOAMPERE_HOUR = AMPERE_HOUR.deriveSI(SIPrefixes.getUnit("k"));

    /** megaampere hour. */
    public static final ElectricalChargeUnit MEGAAMPERE_HOUR = AMPERE_HOUR.deriveSI(SIPrefixes.getUnit("M"));

    /** Faraday. */
    public static final ElectricalChargeUnit FARADAY = COULOMB.deriveLinear(96485.3383, "F", "faraday", UnitSystem.OTHER);

    /** atomic unit of charge. */
    public static final ElectricalChargeUnit ATOMIC_UNIT =
            COULOMB.deriveLinear(1.6021765314E-19, "e", "elementary unit of charge", UnitSystem.SI_ACCEPTED);

    /** statcoulomb (CGS ESU). */
    public static final ElectricalChargeUnit STATCOULOMB =
            COULOMB.deriveLinear(3.335641E-10, "statC", "statcoulomb", UnitSystem.CGS_ESU);

    /** franklin (CGS ESU). */
    public static final ElectricalChargeUnit FRANKLIN = STATCOULOMB.deriveLinear(1.0, "Fr", "franklin");

    /** esu (CGS ESU). */
    public static final ElectricalChargeUnit ESU = STATCOULOMB.deriveLinear(1.0, "esu", "electrostatic unit");

    /** abcoulomb (CGS EMU). */
    public static final ElectricalChargeUnit ABCOULOMB = COULOMB.deriveLinear(10.0, "abC", "abcoulomb", UnitSystem.CGS_EMU);

    /** emu (CGS EMU). */
    public static final ElectricalChargeUnit EMU = ABCOULOMB.deriveLinear(1.0, "emu", "electromagnetic unit");

}
