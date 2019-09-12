package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.RadioActivityUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatRadioActivity;

/**
 * Mutable Float RadioActivityVector, a vector of values with a RadioActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatRadioActivityVector extends AbstractMutableFloatVectorRel<RadioActivityUnit, FloatRadioActivityVector,
        MutableFloatRadioActivityVector, FloatRadioActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float RadioActivityVector
     * @param unit RadioActivityUnit; the unit of the new Relative Immutable Float RadioActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatRadioActivityVector(final float[] values, final RadioActivityUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float RadioActivityVector
     * @param unit RadioActivityUnit; the unit of the new Relative Immutable Float RadioActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatRadioActivityVector(final List<Float> values, final RadioActivityUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values FloatRadioActivity[]; the values of the entries in the new Relative Immutable Float RadioActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatRadioActivityVector(final FloatRadioActivity[] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values List&lt;FloatRadioActivity&gt;; the values of the entries in the new Relative Immutable Float
     *            RadioActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatRadioActivityVector(final List<FloatRadioActivity> values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values SortedMap&lt;Integer, FloatRadioActivity&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float RadioActivityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatRadioActivityVector(final SortedMap<Integer, FloatRadioActivity> values, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            RadioActivityVector
     * @param unit RadioActivityUnit; the unit of the new Relative Sparse Mutable Float RadioActivityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatRadioActivityVector(final SortedMap<Integer, Float> values, final RadioActivityUnit unit,
            final int length, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatRadioActivityVector(final FloatVectorData data, final RadioActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatRadioActivityVector instantiateType(final FloatVectorData dvd, final RadioActivityUnit unit)
    {
        return new FloatRadioActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatRadioActivityVector instantiateMutableType(final FloatVectorData dvd,
            final RadioActivityUnit unit)
    {
        return new MutableFloatRadioActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatRadioActivity instantiateScalar(final float value, final RadioActivityUnit unit)
    {
        return new FloatRadioActivity(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatRadioActivityVector toDense()
    {
        return this.data.isDense() ? (MutableFloatRadioActivityVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatRadioActivityVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatRadioActivityVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatRadioActivity Scalars from this vector.
     * @return FloatRadioActivity[]; an array of FloatRadioActivity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatRadioActivity[] toArray()
    {
        FloatRadioActivity[] array = new FloatRadioActivity[size()];
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
