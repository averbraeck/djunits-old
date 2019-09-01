package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatCatalyticActivityVector, a vector of values with a CatalyticActivityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatCatalyticActivityVector extends
    AbstractFloatVectorRel<CatalyticActivityUnit, FloatCatalyticActivityVector, MutableFloatCatalyticActivityVector, FloatCatalyticActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatCatalyticActivityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatCatalyticActivityVector
     * @param unit CatalyticActivityUnit; the unit of the new Relative Immutable Float FloatCatalyticActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatCatalyticActivityVector(final float[] values, final CatalyticActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatCatalyticActivityVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatCatalyticActivityVector
     * @param unit CatalyticActivityUnit; the unit of the new Relative Immutable Float FloatCatalyticActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatCatalyticActivityVector(final List<Float> values, final CatalyticActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatCatalyticActivityVector.
     * @param values FloatCatalyticActivity[]; the values of the entries in the new Relative Immutable Float FloatCatalyticActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatCatalyticActivityVector(final FloatCatalyticActivity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatCatalyticActivityVector.
     * @param values List&lt;FloatCatalyticActivity&gt;; the values of the entries in the new Relative Immutable Float FloatCatalyticActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatCatalyticActivityVector(final List<FloatCatalyticActivity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatCatalyticActivityVector.
     * @param values SortedMap&lt;Integer, FloatCatalyticActivity&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatCatalyticActivityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatCatalyticActivityVector(final SortedMap<Integer, FloatCatalyticActivity> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatCatalyticActivityVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float FloatCatalyticActivityVector
     * @param unit CatalyticActivityUnit; the unit of the new Relative Sparse Mutable Float FloatCatalyticActivityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatCatalyticActivityVector(final SortedMap<Integer, Float> values, final CatalyticActivityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatCatalyticActivityVector(final FloatVectorData data, final CatalyticActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatCatalyticActivityVector instantiateType(final FloatVectorData dvd, final CatalyticActivityUnit unit)
    {
        return new FloatCatalyticActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatCatalyticActivityVector instantiateMutableType(final FloatVectorData dvd, final CatalyticActivityUnit unit)
    {
        return new MutableFloatCatalyticActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatCatalyticActivity instantiateScalar(final float value, final CatalyticActivityUnit unit)
    {
        return new FloatCatalyticActivity(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatCatalyticActivityVector toDense()
    {
        return this.data.isDense() ? (FloatCatalyticActivityVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatCatalyticActivityVector toSparse()
    {
        return this.data.isSparse() ? (FloatCatalyticActivityVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatCatalyticActivity Scalars from this vector.
     * @return FloatCatalyticActivity[]; an array of FloatCatalyticActivity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatCatalyticActivity[] toArray()
    {
        FloatCatalyticActivity[] array = new FloatCatalyticActivity[size()];
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

