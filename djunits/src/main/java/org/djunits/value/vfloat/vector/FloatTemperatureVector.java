package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTemperature;

/**
 * Relative FloatTemperature Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatTemperatureVector
        extends AbstractFloatVectorRel<TemperatureUnit, FloatTemperatureVector, MutableFloatTemperatureVector, FloatTemperature>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatTemperatureVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatTemperatureVector
     * @param unit TemperatureUnit; the unit of the new Relative Immutable FloatTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTemperatureVector(final float[] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatTemperatureVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable FloatTemperatureVector
     * @param unit TemperatureUnit; the unit of the new Relative Immutable FloatTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTemperatureVector(final List<Float> values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatTemperatureVector.
     * @param values FloatTemperature[]; the values of the entries in the new Relative Immutable FloatTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTemperatureVector(final FloatTemperature[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatTemperatureVector.
     * @param values List&lt;FloatTemperature&gt;; the values of the entries in the new Relative Immutable
     *            FloatTemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTemperatureVector(final List<FloatTemperature> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatTemperatureVector.
     * @param values SortedMap&lt;Integer, FloatTemperature&gt;; the values of the entries in the new Relative Sparse Mutable
     *            FloatTemperatureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTemperatureVector(final SortedMap<Integer, FloatTemperature> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatTemperatureVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable
     *            FloatTemperatureVector
     * @param unit TemperatureUnit; the unit of the new Relative Sparse Mutable FloatTemperatureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTemperatureVector(final SortedMap<Integer, Float> values, final TemperatureUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatTemperatureVector.
     * @param data FloatVectorData; an internal data object
     * @param unit TemperatureUnit; the unit
     */
    FloatTemperatureVector(final FloatVectorData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperatureVector instantiateType(final FloatVectorData dvd, final TemperatureUnit unit)
    {
        return new FloatTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTemperatureVector instantiateMutableType(final FloatVectorData dvd, final TemperatureUnit unit)
    {
        return new MutableFloatTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperature instantiateScalar(final float value, final TemperatureUnit unit)
    {
        return new FloatTemperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTemperatureVector toDense()
    {
        return this.data.isDense() ? (FloatTemperatureVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTemperatureVector toSparse()
    {
        return this.data.isSparse() ? (FloatTemperatureVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatTemperature Scalars from this vector.
     * @return FloatTemperature[]; an array of FloatTemperature Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatTemperature[] toArray()
    {
        FloatTemperature[] array = new FloatTemperature[size()];
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
