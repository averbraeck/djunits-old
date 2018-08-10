package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerLength;

/**
 * Immutable Double MoneyPerLengthVector, a vector of values with a MoneyPerLengthUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerLengthVector
        extends AbstractDoubleVectorRel<MoneyPerLengthUnit, MoneyPerLengthVector, MutableMoneyPerLengthVector, MoneyPerLength>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerLengthVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MoneyPerLengthVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerLengthVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerLengthVector(final double[] values, final MoneyPerLengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerLengthVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerLengthVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerLengthVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerLengthVector(final List<Double> values, final MoneyPerLengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerLengthVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            MoneyPerLengthVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerLengthVector(final MoneyPerLength[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerLengthVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerLengthVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerLengthVector(final List<MoneyPerLength> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerLengthVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            MoneyPerLengthVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerLengthVector(final SortedMap<Integer, MoneyPerLength> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerLengthVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double MoneyPerLengthVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double MoneyPerLengthVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerLengthVector(final SortedMap<Integer, Double> values, final MoneyPerLengthUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MoneyPerLengthVector(final DoubleVectorData data, final MoneyPerLengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerLengthVector instantiateType(final DoubleVectorData dvd, final MoneyPerLengthUnit unit)
    {
        return new MoneyPerLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerLengthVector instantiateMutableType(final DoubleVectorData dvd,
            final MoneyPerLengthUnit unit)
    {
        return new MutableMoneyPerLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerLength instantiateScalar(final double value, final MoneyPerLengthUnit unit)
    {
        return new MoneyPerLength(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLengthVector toDense()
    {
        return this.data.isDense() ? (MoneyPerLengthVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerLengthVector toSparse()
    {
        return this.data.isSparse() ? (MoneyPerLengthVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of MoneyPerLength Scalars from this vector.
     * @return MoneyPerLength[]; an array of MoneyPerLength Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public MoneyPerLength[] toArray()
    {
        MoneyPerLength[] array = new MoneyPerLength[size()];
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
