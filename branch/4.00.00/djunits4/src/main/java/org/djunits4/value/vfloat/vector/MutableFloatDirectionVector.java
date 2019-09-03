package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatDirection;

/**
 * Mutable Absolute FloatDirection Vector a vector of values with a DirectionUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.197Z")
public class MutableFloatDirectionVector extends AbstractMutableFloatVectorAbs<DirectionUnit, AngleUnit, FloatDirectionVector,
        FloatAngleVector, MutableFloatDirectionVector, FloatDirection>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values float[]; the values of the entries in the new Absolute Mutable FloatDirectionVector
     * @param unit DirectionUnit; the unit of the new Absolute Mutable FloatDirectionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDirectionVector(final float[] values, final DirectionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Absolute Mutable FloatDirectionVector
     * @param unit DirectionUnit; the unit of the new Absolute Mutable FloatDirectionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDirectionVector(final List<Float> values, final DirectionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values FloatDirection[]; the values of the entries in the new Absolute Mutable FloatDirectionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDirectionVector(final FloatDirection[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values List&lt;FloatDirection&gt;; the values of the entries in the new Absolute Mutable FloatDirectionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDirectionVector(final List<FloatDirection> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values SortedMap&lt;Integer, FloatDirection&gt;; the values of the entries in the new Absolute Sparse Mutable
     *            FloatDirectionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDirectionVector(final SortedMap<Integer, FloatDirection> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Absolute Sparse Mutable
     *            FloatDirectionVector
     * @param unit DirectionUnit; the unit of the new Absolute Sparse Mutable FloatDirectionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDirectionVector(final SortedMap<Integer, Float> values, final DirectionUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatDirectionVector(final FloatVectorData data, final DirectionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDirectionVector instantiateTypeAbs(final FloatVectorData dvd, final DirectionUnit unit)
    {
        return new FloatDirectionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleVector instantiateTypeRel(final FloatVectorData dvd, final AngleUnit unit)
    {
        return new FloatAngleVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDirectionVector instantiateMutableType(final FloatVectorData dvd, final DirectionUnit unit)
    {
        return new MutableFloatDirectionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDirection instantiateScalar(final float value, final DirectionUnit unit)
    {
        return new FloatDirection(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDirectionVector toDense()
    {
        return this.data.isDense() ? (MutableFloatDirectionVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDirectionVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatDirectionVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatDirection Scalars from this vector.
     * @return FloatDirection[]; an array of FloatDirection Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatDirection[] toArray()
    {
        FloatDirection[] array = new FloatDirection[size()];
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
