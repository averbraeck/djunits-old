package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.IlluminanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Illuminance;

/**
 * Mutable Double IlluminanceVector, a vector of values with a IlluminanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.197Z")
public class MutableIlluminanceVector
        extends AbstractMutableDoubleVectorRel<IlluminanceUnit, IlluminanceVector, MutableIlluminanceVector, Illuminance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double IlluminanceVector
     * @param unit IlluminanceUnit; the unit of the new Relative Immutable Double IlluminanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableIlluminanceVector(final double[] values, final IlluminanceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double IlluminanceVector
     * @param unit IlluminanceUnit; the unit of the new Relative Immutable Double IlluminanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableIlluminanceVector(final List<Double> values, final IlluminanceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values Illuminance[]; the values of the entries in the new Relative Immutable Double IlluminanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableIlluminanceVector(final Illuminance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values List&lt;Illuminance&gt;; the values of the entries in the new Relative Immutable Double IlluminanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableIlluminanceVector(final List<Illuminance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values SortedMap&lt;Integer, Illuminance&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            IlluminanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableIlluminanceVector(final SortedMap<Integer, Illuminance> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            IlluminanceVector
     * @param unit IlluminanceUnit; the unit of the new Relative Sparse Mutable Double IlluminanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableIlluminanceVector(final SortedMap<Integer, Double> values, final IlluminanceUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit IlluminanceUnit; the unit
     */
    MutableIlluminanceVector(final DoubleVectorData data, final IlluminanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final IlluminanceVector instantiateType(final DoubleVectorData dvd, final IlluminanceUnit unit)
    {
        return new IlluminanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableIlluminanceVector instantiateMutableType(final DoubleVectorData dvd, final IlluminanceUnit unit)
    {
        return new MutableIlluminanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Illuminance instantiateScalar(final double value, final IlluminanceUnit unit)
    {
        return new Illuminance(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableIlluminanceVector toDense()
    {
        return this.data.isDense() ? (MutableIlluminanceVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableIlluminanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableIlluminanceVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Illuminance Scalars from this vector.
     * @return Illuminance[]; an array of Illuminance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Illuminance[] toArray()
    {
        Illuminance[] array = new Illuminance[size()];
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
