package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.TorqueUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatTorque;

/**
 * Mutable Float TorqueVector, a vector of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatTorqueVector
        extends AbstractMutableFloatVectorRel<TorqueUnit, FloatTorqueVector, MutableFloatTorqueVector, FloatTorque>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float TorqueVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float TorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Immutable Float TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatTorqueVector(final float[] values, final TorqueUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float TorqueVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float TorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Immutable Float TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatTorqueVector(final List<Float> values, final TorqueUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float TorqueVector.
     * @param values FloatTorque[]; the values of the entries in the new Relative Immutable Float TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatTorqueVector(final FloatTorque[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float TorqueVector.
     * @param values List&lt;FloatTorque&gt;; the values of the entries in the new Relative Immutable Float TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatTorqueVector(final List<FloatTorque> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float TorqueVector.
     * @param values SortedMap&lt;Integer, FloatTorque&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            TorqueVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatTorqueVector(final SortedMap<Integer, FloatTorque> values, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float TorqueVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            TorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Sparse Mutable Float TorqueVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatTorqueVector(final SortedMap<Integer, Float> values, final TorqueUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatTorqueVector(final FloatVectorData data, final TorqueUnit unit)
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
    public final MutableFloatTorqueVector toDense()
    {
        return this.data.isDense() ? (MutableFloatTorqueVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatTorqueVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatTorqueVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
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
            catch (ValueRuntimeException exception)
            {
                throw new RuntimeException(exception);
            }
        }
        return array;
    }

}
