package org.djunits.unit;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 12 jan. 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://Hansvanlint.weblog.tudelft.nl">Hans van Lint</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.citg.tudelft.nl">Guus Tamminga</a>
 * @author <a href="http://www.citg.tudelft.nl">Yufei Yuan</a>
 */
public class DefinesSITest
{
    /**
     * Check that all unit classes that extend Unit define the SI field.
     */
    @SuppressWarnings("rawtypes")
    @Test
    public final void definesSI()
    {
        for (String className : Unit.STANDARD_UNITS)
        {
            if (className.endsWith("SIUnit") || className.endsWith("LinearUnit") || className.contains("Money"))
            {
                continue;
            }

            Class c;
            try
            {
                c = Class.forName("org.djunits.unit." + className);
            }
            catch (Exception exception)
            {
                Assert.fail("Class org.djunits.unit." + className + " could not be loaded");
                return;
            }

            Field[] fields = c.getDeclaredFields();
            boolean foundSI = false;
            for (Field f : fields)
            {
                if (f.getName().equals("SI"))
                {
                    foundSI = true;
                }
            }
            assertTrue("Class " + className + " does not declare field SI", foundSI);
        }
    }
}
