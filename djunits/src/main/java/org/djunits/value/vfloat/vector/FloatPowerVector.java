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
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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
     * @param unit U; the unit of the new Relative Immutable Float FloatPowerVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPowerVector(final float[] values, final PowerUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatPowerVector
     * @param unit U; the unit of the new Relative Immutable Float FloatPowerVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPowerVector(final List<Float> values, final PowerUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float FloatPowerVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPowerVector(final FloatPower[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatPowerVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPowerVector(final List<FloatPower> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatPowerVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPowerVector(final SortedMap<Integer, FloatPower> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatPowerVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatPowerVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatPowerVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPowerVector(final SortedMap<Integer, Float> values, final PowerUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
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

}
