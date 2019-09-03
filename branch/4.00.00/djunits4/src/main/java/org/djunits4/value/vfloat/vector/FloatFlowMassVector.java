package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.FlowMassUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatFlowMass;

/**
 * Immutable Float FloatFlowMassVector, a vector of values with a FlowMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.228Z")
public class FloatFlowMassVector
        extends AbstractFloatVectorRel<FlowMassUnit, FloatFlowMassVector, MutableFloatFlowMassVector, FloatFlowMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatFlowMassVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatFlowMassVector
     * @param unit FlowMassUnit; the unit of the new Relative Immutable Float FloatFlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatFlowMassVector(final float[] values, final FlowMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowMassVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FloatFlowMassVector
     * @param unit FlowMassUnit; the unit of the new Relative Immutable Float FloatFlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatFlowMassVector(final List<Float> values, final FlowMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowMassVector.
     * @param values FloatFlowMass[]; the values of the entries in the new Relative Immutable Float FloatFlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatFlowMassVector(final FloatFlowMass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowMassVector.
     * @param values List&lt;FloatFlowMass&gt;; the values of the entries in the new Relative Immutable Float
     *            FloatFlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatFlowMassVector(final List<FloatFlowMass> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowMassVector.
     * @param values SortedMap&lt;Integer, FloatFlowMass&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatFlowMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatFlowMassVector(final SortedMap<Integer, FloatFlowMass> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatFlowMassVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FloatFlowMassVector
     * @param unit FlowMassUnit; the unit of the new Relative Sparse Mutable Float FloatFlowMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatFlowMassVector(final SortedMap<Integer, Float> values, final FlowMassUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    FloatFlowMassVector(final FloatVectorData data, final FlowMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowMassVector instantiateType(final FloatVectorData dvd, final FlowMassUnit unit)
    {
        return new FloatFlowMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatFlowMassVector instantiateMutableType(final FloatVectorData dvd, final FlowMassUnit unit)
    {
        return new MutableFloatFlowMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowMass instantiateScalar(final float value, final FlowMassUnit unit)
    {
        return new FloatFlowMass(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMassVector toDense()
    {
        return this.data.isDense() ? (FloatFlowMassVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMassVector toSparse()
    {
        return this.data.isSparse() ? (FloatFlowMassVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatFlowMass Scalars from this vector.
     * @return FloatFlowMass[]; an array of FloatFlowMass Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatFlowMass[] toArray()
    {
        FloatFlowMass[] array = new FloatFlowMass[size()];
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
