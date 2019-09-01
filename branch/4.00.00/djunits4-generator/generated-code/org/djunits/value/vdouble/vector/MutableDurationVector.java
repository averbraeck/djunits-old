package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Relative Duration Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableDurationVector extends AbstractMutableDoubleVectorRel<DurationUnit, DurationVector, MutableDurationVector, Duration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable Double DurationVector.
     * @param values double[]; the values of the entries in the new Relative Mutable Double DurationVector
     * @param unit DurationUnit; the unit of the new Relative Mutable Double DurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDurationVector(final double[] values, final DurationUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double DurationVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Mutable Double DurationVector
     * @param unit DurationUnit; the unit of the new Relative Mutable Double DurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDurationVector(final List<Double> values, final DurationUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double DurationVector.
     * @param values Duration[]; the values of the entries in the new Relative Mutable Double DurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDurationVector(final Duration[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double DurationVector.
     * @param values List&lt;Duration&gt;; the values of the entries in the new Relative Mutable Double DurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDurationVector(final List<Duration> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double DurationVector.
     * @param values SortedMap&lt;Integer, Duration&gt;[]; the values of the entries in the new Relative Sparse Mutable Double DurationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDurationVector(final SortedMap<Integer, Duration> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Double DurationVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double DurationVector
     * @param unit DurationUnit; the unit of the new Relative Sparse Mutable Double DurationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDurationVector(final SortedMap<Integer, Double> values, final DurationUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Double DurationVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit DurationUnit; the unit
     */
    MutableDurationVector(final DoubleVectorData data, final DurationUnit unit)
    {
        super(data, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    protected final DurationVector instantiateType(final DoubleVectorData dvd, final DurationUnit unit)
    {
        return new DurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDurationVector instantiateMutableType(final DoubleVectorData dvd, final DurationUnit unit)
    {
        return new MutableDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Duration instantiateScalar(final double value, final DurationUnit unit)
    {
        return new Duration(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableDurationVector toDense()
    {
        return this.data.isDense() ? (MutableDurationVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDurationVector toSparse()
    {
        return this.data.isSparse() ? (MutableDurationVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }
 
    /**
     * Return an array of Duration Scalars from this vector.
     * @return Duration[]; an array of Duration Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Duration[] toArray()
    {
        Duration[] array = new Duration[size()];
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