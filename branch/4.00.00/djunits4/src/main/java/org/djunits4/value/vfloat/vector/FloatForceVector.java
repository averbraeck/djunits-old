package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.ForceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatForce;

/**
 * Immutable Float FloatForceVector, a vector of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatForceVector extends AbstractFloatVectorRel<ForceUnit, FloatForceVector, MutableFloatForceVector, FloatForce>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatForceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatForceVector
     * @param unit ForceUnit; the unit of the new Relative Immutable Float FloatForceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatForceVector(final float[] values, final ForceUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatForceVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatForceVector
     * @param unit ForceUnit; the unit of the new Relative Immutable Float FloatForceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatForceVector(final List<Float> values, final ForceUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatForceVector.
     * @param values FloatForce[]; the values of the entries in the new Relative Immutable Float FloatForceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatForceVector(final FloatForce[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatForceVector.
     * @param values List&lt;FloatForce&gt;; the values of the entries in the new Relative Immutable Float FloatForceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatForceVector(final List<FloatForce> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatForceVector.
     * @param values SortedMap&lt;Integer, FloatForce&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatForceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatForceVector(final SortedMap<Integer, FloatForce> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatForceVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatForceVector
     * @param unit ForceUnit; the unit of the new Relative Sparse Mutable Float FloatForceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatForceVector(final SortedMap<Integer, Float> values, final ForceUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatForceVector(final FloatVectorData data, final ForceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatForceVector instantiateType(final FloatVectorData dvd, final ForceUnit unit)
    {
        return new FloatForceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatForceVector instantiateMutableType(final FloatVectorData dvd, final ForceUnit unit)
    {
        return new MutableFloatForceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatForce instantiateScalar(final float value, final ForceUnit unit)
    {
        return new FloatForce(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForceVector toDense()
    {
        return this.data.isDense() ? (FloatForceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForceVector toSparse()
    {
        return this.data.isSparse() ? (FloatForceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatForce Scalars from this vector.
     * @return FloatForce[]; an array of FloatForce Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatForce[] toArray()
    {
        FloatForce[] array = new FloatForce[size()];
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
