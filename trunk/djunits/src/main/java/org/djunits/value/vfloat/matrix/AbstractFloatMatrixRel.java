package org.djunits.value.vfloat.matrix;

import java.io.Serializable;

import org.djunits.unit.Unit;
import org.djunits.value.Relative;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.AbstractFloatScalarRel;

/**
 * Relative Immutable typed matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the relative matrix type
 * @param <MR> the mutable relative matrix type
 * @param <S> the relative scalar type
 */
abstract class AbstractFloatMatrixRel<U extends Unit<U>, R extends AbstractFloatMatrixRel<U, R, MR, S>,
        MR extends AbstractMutableFloatMatrixRel<U, R, MR, S>, S extends AbstractFloatScalarRel<U, S>>
        extends AbstractFloatMatrix<U, R> implements FloatMatrixInterface<U>, Relative, Serializable
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMatrix
     * @param unit U; the unit of the new Relative Immutable FloatMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractFloatMatrixRel(final float[][] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(unit, FloatMatrixData.instantiate(ensureRectangularAndNonEmpty(values), unit.getScale(), storageType));
    }

    /**
     * Construct a new Relative Immutable FloatMatrix.
     * @param values S[][]; the values of the entries in the new Relative Immutable FloatMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractFloatMatrixRel(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(checkUnit(values), FloatMatrixData.instantiate(values, storageType));
    }

    /**
     * Construct a new Relative Immutable FloatMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit U; the unit
     */
    AbstractFloatMatrixRel(final FloatMatrixData data, final U unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this FloatMatrix. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MA; mutable version of this FloatMatrix
     */
    public MR mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /**
     * Construct a new Relative Immutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd FloatMatrixData; an internal data object
     * @param unit U; the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract R instantiateType(FloatMatrixData dmd, U unit);

    /**
     * Construct a new Relative Mutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd FloatMatrixData; an internal data object
     * @param unit U; the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract MR instantiateMutableType(FloatMatrixData dmd, U unit);

    /**
     * Construct a new Relative Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value float; the value
     * @param unit U; the unit
     * @return S the Immutable FloatScalar of the right type
     */
    protected abstract S instantiateScalar(float value, U unit);

    /** {@inheritDoc} */
    @Override
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
     * Add a Relative value to this Relative value for a matrix or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse matrix or matrix, otherwise the
     * result is a dense matrix or matrix.
     * @param rel R; the right operand
     * @return the addition of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    public final R plus(final R rel) throws ValueException
    {
        return instantiateType(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a matrix or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse matrix or matrix, otherwise
     * the result is a dense matrix or matrix.
     * @param rel R; the right operand
     * @return the subtraction of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    public final R minus(final R rel) throws ValueException
    {
        return instantiateType(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a matrix or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense matrix or matrix, otherwise
     * the result is a sparse matrix or matrix.
     * @param rel R; the right operand
     * @return the multiplication of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    public final R times(final R rel) throws ValueException
    {
        return instantiateType(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a matrix or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense matrix or matrix, otherwise the result
     * is a sparse matrix or matrix.
     * @param rel R; the right operand
     * @return the division of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    public final R divide(final R rel) throws ValueException
    {
        return instantiateType(this.getData().divide(rel.getData()), getUnit());
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a FloatMatrix, and return the Unit.
     * @param dsArray S[][]; the array to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar type
     * @return the unit of the object
     * @throws ValueException when the array is null, has length equal to 0, or has first entry with length equal to 0
     */
    static <U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>> U checkUnit(final S[][] dsArray) throws ValueException
    {
        ensureRectangularAndNonEmpty(dsArray);
        return dsArray[0][0].getUnit();
    }

    /**
     * Check that a 2D array of FloatScalar&lt;?&gt; is rectangular; i.e. all rows have the same length and is non empty.
     * @param values S[][]; the 2D array to check
     * @param <U> the unit
     * @param <S> the scalar type
     * @throws ValueException when values is not rectangular, or contains no data
     */
    protected static <U extends Unit<U>,
            S extends AbstractFloatScalarRel<U, S>> void ensureRectangularAndNonEmpty(final S[][] values) throws ValueException
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
