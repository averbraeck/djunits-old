package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.EnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatEnergy;

/**
 * Mutable Float EnergyVector, a vector of values with a EnergyUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatEnergyVector
        extends AbstractMutableFloatVectorRel<EnergyUnit, FloatEnergyVector, MutableFloatEnergyVector, FloatEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float EnergyVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float EnergyVector
     * @param unit U; the unit of the new Relative Immutable Float EnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEnergyVector(final float[] values, final EnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EnergyVector.
     * @param values List; the values of the entries in the new Relative Immutable Float EnergyVector
     * @param unit U; the unit of the new Relative Immutable Float EnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEnergyVector(final List<Float> values, final EnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EnergyVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float EnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEnergyVector(final FloatEnergy[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EnergyVector.
     * @param values List; the values of the entries in the new Relative Immutable Float EnergyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEnergyVector(final List<FloatEnergy> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EnergyVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float EnergyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEnergyVector(final SortedMap<Integer, FloatEnergy> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float EnergyVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float EnergyVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float EnergyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEnergyVector(final SortedMap<Integer, Float> values, final EnergyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatEnergyVector(final FloatVectorData data, final EnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEnergyVector instantiateType(final FloatVectorData dvd, final EnergyUnit unit)
    {
        return new FloatEnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatEnergyVector instantiateMutableType(final FloatVectorData dvd, final EnergyUnit unit)
    {
        return new MutableFloatEnergyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEnergy instantiateScalar(final float value, final EnergyUnit unit)
    {
        return new FloatEnergy(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatEnergyVector toDense()
    {
        return this.data.isDense() ? (MutableFloatEnergyVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatEnergyVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatEnergyVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
