package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerTime;

/**
 * Immutable Double MoneyPerTimeVector, a vector of values with a MoneyPerTimeUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerTimeVector extends
        TypedDoubleVectorRel<MoneyPerTimeUnit, MoneyPerTimeVector, MutableMoneyPerTimeVector, MoneyPerTime>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerTimeVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MoneyPerTimeVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerTimeVector(final double[] values, final MoneyPerTimeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerTimeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerTimeVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerTimeVector(final List<Double> values, final MoneyPerTimeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerTimeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            MoneyPerTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerTimeVector(final MoneyPerTime[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerTimeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerTimeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerTimeVector(final List<MoneyPerTime> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerTimeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            MoneyPerTimeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerTimeVector(final SortedMap<Integer, MoneyPerTime> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerTimeVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double MoneyPerTimeVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double MoneyPerTimeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerTimeVector(final SortedMap<Integer, Double> values, final MoneyPerTimeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MoneyPerTimeVector(final DoubleVectorData data, final MoneyPerTimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerTimeVector instantiateType(final DoubleVectorData dvd, final MoneyPerTimeUnit unit)
    {
        return new MoneyPerTimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerTimeVector instantiateMutableType(final DoubleVectorData dvd, final MoneyPerTimeUnit unit)
    {
        return new MutableMoneyPerTimeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime get(final int index) throws ValueException
    {
        return new MoneyPerTime(getInUnit(index, getUnit()), getUnit());
    }

}
