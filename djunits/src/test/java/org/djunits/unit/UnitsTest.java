package org.djunits.unit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test UNITS.java
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/node/13">OpenTrafficSim License</a>.
 * <p>
 * @version $Revision$, $LastChangedDate$, by $Author$, initial version Oct 21, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class UnitsTest implements UNITS
{
    /**
     * If this runs, all the static fields in the UNTIS.java interface were initialized with no errors.
     */
    @Test
    public void testUnits()
    {
        // Accessing any static field causes the class to be loaded and all units defined therein to be initialized.
        assertTrue("It exists", METER_PER_SECOND_2 != null);
    }
}
