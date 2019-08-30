package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatElectricalPotentialVector, a vector of values with a ElectricalPotentialUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatElectricalPotentialVector extends
    AbstractFloatVectorRel<ElectricalPotentialUnit, FloatElectricalPotentialVector, MutableFloatElectricalPotentialVector, FloatElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatElectricalPotentialVector
     * @param unit U; the unit of the new Relative Immutable Float FloatElectricalPotentialVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalPotentialVector(final float[] values, final ElectricalPotentialUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatElectricalPotentialVector
     * @param unit U; the unit of the new Relative Immutable Float FloatElectricalPotentialVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalPotentialVector(final List<Float> values, final ElectricalPotentialUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalPotentialVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalPotentialVector(final FloatElectricalPotential[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatElectricalPotentialVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalPotentialVector(final List<FloatElectricalPotential> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatElectricalPotentialVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalPotentialVector(final SortedMap<Integer, FloatElectricalPotential> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalPotentialVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatElectricalPotentialVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatElectricalPotentialVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalPotentialVector(final SortedMap<Integer, Float> values, final ElectricalPotentialUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatElectricalPotentialVector(final FloatVectorData data, final ElectricalPotentialUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotentialVector instantiateType(final FloatVectorData dvd, final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotentialVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalPotentialVector instantiateMutableType(final FloatVectorData dvd, final ElectricalPotentialUnit unit)
    {
        return new MutableFloatElectricalPotentialVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotential instantiateScalar(final float value, final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotential(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotentialVector toDense()
    {
        return this.data.isDense() ? (FloatElectricalPotentialVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotentialVector toSparse()
    {
        return this.data.isSparse() ? (FloatElectricalPotentialVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatElectricalPotential Scalars from this vector.
     * @return FloatElectricalPotential[]; an array of FloatElectricalPotential Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalPotential[] toArray()
    {
        FloatElectricalPotential[] array = new FloatElectricalPotential[size()];
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

