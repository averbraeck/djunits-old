package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.AmountOfSubstanceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatAmountOfSubstance;

/**
 * Mutable Float AmountOfSubstanceVector, a vector of values with a AmountOfSubstanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatAmountOfSubstanceVector extends AbstractMutableFloatVectorRel<AmountOfSubstanceUnit,
        FloatAmountOfSubstanceVector, MutableFloatAmountOfSubstanceVector, FloatAmountOfSubstance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float AmountOfSubstanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float AmountOfSubstanceVector
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Immutable Float AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatAmountOfSubstanceVector(final float[] values, final AmountOfSubstanceUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AmountOfSubstanceVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float AmountOfSubstanceVector
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Immutable Float AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatAmountOfSubstanceVector(final List<Float> values, final AmountOfSubstanceUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AmountOfSubstanceVector.
     * @param values FloatAmountOfSubstance[]; the values of the entries in the new Relative Immutable Float
     *            AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatAmountOfSubstanceVector(final FloatAmountOfSubstance[] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AmountOfSubstanceVector.
     * @param values List&lt;FloatAmountOfSubstance&gt;; the values of the entries in the new Relative Immutable Float
     *            AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatAmountOfSubstanceVector(final List<FloatAmountOfSubstance> values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AmountOfSubstanceVector.
     * @param values SortedMap&lt;Integer, FloatAmountOfSubstance&gt;; the values of the entries in the new Relative Sparse
     *            Mutable Float AmountOfSubstanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatAmountOfSubstanceVector(final SortedMap<Integer, FloatAmountOfSubstance> values, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AmountOfSubstanceVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            AmountOfSubstanceVector
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Sparse Mutable Float AmountOfSubstanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatAmountOfSubstanceVector(final SortedMap<Integer, Float> values, final AmountOfSubstanceUnit unit,
            final int length, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatAmountOfSubstanceVector(final FloatVectorData data, final AmountOfSubstanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAmountOfSubstanceVector instantiateType(final FloatVectorData dvd, final AmountOfSubstanceUnit unit)
    {
        return new FloatAmountOfSubstanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAmountOfSubstanceVector instantiateMutableType(final FloatVectorData dvd,
            final AmountOfSubstanceUnit unit)
    {
        return new MutableFloatAmountOfSubstanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAmountOfSubstance instantiateScalar(final float value, final AmountOfSubstanceUnit unit)
    {
        return new FloatAmountOfSubstance(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAmountOfSubstanceVector toDense()
    {
        return this.data.isDense() ? (MutableFloatAmountOfSubstanceVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAmountOfSubstanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatAmountOfSubstanceVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatAmountOfSubstance Scalars from this vector.
     * @return FloatAmountOfSubstance[]; an array of FloatAmountOfSubstance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAmountOfSubstance[] toArray()
    {
        FloatAmountOfSubstance[] array = new FloatAmountOfSubstance[size()];
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
