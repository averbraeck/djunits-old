package org.djunits4.unit;

/**
 * Runtime Exceptions in Unit package.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-01-18 00:35:01 +0100 (Fri, 18 Jan 2019) $, @version $Revision: 324 $, by $Author: averbraeck $,
 * initial version Jun 18, 2014 <br>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class UnitRuntimeException extends RuntimeException
{

    /** */
    private static final long serialVersionUID = 20190821L;

    /**
     * 
     */
    public UnitRuntimeException()
    {
        super();
    }

    /**
     * @param message String; String
     * @param cause Throwable; Throwable
     * @param enableSuppression boolean;am
     * @param writableStackTrace boolean; boolean
     */
    public UnitRuntimeException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message String; String
     * @param cause Throwable; Throwable
     */
    public UnitRuntimeException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param message String; String
     */
    public UnitRuntimeException(final String message)
    {
        super(message);
    }

    /**
     * @param cause Throwable; Throwable
     */
    public UnitRuntimeException(final Throwable cause)
    {
        super(cause);
    }

}
