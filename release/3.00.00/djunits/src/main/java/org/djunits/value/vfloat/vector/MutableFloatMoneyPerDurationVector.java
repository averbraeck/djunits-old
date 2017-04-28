package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerDuration;

/**
 * Mutable Float MoneyPerDurationVector, a vector of values with a MoneyPerDurationUnit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatMoneyPerDurationVector extends AbstractMutableFloatVectorRel<MoneyPerDurationUnit,
        FloatMoneyPerDurationVector, MutableFloatMoneyPerDurationVector, FloatMoneyPerDuration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float MoneyPerDurationVector
     * @param unit U; the unit of the new Relative Immutable Float MoneyPerDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerDurationVector(final float[] values, final MoneyPerDurationUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values List; the values of the entries in the new Relative Immutable Float MoneyPerDurationVector
     * @param unit U; the unit of the new Relative Immutable Float MoneyPerDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerDurationVector(final List<Float> values, final MoneyPerDurationUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            MoneyPerDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerDurationVector(final FloatMoneyPerDuration[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values List; the values of the entries in the new Relative Immutable Float MoneyPerDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerDurationVector(final List<FloatMoneyPerDuration> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            MoneyPerDurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerDurationVector(final SortedMap<Integer, FloatMoneyPerDuration> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerDurationVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float MoneyPerDurationVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float MoneyPerDurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerDurationVector(final SortedMap<Integer, Float> values, final MoneyPerDurationUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatMoneyPerDurationVector(final FloatVectorData data, final MoneyPerDurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerDurationVector instantiateType(final FloatVectorData dvd, final MoneyPerDurationUnit unit)
    {
        return new FloatMoneyPerDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerDurationVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerDurationUnit unit)
    {
        return new MutableFloatMoneyPerDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerDuration instantiateScalar(final float value, final MoneyPerDurationUnit unit)
    {
        return new FloatMoneyPerDuration(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerDurationVector toDense()
    {
        return this.data.isDense() ? (MutableFloatMoneyPerDurationVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerDurationVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatMoneyPerDurationVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
