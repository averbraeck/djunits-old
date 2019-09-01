package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatEquivalentDoseVector, a vector of values with a EquivalentDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatEquivalentDoseVector extends
    AbstractFloatVectorRel<EquivalentDoseUnit, FloatEquivalentDoseVector, MutableFloatEquivalentDoseVector, FloatEquivalentDose>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatEquivalentDoseVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatEquivalentDoseVector
     * @param unit U; the unit of the new Relative Immutable Float FloatEquivalentDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatEquivalentDoseVector(final float[] values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEquivalentDoseVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatEquivalentDoseVector
     * @param unit U; the unit of the new Relative Immutable Float FloatEquivalentDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatEquivalentDoseVector(final List<Float> values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEquivalentDoseVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatEquivalentDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatEquivalentDoseVector(final FloatEquivalentDose[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEquivalentDoseVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatEquivalentDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatEquivalentDoseVector(final List<FloatEquivalentDose> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEquivalentDoseVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatEquivalentDoseVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatEquivalentDoseVector(final SortedMap<Integer, FloatEquivalentDose> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEquivalentDoseVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatEquivalentDoseVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatEquivalentDoseVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatEquivalentDoseVector(final SortedMap<Integer, Float> values, final EquivalentDoseUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatEquivalentDoseVector(final FloatVectorData data, final EquivalentDoseUnit unit)
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
    public final FloatEquivalentDoseVector toDense()
    {
        return this.data.isDense() ? (FloatEquivalentDoseVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEquivalentDoseVector toSparse()
    {
        return this.data.isSparse() ? (FloatEquivalentDoseVector) this : instantiateType(this.data.toSparse(), getUnit());
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

