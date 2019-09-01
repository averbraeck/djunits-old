package org.djunits.value;

/**
 * Possible ways to store vectors and matrices, e.g. DENSE or SPARSE.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public enum StorageType
{
    /**
     * Dense storage. Use Dense to store small quantities of values, or values where zero is not common, or larger access times
     * are unacceptable, or memory availability is high.
     */
    DENSE,

    /**
     * Sparse storage. Use Sparse to store large quantities of values when most are zero and larger access times are acceptable
     * and memory availability is low. Changing a zero value to a non-zero value is CPU-time-expensive
     */
    SPARSE;
}
