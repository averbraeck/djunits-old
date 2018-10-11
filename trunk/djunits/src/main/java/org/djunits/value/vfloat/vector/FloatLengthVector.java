package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLength;

/**
 * Relative FloatLength Vector.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatLengthVector
        extends AbstractFloatVectorRel<LengthUnit, FloatLengthVector, MutableFloatLengthVector, FloatLength>
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
    public FloatLengthVector(final List<Float> values, final LengthUnit unit, final StorageType storageType)
            throws ValueException
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
     * @param values SortedMap&lt;Integer, FloatLength&gt;; the values of the entries in the new Relative Sparse Mutable
     *            FloatLengthVector
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
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable
     *            FloatLengthVector
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
    protected final MutableFloatLengthVector instantiateMutableType(final FloatVectorData dvd, final LengthUnit unit)
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
