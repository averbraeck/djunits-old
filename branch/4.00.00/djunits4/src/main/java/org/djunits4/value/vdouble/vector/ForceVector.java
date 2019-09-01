package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.ForceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Force;

/**
 * Immutable Double ForceVector, a vector of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class ForceVector extends AbstractDoubleVectorRel<ForceUnit, ForceVector, MutableForceVector, Force>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ForceVector
     * @param unit ForceUnit; the unit of the new Relative Immutable Double ForceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ForceVector(final double[] values, final ForceUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double ForceVector
     * @param unit ForceUnit; the unit of the new Relative Immutable Double ForceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ForceVector(final List<Double> values, final ForceUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values Force[]; the values of the entries in the new Relative Immutable Double ForceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ForceVector(final Force[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values List&lt;Force&gt;; the values of the entries in the new Relative Immutable Double ForceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ForceVector(final List<Force> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values SortedMap&lt;Integer, Force&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            ForceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ForceVector(final SortedMap<Integer, Force> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            ForceVector
     * @param unit ForceUnit; the unit of the new Relative Sparse Mutable Double ForceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ForceVector(final SortedMap<Integer, Double> values, final ForceUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit ForceUnit; the unit
     */
    ForceVector(final DoubleVectorData data, final ForceUnit unit)
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
    public final ForceVector toDense()
    {
        return this.data.isDense() ? (ForceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ForceVector toSparse()
    {
        return this.data.isSparse() ? (ForceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Force Scalars from this vector.
     * @return Force[]; an array of Force Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Force[] toArray()
    {
        Force[] array = new Force[size()];
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
