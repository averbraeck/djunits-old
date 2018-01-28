package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.ElectricalCurrent;

/**
 * Mutable Double ElectricalCurrentVector, a vector of values with a ElectricalCurrentUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableElectricalCurrentVector extends AbstractMutableDoubleVectorRel<ElectricalCurrentUnit,
        ElectricalCurrentVector, MutableElectricalCurrentVector, ElectricalCurrent>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalCurrentVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalCurrentVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalCurrentVector(final double[] values, final ElectricalCurrentUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalCurrentVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalCurrentVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalCurrentVector(final List<Double> values, final ElectricalCurrentUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            ElectricalCurrentVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalCurrentVector(final ElectricalCurrent[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalCurrentVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalCurrentVector(final List<ElectricalCurrent> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            ElectricalCurrentVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalCurrentVector(final SortedMap<Integer, ElectricalCurrent> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double ElectricalCurrentVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double ElectricalCurrentVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalCurrentVector(final SortedMap<Integer, Double> values, final ElectricalCurrentUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableElectricalCurrentVector(final DoubleVectorData data, final ElectricalCurrentUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCurrentVector instantiateType(final DoubleVectorData dvd, final ElectricalCurrentUnit unit)
    {
        return new ElectricalCurrentVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalCurrentVector instantiateMutableType(final DoubleVectorData dvd,
            final ElectricalCurrentUnit unit)
    {
        return new MutableElectricalCurrentVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCurrent instantiateScalar(final double value, final ElectricalCurrentUnit unit)
    {
        return new ElectricalCurrent(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector toDense()
    {
        return this.data.isDense() ? (MutableElectricalCurrentVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector toSparse()
    {
        return this.data.isSparse() ? (MutableElectricalCurrentVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
