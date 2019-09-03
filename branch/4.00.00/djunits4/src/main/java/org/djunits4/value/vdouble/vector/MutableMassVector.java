package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.MassUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Mass;

/**
 * Mutable Double MassVector, a vector of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.197Z")
public class MutableMassVector extends AbstractMutableDoubleVectorRel<MassUnit, MassVector, MutableMassVector, Mass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MassVector
     * @param unit MassUnit; the unit of the new Relative Immutable Double MassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMassVector(final double[] values, final MassUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double MassVector
     * @param unit MassUnit; the unit of the new Relative Immutable Double MassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMassVector(final List<Double> values, final MassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values Mass[]; the values of the entries in the new Relative Immutable Double MassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMassVector(final Mass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values List&lt;Mass&gt;; the values of the entries in the new Relative Immutable Double MassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMassVector(final List<Mass> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values SortedMap&lt;Integer, Mass&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            MassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMassVector(final SortedMap<Integer, Mass> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            MassVector
     * @param unit MassUnit; the unit of the new Relative Sparse Mutable Double MassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMassVector(final SortedMap<Integer, Double> values, final MassUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit MassUnit; the unit
     */
    MutableMassVector(final DoubleVectorData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MassVector instantiateType(final DoubleVectorData dvd, final MassUnit unit)
    {
        return new MassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMassVector instantiateMutableType(final DoubleVectorData dvd, final MassUnit unit)
    {
        return new MutableMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mass instantiateScalar(final double value, final MassUnit unit)
    {
        return new Mass(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector toDense()
    {
        return this.data.isDense() ? (MutableMassVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector toSparse()
    {
        return this.data.isSparse() ? (MutableMassVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Mass Scalars from this vector.
     * @return Mass[]; an array of Mass Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Mass[] toArray()
    {
        Mass[] array = new Mass[size()];
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
