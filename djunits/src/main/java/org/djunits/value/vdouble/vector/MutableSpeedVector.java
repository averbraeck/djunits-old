package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.SpeedUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Speed;

/**
 * Mutable Double SpeedVector, a vector of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableSpeedVector extends MutableTypedDoubleVectorRel<SpeedUnit, SpeedVector, MutableSpeedVector, Speed>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param unit U; the unit of the new Relative Immutable Double SpeedVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableSpeedVector(final double[] values, final SpeedUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values List; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param unit U; the unit of the new Relative Immutable Double SpeedVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableSpeedVector(final List<Double> values, final SpeedUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableSpeedVector(final Speed[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values List; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableSpeedVector(final List<Speed> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            SpeedVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableSpeedVector(final SortedMap<Integer, Speed> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double SpeedVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double SpeedVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableSpeedVector(final SortedMap<Integer, Double> values, final SpeedUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableSpeedVector(final DoubleVectorData data, final SpeedUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final SpeedVector instantiateType(final DoubleVectorData dvd, final SpeedUnit unit)
    {
        return new SpeedVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableSpeedVector instantiateMutableType(final DoubleVectorData dvd, final SpeedUnit unit)
    {
        return new MutableSpeedVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Speed get(final int index) throws ValueException
    {
        return new Speed(getInUnit(index, getUnit()), getUnit());
    }

}
