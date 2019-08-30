package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Float ElectricalConductanceVector, a vector of values with a ElectricalConductanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatElectricalConductanceVector extends
    AbstractMutableFloatVectorRel<ElectricalConductanceUnit, FloatElectricalConductanceVector, MutableFloatElectricalConductanceVector, FloatElectricalConductance> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float ElectricalConductanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float ElectricalConductanceVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalConductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalConductanceVector(final float[] values, final ElectricalConductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalConductanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalConductanceVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalConductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalConductanceVector(final List<Float> values, final ElectricalConductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalConductanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            ElectricalConductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalConductanceVector(final FloatElectricalConductance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalConductanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalConductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalConductanceVector(final List<FloatElectricalConductance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalConductanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            ElectricalConductanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalConductanceVector(final SortedMap<Integer, FloatElectricalConductance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalConductanceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float ElectricalConductanceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float ElectricalConductanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalConductanceVector(final SortedMap<Integer, Float> values, final ElectricalConductanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalConductanceVector(final FloatVectorData data, final ElectricalConductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalConductanceVector instantiateType(final FloatVectorData dvd, final ElectricalConductanceUnit unit)
    {
        return new FloatElectricalConductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalConductanceVector instantiateMutableType(final FloatVectorData dvd, final ElectricalConductanceUnit unit)
    {
        return new MutableFloatElectricalConductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalConductance instantiateScalar(final float value, final ElectricalConductanceUnit unit)
    {
        return new FloatElectricalConductance(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalConductanceVector toDense()
    {
        return this.data.isDense() ? (MutableFloatElectricalConductanceVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalConductanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatElectricalConductanceVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatElectricalConductance Scalars from this vector.
     * @return FloatElectricalConductance[]; an array of FloatElectricalConductance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalConductance[] toArray()
    {
        FloatElectricalConductance[] array = new FloatElectricalConductance[size()];
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

