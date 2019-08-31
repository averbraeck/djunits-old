package org.djunits4.unit;

/**
 * SIUnit describes a unit with arbitrary SI dimensions for which no predefined unit exists.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class SIUnit extends Unit<SIUnit>
{
    /** */
    private static final long serialVersionUID = 20190829L;

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return getUnitBase().getSiDimensions().toString(true, false);
    }

}
