package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngle;

/**
 * Relative FloatAngle Vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAngleVector extends TypedFloatVectorRel<AngleUnit, FloatAngleVector, MutableFloatAngleVector, FloatAngle>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatAngleVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatAngleVector
     * @param unit U; the unit of the new Relative Immutable FloatAngleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleVector(final float[] values, final AngleUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatAngleVector
     * @param unit U; the unit of the new Relative Immutable FloatAngleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleVector(final List<Float> values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable FloatAngleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleVector(final FloatAngle[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatAngleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleVector(final List<FloatAngle> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable FloatAngleVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleVector(final SortedMap<Integer, FloatAngle> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatAngleVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatAngleVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleVector(final SortedMap<Integer, Float> values, final AngleUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAngleVector.
     * @param data an internal data object
     * @param unit the unit
     */
    FloatAngleVector(final FloatVectorData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleVector instantiateType(final FloatVectorData dvd, final AngleUnit unit)
    {
        return new FloatAngleVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAngleVector instantiateMutableType(final FloatVectorData dvd, final AngleUnit unit)
    {
        return new MutableFloatAngleVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngle get(final int index) throws ValueException
    {
        return new FloatAngle(getInUnit(index, getUnit()), getUnit());
    }

    /**
     * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative FloatAngle vector.
     */
    public final FloatDirectionVector toAbs()
    {
        return new FloatDirectionVector(getData(), getUnit());
    }

}
