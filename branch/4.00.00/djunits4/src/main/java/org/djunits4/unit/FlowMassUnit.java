package org.djunits4.unit;

import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.IdentityScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * The mass flow rate is the mass of a substance which passes through a given surface per unit of time (wikipedia).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version May 15, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class FlowMassUnit extends Unit<FlowMassUnit>
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /** The base, with "kg/s" as the SI signature. */
    public static final BaseUnit<FlowMassUnit> BASE = new BaseUnit<>("kg/s");

    /** The SI unit for mass flow rate is kg/s. */
    public static final FlowMassUnit SI = new FlowMassUnit()
            .build(new Unit.Builder<FlowMassUnit>().setBaseUnit(BASE).setId("kg/s").setName("kilogram per second")
                    .setUnitSystem(UnitSystem.SI_BASE).setSiPrefixes(SIPrefixes.NONE).setScale(new IdentityScale()));

    /** kg/s. */
    public static final FlowMassUnit KILOGRAM_PER_SECOND = SI;

    /** lb/s. */
    public static final FlowMassUnit POUND_PER_SECOND = KILOGRAM_PER_SECOND
            .deriveLinear(factorMD(MassUnit.POUND, DurationUnit.SECOND), "lb/s", "pound per second", UnitSystem.IMPERIAL);

    /**
     * Determine the conversion factor to the base flow mass unit, given a mass unit and a duration unit.
     * @param mass MassUnit; the used mass unit, e.g. lb
     * @param duration DurationUnit; the used duration unit, e.g. h
     * @return double; the conversion factor from the provided units (e.g. lb/h) to the standard unit (e.g., kg/s)
     */
    private static double factorMD(final MassUnit mass, final DurationUnit duration)
    {
        return mass.getScale().toStandardUnit(1.0) / duration.getScale().toStandardUnit(1.0);
    }
    
}
