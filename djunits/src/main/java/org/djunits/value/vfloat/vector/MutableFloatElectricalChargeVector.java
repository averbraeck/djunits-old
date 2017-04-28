package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatElectricalCharge;

/**
 * Mutable Float ElectricalChargeVector, a vector of values with a ElectricalChargeUnit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatElectricalChargeVector extends AbstractMutableFloatVectorRel<ElectricalChargeUnit,
        FloatElectricalChargeVector, MutableFloatElectricalChargeVector, FloatElectricalCharge>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float ElectricalChargeVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float ElectricalChargeVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalChargeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalChargeVector(final float[] values, final ElectricalChargeUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalChargeVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalChargeVector
     * @param unit U; the unit of the new Relative Immutable Float ElectricalChargeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalChargeVector(final List<Float> values, final ElectricalChargeUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalChargeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            ElectricalChargeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalChargeVector(final FloatElectricalCharge[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalChargeVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ElectricalChargeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalChargeVector(final List<FloatElectricalCharge> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalChargeVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            ElectricalChargeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalChargeVector(final SortedMap<Integer, FloatElectricalCharge> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalChargeVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float ElectricalChargeVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float ElectricalChargeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalChargeVector(final SortedMap<Integer, Float> values, final ElectricalChargeUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalChargeVector(final FloatVectorData data, final ElectricalChargeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalChargeVector instantiateType(final FloatVectorData dvd, final ElectricalChargeUnit unit)
    {
        return new FloatElectricalChargeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalChargeVector instantiateMutableType(final FloatVectorData dvd,
            final ElectricalChargeUnit unit)
    {
        return new MutableFloatElectricalChargeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCharge instantiateScalar(final float value, final ElectricalChargeUnit unit)
    {
        return new FloatElectricalCharge(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalChargeVector toDense()
    {
        return this.data.isDense() ? (MutableFloatElectricalChargeVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalChargeVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatElectricalChargeVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
