package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Time;

/**
 * Immutable Absolute Time Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class TimeVector extends TypedDoubleVectorAbs<TimeUnit, TimeVector, DurationVector, MutableTimeVector, Time>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values double[]; the values of the entries in the new Absolute Immutable Double TimeVector
     * @param unit U; the unit of the new Absolute Immutable Double TimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TimeVector(final double[] values, final TimeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values List; the values of the entries in the new Absolute Immutable Double TimeVector
     * @param unit U; the unit of the new Absolute Immutable Double TimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TimeVector(final List<Double> values, final TimeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable Double TimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TimeVector(final Time[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values List; the values of the entries in the new Absolute Immutable Double TimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TimeVector(final List<Time> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double TimeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TimeVector(final SortedMap<Integer, Time> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double TimeVector
     * @param unit U; the unit of the new Absolute Sparse Mutable Double TimeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TimeVector(final SortedMap<Integer, Double> values, final TimeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TimeVector.
     * @param data an internal data object
     * @param unit the unit
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
    protected final DurationVector instantiateTypeRel(final DoubleVectorData dvd, final TimeUnit unit)
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
    public final Time get(final int index) throws ValueException
    {
        return new Time(getInUnit(index, getUnit()), getUnit());
    }

    /**
     * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute Time vector.
     */
    public final DurationVector toRel()
    {
        return new DurationVector(getData(), getUnit());
    }

}
