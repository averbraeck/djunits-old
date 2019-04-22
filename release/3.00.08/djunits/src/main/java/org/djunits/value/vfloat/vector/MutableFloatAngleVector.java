package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngle;

/**
 * Mutable Relative FloatAngle Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatAngleVector
        extends AbstractMutableFloatVectorRel<AngleUnit, FloatAngleVector, MutableFloatAngleVector, FloatAngle>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatAngleVector.
     * @param values float[]; the values of the entries in the new Relative Mutable FloatAngleVector
     * @param unit AngleUnit; the unit of the new Relative Mutable FloatAngleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAngleVector(final float[] values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatAngleVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Mutable FloatAngleVector
     * @param unit AngleUnit; the unit of the new Relative Mutable FloatAngleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAngleVector(final List<Float> values, final AngleUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatAngleVector.
     * @param values FloatAngle[]; the values of the entries in the new Relative Mutable FloatAngleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAngleVector(final FloatAngle[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatAngleVector.
     * @param values List&lt;FloatAngle&gt;; the values of the entries in the new Relative Mutable FloatAngleVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAngleVector(final List<FloatAngle> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatAngleVector.
     * @param values SortedMap&lt;Integer, FloatAngle&gt;; the values of the entries in the new Relative Sparse Mutable
     *            FloatAngleVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAngleVector(final SortedMap<Integer, FloatAngle> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatAngleVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable
     *            FloatAngleVector
     * @param unit AngleUnit; the unit of the new Relative Sparse Mutable FloatAngleVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAngleVector(final SortedMap<Integer, Float> values, final AngleUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatAngleVector.
     * @param data FloatVectorData; an internal data object
     * @param unit AngleUnit; the unit
     */
    MutableFloatAngleVector(final FloatVectorData data, final AngleUnit unit)
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
    protected final FloatAngle instantiateScalar(final float value, final AngleUnit unit)
    {
        return new FloatAngle(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAngleVector toDense()
    {
        return this.data.isDense() ? (MutableFloatAngleVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAngleVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatAngleVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatAngle Scalars from this vector.
     * @return FloatAngle[]; an array of FloatAngle Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAngle[] toArray()
    {
        FloatAngle[] array = new FloatAngle[size()];
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