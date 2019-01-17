package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerVolume;

/**
 * Mutable Float MoneyPerVolumeVector, a vector of values with a MoneyPerVolumeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatMoneyPerVolumeVector extends AbstractMutableFloatVectorRel<MoneyPerVolumeUnit,
        FloatMoneyPerVolumeVector, MutableFloatMoneyPerVolumeVector, FloatMoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float MoneyPerVolumeVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float MoneyPerVolumeVector
     * @param unit MoneyPerVolumeUnit; the unit of the new Relative Immutable Float MoneyPerVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerVolumeVector(final float[] values, final MoneyPerVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerVolumeVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float MoneyPerVolumeVector
     * @param unit MoneyPerVolumeUnit; the unit of the new Relative Immutable Float MoneyPerVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerVolumeVector(final List<Float> values, final MoneyPerVolumeUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerVolumeVector.
     * @param values FloatMoneyPerVolume[]; the values of the entries in the new Relative Immutable Float MoneyPerVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerVolumeVector(final FloatMoneyPerVolume[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerVolumeVector.
     * @param values List&lt;FloatMoneyPerVolume&gt;; the values of the entries in the new Relative Immutable Float
     *            MoneyPerVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerVolumeVector(final List<FloatMoneyPerVolume> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerVolumeVector.
     * @param values SortedMap&lt;Integer, FloatMoneyPerVolume&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float MoneyPerVolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerVolumeVector(final SortedMap<Integer, FloatMoneyPerVolume> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerVolumeVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            MoneyPerVolumeVector
     * @param unit MoneyPerVolumeUnit; the unit of the new Relative Sparse Mutable Float MoneyPerVolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerVolumeVector(final SortedMap<Integer, Float> values, final MoneyPerVolumeUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit MoneyPerVolumeUnit; the unit
     */
    MutableFloatMoneyPerVolumeVector(final FloatVectorData data, final MoneyPerVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerVolumeVector instantiateType(final FloatVectorData dvd, final MoneyPerVolumeUnit unit)
    {
        return new FloatMoneyPerVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerVolumeVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerVolumeUnit unit)
    {
        return new MutableFloatMoneyPerVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerVolume instantiateScalar(final float value, final MoneyPerVolumeUnit unit)
    {
        return new FloatMoneyPerVolume(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerVolumeVector toDense()
    {
        return this.data.isDense() ? (MutableFloatMoneyPerVolumeVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerVolumeVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatMoneyPerVolumeVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatMoneyPerVolume Scalars from this vector.
     * @return FloatMoneyPerVolume[]; an array of FloatMoneyPerVolume Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMoneyPerVolume[] toArray()
    {
        FloatMoneyPerVolume[] array = new FloatMoneyPerVolume[size()];
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
