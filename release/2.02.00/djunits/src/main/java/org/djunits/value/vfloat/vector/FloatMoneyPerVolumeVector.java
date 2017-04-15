package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerVolume;

/**
 * Immutable Float FloatMoneyPerVolumeVector, a vector of values with a MoneyPerVolumeUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatMoneyPerVolumeVector extends
        AbstractFloatVectorRel<MoneyPerVolumeUnit, FloatMoneyPerVolumeVector, MutableFloatMoneyPerVolumeVector, FloatMoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerVolumeVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMoneyPerVolumeVector
     * @param unit U; the unit of the new Relative Immutable Float FloatMoneyPerVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerVolumeVector(final float[] values, final MoneyPerVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerVolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatMoneyPerVolumeVector
     * @param unit U; the unit of the new Relative Immutable Float FloatMoneyPerVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerVolumeVector(final List<Float> values, final MoneyPerVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerVolumeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerVolumeVector(final FloatMoneyPerVolume[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerVolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatMoneyPerVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerVolumeVector(final List<FloatMoneyPerVolume> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerVolumeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatMoneyPerVolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerVolumeVector(final SortedMap<Integer, FloatMoneyPerVolume> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerVolumeVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatMoneyPerVolumeVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatMoneyPerVolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerVolumeVector(final SortedMap<Integer, Float> values, final MoneyPerVolumeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatMoneyPerVolumeVector(final FloatVectorData data, final MoneyPerVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerVolumeVector instantiateType(final FloatVectorData dvd, final MoneyPerVolumeUnit unit)
    {
        return new FloatMoneyPerVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerVolumeVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerVolumeUnit unit)
    {
        return new MutableFloatMoneyPerVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerVolume instantiateScalar(final float value, final MoneyPerVolumeUnit unit)
    {
        return new FloatMoneyPerVolume(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolumeVector toDense()
    {
        return this.data.isDense() ? (FloatMoneyPerVolumeVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolumeVector toSparse()
    {
        return this.data.isSparse() ? (FloatMoneyPerVolumeVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

}
