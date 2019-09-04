package org.djunits.unit;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://Hansvanlint.weblog.tudelft.nl">Hans van Lint</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
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
                // TODO: Test for SI for relative classes; BASE for absolute classes
                if (f.getName().equals("SI") || f.getName().equals("BASE"))
                {
                    foundSI = true;
                }
            }
            assertTrue("Class " + className + " does not declare field SI or BASE", foundSI);
        }
    }
}
