package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.LuminousIntensityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.LuminousIntensity;

/**
 * Immutable Double LuminousIntensityVector, a vector of values with a LuminousIntensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class LuminousIntensityVector extends AbstractDoubleVectorRel<LuminousIntensityUnit, LuminousIntensityVector,
        MutableLuminousIntensityVector, LuminousIntensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double LuminousIntensityVector
     * @param unit LuminousIntensityUnit; the unit of the new Relative Immutable Double LuminousIntensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public LuminousIntensityVector(final double[] values, final LuminousIntensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double LuminousIntensityVector
     * @param unit LuminousIntensityUnit; the unit of the new Relative Immutable Double LuminousIntensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public LuminousIntensityVector(final List<Double> values, final LuminousIntensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values LuminousIntensity[]; the values of the entries in the new Relative Immutable Double LuminousIntensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public LuminousIntensityVector(final LuminousIntensity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values List&lt;LuminousIntensity&gt;; the values of the entries in the new Relative Immutable Double
     *            LuminousIntensityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public LuminousIntensityVector(final List<LuminousIntensity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values SortedMap&lt;Integer, LuminousIntensity&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Double LuminousIntensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public LuminousIntensityVector(final SortedMap<Integer, LuminousIntensity> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            LuminousIntensityVector
     * @param unit LuminousIntensityUnit; the unit of the new Relative Sparse Mutable Double LuminousIntensityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public LuminousIntensityVector(final SortedMap<Integer, Double> values, final LuminousIntensityUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit LuminousIntensityUnit; the unit
     */
    LuminousIntensityVector(final DoubleVectorData data, final LuminousIntensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LuminousIntensityVector instantiateType(final DoubleVectorData dvd, final LuminousIntensityUnit unit)
    {
        return new LuminousIntensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableLuminousIntensityVector instantiateMutableType(final DoubleVectorData dvd,
            final LuminousIntensityUnit unit)
    {
        return new MutableLuminousIntensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LuminousIntensity instantiateScalar(final double value, final LuminousIntensityUnit unit)
    {
        return new LuminousIntensity(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final LuminousIntensityVector toDense()
    {
        return this.data.isDense() ? (LuminousIntensityVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LuminousIntensityVector toSparse()
    {
        return this.data.isSparse() ? (LuminousIntensityVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of LuminousIntensity Scalars from this vector.
     * @return LuminousIntensity[]; an array of LuminousIntensity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public LuminousIntensity[] toArray()
    {
        LuminousIntensity[] array = new LuminousIntensity[size()];
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
