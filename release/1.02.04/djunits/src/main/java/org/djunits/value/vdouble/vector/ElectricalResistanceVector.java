package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.ElectricalResistance;

/**
 * Immutable Double ElectricalResistanceVector, a vector of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ElectricalResistanceVector
    extends
    TypedDoubleVectorRel<ElectricalResistanceUnit, ElectricalResistanceVector, MutableElectricalResistanceVector, ElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalResistanceVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalResistanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalResistanceVector(final double[] values, final ElectricalResistanceUnit unit,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalResistanceVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalResistanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalResistanceVector(final List<Double> values, final ElectricalResistanceUnit unit,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            ElectricalResistanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalResistanceVector(final ElectricalResistance[] values, final StorageType storageType)
        throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalResistanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalResistanceVector(final List<ElectricalResistance> values, final StorageType storageType)
        throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            ElectricalResistanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalResistanceVector(final SortedMap<Integer, ElectricalResistance> values, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double ElectricalResistanceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double ElectricalResistanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalResistanceVector(final SortedMap<Integer, Double> values, final ElectricalResistanceUnit unit,
        final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    ElectricalResistanceVector(final DoubleVectorData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalResistanceVector instantiateType(final DoubleVectorData dvd,
        final ElectricalResistanceUnit unit)
    {
        return new ElectricalResistanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalResistanceVector instantiateMutableType(final DoubleVectorData dvd,
        final ElectricalResistanceUnit unit)
    {
        return new MutableElectricalResistanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance get(final int index) throws ValueException
    {
        return new ElectricalResistance(getInUnit(index, getUnit()), getUnit());
    }

}
