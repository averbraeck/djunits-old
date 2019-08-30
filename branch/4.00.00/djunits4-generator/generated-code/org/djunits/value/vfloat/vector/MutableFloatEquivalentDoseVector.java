package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Float EquivalentDoseVector, a vector of values with a EquivalentDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatEquivalentDoseVector extends
    AbstractMutableFloatVectorRel<EquivalentDoseUnit, FloatEquivalentDoseVector, MutableFloatEquivalentDoseVector, FloatEquivalentDose> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float EquivalentDoseVector
     * @param unit U; the unit of the new Relative Immutable Float EquivalentDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEquivalentDoseVector(final float[] values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values List; the values of the entries in the new Relative Immutable Float EquivalentDoseVector
     * @param unit U; the unit of the new Relative Immutable Float EquivalentDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEquivalentDoseVector(final List<Float> values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            EquivalentDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEquivalentDoseVector(final FloatEquivalentDose[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values List; the values of the entries in the new Relative Immutable Float EquivalentDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEquivalentDoseVector(final List<FloatEquivalentDose> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            EquivalentDoseVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEquivalentDoseVector(final SortedMap<Integer, FloatEquivalentDose> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EquivalentDoseVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float EquivalentDoseVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float EquivalentDoseVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEquivalentDoseVector(final SortedMap<Integer, Float> values, final EquivalentDoseUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
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

