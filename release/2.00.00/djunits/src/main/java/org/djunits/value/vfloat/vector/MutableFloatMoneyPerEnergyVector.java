package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerEnergy;

/**
 * Mutable Float MoneyPerEnergyVector, a vector of values with a MoneyPerEnergyUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatMoneyPerEnergyVector extends
        AbstractMutableFloatVectorRel<MoneyPerEnergyUnit, FloatMoneyPerEnergyVector, MutableFloatMoneyPerEnergyVector, FloatMoneyPerEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float MoneyPerEnergyVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float MoneyPerEnergyVector
     * @param unit U; the unit of the new Relative Immutable Float MoneyPerEnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerEnergyVector(final float[] values, final MoneyPerEnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerEnergyVector.
     * @param values List; the values of the entries in the new Relative Immutable Float MoneyPerEnergyVector
     * @param unit U; the unit of the new Relative Immutable Float MoneyPerEnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerEnergyVector(final List<Float> values, final MoneyPerEnergyUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerEnergyVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            MoneyPerEnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerEnergyVector(final FloatMoneyPerEnergy[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerEnergyVector.
     * @param values List; the values of the entries in the new Relative Immutable Float MoneyPerEnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerEnergyVector(final List<FloatMoneyPerEnergy> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerEnergyVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            MoneyPerEnergyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerEnergyVector(final SortedMap<Integer, FloatMoneyPerEnergy> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerEnergyVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float MoneyPerEnergyVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float MoneyPerEnergyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerEnergyVector(final SortedMap<Integer, Float> values, final MoneyPerEnergyUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatMoneyPerEnergyVector(final FloatVectorData data, final MoneyPerEnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerEnergyVector instantiateType(final FloatVectorData dvd, final MoneyPerEnergyUnit unit)
    {
        return new FloatMoneyPerEnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerEnergyVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerEnergyUnit unit)
    {
        return new MutableFloatMoneyPerEnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerEnergy instantiateScalar(final float value, final MoneyPerEnergyUnit unit)
    {
        return new FloatMoneyPerEnergy(value, unit);
    }

    /**
     * Create a dense version of this FloatVector.
     * @return the dense version of this FloatVector
     */
    public final MutableFloatMoneyPerEnergyVector toDense()
    {
        return this.data.isDense() ? (MutableFloatMoneyPerEnergyVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /**
     * Create a sparse version of this FloatVector.
     * @return the sparse version of this FloatVector
     */
    public final MutableFloatMoneyPerEnergyVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatMoneyPerEnergyVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
