package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatPosition;

/**
 * Mutable Absolute FloatPosition Vector a vector of values with a PositionUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatPositionVector extends AbstractMutableFloatVectorAbs<PositionUnit, LengthUnit, FloatPositionVector,
        FloatLengthVector, MutableFloatPositionVector, FloatPosition>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values float[]; the values of the entries in the new Absolute Mutable FloatPositionVector
     * @param unit PositionUnit; the unit of the new Absolute Mutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatPositionVector(final float[] values, final PositionUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Absolute Mutable FloatPositionVector
     * @param unit PositionUnit; the unit of the new Absolute Mutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatPositionVector(final List<Float> values, final PositionUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values FloatPosition[]; the values of the entries in the new Absolute Mutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatPositionVector(final FloatPosition[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values List&lt;FloatPosition&gt;; the values of the entries in the new Absolute Mutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatPositionVector(final List<FloatPosition> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values SortedMap&lt;Integer, FloatPosition&gt;; the values of the entries in the new Absolute Sparse Mutable
     *            FloatPositionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatPositionVector(final SortedMap<Integer, FloatPosition> values, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Absolute Sparse Mutable
     *            FloatPositionVector
     * @param unit PositionUnit; the unit of the new Absolute Sparse Mutable FloatPositionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatPositionVector(final SortedMap<Integer, Float> values, final PositionUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatPositionVector(final FloatVectorData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPositionVector instantiateTypeAbs(final FloatVectorData dvd, final PositionUnit unit)
    {
        return new FloatPositionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLengthVector instantiateTypeRel(final FloatVectorData dvd, final LengthUnit unit)
    {
        return new FloatLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPositionVector instantiateMutableType(final FloatVectorData dvd, final PositionUnit unit)
    {
        return new MutableFloatPositionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPosition instantiateScalar(final float value, final PositionUnit unit)
    {
        return new FloatPosition(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPositionVector toDense()
    {
        return this.data.isDense() ? (MutableFloatPositionVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPositionVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatPositionVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatPosition Scalars from this vector.
     * @return FloatPosition[]; an array of FloatPosition Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatPosition[] toArray()
    {
        FloatPosition[] array = new FloatPosition[size()];
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
