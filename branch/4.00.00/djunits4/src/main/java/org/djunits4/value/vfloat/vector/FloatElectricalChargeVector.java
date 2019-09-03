package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalChargeUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatElectricalCharge;

/**
 * Immutable Float FloatElectricalChargeVector, a vector of values with a ElectricalChargeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatElectricalChargeVector extends AbstractFloatVectorRel<ElectricalChargeUnit, FloatElectricalChargeVector,
        MutableFloatElectricalChargeVector, FloatElectricalCharge>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatElectricalChargeVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatElectricalChargeVector
     * @param unit ElectricalChargeUnit; the unit of the new Relative Immutable Float FloatElectricalChargeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalChargeVector(final float[] values, final ElectricalChargeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalChargeVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalChargeVector
     * @param unit ElectricalChargeUnit; the unit of the new Relative Immutable Float FloatElectricalChargeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalChargeVector(final List<Float> values, final ElectricalChargeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalChargeVector.
     * @param values FloatElectricalCharge[]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalChargeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalChargeVector(final FloatElectricalCharge[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalChargeVector.
     * @param values List&lt;FloatElectricalCharge&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalChargeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalChargeVector(final List<FloatElectricalCharge> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalChargeVector.
     * @param values SortedMap&lt;Integer, FloatElectricalCharge&gt;; the values of the entries in the new Relative Sparse
     *            Mutable Float FloatElectricalChargeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalChargeVector(final SortedMap<Integer, FloatElectricalCharge> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalChargeVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatElectricalChargeVector
     * @param unit ElectricalChargeUnit; the unit of the new Relative Sparse Mutable Float FloatElectricalChargeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalChargeVector(final SortedMap<Integer, Float> values, final ElectricalChargeUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatElectricalChargeVector(final FloatVectorData data, final ElectricalChargeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalChargeVector instantiateType(final FloatVectorData dvd, final ElectricalChargeUnit unit)
    {
        return new FloatElectricalChargeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalChargeVector instantiateMutableType(final FloatVectorData dvd,
            final ElectricalChargeUnit unit)
    {
        return new MutableFloatElectricalChargeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCharge instantiateScalar(final float value, final ElectricalChargeUnit unit)
    {
        return new FloatElectricalCharge(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalChargeVector toDense()
    {
        return this.data.isDense() ? (FloatElectricalChargeVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalChargeVector toSparse()
    {
        return this.data.isSparse() ? (FloatElectricalChargeVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatElectricalCharge Scalars from this vector.
     * @return FloatElectricalCharge[]; an array of FloatElectricalCharge Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalCharge[] toArray()
    {
        FloatElectricalCharge[] array = new FloatElectricalCharge[size()];
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