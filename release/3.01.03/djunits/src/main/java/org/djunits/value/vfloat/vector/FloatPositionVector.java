package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatPosition;

/**
 * Absolute FloatPosition Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatPositionVector extends AbstractFloatVectorAbs<PositionUnit, LengthUnit, FloatPositionVector,
        FloatLengthVector, MutableFloatPositionVector, FloatPosition>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable FloatPositionVector.
     * @param values float[]; the values of the entries in the new Absolute Immutable FloatPositionVector
     * @param unit PositionUnit; the unit of the new Absolute Immutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPositionVector(final float[] values, final PositionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatPositionVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Absolute Immutable FloatPositionVector
     * @param unit PositionUnit; the unit of the new Absolute Immutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPositionVector(final List<Float> values, final PositionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatPositionVector.
     * @param values FloatPosition[]; the values of the entries in the new Absolute Immutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPositionVector(final FloatPosition[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatPositionVector.
     * @param values List&lt;FloatPosition&gt;; the values of the entries in the new Absolute Immutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPositionVector(final List<FloatPosition> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatPositionVector.
     * @param values SortedMap&lt;Integer, FloatPosition&gt;; the values of the entries in the new Absolute Sparse Mutable
     *            FloatPositionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPositionVector(final SortedMap<Integer, FloatPosition> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatPositionVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Absolute Sparse Mutable
     *            FloatPositionVector
     * @param unit PositionUnit; the unit of the new Absolute Sparse Mutable FloatPositionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPositionVector(final SortedMap<Integer, Float> values, final PositionUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatPositionVector.
     * @param data FloatVectorData; an internal data object
     * @param unit PositionUnit; the unit
     */
    FloatPositionVector(final FloatVectorData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPositionVector instantiateTypeAbs(final FloatVectorData dvd, final PositionUnit unit)
    {
        return new FloatPositionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLengthVector instantiateTypeRel(final FloatVectorData dvd, final LengthUnit unit)
    {
        return new FloatLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPositionVector instantiateMutableType(final FloatVectorData dvd, final PositionUnit unit)
    {
        return new MutableFloatPositionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPosition instantiateScalar(final float value, final PositionUnit unit)
    {
        return new FloatPosition(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPositionVector toDense()
    {
        return this.data.isDense() ? (FloatPositionVector) this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPositionVector toSparse()
    {
        return this.data.isSparse() ? (FloatPositionVector) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatPosition Scalars from this vector.
     * @return FloatPosition[]; an array of FloatPosition Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatPosition[] toArray()
    {
        FloatPosition[] array = new FloatPosition[size()];
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