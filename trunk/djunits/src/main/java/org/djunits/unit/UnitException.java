package org.djunits.unit;

/**
 * Exceptions in Unit package.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-07-26 01:01:13 +0200 (Sun, 26 Jul 2015) $, @version $Revision: 1155 $, by $Author: averbraeck $,
 * initial version Jun 18, 2014 <br>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class UnitException extends Exception
{

    /** */
    private static final long serialVersionUID = 20140618L;

    /**
     * 
     */
    public UnitException()
    {
        super();
    }

    /**
     * @param message String
     * @param cause Throwable
     * @param enableSuppression bpp;am
     * @param writableStackTrace boolean
     */
    public UnitException(final String message, final Throwable cause, final boolean enableSuppression,
        final boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message String
     * @param cause Throwable
     */
    public UnitException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param message String
     */
    public UnitException(final String message)
    {
        super(message);
    }

    /**
     * @param cause Throwable
     */
    public UnitException(final Throwable cause)
    {
        super(cause);
    }

}
