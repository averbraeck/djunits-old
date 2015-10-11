package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.SpeedUnit;
import org.djunits.value.DataType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Speed;

/**
 * Immutable Double SpeedVector, a vector of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class SpeedVector extends TypedDoubleVectorRel<SpeedUnit, SpeedVector, MutableSpeedVector, Speed>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param unit U; the unit of the new Relative Immutable Double SpeedVector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public SpeedVector(final double[] values, final SpeedUnit unit, final DataType dataType) throws ValueException
    {
        super(values, unit, dataType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values List; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param unit U; the unit of the new Relative Immutable Double SpeedVector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public SpeedVector(final List<Double> values, final SpeedUnit unit, final DataType dataType) throws ValueException
    {
        super(values, unit, dataType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public SpeedVector(final Speed[] values, final DataType dataType) throws ValueException
    {
        super(values, dataType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values List; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public SpeedVector(final List<Speed> values, final DataType dataType) throws ValueException
    {
        super(values, dataType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            SpeedVector
     * @param length the size of the vector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public SpeedVector(final SortedMap<Integer, Speed> values, final int length, final DataType dataType)
        throws ValueException
    {
        super(values, length, dataType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double SpeedVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double SpeedVector
     * @param length the size of the vector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public SpeedVector(final SortedMap<Integer, Double> values, final SpeedUnit unit, final int length,
        final DataType dataType) throws ValueException
    {
        super(values, unit, length, dataType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    SpeedVector(final DoubleVectorData data, final SpeedUnit unit)
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
