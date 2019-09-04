package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.VolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatVolume;

/**
 * Immutable Float FloatVolumeVector, a vector of values with a VolumeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatVolumeVector
        extends AbstractFloatVectorRel<VolumeUnit, FloatVolumeVector, MutableFloatVolumeVector, FloatVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatVolumeVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatVolumeVector
     * @param unit VolumeUnit; the unit of the new Relative Immutable Float FloatVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatVolumeVector(final float[] values, final VolumeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatVolumeVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatVolumeVector
     * @param unit VolumeUnit; the unit of the new Relative Immutable Float FloatVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatVolumeVector(final List<Float> values, final VolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatVolumeVector.
     * @param values FloatVolume[]; the values of the entries in the new Relative Immutable Float FloatVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatVolumeVector(final FloatVolume[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatVolumeVector.
     * @param values List&lt;FloatVolume&gt;; the values of the entries in the new Relative Immutable Float FloatVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatVolumeVector(final List<FloatVolume> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatVolumeVector.
     * @param values SortedMap&lt;Integer, FloatVolume&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatVolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatVolumeVector(final SortedMap<Integer, FloatVolume> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatVolumeVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatVolumeVector
     * @param unit VolumeUnit; the unit of the new Relative Sparse Mutable Float FloatVolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatVolumeVector(final SortedMap<Integer, Float> values, final VolumeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit VolumeUnit; the unit
     */
    FloatVolumeVector(final FloatVectorData data, final VolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatVolumeVector instantiateType(final FloatVectorData dvd, final VolumeUnit unit)
    {
        return new FloatVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatVolumeVector instantiateMutableType(final FloatVectorData dvd, final VolumeUnit unit)
    {
        return new MutableFloatVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatVolume instantiateScalar(final float value, final VolumeUnit unit)
    {
        return new FloatVolume(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolumeVector toDense()
    {
        return this.data.isDense() ? (FloatVolumeVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolumeVector toSparse()
    {
        return this.data.isSparse() ? (FloatVolumeVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatVolume Scalars from this vector.
     * @return FloatVolume[]; an array of FloatVolume Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatVolume[] toArray()
    {
        FloatVolume[] array = new FloatVolume[size()];
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
