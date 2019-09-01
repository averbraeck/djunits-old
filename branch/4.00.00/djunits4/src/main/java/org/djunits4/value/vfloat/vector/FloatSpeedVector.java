package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.SpeedUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatSpeed;

/**
 * Immutable Float FloatSpeedVector, a vector of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatSpeedVector extends AbstractFloatVectorRel<SpeedUnit, FloatSpeedVector, MutableFloatSpeedVector, FloatSpeed>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatSpeedVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatSpeedVector
     * @param unit SpeedUnit; the unit of the new Relative Immutable Float FloatSpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatSpeedVector(final float[] values, final SpeedUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatSpeedVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatSpeedVector
     * @param unit SpeedUnit; the unit of the new Relative Immutable Float FloatSpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatSpeedVector(final List<Float> values, final SpeedUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatSpeedVector.
     * @param values FloatSpeed[]; the values of the entries in the new Relative Immutable Float FloatSpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatSpeedVector(final FloatSpeed[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatSpeedVector.
     * @param values List&lt;FloatSpeed&gt;; the values of the entries in the new Relative Immutable Float FloatSpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatSpeedVector(final List<FloatSpeed> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatSpeedVector.
     * @param values SortedMap&lt;Integer, FloatSpeed&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatSpeedVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatSpeedVector(final SortedMap<Integer, FloatSpeed> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatSpeedVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatSpeedVector
     * @param unit SpeedUnit; the unit of the new Relative Sparse Mutable Float FloatSpeedVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatSpeedVector(final SortedMap<Integer, Float> values, final SpeedUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatSpeedVector(final FloatVectorData data, final SpeedUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatSpeedVector instantiateType(final FloatVectorData dvd, final SpeedUnit unit)
    {
        return new FloatSpeedVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatSpeedVector instantiateMutableType(final FloatVectorData dvd, final SpeedUnit unit)
    {
        return new MutableFloatSpeedVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatSpeed instantiateScalar(final float value, final SpeedUnit unit)
    {
        return new FloatSpeed(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeedVector toDense()
    {
        return this.data.isDense() ? (FloatSpeedVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSpeedVector toSparse()
    {
        return this.data.isSparse() ? (FloatSpeedVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatSpeed Scalars from this vector.
     * @return FloatSpeed[]; an array of FloatSpeed Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatSpeed[] toArray()
    {
        FloatSpeed[] array = new FloatSpeed[size()];
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
