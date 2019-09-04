package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoney;

/**
 * Immutable Float FloatMoneyVector, a vector of values with a MoneyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMoneyVector extends AbstractFloatVectorRel<MoneyUnit, FloatMoneyVector, MutableFloatMoneyVector, FloatMoney>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMoneyVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMoneyVector
     * @param unit MoneyUnit; the unit of the new Relative Immutable Float FloatMoneyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyVector(final float[] values, final MoneyUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatMoneyVector
     * @param unit MoneyUnit; the unit of the new Relative Immutable Float FloatMoneyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyVector(final List<Float> values, final MoneyUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyVector.
     * @param values FloatMoney[]; the values of the entries in the new Relative Immutable Float FloatMoneyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyVector(final FloatMoney[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyVector.
     * @param values List&lt;FloatMoney&gt;; the values of the entries in the new Relative Immutable Float FloatMoneyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyVector(final List<FloatMoney> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyVector.
     * @param values SortedMap&lt;Integer, FloatMoney&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatMoneyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyVector(final SortedMap<Integer, FloatMoney> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatMoneyVector
     * @param unit MoneyUnit; the unit of the new Relative Sparse Mutable Float FloatMoneyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyVector(final SortedMap<Integer, Float> values, final MoneyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit MoneyUnit; the unit
     */
    FloatMoneyVector(final FloatVectorData data, final MoneyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyVector instantiateType(final FloatVectorData dvd, final MoneyUnit unit)
    {
        return new FloatMoneyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyVector instantiateMutableType(final FloatVectorData dvd, final MoneyUnit unit)
    {
        return new MutableFloatMoneyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoney instantiateScalar(final float value, final MoneyUnit unit)
    {
        return new FloatMoney(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyVector toDense()
    {
        return this.data.isDense() ? (FloatMoneyVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyVector toSparse()
    {
        return this.data.isSparse() ? (FloatMoneyVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatMoney Scalars from this vector.
     * @return FloatMoney[]; an array of FloatMoney Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMoney[] toArray()
    {
        FloatMoney[] array = new FloatMoney[size()];
        for (int i = 0; i < size(); i++)
        {
            try
            {
                array[i] = get(i);
            }
            catch (ValueException exception)
            {
                throw new RuntimeException(exception);
            }
        }
        return array;
    }

}
