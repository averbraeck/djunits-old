package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double DensityVector, a vector of values with a DensityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class DensityVector extends
    AbstractDoubleVectorRel<DensityUnit, DensityVector, MutableDensityVector, Density>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double DensityVector
     * @param unit DensityUnit; the unit of the new Relative Immutable Double DensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DensityVector(final double[] values, final DensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double DensityVector
     * @param unit DensityUnit; the unit of the new Relative Immutable Double DensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DensityVector(final List<Double> values, final DensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values Density[]; the values of the entries in the new Relative Immutable Double DensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DensityVector(final Density[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values List&lt;Density&gt;; the values of the entries in the new Relative Immutable Double DensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DensityVector(final List<Density> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values SortedMap&lt;Integer, Density&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            DensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DensityVector(final SortedMap<Integer, Density> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double DensityVector
     * @param unit DensityUnit; the unit of the new Relative Sparse Mutable Double DensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DensityVector(final SortedMap<Integer, Double> values, final DensityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit DensityUnit; the unit
     */
    DensityVector(final DoubleVectorData data, final DensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DensityVector instantiateType(final DoubleVectorData dvd, final DensityUnit unit)
    {
        return new DensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDensityVector instantiateMutableType(final DoubleVectorData dvd, final DensityUnit unit)
    {
        return new MutableDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Density instantiateScalar(final double value, final DensityUnit unit)
    {
        return new Density(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final DensityVector toDense()
    {
        return this.data.isDense() ? (DensityVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final DensityVector toSparse()
    {
        return this.data.isSparse() ? (DensityVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of Density Scalars from this vector.
     * @return Density[]; an array of Density Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Density[] toArray()
    {
        Density[] array = new Density[size()];
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
