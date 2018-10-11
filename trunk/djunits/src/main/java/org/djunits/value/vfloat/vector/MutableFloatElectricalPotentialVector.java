package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatElectricalPotential;

/**
 * Mutable Float ElectricalPotentialVector, a vector of values with a ElectricalPotentialUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatElectricalPotentialVector extends AbstractMutableFloatVectorRel<ElectricalPotentialUnit,
        FloatElectricalPotentialVector, MutableFloatElectricalPotentialVector, FloatElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float ElectricalPotentialVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float ElectricalPotentialVector
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Immutable Float ElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalPotentialVector(final float[] values, final ElectricalPotentialUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalPotentialVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float ElectricalPotentialVector
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Immutable Float ElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalPotentialVector(final List<Float> values, final ElectricalPotentialUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalPotentialVector.
     * @param values FloatElectricalPotential[]; the values of the entries in the new Relative Immutable Float
     *            ElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalPotentialVector(final FloatElectricalPotential[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalPotentialVector.
     * @param values List&lt;FloatElectricalPotential&gt;; the values of the entries in the new Relative Immutable Float
     *            ElectricalPotentialVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalPotentialVector(final List<FloatElectricalPotential> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalPotentialVector.
     * @param values SortedMap&lt;Integer, FloatElectricalPotential&gt;; the values of the entries in the new Relative Sparse
     *            Mutable Float ElectricalPotentialVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalPotentialVector(final SortedMap<Integer, FloatElectricalPotential> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ElectricalPotentialVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            ElectricalPotentialVector
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Sparse Mutable Float ElectricalPotentialVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalPotentialVector(final SortedMap<Integer, Float> values, final ElectricalPotentialUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit ElectricalPotentialUnit; the unit
     */
    MutableFloatElectricalPotentialVector(final FloatVectorData data, final ElectricalPotentialUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotentialVector instantiateType(final FloatVectorData dvd,
            final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotentialVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalPotentialVector instantiateMutableType(final FloatVectorData dvd,
            final ElectricalPotentialUnit unit)
    {
        return new MutableFloatElectricalPotentialVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotential instantiateScalar(final float value, final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotential(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalPotentialVector toDense()
    {
        return this.data.isDense() ? (MutableFloatElectricalPotentialVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalPotentialVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatElectricalPotentialVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatElectricalPotential Scalars from this vector.
     * @return FloatElectricalPotential[]; an array of FloatElectricalPotential Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatElectricalPotential[] toArray()
    {
        FloatElectricalPotential[] array = new FloatElectricalPotential[size()];
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
