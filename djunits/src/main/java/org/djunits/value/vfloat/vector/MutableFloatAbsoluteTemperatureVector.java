package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAbsoluteTemperature;

/**
 * Mutable Absolute FloatAbsoluteTemperature Vector a vector of values with a TemperatureUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatAbsoluteTemperatureVector
        extends
        MutableTypedFloatVectorAbs<TemperatureUnit, FloatAbsoluteTemperatureVector, FloatTemperatureVector, MutableFloatAbsoluteTemperatureVector, FloatAbsoluteTemperature>
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
    public MutableFloatAbsoluteTemperatureVector(final float[] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
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
    public MutableFloatAbsoluteTemperatureVector(final List<Float> values, final TemperatureUnit unit,
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
    public MutableFloatAbsoluteTemperatureVector(final SortedMap<Integer, Float> values, final TemperatureUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatAbsoluteTemperatureVector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatAbsoluteTemperatureVector(final FloatVectorData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsoluteTemperatureVector instantiateTypeAbs(final FloatVectorData dvd, final TemperatureUnit unit)
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
            final TemperatureUnit unit)
    {
        return new MutableFloatAbsoluteTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAbsoluteTemperature get(final int index) throws ValueException
    {
        return new FloatAbsoluteTemperature(getInUnit(index, getUnit()), getUnit());
    }

    /**
     * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute FloatAbsoluteTemperature vector.
     */
    public final MutableFloatTemperatureVector toRel()
    {
        return new MutableFloatTemperatureVector(getData(), getUnit());
    }

}
