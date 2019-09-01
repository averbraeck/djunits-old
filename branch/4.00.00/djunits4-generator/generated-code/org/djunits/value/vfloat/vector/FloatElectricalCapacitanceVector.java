package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatElectricalCapacitanceVector, a vector of values with a ElectricalCapacitanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatElectricalCapacitanceVector extends
    AbstractFloatVectorRel<ElectricalCapacitanceUnit, FloatElectricalCapacitanceVector, MutableFloatElectricalCapacitanceVector, FloatElectricalCapacitance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatElectricalCapacitanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatElectricalCapacitanceVector
     * @param unit ElectricalCapacitanceUnit; the unit of the new Relative Immutable Float FloatElectricalCapacitanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalCapacitanceVector(final float[] values, final ElectricalCapacitanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCapacitanceVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatElectricalCapacitanceVector
     * @param unit ElectricalCapacitanceUnit; the unit of the new Relative Immutable Float FloatElectricalCapacitanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalCapacitanceVector(final List<Float> values, final ElectricalCapacitanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCapacitanceVector.
     * @param values FloatElectricalCapacitance[]; the values of the entries in the new Relative Immutable Float FloatElectricalCapacitanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalCapacitanceVector(final FloatElectricalCapacitance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCapacitanceVector.
     * @param values List&lt;FloatElectricalCapacitance&gt;; the values of the entries in the new Relative Immutable Float FloatElectricalCapacitanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalCapacitanceVector(final List<FloatElectricalCapacitance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCapacitanceVector.
     * @param values SortedMap&lt;Integer, FloatElectricalCapacitance&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatElectricalCapacitanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalCapacitanceVector(final SortedMap<Integer, FloatElectricalCapacitance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCapacitanceVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float FloatElectricalCapacitanceVector
     * @param unit ElectricalCapacitanceUnit; the unit of the new Relative Sparse Mutable Float FloatElectricalCapacitanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalCapacitanceVector(final SortedMap<Integer, Float> values, final ElectricalCapacitanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatElectricalCapacitanceVector(final FloatVectorData data, final ElectricalCapacitanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCapacitanceVector instantiateType(final FloatVectorData dvd, final ElectricalCapacitanceUnit unit)
    {
        return new FloatElectricalCapacitanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalCapacitanceVector instantiateMutableType(final FloatVectorData dvd, final ElectricalCapacitanceUnit unit)
    {
        return new MutableFloatElectricalCapacitanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCapacitance instantiateScalar(final float value, final ElectricalCapacitanceUnit unit)
    {
        return new FloatElectricalCapacitance(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCapacitanceVector toDense()
    {
        return this.data.isDense() ? (FloatElectricalCapacitanceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCapacitanceVector toSparse()
    {
        return this.data.isSparse() ? (FloatElectricalCapacitanceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatElectricalCapacitance Scalars from this vector.
     * @return FloatElectricalCapacitance[]; an array of FloatElectricalCapacitance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalCapacitance[] toArray()
    {
        FloatElectricalCapacitance[] array = new FloatElectricalCapacitance[size()];
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

