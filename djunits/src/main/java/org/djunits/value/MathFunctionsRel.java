package org.djunits.value;

/**
 * Interface to force a limited number of functions of Math to be implemented for relative values, in addition to those already
 * implemented for absolute values.
 * <p>
 * Copyright (c) 2015-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-10-04 20:48:33 +0200 (Sun, 04 Oct 2015) $, @version $Revision: 87 $, by $Author: averbraeck $, initial
 * version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
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
