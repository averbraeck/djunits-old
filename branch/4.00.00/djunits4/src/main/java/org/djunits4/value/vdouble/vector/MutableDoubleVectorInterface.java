package org.djunits4.value.vdouble.vector;

import org.djunits4.unit.Unit;
import org.djunits4.value.Mutable;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 */
public interface MutableDoubleVectorInterface<U extends Unit<U>> extends DoubleVectorInterface<U>, Mutable
{
    /**
     * return an immutable version of this vector.
     * @return an immutable version of this vector
     */
    DoubleVectorInterface<U> immutable();

}
