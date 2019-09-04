package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerLength;

/**
 * Immutable Float FloatMoneyPerLengthVector, a vector of values with a MoneyPerLengthUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMoneyPerLengthVector extends AbstractFloatVectorRel<MoneyPerLengthUnit, FloatMoneyPerLengthVector,
        MutableFloatMoneyPerLengthVector, FloatMoneyPerLength>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMoneyPerLengthVector
     * @param unit MoneyPerLengthUnit; the unit of the new Relative Immutable Float FloatMoneyPerLengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerLengthVector(final float[] values, final MoneyPerLengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatMoneyPerLengthVector
     * @param unit MoneyPerLengthUnit; the unit of the new Relative Immutable Float FloatMoneyPerLengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerLengthVector(final List<Float> values, final MoneyPerLengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values FloatMoneyPerLength[]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerLengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerLengthVector(final FloatMoneyPerLength[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values List&lt;FloatMoneyPerLength&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerLengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerLengthVector(final List<FloatMoneyPerLength> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values SortedMap&lt;Integer, FloatMoneyPerLength&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float FloatMoneyPerLengthVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerLengthVector(final SortedMap<Integer, FloatMoneyPerLength> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatMoneyPerLengthVector
     * @param unit MoneyPerLengthUnit; the unit of the new Relative Sparse Mutable Float FloatMoneyPerLengthVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerLengthVector(final SortedMap<Integer, Float> values, final MoneyPerLengthUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit MoneyPerLengthUnit; the unit
     */
    FloatMoneyPerLengthVector(final FloatVectorData data, final MoneyPerLengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerLengthVector instantiateType(final FloatVectorData dvd, final MoneyPerLengthUnit unit)
    {
        return new FloatMoneyPerLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerLengthVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerLengthUnit unit)
    {
        return new MutableFloatMoneyPerLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerLength instantiateScalar(final float value, final MoneyPerLengthUnit unit)
    {
        return new FloatMoneyPerLength(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLengthVector toDense()
    {
        return this.data.isDense() ? (FloatMoneyPerLengthVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerLengthVector toSparse()
    {
        return this.data.isSparse() ? (FloatMoneyPerLengthVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatMoneyPerLength Scalars from this vector.
     * @return FloatMoneyPerLength[]; an array of FloatMoneyPerLength Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMoneyPerLength[] toArray()
    {
        FloatMoneyPerLength[] array = new FloatMoneyPerLength[size()];
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
