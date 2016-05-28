package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AbsoluteTemperature;

/**
 * Mutable Absolute AbsoluteTemperature Vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableAbsoluteTemperatureVector
        extends
        MutableTypedDoubleVectorAbs<TemperatureUnit, AbsoluteTemperatureVector, TemperatureVector, MutableAbsoluteTemperatureVector, AbsoluteTemperature>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureVector.
     * @param values double[]; the values of the entries in the new Absolute Mutable Double AbsoluteTemperatureVector
     * @param unit U; the unit of the new Absolute Mutable Double AbsoluteTemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAbsoluteTemperatureVector(final double[] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureVector.
     * @param values List; the values of the entries in the new Absolute Mutable Double AbsoluteTemperatureVector
     * @param unit U; the unit of the new Absolute Mutable Double AbsoluteTemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAbsoluteTemperatureVector(final List<Double> values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable Double
     *            AbsoluteTemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAbsoluteTemperatureVector(final AbsoluteTemperature[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureVector.
     * @param values List; the values of the entries in the new Absolute Mutable Double AbsoluteTemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAbsoluteTemperatureVector(final List<AbsoluteTemperature> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
     *            AbsoluteTemperatureVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAbsoluteTemperatureVector(final SortedMap<Integer, AbsoluteTemperature> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double AbsoluteTemperatureVector
     * @param unit U; the unit of the new Absolute Sparse Mutable Double AbsoluteTemperatureVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAbsoluteTemperatureVector(final SortedMap<Integer, Double> values, final TemperatureUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double AbsoluteTemperatureVector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableAbsoluteTemperatureVector(final DoubleVectorData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AbsoluteTemperatureVector instantiateTypeAbs(final DoubleVectorData dvd, final TemperatureUnit unit)
    {
        return new AbsoluteTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final TemperatureVector instantiateTypeRel(final DoubleVectorData dvd, final TemperatureUnit unit)
    {
        return new TemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAbsoluteTemperatureVector instantiateMutableType(final DoubleVectorData dvd,
            final TemperatureUnit unit)
    {
        return new MutableAbsoluteTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AbsoluteTemperature get(final int index) throws ValueException
    {
        return new AbsoluteTemperature(getInUnit(index, getUnit()), getUnit());
    }

    /**
     * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute AbsoluteTemperature vector.
     */
    public final MutableTemperatureVector toRel()
    {
        return new MutableTemperatureVector(getData(), getUnit());
    }

}
