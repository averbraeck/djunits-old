package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double LinearDensityVector, a vector of values with a LinearDensityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableLinearDensityVector extends
    AbstractMutableDoubleVectorRel<LinearDensityUnit, LinearDensityVector, MutableLinearDensityVector, LinearDensity> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double LinearDensityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double LinearDensityVector
     * @param unit LinearDensityUnit; the unit of the new Relative Immutable Double LinearDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLinearDensityVector(final double[] values, final LinearDensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LinearDensityVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double LinearDensityVector
     * @param unit LinearDensityUnit; the unit of the new Relative Immutable Double LinearDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLinearDensityVector(final List<Double> values, final LinearDensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LinearDensityVector.
     * @param values LinearDensity[]; the values of the entries in the new Relative Immutable Double LinearDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLinearDensityVector(final LinearDensity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LinearDensityVector.
     * @param values List&lt;LinearDensity&gt;; the values of the entries in the new Relative Immutable Double LinearDensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLinearDensityVector(final List<LinearDensity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LinearDensityVector.
     * @param values SortedMap&lt;Integer, LinearDensity&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            LinearDensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLinearDensityVector(final SortedMap<Integer, LinearDensity> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LinearDensityVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double LinearDensityVector
     * @param unit LinearDensityUnit; the unit of the new Relative Sparse Mutable Double LinearDensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLinearDensityVector(final SortedMap<Integer, Double> values, final LinearDensityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit LinearDensityUnit; the unit
     */
    MutableLinearDensityVector(final DoubleVectorData data, final LinearDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LinearDensityVector instantiateType(final DoubleVectorData dvd, final LinearDensityUnit unit)
    {
        return new LinearDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableLinearDensityVector instantiateMutableType(final DoubleVectorData dvd, final LinearDensityUnit unit)
    {
        return new MutableLinearDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LinearDensity instantiateScalar(final double value, final LinearDensityUnit unit)
    {
        return new LinearDensity(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector toDense()
    {
        return this.data.isDense() ? (MutableLinearDensityVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityVector toSparse()
    {
        return this.data.isSparse() ? (MutableLinearDensityVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of LinearDensity Scalars from this vector.
     * @return LinearDensity[]; an array of LinearDensity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public LinearDensity[] toArray()
    {
        LinearDensity[] array = new LinearDensity[size()];
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
