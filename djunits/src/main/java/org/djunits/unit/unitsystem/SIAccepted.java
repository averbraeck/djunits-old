package org.djunits.unit.unitsystem;

/**
 * The international System of Units (SI): accepted units such as the minute, day, and liter.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-07-26 01:01:13 +0200 (Sun, 26 Jul 2015) $, @version $Revision: 1155 $, by $Author: averbraeck $,
 * initial version Jun 6, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class SIAccepted extends SI
{
    /** */
    private static final long serialVersionUID = 20140606L;

    /**
     * protected constructor to avoid creating other (false) SI unit systems.
     * @param abbreviationKey the abbreviation of the unit system, such as SI
     * @param nameKey the name of the unit system, such as SI Base
     */
    protected SIAccepted(final String abbreviationKey, final String nameKey)
    {
        super(abbreviationKey, nameKey);
    }

}
