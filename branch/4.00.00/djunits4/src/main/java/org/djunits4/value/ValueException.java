package org.djunits4.value;

/**
 * Exception that is thrown for bad indices, or non-rectangular arrays, incompatible arrays or matrices, or empty arrays
 * <p>
 * This file was generated by the djunits value classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-01-18 00:35:01 +0100 (Fri, 18 Jan 2019) $, @version $Revision: 324 $, by $Author: averbraeck $,
 * initial version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ValueException extends Exception
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new ValueException.
     */
    public ValueException()
    {
        super();
    }

    /**
     * Construct a new ValueException.
     * @param message String; description of the problem
     */
    public ValueException(final String message)
    {
        super(message);
    }

    /**
     * Construct a new ValueException.
     * @param cause Throwable; the cause of this ValueException
     */
    public ValueException(final Throwable cause)
    {
        super(cause);
    }

    /**
     * Construct a new ValueException.
     * @param message String; description of the problem
     * @param cause Throwable; the cause of this ValueException
     */
    public ValueException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

    /**
     * Construct a new ValueException.
     * @param message String; description of the problem
     * @param cause Throwable; the cause of this ValueException
     * @param enableSuppression boolean; whether or not suppression is enabled or disabled
     * @param writableStackTrace boolean; whether or not the stack trace should be writable
     */
    public ValueException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
