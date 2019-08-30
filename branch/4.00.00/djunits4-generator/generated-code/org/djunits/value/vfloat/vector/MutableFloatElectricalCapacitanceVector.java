package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Float ElectricalCapacitanceVector, a vector of values with a ElectricalCapacitanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatElectricalCapacitanceVector extends
    AbstractMutableFloatVectorRel<ElectricalCapacitanceUnit, FloatElectricalCapacitanceVector, MutableFloatElectricalCapacitanceVector, FloatElectricalCapacitance> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float ElectricalCapacitanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float ElectricalCapacitanceVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalCapacitanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalCapacitanceVector(final float[] values, final ElectricalCapacitanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCapacitanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalCapacitanceVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalCapacitanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalCapacitanceVector(final List<Float> values, final ElectricalCapacitanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCapacitanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            ElectricalCapacitanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalCapacitanceVector(final FloatElectricalCapacitance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCapacitanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalCapacitanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalCapacitanceVector(final List<FloatElectricalCapacitance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCapacitanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            ElectricalCapacitanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalCapacitanceVector(final SortedMap<Integer, FloatElectricalCapacitance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalCapacitanceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float ElectricalCapacitanceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float ElectricalCapacitanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalCapacitanceVector(final SortedMap<Integer, Float> values, final ElectricalCapacitanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalCapacitanceVector(final FloatVectorData data, final ElectricalCapacitanceUnit unit)
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
    public final MutableFloatElectricalCapacitanceVector toDense()
    {
        return this.data.isDense() ? (MutableFloatElectricalCapacitanceVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalCapacitanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatElectricalCapacitanceVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
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

