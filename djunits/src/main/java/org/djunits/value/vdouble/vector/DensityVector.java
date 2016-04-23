package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DensityUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Density;

/**
 * Immutable Double DensityVector, a vector of values with a DensityUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DensityVector extends TypedDoubleVectorRel<DensityUnit, DensityVector, MutableDensityVector, Density>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double DensityVector
     * @param unit U; the unit of the new Relative Immutable Double DensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DensityVector(final double[] values, final DensityUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double DensityVector
     * @param unit U; the unit of the new Relative Immutable Double DensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DensityVector(final List<Double> values, final DensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double DensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DensityVector(final Density[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double DensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DensityVector(final List<Density> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            DensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DensityVector(final SortedMap<Integer, Density> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double DensityVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double DensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DensityVector(final SortedMap<Integer, Double> values, final DensityUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    DensityVector(final DoubleVectorData data, final DensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DensityVector instantiateType(final DoubleVectorData dvd, final DensityUnit unit)
    {
        return new DensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDensityVector instantiateMutableType(final DoubleVectorData dvd, final DensityUnit unit)
    {
        return new MutableDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Density get(final int index) throws ValueException
    {
        return new Density(getInUnit(index, getUnit()), getUnit());
    }

}
