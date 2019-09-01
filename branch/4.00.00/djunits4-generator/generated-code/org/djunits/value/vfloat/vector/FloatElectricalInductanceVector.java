package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatElectricalInductanceVector, a vector of values with a ElectricalInductanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatElectricalInductanceVector extends
    AbstractFloatVectorRel<ElectricalInductanceUnit, FloatElectricalInductanceVector, MutableFloatElectricalInductanceVector, FloatElectricalInductance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatElectricalInductanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatElectricalInductanceVector
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Immutable Float FloatElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalInductanceVector(final float[] values, final ElectricalInductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalInductanceVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatElectricalInductanceVector
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Immutable Float FloatElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalInductanceVector(final List<Float> values, final ElectricalInductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalInductanceVector.
     * @param values FloatElectricalInductance[]; the values of the entries in the new Relative Immutable Float FloatElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalInductanceVector(final FloatElectricalInductance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalInductanceVector.
     * @param values List&lt;FloatElectricalInductance&gt;; the values of the entries in the new Relative Immutable Float FloatElectricalInductanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalInductanceVector(final List<FloatElectricalInductance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalInductanceVector.
     * @param values SortedMap&lt;Integer, FloatElectricalInductance&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatElectricalInductanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalInductanceVector(final SortedMap<Integer, FloatElectricalInductance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalInductanceVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float FloatElectricalInductanceVector
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Sparse Mutable Float FloatElectricalInductanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalInductanceVector(final SortedMap<Integer, Float> values, final ElectricalInductanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatElectricalInductanceVector(final FloatVectorData data, final ElectricalInductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductanceVector instantiateType(final FloatVectorData dvd, final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalInductanceVector instantiateMutableType(final FloatVectorData dvd, final ElectricalInductanceUnit unit)
    {
        return new MutableFloatElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductance instantiateScalar(final float value, final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductance(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatElectricalInductanceVector toDense()
    {
        return this.data.isDense() ? (FloatElectricalInductanceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalInductanceVector toSparse()
    {
        return this.data.isSparse() ? (FloatElectricalInductanceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatElectricalInductance Scalars from this vector.
     * @return FloatElectricalInductance[]; an array of FloatElectricalInductance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalInductance[] toArray()
    {
        FloatElectricalInductance[] array = new FloatElectricalInductance[size()];
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

