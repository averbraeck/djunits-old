package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LinearDensityUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLinearDensity;

/**
 * Mutable Float LinearDensityVector, a vector of values with a LinearDensityUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatLinearDensityVector extends AbstractMutableFloatVectorRel<LinearDensityUnit, FloatLinearDensityVector,
        MutableFloatLinearDensityVector, FloatLinearDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float LinearDensityVector
     * @param unit U; the unit of the new Relative Immutable Float LinearDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLinearDensityVector(final float[] values, final LinearDensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Float LinearDensityVector
     * @param unit U; the unit of the new Relative Immutable Float LinearDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLinearDensityVector(final List<Float> values, final LinearDensityUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            LinearDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLinearDensityVector(final FloatLinearDensity[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Float LinearDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLinearDensityVector(final List<FloatLinearDensity> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            LinearDensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLinearDensityVector(final SortedMap<Integer, FloatLinearDensity> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float LinearDensityVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float LinearDensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLinearDensityVector(final SortedMap<Integer, Float> values, final LinearDensityUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatLinearDensityVector(final FloatVectorData data, final LinearDensityUnit unit)
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
    protected final FloatLinearDensity instantiateScalar(final float value, final LinearDensityUnit unit)
    {
        return new FloatLinearDensity(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLinearDensityVector toDense()
    {
        return this.data.isDense() ? (MutableFloatLinearDensityVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLinearDensityVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatLinearDensityVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}