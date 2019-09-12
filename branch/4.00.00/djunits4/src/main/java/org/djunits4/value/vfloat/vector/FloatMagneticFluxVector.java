package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.MagneticFluxUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatMagneticFlux;

/**
 * Immutable Float FloatMagneticFluxVector, a vector of values with a MagneticFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class FloatMagneticFluxVector extends
        AbstractFloatVectorRel<MagneticFluxUnit, FloatMagneticFluxVector, MutableFloatMagneticFluxVector, FloatMagneticFlux>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMagneticFluxVector
     * @param unit MagneticFluxUnit; the unit of the new Relative Immutable Float FloatMagneticFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatMagneticFluxVector(final float[] values, final MagneticFluxUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatMagneticFluxVector
     * @param unit MagneticFluxUnit; the unit of the new Relative Immutable Float FloatMagneticFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatMagneticFluxVector(final List<Float> values, final MagneticFluxUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values FloatMagneticFlux[]; the values of the entries in the new Relative Immutable Float FloatMagneticFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatMagneticFluxVector(final FloatMagneticFlux[] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values List&lt;FloatMagneticFlux&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatMagneticFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatMagneticFluxVector(final List<FloatMagneticFlux> values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values SortedMap&lt;Integer, FloatMagneticFlux&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float FloatMagneticFluxVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatMagneticFluxVector(final SortedMap<Integer, FloatMagneticFlux> values, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatMagneticFluxVector
     * @param unit MagneticFluxUnit; the unit of the new Relative Sparse Mutable Float FloatMagneticFluxVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatMagneticFluxVector(final SortedMap<Integer, Float> values, final MagneticFluxUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatMagneticFluxVector(final FloatVectorData data, final MagneticFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFluxVector instantiateType(final FloatVectorData dvd, final MagneticFluxUnit unit)
    {
        return new FloatMagneticFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMagneticFluxVector instantiateMutableType(final FloatVectorData dvd,
            final MagneticFluxUnit unit)
    {
        return new MutableFloatMagneticFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFlux instantiateScalar(final float value, final MagneticFluxUnit unit)
    {
        return new FloatMagneticFlux(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxVector toDense()
    {
        return this.data.isDense() ? (FloatMagneticFluxVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxVector toSparse()
    {
        return this.data.isSparse() ? (FloatMagneticFluxVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatMagneticFlux Scalars from this vector.
     * @return FloatMagneticFlux[]; an array of FloatMagneticFlux Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMagneticFlux[] toArray()
    {
        FloatMagneticFlux[] array = new FloatMagneticFlux[size()];
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
