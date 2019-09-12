package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.SpeedUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatSpeed;

/**
 * Mutable Float SpeedVector, a vector of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatSpeedVector
        extends AbstractMutableFloatVectorRel<SpeedUnit, FloatSpeedVector, MutableFloatSpeedVector, FloatSpeed>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float SpeedVector
     * @param unit SpeedUnit; the unit of the new Relative Immutable Float SpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatSpeedVector(final float[] values, final SpeedUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float SpeedVector
     * @param unit SpeedUnit; the unit of the new Relative Immutable Float SpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatSpeedVector(final List<Float> values, final SpeedUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values FloatSpeed[]; the values of the entries in the new Relative Immutable Float SpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatSpeedVector(final FloatSpeed[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values List&lt;FloatSpeed&gt;; the values of the entries in the new Relative Immutable Float SpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatSpeedVector(final List<FloatSpeed> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values SortedMap&lt;Integer, FloatSpeed&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            SpeedVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatSpeedVector(final SortedMap<Integer, FloatSpeed> values, final int length, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            SpeedVector
     * @param unit SpeedUnit; the unit of the new Relative Sparse Mutable Float SpeedVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatSpeedVector(final SortedMap<Integer, Float> values, final SpeedUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatSpeedVector(final FloatVectorData data, final SpeedUnit unit)
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
    public final MutableFloatSpeedVector toDense()
    {
        return this.data.isDense() ? (MutableFloatSpeedVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatSpeedVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatSpeedVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
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
            catch (ValueRuntimeException exception)
            {
                throw new RuntimeException(exception);
            }
        }
        return array;
    }

}
