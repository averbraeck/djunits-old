package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerArea;

/**
 * Mutable Double MoneyPerAreaVector, a vector of values with a MoneyPerAreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMoneyPerAreaVector
        extends AbstractMutableDoubleVectorRel<MoneyPerAreaUnit, MoneyPerAreaVector, MutableMoneyPerAreaVector, MoneyPerArea>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerAreaVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MoneyPerAreaVector
     * @param unit MoneyPerAreaUnit; the unit of the new Relative Immutable Double MoneyPerAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerAreaVector(final double[] values, final MoneyPerAreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerAreaVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double MoneyPerAreaVector
     * @param unit MoneyPerAreaUnit; the unit of the new Relative Immutable Double MoneyPerAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerAreaVector(final List<Double> values, final MoneyPerAreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerAreaVector.
     * @param values MoneyPerArea[]; the values of the entries in the new Relative Immutable Double MoneyPerAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerAreaVector(final MoneyPerArea[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerAreaVector.
     * @param values List&lt;MoneyPerArea&gt;; the values of the entries in the new Relative Immutable Double MoneyPerAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerAreaVector(final List<MoneyPerArea> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerAreaVector.
     * @param values SortedMap&lt;Integer, MoneyPerArea&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            MoneyPerAreaVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerAreaVector(final SortedMap<Integer, MoneyPerArea> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerAreaVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            MoneyPerAreaVector
     * @param unit MoneyPerAreaUnit; the unit of the new Relative Sparse Mutable Double MoneyPerAreaVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerAreaVector(final SortedMap<Integer, Double> values, final MoneyPerAreaUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit MoneyPerAreaUnit; the unit
     */
    MutableMoneyPerAreaVector(final DoubleVectorData data, final MoneyPerAreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerAreaVector instantiateType(final DoubleVectorData dvd, final MoneyPerAreaUnit unit)
    {
        return new MoneyPerAreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerAreaVector instantiateMutableType(final DoubleVectorData dvd, final MoneyPerAreaUnit unit)
    {
        return new MutableMoneyPerAreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerArea instantiateScalar(final double value, final MoneyPerAreaUnit unit)
    {
        return new MoneyPerArea(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector toDense()
    {
        return this.data.isDense() ? (MutableMoneyPerAreaVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerAreaVector toSparse()
    {
        return this.data.isSparse() ? (MutableMoneyPerAreaVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of MoneyPerArea Scalars from this vector.
     * @return MoneyPerArea[]; an array of MoneyPerArea Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public MoneyPerArea[] toArray()
    {
        MoneyPerArea[] array = new MoneyPerArea[size()];
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
