package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.PressureUnit;
import org.djunits.value.DataType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Pressure;

/**
 * Immutable Double PressureVector, a vector of values with a PressureUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class PressureVector extends TypedDoubleVectorRel<PressureUnit, PressureVector, MutablePressureVector, Pressure>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double PressureVector
     * @param unit U; the unit of the new Relative Immutable Double PressureVector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PressureVector(final double[] values, final PressureUnit unit, final DataType dataType)
        throws ValueException
    {
        super(values, unit, dataType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values List; the values of the entries in the new Relative Immutable Double PressureVector
     * @param unit U; the unit of the new Relative Immutable Double PressureVector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PressureVector(final List<Double> values, final PressureUnit unit, final DataType dataType)
        throws ValueException
    {
        super(values, unit, dataType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double PressureVector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PressureVector(final Pressure[] values, final DataType dataType) throws ValueException
    {
        super(values, dataType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values List; the values of the entries in the new Relative Immutable Double PressureVector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PressureVector(final List<Pressure> values, final DataType dataType) throws ValueException
    {
        super(values, dataType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            PressureVector
     * @param length the size of the vector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PressureVector(final SortedMap<Integer, Pressure> values, final int length, final DataType dataType)
        throws ValueException
    {
        super(values, length, dataType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double PressureVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double PressureVector
     * @param length the size of the vector
     * @param dataType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PressureVector(final SortedMap<Integer, Double> values, final PressureUnit unit, final int length,
        final DataType dataType) throws ValueException
    {
        super(values, unit, length, dataType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    PressureVector(final DoubleVectorData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final PressureVector instantiateType(final DoubleVectorData dvd, final PressureUnit unit)
    {
        return new PressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutablePressureVector instantiateMutableType(final DoubleVectorData dvd, final PressureUnit unit)
    {
        return new MutablePressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Pressure get(final int index) throws ValueException
    {
        return new Pressure(getInUnit(index, getUnit()), getUnit());
    }

}
