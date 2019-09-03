package org.djunits4.unit.util;

/**
 * Runtime Exceptions in Unit package.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-01-18 00:35:01 +0100 (Fri, 18 Jan 2019) $, @version $Revision: 324 $, by $Author: averbraeck $,
 * initial version Jun 18, 2014 <br>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class UnitRuntimeException extends RuntimeException
{

    /** */
    private static final long serialVersionUID = 20190821L;

    /**
     * Construct a new UnitRuntimeException with all default values.
     */
    public UnitRuntimeException()
    {
        super();
    }

    /**
     * Construct a new UnitRuntimeException.
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
     * Construct a new UnitRuntimeException with some default values.
     * @param message String; String
     * @param cause Throwable; Throwable
     */
    public UnitRuntimeException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

    /**
     * Construct a new UnitRuntimeException with some default values.
     * @param message String; String
     */
    public UnitRuntimeException(final String message)
    {
        super(message);
    }

    /**
     * Construct a new UnitRuntimeException with some default values.
     * @param cause Throwable; Throwable
     */
    public UnitRuntimeException(final Throwable cause)
    {
        super(cause);
    }

}