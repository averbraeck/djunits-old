package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AreaUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Area;

/**
 * Mutable Double AreaVector, a vector of values with a AreaUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableAreaVector extends MutableTypedDoubleVectorRel<AreaUnit, AreaVector, MutableAreaVector, Area>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double AreaVector
     * @param unit U; the unit of the new Relative Immutable Double AreaVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAreaVector(final double[] values, final AreaUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AreaVector
     * @param unit U; the unit of the new Relative Immutable Double AreaVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAreaVector(final List<Double> values, final AreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double AreaVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAreaVector(final Area[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AreaVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAreaVector(final List<Area> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double AreaVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAreaVector(final SortedMap<Integer, Area> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double AreaVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double AreaVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAreaVector(final SortedMap<Integer, Double> values, final AreaUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableAreaVector(final DoubleVectorData data, final AreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AreaVector instantiateType(final DoubleVectorData dvd, final AreaUnit unit)
    {
        return new AreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAreaVector instantiateMutableType(final DoubleVectorData dvd, final AreaUnit unit)
    {
        return new MutableAreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Area get(final int index) throws ValueException
    {
        return new Area(getInUnit(index, getUnit()), getUnit());
    }

}
