package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Relative FloatTemperature Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatTemperatureVector extends AbstractMutableFloatVectorRel<TemperatureUnit, FloatTemperatureVector, MutableFloatTemperatureVector, FloatTemperature>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatTemperatureVector.
     * @param values float[]; the values of the entries in the new Relative Mutable FloatTemperatureVector
     * @param unit TemperatureUnit; the unit of the new Relative Mutable FloatTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatTemperatureVector(final float[] values, final TemperatureUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatTemperatureVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Mutable FloatTemperatureVector
     * @param unit TemperatureUnit; the unit of the new Relative Mutable FloatTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatTemperatureVector(final List<Float> values, final TemperatureUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatTemperatureVector.
     * @param values FloatTemperature[]; the values of the entries in the new Relative Mutable FloatTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatTemperatureVector(final FloatTemperature[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatTemperatureVector.
     * @param values List&lt;FloatTemperature&gt;; the values of the entries in the new Relative Mutable FloatTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatTemperatureVector(final List<FloatTemperature> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatTemperatureVector.
     * @param values SortedMap&lt;Integer, FloatTemperature&gt;; the values of the entries in the new Relative Sparse Mutable FloatTemperatureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatTemperatureVector(final SortedMap<Integer, FloatTemperature> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatTemperatureVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable FloatTemperatureVector
     * @param unit TemperatureUnit; the unit of the new Relative Sparse Mutable FloatTemperatureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatTemperatureVector(final SortedMap<Integer, Float> values, final TemperatureUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatTemperatureVector.
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatTemperatureVector(final FloatVectorData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperatureVector instantiateType(final FloatVectorData dvd, final TemperatureUnit unit)
    {
        return new FloatTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTemperatureVector instantiateMutableType(final FloatVectorData dvd, final TemperatureUnit unit)
    {
        return new MutableFloatTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperature instantiateScalar(final float value, final TemperatureUnit unit)
    {
        return new FloatTemperature(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableFloatTemperatureVector toDense()
    {
        return this.data.isDense() ? (MutableFloatTemperatureVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatTemperatureVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatTemperatureVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatTemperature Scalars from this vector.
     * @return FloatTemperature[]; an array of FloatTemperature Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatTemperature[] toArray()
    {
        FloatTemperature[] array = new FloatTemperature[size()];
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