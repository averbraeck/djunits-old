package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AccelerationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAcceleration;

/**
 * Immutable FloatAccelerationVector, a vector of values with a AccelerationUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAccelerationVector extends
    TypedFloatVectorRel<AccelerationUnit, FloatAccelerationVector, MutableFloatAccelerationVector, FloatAcceleration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatAccelerationVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatAccelerationVector
     * @param unit U; the unit of the new Relative Immutable FloatAccelerationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAccelerationVector(final float[] values, final AccelerationUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAccelerationVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatAccelerationVector
     * @param unit U; the unit of the new Relative Immutable FloatAccelerationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAccelerationVector(final List<Float> values, final AccelerationUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAccelerationVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatAccelerationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAccelerationVector(final FloatAcceleration[] values, final StorageType storageType)
        throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAccelerationVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatAccelerationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAccelerationVector(final List<FloatAcceleration> values, final StorageType storageType)
        throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAccelerationVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatAccelerationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAccelerationVector(final SortedMap<Integer, FloatAcceleration> values, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAccelerationVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatAccelerationVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatAccelerationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAccelerationVector(final SortedMap<Integer, Float> values, final AccelerationUnit unit,
        final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatAccelerationVector(final FloatVectorData data, final AccelerationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAccelerationVector instantiateType(final FloatVectorData dvd, final AccelerationUnit unit)
    {
        return new FloatAccelerationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAccelerationVector instantiateMutableType(final FloatVectorData dvd,
        final AccelerationUnit unit)
    {
        return new MutableFloatAccelerationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration get(final int index) throws ValueException
    {
        return new FloatAcceleration(getInUnit(index, getUnit()), getUnit());
    }

}
