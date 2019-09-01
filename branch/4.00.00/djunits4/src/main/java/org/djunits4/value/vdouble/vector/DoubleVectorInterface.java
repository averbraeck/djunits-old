package org.djunits4.value.vdouble.vector;

import org.djunits4.unit.Unit;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.AbstractDoubleScalar;

/**
 * Interface for the Immutable and Mutable DoubleVector classes.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 6, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit
 */
public interface DoubleVectorInterface<U extends Unit<U>>
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
     * Retrieve a value from the vector.
     * @param index int; the index to retrieve the value at
     * @return the value as a DoubleScalar
     * @throws ValueException in case index is out of bounds
     */
    AbstractDoubleScalar<U, ?> get(int index) throws ValueException;

    /**
     * Retrieve the value stored at a specified position in the standard SI unit.
     * @param index int; index of the value to retrieve
     * @return double; value at position index in the standard SI unit
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    double getSI(int index) throws ValueException;

    /**
     * Retrieve the value stored at a specified position in the original unit.
     * @param index int; index of the value to retrieve
     * @return double; value at position index in the original unit
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    double getInUnit(int index) throws ValueException;

    /**
     * Retrieve the value stored at a specified position converted into a specified unit.
     * @param index int; index of the value to retrieve
     * @param targetUnit U; the unit for the result
     * @return double; value at position index converted into the specified unit
     * @throws ValueException when index out of range (index &lt; 0 or index &gt;= size())
     */
    double getInUnit(int index, U targetUnit) throws ValueException;

    /**
     * return a mutable version of this vector.
     * @return a mutable version of this vector
     */
    MutableDoubleVectorInterface<U> mutable();

    /**
     * return a sparse version of this vector.
     * @return a sparse version of this vector
     */
    DoubleVectorInterface<U> toSparse();

    /**
     * return a dense version of this vector.
     * @return a dense version of this vector
     */
    DoubleVectorInterface<U> toDense();

    /**
     * Compute the sum of all values of this vector.
     * @return double; the sum of all values of this vector
     */
    double zSum();

    /**
     * Create a double[] array filled with the values in the standard SI unit.
     * @return double[]; array of values in the standard SI unit
     */
    double[] getValuesSI();

    /**
     * Create a double[] array filled with the values in the original unit.
     * @return double[]; the values in the original unit
     */
    double[] getValuesInUnit();

    /**
     * Create a double[] array filled with the values converted into a specified unit.
     * @param targetUnit U; the unit into which the values are converted for use
     * @return double[]; the values converted into the specified unit
     */
    double[] getValuesInUnit(U targetUnit);

    /**
     * @return a String with the Vector, non-verbose, with the unit attached.
     */
    @Override
    String toString();

    /**
     * Print this DoubleVector with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @return String; printable string with the vector contents expressed in the specified unit
     */
    String toString(U displayUnit);

    /**
     * Print this DoubleVector with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the vector contents
     */
    String toString(boolean verbose, boolean withUnit);

    /**
     * Print this DoubleVector with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the vector contents
     */
    String toString(U displayUnit, boolean verbose, boolean withUnit);

}
