package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.LinearDensityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatLinearDensity;

/**
 * Mutable Float LinearDensityVector, a vector of values with a LinearDensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.243Z")
public class MutableFloatLinearDensityVector extends AbstractMutableFloatVectorRel<LinearDensityUnit, FloatLinearDensityVector,
        MutableFloatLinearDensityVector, FloatLinearDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float LinearDensityVector
     * @param unit LinearDensityUnit; the unit of the new Relative Immutable Float LinearDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLinearDensityVector(final float[] values, final LinearDensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float LinearDensityVector
     * @param unit LinearDensityUnit; the unit of the new Relative Immutable Float LinearDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLinearDensityVector(final List<Float> values, final LinearDensityUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values FloatLinearDensity[]; the values of the entries in the new Relative Immutable Float LinearDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLinearDensityVector(final FloatLinearDensity[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values List&lt;FloatLinearDensity&gt;; the values of the entries in the new Relative Immutable Float
     *            LinearDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLinearDensityVector(final List<FloatLinearDensity> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values SortedMap&lt;Integer, FloatLinearDensity&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float LinearDensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLinearDensityVector(final SortedMap<Integer, FloatLinearDensity> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LinearDensityVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            LinearDensityVector
     * @param unit LinearDensityUnit; the unit of the new Relative Sparse Mutable Float LinearDensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLinearDensityVector(final SortedMap<Integer, Float> values, final LinearDensityUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
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

    /**
     * Return an array of FloatLinearDensity Scalars from this vector.
     * @return FloatLinearDensity[]; an array of FloatLinearDensity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatLinearDensity[] toArray()
    {
        FloatLinearDensity[] array = new FloatLinearDensity[size()];
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
