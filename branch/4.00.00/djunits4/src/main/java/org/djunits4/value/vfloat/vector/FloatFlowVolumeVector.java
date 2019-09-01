package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.FlowVolumeUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatFlowVolume;

/**
 * Immutable Float FloatFlowVolumeVector, a vector of values with a FlowVolumeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatFlowVolumeVector
        extends AbstractFloatVectorRel<FlowVolumeUnit, FloatFlowVolumeVector, MutableFloatFlowVolumeVector, FloatFlowVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatFlowVolumeVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatFlowVolumeVector
     * @param unit FlowVolumeUnit; the unit of the new Relative Immutable Float FloatFlowVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatFlowVolumeVector(final float[] values, final FlowVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowVolumeVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatFlowVolumeVector
     * @param unit FlowVolumeUnit; the unit of the new Relative Immutable Float FloatFlowVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatFlowVolumeVector(final List<Float> values, final FlowVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowVolumeVector.
     * @param values FloatFlowVolume[]; the values of the entries in the new Relative Immutable Float FloatFlowVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatFlowVolumeVector(final FloatFlowVolume[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowVolumeVector.
     * @param values List&lt;FloatFlowVolume&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatFlowVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatFlowVolumeVector(final List<FloatFlowVolume> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowVolumeVector.
     * @param values SortedMap&lt;Integer, FloatFlowVolume&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float FloatFlowVolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatFlowVolumeVector(final SortedMap<Integer, FloatFlowVolume> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowVolumeVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatFlowVolumeVector
     * @param unit FlowVolumeUnit; the unit of the new Relative Sparse Mutable Float FloatFlowVolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatFlowVolumeVector(final SortedMap<Integer, Float> values, final FlowVolumeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatFlowVolumeVector(final FloatVectorData data, final FlowVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowVolumeVector instantiateType(final FloatVectorData dvd, final FlowVolumeUnit unit)
    {
        return new FloatFlowVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatFlowVolumeVector instantiateMutableType(final FloatVectorData dvd, final FlowVolumeUnit unit)
    {
        return new MutableFloatFlowVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowVolume instantiateScalar(final float value, final FlowVolumeUnit unit)
    {
        return new FloatFlowVolume(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolumeVector toDense()
    {
        return this.data.isDense() ? (FloatFlowVolumeVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolumeVector toSparse()
    {
        return this.data.isSparse() ? (FloatFlowVolumeVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatFlowVolume Scalars from this vector.
     * @return FloatFlowVolume[]; an array of FloatFlowVolume Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatFlowVolume[] toArray()
    {
        FloatFlowVolume[] array = new FloatFlowVolume[size()];
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
