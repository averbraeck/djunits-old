package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DirectionUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDirection;

/**
 * Absolute FloatDirection Vector.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDirectionVector extends AbstractFloatVectorAbs<DirectionUnit, AngleUnit, FloatDirectionVector,
        FloatAngleVector, MutableFloatDirectionVector, FloatDirection>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable FloatDirectionVector.
     * @param values float[]; the values of the entries in the new Absolute Immutable FloatDirectionVector
     * @param unit U; the unit of the new Absolute Immutable FloatDirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDirectionVector(final float[] values, final DirectionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionVector.
     * @param values List; the values of the entries in the new Absolute Immutable FloatDirectionVector
     * @param unit U; the unit of the new Absolute Immutable FloatDirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDirectionVector(final List<Float> values, final DirectionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable FloatDirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDirectionVector(final FloatDirection[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionVector.
     * @param values List; the values of the entries in the new Absolute Immutable FloatDirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDirectionVector(final List<FloatDirection> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable
     *            FloatDirectionVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDirectionVector(final SortedMap<Integer, FloatDirection> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatDirectionVector
     * @param unit U; the unit of the new Absolute Sparse Mutable FloatDirectionVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDirectionVector(final SortedMap<Integer, Float> values, final DirectionUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable FloatDirectionVector.
     * @param data an internal data object
     * @param unit the unit
     */
    FloatDirectionVector(final FloatVectorData data, final DirectionUnit unit)
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
    public final FloatDirectionVector toDense()
    {
        return this.data.isDense() ? (FloatDirectionVector) this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDirectionVector toSparse()
    {
        return this.data.isSparse() ? (FloatDirectionVector) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

}
