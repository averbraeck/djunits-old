package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDuration;

/**
 * Relative FloatDuration Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDurationVector extends
        TypedFloatVectorRel<TimeUnit, FloatDurationVector, MutableFloatDurationVector, FloatDuration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatDurationVector
     * @param unit U; the unit of the new Relative Immutable FloatDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDurationVector(final float[] values, final TimeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatDurationVector
     * @param unit U; the unit of the new Relative Immutable FloatDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDurationVector(final List<Float> values, final TimeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable FloatDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDurationVector(final FloatDuration[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDurationVector(final List<FloatDuration> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable
     *            FloatDurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDurationVector(final SortedMap<Integer, FloatDuration> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatDurationVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatDurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDurationVector(final SortedMap<Integer, Float> values, final TimeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDurationVector.
     * @param data an internal data object
     * @param unit the unit
     */
    FloatDurationVector(final FloatVectorData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDurationVector instantiateType(final FloatVectorData dvd, final TimeUnit unit)
    {
        return new FloatDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDurationVector instantiateMutableType(final FloatVectorData dvd, final TimeUnit unit)
    {
        return new MutableFloatDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDuration get(final int index) throws ValueException
    {
        return new FloatDuration(getInUnit(index, getUnit()), getUnit());
    }

    /**
     * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative FloatDuration vector.
     */
    public final FloatTimeVector toAbs()
    {
        return new FloatTimeVector(getData(), getUnit());
    }

}
