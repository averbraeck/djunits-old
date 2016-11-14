package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Duration;

/**
 * Immutable Relative Duration Vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DurationVector extends AbstractDoubleVectorRel<TimeUnit, DurationVector, MutableDurationVector, Duration>
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
    public DurationVector(final double[] values, final TimeUnit unit, final StorageType storageType) throws ValueException
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
    public DurationVector(final List<Double> values, final TimeUnit unit, final StorageType storageType) throws ValueException
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
    public DurationVector(final SortedMap<Integer, Double> values, final TimeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationVector.
     * @param data an internal data object
     * @param unit the unit
     */
    DurationVector(final DoubleVectorData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DurationVector instantiateType(final DoubleVectorData dvd, final TimeUnit unit)
    {
        return new DurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDurationVector instantiateMutableType(final DoubleVectorData dvd, final TimeUnit unit)
    {
        return new MutableDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Duration instantiateScalar(final double value, final TimeUnit unit)
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
     * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative Duration vector.
     */
    public final TimeVector toAbs()
    {
        return new TimeVector(getData(), getUnit());
    }

}
