package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double VolumeVector, a vector of values with a VolumeUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class VolumeVector extends
    AbstractDoubleVectorRel<VolumeUnit, VolumeVector, MutableVolumeVector, Volume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double VolumeVector
     * @param unit VolumeUnit; the unit of the new Relative Immutable Double VolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public VolumeVector(final double[] values, final VolumeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double VolumeVector
     * @param unit VolumeUnit; the unit of the new Relative Immutable Double VolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public VolumeVector(final List<Double> values, final VolumeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values Volume[]; the values of the entries in the new Relative Immutable Double VolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public VolumeVector(final Volume[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values List&lt;Volume&gt;; the values of the entries in the new Relative Immutable Double VolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public VolumeVector(final List<Volume> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values SortedMap&lt;Integer, Volume&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            VolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public VolumeVector(final SortedMap<Integer, Volume> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double VolumeVector
     * @param unit VolumeUnit; the unit of the new Relative Sparse Mutable Double VolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public VolumeVector(final SortedMap<Integer, Double> values, final VolumeUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit VolumeUnit; the unit
     */
    VolumeVector(final DoubleVectorData data, final VolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final VolumeVector instantiateType(final DoubleVectorData dvd, final VolumeUnit unit)
    {
        return new VolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableVolumeVector instantiateMutableType(final DoubleVectorData dvd, final VolumeUnit unit)
    {
        return new MutableVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Volume instantiateScalar(final double value, final VolumeUnit unit)
    {
        return new Volume(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final VolumeVector toDense()
    {
        return this.data.isDense() ? (VolumeVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final VolumeVector toSparse()
    {
        return this.data.isSparse() ? (VolumeVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of Volume Scalars from this vector.
     * @return Volume[]; an array of Volume Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Volume[] toArray()
    {
        Volume[] array = new Volume[size()];
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
