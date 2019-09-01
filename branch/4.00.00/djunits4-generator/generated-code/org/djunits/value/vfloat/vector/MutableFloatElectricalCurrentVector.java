package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Float ElectricalCurrentVector, a vector of values with a ElectricalCurrentUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatElectricalCurrentVector extends
    AbstractMutableFloatVectorRel<ElectricalCurrentUnit, FloatElectricalCurrentVector, MutableFloatElectricalCurrentVector, FloatElectricalCurrent> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float ElectricalCurrentVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float ElectricalCurrentVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalCurrentVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalCurrentVector(final float[] values, final ElectricalCurrentUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCurrentVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalCurrentVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalCurrentVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalCurrentVector(final List<Float> values, final ElectricalCurrentUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCurrentVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            ElectricalCurrentVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalCurrentVector(final FloatElectricalCurrent[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCurrentVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalCurrentVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalCurrentVector(final List<FloatElectricalCurrent> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCurrentVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            ElectricalCurrentVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalCurrentVector(final SortedMap<Integer, FloatElectricalCurrent> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCurrentVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float ElectricalCurrentVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float ElectricalCurrentVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalCurrentVector(final SortedMap<Integer, Float> values, final ElectricalCurrentUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalCurrentVector(final FloatVectorData data, final ElectricalCurrentUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCurrentVector instantiateType(final FloatVectorData dvd, final ElectricalCurrentUnit unit)
    {
        return new FloatElectricalCurrentVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalCurrentVector instantiateMutableType(final FloatVectorData dvd, final ElectricalCurrentUnit unit)
    {
        return new MutableFloatElectricalCurrentVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCurrent instantiateScalar(final float value, final ElectricalCurrentUnit unit)
    {
        return new FloatElectricalCurrent(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalCurrentVector toDense()
    {
        return this.data.isDense() ? (MutableFloatElectricalCurrentVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalCurrentVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatElectricalCurrentVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatElectricalCurrent Scalars from this vector.
     * @return FloatElectricalCurrent[]; an array of FloatElectricalCurrent Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalCurrent[] toArray()
    {
        FloatElectricalCurrent[] array = new FloatElectricalCurrent[size()];
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

