package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.VolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatVolume;

/**
 * Mutable Float VolumeVector, a vector of values with a VolumeUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatVolumeVector
        extends AbstractMutableFloatVectorRel<VolumeUnit, FloatVolumeVector, MutableFloatVolumeVector, FloatVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float VolumeVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float VolumeVector
     * @param unit U; the unit of the new Relative Immutable Float VolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatVolumeVector(final float[] values, final VolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float VolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Float VolumeVector
     * @param unit U; the unit of the new Relative Immutable Float VolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatVolumeVector(final List<Float> values, final VolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float VolumeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float VolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatVolumeVector(final FloatVolume[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float VolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Float VolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatVolumeVector(final List<FloatVolume> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float VolumeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float VolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatVolumeVector(final SortedMap<Integer, FloatVolume> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float VolumeVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float VolumeVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float VolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatVolumeVector(final SortedMap<Integer, Float> values, final VolumeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatVolumeVector(final FloatVectorData data, final VolumeUnit unit)
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
    public final MutableFloatVolumeVector toDense()
    {
        return this.data.isDense() ? (MutableFloatVolumeVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatVolumeVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatVolumeVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
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
