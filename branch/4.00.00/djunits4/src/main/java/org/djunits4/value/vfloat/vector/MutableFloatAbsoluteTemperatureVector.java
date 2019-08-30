package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatAbsoluteTemperature;

/**
 * Mutable Absolute FloatAbsoluteTemperature Vector a vector of values with a AbsoluteTemperatureUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatAbsoluteTemperatureVector
        extends AbstractMutableFloatVectorAbs<AbsoluteTemperatureUnit, TemperatureUnit, FloatAbsoluteTemperatureVector,
                FloatTemperatureVector, MutableFloatAbsoluteTemperatureVector, FloatAbsoluteTemperature>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values float[]; the values of the entries in the new Absolute Mutable FloatAbsoluteTemperatureVector
     * @param unit U; the unit of the new Absolute Mutable FloatAbsoluteTemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAbsoluteTemperatureVector(final float[] values, final AbsoluteTemperatureUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values List; the values of the entries in the new Absolute Mutable FloatAbsoluteTemperatureVector
     * @param unit U; the unit of the new Absolute Mutable FloatAbsoluteTemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAbsoluteTemperatureVector(final List<Float> values, final AbsoluteTemperatureUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable
     *            FloatAbsoluteTemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAbsoluteTemperatureVector(final FloatAbsoluteTemperature[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values List; the values of the entries in the new Absolute Mutable FloatAbsoluteTemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAbsoluteTemperatureVector(final List<FloatAbsoluteTemperature> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
     *            FloatAbsoluteTemperatureVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAbsoluteTemperatureVector(final SortedMap<Integer, FloatAbsoluteTemperature> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatAbsoluteTemperatureVector
     * @param unit U; the unit of the new Absolute Sparse Mutable FloatAbsoluteTemperatureVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAbsoluteTemperatureVector(final SortedMap<Integer, Float> values, final AbsoluteTemperatureUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatAbsoluteTemperatureVector(final FloatVectorData data, final AbsoluteTemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsoluteTemperatureVector instantiateTypeAbs(final FloatVectorData dvd,
            final AbsoluteTemperatureUnit unit)
    {
        return new FloatAbsoluteTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTemperatureVector instantiateTypeRel(final FloatVectorData dvd, final TemperatureUnit unit)
    {
        return new FloatTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAbsoluteTemperatureVector instantiateMutableType(final FloatVectorData dvd,
            final AbsoluteTemperatureUnit unit)
    {
        return new MutableFloatAbsoluteTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsoluteTemperature instantiateScalar(final float value, final AbsoluteTemperatureUnit unit)
    {
        return new FloatAbsoluteTemperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAbsoluteTemperatureVector toDense()
    {
        return this.data.isDense() ? (MutableFloatAbsoluteTemperatureVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAbsoluteTemperatureVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatAbsoluteTemperatureVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatAbsoluteTemperature Scalars from this vector.
     * @return FloatAbsoluteTemperature[]; an array of FloatAbsoluteTemperature Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAbsoluteTemperature[] toArray()
    {
        FloatAbsoluteTemperature[] array = new FloatAbsoluteTemperature[size()];
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
