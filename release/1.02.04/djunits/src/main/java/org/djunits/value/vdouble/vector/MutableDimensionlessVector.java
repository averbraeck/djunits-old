package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Dimensionless;

/**
 * Mutable Double DimensionlessVector, a vector of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableDimensionlessVector
    extends
    MutableTypedDoubleVectorDimensionless<DimensionlessUnit, DimensionlessVector, MutableDimensionlessVector, Dimensionless>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double DimensionlessVector
     * @param unit U; the unit of the new Relative Immutable Double DimensionlessVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDimensionlessVector(final double[] values, final DimensionlessUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values List; the values of the entries in the new Relative Immutable Double DimensionlessVector
     * @param unit U; the unit of the new Relative Immutable Double DimensionlessVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDimensionlessVector(final List<Double> values, final DimensionlessUnit unit,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            DimensionlessVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDimensionlessVector(final Dimensionless[] values, final StorageType storageType)
        throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values List; the values of the entries in the new Relative Immutable Double DimensionlessVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDimensionlessVector(final List<Dimensionless> values, final StorageType storageType)
        throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            DimensionlessVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDimensionlessVector(final SortedMap<Integer, Dimensionless> values, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double DimensionlessVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double DimensionlessVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDimensionlessVector(final SortedMap<Integer, Double> values, final DimensionlessUnit unit,
        final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableDimensionlessVector(final DoubleVectorData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DimensionlessVector instantiateType(final DoubleVectorData dvd, final DimensionlessUnit unit)
    {
        return new DimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDimensionlessVector instantiateMutableType(final DoubleVectorData dvd,
        final DimensionlessUnit unit)
    {
        return new MutableDimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Dimensionless get(final int index) throws ValueException
    {
        return new Dimensionless(getInUnit(index, getUnit()), getUnit());
    }

}
