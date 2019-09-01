package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalPotentialUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatElectricalPotential;

/**
 * Immutable Float FloatElectricalPotentialVector, a vector of values with a ElectricalPotentialUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatElectricalPotentialVector extends AbstractFloatVectorRel<ElectricalPotentialUnit,
        FloatElectricalPotentialVector, MutableFloatElectricalPotentialVector, FloatElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatElectricalPotentialVector
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Immutable Float FloatElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalPotentialVector(final float[] values, final ElectricalPotentialUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalPotentialVector
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Immutable Float FloatElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalPotentialVector(final List<Float> values, final ElectricalPotentialUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values FloatElectricalPotential[]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalPotentialVector(final FloatElectricalPotential[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values List&lt;FloatElectricalPotential&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalPotentialVector(final List<FloatElectricalPotential> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values SortedMap&lt;Integer, FloatElectricalPotential&gt;; the values of the entries in the new Relative Sparse
     *            Mutable Float FloatElectricalPotentialVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalPotentialVector(final SortedMap<Integer, FloatElectricalPotential> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatElectricalPotentialVector
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Sparse Mutable Float FloatElectricalPotentialVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalPotentialVector(final SortedMap<Integer, Float> values, final ElectricalPotentialUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatElectricalPotentialVector(final FloatVectorData data, final ElectricalPotentialUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotentialVector instantiateType(final FloatVectorData dvd,
            final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotentialVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalPotentialVector instantiateMutableType(final FloatVectorData dvd,
            final ElectricalPotentialUnit unit)
    {
        return new MutableFloatElectricalPotentialVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotential instantiateScalar(final float value, final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotential(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotentialVector toDense()
    {
        return this.data.isDense() ? (FloatElectricalPotentialVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotentialVector toSparse()
    {
        return this.data.isSparse() ? (FloatElectricalPotentialVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatElectricalPotential Scalars from this vector.
     * @return FloatElectricalPotential[]; an array of FloatElectricalPotential Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalPotential[] toArray()
    {
        FloatElectricalPotential[] array = new FloatElectricalPotential[size()];
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
