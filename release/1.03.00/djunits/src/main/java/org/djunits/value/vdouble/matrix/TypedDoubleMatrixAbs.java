package org.djunits.value.vdouble.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Absolute Immutable typed matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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
abstract class TypedDoubleMatrixAbs<U extends Unit<U>, A extends TypedDoubleMatrixAbs<U, A, R, MA, S>, R extends TypedDoubleMatrixRel<U, R, ?, ?>, MA extends MutableTypedDoubleMatrixAbs<U, A, R, MA, S>, S extends DoubleScalar.Abs<U>>
        extends DoubleMatrix.Abs<U>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable DoubleMatrix.
     * @param values double[]; the values of the entries in the new Relative Immutable DoubleMatrix
     * @param unit U; the unit of the new Relative Immutable DoubleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    TypedDoubleMatrixAbs(final double[][] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable DoubleMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable DoubleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    TypedDoubleMatrixAbs(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable DoubleMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    TypedDoubleMatrixAbs(final DoubleMatrixData data, final U unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MA mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final A toDense()
    {
        return this.data.isDense() ? (A) this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final A toSparse()
    {
        return this.data.isSparse() ? (A) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /**
     * Construct a new Absolute Immutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract A instantiateTypeAbs(final DoubleMatrixData dmd, final U unit);

    /**
     * Construct a new Relative Immutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract R instantiateTypeRel(final DoubleMatrixData dmd, final U unit);

    /**
     * Construct a new Absolute Mutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract MA instantiateMutableType(final DoubleMatrixData dmd, final U unit);

    /** {@inheritDoc} */
    @Override
    public abstract S get(final int row, final int column) throws ValueException;

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
    public A minus(final R rel) throws ValueException
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
    public R minus(final A abs) throws ValueException
    {
        return instantiateTypeRel(this.getData().minus(abs.getData()), getUnit());
    }
}
