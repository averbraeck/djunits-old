package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerEnergy;

/**
 * Immutable Float FloatMoneyPerEnergyVector, a vector of values with a MoneyPerEnergyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMoneyPerEnergyVector extends AbstractFloatVectorRel<MoneyPerEnergyUnit, FloatMoneyPerEnergyVector,
        MutableFloatMoneyPerEnergyVector, FloatMoneyPerEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerEnergyVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMoneyPerEnergyVector
     * @param unit MoneyPerEnergyUnit; the unit of the new Relative Immutable Float FloatMoneyPerEnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerEnergyVector(final float[] values, final MoneyPerEnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerEnergyVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatMoneyPerEnergyVector
     * @param unit MoneyPerEnergyUnit; the unit of the new Relative Immutable Float FloatMoneyPerEnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerEnergyVector(final List<Float> values, final MoneyPerEnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerEnergyVector.
     * @param values FloatMoneyPerEnergy[]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerEnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerEnergyVector(final FloatMoneyPerEnergy[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerEnergyVector.
     * @param values List&lt;FloatMoneyPerEnergy&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerEnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerEnergyVector(final List<FloatMoneyPerEnergy> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerEnergyVector.
     * @param values SortedMap&lt;Integer, FloatMoneyPerEnergy&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float FloatMoneyPerEnergyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerEnergyVector(final SortedMap<Integer, FloatMoneyPerEnergy> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerEnergyVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatMoneyPerEnergyVector
     * @param unit MoneyPerEnergyUnit; the unit of the new Relative Sparse Mutable Float FloatMoneyPerEnergyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerEnergyVector(final SortedMap<Integer, Float> values, final MoneyPerEnergyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit MoneyPerEnergyUnit; the unit
     */
    FloatMoneyPerEnergyVector(final FloatVectorData data, final MoneyPerEnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerEnergyVector instantiateType(final FloatVectorData dvd, final MoneyPerEnergyUnit unit)
    {
        return new FloatMoneyPerEnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerEnergyVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerEnergyUnit unit)
    {
        return new MutableFloatMoneyPerEnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerEnergy instantiateScalar(final float value, final MoneyPerEnergyUnit unit)
    {
        return new FloatMoneyPerEnergy(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergyVector toDense()
    {
        return this.data.isDense() ? (FloatMoneyPerEnergyVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergyVector toSparse()
    {
        return this.data.isSparse() ? (FloatMoneyPerEnergyVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatMoneyPerEnergy Scalars from this vector.
     * @return FloatMoneyPerEnergy[]; an array of FloatMoneyPerEnergy Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMoneyPerEnergy[] toArray()
    {
        FloatMoneyPerEnergy[] array = new FloatMoneyPerEnergy[size()];
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
