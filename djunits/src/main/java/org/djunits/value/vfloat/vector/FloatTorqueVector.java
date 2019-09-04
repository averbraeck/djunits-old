package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TorqueUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTorque;

/**
 * Immutable Float FloatTorqueVector, a vector of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatTorqueVector
        extends AbstractFloatVectorRel<TorqueUnit, FloatTorqueVector, MutableFloatTorqueVector, FloatTorque>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatTorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Immutable Float FloatTorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTorqueVector(final float[] values, final TorqueUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatTorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Immutable Float FloatTorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTorqueVector(final List<Float> values, final TorqueUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values FloatTorque[]; the values of the entries in the new Relative Immutable Float FloatTorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTorqueVector(final FloatTorque[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values List&lt;FloatTorque&gt;; the values of the entries in the new Relative Immutable Float FloatTorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTorqueVector(final List<FloatTorque> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values SortedMap&lt;Integer, FloatTorque&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatTorqueVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTorqueVector(final SortedMap<Integer, FloatTorque> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatTorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Sparse Mutable Float FloatTorqueVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTorqueVector(final SortedMap<Integer, Float> values, final TorqueUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit TorqueUnit; the unit
     */
    FloatTorqueVector(final FloatVectorData data, final TorqueUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTorqueVector instantiateType(final FloatVectorData dvd, final TorqueUnit unit)
    {
        return new FloatTorqueVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTorqueVector instantiateMutableType(final FloatVectorData dvd, final TorqueUnit unit)
    {
        return new MutableFloatTorqueVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTorque instantiateScalar(final float value, final TorqueUnit unit)
    {
        return new FloatTorque(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorqueVector toDense()
    {
        return this.data.isDense() ? (FloatTorqueVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorqueVector toSparse()
    {
        return this.data.isSparse() ? (FloatTorqueVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatTorque Scalars from this vector.
     * @return FloatTorque[]; an array of FloatTorque Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatTorque[] toArray()
    {
        FloatTorque[] array = new FloatTorque[size()];
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
