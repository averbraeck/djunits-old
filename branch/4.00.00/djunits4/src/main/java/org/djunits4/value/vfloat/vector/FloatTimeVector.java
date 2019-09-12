package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatTime;

/**
 * Absolute FloatTime Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class FloatTimeVector extends
        AbstractFloatVectorAbs<TimeUnit, DurationUnit, FloatTimeVector, FloatDurationVector, MutableFloatTimeVector, FloatTime>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable FloatTimeVector.
     * @param values float[]; the values of the entries in the new Absolute Immutable FloatTimeVector
     * @param unit TimeUnit; the unit of the new Absolute Immutable FloatTimeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatTimeVector(final float[] values, final TimeUnit unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatTimeVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Absolute Immutable FloatTimeVector
     * @param unit TimeUnit; the unit of the new Absolute Immutable FloatTimeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatTimeVector(final List<Float> values, final TimeUnit unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatTimeVector.
     * @param values FloatTime[]; the values of the entries in the new Absolute Immutable FloatTimeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatTimeVector(final FloatTime[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatTimeVector.
     * @param values List&lt;FloatTime&gt;; the values of the entries in the new Absolute Immutable FloatTimeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatTimeVector(final List<FloatTime> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatTimeVector.
     * @param values SortedMap&lt;Integer, FloatTime&gt;; the values of the entries in the new Absolute Sparse Mutable
     *            FloatTimeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatTimeVector(final SortedMap<Integer, FloatTime> values, final int length, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatTimeVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Absolute Sparse Mutable
     *            FloatTimeVector
     * @param unit TimeUnit; the unit of the new Absolute Sparse Mutable FloatTimeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatTimeVector(final SortedMap<Integer, Float> values, final TimeUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatTimeVector.
     * @param data FloatVectorData; an internal data object
     * @param unit TimeUnit; the unit
     */
    FloatTimeVector(final FloatVectorData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTimeVector instantiateTypeAbs(final FloatVectorData dvd, final TimeUnit unit)
    {
        return new FloatTimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationVector instantiateTypeRel(final FloatVectorData dvd, final DurationUnit unit)
    {
        return new FloatDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTimeVector instantiateMutableType(final FloatVectorData dvd, final TimeUnit unit)
    {
        return new MutableFloatTimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTime instantiateScalar(final float value, final TimeUnit unit)
    {
        return new FloatTime(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTimeVector toDense()
    {
        return this.data.isDense() ? (FloatTimeVector) this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTimeVector toSparse()
    {
        return this.data.isSparse() ? (FloatTimeVector) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatTime Scalars from this vector.
     * @return FloatTime[]; an array of FloatTime Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatTime[] toArray()
    {
        FloatTime[] array = new FloatTime[size()];
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
