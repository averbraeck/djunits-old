package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.AmountOfSubstanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.AmountOfSubstance;

/**
 * Mutable Double AmountOfSubstanceVector, a vector of values with a AmountOfSubstanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableAmountOfSubstanceVector extends AbstractMutableDoubleVectorRel<AmountOfSubstanceUnit,
        AmountOfSubstanceVector, MutableAmountOfSubstanceVector, AmountOfSubstance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double AmountOfSubstanceVector
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Immutable Double AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAmountOfSubstanceVector(final double[] values, final AmountOfSubstanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double AmountOfSubstanceVector
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Immutable Double AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAmountOfSubstanceVector(final List<Double> values, final AmountOfSubstanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values AmountOfSubstance[]; the values of the entries in the new Relative Immutable Double AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAmountOfSubstanceVector(final AmountOfSubstance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values List&lt;AmountOfSubstance&gt;; the values of the entries in the new Relative Immutable Double
     *            AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAmountOfSubstanceVector(final List<AmountOfSubstance> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values SortedMap&lt;Integer, AmountOfSubstance&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Double AmountOfSubstanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAmountOfSubstanceVector(final SortedMap<Integer, AmountOfSubstance> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            AmountOfSubstanceVector
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Sparse Mutable Double AmountOfSubstanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAmountOfSubstanceVector(final SortedMap<Integer, Double> values, final AmountOfSubstanceUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit AmountOfSubstanceUnit; the unit
     */
    MutableAmountOfSubstanceVector(final DoubleVectorData data, final AmountOfSubstanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AmountOfSubstanceVector instantiateType(final DoubleVectorData dvd, final AmountOfSubstanceUnit unit)
    {
        return new AmountOfSubstanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAmountOfSubstanceVector instantiateMutableType(final DoubleVectorData dvd,
            final AmountOfSubstanceUnit unit)
    {
        return new MutableAmountOfSubstanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AmountOfSubstance instantiateScalar(final double value, final AmountOfSubstanceUnit unit)
    {
        return new AmountOfSubstance(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAmountOfSubstanceVector toDense()
    {
        return this.data.isDense() ? (MutableAmountOfSubstanceVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAmountOfSubstanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableAmountOfSubstanceVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of AmountOfSubstance Scalars from this vector.
     * @return AmountOfSubstance[]; an array of AmountOfSubstance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public AmountOfSubstance[] toArray()
    {
        AmountOfSubstance[] array = new AmountOfSubstance[size()];
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
