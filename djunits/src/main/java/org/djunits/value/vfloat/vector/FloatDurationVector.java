package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDuration;

/**
 * Relative FloatDuration Vector.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDurationVector
        extends AbstractFloatVectorRel<DurationUnit, FloatDurationVector, MutableFloatDurationVector, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatDurationVector
     * @param unit DurationUnit; the unit of the new Relative Immutable FloatDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDurationVector(final float[] values, final DurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable FloatDurationVector
     * @param unit DurationUnit; the unit of the new Relative Immutable FloatDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDurationVector(final List<Float> values, final DurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values FloatDuration[]; the values of the entries in the new Relative Immutable FloatDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDurationVector(final FloatDuration[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values List&lt;FloatDuration&gt;; the values of the entries in the new Relative Immutable FloatDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDurationVector(final List<FloatDuration> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values SortedMap&lt;Integer, FloatDuration&gt;; the values of the entries in the new Relative Sparse Mutable
     *            FloatDurationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDurationVector(final SortedMap<Integer, FloatDuration> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable
     *            FloatDurationVector
     * @param unit DurationUnit; the unit of the new Relative Sparse Mutable FloatDurationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDurationVector(final SortedMap<Integer, Float> values, final DurationUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param data FloatVectorData; an internal data object
     * @param unit DurationUnit; the unit
     */
    FloatDurationVector(final FloatVectorData data, final DurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationVector instantiateType(final FloatVectorData dvd, final DurationUnit unit)
    {
        return new FloatDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDurationVector instantiateMutableType(final FloatVectorData dvd, final DurationUnit unit)
    {
        return new MutableFloatDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDuration instantiateScalar(final float value, final DurationUnit unit)
    {
        return new FloatDuration(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDurationVector toDense()
    {
        return this.data.isDense() ? (FloatDurationVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDurationVector toSparse()
    {
        return this.data.isSparse() ? (FloatDurationVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatDuration Scalars from this vector.
     * @return FloatDuration[]; an array of FloatDuration Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatDuration[] toArray()
    {
        FloatDuration[] array = new FloatDuration[size()];
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
