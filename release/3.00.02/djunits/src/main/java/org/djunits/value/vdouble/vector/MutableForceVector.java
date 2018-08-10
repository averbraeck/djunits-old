package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ForceUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Force;

/**
 * Mutable Double ForceVector, a vector of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableForceVector extends AbstractMutableDoubleVectorRel<ForceUnit, ForceVector, MutableForceVector, Force>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ForceVector
     * @param unit U; the unit of the new Relative Immutable Double ForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableForceVector(final double[] values, final ForceUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ForceVector
     * @param unit U; the unit of the new Relative Immutable Double ForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableForceVector(final List<Double> values, final ForceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double ForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableForceVector(final Force[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableForceVector(final List<Force> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            ForceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableForceVector(final SortedMap<Integer, Force> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double ForceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double ForceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableForceVector(final SortedMap<Integer, Double> values, final ForceUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableForceVector(final DoubleVectorData data, final ForceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ForceVector instantiateType(final DoubleVectorData dvd, final ForceUnit unit)
    {
        return new ForceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableForceVector instantiateMutableType(final DoubleVectorData dvd, final ForceUnit unit)
    {
        return new MutableForceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Force instantiateScalar(final double value, final ForceUnit unit)
    {
        return new Force(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector toDense()
    {
        return this.data.isDense() ? (MutableForceVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector toSparse()
    {
        return this.data.isSparse() ? (MutableForceVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}