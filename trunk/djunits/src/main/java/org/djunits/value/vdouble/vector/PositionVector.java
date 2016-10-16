package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Position;

/**
 * Immutable Absolute Position Vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class PositionVector
        extends AbstractDoubleVectorAbs<LengthUnit, PositionVector, LengthVector, MutablePositionVector, Position>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double PositionVector.
     * @param values double[]; the values of the entries in the new Absolute Immutable Double PositionVector
     * @param unit U; the unit of the new Absolute Immutable Double PositionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PositionVector(final double[] values, final LengthUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double PositionVector.
     * @param values List; the values of the entries in the new Absolute Immutable Double PositionVector
     * @param unit U; the unit of the new Absolute Immutable Double PositionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PositionVector(final List<Double> values, final LengthUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double PositionVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable Double PositionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PositionVector(final Position[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double PositionVector.
     * @param values List; the values of the entries in the new Absolute Immutable Double PositionVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PositionVector(final List<Position> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double PositionVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double
     *            PositionVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PositionVector(final SortedMap<Integer, Position> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double PositionVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double PositionVector
     * @param unit U; the unit of the new Absolute Sparse Mutable Double PositionVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PositionVector(final SortedMap<Integer, Double> values, final LengthUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double PositionVector.
     * @param data an internal data object
     * @param unit the unit
     */
    PositionVector(final DoubleVectorData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final PositionVector instantiateTypeAbs(final DoubleVectorData dvd, final LengthUnit unit)
    {
        return new PositionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LengthVector instantiateTypeRel(final DoubleVectorData dvd, final LengthUnit unit)
    {
        return new LengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutablePositionVector instantiateMutableType(final DoubleVectorData dvd, final LengthUnit unit)
    {
        return new MutablePositionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Position instantiateScalar(final double value, final LengthUnit unit)
    {
        return new Position(value, unit);
    }

    /**
     * Create a dense version of this DoubleVector.
     * @return the dense version of this DoubleVector
     */
    public final PositionVector toDense()
    {
        return this.data.isDense() ? (PositionVector) this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /**
     * Create a sparse version of this DoubleVector.
     * @return the sparse version of this DoubleVector
     */
    public final PositionVector toSparse()
    {
        return this.data.isSparse() ? (PositionVector) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /**
     * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute Position vector.
     */
    public final LengthVector toRel()
    {
        return new LengthVector(getData(), getUnit());
    }

}
