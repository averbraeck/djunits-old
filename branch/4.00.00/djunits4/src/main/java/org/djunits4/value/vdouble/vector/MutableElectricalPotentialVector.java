package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalPotentialUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.ElectricalPotential;

/**
 * Mutable Double ElectricalPotentialVector, a vector of values with a ElectricalPotentialUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.197Z")
public class MutableElectricalPotentialVector extends AbstractMutableDoubleVectorRel<ElectricalPotentialUnit,
        ElectricalPotentialVector, MutableElectricalPotentialVector, ElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalPotentialVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalPotentialVector
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Immutable Double ElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalPotentialVector(final double[] values, final ElectricalPotentialUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalPotentialVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double
     *            ElectricalPotentialVector
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Immutable Double ElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalPotentialVector(final List<Double> values, final ElectricalPotentialUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalPotentialVector.
     * @param values ElectricalPotential[]; the values of the entries in the new Relative Immutable Double
     *            ElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalPotentialVector(final ElectricalPotential[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalPotentialVector.
     * @param values List&lt;ElectricalPotential&gt;; the values of the entries in the new Relative Immutable Double
     *            ElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalPotentialVector(final List<ElectricalPotential> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalPotentialVector.
     * @param values SortedMap&lt;Integer, ElectricalPotential&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Double ElectricalPotentialVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalPotentialVector(final SortedMap<Integer, ElectricalPotential> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalPotentialVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            ElectricalPotentialVector
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Sparse Mutable Double ElectricalPotentialVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalPotentialVector(final SortedMap<Integer, Double> values, final ElectricalPotentialUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit ElectricalPotentialUnit; the unit
     */
    MutableElectricalPotentialVector(final DoubleVectorData data, final ElectricalPotentialUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalPotentialVector instantiateType(final DoubleVectorData dvd, final ElectricalPotentialUnit unit)
    {
        return new ElectricalPotentialVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalPotentialVector instantiateMutableType(final DoubleVectorData dvd,
            final ElectricalPotentialUnit unit)
    {
        return new MutableElectricalPotentialVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalPotential instantiateScalar(final double value, final ElectricalPotentialUnit unit)
    {
        return new ElectricalPotential(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalPotentialVector toDense()
    {
        return this.data.isDense() ? (MutableElectricalPotentialVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalPotentialVector toSparse()
    {
        return this.data.isSparse() ? (MutableElectricalPotentialVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of ElectricalPotential Scalars from this vector.
     * @return ElectricalPotential[]; an array of ElectricalPotential Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public ElectricalPotential[] toArray()
    {
        ElectricalPotential[] array = new ElectricalPotential[size()];
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
