package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double EquivalentDoseVector, a vector of values with a EquivalentDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class EquivalentDoseVector extends
    AbstractDoubleVectorRel<EquivalentDoseUnit, EquivalentDoseVector, MutableEquivalentDoseVector, EquivalentDose>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double EquivalentDoseVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double EquivalentDoseVector
     * @param unit EquivalentDoseUnit; the unit of the new Relative Immutable Double EquivalentDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public EquivalentDoseVector(final double[] values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EquivalentDoseVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double EquivalentDoseVector
     * @param unit EquivalentDoseUnit; the unit of the new Relative Immutable Double EquivalentDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public EquivalentDoseVector(final List<Double> values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EquivalentDoseVector.
     * @param values EquivalentDose[]; the values of the entries in the new Relative Immutable Double EquivalentDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public EquivalentDoseVector(final EquivalentDose[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EquivalentDoseVector.
     * @param values List&lt;EquivalentDose&gt;; the values of the entries in the new Relative Immutable Double EquivalentDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public EquivalentDoseVector(final List<EquivalentDose> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EquivalentDoseVector.
     * @param values SortedMap&lt;Integer, EquivalentDose&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            EquivalentDoseVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public EquivalentDoseVector(final SortedMap<Integer, EquivalentDose> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EquivalentDoseVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double EquivalentDoseVector
     * @param unit EquivalentDoseUnit; the unit of the new Relative Sparse Mutable Double EquivalentDoseVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public EquivalentDoseVector(final SortedMap<Integer, Double> values, final EquivalentDoseUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit EquivalentDoseUnit; the unit
     */
    EquivalentDoseVector(final DoubleVectorData data, final EquivalentDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final EquivalentDoseVector instantiateType(final DoubleVectorData dvd, final EquivalentDoseUnit unit)
    {
        return new EquivalentDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableEquivalentDoseVector instantiateMutableType(final DoubleVectorData dvd, final EquivalentDoseUnit unit)
    {
        return new MutableEquivalentDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final EquivalentDose instantiateScalar(final double value, final EquivalentDoseUnit unit)
    {
        return new EquivalentDose(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final EquivalentDoseVector toDense()
    {
        return this.data.isDense() ? (EquivalentDoseVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final EquivalentDoseVector toSparse()
    {
        return this.data.isSparse() ? (EquivalentDoseVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of EquivalentDose Scalars from this vector.
     * @return EquivalentDose[]; an array of EquivalentDose Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public EquivalentDose[] toArray()
    {
        EquivalentDose[] array = new EquivalentDose[size()];
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
