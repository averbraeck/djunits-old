package org.djunits.value.vdouble.vector;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;

import org.djunits.unit.AbsoluteLinearUnit;
import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.FunctionsAbs;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalarAbs;

/**
 * Absolute Immutable typed vector.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <AU> the absolute unit
 * @param <RU> the relative unit
 * @param <A> the absolute vector type
 * @param <R> the relative vector type
 * @param <MA> the mutable absolute vector type
 * @param <S> the absolute scalar type
 */
abstract class AbstractDoubleVectorAbs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
        A extends AbstractDoubleVectorAbs<AU, RU, A, R, MA, S>, R extends AbstractDoubleVectorRel<RU, R, ?, ?>,
        MA extends AbstractMutableDoubleVectorAbs<AU, RU, A, R, MA, S>, S extends AbstractDoubleScalarAbs<AU, S, RU, ?>>
        extends AbstractDoubleVector<AU, A> implements FunctionsAbs<AU, RU, A, R>, Absolute, Serializable, Iterable<S>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values double[]; the values of the entries in the new Absolute Immutable DoubleVector
     * @param unit AU; the unit of the new Absolute Immutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractDoubleVectorAbs(final double[] values, final AU unit, final StorageType storageType) throws ValueException
    {
        super(unit, DoubleVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Absolute Immutable DoubleVector
     * @param unit AU; the unit of the new Absolute Immutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractDoubleVectorAbs(final List<Double> values, final AU unit, final StorageType storageType) throws ValueException
    {
        super(unit, DoubleVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values S[]; the values of the entries in the new Absolute Immutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractDoubleVectorAbs(final S[] values, final StorageType storageType) throws ValueException
    {
        super(checkUnit(values), DoubleVectorData.instantiate(values, storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values List&lt;S&gt;; the values of the entries in the new Absolute Immutable DoubleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractDoubleVectorAbs(final List<S> values, final StorageType storageType) throws ValueException
    {
        super(checkUnit(values), DoubleVectorData.instantiateLD(values, storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values SortedMap&lt;Integer, S&gt;; the values of the entries in the new Absolute Sparse Mutable DoubleVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractDoubleVectorAbs(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(checkUnit(values), DoubleVectorData.instantiateMD(values, length, storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Absolute Sparse Mutable DoubleVector
     * @param unit AU; the unit of the new Absolute Sparse Mutable DoubleVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractDoubleVectorAbs(final SortedMap<Integer, Double> values, final AU unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(unit, DoubleVectorData.instantiate(values, length, unit.getScale(), storageType));
    }

    /**
     * Construct a new Relative Immutable DoubleVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit AU; the unit
     */
    AbstractDoubleVectorAbs(final DoubleVectorData data, final AU unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this DoubleVector. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MA; mutable version of this DoubleVector
     */
    @Override
    public MA mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /**
     * Construct a new Absolute Immutable DoubleVector of the right type. Each extending class must implement this method.
     * @param dvd DoubleVectorData; an internal data object
     * @param unit AU; the unit
     * @return M the Mutable DoubleVector of the right type
     */
    protected abstract A instantiateTypeAbs(DoubleVectorData dvd, AU unit);

    /**
     * Construct a new Relative Immutable DoubleVector of the right type. Each extending class must implement this method.
     * @param dvd DoubleVectorData; an internal data object
     * @param unit RU; the unit
     * @return M the Mutable DoubleVector of the right type
     */
    protected abstract R instantiateTypeRel(DoubleVectorData dvd, RU unit);

    /**
     * Construct a new Absolute Mutable DoubleVector of the right type. Each extending class must implement this method.
     * @param dvd DoubleVectorData; an internal data object
     * @param unit AU; the unit
     * @return M the Mutable DoubleVector of the right type
     */
    protected abstract MA instantiateMutableType(DoubleVectorData dvd, AU unit);

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the value
     * @param unit AU; the unit
     * @return S the Immutable DoubleScalar of the right type
     */
    protected abstract S instantiateScalar(double value, AU unit);

    /** {@inheritDoc} */
    @Override
    public final S get(final int index) throws ValueException
    {
        return instantiateScalar(getInUnit(index, getUnit()), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final A plus(final R rel) throws ValueException
    {
        return instantiateTypeAbs(this.getData().plus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public A minus(final R rel) throws ValueException
    {
        return instantiateTypeAbs(this.getData().minus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public R minus(final A abs) throws ValueException
    {
        return instantiateTypeRel(this.getData().minus(abs.getData()), getUnit().getRelativeUnit());
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a DoubleVector, and return the Unit.
     * @param dsArray S[]; the array to check and get the unit for
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar type
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractDoubleScalarAbs<AU, S, RU, ?>> AU checkUnit(final S[] dsArray) throws ValueException
    {
        if (dsArray != null && dsArray.length > 0)
        {
            return dsArray[0].getUnit();
        }
        throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from a null or empty array of DoubleScalar");
    }

    /**
     * Check that a provided list can be used to create some descendant of a DoubleVector, and return the Unit.
     * @param dsList List&lt;S&gt;; the list to check and get the unit for
     * @param <AU> the absolute unit of the scalars in the list
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar in the list
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractDoubleScalarAbs<AU, S, RU, ?>> AU checkUnit(final List<S> dsList) throws ValueException
    {
        if (dsList != null && dsList.size() > 0)
        {
            return dsList.get(0).getUnit();
        }
        throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from a null or empty list of DoubleScalar");
    }

    /**
     * Check that a provided Map can be used to create some descendant of a DoubleVector.
     * @param dsMap SortedMap&lt;Integer,S&gt;; the provided map
     * @param <AU> the absolute unit of the scalars in the map
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar in the list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractDoubleScalarAbs<AU, S, RU, ?>> AU checkUnit(final SortedMap<Integer, S> dsMap)
                    throws ValueException
    {
        if (dsMap != null && dsMap.size() > 0)
        {
            return dsMap.get(dsMap.firstKey()).getUnit();
        }
        throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from a null or empty Map of DoubleScalar");
    }

    /* ============================================================================================ */
    /* =============================== ITERATOR METHODS AND CLASS ================================= */
    /* ============================================================================================ */

    /**
     * Returns an iterator over the scalars in this vector in proper sequence.
     * @return an iterator over the scalars in this vector in proper sequence
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
            catch (ValueException exception)
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
