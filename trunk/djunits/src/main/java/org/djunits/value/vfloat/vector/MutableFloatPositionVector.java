package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatPosition;

/**
 * Mutable Absolute FloatPosition Vector a vector of values with a PositionUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatPositionVector extends AbstractMutableFloatVectorAbs<PositionUnit, LengthUnit, FloatPositionVector,
        FloatLengthVector, MutableFloatPositionVector, FloatPosition>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values float[]; the values of the entries in the new Absolute Mutable FloatPositionVector
     * @param unit PositionUnit; the unit of the new Absolute Mutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPositionVector(final float[] values, final PositionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Absolute Mutable FloatPositionVector
     * @param unit PositionUnit; the unit of the new Absolute Mutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPositionVector(final List<Float> values, final PositionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values FloatPosition[]; the values of the entries in the new Absolute Mutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPositionVector(final FloatPosition[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values List&lt;FloatPosition&gt;; the values of the entries in the new Absolute Mutable FloatPositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPositionVector(final List<FloatPosition> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values SortedMap&lt;Integer, FloatPosition&gt;; the values of the entries in the new Absolute Sparse Mutable
     *            FloatPositionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPositionVector(final SortedMap<Integer, FloatPosition> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Absolute Sparse Mutable
     *            FloatPositionVector
     * @param unit PositionUnit; the unit of the new Absolute Sparse Mutable FloatPositionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPositionVector(final SortedMap<Integer, Float> values, final PositionUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatPositionVector.
     * @param data FloatVectorData; an internal data object
     * @param unit PositionUnit; the unit
     */
    MutableFloatPositionVector(final FloatVectorData data, final PositionUnit unit)
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
    public final MutableFloatPositionVector toDense()
    {
        return this.data.isDense() ? (MutableFloatPositionVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPositionVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatPositionVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
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
