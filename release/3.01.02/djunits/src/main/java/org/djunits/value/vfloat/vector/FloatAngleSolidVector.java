package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngleSolid;

/**
 * Immutable Float FloatAngleSolidVector, a vector of values with a AngleSolidUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatAngleSolidVector
        extends AbstractFloatVectorRel<AngleSolidUnit, FloatAngleSolidVector, MutableFloatAngleSolidVector, FloatAngleSolid>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatAngleSolidVector
     * @param unit AngleSolidUnit; the unit of the new Relative Immutable Float FloatAngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleSolidVector(final float[] values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatAngleSolidVector
     * @param unit AngleSolidUnit; the unit of the new Relative Immutable Float FloatAngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleSolidVector(final List<Float> values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values FloatAngleSolid[]; the values of the entries in the new Relative Immutable Float FloatAngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleSolidVector(final FloatAngleSolid[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values List&lt;FloatAngleSolid&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatAngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleSolidVector(final List<FloatAngleSolid> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values SortedMap&lt;Integer, FloatAngleSolid&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float FloatAngleSolidVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAngleSolidVector(final SortedMap<Integer, FloatAngleSolid> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatAngleSolidVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatAngleSolidVector
     * @param unit AngleSolidUnit; the unit of the new Relative Sparse Mutable Float FloatAngleSolidVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAngleSolidVector(final SortedMap<Integer, Float> values, final AngleSolidUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit AngleSolidUnit; the unit
     */
    FloatAngleSolidVector(final FloatVectorData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolidVector instantiateType(final FloatVectorData dvd, final AngleSolidUnit unit)
    {
        return new FloatAngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAngleSolidVector instantiateMutableType(final FloatVectorData dvd, final AngleSolidUnit unit)
    {
        return new MutableFloatAngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolid instantiateScalar(final float value, final AngleSolidUnit unit)
    {
        return new FloatAngleSolid(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolidVector toDense()
    {
        return this.data.isDense() ? (FloatAngleSolidVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAngleSolidVector toSparse()
    {
        return this.data.isSparse() ? (FloatAngleSolidVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatAngleSolid Scalars from this vector.
     * @return FloatAngleSolid[]; an array of FloatAngleSolid Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatAngleSolid[] toArray()
    {
        FloatAngleSolid[] array = new FloatAngleSolid[size()];
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
