package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.FrequencyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatFrequency;

/**
 * Mutable Float FrequencyVector, a vector of values with a FrequencyUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatFrequencyVector
        extends AbstractMutableFloatVectorRel<FrequencyUnit, FloatFrequencyVector, MutableFloatFrequencyVector, FloatFrequency>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FrequencyVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FrequencyVector
     * @param unit FrequencyUnit; the unit of the new Relative Immutable Float FrequencyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatFrequencyVector(final float[] values, final FrequencyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FrequencyVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FrequencyVector
     * @param unit FrequencyUnit; the unit of the new Relative Immutable Float FrequencyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatFrequencyVector(final List<Float> values, final FrequencyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FrequencyVector.
     * @param values FloatFrequency[]; the values of the entries in the new Relative Immutable Float FrequencyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatFrequencyVector(final FloatFrequency[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FrequencyVector.
     * @param values List&lt;FloatFrequency&gt;; the values of the entries in the new Relative Immutable Float FrequencyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatFrequencyVector(final List<FloatFrequency> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FrequencyVector.
     * @param values SortedMap&lt;Integer, FloatFrequency&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float FrequencyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatFrequencyVector(final SortedMap<Integer, FloatFrequency> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FrequencyVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FrequencyVector
     * @param unit FrequencyUnit; the unit of the new Relative Sparse Mutable Float FrequencyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatFrequencyVector(final SortedMap<Integer, Float> values, final FrequencyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit FrequencyUnit; the unit
     */
    MutableFloatFrequencyVector(final FloatVectorData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFrequencyVector instantiateType(final FloatVectorData dvd, final FrequencyUnit unit)
    {
        return new FloatFrequencyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatFrequencyVector instantiateMutableType(final FloatVectorData dvd, final FrequencyUnit unit)
    {
        return new MutableFloatFrequencyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFrequency instantiateScalar(final float value, final FrequencyUnit unit)
    {
        return new FloatFrequency(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFrequencyVector toDense()
    {
        return this.data.isDense() ? (MutableFloatFrequencyVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFrequencyVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatFrequencyVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatFrequency Scalars from this vector.
     * @return FloatFrequency[]; an array of FloatFrequency Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatFrequency[] toArray()
    {
        FloatFrequency[] array = new FloatFrequency[size()];
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
