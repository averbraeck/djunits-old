package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDirection;

/**
 * Mutable Absolute FloatDirection Vector a vector of values with a AngleUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatDirectionVector
        extends
        MutableTypedFloatVectorAbs<AngleUnit, FloatDirectionVector, FloatAngleVector, MutableFloatDirectionVector, FloatDirection>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values float[]; the values of the entries in the new Absolute Mutable FloatDirectionVector
     * @param unit U; the unit of the new Absolute Mutable FloatDirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDirectionVector(final float[] values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values List; the values of the entries in the new Absolute Mutable FloatDirectionVector
     * @param unit U; the unit of the new Absolute Mutable FloatDirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDirectionVector(final List<Float> values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable FloatDirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDirectionVector(final FloatDirection[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values List; the values of the entries in the new Absolute Mutable FloatDirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDirectionVector(final List<FloatDirection> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
     *            FloatDirectionVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDirectionVector(final SortedMap<Integer, FloatDirection> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatDirectionVector
     * @param unit U; the unit of the new Absolute Sparse Mutable FloatDirectionVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDirectionVector(final SortedMap<Integer, Float> values, final AngleUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionVector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatDirectionVector(final FloatVectorData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDirectionVector instantiateTypeAbs(final FloatVectorData dvd, final AngleUnit unit)
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
    protected final MutableFloatDirectionVector instantiateMutableType(final FloatVectorData dvd, final AngleUnit unit)
    {
        return new MutableFloatDirectionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDirection get(final int index) throws ValueException
    {
        return new FloatDirection(getInUnit(index, getUnit()), getUnit());
    }

    /**
     * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute FloatDirection vector.
     */
    public final MutableFloatAngleVector toRel()
    {
        return new MutableFloatAngleVector(getData(), getUnit());
    }

}
