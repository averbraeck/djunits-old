package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double TorqueVector, a vector of values with a TorqueUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.181Z")
public class TorqueVector extends
    AbstractDoubleVectorRel<TorqueUnit, TorqueVector, MutableTorqueVector, Torque>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Immutable Double TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TorqueVector(final double[] values, final TorqueUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Immutable Double TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TorqueVector(final List<Double> values, final TorqueUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values Torque[]; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TorqueVector(final Torque[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values List&lt;Torque&gt;; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TorqueVector(final List<Torque> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values SortedMap&lt;Integer, Torque&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            TorqueVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TorqueVector(final SortedMap<Integer, Torque> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double TorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Sparse Mutable Double TorqueVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TorqueVector(final SortedMap<Integer, Double> values, final TorqueUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit TorqueUnit; the unit
     */
    TorqueVector(final DoubleVectorData data, final TorqueUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final TorqueVector instantiateType(final DoubleVectorData dvd, final TorqueUnit unit)
    {
        return new TorqueVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableTorqueVector instantiateMutableType(final DoubleVectorData dvd, final TorqueUnit unit)
    {
        return new MutableTorqueVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Torque instantiateScalar(final double value, final TorqueUnit unit)
    {
        return new Torque(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final TorqueVector toDense()
    {
        return this.data.isDense() ? (TorqueVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final TorqueVector toSparse()
    {
        return this.data.isSparse() ? (TorqueVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of Torque Scalars from this vector.
     * @return Torque[]; an array of Torque Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Torque[] toArray()
    {
        Torque[] array = new Torque[size()];
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
