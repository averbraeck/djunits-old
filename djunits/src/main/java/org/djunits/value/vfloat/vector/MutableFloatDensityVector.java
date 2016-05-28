package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DensityUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDensity;

/**
 * Mutable FloatDensityVector, a vector of values with a DensityUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatDensityVector extends
        MutableTypedFloatVectorRel<DensityUnit, FloatDensityVector, MutableFloatDensityVector, FloatDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatDensityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatDensityVector
     * @param unit U; the unit of the new Relative Immutable FloatDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDensityVector(final float[] values, final DensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDensityVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatDensityVector
     * @param unit U; the unit of the new Relative Immutable FloatDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDensityVector(final List<Float> values, final DensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDensityVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDensityVector(final FloatDensity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDensityVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDensityVector(final List<FloatDensity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDensityVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatDensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDensityVector(final SortedMap<Integer, FloatDensity> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDensityVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatDensityVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatDensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDensityVector(final SortedMap<Integer, Float> values, final DensityUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatDensityVector(final FloatVectorData data, final DensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDensityVector instantiateType(final FloatVectorData dvd, final DensityUnit unit)
    {
        return new FloatDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDensityVector instantiateMutableType(final FloatVectorData dvd, final DensityUnit unit)
    {
        return new MutableFloatDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDensity get(final int index) throws ValueException
    {
        return new FloatDensity(getInUnit(index, getUnit()), getUnit());
    }

}
