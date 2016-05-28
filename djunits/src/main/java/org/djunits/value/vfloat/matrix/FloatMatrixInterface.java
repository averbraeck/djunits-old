package org.djunits.value.vfloat.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Interface for the Immutable and Mutable FloatMatrix classes.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 6, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 */
public interface FloatMatrixInterface<U extends Unit<U>>
{
    /**
     * Retrieve the number of rows of the matrix.
     * @return int; the number of rows of the matrix
     */
    int rows();

    /**
     * Retrieve the number of columns of the matrix.
     * @return int; the number of columns of the matrix
     */
    int columns();

    /**
     * Count the number of cells that have a non-zero value (ignores tolerance).
     * @return int; the number of cells having non-zero value
     */
    int cardinality();

    /**
     * Retrieve the value stored at a specified row and column in the standard SI unit.
     * @param row int; row of the value to retrieve
     * @param column int; column of the value to retrieve
     * @return float; value at position row, column in the standard SI unit
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    float getSI(int row, int column) throws ValueException;

    /**
     * Retrieve the value stored at a specified row and column in the original unit.
     * @param row int; row of the value to retrieve
     * @param column int; column of the value to retrieve
     * @return float; value at position row, column in the original unit
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    float getInUnit(int row, int column) throws ValueException;

    /**
     * Retrieve the value stored at a specified row and column converted into a specified unit.
     * @param row int; row of the value to retrieve
     * @param column int; column of the value to retrieve
     * @param targetUnit U; the unit for the result
     * @return float; value at position row, column converted into the specified unit
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    float getInUnit(int row, int column, U targetUnit) throws ValueException;

    /**
     * Retrieve the value stored at a specified row and column as a FloatScalar.
     * @param row int; row of the value to retrieve
     * @param column int; column of the value to retrieve
     * @return FloatScalar&lt;U&gt;; the strongly typed value of the selected cell
     * @throws ValueException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column &gt;=
     *             columns())
     */
    FloatScalar<U> get(int row, int column) throws ValueException;

    /**
     * Compute the sum of all values of this matrix.
     * @return float; the sum of all values of this matrix
     */
    float zSum();

    /**
     * Compute the determinant of the matrix.
     * @return float; the determinant of the matrix
     * @throws ValueException when matrix is neither sparse, nor dense, or not square
     */
    float determinant() throws ValueException;

    /**
     * Create a mutable version of this FloatMatrix. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MutableFloatMatrix&lt;U&gt;; mutable version of this FloatMatrix
     */
    MutableFloatMatrixInterface<U> mutable();

    /**
     * Create a dense float[][] array filled with the values in the standard SI unit.
     * @return float[][]; array of values in the standard SI unit
     */
    float[][] getValuesSI();

    /**
     * Create a dense float[][] array filled with the values in the original unit.
     * @return float[][]; the values in the original unit
     */
    float[][] getValuesInUnit();

    /**
     * Create a dense float[][] array filled with the values converted into a specified unit.
     * @param targetUnit U; the unit into which the values are converted for use
     * @return float[][]; the values converted into the specified unit
     */
    float[][] getValuesInUnit(final U targetUnit);

    /**
     * @return a String with the Matrix, non-verbose, with the unit attached.
     */
    String toString();

    /**
     * Print this FloatMatrix with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @return String; printable string with the matrix contents expressed in the specified unit
     */
    String toString(final U displayUnit);

    /**
     * Print this FloatMatrix with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the matrix contents
     */
    String toString(final boolean verbose, final boolean withUnit);

    /**
     * Print this FloatMatrix with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the matrix contents
     */
    String toString(final U displayUnit, final boolean verbose, final boolean withUnit);

    /**
     * Create a dense version of this FloatMatrix. <br>
     * @return MutableFloatMatrix&lt;U&gt;; dense version of this FloatMatrix
     */
    FloatMatrixInterface<U> toDense();

    /**
     * Create a sparse version of this FloatMatrix. <br>
     * @return MutableFloatMatrix&lt;U&gt;; sparse version of this FloatMatrix
     */
    FloatMatrixInterface<U> toSparse();
}
