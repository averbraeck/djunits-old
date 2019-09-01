package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.ElectricalResistance;

/**
 * Mutable Double ElectricalResistanceVector, a vector of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableElectricalResistanceVector extends AbstractMutableDoubleVectorRel<ElectricalResistanceUnit,
        ElectricalResistanceVector, MutableElectricalResistanceVector, ElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalResistanceVector
     * @param unit ElectricalResistanceUnit; the unit of the new Relative Immutable Double ElectricalResistanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalResistanceVector(final double[] values, final ElectricalResistanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double
     *            ElectricalResistanceVector
     * @param unit ElectricalResistanceUnit; the unit of the new Relative Immutable Double ElectricalResistanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalResistanceVector(final List<Double> values, final ElectricalResistanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values ElectricalResistance[]; the values of the entries in the new Relative Immutable Double
     *            ElectricalResistanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalResistanceVector(final ElectricalResistance[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values List&lt;ElectricalResistance&gt;; the values of the entries in the new Relative Immutable Double
     *            ElectricalResistanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalResistanceVector(final List<ElectricalResistance> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values SortedMap&lt;Integer, ElectricalResistance&gt;; the values of the entries in the new Relative Sparse
     *            Mutable Double ElectricalResistanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalResistanceVector(final SortedMap<Integer, ElectricalResistance> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            ElectricalResistanceVector
     * @param unit ElectricalResistanceUnit; the unit of the new Relative Sparse Mutable Double ElectricalResistanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalResistanceVector(final SortedMap<Integer, Double> values, final ElectricalResistanceUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit ElectricalResistanceUnit; the unit
     */
    MutableElectricalResistanceVector(final DoubleVectorData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalResistanceVector instantiateType(final DoubleVectorData dvd, final ElectricalResistanceUnit unit)
    {
        return new ElectricalResistanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalResistanceVector instantiateMutableType(final DoubleVectorData dvd,
            final ElectricalResistanceUnit unit)
    {
        return new MutableElectricalResistanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalResistance instantiateScalar(final double value, final ElectricalResistanceUnit unit)
    {
        return new ElectricalResistance(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalResistanceVector toDense()
    {
        return this.data.isDense() ? (MutableElectricalResistanceVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalResistanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableElectricalResistanceVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of ElectricalResistance Scalars from this vector.
     * @return ElectricalResistance[]; an array of ElectricalResistance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public ElectricalResistance[] toArray()
    {
        ElectricalResistance[] array = new ElectricalResistance[size()];
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
