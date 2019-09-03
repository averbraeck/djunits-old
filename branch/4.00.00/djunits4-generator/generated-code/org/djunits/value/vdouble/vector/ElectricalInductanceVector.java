package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double ElectricalInductanceVector, a vector of values with a ElectricalInductanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.181Z")
public class ElectricalInductanceVector extends
    AbstractDoubleVectorRel<ElectricalInductanceUnit, ElectricalInductanceVector, MutableElectricalInductanceVector, ElectricalInductance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalInductanceVector
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Immutable Double ElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalInductanceVector(final double[] values, final ElectricalInductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double ElectricalInductanceVector
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Immutable Double ElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalInductanceVector(final List<Double> values, final ElectricalInductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values ElectricalInductance[]; the values of the entries in the new Relative Immutable Double ElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalInductanceVector(final ElectricalInductance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values List&lt;ElectricalInductance&gt;; the values of the entries in the new Relative Immutable Double ElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalInductanceVector(final List<ElectricalInductance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values SortedMap&lt;Integer, ElectricalInductance&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            ElectricalInductanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalInductanceVector(final SortedMap<Integer, ElectricalInductance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double ElectricalInductanceVector
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Sparse Mutable Double ElectricalInductanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalInductanceVector(final SortedMap<Integer, Double> values, final ElectricalInductanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit ElectricalInductanceUnit; the unit
     */
    ElectricalInductanceVector(final DoubleVectorData data, final ElectricalInductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalInductanceVector instantiateType(final DoubleVectorData dvd, final ElectricalInductanceUnit unit)
    {
        return new ElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalInductanceVector instantiateMutableType(final DoubleVectorData dvd, final ElectricalInductanceUnit unit)
    {
        return new MutableElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalInductance instantiateScalar(final double value, final ElectricalInductanceUnit unit)
    {
        return new ElectricalInductance(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final ElectricalInductanceVector toDense()
    {
        return this.data.isDense() ? (ElectricalInductanceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalInductanceVector toSparse()
    {
        return this.data.isSparse() ? (ElectricalInductanceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of ElectricalInductance Scalars from this vector.
     * @return ElectricalInductance[]; an array of ElectricalInductance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public ElectricalInductance[] toArray()
    {
        ElectricalInductance[] array = new ElectricalInductance[size()];
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
