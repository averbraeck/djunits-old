package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatAccelerationVector, a vector of values with a AccelerationUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatAccelerationVector extends
    AbstractFloatVectorRel<AccelerationUnit, FloatAccelerationVector, MutableFloatAccelerationVector, FloatAcceleration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatAccelerationVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatAccelerationVector
     * @param unit AccelerationUnit; the unit of the new Relative Immutable Float FloatAccelerationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAccelerationVector(final float[] values, final AccelerationUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAccelerationVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatAccelerationVector
     * @param unit AccelerationUnit; the unit of the new Relative Immutable Float FloatAccelerationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAccelerationVector(final List<Float> values, final AccelerationUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAccelerationVector.
     * @param values FloatAcceleration[]; the values of the entries in the new Relative Immutable Float FloatAccelerationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAccelerationVector(final FloatAcceleration[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAccelerationVector.
     * @param values List&lt;FloatAcceleration&gt;; the values of the entries in the new Relative Immutable Float FloatAccelerationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAccelerationVector(final List<FloatAcceleration> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAccelerationVector.
     * @param values SortedMap&lt;Integer, FloatAcceleration&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatAccelerationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAccelerationVector(final SortedMap<Integer, FloatAcceleration> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAccelerationVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float FloatAccelerationVector
     * @param unit AccelerationUnit; the unit of the new Relative Sparse Mutable Float FloatAccelerationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAccelerationVector(final SortedMap<Integer, Float> values, final AccelerationUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatAccelerationVector(final FloatVectorData data, final AccelerationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAccelerationVector instantiateType(final FloatVectorData dvd, final AccelerationUnit unit)
    {
        return new FloatAccelerationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAccelerationVector instantiateMutableType(final FloatVectorData dvd, final AccelerationUnit unit)
    {
        return new MutableFloatAccelerationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAcceleration instantiateScalar(final float value, final AccelerationUnit unit)
    {
        return new FloatAcceleration(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatAccelerationVector toDense()
    {
        return this.data.isDense() ? (FloatAccelerationVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAccelerationVector toSparse()
    {
        return this.data.isSparse() ? (FloatAccelerationVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatAcceleration Scalars from this vector.
     * @return FloatAcceleration[]; an array of FloatAcceleration Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAcceleration[] toArray()
    {
        FloatAcceleration[] array = new FloatAcceleration[size()];
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

