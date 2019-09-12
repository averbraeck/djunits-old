package org.djunits4.value.vdouble.matrix;

import java.io.Serializable;

import org.djunits4.unit.Unit;
import org.djunits4.value.Relative;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;

/**
 * Relative Immutable typed matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the relative matrix type
 * @param <MR> the mutable relative matrix type
 * @param <S> the relative scalar type
 */
abstract class AbstractDoubleMatrixRel<U extends Unit<U>, R extends AbstractDoubleMatrixRel<U, R, MR, S>,
        MR extends AbstractMutableDoubleMatrixRel<U, R, MR, S>, S extends AbstractDoubleScalarRel<U, S>>
        extends AbstractDoubleMatrix<U, R> implements Relative, Serializable
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable DoubleMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable DoubleMatrix
     * @param unit U; the unit of the new Relative Immutable DoubleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractDoubleMatrixRel(final double[][] values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(unit, DoubleMatrixData.instantiate(ensureRectangularAndNonEmpty(values), unit.getScale(), storageType));
    }

    /**
     * Construct a new Relative Immutable DoubleMatrix.
     * @param values S[][]; the values of the entries in the new Relative Immutable DoubleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractDoubleMatrixRel(final S[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(checkUnit(values), DoubleMatrixData.instantiate(values, storageType));
    }

    /**
     * Construct a new Relative Immutable DoubleMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit U; the unit
     */
    AbstractDoubleMatrixRel(final DoubleMatrixData data, final U unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this DoubleMatrix. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MA; mutable version of this DoubleMatrix
     */
    public MR mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /**
     * Construct a new Relative Immutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd DoubleMatrixData; an internal data object
     * @param unit U; the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract R instantiateType(DoubleMatrixData dmd, U unit);

    /**
     * Construct a new Relative Mutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd DoubleMatrixData; an internal data object
     * @param unit U; the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract MR instantiateMutableType(DoubleMatrixData dmd, U unit);

    /**
     * Construct a new Relative Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the value
     * @param unit U; the unit
     * @return S the Immutable DoubleScalar of the right type
     */
    protected abstract S instantiateScalar(double value, U unit);

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public final S get(final int row, final int column) throws ValueRuntimeException
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
     * @throws ValueRuntimeException in case this matrix or matrix and the operand have a different size
     */
    public final R plus(final R rel) throws ValueRuntimeException
    {
        return instantiateType(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a matrix or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse matrix or matrix, otherwise
     * the result is a dense matrix or matrix.
     * @param rel R; the right operand
     * @return the subtraction of this matrix and the operand
     * @throws ValueRuntimeException in case this matrix or matrix and the operand have a different size
     */
    public final R minus(final R rel) throws ValueRuntimeException
    {
        return instantiateType(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a matrix or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense matrix or matrix, otherwise
     * the result is a sparse matrix or matrix.
     * @param rel R; the right operand
     * @return the multiplication of this matrix and the operand
     * @throws ValueRuntimeException in case this matrix or matrix and the operand have a different size
     */
    public final <TU extends Unit<TU>, TR extends AbstractDoubleMatrixRel<TU, TR, TMR, TS>,
            TMR extends AbstractMutableDoubleMatrixRel<TU, TR, TMR, TS>,
            TS extends AbstractDoubleScalarRel<TU, TS>> SIMatrix times(final AbstractDoubleMatrixRel<TU, TR, TMR, TS> rel)
                    throws ValueRuntimeException
    {
        return (SIMatrix) instantiateType(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a matrix or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense matrix or matrix, otherwise the result
     * is a sparse matrix or matrix.
     * @param rel R; the right operand
     * @return the division of this matrix and the operand
     * @throws ValueRuntimeException in case this matrix or matrix and the operand have a different size
     */
    public final <TU extends Unit<TU>, TR extends AbstractDoubleMatrixRel<TU, TR, TMR, TS>,
            TMR extends AbstractMutableDoubleMatrixRel<TU, TR, TMR, TS>,
            TS extends AbstractDoubleScalarRel<TU, TS>> SIMatrix divide(final AbstractDoubleMatrixRel<TU, TR, TMR, TS> rel)
                    throws ValueRuntimeException
    {
        return (SIMatrix) instantiateType(this.getData().divide(rel.getData()), getUnit());
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a DoubleMatrix, and return the Unit.
     * @param dsArray S[][]; the array to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar type
     * @return the unit of the object
     * @throws ValueRuntimeException when the array is null, has length equal to 0, or has first entry with length equal to 0
     */
    static <U extends Unit<U>, S extends AbstractDoubleScalarRel<U, S>> U checkUnit(final S[][] dsArray)
            throws ValueRuntimeException
    {
        ensureRectangularAndNonEmpty(dsArray);
        return dsArray[0][0].getUnit();
    }

    /**
     * Check that a 2D array of DoubleScalar&lt;?&gt; is rectangular; i.e. all rows have the same length and is non empty.
     * @param values S[][]; the 2D array to check
     * @param <U> the unit
     * @param <S> the scalar type
     * @throws ValueRuntimeException when values is not rectangular, or contains no data
     */
    protected static <U extends Unit<U>, S extends AbstractDoubleScalarRel<U, S>> void ensureRectangularAndNonEmpty(
            final S[][] values) throws ValueRuntimeException
    {
        if (null == values)
        {
            throw new ValueRuntimeException(
                    "Cannot create a DoubleVector or MutableDoubleVector from an empty array of DoubleScalar");
        }
        if (0 == values.length || 0 == values[0].length)
        {
            throw new ValueRuntimeException("Creating DoubleVector or MutableDoubleVector: "
                    + "Cannot determine unit for DoubleMatrix from an empty array of DoubleScalar");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (values[0].length != values[row].length)
            {
                throw new ValueRuntimeException(
                        "Creating DoubleVector or MutableDoubleVector: Lengths of rows are not all the same");
            }
        }
    }

}
