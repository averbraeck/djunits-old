package org.djunits4.value.base;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.Relative;
import org.djunits4.value.Value;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;

/**
 * Matrix to distinguish a matrix from scalars and matrixs. A possible way to implement this interface is:
 * 
 * <pre>
 * class LengthMatrix implements Matrix&lt;LengthUnit, Length, LengthMatrix&gt;
 * </pre>
 * 
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>. <br>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <U> the unit
 * @param <S> the scalar type belonging to the matrix type
 * @param <V> the corresponding vector type
 * @param <M> the matrix type with the given unit
 */
public interface Matrix<U extends Unit<U>, S extends Scalar<U, S>, V extends Vector<U, S, V>, M extends Matrix<U, S, V, M>>
        extends Value<U, M>
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
    int cols();

    /**
     * Count the number of cells that have a non-zero value.
     * @return int; the number of cells having non-zero value
     */
    int cardinality();

    /**
     * Return the class of the corresponding scalar.
     * @return Class&lt;S&gt;; the class of the corresponding scalar
     */
    Class<S> getScalarClass();

    /**
     * Return the class of the corresponding vector.
     * @return Class&lt;V&gt;; the class of the corresponding vector
     */
    Class<V> getVectorClass();

    /**
     * Retrieve a value from the matrix.
     * @param row int; row of the value to retrieve
     * @param column int; column of the value to retrieve
     * @return S; the value as a Scalar
     * @throws ValueRuntimeException in case row or column is out of bounds
     */
    S get(int row, int column) throws ValueRuntimeException;

    /**
     * Return the vector as a 2D-array of scalars.
     * @return S[][]; the vector as a 2D-array of scalars
     */
    S[][] getScalars();

    /**
     * Retrieve a row from the matrix as a vector.
     * @param row int; row of the values to retrieve
     * @return V; the row as a Vector
     * @throws ValueRuntimeException in case row is out of bounds
     */
    V getRow(int row) throws ValueRuntimeException;

    /**
     * Retrieve a column from the matrix as a vector.
     * @param column int; column of the values to retrieve
     * @return V; the column as a Vector
     * @throws ValueRuntimeException in case column is out of bounds
     */
    V getColumn(int column) throws ValueRuntimeException;

    /**
     * Retrieve the main diagonal of the matrix as a vector.
     * @return V; the main diagonal as a Vector
     * @throws ValueRuntimeException in case the matrix is not square
     */
    V getDiagonal() throws ValueRuntimeException;

    /**
     * Retrieve a row from the matrix as an array of scalars.
     * @param row int; row of the values to retrieve
     * @return S[]; the row as a Scalar array
     * @throws ValueRuntimeException in case row is out of bounds
     */
    S[] getRowScalars(int row) throws ValueRuntimeException;

    /**
     * Retrieve a column from the matrix as an array of scalars.
     * @param column int; column of the values to retrieve
     * @return S[]; the column as a Scalar array
     * @throws ValueRuntimeException in case column is out of bounds
     */
    S[] getColumnScalars(int column) throws ValueRuntimeException;

    /**
     * Retrieve the main diagonal of the matrix as an array of scalars.
     * @return V; the main diagonal as a Scalar array
     * @throws ValueRuntimeException in case the matrix is not square
     */
    S[] getDiagonalScalars() throws ValueRuntimeException;

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored matrix.
     * @return StorageType; the storage type (DENSE, SPARSE, etc.) for the stored matrix
     */
    StorageType getStorageType();

    /**
     * Create and return a sparse version of this matrix. When the matrix data was already sparse, the current version is
     * returned and no copy will be made of the data.
     * @return V; a sparse version of this matrix
     */
    M toSparse();

    /**
     * Create and return a dense version of this matrix. When the matrix data was already dense, the current version is returned
     * and no copy will be made of the data.
     * @return V; a dense version of this matrix
     */
    M toDense();

    /**
     * Turn the immutable flag on for this matrix.
     * @return V; the matrix with a raised immutable flag
     */
    M immutable();

    /**
     * Turn the immutable flag off for this matrix.
     * @return V; the matrix with a cleared immutable flag
     */
    M mutable();

    /**
     * Methods for Relative Matrix. A possible way to implement this interface is:
     * 
     * <pre>
     *   class AreaMatrix implements Matrix.Rel&lt;AreaUnit, Area, AreaMatrix&gt;
     * </pre>
     * 
     * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved.
     * <br>
     * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>. <br>
     * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
     * @param <U> the unit
     * @param <S> the scalar type belonging to the matrix type
     * @param <V> the corresponding vector type
     * @param <RM> the relative matrix type with this unit
     */
    public static interface Rel<U extends Unit<U>, S extends Scalar<U, S>, V extends Vector<U, S, V>,
            RM extends Matrix.Rel<U, S, V, RM>> extends Matrix<U, S, V, RM>, Relative
    {
        /**
         * Add a relative matrix to this relative mutable matrix. A new matrix is returned. When the matrix itself needs to be
         * changed, use the increaseBy(V) method instead. The addition is done value by value and the result is stored in a new
         * matrix. If both operands are sparse, the result is a sparse matrix, otherwise the result is a dense matrix.
         * @param increment RV; the relative matrix (mutable or immutable, sparse or dense) to add
         * @return RMV; the sum of this matrix and the operand as a new relative, mutable matrix
         * @throws ValueRuntimeException in case this matrix and the operand have a different size
         */
        RM plus(RM increment) throws ValueRuntimeException;

        /**
         * Subtract a relative matrix from this relative mutable matrix. A new matrix is returned. When the matrix itself needs
         * to be changed, use the decreaseBy(V) method instead. The subtraction is done value by value and the result is stored
         * in a new matrix. If both operands are sparse, the result is a sparse matrix, otherwise the result is a dense matrix.
         * @param decrement RV; the value to subtract
         * @return RMV; the difference of this matrix and the operand as a new relative, mutable matrix
         * @throws ValueRuntimeException in case this matrix and the operand have a different size
         */
        RM minus(RM decrement) throws ValueRuntimeException;

        /**
         * Multiply all values of this matrix by the multiplier. This only works if the matrix is mutable.
         * @param multiplier double; the factor by which to multiply all values
         * @return V; this modified matrix
         * @throws ValueRuntimeException in case the matrix is immutable
         */
        RM multiplyBy(double multiplier);

        /**
         * Divide all values of this matrix by the divisor. This only works if the matrix is mutable.
         * @param divisor double; the value by which to divide all values
         * @return V; this modified matrix
         * @throws ValueRuntimeException in case the matrix is immutable
         */
        RM divideBy(double divisor);
    }

    /**
     * Additional methods for Relative Matrix that has a corresponding Absolute Matrix. An example is the relative matrix Length
     * that has a corresponding absolute matrix Position. A possible way to implement this interface is:
     * 
     * <pre>
     * class LengthMatrix implements Matrix.RelWithAbs&lt;
     *     PositionUnit, Position, PositionMatrix, LengthUnit, Length, LengthMatrix&gt;
     * </pre>
     * 
     * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved.
     * <br>
     * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>. <br>
     * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
     * @param <AU> the absolute unit belonging to the relative unit
     * @param <A> the absolute scalar type belonging to the absolute matrix type
     * @param <AV> the corresponding absolute vector type
     * @param <AM> the absolute matrix type
     * @param <RU> the relative unit belonging to the absolute unit
     * @param <R> the relative scalar type belonging to the relative matrix type
     * @param <RV> the corresponding relative vector type
     * @param <RM> the relative matrix type with this unit
     */
    public static interface RelWithAbs<AU extends AbsoluteLinearUnit<AU, RU>, A extends Scalar<AU, A>,
            AV extends Vector.Abs<AU, A, AV, RU, R, RV>, AM extends Matrix.Abs<AU, A, AV, AM, RU, R, RV, RM>,
            RU extends Unit<RU>, R extends Scalar<RU, R>, RV extends Vector.RelWithAbs<AU, A, AV, RU, R, RV>,
            RM extends Matrix.RelWithAbs<AU, A, AV, AM, RU, R, RV, RM>> extends Rel<RU, R, RV, RM>
    {
        /**
         * Add an absolute matrix to this relative matrix. A new matrix is returned. When the matrix itself needs to be changed,
         * use the increaseBy(V) method instead. The addition is done value by value and the result is stored in a new matrix.
         * If both operands are sparse, the result is a sparse matrix, otherwise the result is a dense matrix.
         * @param increment AV; the absolute matrix (mutable or immutable, sparse or dense) to add to this relative matrix
         * @return AMV; the sum of this matrix and the operand as a new absolute, mutable matrix
         * @throws ValueRuntimeException in case this matrix and the operand have a different size
         */
        AM plus(AM increment);
    }

    /**
     * Methods for Absolute Matrix. An example is the absolute matrix Position that has a corresponding relative matrix Length.
     * A possible way to implement this interface is:
     * 
     * <pre>
     * class PositionMatrix implements Matrix.Abs&lt;
     *     PositionUnit, Position, PositionMatrix, LengthUnit, Length, LengthMatrix&gt;
     * </pre>
     * 
     * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved.
     * <br>
     * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>. <br>
     * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
     * @param <AU> the absolute unit belonging to the relative unit
     * @param <A> the absolute scalar type belonging to the absolute matrix type
     * @param <AV> the corresponding absolute vector type
     * @param <AM> the absolute matrix type
     * @param <RU> the relative unit belonging to the absolute unit
     * @param <R> the relative scalar type belonging to the relative matrix type
     * @param <RV> the corresponding relative vector type
     * @param <RM> the relative matrix type with this unit
     */
    public static interface Abs<AU extends AbsoluteLinearUnit<AU, RU>, A extends Scalar<AU, A>,
            AV extends Vector.Abs<AU, A, AV, RU, R, RV>, AM extends Matrix.Abs<AU, A, AV, AM, RU, R, RV, RM>,
            RU extends Unit<RU>, R extends Scalar<RU, R>, RV extends Vector.RelWithAbs<AU, A, AV, RU, R, RV>,
            RM extends Matrix.RelWithAbs<AU, A, AV, AM, RU, R, RV, RM>> extends Matrix<AU, A, AV, AM>, Absolute
    {
        /**
         * Add a relative matrix to this absolute matrix. A new matrix is returned. When the matrix itself needs to be changed,
         * use the increaseBy(V) method instead. The addition is done value by value and the result is stored in a new matrix.
         * If both operands are sparse, the result is a sparse matrix, otherwise the result is a dense matrix.
         * @param increment RV; the relative matrix (mutable or immutable, sparse or dense) to add to this absolute matrix
         * @return AIV; the sum of this value and the operand as a new absolute, immutable matrix
         * @throws ValueRuntimeException in case this matrix and the operand have a different size
         */
        AM plus(RM increment) throws ValueRuntimeException;

        /**
         * Subtract a relative matrix from this absolute matrix. A new matrix is returned. When the matrix itself needs to be
         * changed, use the decreaseBy(V) method instead. The subtraction is done value by value and the result is stored in a
         * new matrix. If both operands are sparse, the result is a sparse matrix, otherwise the result is a dense matrix.
         * @param decrement RV; the relative matrix (mutable or immutable, sparse or dense) to subtract from this absolute
         *            matrix
         * @return AIV; the difference of this value and the operand as a new absolute, immutable matrix
         * @throws ValueRuntimeException in case this matrix and the operand have a different size
         */
        AM minus(RM decrement) throws ValueRuntimeException;

        /**
         * Subtract an absolute matrix from this absolute matrix.A new matrix is returned. When the matrix itself needs to be
         * changed, use the decreaseBy(V) method instead. The subtraction is done value by value and the result is stored in a
         * new matrix. If both operands are sparse, the result is a sparse matrix, otherwise the result is a dense matrix.
         * @param decrement AV; the absolute matrix (mutable or immutable, sparse or dense) to subtract from this absolute
         *            matrix
         * @return RIV; the difference of this value and the operand as a new relative, immutable matrix
         * @throws ValueRuntimeException in case this matrix and the operand have a different size
         */
        RM minus(AM decrement) throws ValueRuntimeException;
    }
}
