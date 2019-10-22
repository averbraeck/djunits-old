package org.djunits.unit;

import org.djunits.unit.base.UnitBase;
import org.djunits.unit.scale.IdentityScale;
import org.djunits.unit.si.SIPrefixes;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * Dimensionless unit.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public final class DimensionlessUnit extends Unit<DimensionlessUnit>
{
    /** */
    private static final long serialVersionUID = 20150830L;

    /** The base, with the empty SI signature. */
    public static final UnitBase<DimensionlessUnit> BASE = new UnitBase<>("Dimensionless", "");

    /** The SI unit for a dimension less unit is "1" or N/A. */
    public static final DimensionlessUnit SI =
            new DimensionlessUnit().build(new Unit.Builder<DimensionlessUnit>().setUnitBase(BASE).setId("unit").setName("unit")
                    .setUnitSystem(UnitSystem.OTHER).setSiPrefixes(SIPrefixes.NONE, 1.0).setScale(IdentityScale.SCALE));

}
