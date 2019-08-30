package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.TorqueUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Torque;

/**
 * Mutable Double TorqueVector, a vector of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableTorqueVector extends AbstractMutableDoubleVectorRel<TorqueUnit, TorqueVector, MutableTorqueVector, Torque>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Immutable Double TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableTorqueVector(final double[] values, final TorqueUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Immutable Double TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableTorqueVector(final List<Double> values, final TorqueUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values Torque[]; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableTorqueVector(final Torque[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values List&lt;Torque&gt;; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableTorqueVector(final List<Torque> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values SortedMap&lt;Integer, Torque&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            TorqueVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableTorqueVector(final SortedMap<Integer, Torque> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            TorqueVector
     * @param unit TorqueUnit; the unit of the new Relative Sparse Mutable Double TorqueVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableTorqueVector(final SortedMap<Integer, Double> values, final TorqueUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit TorqueUnit; the unit
     */
    MutableTorqueVector(final DoubleVectorData data, final TorqueUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final TorqueVector instantiateType(final DoubleVectorData dvd, final TorqueUnit unit)
    {
        return new TorqueVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableTorqueVector instantiateMutableType(final DoubleVectorData dvd, final TorqueUnit unit)
    {
        return new MutableTorqueVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Torque instantiateScalar(final double value, final TorqueUnit unit)
    {
        return new Torque(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector toDense()
    {
        return this.data.isDense() ? (MutableTorqueVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTorqueVector toSparse()
    {
        return this.data.isSparse() ? (MutableTorqueVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Torque Scalars from this vector.
     * @return Torque[]; an array of Torque Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Torque[] toArray()
    {
        Torque[] array = new Torque[size()];
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
