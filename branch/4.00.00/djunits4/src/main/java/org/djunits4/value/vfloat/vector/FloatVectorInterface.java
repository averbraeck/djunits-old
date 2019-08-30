package org.djunits4.value.vfloat.vector;

import org.djunits4.unit.Unit;
import org.djunits4.value.ValueException;

/**
 * Interface for the Immutable and Mutable FloatVector classes.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 6, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 */
public interface FloatVectorInterface<U extends Unit<U>>
{
    /**
     * Retrieve the size of the vector.
     * @return int; the size of the vector
     */
    int size();

    /**
     * Count the number of cells that have a non-zero value (ignores tolerance).
     * @return int; the number of cells having non-zero value
     */
    int cardinality();

    /**
     * Retrieve the value stored at a specified position in the standard SI unit.
     * @param index int; index of the value to retrieve
     * @return float; value at position index in the standard SI unit
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    float getSI(int index) throws ValueException;

    /**
     * Retrieve the value stored at a specified position in the original unit.
     * @param index int; index of the value to retrieve
     * @return float; value at position index in the original unit
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    float getInUnit(int index) throws ValueException;

    /**
     * Retrieve the value stored at a specified position converted into a specified unit.
     * @param index int; index of the value to retrieve
     * @param targetUnit U; the unit for the result
     * @return float; value at position index converted into the specified unit
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    float getInUnit(int index, U targetUnit) throws ValueException;

    /**
     * return a mutable version of this vector.
     * @return a mutable version of this vector
     */
    MutableFloatVectorInterface<U> mutable();

    /**
     * return a sparse version of this vector.
     * @return a sparse version of this vector
     */
    FloatVectorInterface<U> toSparse();

    /**
     * return a dense version of this vector.
     * @return a dense version of this vector
     */
    FloatVectorInterface<U> toDense();

    /**
     * Compute the sum of all values of this vector.
     * @return float; the sum of all values of this vector
     */
    float zSum();

    /**
     * Create a float[] array filled with the values in the standard SI unit.
     * @return float[]; array of values in the standard SI unit
     */
    float[] getValuesSI();

    /**
     * Create a float[] array filled with the values in the original unit.
     * @return float[]; the values in the original unit
     */
    float[] getValuesInUnit();

    /**
     * Create a float[] array filled with the values converted into a specified unit.
     * @param targetUnit U; the unit into which the values are converted for use
     * @return float[]; the values converted into the specified unit
     */
    float[] getValuesInUnit(U targetUnit);

    /**
     * @return a String with the Vector, non-verbose, with the unit attached.
     */
    @Override
    String toString();

    /**
     * Print this FloatVector with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @return String; printable string with the vector contents expressed in the specified unit
     */
    String toString(U displayUnit);

    /**
     * Print this FloatVector with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the vector contents
     */
    String toString(boolean verbose, boolean withUnit);

    /**
     * Print this FloatVector with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the vector contents
     */
    String toString(U displayUnit, boolean verbose, boolean withUnit);

}
