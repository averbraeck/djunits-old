package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double ElectricalChargeVector, a vector of values with a ElectricalChargeUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.165Z")
public class ElectricalChargeVector extends
    AbstractDoubleVectorRel<ElectricalChargeUnit, ElectricalChargeVector, MutableElectricalChargeVector, ElectricalCharge>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalChargeVector
     * @param unit ElectricalChargeUnit; the unit of the new Relative Immutable Double ElectricalChargeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalChargeVector(final double[] values, final ElectricalChargeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double ElectricalChargeVector
     * @param unit ElectricalChargeUnit; the unit of the new Relative Immutable Double ElectricalChargeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalChargeVector(final List<Double> values, final ElectricalChargeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values ElectricalCharge[]; the values of the entries in the new Relative Immutable Double ElectricalChargeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalChargeVector(final ElectricalCharge[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values List&lt;ElectricalCharge&gt;; the values of the entries in the new Relative Immutable Double ElectricalChargeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalChargeVector(final List<ElectricalCharge> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values SortedMap&lt;Integer, ElectricalCharge&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            ElectricalChargeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalChargeVector(final SortedMap<Integer, ElectricalCharge> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double ElectricalChargeVector
     * @param unit ElectricalChargeUnit; the unit of the new Relative Sparse Mutable Double ElectricalChargeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalChargeVector(final SortedMap<Integer, Double> values, final ElectricalChargeUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit ElectricalChargeUnit; the unit
     */
    ElectricalChargeVector(final DoubleVectorData data, final ElectricalChargeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalChargeVector instantiateType(final DoubleVectorData dvd, final ElectricalChargeUnit unit)
    {
        return new ElectricalChargeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalChargeVector instantiateMutableType(final DoubleVectorData dvd, final ElectricalChargeUnit unit)
    {
        return new MutableElectricalChargeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCharge instantiateScalar(final double value, final ElectricalChargeUnit unit)
    {
        return new ElectricalCharge(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final ElectricalChargeVector toDense()
    {
        return this.data.isDense() ? (ElectricalChargeVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalChargeVector toSparse()
    {
        return this.data.isSparse() ? (ElectricalChargeVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of ElectricalCharge Scalars from this vector.
     * @return ElectricalCharge[]; an array of ElectricalCharge Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public ElectricalCharge[] toArray()
    {
        ElectricalCharge[] array = new ElectricalCharge[size()];
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
