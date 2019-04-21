package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.FlowVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.FlowVolume;

/**
 * Mutable Double FlowVolumeVector, a vector of values with a FlowVolumeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFlowVolumeVector
        extends AbstractMutableDoubleVectorRel<FlowVolumeUnit, FlowVolumeVector, MutableFlowVolumeVector, FlowVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double FlowVolumeVector
     * @param unit FlowVolumeUnit; the unit of the new Relative Immutable Double FlowVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFlowVolumeVector(final double[] values, final FlowVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double FlowVolumeVector
     * @param unit FlowVolumeUnit; the unit of the new Relative Immutable Double FlowVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFlowVolumeVector(final List<Double> values, final FlowVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values FlowVolume[]; the values of the entries in the new Relative Immutable Double FlowVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFlowVolumeVector(final FlowVolume[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values List&lt;FlowVolume&gt;; the values of the entries in the new Relative Immutable Double FlowVolumeVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFlowVolumeVector(final List<FlowVolume> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values SortedMap&lt;Integer, FlowVolume&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            FlowVolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFlowVolumeVector(final SortedMap<Integer, FlowVolume> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            FlowVolumeVector
     * @param unit FlowVolumeUnit; the unit of the new Relative Sparse Mutable Double FlowVolumeVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFlowVolumeVector(final SortedMap<Integer, Double> values, final FlowVolumeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit FlowVolumeUnit; the unit
     */
    MutableFlowVolumeVector(final DoubleVectorData data, final FlowVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FlowVolumeVector instantiateType(final DoubleVectorData dvd, final FlowVolumeUnit unit)
    {
        return new FlowVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFlowVolumeVector instantiateMutableType(final DoubleVectorData dvd, final FlowVolumeUnit unit)
    {
        return new MutableFlowVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FlowVolume instantiateScalar(final double value, final FlowVolumeUnit unit)
    {
        return new FlowVolume(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowVolumeVector toDense()
    {
        return this.data.isDense() ? (MutableFlowVolumeVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowVolumeVector toSparse()
    {
        return this.data.isSparse() ? (MutableFlowVolumeVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FlowVolume Scalars from this vector.
     * @return FlowVolume[]; an array of FlowVolume Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FlowVolume[] toArray()
    {
        FlowVolume[] array = new FlowVolume[size()];
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
