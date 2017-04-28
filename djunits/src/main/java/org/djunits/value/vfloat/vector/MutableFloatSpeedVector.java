package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.SpeedUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatSpeed;

/**
 * Mutable Float SpeedVector, a vector of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatSpeedVector
        extends AbstractMutableFloatVectorRel<SpeedUnit, FloatSpeedVector, MutableFloatSpeedVector, FloatSpeed>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float SpeedVector
     * @param unit U; the unit of the new Relative Immutable Float SpeedVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatSpeedVector(final float[] values, final SpeedUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values List; the values of the entries in the new Relative Immutable Float SpeedVector
     * @param unit U; the unit of the new Relative Immutable Float SpeedVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatSpeedVector(final List<Float> values, final SpeedUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float SpeedVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatSpeedVector(final FloatSpeed[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values List; the values of the entries in the new Relative Immutable Float SpeedVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatSpeedVector(final List<FloatSpeed> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float SpeedVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatSpeedVector(final SortedMap<Integer, FloatSpeed> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float SpeedVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float SpeedVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float SpeedVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatSpeedVector(final SortedMap<Integer, Float> values, final SpeedUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatSpeedVector(final FloatVectorData data, final SpeedUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatSpeedVector instantiateType(final FloatVectorData dvd, final SpeedUnit unit)
    {
        return new FloatSpeedVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatSpeedVector instantiateMutableType(final FloatVectorData dvd, final SpeedUnit unit)
    {
        return new MutableFloatSpeedVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatSpeed instantiateScalar(final float value, final SpeedUnit unit)
    {
        return new FloatSpeed(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatSpeedVector toDense()
    {
        return this.data.isDense() ? (MutableFloatSpeedVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatSpeedVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatSpeedVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
