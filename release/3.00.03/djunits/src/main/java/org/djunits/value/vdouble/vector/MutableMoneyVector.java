package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Money;

/**
 * Mutable Double MoneyVector, a vector of values with a MoneyUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMoneyVector extends AbstractMutableDoubleVectorRel<MoneyUnit, MoneyVector, MutableMoneyVector, Money>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MoneyVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyVector(final double[] values, final MoneyUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyVector(final List<Double> values, final MoneyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double MoneyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyVector(final Money[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyVector(final List<Money> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            MoneyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyVector(final SortedMap<Integer, Money> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double MoneyVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double MoneyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyVector(final SortedMap<Integer, Double> values, final MoneyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableMoneyVector(final DoubleVectorData data, final MoneyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyVector instantiateType(final DoubleVectorData dvd, final MoneyUnit unit)
    {
        return new MoneyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyVector instantiateMutableType(final DoubleVectorData dvd, final MoneyUnit unit)
    {
        return new MutableMoneyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Money instantiateScalar(final double value, final MoneyUnit unit)
    {
        return new Money(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector toDense()
    {
        return this.data.isDense() ? (MutableMoneyVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyVector toSparse()
    {
        return this.data.isSparse() ? (MutableMoneyVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Money Scalars from this vector.
     * @return Money[]; an array of Money Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Money[] toArray()
    {
        Money[] array = new Money[size()];
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