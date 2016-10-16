package org.djunits.value.vfloat.matrix;

import java.io.Serializable;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.AbstractFloatScalarAbs;

/**
 * Absolute Immutable typed matrix.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <A> the absolute matrix type
 * @param <R> the relative matrix type
 * @param <MA> the mutable absolute matrix type
 * @param <S> the absolute scalar type
 */
abstract class AbstractFloatMatrixAbs<U extends Unit<U>, A extends AbstractFloatMatrixAbs<U, A, R, MA, S>, 
        R extends AbstractFloatMatrixRel<U, R, ?, ?>, MA extends AbstractMutableFloatMatrixAbs<U, A, R, MA, S>, 
        S extends AbstractFloatScalarAbs<U, S, ?>>
        extends AbstractFloatMatrix<U, A>  implements FloatMatrixInterface<U>, Absolute, Serializable
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Absolute Immutable FloatMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Immutable FloatMatrix
     * @param unit U; the unit of the new Absolute Immutable FloatMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractFloatMatrixAbs(final float[][] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(unit, FloatMatrixData.instantiate(ensureRectangularAndNonEmpty(values), unit.getScale(), storageType));

    }

    /**
     * Construct a new Absolute Immutable FloatMatrix.
     * @param values S[][]; the values of the entries in the new Absolute Immutable FloatMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractFloatMatrixAbs(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(checkUnit(values), FloatMatrixData.instantiate(values, storageType));
    }

    /**
     * Construct a new Relative Immutable FloatMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    AbstractFloatMatrixAbs(final FloatMatrixData data, final U unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this FloatMatrix. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MA; mutable version of this FloatMatrix
     */
    public MA mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /**
     * Construct a new Absolute Immutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract A instantiateTypeAbs(final FloatMatrixData dmd, final U unit);

    /**
     * Construct a new Relative Immutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract R instantiateTypeRel(final FloatMatrixData dmd, final U unit);

    /**
     * Construct a new Absolute Mutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract MA instantiateMutableType(final FloatMatrixData dmd, final U unit);

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the value
     * @param unit the unit
     * @return S the Immutable FloatScalar of the right type
     */
    protected abstract S instantiateScalar(final float value, final U unit);

    /**
     * Return the Scalar value at the index position.
     * @param row the row position
     * @param column the column position
     * @return S the scalar
     * @throws ValueException when index out of bounds
     */
    @SuppressWarnings("checkstyle:designforextension")
    public final S get(final int row, final int column) throws ValueException
    {
        checkIndex(row, column);
        return instantiateScalar(getInUnit(row, column, getUnit()), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /**
     * Add a Relative value to this Absolute value for a matrix or matrix. The addition is done value by value and the result is
     * stored in a new Absolute value. If both operands are sparse, the result is a sparse matrix or matrix, otherwise the
     * result is a dense matrix or matrix.
     * @param rel the right operand
     * @return the addition of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    public final A plus(final R rel) throws ValueException
    {
        return instantiateTypeAbs(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Absolute value for a matrix or matrix. The subtraction is done value by value and the
     * result is stored in a new Relative value. If both operands are sparse, the result is a sparse matrix or matrix, otherwise
     * the result is a dense matrix or matrix.
     * @param rel the right operand
     * @return the subtraction of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    public final A minus(final R rel) throws ValueException
    {
        return instantiateTypeAbs(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Subtract an Absolute value from this Relative value for a matrix or matrix. The subtraction is done value by value and
     * the result is stored in a new Relative value. If both operands are sparse, the result is a sparse matrix or matrix,
     * otherwise the result is a dense matrix or matrix.
     * @param abs the right operand
     * @return the subtraction of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    public final R minus(final A abs) throws ValueException
    {
        return instantiateTypeRel(this.getData().minus(abs.getData()), getUnit());
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a FloatMatrix, and return the Unit.
     * @param dsArray the array to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar type
     * @return the unit of the object
     * @throws ValueException when the array is null, has length equal to 0, or has first entry with length equal to 0
     */
    static <U extends Unit<U>, S extends AbstractFloatScalarAbs<U, S, ?>> U checkUnit(final S[][] dsArray) throws ValueException
    {
        ensureRectangularAndNonEmpty(dsArray);
        return dsArray[0][0].getUnit();
    }

    /**
     * Check that a 2D array of FloatScalar&lt;?&gt; is rectangular; i.e. all rows have the same length and is non empty.
     * @param values FloatScalar&lt;?&gt;[][]; the 2D array to check
     * @param <U> the unit
     * @param <S> the scalar type
     * @throws ValueException when values is not rectangular, or contains no data
     */
    protected static <U extends Unit<U>, S extends AbstractFloatScalarAbs<U, S, ?>> void ensureRectangularAndNonEmpty(
            final S[][] values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("Cannot create a FloatVector or MutableFloatVector from an empty array of FloatScalar");
        }
        if (0 == values.length || 0 == values[0].length)
        {
            throw new ValueException("Creating FloatVector or MutableFloatVector: "
                    + "Cannot determine unit for FloatMatrix from an empty array of FloatScalar");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (values[0].length != values[row].length)
            {
                throw new ValueException("Creating FloatVector or MutableFloatVector: Lengths of rows are not all the same");
            }
        }
    }
}
