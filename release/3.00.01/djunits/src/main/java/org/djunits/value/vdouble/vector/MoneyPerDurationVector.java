package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerDuration;

/**
 * Immutable Double MoneyPerDurationVector, a vector of values with a MoneyPerDurationUnit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerDurationVector extends
        AbstractDoubleVectorRel<MoneyPerDurationUnit, MoneyPerDurationVector, MutableMoneyPerDurationVector, MoneyPerDuration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MoneyPerDurationVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerDurationVector(final double[] values, final MoneyPerDurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerDurationVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerDurationVector(final List<Double> values, final MoneyPerDurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            MoneyPerDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerDurationVector(final MoneyPerDuration[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerDurationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerDurationVector(final List<MoneyPerDuration> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            MoneyPerDurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerDurationVector(final SortedMap<Integer, MoneyPerDuration> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double MoneyPerDurationVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double MoneyPerDurationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerDurationVector(final SortedMap<Integer, Double> values, final MoneyPerDurationUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MoneyPerDurationVector(final DoubleVectorData data, final MoneyPerDurationUnit unit)
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
    public final MoneyPerDurationVector toDense()
    {
        return this.data.isDense() ? (MoneyPerDurationVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerDurationVector toSparse()
    {
        return this.data.isSparse() ? (MoneyPerDurationVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

}
