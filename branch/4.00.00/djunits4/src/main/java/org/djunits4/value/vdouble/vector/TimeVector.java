package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Time;

/**
 * Immutable Absolute Time Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class TimeVector
        extends AbstractDoubleVectorAbs<TimeUnit, DurationUnit, TimeVector, DurationVector, MutableTimeVector, Time>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values double[]; the values of the entries in the new Absolute Immutable Double TimeVector
     * @param unit TimeUnit; the unit of the new Absolute Immutable Double TimeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TimeVector(final double[] values, final TimeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Absolute Immutable Double TimeVector
     * @param unit TimeUnit; the unit of the new Absolute Immutable Double TimeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TimeVector(final List<Double> values, final TimeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values Time[]; the values of the entries in the new Absolute Immutable Double TimeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TimeVector(final Time[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values List&lt;Time&gt;; the values of the entries in the new Absolute Immutable Double TimeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TimeVector(final List<Time> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values SortedMap&lt;Integer, Time&gt;; the values of the entries in the new Absolute Sparse Mutable Double
     *            TimeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TimeVector(final SortedMap<Integer, Time> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Absolute Sparse Mutable Double
     *            TimeVector
     * @param unit TimeUnit; the unit of the new Absolute Sparse Mutable Double TimeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TimeVector(final SortedMap<Integer, Double> values, final TimeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit TimeUnit; the unit
     */
    TimeVector(final DoubleVectorData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final TimeVector instantiateTypeAbs(final DoubleVectorData dvd, final TimeUnit unit)
    {
        return new TimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DurationVector instantiateTypeRel(final DoubleVectorData dvd, final DurationUnit unit)
    {
        return new DurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableTimeVector instantiateMutableType(final DoubleVectorData dvd, final TimeUnit unit)
    {
        return new MutableTimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Time instantiateScalar(final double value, final TimeUnit unit)
    {
        return new Time(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final TimeVector toDense()
    {
        return this.data.isDense() ? (TimeVector) this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final TimeVector toSparse()
    {
        return this.data.isSparse() ? (TimeVector) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Time Scalars from this vector.
     * @return Time[]; an array of Time Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Time[] toArray()
    {
        Time[] array = new Time[size()];
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
