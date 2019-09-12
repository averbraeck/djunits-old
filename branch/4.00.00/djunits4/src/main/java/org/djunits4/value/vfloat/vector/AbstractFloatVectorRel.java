package org.djunits4.value.vfloat.vector;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;

import org.djunits4.unit.Unit;
import org.djunits4.value.Relative;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.AbstractFloatScalarRel;

/**
 * Relative Immutable typed vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the relative vector type
 * @param <MR> the mutable relative vector type
 * @param <S> the relative scalar type
 */
abstract class AbstractFloatVectorRel<U extends Unit<U>, R extends AbstractFloatVectorRel<U, R, MR, S>,
        MR extends AbstractMutableFloatVectorRel<U, R, MR, S>, S extends AbstractFloatScalarRel<U, S>>
        extends AbstractFloatVector<U, R> implements Relative, Serializable, Iterable<S>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatVector
     * @param unit U; the unit of the new Relative Immutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractFloatVectorRel(final float[] values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(unit, FloatVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable FloatVector
     * @param unit U; the unit of the new Relative Immutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractFloatVectorRel(final List<Float> values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(unit, FloatVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values S[]; the values of the entries in the new Relative Immutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractFloatVectorRel(final S[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(checkUnit(values), FloatVectorData.instantiate(values, storageType));
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values List&lt;S&gt;; the values of the entries in the new Relative Immutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractFloatVectorRel(final List<S> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(checkUnit(values), FloatVectorData.instantiateLD(values, storageType));
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values SortedMap&lt;Integer, S&gt;; the values of the entries in the new Relative Sparse Mutable FloatVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractFloatVectorRel(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(checkUnit(values), FloatVectorData.instantiateMD(values, length, storageType));
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable FloatVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractFloatVectorRel(final SortedMap<Integer, Float> values, final U unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(unit, FloatVectorData.instantiate(values, length, unit.getScale(), storageType));
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param data FloatVectorData; an internal data object
     * @param unit U; the unit
     */
    AbstractFloatVectorRel(final FloatVectorData data, final U unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this FloatVector. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MR; mutable version of this FloatVector
     */
    @Override
    public MR mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /**
     * Construct a new Relative Immutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd FloatVectorData; an internal data object
     * @param unit U; the unit
     * @return R the FloatVector of the right type
     */
    protected abstract R instantiateType(FloatVectorData dvd, U unit);

    /**
     * Construct a new Relative Mutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd FloatVectorData; an internal data object
     * @param unit U; the unit
     * @return MR the Mutable FloatVector of the right type
     */
    protected abstract MR instantiateMutableType(FloatVectorData dvd, U unit);

    /**
     * Construct a new Relative Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value float; the value
     * @param unit U; the unit
     * @return S the Immutable FloatScalar of the right type
     */
    protected abstract S instantiateScalar(float value, U unit);

    /** {@inheritDoc} */
    @Override
    public S get(final int index) throws ValueRuntimeException
    {
        return instantiateScalar(getInUnit(index, getUnit()), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel R; the right operand
     * @return R; the addition of this vector and the operand
     * @throws ValueRuntimeException in case this vector or matrix and the operand have a different size
     */
    public final R plus(final R rel) throws ValueRuntimeException
    {
        return instantiateType(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel R; the right operand
     * @return R; the subtraction of this vector and the operand
     * @throws ValueRuntimeException in case this vector or matrix and the operand have a different size
     */
    public final R minus(final R rel) throws ValueRuntimeException
    {
        return instantiateType(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel R; the right operand
     * @return R; the multiplication of this vector and the operand
     * @throws ValueRuntimeException in case this vector or matrix and the operand have a different size
     */
    public final R times(final R rel) throws ValueRuntimeException
    {
        return instantiateType(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel R; the right operand
     * @return R; the division of this vector and the operand
     * @throws ValueRuntimeException in case this vector or matrix and the operand have a different size
     */
    public final R divide(final R rel) throws ValueRuntimeException
    {
        return instantiateType(this.getData().divide(rel.getData()), getUnit());
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a FloatVector, and return the Unit.
     * @param dsArray AbstractFloatScalarRel&lt;U,S&gt;[]; the array to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar type
     * @return U; the unit of the object
     * @throws ValueRuntimeException when the array has length equal to 0
     */
    static <U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>> U checkUnit(final AbstractFloatScalarRel<U, S>[] dsArray)
            throws ValueRuntimeException
    {
        if (dsArray != null && dsArray.length > 0)
        {
            return dsArray[0].getUnit();
        }
        throw new ValueRuntimeException("Cannot create a FloatVector or MutableFloatVector from a null or empty array of FloatScalar");
    }

    /**
     * Check that a provided list can be used to create some descendant of a FloatVector, and return the Unit.
     * @param dsList List&lt;S&gt;; the list to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar in the list
     * @return U; the unit of the object
     * @throws ValueRuntimeException when the array has length equal to 0
     */
    static <U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>> U checkUnit(final List<S> dsList) throws ValueRuntimeException
    {
        if (dsList != null && dsList.size() > 0)
        {
            return dsList.get(0).getUnit();
        }
        throw new ValueRuntimeException("Cannot create a FloatVector or MutableFloatVector from a null or empty list of FloatScalar");
    }

    /**
     * Check that a provided Map can be used to create some descendant of a FloatVector.
     * @param dsMap SortedMap&lt;Integer,S&gt;; the provided map
     * @param <U> Unit; the unit of the FloatScalar list
     * @param <S> the scalar in the list
     * @return Map&lt;Integer, S&gt;; the provided Map
     * @throws ValueRuntimeException when the Map is null or has size equal to 0
     */
    static <U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>> U checkUnit(final SortedMap<Integer, S> dsMap)
            throws ValueRuntimeException
    {
        if (dsMap != null && dsMap.size() > 0)
        {
            return dsMap.get(dsMap.firstKey()).getUnit();
        }
        throw new ValueRuntimeException("Cannot create a FloatVector or MutableFloatVector from a null or empty Map of FloatScalar");
    }

    /* ============================================================================================ */
    /* =============================== ITERATOR METHODS AND CLASS ================================= */
    /* ============================================================================================ */

    /**
     * Create and return an iterator over the scalars in this vector in proper sequence.
     * @return Iterator&lt;S&gt;; an iterator over the scalars in this vector in proper sequence
     */
    @Override
    public Iterator<S> iterator()
    {
        return new Itr();
    }

    /**
     * The iterator class is loosely based in AbstractList.Itr. It does not throw a ConcurrentModificationException, because the
     * size of the vector does not change. Normal (non-mutable) vectors cannot change their size, nor their content. The only
     * thing for the MutableVector that can change is its content, not its length.
     */
    protected class Itr implements Iterator<S>
    {
        /** index of next element to return. */
        private int cursor = 0;

        @Override
        public boolean hasNext()
        {
            return this.cursor != size();
        }

        /** {@inheritDoc} */
        @Override
        public S next()
        {
            if (this.cursor >= size())
            {
                throw new NoSuchElementException();
            }
            try
            {
                int i = this.cursor;
                S next = get(i);
                this.cursor = i + 1;
                return next;
            }
            catch (ValueRuntimeException exception)
            {
                throw new RuntimeException(exception);
            }
        }

        /** {@inheritDoc} */
        @Override
        public void remove()
        {
            throw new RuntimeException("Remove function cannot be applied on fixed-size DJUNITS Vector");
        }
    }

}
