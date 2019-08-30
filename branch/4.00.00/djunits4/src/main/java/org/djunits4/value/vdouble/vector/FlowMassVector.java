package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.FlowMassUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.FlowMass;

/**
 * Immutable Double FlowMassVector, a vector of values with a FlowMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FlowMassVector extends AbstractDoubleVectorRel<FlowMassUnit, FlowMassVector, MutableFlowMassVector, FlowMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double FlowMassVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double FlowMassVector
     * @param unit FlowMassUnit; the unit of the new Relative Immutable Double FlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FlowMassVector(final double[] values, final FlowMassUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowMassVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double FlowMassVector
     * @param unit FlowMassUnit; the unit of the new Relative Immutable Double FlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FlowMassVector(final List<Double> values, final FlowMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowMassVector.
     * @param values FlowMass[]; the values of the entries in the new Relative Immutable Double FlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FlowMassVector(final FlowMass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowMassVector.
     * @param values List&lt;FlowMass&gt;; the values of the entries in the new Relative Immutable Double FlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FlowMassVector(final List<FlowMass> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowMassVector.
     * @param values SortedMap&lt;Integer, FlowMass&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            FlowMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FlowMassVector(final SortedMap<Integer, FlowMass> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowMassVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            FlowMassVector
     * @param unit FlowMassUnit; the unit of the new Relative Sparse Mutable Double FlowMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FlowMassVector(final SortedMap<Integer, Double> values, final FlowMassUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit FlowMassUnit; the unit
     */
    FlowMassVector(final DoubleVectorData data, final FlowMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FlowMassVector instantiateType(final DoubleVectorData dvd, final FlowMassUnit unit)
    {
        return new FlowMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFlowMassVector instantiateMutableType(final DoubleVectorData dvd, final FlowMassUnit unit)
    {
        return new MutableFlowMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FlowMass instantiateScalar(final double value, final FlowMassUnit unit)
    {
        return new FlowMass(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMassVector toDense()
    {
        return this.data.isDense() ? (FlowMassVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMassVector toSparse()
    {
        return this.data.isSparse() ? (FlowMassVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FlowMass Scalars from this vector.
     * @return FlowMass[]; an array of FlowMass Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FlowMass[] toArray()
    {
        FlowMass[] array = new FlowMass[size()];
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
