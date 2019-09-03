package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatMagneticFluxDensityVector, a vector of values with a MagneticFluxDensityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.228Z")
public class FloatMagneticFluxDensityVector extends
    AbstractFloatVectorRel<MagneticFluxDensityUnit, FloatMagneticFluxDensityVector, MutableFloatMagneticFluxDensityVector, FloatMagneticFluxDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxDensityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMagneticFluxDensityVector
     * @param unit MagneticFluxDensityUnit; the unit of the new Relative Immutable Float FloatMagneticFluxDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMagneticFluxDensityVector(final float[] values, final MagneticFluxDensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxDensityVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatMagneticFluxDensityVector
     * @param unit MagneticFluxDensityUnit; the unit of the new Relative Immutable Float FloatMagneticFluxDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMagneticFluxDensityVector(final List<Float> values, final MagneticFluxDensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxDensityVector.
     * @param values FloatMagneticFluxDensity[]; the values of the entries in the new Relative Immutable Float FloatMagneticFluxDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMagneticFluxDensityVector(final FloatMagneticFluxDensity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxDensityVector.
     * @param values List&lt;FloatMagneticFluxDensity&gt;; the values of the entries in the new Relative Immutable Float FloatMagneticFluxDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMagneticFluxDensityVector(final List<FloatMagneticFluxDensity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxDensityVector.
     * @param values SortedMap&lt;Integer, FloatMagneticFluxDensity&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatMagneticFluxDensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMagneticFluxDensityVector(final SortedMap<Integer, FloatMagneticFluxDensity> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxDensityVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float FloatMagneticFluxDensityVector
     * @param unit MagneticFluxDensityUnit; the unit of the new Relative Sparse Mutable Float FloatMagneticFluxDensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMagneticFluxDensityVector(final SortedMap<Integer, Float> values, final MagneticFluxDensityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatMagneticFluxDensityVector(final FloatVectorData data, final MagneticFluxDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFluxDensityVector instantiateType(final FloatVectorData dvd, final MagneticFluxDensityUnit unit)
    {
        return new FloatMagneticFluxDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMagneticFluxDensityVector instantiateMutableType(final FloatVectorData dvd, final MagneticFluxDensityUnit unit)
    {
        return new MutableFloatMagneticFluxDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFluxDensity instantiateScalar(final float value, final MagneticFluxDensityUnit unit)
    {
        return new FloatMagneticFluxDensity(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxDensityVector toDense()
    {
        return this.data.isDense() ? (FloatMagneticFluxDensityVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxDensityVector toSparse()
    {
        return this.data.isSparse() ? (FloatMagneticFluxDensityVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatMagneticFluxDensity Scalars from this vector.
     * @return FloatMagneticFluxDensity[]; an array of FloatMagneticFluxDensity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMagneticFluxDensity[] toArray()
    {
        FloatMagneticFluxDensity[] array = new FloatMagneticFluxDensity[size()];
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

