package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Float ElectricalInductanceVector, a vector of values with a ElectricalInductanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatElectricalInductanceVector extends
    AbstractMutableFloatVectorRel<ElectricalInductanceUnit, FloatElectricalInductanceVector, MutableFloatElectricalInductanceVector, FloatElectricalInductance> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float ElectricalInductanceVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalInductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalInductanceVector(final float[] values, final ElectricalInductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalInductanceVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalInductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalInductanceVector(final List<Float> values, final ElectricalInductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            ElectricalInductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalInductanceVector(final FloatElectricalInductance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalInductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalInductanceVector(final List<FloatElectricalInductance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            ElectricalInductanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalInductanceVector(final SortedMap<Integer, FloatElectricalInductance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalInductanceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float ElectricalInductanceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float ElectricalInductanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalInductanceVector(final SortedMap<Integer, Float> values, final ElectricalInductanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalInductanceVector(final FloatVectorData data, final ElectricalInductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductanceVector instantiateType(final FloatVectorData dvd, final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalInductanceVector instantiateMutableType(final FloatVectorData dvd, final ElectricalInductanceUnit unit)
    {
        return new MutableFloatElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductance instantiateScalar(final float value, final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductance(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalInductanceVector toDense()
    {
        return this.data.isDense() ? (MutableFloatElectricalInductanceVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalInductanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatElectricalInductanceVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatElectricalInductance Scalars from this vector.
     * @return FloatElectricalInductance[]; an array of FloatElectricalInductance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalInductance[] toArray()
    {
        FloatElectricalInductance[] array = new FloatElectricalInductance[size()];
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

