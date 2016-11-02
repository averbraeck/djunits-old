package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerLength;

/**
 * Immutable Float FloatMoneyPerLengthVector, a vector of values with a MoneyPerLengthUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatMoneyPerLengthVector extends
        AbstractFloatVectorRel<MoneyPerLengthUnit, FloatMoneyPerLengthVector, MutableFloatMoneyPerLengthVector, FloatMoneyPerLength>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMoneyPerLengthVector
     * @param unit U; the unit of the new Relative Immutable Float FloatMoneyPerLengthVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerLengthVector(final float[] values, final MoneyPerLengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatMoneyPerLengthVector
     * @param unit U; the unit of the new Relative Immutable Float FloatMoneyPerLengthVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerLengthVector(final List<Float> values, final MoneyPerLengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerLengthVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerLengthVector(final FloatMoneyPerLength[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatMoneyPerLengthVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerLengthVector(final List<FloatMoneyPerLength> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatMoneyPerLengthVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerLengthVector(final SortedMap<Integer, FloatMoneyPerLength> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMoneyPerLengthVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatMoneyPerLengthVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatMoneyPerLengthVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerLengthVector(final SortedMap<Integer, Float> values, final MoneyPerLengthUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatMoneyPerLengthVector(final FloatVectorData data, final MoneyPerLengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerLengthVector instantiateType(final FloatVectorData dvd, final MoneyPerLengthUnit unit)
    {
        return new FloatMoneyPerLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerLengthVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerLengthUnit unit)
    {
        return new MutableFloatMoneyPerLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerLength instantiateScalar(final float value, final MoneyPerLengthUnit unit)
    {
        return new FloatMoneyPerLength(value, unit);
    }

    /**
     * Create a dense version of this FloatVector.
     * @return the dense version of this FloatVector
     */
    public final FloatMoneyPerLengthVector toDense()
    {
        return this.data.isDense() ? (FloatMoneyPerLengthVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /**
     * Create a sparse version of this FloatVector.
     * @return the sparse version of this FloatVector
     */
    public final FloatMoneyPerLengthVector toSparse()
    {
        return this.data.isSparse() ? (FloatMoneyPerLengthVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

}
