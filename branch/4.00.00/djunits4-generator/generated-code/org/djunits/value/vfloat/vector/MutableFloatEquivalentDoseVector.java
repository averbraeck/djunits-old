package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Float EquivalentDoseVector, a vector of values with a EquivalentDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.243Z")
public class MutableFloatEquivalentDoseVector extends
    AbstractMutableFloatVectorRel<EquivalentDoseUnit, FloatEquivalentDoseVector, MutableFloatEquivalentDoseVector, FloatEquivalentDose> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float EquivalentDoseVector
     * @param unit EquivalentDoseUnit; the unit of the new Relative Immutable Float EquivalentDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEquivalentDoseVector(final float[] values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float EquivalentDoseVector
     * @param unit EquivalentDoseUnit; the unit of the new Relative Immutable Float EquivalentDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEquivalentDoseVector(final List<Float> values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values FloatEquivalentDose[]; the values of the entries in the new Relative Immutable Float EquivalentDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEquivalentDoseVector(final FloatEquivalentDose[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values List&lt;FloatEquivalentDose&gt;; the values of the entries in the new Relative Immutable Float EquivalentDoseVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEquivalentDoseVector(final List<FloatEquivalentDose> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values SortedMap&lt;Integer, FloatEquivalentDose&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            EquivalentDoseVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEquivalentDoseVector(final SortedMap<Integer, FloatEquivalentDose> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float EquivalentDoseVector
     * @param unit EquivalentDoseUnit; the unit of the new Relative Sparse Mutable Float EquivalentDoseVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEquivalentDoseVector(final SortedMap<Integer, Float> values, final EquivalentDoseUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatEquivalentDoseVector(final FloatVectorData data, final EquivalentDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEquivalentDoseVector instantiateType(final FloatVectorData dvd, final EquivalentDoseUnit unit)
    {
        return new FloatEquivalentDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatEquivalentDoseVector instantiateMutableType(final FloatVectorData dvd, final EquivalentDoseUnit unit)
    {
        return new MutableFloatEquivalentDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEquivalentDose instantiateScalar(final float value, final EquivalentDoseUnit unit)
    {
        return new FloatEquivalentDose(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableFloatEquivalentDoseVector toDense()
    {
        return this.data.isDense() ? (MutableFloatEquivalentDoseVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatEquivalentDoseVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatEquivalentDoseVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatEquivalentDose Scalars from this vector.
     * @return FloatEquivalentDose[]; an array of FloatEquivalentDose Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatEquivalentDose[] toArray()
    {
        FloatEquivalentDose[] array = new FloatEquivalentDose[size()];
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

