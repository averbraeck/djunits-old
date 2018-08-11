package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.FlowVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.FlowVolume;

/**
 * Immutable Double FlowVolumeVector, a vector of values with a FlowVolumeUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FlowVolumeVector
        extends AbstractDoubleVectorRel<FlowVolumeUnit, FlowVolumeVector, MutableFlowVolumeVector, FlowVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double FlowVolumeVector
     * @param unit U; the unit of the new Relative Immutable Double FlowVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FlowVolumeVector(final double[] values, final FlowVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double FlowVolumeVector
     * @param unit U; the unit of the new Relative Immutable Double FlowVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FlowVolumeVector(final List<Double> values, final FlowVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            FlowVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FlowVolumeVector(final FlowVolume[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double FlowVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FlowVolumeVector(final List<FlowVolume> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            FlowVolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FlowVolumeVector(final SortedMap<Integer, FlowVolume> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double FlowVolumeVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double FlowVolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FlowVolumeVector(final SortedMap<Integer, Double> values, final FlowVolumeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FlowVolumeVector(final DoubleVectorData data, final FlowVolumeUnit unit)
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
    public final FlowVolumeVector toDense()
    {
        return this.data.isDense() ? (FlowVolumeVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolumeVector toSparse()
    {
        return this.data.isSparse() ? (FlowVolumeVector) this : instantiateType(this.data.toSparse(), getUnit());
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
