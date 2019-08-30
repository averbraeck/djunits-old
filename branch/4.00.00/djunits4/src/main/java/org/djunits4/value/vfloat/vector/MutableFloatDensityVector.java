package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.DensityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatDensity;

/**
 * Mutable Float DensityVector, a vector of values with a DensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatDensityVector
        extends AbstractMutableFloatVectorRel<DensityUnit, FloatDensityVector, MutableFloatDensityVector, FloatDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float DensityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float DensityVector
     * @param unit DensityUnit; the unit of the new Relative Immutable Float DensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDensityVector(final float[] values, final DensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DensityVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float DensityVector
     * @param unit DensityUnit; the unit of the new Relative Immutable Float DensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDensityVector(final List<Float> values, final DensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DensityVector.
     * @param values FloatDensity[]; the values of the entries in the new Relative Immutable Float DensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDensityVector(final FloatDensity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DensityVector.
     * @param values List&lt;FloatDensity&gt;; the values of the entries in the new Relative Immutable Float DensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDensityVector(final List<FloatDensity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DensityVector.
     * @param values SortedMap&lt;Integer, FloatDensity&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            DensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDensityVector(final SortedMap<Integer, FloatDensity> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DensityVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            DensityVector
     * @param unit DensityUnit; the unit of the new Relative Sparse Mutable Float DensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDensityVector(final SortedMap<Integer, Float> values, final DensityUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit DensityUnit; the unit
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
    protected final FloatDensity instantiateScalar(final float value, final DensityUnit unit)
    {
        return new FloatDensity(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDensityVector toDense()
    {
        return this.data.isDense() ? (MutableFloatDensityVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDensityVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatDensityVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatDensity Scalars from this vector.
     * @return FloatDensity[]; an array of FloatDensity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatDensity[] toArray()
    {
        FloatDensity[] array = new FloatDensity[size()];
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
