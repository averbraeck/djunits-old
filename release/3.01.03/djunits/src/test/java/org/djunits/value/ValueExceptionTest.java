package org.djunits.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test the constructors for ValueException.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @version $Revision$, $LastChangedDate$, by $Author$,
 *          initial version 27 sep. 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ValueExceptionTest
{
    /**
     * Test all constructors for ValueException.
     */
    @Test
    public final void valueExceptionTest()
    {
        String message = "MessageString";
        Exception e = new ValueException(message);
        assertTrue("Exception should not be null", null != e);
        assertEquals("message should be our message", message, e.getMessage());
        assertEquals("cause should be null", null, e.getCause());
        e = new ValueException();
        assertTrue("Exception should not be null", null != e);
        assertEquals("cause should be null", null, e.getCause());
        String causeString = "CauseString";
        Throwable cause = new Throwable(causeString);
        e = new ValueException(cause);
        assertTrue("Exception should not be null", null != e);
        assertEquals("cause should not be our cause", cause, e.getCause());
        assertEquals("cause description should be our cause string", causeString, e.getCause().getMessage());
        e = new ValueException(message, cause);
        assertTrue("Exception should not be null", null != e);
        assertEquals("message should be our message", message, e.getMessage());
        assertEquals("cause should not be our cause", cause, e.getCause());
        assertEquals("cause description should be our cause string", causeString, e.getCause().getMessage());
        for (boolean enableSuppression : new boolean[] { true, false })
        {
            for (boolean writableStackTrace : new boolean[] { true, false })
            {
                e = new ValueException(message, cause, enableSuppression, writableStackTrace);
                assertTrue("Exception should not be null", null != e);
                assertEquals("message should be our message", message, e.getMessage());
                assertEquals("cause should not be our cause", cause, e.getCause());
                assertEquals("cause description should be our cause string", causeString, e.getCause().getMessage());
                // Don't know how to check if suppression is enabled/disabled
                StackTraceElement[] stackTrace = new StackTraceElement[1];
                stackTrace[0] = new StackTraceElement("a", "b", "c", 1234);
                try
                {
                    e.setStackTrace(stackTrace);
                }
                catch (Exception e1)
                {
                    assertTrue("Stack trace should be writable", writableStackTrace);
                    continue;
                }
                // You wouldn't believe it, but a call to setStackTrace if non-writable is silently ignored
                StackTraceElement[] retrievedStackTrace = e.getStackTrace();
                if (retrievedStackTrace.length > 0)
                {
                    assertTrue("stack trace should be writable", writableStackTrace);
                }
            }
        }
    }
}
