package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double RadioActivityVector, a vector of values with a RadioActivityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class RadioActivityVector extends
    AbstractDoubleVectorRel<RadioActivityUnit, RadioActivityVector, MutableRadioActivityVector, RadioActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double RadioActivityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double RadioActivityVector
     * @param unit RadioActivityUnit; the unit of the new Relative Immutable Double RadioActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public RadioActivityVector(final double[] values, final RadioActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double RadioActivityVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double RadioActivityVector
     * @param unit RadioActivityUnit; the unit of the new Relative Immutable Double RadioActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public RadioActivityVector(final List<Double> values, final RadioActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double RadioActivityVector.
     * @param values RadioActivity[]; the values of the entries in the new Relative Immutable Double RadioActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public RadioActivityVector(final RadioActivity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double RadioActivityVector.
     * @param values List&lt;RadioActivity&gt;; the values of the entries in the new Relative Immutable Double RadioActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public RadioActivityVector(final List<RadioActivity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double RadioActivityVector.
     * @param values SortedMap&lt;Integer, RadioActivity&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            RadioActivityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public RadioActivityVector(final SortedMap<Integer, RadioActivity> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double RadioActivityVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double RadioActivityVector
     * @param unit RadioActivityUnit; the unit of the new Relative Sparse Mutable Double RadioActivityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public RadioActivityVector(final SortedMap<Integer, Double> values, final RadioActivityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit RadioActivityUnit; the unit
     */
    RadioActivityVector(final DoubleVectorData data, final RadioActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final RadioActivityVector instantiateType(final DoubleVectorData dvd, final RadioActivityUnit unit)
    {
        return new RadioActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableRadioActivityVector instantiateMutableType(final DoubleVectorData dvd, final RadioActivityUnit unit)
    {
        return new MutableRadioActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final RadioActivity instantiateScalar(final double value, final RadioActivityUnit unit)
    {
        return new RadioActivity(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final RadioActivityVector toDense()
    {
        return this.data.isDense() ? (RadioActivityVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final RadioActivityVector toSparse()
    {
        return this.data.isSparse() ? (RadioActivityVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of RadioActivity Scalars from this vector.
     * @return RadioActivity[]; an array of RadioActivity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public RadioActivity[] toArray()
    {
        RadioActivity[] array = new RadioActivity[size()];
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
