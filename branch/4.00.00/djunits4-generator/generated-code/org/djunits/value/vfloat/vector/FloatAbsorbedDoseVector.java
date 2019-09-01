package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatAbsorbedDoseVector, a vector of values with a AbsorbedDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatAbsorbedDoseVector extends
    AbstractFloatVectorRel<AbsorbedDoseUnit, FloatAbsorbedDoseVector, MutableFloatAbsorbedDoseVector, FloatAbsorbedDose>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param unit U; the unit of the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAbsorbedDoseVector(final float[] values, final AbsorbedDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param unit U; the unit of the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAbsorbedDoseVector(final List<Float> values, final AbsorbedDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatAbsorbedDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAbsorbedDoseVector(final FloatAbsorbedDose[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatAbsorbedDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAbsorbedDoseVector(final List<FloatAbsorbedDose> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatAbsorbedDoseVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAbsorbedDoseVector(final SortedMap<Integer, FloatAbsorbedDose> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAbsorbedDoseVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatAbsorbedDoseVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatAbsorbedDoseVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAbsorbedDoseVector(final SortedMap<Integer, Float> values, final AbsorbedDoseUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatAbsorbedDoseVector(final FloatVectorData data, final AbsorbedDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsorbedDoseVector instantiateType(final FloatVectorData dvd, final AbsorbedDoseUnit unit)
    {
        return new FloatAbsorbedDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAbsorbedDoseVector instantiateMutableType(final FloatVectorData dvd, final AbsorbedDoseUnit unit)
    {
        return new MutableFloatAbsorbedDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsorbedDose instantiateScalar(final float value, final AbsorbedDoseUnit unit)
    {
        return new FloatAbsorbedDose(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatAbsorbedDoseVector toDense()
    {
        return this.data.isDense() ? (FloatAbsorbedDoseVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAbsorbedDoseVector toSparse()
    {
        return this.data.isSparse() ? (FloatAbsorbedDoseVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatAbsorbedDose Scalars from this vector.
     * @return FloatAbsorbedDose[]; an array of FloatAbsorbedDose Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAbsorbedDose[] toArray()
    {
        FloatAbsorbedDose[] array = new FloatAbsorbedDose[size()];
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

