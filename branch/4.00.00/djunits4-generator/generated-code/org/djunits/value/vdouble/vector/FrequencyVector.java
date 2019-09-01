package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double FrequencyVector, a vector of values with a FrequencyUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FrequencyVector extends
    AbstractDoubleVectorRel<FrequencyUnit, FrequencyVector, MutableFrequencyVector, Frequency>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double FrequencyVector
     * @param unit FrequencyUnit; the unit of the new Relative Immutable Double FrequencyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FrequencyVector(final double[] values, final FrequencyUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double FrequencyVector
     * @param unit FrequencyUnit; the unit of the new Relative Immutable Double FrequencyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FrequencyVector(final List<Double> values, final FrequencyUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values Frequency[]; the values of the entries in the new Relative Immutable Double FrequencyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FrequencyVector(final Frequency[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values List&lt;Frequency&gt;; the values of the entries in the new Relative Immutable Double FrequencyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FrequencyVector(final List<Frequency> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values SortedMap&lt;Integer, Frequency&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            FrequencyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FrequencyVector(final SortedMap<Integer, Frequency> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double FrequencyVector
     * @param unit FrequencyUnit; the unit of the new Relative Sparse Mutable Double FrequencyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FrequencyVector(final SortedMap<Integer, Double> values, final FrequencyUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit FrequencyUnit; the unit
     */
    FrequencyVector(final DoubleVectorData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FrequencyVector instantiateType(final DoubleVectorData dvd, final FrequencyUnit unit)
    {
        return new FrequencyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFrequencyVector instantiateMutableType(final DoubleVectorData dvd, final FrequencyUnit unit)
    {
        return new MutableFrequencyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Frequency instantiateScalar(final double value, final FrequencyUnit unit)
    {
        return new Frequency(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FrequencyVector toDense()
    {
        return this.data.isDense() ? (FrequencyVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FrequencyVector toSparse()
    {
        return this.data.isSparse() ? (FrequencyVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of Frequency Scalars from this vector.
     * @return Frequency[]; an array of Frequency Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Frequency[] toArray()
    {
        Frequency[] array = new Frequency[size()];
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
