package org.djunits;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.djunits.value.ValueUtil;
import org.djunits.value.formatter.Format;
import org.djunits.value.formatter.Formatter;
import org.junit.Test;

/**
 * Test the various private constructors. There is nothing to test about these, but the non-tested (almost) unreachable code
 * throws of the statistics of our test coverage.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/node/13">OpenTrafficSim License</a>.
 * <p>
 * @version $Revision$, $LastChangedDate$, by $Author$, initial
 *          version 27 sep. 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class PrivateConstructorsTest
{

    /**
     * Call a the private zero-argument constructor of the specified class.
     * @param clas Class; the class
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void callPrivateConstructor(final Class<?> clas) throws InstantiationException, IllegalAccessException,
        IllegalArgumentException, InvocationTargetException
    {
        Constructor<?>[] cons = clas.getDeclaredConstructors();
        cons[0].setAccessible(true);
        cons[0].newInstance((Object[]) null);
    }

    /**
     * Increase the code coverage by including the private constructor. <br>
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    @Test
    public void privateConstructorTest() throws InstantiationException, IllegalAccessException,
        IllegalArgumentException, InvocationTargetException
    {
        callPrivateConstructor(Format.class);
        callPrivateConstructor(Formatter.class);
        callPrivateConstructor(ValueUtil.class);
    }

}
