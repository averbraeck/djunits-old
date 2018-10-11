package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerDuration;

/**
 * Mutable Double MoneyPerDurationVector, a vector of values with a MoneyPerDurationUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMoneyPerDurationVector extends AbstractMutableDoubleVectorRel<MoneyPerDurationUnit, MoneyPerDurationVector,
        MutableMoneyPerDurationVector, MoneyPerDuration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MoneyPerDurationVector
     * @param unit MoneyPerDurationUnit; the unit of the new Relative Immutable Double MoneyPerDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerDurationVector(final double[] values, final MoneyPerDurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double MoneyPerDurationVector
     * @param unit MoneyPerDurationUnit; the unit of the new Relative Immutable Double MoneyPerDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerDurationVector(final List<Double> values, final MoneyPerDurationUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values MoneyPerDuration[]; the values of the entries in the new Relative Immutable Double MoneyPerDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerDurationVector(final MoneyPerDuration[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values List&lt;MoneyPerDuration&gt;; the values of the entries in the new Relative Immutable Double
     *            MoneyPerDurationVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerDurationVector(final List<MoneyPerDuration> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values SortedMap&lt;Integer, MoneyPerDuration&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Double MoneyPerDurationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerDurationVector(final SortedMap<Integer, MoneyPerDuration> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            MoneyPerDurationVector
     * @param unit MoneyPerDurationUnit; the unit of the new Relative Sparse Mutable Double MoneyPerDurationVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerDurationVector(final SortedMap<Integer, Double> values, final MoneyPerDurationUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit MoneyPerDurationUnit; the unit
     */
    MutableMoneyPerDurationVector(final DoubleVectorData data, final MoneyPerDurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerDurationVector instantiateType(final DoubleVectorData dvd, final MoneyPerDurationUnit unit)
    {
        return new MoneyPerDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerDurationVector instantiateMutableType(final DoubleVectorData dvd,
            final MoneyPerDurationUnit unit)
    {
        return new MutableMoneyPerDurationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerDuration instantiateScalar(final double value, final MoneyPerDurationUnit unit)
    {
        return new MoneyPerDuration(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerDurationVector toDense()
    {
        return this.data.isDense() ? (MutableMoneyPerDurationVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerDurationVector toSparse()
    {
        return this.data.isSparse() ? (MutableMoneyPerDurationVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of MoneyPerDuration Scalars from this vector.
     * @return MoneyPerDuration[]; an array of MoneyPerDuration Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public MoneyPerDuration[] toArray()
    {
        MoneyPerDuration[] array = new MoneyPerDuration[size()];
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
