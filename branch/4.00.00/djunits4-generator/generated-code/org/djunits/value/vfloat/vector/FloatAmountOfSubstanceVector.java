package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatAmountOfSubstanceVector, a vector of values with a AmountOfSubstanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatAmountOfSubstanceVector extends
    AbstractFloatVectorRel<AmountOfSubstanceUnit, FloatAmountOfSubstanceVector, MutableFloatAmountOfSubstanceVector, FloatAmountOfSubstance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatAmountOfSubstanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatAmountOfSubstanceVector
     * @param unit U; the unit of the new Relative Immutable Float FloatAmountOfSubstanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAmountOfSubstanceVector(final float[] values, final AmountOfSubstanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAmountOfSubstanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatAmountOfSubstanceVector
     * @param unit U; the unit of the new Relative Immutable Float FloatAmountOfSubstanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAmountOfSubstanceVector(final List<Float> values, final AmountOfSubstanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAmountOfSubstanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatAmountOfSubstanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAmountOfSubstanceVector(final FloatAmountOfSubstance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAmountOfSubstanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatAmountOfSubstanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAmountOfSubstanceVector(final List<FloatAmountOfSubstance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAmountOfSubstanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatAmountOfSubstanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAmountOfSubstanceVector(final SortedMap<Integer, FloatAmountOfSubstance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAmountOfSubstanceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatAmountOfSubstanceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatAmountOfSubstanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAmountOfSubstanceVector(final SortedMap<Integer, Float> values, final AmountOfSubstanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatAmountOfSubstanceVector(final FloatVectorData data, final AmountOfSubstanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAmountOfSubstanceVector instantiateType(final FloatVectorData dvd, final AmountOfSubstanceUnit unit)
    {
        return new FloatAmountOfSubstanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAmountOfSubstanceVector instantiateMutableType(final FloatVectorData dvd, final AmountOfSubstanceUnit unit)
    {
        return new MutableFloatAmountOfSubstanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAmountOfSubstance instantiateScalar(final float value, final AmountOfSubstanceUnit unit)
    {
        return new FloatAmountOfSubstance(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatAmountOfSubstanceVector toDense()
    {
        return this.data.isDense() ? (FloatAmountOfSubstanceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAmountOfSubstanceVector toSparse()
    {
        return this.data.isSparse() ? (FloatAmountOfSubstanceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatAmountOfSubstance Scalars from this vector.
     * @return FloatAmountOfSubstance[]; an array of FloatAmountOfSubstance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAmountOfSubstance[] toArray()
    {
        FloatAmountOfSubstance[] array = new FloatAmountOfSubstance[size()];
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

