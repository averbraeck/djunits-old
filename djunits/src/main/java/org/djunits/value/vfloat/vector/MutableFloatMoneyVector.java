package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoney;

/**
 * Mutable Float MoneyVector, a vector of values with a MoneyUnit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatMoneyVector
        extends AbstractMutableFloatVectorRel<MoneyUnit, FloatMoneyVector, MutableFloatMoneyVector, FloatMoney>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float MoneyVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float MoneyVector
     * @param unit U; the unit of the new Relative Immutable Float MoneyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyVector(final float[] values, final MoneyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyVector.
     * @param values List; the values of the entries in the new Relative Immutable Float MoneyVector
     * @param unit U; the unit of the new Relative Immutable Float MoneyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyVector(final List<Float> values, final MoneyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float MoneyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyVector(final FloatMoney[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyVector.
     * @param values List; the values of the entries in the new Relative Immutable Float MoneyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyVector(final List<FloatMoney> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float MoneyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyVector(final SortedMap<Integer, FloatMoney> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float MoneyVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float MoneyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyVector(final SortedMap<Integer, Float> values, final MoneyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatMoneyVector(final FloatVectorData data, final MoneyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyVector instantiateType(final FloatVectorData dvd, final MoneyUnit unit)
    {
        return new FloatMoneyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyVector instantiateMutableType(final FloatVectorData dvd, final MoneyUnit unit)
    {
        return new MutableFloatMoneyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoney instantiateScalar(final float value, final MoneyUnit unit)
    {
        return new FloatMoney(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyVector toDense()
    {
        return this.data.isDense() ? (MutableFloatMoneyVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatMoneyVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
