package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.PowerUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatPower;

/**
 * Immutable Float FloatPowerVector, a vector of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatPowerVector extends AbstractFloatVectorRel<PowerUnit, FloatPowerVector, MutableFloatPowerVector, FloatPower>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatPowerVector
     * @param unit PowerUnit; the unit of the new Relative Immutable Float FloatPowerVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPowerVector(final float[] values, final PowerUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatPowerVector
     * @param unit PowerUnit; the unit of the new Relative Immutable Float FloatPowerVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPowerVector(final List<Float> values, final PowerUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values FloatPower[]; the values of the entries in the new Relative Immutable Float FloatPowerVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPowerVector(final FloatPower[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values List&lt;FloatPower&gt;; the values of the entries in the new Relative Immutable Float FloatPowerVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPowerVector(final List<FloatPower> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values SortedMap&lt;Integer, FloatPower&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatPowerVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPowerVector(final SortedMap<Integer, FloatPower> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatPowerVector
     * @param unit PowerUnit; the unit of the new Relative Sparse Mutable Float FloatPowerVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPowerVector(final SortedMap<Integer, Float> values, final PowerUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit PowerUnit; the unit
     */
    FloatPowerVector(final FloatVectorData data, final PowerUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPowerVector instantiateType(final FloatVectorData dvd, final PowerUnit unit)
    {
        return new FloatPowerVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPowerVector instantiateMutableType(final FloatVectorData dvd, final PowerUnit unit)
    {
        return new MutableFloatPowerVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPower instantiateScalar(final float value, final PowerUnit unit)
    {
        return new FloatPower(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPowerVector toDense()
    {
        return this.data.isDense() ? (FloatPowerVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPowerVector toSparse()
    {
        return this.data.isSparse() ? (FloatPowerVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatPower Scalars from this vector.
     * @return FloatPower[]; an array of FloatPower Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatPower[] toArray()
    {
        FloatPower[] array = new FloatPower[size()];
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
