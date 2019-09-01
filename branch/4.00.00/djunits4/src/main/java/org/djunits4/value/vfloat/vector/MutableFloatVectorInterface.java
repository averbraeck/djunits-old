package org.djunits4.value.vfloat.vector;

import org.djunits4.unit.Unit;
import org.djunits4.value.Mutable;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 16, 2016 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 */
public interface MutableFloatVectorInterface<U extends Unit<U>> extends FloatVectorInterface<U>, Mutable
{
    /**
     * return an immutable version of this vector.
     * @return an immutable version of this vector
     */
    FloatVectorInterface<U> immutable();

}
