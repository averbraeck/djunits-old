package org.djunits4.unit;

import org.djunits4.unit.base.BaseUnit;
import org.djunits4.unit.scale.StandardScale;
import org.djunits4.unit.si.SIPrefixes;
import org.djunits4.unit.unitsystem.UnitSystem;

/**
 * Dimensionless unit.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version Jun 5, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public final class DimensionlessUnit extends Unit<DimensionlessUnit>
{
    /** */
    private static final long serialVersionUID = 20150830L;

    /** the base, with the empty SI signature. */
    public static final BaseUnit<DimensionlessUnit> BASE = new BaseUnit<>("");

    /** The SI unit for a dimensionless unit is "1" or N/A. */
    public static final DimensionlessUnit SI =
            new DimensionlessUnit().build(new Unit.Builder<DimensionlessUnit>().setBaseUnit(BASE).setId("unit").setName("unit")
                    .setUnitSystem(UnitSystem.OTHER).setSiPrefixes(SIPrefixes.NONE).setScale(new StandardScale()));

}
