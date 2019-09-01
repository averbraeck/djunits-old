package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatIlluminanceVector, a vector of values with a IlluminanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatIlluminanceVector extends
    AbstractFloatVectorRel<IlluminanceUnit, FloatIlluminanceVector, MutableFloatIlluminanceVector, FloatIlluminance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatIlluminanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatIlluminanceVector
     * @param unit IlluminanceUnit; the unit of the new Relative Immutable Float FloatIlluminanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatIlluminanceVector(final float[] values, final IlluminanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatIlluminanceVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatIlluminanceVector
     * @param unit IlluminanceUnit; the unit of the new Relative Immutable Float FloatIlluminanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatIlluminanceVector(final List<Float> values, final IlluminanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatIlluminanceVector.
     * @param values FloatIlluminance[]; the values of the entries in the new Relative Immutable Float FloatIlluminanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatIlluminanceVector(final FloatIlluminance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatIlluminanceVector.
     * @param values List&lt;FloatIlluminance&gt;; the values of the entries in the new Relative Immutable Float FloatIlluminanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatIlluminanceVector(final List<FloatIlluminance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatIlluminanceVector.
     * @param values SortedMap&lt;Integer, FloatIlluminance&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatIlluminanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatIlluminanceVector(final SortedMap<Integer, FloatIlluminance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatIlluminanceVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float FloatIlluminanceVector
     * @param unit IlluminanceUnit; the unit of the new Relative Sparse Mutable Float FloatIlluminanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatIlluminanceVector(final SortedMap<Integer, Float> values, final IlluminanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatIlluminanceVector(final FloatVectorData data, final IlluminanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatIlluminanceVector instantiateType(final FloatVectorData dvd, final IlluminanceUnit unit)
    {
        return new FloatIlluminanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatIlluminanceVector instantiateMutableType(final FloatVectorData dvd, final IlluminanceUnit unit)
    {
        return new MutableFloatIlluminanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatIlluminance instantiateScalar(final float value, final IlluminanceUnit unit)
    {
        return new FloatIlluminance(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatIlluminanceVector toDense()
    {
        return this.data.isDense() ? (FloatIlluminanceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatIlluminanceVector toSparse()
    {
        return this.data.isSparse() ? (FloatIlluminanceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatIlluminance Scalars from this vector.
     * @return FloatIlluminance[]; an array of FloatIlluminance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatIlluminance[] toArray()
    {
        FloatIlluminance[] array = new FloatIlluminance[size()];
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

