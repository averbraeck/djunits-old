package org.djunits4.value.vfloat.vector;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.function.FunctionsAbsWithRel;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.AbstractFloatScalarAbs;

/**
 * Absolute Immutable typed vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <AU> the absolute unit
 * @param <RU> the relative unit
 * @param <A> the absolute vector type
 * @param <R> the relative vector type
 * @param <MA> the mutable absolute vector type
 * @param <S> the absolute scalar type
 */
abstract class AbstractFloatVectorAbs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
        A extends AbstractFloatVectorAbs<AU, RU, A, R, MA, S>, R extends AbstractFloatVectorRel<RU, R, ?, ?>,
        MA extends AbstractMutableFloatVectorAbs<AU, RU, A, R, MA, S>, S extends AbstractFloatScalarAbs<AU, S, RU, ?>>
        extends AbstractFloatVector<AU, A> implements FunctionsAbsWithRel<AU, RU, A, R>, Absolute, Serializable, Iterable<S>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values float[]; the values of the entries in the new Absolute Immutable FloatVector
     * @param unit AU; the unit of the new Absolute Immutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractFloatVectorAbs(final float[] values, final AU unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(unit, FloatVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Absolute Immutable FloatVector
     * @param unit AU; the unit of the new Absolute Immutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractFloatVectorAbs(final List<Float> values, final AU unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(unit, FloatVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values S[]; the values of the entries in the new Absolute Immutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractFloatVectorAbs(final S[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(checkUnit(values), FloatVectorData.instantiate(values, storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values List&lt;S&gt;; the values of the entries in the new Absolute Immutable FloatVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractFloatVectorAbs(final List<S> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(checkUnit(values), FloatVectorData.instantiateLD(values, storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values SortedMap&lt;Integer, S&gt;; the values of the entries in the new Absolute Sparse Mutable FloatVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractFloatVectorAbs(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(checkUnit(values), FloatVectorData.instantiateMD(values, length, storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Absolute Sparse Mutable FloatVector
     * @param unit AU; the unit of the new Absolute Sparse Mutable FloatVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractFloatVectorAbs(final SortedMap<Integer, Float> values, final AU unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(unit, FloatVectorData.instantiate(values, length, unit.getScale(), storageType));
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param data FloatVectorData; an internal data object
     * @param unit AU; the unit
     */
    AbstractFloatVectorAbs(final FloatVectorData data, final AU unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this FloatVector. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MA; mutable version of this FloatVector
     */
    @Override
    public MA mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /**
     * Construct a new Absolute Immutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd FloatVectorData; an internal data object
     * @param unit AU; the unit
     * @return M the Mutable FloatVector of the right type
     */
    protected abstract A instantiateTypeAbs(FloatVectorData dvd, AU unit);

    /**
     * Construct a new Relative Immutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd FloatVectorData; an internal data object
     * @param unit RU; the unit
     * @return M the Mutable FloatVector of the right type
     */
    protected abstract R instantiateTypeRel(FloatVectorData dvd, RU unit);

    /**
     * Construct a new Absolute Mutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd FloatVectorData; an internal data object
     * @param unit AU; the unit
     * @return M the Mutable FloatVector of the right type
     */
    protected abstract MA instantiateMutableType(FloatVectorData dvd, AU unit);

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value float; the value
     * @param unit AU; the unit
     * @return S the Immutable FloatScalar of the right type
     */
    protected abstract S instantiateScalar(float value, AU unit);

    /** {@inheritDoc} */
    @Override
    public S get(final int index) throws ValueRuntimeException
    {
        return instantiateScalar(getInUnit(index, getUnit()), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final A plus(final R rel) throws ValueRuntimeException
    {
        return instantiateTypeAbs(this.getData().plus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public A minus(final R rel) throws ValueRuntimeException
    {
        return instantiateTypeAbs(this.getData().minus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public R minus(final A abs) throws ValueRuntimeException
    {
        return instantiateTypeRel(this.getData().minus(abs.getData()), getUnit().getRelativeUnit());
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a FloatVector, and return the Unit.
     * @param dsArray S[]; the array to check and get the unit for
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar type
     * @return AU; the unit of the object
     * @throws ValueRuntimeException when the array has length equal to 0
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractFloatScalarAbs<AU, S, RU, ?>> AU checkUnit(final S[] dsArray) throws ValueRuntimeException
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
     * @param <AU> the absolute unit of the scalars in the list
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar in the list
     * @return AU the unit of the object
     * @throws ValueRuntimeException when the array has length equal to 0
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractFloatScalarAbs<AU, S, RU, ?>> AU checkUnit(final List<S> dsList) throws ValueRuntimeException
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
     * @param <AU> the absolute unit of the scalars in the map
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar in the list
     * @return SortedMap&lt;Integer, S&gt;; the provided Map
     * @throws ValueRuntimeException when the Map is null or has size equal to 0
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractFloatScalarAbs<AU, S, RU, ?>> AU checkUnit(final SortedMap<Integer, S> dsMap)
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
