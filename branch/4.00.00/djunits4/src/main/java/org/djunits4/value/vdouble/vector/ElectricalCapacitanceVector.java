package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.ElectricalCapacitanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.ElectricalCapacitance;

/**
 * Immutable Double ElectricalCapacitanceVector, a vector of values with a ElectricalCapacitanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class ElectricalCapacitanceVector extends AbstractDoubleVectorRel<ElectricalCapacitanceUnit, ElectricalCapacitanceVector,
        MutableElectricalCapacitanceVector, ElectricalCapacitance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalCapacitanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalCapacitanceVector
     * @param unit ElectricalCapacitanceUnit; the unit of the new Relative Immutable Double ElectricalCapacitanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalCapacitanceVector(final double[] values, final ElectricalCapacitanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCapacitanceVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double
     *            ElectricalCapacitanceVector
     * @param unit ElectricalCapacitanceUnit; the unit of the new Relative Immutable Double ElectricalCapacitanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalCapacitanceVector(final List<Double> values, final ElectricalCapacitanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCapacitanceVector.
     * @param values ElectricalCapacitance[]; the values of the entries in the new Relative Immutable Double
     *            ElectricalCapacitanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalCapacitanceVector(final ElectricalCapacitance[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCapacitanceVector.
     * @param values List&lt;ElectricalCapacitance&gt;; the values of the entries in the new Relative Immutable Double
     *            ElectricalCapacitanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalCapacitanceVector(final List<ElectricalCapacitance> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCapacitanceVector.
     * @param values SortedMap&lt;Integer, ElectricalCapacitance&gt;; the values of the entries in the new Relative Sparse
     *            Mutable Double ElectricalCapacitanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalCapacitanceVector(final SortedMap<Integer, ElectricalCapacitance> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCapacitanceVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            ElectricalCapacitanceVector
     * @param unit ElectricalCapacitanceUnit; the unit of the new Relative Sparse Mutable Double ElectricalCapacitanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalCapacitanceVector(final SortedMap<Integer, Double> values, final ElectricalCapacitanceUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit ElectricalCapacitanceUnit; the unit
     */
    ElectricalCapacitanceVector(final DoubleVectorData data, final ElectricalCapacitanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCapacitanceVector instantiateType(final DoubleVectorData dvd,
            final ElectricalCapacitanceUnit unit)
    {
        return new ElectricalCapacitanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalCapacitanceVector instantiateMutableType(final DoubleVectorData dvd,
            final ElectricalCapacitanceUnit unit)
    {
        return new MutableElectricalCapacitanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCapacitance instantiateScalar(final double value, final ElectricalCapacitanceUnit unit)
    {
        return new ElectricalCapacitance(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCapacitanceVector toDense()
    {
        return this.data.isDense() ? (ElectricalCapacitanceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCapacitanceVector toSparse()
    {
        return this.data.isSparse() ? (ElectricalCapacitanceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of ElectricalCapacitance Scalars from this vector.
     * @return ElectricalCapacitance[]; an array of ElectricalCapacitance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public ElectricalCapacitance[] toArray()
    {
        ElectricalCapacitance[] array = new ElectricalCapacitance[size()];
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
