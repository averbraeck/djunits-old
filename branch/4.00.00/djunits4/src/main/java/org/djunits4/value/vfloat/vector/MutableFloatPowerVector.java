package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.PowerUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatPower;

/**
 * Mutable Float PowerVector, a vector of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatPowerVector
        extends AbstractMutableFloatVectorRel<PowerUnit, FloatPowerVector, MutableFloatPowerVector, FloatPower>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float PowerVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float PowerVector
     * @param unit PowerUnit; the unit of the new Relative Immutable Float PowerVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatPowerVector(final float[] values, final PowerUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PowerVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float PowerVector
     * @param unit PowerUnit; the unit of the new Relative Immutable Float PowerVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatPowerVector(final List<Float> values, final PowerUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PowerVector.
     * @param values FloatPower[]; the values of the entries in the new Relative Immutable Float PowerVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatPowerVector(final FloatPower[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PowerVector.
     * @param values List&lt;FloatPower&gt;; the values of the entries in the new Relative Immutable Float PowerVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatPowerVector(final List<FloatPower> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PowerVector.
     * @param values SortedMap&lt;Integer, FloatPower&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            PowerVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatPowerVector(final SortedMap<Integer, FloatPower> values, final int length, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PowerVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            PowerVector
     * @param unit PowerUnit; the unit of the new Relative Sparse Mutable Float PowerVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatPowerVector(final SortedMap<Integer, Float> values, final PowerUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatPowerVector(final FloatVectorData data, final PowerUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPowerVector instantiateType(final FloatVectorData dvd, final PowerUnit unit)
    {
        return new FloatPowerVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPowerVector instantiateMutableType(final FloatVectorData dvd, final PowerUnit unit)
    {
        return new MutableFloatPowerVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPower instantiateScalar(final float value, final PowerUnit unit)
    {
        return new FloatPower(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPowerVector toDense()
    {
        return this.data.isDense() ? (MutableFloatPowerVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPowerVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatPowerVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatPower Scalars from this vector.
     * @return FloatPower[]; an array of FloatPower Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatPower[] toArray()
    {
        FloatPower[] array = new FloatPower[size()];
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
