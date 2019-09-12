package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.AbsorbedDoseUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatAbsorbedDose;

/**
 * Immutable Float FloatAbsorbedDoseVector, a vector of values with a AbsorbedDoseUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class FloatAbsorbedDoseVector extends
        AbstractFloatVectorRel<AbsorbedDoseUnit, FloatAbsorbedDoseVector, MutableFloatAbsorbedDoseVector, FloatAbsorbedDose>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param unit AbsorbedDoseUnit; the unit of the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatAbsorbedDoseVector(final float[] values, final AbsorbedDoseUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param unit AbsorbedDoseUnit; the unit of the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatAbsorbedDoseVector(final List<Float> values, final AbsorbedDoseUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values FloatAbsorbedDose[]; the values of the entries in the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatAbsorbedDoseVector(final FloatAbsorbedDose[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values List&lt;FloatAbsorbedDose&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatAbsorbedDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatAbsorbedDoseVector(final List<FloatAbsorbedDose> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values SortedMap&lt;Integer, FloatAbsorbedDose&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float FloatAbsorbedDoseVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatAbsorbedDoseVector(final SortedMap<Integer, FloatAbsorbedDose> values, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatAbsorbedDoseVector
     * @param unit AbsorbedDoseUnit; the unit of the new Relative Sparse Mutable Float FloatAbsorbedDoseVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatAbsorbedDoseVector(final SortedMap<Integer, Float> values, final AbsorbedDoseUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatAbsorbedDoseVector(final FloatVectorData data, final AbsorbedDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsorbedDoseVector instantiateType(final FloatVectorData dvd, final AbsorbedDoseUnit unit)
    {
        return new FloatAbsorbedDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAbsorbedDoseVector instantiateMutableType(final FloatVectorData dvd,
            final AbsorbedDoseUnit unit)
    {
        return new MutableFloatAbsorbedDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsorbedDose instantiateScalar(final float value, final AbsorbedDoseUnit unit)
    {
        return new FloatAbsorbedDose(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAbsorbedDoseVector toDense()
    {
        return this.data.isDense() ? (FloatAbsorbedDoseVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAbsorbedDoseVector toSparse()
    {
        return this.data.isSparse() ? (FloatAbsorbedDoseVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatAbsorbedDose Scalars from this vector.
     * @return FloatAbsorbedDose[]; an array of FloatAbsorbedDose Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAbsorbedDose[] toArray()
    {
        FloatAbsorbedDose[] array = new FloatAbsorbedDose[size()];
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
