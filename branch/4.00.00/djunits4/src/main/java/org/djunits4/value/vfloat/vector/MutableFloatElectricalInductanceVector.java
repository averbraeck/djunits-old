package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalInductanceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatElectricalInductance;

/**
 * Mutable Float ElectricalInductanceVector, a vector of values with a ElectricalInductanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatElectricalInductanceVector extends AbstractMutableFloatVectorRel<ElectricalInductanceUnit,
        FloatElectricalInductanceVector, MutableFloatElectricalInductanceVector, FloatElectricalInductance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float ElectricalInductanceVector
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Immutable Float ElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatElectricalInductanceVector(final float[] values, final ElectricalInductanceUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float ElectricalInductanceVector
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Immutable Float ElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatElectricalInductanceVector(final List<Float> values, final ElectricalInductanceUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values FloatElectricalInductance[]; the values of the entries in the new Relative Immutable Float
     *            ElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatElectricalInductanceVector(final FloatElectricalInductance[] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values List&lt;FloatElectricalInductance&gt;; the values of the entries in the new Relative Immutable Float
     *            ElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatElectricalInductanceVector(final List<FloatElectricalInductance> values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values SortedMap&lt;Integer, FloatElectricalInductance&gt;; the values of the entries in the new Relative Sparse
     *            Mutable Float ElectricalInductanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatElectricalInductanceVector(final SortedMap<Integer, FloatElectricalInductance> values, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            ElectricalInductanceVector
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Sparse Mutable Float ElectricalInductanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatElectricalInductanceVector(final SortedMap<Integer, Float> values, final ElectricalInductanceUnit unit,
            final int length, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalInductanceVector(final FloatVectorData data, final ElectricalInductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductanceVector instantiateType(final FloatVectorData dvd,
            final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalInductanceVector instantiateMutableType(final FloatVectorData dvd,
            final ElectricalInductanceUnit unit)
    {
        return new MutableFloatElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductance instantiateScalar(final float value, final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductance(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalInductanceVector toDense()
    {
        return this.data.isDense() ? (MutableFloatElectricalInductanceVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalInductanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatElectricalInductanceVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatElectricalInductance Scalars from this vector.
     * @return FloatElectricalInductance[]; an array of FloatElectricalInductance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalInductance[] toArray()
    {
        FloatElectricalInductance[] array = new FloatElectricalInductance[size()];
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
