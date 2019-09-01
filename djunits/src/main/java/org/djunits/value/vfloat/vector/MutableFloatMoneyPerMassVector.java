package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerMass;

/**
 * Mutable Float MoneyPerMassVector, a vector of values with a MoneyPerMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatMoneyPerMassVector extends AbstractMutableFloatVectorRel<MoneyPerMassUnit, FloatMoneyPerMassVector,
        MutableFloatMoneyPerMassVector, FloatMoneyPerMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float MoneyPerMassVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float MoneyPerMassVector
     * @param unit MoneyPerMassUnit; the unit of the new Relative Immutable Float MoneyPerMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerMassVector(final float[] values, final MoneyPerMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerMassVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float MoneyPerMassVector
     * @param unit MoneyPerMassUnit; the unit of the new Relative Immutable Float MoneyPerMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerMassVector(final List<Float> values, final MoneyPerMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerMassVector.
     * @param values FloatMoneyPerMass[]; the values of the entries in the new Relative Immutable Float MoneyPerMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerMassVector(final FloatMoneyPerMass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerMassVector.
     * @param values List&lt;FloatMoneyPerMass&gt;; the values of the entries in the new Relative Immutable Float
     *            MoneyPerMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerMassVector(final List<FloatMoneyPerMass> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerMassVector.
     * @param values SortedMap&lt;Integer, FloatMoneyPerMass&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float MoneyPerMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerMassVector(final SortedMap<Integer, FloatMoneyPerMass> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MoneyPerMassVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            MoneyPerMassVector
     * @param unit MoneyPerMassUnit; the unit of the new Relative Sparse Mutable Float MoneyPerMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerMassVector(final SortedMap<Integer, Float> values, final MoneyPerMassUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit MoneyPerMassUnit; the unit
     */
    MutableFloatMoneyPerMassVector(final FloatVectorData data, final MoneyPerMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerMassVector instantiateType(final FloatVectorData dvd, final MoneyPerMassUnit unit)
    {
        return new FloatMoneyPerMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerMassVector instantiateMutableType(final FloatVectorData dvd,
            final MoneyPerMassUnit unit)
    {
        return new MutableFloatMoneyPerMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerMass instantiateScalar(final float value, final MoneyPerMassUnit unit)
    {
        return new FloatMoneyPerMass(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerMassVector toDense()
    {
        return this.data.isDense() ? (MutableFloatMoneyPerMassVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerMassVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatMoneyPerMassVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatMoneyPerMass Scalars from this vector.
     * @return FloatMoneyPerMass[]; an array of FloatMoneyPerMass Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMoneyPerMass[] toArray()
    {
        FloatMoneyPerMass[] array = new FloatMoneyPerMass[size()];
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
