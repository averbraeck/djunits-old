package org.djunits.value.vdouble.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Relative Mutable typed Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the matrix type
 * @param <MR> the mutable matrix type
 * @param <S> the scalar type
 */
abstract class MutableTypedDoubleMatrixRel<U extends Unit<U>, R extends TypedDoubleMatrixRel<U, R, MR, S>, MR extends MutableTypedDoubleMatrixRel<U, R, MR, S>, S extends DoubleScalar.Rel<U>>
        extends MutableDoubleMatrix.Rel<U>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param values double[]; the values of the entries in the new Relative Mutable DoubleMatrix
     * @param unit U; the unit of the new Relative Mutable DoubleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedDoubleMatrixRel(final double[][] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable DoubleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedDoubleMatrixRel(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableTypedDoubleMatrixRel(final DoubleMatrixData data, final U unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MR mutable()
    {
        setCopyOnWrite(true);
        final MR result = instantiateMutableType(getData(), getUnit());
        result.setCopyOnWrite(true);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public R immutable()
    {
        setCopyOnWrite(true);
        return instantiateType(getData(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR toDense()
    {
        return this.data.isDense() ? (MR) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR toSparse()
    {
        return this.data.isSparse() ? (MR) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Construct a new Relative Immutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract R instantiateType(final DoubleMatrixData dmd, final U unit);

    /**
     * Construct a new Relative Mutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd an internal data object
     * @param unit the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract MR instantiateMutableType(final DoubleMatrixData dmd, final U unit);

    /** {@inheritDoc} */
    @Override
    public abstract S get(final int row, final int column) throws ValueException;

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MR copy()
    {
        return mutable();
    }

    /**
     * Add a Relative value to this Relative value for a matrix or matrix. The addition is done value by value and the result is
     * stored in a new Relative value. If both operands are sparse, the result is a sparse matrix or matrix, otherwise the
     * result is a dense matrix or matrix.
     * @param rel the right operand
     * @return the addition of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    @SuppressWarnings("unchecked")
    public final R plus(final R rel) throws ValueException
    {
        return (R) super.plus(rel);
    }

    /**
     * Subtract a Relative value from this Relative value for a matrix or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse matrix or matrix, otherwise
     * the result is a dense matrix or matrix.
     * @param rel the right operand
     * @return the subtraction of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    @SuppressWarnings("unchecked")
    public final R minus(final R rel) throws ValueException
    {
        return (R) super.minus(rel);
    }

    /**
     * Multiply a Relative value with this Relative value for a matrix or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense matrix or matrix, otherwise
     * the result is a sparse matrix or matrix.
     * @param rel the right operand
     * @return the multiplication of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    @SuppressWarnings("unchecked")
    public final R times(final R rel) throws ValueException
    {
        return (R) super.times(rel);
    }

    /**
     * Divide this Relative value by a Relative value for a matrix or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense matrix or matrix, otherwise the result
     * is a sparse matrix or matrix.
     * @param rel the right operand
     * @return the division of this matrix and the operand
     * @throws ValueException in case this matrix or matrix and the operand have a different size
     */
    @SuppressWarnings("unchecked")
    public final R divide(final R rel) throws ValueException
    {
        return (R) super.divide(rel);
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR abs()
    {
        return (MR) super.abs();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR ceil()
    {
        return (MR) super.ceil();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR floor()
    {
        return (MR) super.floor();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR rint()
    {
        return (MR) super.rint();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR round()
    {
        return (MR) super.round();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR multiplyBy(final double constant)
    {
        return (MR) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR divideBy(final double constant)
    {
        return (MR) super.divideBy(constant);
    }

}
