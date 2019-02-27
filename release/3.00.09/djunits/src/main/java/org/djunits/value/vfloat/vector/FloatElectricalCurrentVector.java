package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatElectricalCurrent;

/**
 * Immutable Float FloatElectricalCurrentVector, a vector of values with a ElectricalCurrentUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatElectricalCurrentVector extends AbstractFloatVectorRel<ElectricalCurrentUnit, FloatElectricalCurrentVector,
        MutableFloatElectricalCurrentVector, FloatElectricalCurrent>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatElectricalCurrentVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatElectricalCurrentVector
     * @param unit ElectricalCurrentUnit; the unit of the new Relative Immutable Float FloatElectricalCurrentVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalCurrentVector(final float[] values, final ElectricalCurrentUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCurrentVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalCurrentVector
     * @param unit ElectricalCurrentUnit; the unit of the new Relative Immutable Float FloatElectricalCurrentVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalCurrentVector(final List<Float> values, final ElectricalCurrentUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCurrentVector.
     * @param values FloatElectricalCurrent[]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalCurrentVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalCurrentVector(final FloatElectricalCurrent[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCurrentVector.
     * @param values List&lt;FloatElectricalCurrent&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalCurrentVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalCurrentVector(final List<FloatElectricalCurrent> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCurrentVector.
     * @param values SortedMap&lt;Integer, FloatElectricalCurrent&gt;; the values of the entries in the new Relative Sparse
     *            Mutable Float FloatElectricalCurrentVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalCurrentVector(final SortedMap<Integer, FloatElectricalCurrent> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatElectricalCurrentVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatElectricalCurrentVector
     * @param unit ElectricalCurrentUnit; the unit of the new Relative Sparse Mutable Float FloatElectricalCurrentVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalCurrentVector(final SortedMap<Integer, Float> values, final ElectricalCurrentUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit ElectricalCurrentUnit; the unit
     */
    FloatElectricalCurrentVector(final FloatVectorData data, final ElectricalCurrentUnit unit)
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
    protected final MutableFloatElectricalCurrentVector instantiateMutableType(final FloatVectorData dvd,
            final ElectricalCurrentUnit unit)
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
    public final FloatElectricalCurrentVector toDense()
    {
        return this.data.isDense() ? (FloatElectricalCurrentVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrentVector toSparse()
    {
        return this.data.isSparse() ? (FloatElectricalCurrentVector) this : instantiateType(this.data.toSparse(), getUnit());
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
