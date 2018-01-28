package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerEnergy;

/**
 * Immutable Double MoneyPerEnergyVector, a vector of values with a MoneyPerEnergyUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerEnergyVector
        extends AbstractDoubleVectorRel<MoneyPerEnergyUnit, MoneyPerEnergyVector, MutableMoneyPerEnergyVector, MoneyPerEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MoneyPerEnergyVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerEnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerEnergyVector(final double[] values, final MoneyPerEnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerEnergyVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerEnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerEnergyVector(final List<Double> values, final MoneyPerEnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            MoneyPerEnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerEnergyVector(final MoneyPerEnergy[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerEnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerEnergyVector(final List<MoneyPerEnergy> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            MoneyPerEnergyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerEnergyVector(final SortedMap<Integer, MoneyPerEnergy> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double MoneyPerEnergyVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double MoneyPerEnergyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerEnergyVector(final SortedMap<Integer, Double> values, final MoneyPerEnergyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MoneyPerEnergyVector(final DoubleVectorData data, final MoneyPerEnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerEnergyVector instantiateType(final DoubleVectorData dvd, final MoneyPerEnergyUnit unit)
    {
        return new MoneyPerEnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerEnergyVector instantiateMutableType(final DoubleVectorData dvd,
            final MoneyPerEnergyUnit unit)
    {
        return new MutableMoneyPerEnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerEnergy instantiateScalar(final double value, final MoneyPerEnergyUnit unit)
    {
        return new MoneyPerEnergy(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergyVector toDense()
    {
        return this.data.isDense() ? (MoneyPerEnergyVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergyVector toSparse()
    {
        return this.data.isSparse() ? (MoneyPerEnergyVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of MoneyPerEnergy Scalars from this vector.
     * @return MoneyPerEnergy[]; an array of MoneyPerEnergy Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public MoneyPerEnergy[] toArray()
    {
        MoneyPerEnergy[] array = new MoneyPerEnergy[size()];
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
