package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.EnergyUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Energy;

/**
 * Immutable Double EnergyVector, a vector of values with a EnergyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class EnergyVector extends AbstractDoubleVectorRel<EnergyUnit, EnergyVector, MutableEnergyVector, Energy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double EnergyVector
     * @param unit EnergyUnit; the unit of the new Relative Immutable Double EnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public EnergyVector(final double[] values, final EnergyUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double EnergyVector
     * @param unit EnergyUnit; the unit of the new Relative Immutable Double EnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public EnergyVector(final List<Double> values, final EnergyUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values Energy[]; the values of the entries in the new Relative Immutable Double EnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public EnergyVector(final Energy[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values List&lt;Energy&gt;; the values of the entries in the new Relative Immutable Double EnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public EnergyVector(final List<Energy> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values SortedMap&lt;Integer, Energy&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            EnergyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public EnergyVector(final SortedMap<Integer, Energy> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EnergyVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            EnergyVector
     * @param unit EnergyUnit; the unit of the new Relative Sparse Mutable Double EnergyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public EnergyVector(final SortedMap<Integer, Double> values, final EnergyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit EnergyUnit; the unit
     */
    EnergyVector(final DoubleVectorData data, final EnergyUnit unit)
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
    public final EnergyVector toDense()
    {
        return this.data.isDense() ? (EnergyVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final EnergyVector toSparse()
    {
        return this.data.isSparse() ? (EnergyVector) this : instantiateType(this.data.toSparse(), getUnit());
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
