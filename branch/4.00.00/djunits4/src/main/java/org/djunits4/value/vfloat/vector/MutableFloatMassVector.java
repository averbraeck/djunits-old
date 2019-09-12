package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.MassUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatMass;

/**
 * Mutable Float MassVector, a vector of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatMassVector
        extends AbstractMutableFloatVectorRel<MassUnit, FloatMassVector, MutableFloatMassVector, FloatMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float MassVector
     * @param unit MassUnit; the unit of the new Relative Immutable Float MassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatMassVector(final float[] values, final MassUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float MassVector
     * @param unit MassUnit; the unit of the new Relative Immutable Float MassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatMassVector(final List<Float> values, final MassUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values FloatMass[]; the values of the entries in the new Relative Immutable Float MassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatMassVector(final FloatMass[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values List&lt;FloatMass&gt;; the values of the entries in the new Relative Immutable Float MassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatMassVector(final List<FloatMass> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values SortedMap&lt;Integer, FloatMass&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            MassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatMassVector(final SortedMap<Integer, FloatMass> values, final int length, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            MassVector
     * @param unit MassUnit; the unit of the new Relative Sparse Mutable Float MassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatMassVector(final SortedMap<Integer, Float> values, final MassUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatMassVector(final FloatVectorData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMassVector instantiateType(final FloatVectorData dvd, final MassUnit unit)
    {
        return new FloatMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMassVector instantiateMutableType(final FloatVectorData dvd, final MassUnit unit)
    {
        return new MutableFloatMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMass instantiateScalar(final float value, final MassUnit unit)
    {
        return new FloatMass(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMassVector toDense()
    {
        return this.data.isDense() ? (MutableFloatMassVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMassVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatMassVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatMass Scalars from this vector.
     * @return FloatMass[]; an array of FloatMass Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMass[] toArray()
    {
        FloatMass[] array = new FloatMass[size()];
        for (int i = 0; i < size(); i++)
        {
            try
            {
                array[i] = get(i);
            }
            catch (ValueRuntimeException exception)
            {
                throw new RuntimeException(exception);
            }
        }
        return array;
    }

}
