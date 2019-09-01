package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatLuminousIntensityVector, a vector of values with a LuminousIntensityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatLuminousIntensityVector extends
    AbstractFloatVectorRel<LuminousIntensityUnit, FloatLuminousIntensityVector, MutableFloatLuminousIntensityVector, FloatLuminousIntensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatLuminousIntensityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatLuminousIntensityVector
     * @param unit LuminousIntensityUnit; the unit of the new Relative Immutable Float FloatLuminousIntensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLuminousIntensityVector(final float[] values, final LuminousIntensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatLuminousIntensityVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatLuminousIntensityVector
     * @param unit LuminousIntensityUnit; the unit of the new Relative Immutable Float FloatLuminousIntensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLuminousIntensityVector(final List<Float> values, final LuminousIntensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatLuminousIntensityVector.
     * @param values FloatLuminousIntensity[]; the values of the entries in the new Relative Immutable Float FloatLuminousIntensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLuminousIntensityVector(final FloatLuminousIntensity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatLuminousIntensityVector.
     * @param values List&lt;FloatLuminousIntensity&gt;; the values of the entries in the new Relative Immutable Float FloatLuminousIntensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLuminousIntensityVector(final List<FloatLuminousIntensity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatLuminousIntensityVector.
     * @param values SortedMap&lt;Integer, FloatLuminousIntensity&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatLuminousIntensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLuminousIntensityVector(final SortedMap<Integer, FloatLuminousIntensity> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatLuminousIntensityVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float FloatLuminousIntensityVector
     * @param unit LuminousIntensityUnit; the unit of the new Relative Sparse Mutable Float FloatLuminousIntensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLuminousIntensityVector(final SortedMap<Integer, Float> values, final LuminousIntensityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatLuminousIntensityVector(final FloatVectorData data, final LuminousIntensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLuminousIntensityVector instantiateType(final FloatVectorData dvd, final LuminousIntensityUnit unit)
    {
        return new FloatLuminousIntensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLuminousIntensityVector instantiateMutableType(final FloatVectorData dvd, final LuminousIntensityUnit unit)
    {
        return new MutableFloatLuminousIntensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLuminousIntensity instantiateScalar(final float value, final LuminousIntensityUnit unit)
    {
        return new FloatLuminousIntensity(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatLuminousIntensityVector toDense()
    {
        return this.data.isDense() ? (FloatLuminousIntensityVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLuminousIntensityVector toSparse()
    {
        return this.data.isSparse() ? (FloatLuminousIntensityVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatLuminousIntensity Scalars from this vector.
     * @return FloatLuminousIntensity[]; an array of FloatLuminousIntensity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatLuminousIntensity[] toArray()
    {
        FloatLuminousIntensity[] array = new FloatLuminousIntensity[size()];
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

