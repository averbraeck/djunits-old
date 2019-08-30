package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Float RadioActivityVector, a vector of values with a RadioActivityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatRadioActivityVector extends
    AbstractMutableFloatVectorRel<RadioActivityUnit, FloatRadioActivityVector, MutableFloatRadioActivityVector, FloatRadioActivity> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float RadioActivityVector
     * @param unit U; the unit of the new Relative Immutable Float RadioActivityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatRadioActivityVector(final float[] values, final RadioActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values List; the values of the entries in the new Relative Immutable Float RadioActivityVector
     * @param unit U; the unit of the new Relative Immutable Float RadioActivityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatRadioActivityVector(final List<Float> values, final RadioActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            RadioActivityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatRadioActivityVector(final FloatRadioActivity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values List; the values of the entries in the new Relative Immutable Float RadioActivityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatRadioActivityVector(final List<FloatRadioActivity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            RadioActivityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatRadioActivityVector(final SortedMap<Integer, FloatRadioActivity> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float RadioActivityVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float RadioActivityVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float RadioActivityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatRadioActivityVector(final SortedMap<Integer, Float> values, final RadioActivityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatRadioActivityVector(final FloatVectorData data, final RadioActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatRadioActivityVector instantiateType(final FloatVectorData dvd, final RadioActivityUnit unit)
    {
        return new FloatRadioActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatRadioActivityVector instantiateMutableType(final FloatVectorData dvd, final RadioActivityUnit unit)
    {
        return new MutableFloatRadioActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatRadioActivity instantiateScalar(final float value, final RadioActivityUnit unit)
    {
        return new FloatRadioActivity(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableFloatRadioActivityVector toDense()
    {
        return this.data.isDense() ? (MutableFloatRadioActivityVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatRadioActivityVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatRadioActivityVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatRadioActivity Scalars from this vector.
     * @return FloatRadioActivity[]; an array of FloatRadioActivity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatRadioActivity[] toArray()
    {
        FloatRadioActivity[] array = new FloatRadioActivity[size()];
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

