package org.djunits4.unit;

import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.StandardScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The units of force.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class ForceUnit extends Unit<ForceUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** the base, with "kgm/s2" as the SI signature. */
    public static final BaseUnit<ForceUnit> BASE = new BaseUnit<>("kgm/s2");

    /** The SI unit for force is Newton. */
    public static final ForceUnit SI =
            new ForceUnit().build(new Unit.Builder<ForceUnit>().setBaseUnit(BASE).setId("N").setName("newton")
                    .setUnitSystem(UnitSystem.SI_DERIVED).setSiPrefixes(SIPrefixes.NONE).setScale(new StandardScale()));

    /** Newton. */
    public static final ForceUnit NEWTON = SI;

    /** Dyne. */
    public static final ForceUnit DYNE =
            SI.deriveLinear(factorMA(MassUnit.GRAM, AccelerationUnit.GAL), "dyn", "dyne", UnitSystem.CGS);

    /** kilogram-force. */
    public static final ForceUnit KILOGRAM_FORCE = SI.deriveLinear(
            factorMA(MassUnit.KILOGRAM, AccelerationUnit.STANDARD_GRAVITY), "kgf", "kilogram-force", UnitSystem.OTHER);

    /** ounce-force. */
    public static final ForceUnit OUNCE_FORCE = SI.deriveLinear(factorMA(MassUnit.OUNCE, AccelerationUnit.STANDARD_GRAVITY),
            "ozf", "ounce-force", UnitSystem.IMPERIAL);

    /** pound-force. */
    public static final ForceUnit POUND_FORCE = SI.deriveLinear(factorMA(MassUnit.POUND, AccelerationUnit.STANDARD_GRAVITY),
            "lbf", "pound-force", UnitSystem.IMPERIAL);

    /** ton-force. */
    public static final ForceUnit TON_FORCE = SI.deriveLinear(factorMA(MassUnit.TON_SHORT, AccelerationUnit.STANDARD_GRAVITY),
            "tnf", "ton-force", UnitSystem.IMPERIAL);

    /** sthene. */
    public static final ForceUnit STHENE =
            SI.deriveLinear(factorMA(MassUnit.TON_METRIC, AccelerationUnit.METER_PER_SECOND_2), "sn", "sthene", UnitSystem.MTS);

    /**
     * @param mass the used mass unit, e.g. lb
     * @param acceleration the used acceleration unit, e.g. ft/s2
     * @return the conversion factor from the provided units (e.g. lb.ft/s2) to the standard unit (e.g., kg.m/s2)
     */
    private static double factorMA(final MassUnit mass, final AccelerationUnit acceleration)
    {
        return mass.getScale().toStandardUnit(1.0) * acceleration.getScale().toStandardUnit(1.0);
    }
}
