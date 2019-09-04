package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerMass;

/**
 * Mutable Double MoneyPerMassVector, a vector of values with a MoneyPerMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableMoneyPerMassVector
        extends AbstractMutableDoubleVectorRel<MoneyPerMassUnit, MoneyPerMassVector, MutableMoneyPerMassVector, MoneyPerMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerMassVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MoneyPerMassVector
     * @param unit MoneyPerMassUnit; the unit of the new Relative Immutable Double MoneyPerMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerMassVector(final double[] values, final MoneyPerMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerMassVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double MoneyPerMassVector
     * @param unit MoneyPerMassUnit; the unit of the new Relative Immutable Double MoneyPerMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerMassVector(final List<Double> values, final MoneyPerMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerMassVector.
     * @param values MoneyPerMass[]; the values of the entries in the new Relative Immutable Double MoneyPerMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerMassVector(final MoneyPerMass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerMassVector.
     * @param values List&lt;MoneyPerMass&gt;; the values of the entries in the new Relative Immutable Double MoneyPerMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerMassVector(final List<MoneyPerMass> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerMassVector.
     * @param values SortedMap&lt;Integer, MoneyPerMass&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            MoneyPerMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerMassVector(final SortedMap<Integer, MoneyPerMass> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerMassVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            MoneyPerMassVector
     * @param unit MoneyPerMassUnit; the unit of the new Relative Sparse Mutable Double MoneyPerMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerMassVector(final SortedMap<Integer, Double> values, final MoneyPerMassUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit MoneyPerMassUnit; the unit
     */
    MutableMoneyPerMassVector(final DoubleVectorData data, final MoneyPerMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerMassVector instantiateType(final DoubleVectorData dvd, final MoneyPerMassUnit unit)
    {
        return new MoneyPerMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerMassVector instantiateMutableType(final DoubleVectorData dvd, final MoneyPerMassUnit unit)
    {
        return new MutableMoneyPerMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerMass instantiateScalar(final double value, final MoneyPerMassUnit unit)
    {
        return new MoneyPerMass(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector toDense()
    {
        return this.data.isDense() ? (MutableMoneyPerMassVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassVector toSparse()
    {
        return this.data.isSparse() ? (MutableMoneyPerMassVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of MoneyPerMass Scalars from this vector.
     * @return MoneyPerMass[]; an array of MoneyPerMass Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public MoneyPerMass[] toArray()
    {
        MoneyPerMass[] array = new MoneyPerMass[size()];
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
