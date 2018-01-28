package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.EnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Energy;

/**
 * Mutable Double EnergyVector, a vector of values with a EnergyUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableEnergyVector extends AbstractMutableDoubleVectorRel<EnergyUnit, EnergyVector, MutableEnergyVector, Energy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double EnergyVector
     * @param unit U; the unit of the new Relative Immutable Double EnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableEnergyVector(final double[] values, final EnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values List; the values of the entries in the new Relative Immutable Double EnergyVector
     * @param unit U; the unit of the new Relative Immutable Double EnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableEnergyVector(final List<Double> values, final EnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double EnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableEnergyVector(final Energy[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values List; the values of the entries in the new Relative Immutable Double EnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableEnergyVector(final List<Energy> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            EnergyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableEnergyVector(final SortedMap<Integer, Energy> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double EnergyVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double EnergyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableEnergyVector(final SortedMap<Integer, Double> values, final EnergyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableEnergyVector(final DoubleVectorData data, final EnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final EnergyVector instantiateType(final DoubleVectorData dvd, final EnergyUnit unit)
    {
        return new EnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableEnergyVector instantiateMutableType(final DoubleVectorData dvd, final EnergyUnit unit)
    {
        return new MutableEnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Energy instantiateScalar(final double value, final EnergyUnit unit)
    {
        return new Energy(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector toDense()
    {
        return this.data.isDense() ? (MutableEnergyVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector toSparse()
    {
        return this.data.isSparse() ? (MutableEnergyVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Energy Scalars from this vector.
     * @return Energy[]; an array of Energy Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Energy[] toArray()
    {
        Energy[] array = new Energy[size()];
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
