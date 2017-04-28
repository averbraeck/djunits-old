package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TorqueUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatTorque;

/**
 * Immutable Float FloatTorqueVector, a vector of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatTorqueVector
        extends AbstractFloatVectorRel<TorqueUnit, FloatTorqueVector, MutableFloatTorqueVector, FloatTorque>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatTorqueVector
     * @param unit U; the unit of the new Relative Immutable Float FloatTorqueVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTorqueVector(final float[] values, final TorqueUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatTorqueVector
     * @param unit U; the unit of the new Relative Immutable Float FloatTorqueVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTorqueVector(final List<Float> values, final TorqueUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float FloatTorqueVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTorqueVector(final FloatTorque[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatTorqueVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTorqueVector(final List<FloatTorque> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatTorqueVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatTorqueVector(final SortedMap<Integer, FloatTorque> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatTorqueVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatTorqueVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatTorqueVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatTorqueVector(final SortedMap<Integer, Float> values, final TorqueUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatTorqueVector(final FloatVectorData data, final TorqueUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTorqueVector instantiateType(final FloatVectorData dvd, final TorqueUnit unit)
    {
        return new FloatTorqueVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatTorqueVector instantiateMutableType(final FloatVectorData dvd, final TorqueUnit unit)
    {
        return new MutableFloatTorqueVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatTorque instantiateScalar(final float value, final TorqueUnit unit)
    {
        return new FloatTorque(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorqueVector toDense()
    {
        return this.data.isDense() ? (FloatTorqueVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatTorqueVector toSparse()
    {
        return this.data.isSparse() ? (FloatTorqueVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

}
