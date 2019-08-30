package org.djunits4.unit;

import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.StandardScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of torque (moment of force).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class TorqueUnit extends Unit<TorqueUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the base, with "kgm2/s2" as the SI signature. */
    public static final BaseUnit<TorqueUnit> BASE = new BaseUnit<>("kgm2/s2");

    /** The SI unit for torque is Newton meter = kgm2/s2. */
    public static final TorqueUnit SI =
            new TorqueUnit().build(new Unit.Builder<TorqueUnit>().setBaseUnit(BASE).setId("N.m").setName("Newton meter")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.NONE).setScale(new StandardScale()));

    /** Newton meter. */
    public static final TorqueUnit NEWTON_METER = SI;

    /** meter kilogram-force. */
    public static final TorqueUnit METER_KILOGRAM_FORCE = SI.deriveLinear(factorLF(LengthUnit.METER, ForceUnit.KILOGRAM_FORCE),
            "m.kgf", "meter kilogram-force", UnitSystem.OTHER);

    /** Pound foot. */
    public static final TorqueUnit POUND_FOOT =
            SI.deriveLinear(factorLF(LengthUnit.FOOT, ForceUnit.POUND_FORCE), "lbf.ft", "pound-foot", UnitSystem.IMPERIAL);

    /** Pound inch. */
    public static final TorqueUnit POUND_INCH =
            SI.deriveLinear(factorLF(LengthUnit.INCH, ForceUnit.POUND_FORCE), "lbf.in", "pound-inch", UnitSystem.IMPERIAL);

    /**
     * @param length the used length unit, e.g. m
     * @param force the used force unit, e.g. kgf
     * @return the conversion factor from the provided units (e.g. m.kgf) to the standard unit (e.g., Nm or kg.m2/s2)
     */
    private static double factorLF(final LengthUnit length, final ForceUnit force)
    {
        return length.getScale().toStandardUnit(1.0) * force.getScale().toStandardUnit(1.0);
    }
}
