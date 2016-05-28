package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LinearDensityUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLinearDensity;

/**
 * Immutable FloatLinearDensityVector, a vector of values with a LinearDensityUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatLinearDensityVector extends
        TypedFloatVectorRel<LinearDensityUnit, FloatLinearDensityVector, MutableFloatLinearDensityVector, FloatLinearDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatLinearDensityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatLinearDensityVector
     * @param unit U; the unit of the new Relative Immutable FloatLinearDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLinearDensityVector(final float[] values, final LinearDensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLinearDensityVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatLinearDensityVector
     * @param unit U; the unit of the new Relative Immutable FloatLinearDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLinearDensityVector(final List<Float> values, final LinearDensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLinearDensityVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatLinearDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLinearDensityVector(final FloatLinearDensity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLinearDensityVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatLinearDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLinearDensityVector(final List<FloatLinearDensity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLinearDensityVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatLinearDensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLinearDensityVector(final SortedMap<Integer, FloatLinearDensity> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLinearDensityVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatLinearDensityVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatLinearDensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLinearDensityVector(final SortedMap<Integer, Float> values, final LinearDensityUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatLinearDensityVector(final FloatVectorData data, final LinearDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLinearDensityVector instantiateType(final FloatVectorData dvd, final LinearDensityUnit unit)
    {
        return new FloatLinearDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLinearDensityVector instantiateMutableType(final FloatVectorData dvd,
            final LinearDensityUnit unit)
    {
        return new MutableFloatLinearDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLinearDensity get(final int index) throws ValueException
    {
        return new FloatLinearDensity(getInUnit(index, getUnit()), getUnit());
    }

}
