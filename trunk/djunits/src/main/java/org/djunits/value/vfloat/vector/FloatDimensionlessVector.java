package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDimensionless;

/**
 * Immutable Float FloatDimensionlessVector, a vector of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDimensionlessVector extends
        AbstractFloatVectorRel<DimensionlessUnit, FloatDimensionlessVector, MutableFloatDimensionlessVector, FloatDimensionless>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatDimensionlessVector
     * @param unit U; the unit of the new Relative Immutable Float FloatDimensionlessVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDimensionlessVector(final float[] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatDimensionlessVector
     * @param unit U; the unit of the new Relative Immutable Float FloatDimensionlessVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDimensionlessVector(final List<Float> values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatDimensionlessVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDimensionlessVector(final FloatDimensionless[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatDimensionlessVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDimensionlessVector(final List<FloatDimensionless> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatDimensionlessVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDimensionlessVector(final SortedMap<Integer, FloatDimensionless> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatDimensionlessVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatDimensionlessVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatDimensionlessVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDimensionlessVector(final SortedMap<Integer, Float> values, final DimensionlessUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatDimensionlessVector(final FloatVectorData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionlessVector instantiateType(final FloatVectorData dvd, final DimensionlessUnit unit)
    {
        return new FloatDimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDimensionlessVector instantiateMutableType(final FloatVectorData dvd,
            final DimensionlessUnit unit)
    {
        return new MutableFloatDimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionless instantiateScalar(final float value, final DimensionlessUnit unit)
    {
        return new FloatDimensionless(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector toDense()
    {
        return this.data.isDense() ? (FloatDimensionlessVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector toSparse()
    {
        return this.data.isSparse() ? (FloatDimensionlessVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

}
