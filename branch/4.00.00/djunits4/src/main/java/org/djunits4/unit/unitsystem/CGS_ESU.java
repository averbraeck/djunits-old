package org.djunits4.unit.unitsystem;

/**
 * The centimeter-gram-second system. Electrostatic units (ESU).
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class CGS_ESU extends CGS
{
    /** */
    private static final long serialVersionUID = 20140607L;

    /**
     * protected constructor to avoid creating other (false) unit systems.
     * @param abbreviationKey String; the abbreviation of the unit system, such as SI
     * @param nameKey String; the name of the unit system, such as SI Base
     */
    protected CGS_ESU(final String abbreviationKey, final String nameKey)
    {
        super(abbreviationKey, nameKey);
    }

}
