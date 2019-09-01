package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatDimensionless;

/**
 * Immutable Float FloatDimensionlessVector, a vector of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatDimensionlessVector extends
        AbstractFloatVectorRel<DimensionlessUnit, FloatDimensionlessVector, MutableFloatDimensionlessVector, FloatDimensionless>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatDimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Float FloatDimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDimensionlessVector(final float[] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatDimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Float FloatDimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDimensionlessVector(final List<Float> values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values FloatDimensionless[]; the values of the entries in the new Relative Immutable Float
     *            FloatDimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDimensionlessVector(final FloatDimensionless[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values List&lt;FloatDimensionless&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatDimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDimensionlessVector(final List<FloatDimensionless> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values SortedMap&lt;Integer, FloatDimensionless&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float FloatDimensionlessVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDimensionlessVector(final SortedMap<Integer, FloatDimensionless> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatDimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Sparse Mutable Float FloatDimensionlessVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDimensionlessVector(final SortedMap<Integer, Float> values, final DimensionlessUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    FloatDimensionlessVector(final FloatVectorData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionlessVector instantiateType(final FloatVectorData dvd, final DimensionlessUnit unit)
    {
        return new FloatDimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDimensionlessVector instantiateMutableType(final FloatVectorData dvd,
            final DimensionlessUnit unit)
    {
        return new MutableFloatDimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionless instantiateScalar(final float value, final DimensionlessUnit unit)
    {
        return new FloatDimensionless(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector toDense()
    {
        return this.data.isDense() ? (FloatDimensionlessVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector toSparse()
    {
        return this.data.isSparse() ? (FloatDimensionlessVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatDimensionless Scalars from this vector.
     * @return FloatDimensionless[]; an array of FloatDimensionless Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatDimensionless[] toArray()
    {
        FloatDimensionless[] array = new FloatDimensionless[size()];
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
