package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTime;

/**
 * Mutable Absolute FloatTime Vector a vector of values with a TimeUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatTimeVector
        extends AbstractMutableFloatVectorAbs<TimeUnit, FloatTimeVector, FloatDurationVector, MutableFloatTimeVector, FloatTime>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatTimeVector.
     * @param values float[]; the values of the entries in the new Absolute Mutable FloatTimeVector
     * @param unit U; the unit of the new Absolute Mutable FloatTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatTimeVector(final float[] values, final TimeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatTimeVector.
     * @param values List; the values of the entries in the new Absolute Mutable FloatTimeVector
     * @param unit U; the unit of the new Absolute Mutable FloatTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatTimeVector(final List<Float> values, final TimeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatTimeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable FloatTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatTimeVector(final FloatTime[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatTimeVector.
     * @param values List; the values of the entries in the new Absolute Mutable FloatTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatTimeVector(final List<FloatTime> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatTimeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable FloatTimeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatTimeVector(final SortedMap<Integer, FloatTime> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatTimeVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatTimeVector
     * @param unit U; the unit of the new Absolute Sparse Mutable FloatTimeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatTimeVector(final SortedMap<Integer, Float> values, final TimeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatTimeVector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatTimeVector(final FloatVectorData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTimeVector instantiateTypeAbs(final FloatVectorData dvd, final TimeUnit unit)
    {
        return new FloatTimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationVector instantiateTypeRel(final FloatVectorData dvd, final TimeUnit unit)
    {
        return new FloatDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTimeVector instantiateMutableType(final FloatVectorData dvd, final TimeUnit unit)
    {
        return new MutableFloatTimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTime instantiateScalar(final float value, final TimeUnit unit)
    {
        return new FloatTime(value, unit);
    }

    /**
     * Create a dense version of this FloatVector.
     * @return the dense version of this FloatVector
     */
    public final MutableFloatTimeVector toDense()
    {
        return this.data.isDense() ? (MutableFloatTimeVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /**
     * Create a sparse version of this FloatVector.
     * @return the sparse version of this FloatVector
     */
    public final MutableFloatTimeVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatTimeVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute Time vector.
     */
    public final MutableFloatDurationVector toRel()
    {
        return new MutableFloatDurationVector(getData(), getUnit());
    }

}
