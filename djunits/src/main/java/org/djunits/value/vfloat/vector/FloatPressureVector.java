package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.PressureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatPressure;

/**
 * Immutable Float FloatPressureVector, a vector of values with a PressureUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatPressureVector
        extends AbstractFloatVectorRel<PressureUnit, FloatPressureVector, MutableFloatPressureVector, FloatPressure>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatPressureVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatPressureVector
     * @param unit PressureUnit; the unit of the new Relative Immutable Float FloatPressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPressureVector(final float[] values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPressureVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatPressureVector
     * @param unit PressureUnit; the unit of the new Relative Immutable Float FloatPressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPressureVector(final List<Float> values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPressureVector.
     * @param values FloatPressure[]; the values of the entries in the new Relative Immutable Float FloatPressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPressureVector(final FloatPressure[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPressureVector.
     * @param values List&lt;FloatPressure&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatPressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPressureVector(final List<FloatPressure> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPressureVector.
     * @param values SortedMap&lt;Integer, FloatPressure&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatPressureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPressureVector(final SortedMap<Integer, FloatPressure> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPressureVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatPressureVector
     * @param unit PressureUnit; the unit of the new Relative Sparse Mutable Float FloatPressureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPressureVector(final SortedMap<Integer, Float> values, final PressureUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit PressureUnit; the unit
     */
    FloatPressureVector(final FloatVectorData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPressureVector instantiateType(final FloatVectorData dvd, final PressureUnit unit)
    {
        return new FloatPressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPressureVector instantiateMutableType(final FloatVectorData dvd, final PressureUnit unit)
    {
        return new MutableFloatPressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPressure instantiateScalar(final float value, final PressureUnit unit)
    {
        return new FloatPressure(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressureVector toDense()
    {
        return this.data.isDense() ? (FloatPressureVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressureVector toSparse()
    {
        return this.data.isSparse() ? (FloatPressureVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatPressure Scalars from this vector.
     * @return FloatPressure[]; an array of FloatPressure Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatPressure[] toArray()
    {
        FloatPressure[] array = new FloatPressure[size()];
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
