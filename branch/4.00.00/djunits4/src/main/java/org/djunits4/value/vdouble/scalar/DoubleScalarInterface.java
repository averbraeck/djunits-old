package org.djunits4.value.vdouble.scalar;

/**
 * Double scalar functions.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public interface DoubleScalarInterface
{
    /**
     * Retrieve the value in the underlying SI unit.
     * @return double
     */
    double getSI();

    /**
     * Retrieve the value in the original unit.
     * @return double
     */
    double getInUnit();

}
