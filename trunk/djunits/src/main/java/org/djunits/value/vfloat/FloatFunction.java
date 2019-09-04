package org.djunits.value.vfloat;

/**
 * Interface that represents a function object: a function that takes a single argument and returns a single value. Based on the
 * parallelcolt FloatFunction interface.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public abstract class FloatFunction
{
    /**
     * Applies a function to an argument.
     * @param argument float; argument passed to the function.
     * @return the result of the function.
     */
    public abstract float apply(float argument);
}
