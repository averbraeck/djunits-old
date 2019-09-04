package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAbsoluteTemperature;

/**
 * Mutable Absolute FloatAbsoluteTemperature Vector a vector of values with a AbsoluteTemperatureUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatAbsoluteTemperatureVector
        extends AbstractMutableFloatVectorAbs<AbsoluteTemperatureUnit, TemperatureUnit, FloatAbsoluteTemperatureVector,
                FloatTemperatureVector, MutableFloatAbsoluteTemperatureVector, FloatAbsoluteTemperature>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values float[]; the values of the entries in the new Absolute Mutable FloatAbsoluteTemperatureVector
     * @param unit AbsoluteTemperatureUnit; the unit of the new Absolute Mutable FloatAbsoluteTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAbsoluteTemperatureVector(final float[] values, final AbsoluteTemperatureUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Absolute Mutable FloatAbsoluteTemperatureVector
     * @param unit AbsoluteTemperatureUnit; the unit of the new Absolute Mutable FloatAbsoluteTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAbsoluteTemperatureVector(final List<Float> values, final AbsoluteTemperatureUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values FloatAbsoluteTemperature[]; the values of the entries in the new Absolute Mutable
     *            FloatAbsoluteTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAbsoluteTemperatureVector(final FloatAbsoluteTemperature[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values List&lt;FloatAbsoluteTemperature&gt;; the values of the entries in the new Absolute Mutable
     *            FloatAbsoluteTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAbsoluteTemperatureVector(final List<FloatAbsoluteTemperature> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values SortedMap&lt;Integer, FloatAbsoluteTemperature&gt;; the values of the entries in the new Absolute Sparse
     *            Mutable FloatAbsoluteTemperatureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAbsoluteTemperatureVector(final SortedMap<Integer, FloatAbsoluteTemperature> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Absolute Sparse Mutable
     *            FloatAbsoluteTemperatureVector
     * @param unit AbsoluteTemperatureUnit; the unit of the new Absolute Sparse Mutable FloatAbsoluteTemperatureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAbsoluteTemperatureVector(final SortedMap<Integer, Float> values, final AbsoluteTemperatureUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param data FloatVectorData; an internal data object
     * @param unit AbsoluteTemperatureUnit; the unit
     */
    MutableFloatAbsoluteTemperatureVector(final FloatVectorData data, final AbsoluteTemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsoluteTemperatureVector instantiateTypeAbs(final FloatVectorData dvd,
            final AbsoluteTemperatureUnit unit)
    {
        return new FloatAbsoluteTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperatureVector instantiateTypeRel(final FloatVectorData dvd, final TemperatureUnit unit)
    {
        return new FloatTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAbsoluteTemperatureVector instantiateMutableType(final FloatVectorData dvd,
            final AbsoluteTemperatureUnit unit)
    {
        return new MutableFloatAbsoluteTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsoluteTemperature instantiateScalar(final float value, final AbsoluteTemperatureUnit unit)
    {
        return new FloatAbsoluteTemperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAbsoluteTemperatureVector toDense()
    {
        return this.data.isDense() ? (MutableFloatAbsoluteTemperatureVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAbsoluteTemperatureVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatAbsoluteTemperatureVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatAbsoluteTemperature Scalars from this vector.
     * @return FloatAbsoluteTemperature[]; an array of FloatAbsoluteTemperature Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAbsoluteTemperature[] toArray()
    {
        FloatAbsoluteTemperature[] array = new FloatAbsoluteTemperature[size()];
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
