package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TorqueUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Torque;

/**
 * Immutable Double TorqueVector, a vector of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class TorqueVector extends TypedDoubleVectorRel<TorqueUnit, TorqueVector, MutableTorqueVector, Torque>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param unit U; the unit of the new Relative Immutable Double TorqueVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TorqueVector(final double[] values, final TorqueUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values List; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param unit U; the unit of the new Relative Immutable Double TorqueVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TorqueVector(final List<Double> values, final TorqueUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TorqueVector(final Torque[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values List; the values of the entries in the new Relative Immutable Double TorqueVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TorqueVector(final List<Torque> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            TorqueVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TorqueVector(final SortedMap<Integer, Torque> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TorqueVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double TorqueVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double TorqueVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TorqueVector(final SortedMap<Integer, Double> values, final TorqueUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    TorqueVector(final DoubleVectorData data, final TorqueUnit unit)
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
    public final Torque get(final int index) throws ValueException
    {
        return new Torque(getInUnit(index, getUnit()), getUnit());
    }

}
