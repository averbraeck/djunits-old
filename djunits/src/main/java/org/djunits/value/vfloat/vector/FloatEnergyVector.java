package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.EnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatEnergy;

/**
 * Immutable Float FloatEnergyVector, a vector of values with a EnergyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatEnergyVector
        extends AbstractFloatVectorRel<EnergyUnit, FloatEnergyVector, MutableFloatEnergyVector, FloatEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatEnergyVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatEnergyVector
     * @param unit EnergyUnit; the unit of the new Relative Immutable Float FloatEnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatEnergyVector(final float[] values, final EnergyUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEnergyVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatEnergyVector
     * @param unit EnergyUnit; the unit of the new Relative Immutable Float FloatEnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatEnergyVector(final List<Float> values, final EnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEnergyVector.
     * @param values FloatEnergy[]; the values of the entries in the new Relative Immutable Float FloatEnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatEnergyVector(final FloatEnergy[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEnergyVector.
     * @param values List&lt;FloatEnergy&gt;; the values of the entries in the new Relative Immutable Float FloatEnergyVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatEnergyVector(final List<FloatEnergy> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEnergyVector.
     * @param values SortedMap&lt;Integer, FloatEnergy&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatEnergyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatEnergyVector(final SortedMap<Integer, FloatEnergy> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatEnergyVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatEnergyVector
     * @param unit EnergyUnit; the unit of the new Relative Sparse Mutable Float FloatEnergyVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatEnergyVector(final SortedMap<Integer, Float> values, final EnergyUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit EnergyUnit; the unit
     */
    FloatEnergyVector(final FloatVectorData data, final EnergyUnit unit)
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
    public final FloatEnergyVector toDense()
    {
        return this.data.isDense() ? (FloatEnergyVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatEnergyVector toSparse()
    {
        return this.data.isSparse() ? (FloatEnergyVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatEnergy Scalars from this vector.
     * @return FloatEnergy[]; an array of FloatEnergy Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatEnergy[] toArray()
    {
        FloatEnergy[] array = new FloatEnergy[size()];
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
