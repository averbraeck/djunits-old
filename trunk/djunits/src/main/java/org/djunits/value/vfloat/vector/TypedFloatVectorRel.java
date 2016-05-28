package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Relative Immutable typed vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the relative vector type
 * @param <MR> the mutable relative vector type
 * @param <S> the scalar type
 */
abstract class TypedFloatVectorRel<U extends Unit<U>, R extends TypedFloatVectorRel<U, R, MR, S>, MR extends MutableTypedFloatVectorRel<U, R, MR, S>, S extends FloatScalar.Rel<U>>
        extends FloatVector.Rel<U>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatVector
     * @param unit U; the unit of the new Relative Immutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    TypedFloatVectorRel(final float[] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatVector
     * @param unit U; the unit of the new Relative Immutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    TypedFloatVectorRel(final List<Float> values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    TypedFloatVectorRel(final S[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    TypedFloatVectorRel(final List<S> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable FloatVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    TypedFloatVectorRel(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    TypedFloatVectorRel(final SortedMap<Integer, Float> values, final U unit, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param data an internal data object
     * @param unit the unit
     */
    TypedFloatVectorRel(final FloatVectorData data, final U unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MR mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final R toDense()
    {
        return this.data.isDense() ? (R) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final R toSparse()
    {
        return this.data.isSparse() ? (R) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Construct a new Relative Immutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatVector of the right type
     */
    protected abstract R instantiateType(final FloatVectorData dvd, final U unit);

    /**
     * Construct a new Relative Mutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatVector of the right type
     */
    protected abstract MR instantiateMutableType(final FloatVectorData dvd, final U unit);

    /** {@inheritDoc} */
    @Override
    public abstract S get(final int index) throws ValueException;

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final R plus(final R rel) throws ValueException
    {
        return instantiateType(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final R minus(final R rel) throws ValueException
    {
        return instantiateType(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final R times(final R rel) throws ValueException
    {
        return instantiateType(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final R divide(final R rel) throws ValueException
    {
        return instantiateType(this.getData().divide(rel.getData()), getUnit());
    }

}
