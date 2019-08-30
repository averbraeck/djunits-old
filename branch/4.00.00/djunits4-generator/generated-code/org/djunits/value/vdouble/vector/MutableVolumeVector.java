package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double VolumeVector, a vector of values with a VolumeUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableVolumeVector extends
    AbstractMutableDoubleVectorRel<VolumeUnit, VolumeVector, MutableVolumeVector, Volume> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double VolumeVector
     * @param unit U; the unit of the new Relative Immutable Double VolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableVolumeVector(final double[] values, final VolumeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double VolumeVector
     * @param unit U; the unit of the new Relative Immutable Double VolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableVolumeVector(final List<Double> values, final VolumeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            VolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableVolumeVector(final Volume[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double VolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableVolumeVector(final List<Volume> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            VolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableVolumeVector(final SortedMap<Integer, Volume> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double VolumeVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double VolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableVolumeVector(final SortedMap<Integer, Double> values, final VolumeUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableVolumeVector(final DoubleVectorData data, final VolumeUnit unit)
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
    public final MutableVolumeVector toDense()
    {
        return this.data.isDense() ? (MutableVolumeVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector toSparse()
    {
        return this.data.isSparse() ? (MutableVolumeVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
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
