package org.djunits4.value.vfloat.matrix.base;

import org.djunits4.unit.Unit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.base.Matrix;
import org.djunits4.value.base.Scalar;
import org.djunits4.value.vfloat.vector.base.FloatVectorInterface;

/**
 * Interface for the FloatMatrix classes, specifically defining the methods that deal with float values.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit
 * @param <S> the generic scalar type belonging to U
 * @param <V> the vector type belonging to the matrix type
 * @param <M> the generic matrix type
 */
public interface FloatMatrixInterface<U extends Unit<U>, S extends Scalar<U, S>, V extends FloatVectorInterface<U, S, V>,
        M extends FloatMatrixInterface<U, S, V, M>> extends Matrix<U, S, V, M>
{
    /**
     * Retrieve the value stored at a specified row and column in the standard SI unit.
     * @param row int; row of the value to retrieve
     * @param column int; column of the value to retrieve
     * @return float; value at position row, column in the standard SI unit
     * @throws ValueRuntimeException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column
     *             &gt;= columns())
     */
    float getSI(int row, int column) throws ValueRuntimeException;

    /**
     * Retrieve the value stored at a specified row and column in the original unit.
     * @param row int; row of the value to retrieve
     * @param column int; column of the value to retrieve
     * @return float; value at position row, column in the original unit
     * @throws ValueRuntimeException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column
     *             &gt;= columns())
     */
    float getInUnit(int row, int column) throws ValueRuntimeException;

    /**
     * Retrieve the value stored at a specified row and column converted into a specified unit.
     * @param row int; row of the value to retrieve
     * @param column int; column of the value to retrieve
     * @param targetUnit U; the unit for the result
     * @return float; value at position row, column converted into the specified unit
     * @throws ValueRuntimeException when row or column out of range (row &lt; 0 or row &gt;= rows() or column &lt; 0 or column
     *             &gt;= columns())
     */
    float getInUnit(int row, int column, U targetUnit) throws ValueRuntimeException;

    /**
     * Retrieve a row from the matrix as an array of float.
     * @param row int; row of the values to retrieve
     * @return S[]; the row as a float array
     * @throws ValueRuntimeException in case row is out of bounds
     */
    float[] getRowSI(int row) throws ValueRuntimeException;

    /**
     * Retrieve a column from the matrix as an array of float.
     * @param column int; column of the values to retrieve
     * @return S[]; the column as a float array
     * @throws ValueRuntimeException in case column is out of bounds
     */
    float[] getColumnSI(int column) throws ValueRuntimeException;

    /**
     * Retrieve the main diagonal of the matrix as an array of float.
     * @return V; the main diagonal as a float array
     * @throws ValueRuntimeException in case the matrix is not square
     */
    float[] getDiagonalSI() throws ValueRuntimeException;

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
    float[][] getValuesInUnit(U targetUnit);

    /**
     * Compute the sum of all values of this matrix.
     * @return float; the sum of all values of this matrix
     */
    float zSum();

    /**
     * Compute the determinant of the matrix.
     * @return float; the determinant of the matrix
     * @throws ValueRuntimeException when matrix is neither sparse, nor dense, or not square
     */
    float determinant() throws ValueRuntimeException;
}
