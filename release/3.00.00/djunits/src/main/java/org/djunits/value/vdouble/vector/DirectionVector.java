package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DirectionUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Direction;

/**
 * Immutable Absolute Direction Vector.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DirectionVector extends
        AbstractDoubleVectorAbs<DirectionUnit, AngleUnit, DirectionVector, AngleVector, MutableDirectionVector, Direction>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double DirectionVector.
     * @param values double[]; the values of the entries in the new Absolute Immutable Double DirectionVector
     * @param unit U; the unit of the new Absolute Immutable Double DirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DirectionVector(final double[] values, final DirectionUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double DirectionVector.
     * @param values List; the values of the entries in the new Absolute Immutable Double DirectionVector
     * @param unit U; the unit of the new Absolute Immutable Double DirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DirectionVector(final List<Double> values, final DirectionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double DirectionVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable Double DirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DirectionVector(final Direction[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double DirectionVector.
     * @param values List; the values of the entries in the new Absolute Immutable Double DirectionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DirectionVector(final List<Direction> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double DirectionVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
     *            DirectionVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DirectionVector(final SortedMap<Integer, Direction> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double DirectionVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double DirectionVector
     * @param unit U; the unit of the new Absolute Sparse Mutable Double DirectionVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DirectionVector(final SortedMap<Integer, Double> values, final DirectionUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double DirectionVector.
     * @param data an internal data object
     * @param unit the unit
     */
    DirectionVector(final DoubleVectorData data, final DirectionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DirectionVector instantiateTypeAbs(final DoubleVectorData dvd, final DirectionUnit unit)
    {
        return new DirectionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleVector instantiateTypeRel(final DoubleVectorData dvd, final AngleUnit unit)
    {
        return new AngleVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDirectionVector instantiateMutableType(final DoubleVectorData dvd, final DirectionUnit unit)
    {
        return new MutableDirectionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Direction instantiateScalar(final double value, final DirectionUnit unit)
    {
        return new Direction(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final DirectionVector toDense()
    {
        return this.data.isDense() ? (DirectionVector) this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final DirectionVector toSparse()
    {
        return this.data.isSparse() ? (DirectionVector) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

}
