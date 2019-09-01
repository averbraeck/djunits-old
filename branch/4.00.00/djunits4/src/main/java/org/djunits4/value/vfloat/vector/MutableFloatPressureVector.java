package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.PressureUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatPressure;

/**
 * Mutable Float PressureVector, a vector of values with a PressureUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatPressureVector
        extends AbstractMutableFloatVectorRel<PressureUnit, FloatPressureVector, MutableFloatPressureVector, FloatPressure>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float PressureVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float PressureVector
     * @param unit PressureUnit; the unit of the new Relative Immutable Float PressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPressureVector(final float[] values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PressureVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float PressureVector
     * @param unit PressureUnit; the unit of the new Relative Immutable Float PressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPressureVector(final List<Float> values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PressureVector.
     * @param values FloatPressure[]; the values of the entries in the new Relative Immutable Float PressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPressureVector(final FloatPressure[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PressureVector.
     * @param values List&lt;FloatPressure&gt;; the values of the entries in the new Relative Immutable Float PressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPressureVector(final List<FloatPressure> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PressureVector.
     * @param values SortedMap&lt;Integer, FloatPressure&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            PressureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPressureVector(final SortedMap<Integer, FloatPressure> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float PressureVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            PressureVector
     * @param unit PressureUnit; the unit of the new Relative Sparse Mutable Float PressureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPressureVector(final SortedMap<Integer, Float> values, final PressureUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatPressureVector(final FloatVectorData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPressureVector instantiateType(final FloatVectorData dvd, final PressureUnit unit)
    {
        return new FloatPressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPressureVector instantiateMutableType(final FloatVectorData dvd, final PressureUnit unit)
    {
        return new MutableFloatPressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPressure instantiateScalar(final float value, final PressureUnit unit)
    {
        return new FloatPressure(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPressureVector toDense()
    {
        return this.data.isDense() ? (MutableFloatPressureVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatPressureVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatPressureVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatPressure Scalars from this vector.
     * @return FloatPressure[]; an array of FloatPressure Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatPressure[] toArray()
    {
        FloatPressure[] array = new FloatPressure[size()];
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
