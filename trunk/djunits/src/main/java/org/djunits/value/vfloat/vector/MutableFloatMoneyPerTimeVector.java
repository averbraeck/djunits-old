package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerTime;

/**
 * Mutable FloatMoneyPerTimeVector, a vector of values with a MoneyPerTimeUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatMoneyPerTimeVector
        extends
        MutableTypedFloatVectorRel<MoneyPerTimeUnit, FloatMoneyPerTimeVector, MutableFloatMoneyPerTimeVector, FloatMoneyPerTime>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMoneyPerTimeVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatMoneyPerTimeVector
     * @param unit U; the unit of the new Relative Immutable FloatMoneyPerTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerTimeVector(final float[] values, final MoneyPerTimeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerTimeVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatMoneyPerTimeVector
     * @param unit U; the unit of the new Relative Immutable FloatMoneyPerTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerTimeVector(final List<Float> values, final MoneyPerTimeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerTimeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerTimeVector(final FloatMoneyPerTime[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerTimeVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatMoneyPerTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerTimeVector(final List<FloatMoneyPerTime> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerTimeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatMoneyPerTimeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerTimeVector(final SortedMap<Integer, FloatMoneyPerTime> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerTimeVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatMoneyPerTimeVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatMoneyPerTimeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerTimeVector(final SortedMap<Integer, Float> values, final MoneyPerTimeUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatMoneyPerTimeVector(final FloatVectorData data, final MoneyPerTimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerTimeVector instantiateType(final FloatVectorData dvd, final MoneyPerTimeUnit unit)
    {
        return new FloatMoneyPerTimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerTimeVector instantiateMutableType(final FloatVectorData dvd, final MoneyPerTimeUnit unit)
    {
        return new MutableFloatMoneyPerTimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerTime get(final int index) throws ValueException
    {
        return new FloatMoneyPerTime(getInUnit(index, getUnit()), getUnit());
    }

}
