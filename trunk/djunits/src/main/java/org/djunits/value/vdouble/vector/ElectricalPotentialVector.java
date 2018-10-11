package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.ElectricalPotential;

/**
 * Immutable Double ElectricalPotentialVector, a vector of values with a ElectricalPotentialUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ElectricalPotentialVector extends AbstractDoubleVectorRel<ElectricalPotentialUnit, ElectricalPotentialVector,
        MutableElectricalPotentialVector, ElectricalPotential>
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
    public ElectricalPotentialVector(final double[] values, final ElectricalPotentialUnit unit, final StorageType storageType)
            throws ValueException
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
    public ElectricalPotentialVector(final List<Double> values, final ElectricalPotentialUnit unit,
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
    public ElectricalPotentialVector(final ElectricalPotential[] values, final StorageType storageType) throws ValueException
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
    public ElectricalPotentialVector(final List<ElectricalPotential> values, final StorageType storageType)
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
    public ElectricalPotentialVector(final SortedMap<Integer, ElectricalPotential> values, final int length,
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
    public ElectricalPotentialVector(final SortedMap<Integer, Double> values, final ElectricalPotentialUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit ElectricalPotentialUnit; the unit
     */
    ElectricalPotentialVector(final DoubleVectorData data, final ElectricalPotentialUnit unit)
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
    public final ElectricalPotentialVector toDense()
    {
        return this.data.isDense() ? (ElectricalPotentialVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotentialVector toSparse()
    {
        return this.data.isSparse() ? (ElectricalPotentialVector) this : instantiateType(this.data.toSparse(), getUnit());
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
