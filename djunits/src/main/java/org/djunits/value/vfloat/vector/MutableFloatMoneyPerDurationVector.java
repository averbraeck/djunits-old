package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerDuration;

/**
 * Mutable Float MoneyPerDurationVector, a vector of values with a MoneyPerDurationUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatMoneyPerDurationVector extends AbstractMutableFloatVectorRel<MoneyPerDurationUnit,
        FloatMoneyPerDurationVector, MutableFloatMoneyPerDurationVector, FloatMoneyPerDuration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float MoneyPerDurationVector
     * @param unit MoneyPerDurationUnit; the unit of the new Relative Immutable Float MoneyPerDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerDurationVector(final float[] values, final MoneyPerDurationUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float MoneyPerDurationVector
     * @param unit MoneyPerDurationUnit; the unit of the new Relative Immutable Float MoneyPerDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerDurationVector(final List<Float> values, final MoneyPerDurationUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values FloatMoneyPerDuration[]; the values of the entries in the new Relative Immutable Float
     *            MoneyPerDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerDurationVector(final FloatMoneyPerDuration[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values List&lt;FloatMoneyPerDuration&gt;; the values of the entries in the new Relative Immutable Float
     *            MoneyPerDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerDurationVector(final List<FloatMoneyPerDuration> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values SortedMap&lt;Integer, FloatMoneyPerDuration&gt;; the values of the entries in the new Relative Sparse
     *            Mutable Float MoneyPerDurationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerDurationVector(final SortedMap<Integer, FloatMoneyPerDuration> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            MoneyPerDurationVector
     * @param unit MoneyPerDurationUnit; the unit of the new Relative Sparse Mutable Float MoneyPerDurationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerDurationVector(final SortedMap<Integer, Float> values, final MoneyPerDurationUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit MoneyPerDurationUnit; the unit
     */
    MutableFloatMoneyPerDurationVector(final FloatVectorData data, final MoneyPerDurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerDurationVector instantiateType(final FloatVectorData dvd, final MoneyPerDurationUnit unit)
    {
        return new FloatMoneyPerDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerDurationVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerDurationUnit unit)
    {
        return new MutableFloatMoneyPerDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerDuration instantiateScalar(final float value, final MoneyPerDurationUnit unit)
    {
        return new FloatMoneyPerDuration(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerDurationVector toDense()
    {
        return this.data.isDense() ? (MutableFloatMoneyPerDurationVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerDurationVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatMoneyPerDurationVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatMoneyPerDuration Scalars from this vector.
     * @return FloatMoneyPerDuration[]; an array of FloatMoneyPerDuration Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMoneyPerDuration[] toArray()
    {
        FloatMoneyPerDuration[] array = new FloatMoneyPerDuration[size()];
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
