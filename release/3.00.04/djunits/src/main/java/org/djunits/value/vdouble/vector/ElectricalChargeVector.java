package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.ElectricalCharge;

/**
 * Immutable Double ElectricalChargeVector, a vector of values with a ElectricalChargeUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ElectricalChargeVector extends
        AbstractDoubleVectorRel<ElectricalChargeUnit, ElectricalChargeVector, MutableElectricalChargeVector, ElectricalCharge>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalChargeVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalChargeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalChargeVector(final double[] values, final ElectricalChargeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalChargeVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalChargeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalChargeVector(final List<Double> values, final ElectricalChargeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            ElectricalChargeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalChargeVector(final ElectricalCharge[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalChargeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalChargeVector(final List<ElectricalCharge> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            ElectricalChargeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalChargeVector(final SortedMap<Integer, ElectricalCharge> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalChargeVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double ElectricalChargeVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double ElectricalChargeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalChargeVector(final SortedMap<Integer, Double> values, final ElectricalChargeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    ElectricalChargeVector(final DoubleVectorData data, final ElectricalChargeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalChargeVector instantiateType(final DoubleVectorData dvd, final ElectricalChargeUnit unit)
    {
        return new ElectricalChargeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalChargeVector instantiateMutableType(final DoubleVectorData dvd,
            final ElectricalChargeUnit unit)
    {
        return new MutableElectricalChargeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCharge instantiateScalar(final double value, final ElectricalChargeUnit unit)
    {
        return new ElectricalCharge(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalChargeVector toDense()
    {
        return this.data.isDense() ? (ElectricalChargeVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalChargeVector toSparse()
    {
        return this.data.isSparse() ? (ElectricalChargeVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of ElectricalCharge Scalars from this vector.
     * @return ElectricalCharge[]; an array of ElectricalCharge Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public ElectricalCharge[] toArray()
    {
        ElectricalCharge[] array = new ElectricalCharge[size()];
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