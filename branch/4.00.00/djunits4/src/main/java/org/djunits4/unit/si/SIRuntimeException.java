package org.djunits4.unit.si;

/**
 * Runtime Exceptions in SI package.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-01-18 00:35:01 +0100 (Fri, 18 Jan 2019) $, @version $Revision: 324 $, by $Author: averbraeck $,
 * initial version Jun 18, 2014 <br>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class SIRuntimeException extends RuntimeException
{

    /** */
    private static final long serialVersionUID = 20190821L;

    /**
     * 
     */
    public SIRuntimeException()
    {
        super();
    }

    /**
     * @param message String; String
     * @param cause Throwable; Throwable
     */
    public SIRuntimeException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param message String; String
     */
    public SIRuntimeException(final String message)
    {
        super(message);
    }

    /**
     * @param cause Throwable; Throwable
     */
    public SIRuntimeException(final Throwable cause)
    {
        super(cause);
    }

}
