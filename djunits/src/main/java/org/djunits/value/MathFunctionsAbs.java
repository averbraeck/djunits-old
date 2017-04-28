package org.djunits.value;

import java.io.Serializable;

/**
 * Interface to force a limited number of functions of Math to be implemented for absolute values. Note: a lot of standard Math
 * functions are <i>not</i> implemented, as they don't make sense with the units. E.g., a cubic root of a Volume should give a
 * Length, and not another volume... Trigoniometric functions should not give back the same unit either. The abs() function is
 * not included here, as abs() only makes sense for relative vales. What is the absolute value of 14 January 2016? Therefore the
 * functions that the interface forces to implement is rather limited, and certainly not the entire range of java.lang.Math
 * functions.
 * <p>
 * Copyright (c) 2015-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <T> the type of the value that the functions operate on
 */
public interface MathFunctionsAbs<T> extends Serializable
{
    /**
     * Set the value(s) to the smallest (closest to negative infinity) value(s) that are greater than or equal to the argument
     * and equal to a mathematical integer.
     * @return T; the modified T
     */
    T ceil();

    /**
     * Set the value(s) to the largest (closest to positive infinity) value(s) that are less than or equal to the argument and
     * equal to a mathematical integer.
     * @return T; the modified T
     */
    T floor();

    /**
     * Set the value(s) to the value(s) that are closest in value to the argument and equal to a mathematical integer.
     * @return T; the modified T
     */
    T rint();

    /**
     * Set the value(s) to the closest long to the argument with ties rounding up.
     * @return T; the modified T
     */
    T round();
}
