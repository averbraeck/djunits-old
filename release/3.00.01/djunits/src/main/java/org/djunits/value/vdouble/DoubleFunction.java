package org.djunits.value.vdouble;

/**
 * Interface that represents a function object: a function that takes a single argument and returns a single value. Based on the
 * parallelcolt DoubleFunction interface.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class DoubleFunction
{
    /**
     * Applies a function to an argument.
     * @param argument argument passed to the function.
     * @return the result of the function.
     */
    public abstract double apply(double argument);
}
