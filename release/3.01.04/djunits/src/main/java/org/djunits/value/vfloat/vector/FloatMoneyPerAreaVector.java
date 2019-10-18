package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerArea;

/**
 * Immutable Float FloatMoneyPerAreaVector, a vector of values with a MoneyPerAreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatMoneyPerAreaVector extends
        AbstractFloatVectorRel<MoneyPerAreaUnit, FloatMoneyPerAreaVector, MutableFloatMoneyPerAreaVector, FloatMoneyPerArea>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerAreaVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMoneyPerAreaVector
     * @param unit MoneyPerAreaUnit; the unit of the new Relative Immutable Float FloatMoneyPerAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerAreaVector(final float[] values, final MoneyPerAreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerAreaVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatMoneyPerAreaVector
     * @param unit MoneyPerAreaUnit; the unit of the new Relative Immutable Float FloatMoneyPerAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerAreaVector(final List<Float> values, final MoneyPerAreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerAreaVector.
     * @param values FloatMoneyPerArea[]; the values of the entries in the new Relative Immutable Float FloatMoneyPerAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerAreaVector(final FloatMoneyPerArea[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerAreaVector.
     * @param values List&lt;FloatMoneyPerArea&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerAreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerAreaVector(final List<FloatMoneyPerArea> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerAreaVector.
     * @param values SortedMap&lt;Integer, FloatMoneyPerArea&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float FloatMoneyPerAreaVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerAreaVector(final SortedMap<Integer, FloatMoneyPerArea> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerAreaVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatMoneyPerAreaVector
     * @param unit MoneyPerAreaUnit; the unit of the new Relative Sparse Mutable Float FloatMoneyPerAreaVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerAreaVector(final SortedMap<Integer, Float> values, final MoneyPerAreaUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit MoneyPerAreaUnit; the unit
     */
    FloatMoneyPerAreaVector(final FloatVectorData data, final MoneyPerAreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerAreaVector instantiateType(final FloatVectorData dvd, final MoneyPerAreaUnit unit)
    {
        return new FloatMoneyPerAreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerAreaVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerAreaUnit unit)
    {
        return new MutableFloatMoneyPerAreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerArea instantiateScalar(final float value, final MoneyPerAreaUnit unit)
    {
        return new FloatMoneyPerArea(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerAreaVector toDense()
    {
        return this.data.isDense() ? (FloatMoneyPerAreaVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerAreaVector toSparse()
    {
        return this.data.isSparse() ? (FloatMoneyPerAreaVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatMoneyPerArea Scalars from this vector.
     * @return FloatMoneyPerArea[]; an array of FloatMoneyPerArea Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMoneyPerArea[] toArray()
    {
        FloatMoneyPerArea[] array = new FloatMoneyPerArea[size()];
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