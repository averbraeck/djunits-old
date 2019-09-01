package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatMassVector, a vector of values with a MassUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatMassVector extends
    AbstractFloatVectorRel<MassUnit, FloatMassVector, MutableFloatMassVector, FloatMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMassVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMassVector
     * @param unit MassUnit; the unit of the new Relative Immutable Float FloatMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMassVector(final float[] values, final MassUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMassVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatMassVector
     * @param unit MassUnit; the unit of the new Relative Immutable Float FloatMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMassVector(final List<Float> values, final MassUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMassVector.
     * @param values FloatMass[]; the values of the entries in the new Relative Immutable Float FloatMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMassVector(final FloatMass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMassVector.
     * @param values List&lt;FloatMass&gt;; the values of the entries in the new Relative Immutable Float FloatMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMassVector(final List<FloatMass> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMassVector.
     * @param values SortedMap&lt;Integer, FloatMass&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMassVector(final SortedMap<Integer, FloatMass> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMassVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float FloatMassVector
     * @param unit MassUnit; the unit of the new Relative Sparse Mutable Float FloatMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMassVector(final SortedMap<Integer, Float> values, final MassUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatMassVector(final FloatVectorData data, final MassUnit unit)
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
    public final FloatMassVector toDense()
    {
        return this.data.isDense() ? (FloatMassVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMassVector toSparse()
    {
        return this.data.isSparse() ? (FloatMassVector) this : instantiateType(this.data.toSparse(), getUnit());
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
            catch (ValueException exception)
            {
                throw new RuntimeException(exception);
            }
        }
        return array;
    }

}

