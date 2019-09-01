package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.AreaUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatArea;

/**
 * Immutable Float FloatAreaVector, a vector of values with a AreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatAreaVector extends AbstractFloatVectorRel<AreaUnit, FloatAreaVector, MutableFloatAreaVector, FloatArea>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatAreaVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatAreaVector
     * @param unit AreaUnit; the unit of the new Relative Immutable Float FloatAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAreaVector(final float[] values, final AreaUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAreaVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatAreaVector
     * @param unit AreaUnit; the unit of the new Relative Immutable Float FloatAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAreaVector(final List<Float> values, final AreaUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAreaVector.
     * @param values FloatArea[]; the values of the entries in the new Relative Immutable Float FloatAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAreaVector(final FloatArea[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAreaVector.
     * @param values List&lt;FloatArea&gt;; the values of the entries in the new Relative Immutable Float FloatAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAreaVector(final List<FloatArea> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAreaVector.
     * @param values SortedMap&lt;Integer, FloatArea&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatAreaVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAreaVector(final SortedMap<Integer, FloatArea> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAreaVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatAreaVector
     * @param unit AreaUnit; the unit of the new Relative Sparse Mutable Float FloatAreaVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAreaVector(final SortedMap<Integer, Float> values, final AreaUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatAreaVector(final FloatVectorData data, final AreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAreaVector instantiateType(final FloatVectorData dvd, final AreaUnit unit)
    {
        return new FloatAreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAreaVector instantiateMutableType(final FloatVectorData dvd, final AreaUnit unit)
    {
        return new MutableFloatAreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatArea instantiateScalar(final float value, final AreaUnit unit)
    {
        return new FloatArea(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAreaVector toDense()
    {
        return this.data.isDense() ? (FloatAreaVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAreaVector toSparse()
    {
        return this.data.isSparse() ? (FloatAreaVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatArea Scalars from this vector.
     * @return FloatArea[]; an array of FloatArea Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatArea[] toArray()
    {
        FloatArea[] array = new FloatArea[size()];
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
