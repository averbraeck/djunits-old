package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Duration;

/**
 * Immutable Relative Duration Vector.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DurationVector extends AbstractDoubleVectorRel<DurationUnit, DurationVector, MutableDurationVector, Duration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double DurationVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double DurationVector
     * @param unit U; the unit of the new Relative Immutable Double DurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DurationVector(final double[] values, final DurationUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationVector.
     * @param values List; the values of the entries in the new Relative Immutable Double DurationVector
     * @param unit U; the unit of the new Relative Immutable Double DurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DurationVector(final List<Double> values, final DurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double DurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DurationVector(final Duration[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationVector.
     * @param values List; the values of the entries in the new Relative Immutable Double DurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DurationVector(final List<Duration> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            DurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DurationVector(final SortedMap<Integer, Duration> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double DurationVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double DurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DurationVector(final SortedMap<Integer, Double> values, final DurationUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationVector.
     * @param data an internal data object
     * @param unit the unit
     */
    DurationVector(final DoubleVectorData data, final DurationUnit unit)
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
    public final DurationVector toDense()
    {
        return this.data.isDense() ? (DurationVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final DurationVector toSparse()
    {
        return this.data.isSparse() ? (DurationVector) this : instantiateType(this.data.toSparse(), getUnit());
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
