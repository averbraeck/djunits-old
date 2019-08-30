package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Relative FloatDuration Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatDurationVector extends AbstractMutableFloatVectorRel<DurationUnit, FloatDurationVector, MutableFloatDurationVector, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatDurationVector.
     * @param values float[]; the values of the entries in the new Relative Mutable FloatDurationVector
     * @param unit U; the unit of the new Relative Mutable FloatDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDurationVector(final float[] values, final DurationUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatDurationVector.
     * @param values List; the values of the entries in the new Relative Mutable FloatDurationVector
     * @param unit U; the unit of the new Relative Mutable FloatDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDurationVector(final List<Float> values, final DurationUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatDurationVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable FloatDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDurationVector(final FloatDuration[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatDurationVector.
     * @param values List; the values of the entries in the new Relative Mutable FloatDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDurationVector(final List<FloatDuration> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatDurationVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable FloatDurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDurationVector(final SortedMap<Integer, FloatDuration> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatDurationVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatDurationVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatDurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDurationVector(final SortedMap<Integer, Float> values, final DurationUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatDurationVector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatDurationVector(final FloatVectorData data, final DurationUnit unit)
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
    public final MutableFloatDurationVector toDense()
    {
        return this.data.isDense() ? (MutableFloatDurationVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDurationVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatDurationVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
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