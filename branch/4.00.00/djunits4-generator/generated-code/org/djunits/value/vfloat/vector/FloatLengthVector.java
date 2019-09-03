package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Relative FloatLength Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.212Z")
public class FloatLengthVector extends AbstractFloatVectorRel<LengthUnit, FloatLengthVector, MutableFloatLengthVector, FloatLength>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatLengthVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatLengthVector
     * @param unit LengthUnit; the unit of the new Relative Immutable FloatLengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLengthVector(final float[] values, final LengthUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLengthVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable FloatLengthVector
     * @param unit LengthUnit; the unit of the new Relative Immutable FloatLengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLengthVector(final List<Float> values, final LengthUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLengthVector.
     * @param values FloatLength[]; the values of the entries in the new Relative Immutable FloatLengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLengthVector(final FloatLength[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLengthVector.
     * @param values List&lt;FloatLength&gt;; the values of the entries in the new Relative Immutable FloatLengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLengthVector(final List<FloatLength> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLengthVector.
     * @param values SortedMap&lt;Integer, FloatLength&gt;; the values of the entries in the new Relative Sparse Mutable FloatLengthVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLengthVector(final SortedMap<Integer, FloatLength> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLengthVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable FloatLengthVector
     * @param unit LengthUnit; the unit of the new Relative Sparse Mutable FloatLengthVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLengthVector(final SortedMap<Integer, Float> values, final LengthUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLengthVector.
     * @param data FloatVectorData; an internal data object
     * @param unit LengthUnit; the unit
     */
    FloatLengthVector(final FloatVectorData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLengthVector instantiateType(final FloatVectorData dvd, final LengthUnit unit)
    {
        return new FloatLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLengthVector
        instantiateMutableType(final FloatVectorData dvd, final LengthUnit unit)
    {
        return new MutableFloatLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLength instantiateScalar(final float value, final LengthUnit unit)
    {
        return new FloatLength(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatLengthVector toDense()
    {
        return this.data.isDense() ? (FloatLengthVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLengthVector toSparse()
    {
        return this.data.isSparse() ? (FloatLengthVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatLength Scalars from this vector.
     * @return FloatLength[]; an array of FloatLength Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatLength[] toArray()
    {
        FloatLength[] array = new FloatLength[size()];
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