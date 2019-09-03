package org.djunits4.value;

/**
 * Exception that is thrown for bad indices, or non-rectangular arrays, incompatible arrays or matrices, or empty arrays
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class ValueException extends Exception
{
    /**  */
    private static final long serialVersionUID = 20150626L;

    /**
     * Construct a new ValueException using default values for all fields.
     */
    public ValueException()
    {
        super();
    }

    /**
     * Construct a new ValueException with specified description.
     * @param message String; description of the problem
     */
    public ValueException(final String message)
    {
        super(message);
    }

    /**
     * Construct a new ValueException with specified cause.
     * @param cause Throwable; the cause of this ValueException
     */
    public ValueException(final Throwable cause)
    {
        super(cause);
    }

    /**
     * Construct a new ValueException with specified description and cause.
     * @param message String; description of the problem
     * @param cause Throwable; the cause of this ValueException
     */
    public ValueException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

    /**
     * Construct a new ValueException specifying all fields.
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
