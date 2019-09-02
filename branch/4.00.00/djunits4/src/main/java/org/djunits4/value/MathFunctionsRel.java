package org.djunits4.value;

/**
 * Interface to force a limited number of functions of Math to be implemented for relative values, in addition to those already
 * implemented for absolute values.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-10-04 20:48:33 +0200 (Sun, 04 Oct 2015) $, @version $Revision: 87 $, by $Author: averbraeck $, initial
 * version 26 jun, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <T> the type of the value that the functions operate on
 */
public interface MathFunctionsRel<T> extends MathFunctionsAbs<T>
{
    /**
     * Set the value(s) to their absolute value.
     * @return T; the modified T
     */
    T abs();

    /**
     * Set the value(s) to the minus value.
     * @return T; the modified T
     */
    T neg();
    
}
