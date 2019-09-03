package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatAngleSolidVector, a vector of values with a AngleSolidUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.212Z")
public class FloatAngleSolidVector extends
    AbstractFloatVectorRel<AngleSolidUnit, FloatAngleSolidVector, MutableFloatAngleSolidVector, FloatAngleSolid>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatAngleSolidVector
     * @param unit AngleSolidUnit; the unit of the new Relative Immutable Float FloatAngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleSolidVector(final float[] values, final AngleSolidUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatAngleSolidVector
     * @param unit AngleSolidUnit; the unit of the new Relative Immutable Float FloatAngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleSolidVector(final List<Float> values, final AngleSolidUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values FloatAngleSolid[]; the values of the entries in the new Relative Immutable Float FloatAngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleSolidVector(final FloatAngleSolid[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values List&lt;FloatAngleSolid&gt;; the values of the entries in the new Relative Immutable Float FloatAngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleSolidVector(final List<FloatAngleSolid> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values SortedMap&lt;Integer, FloatAngleSolid&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatAngleSolidVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleSolidVector(final SortedMap<Integer, FloatAngleSolid> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float FloatAngleSolidVector
     * @param unit AngleSolidUnit; the unit of the new Relative Sparse Mutable Float FloatAngleSolidVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleSolidVector(final SortedMap<Integer, Float> values, final AngleSolidUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatAngleSolidVector(final FloatVectorData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolidVector instantiateType(final FloatVectorData dvd, final AngleSolidUnit unit)
    {
        return new FloatAngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAngleSolidVector instantiateMutableType(final FloatVectorData dvd, final AngleSolidUnit unit)
    {
        return new MutableFloatAngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolid instantiateScalar(final float value, final AngleSolidUnit unit)
    {
        return new FloatAngleSolid(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolidVector toDense()
    {
        return this.data.isDense() ? (FloatAngleSolidVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolidVector toSparse()
    {
        return this.data.isSparse() ? (FloatAngleSolidVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatAngleSolid Scalars from this vector.
     * @return FloatAngleSolid[]; an array of FloatAngleSolid Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAngleSolid[] toArray()
    {
        FloatAngleSolid[] array = new FloatAngleSolid[size()];
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

