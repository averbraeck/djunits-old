package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Position;

/**
 * Mutable Absolute Position Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutablePositionVector extends
        AbstractMutableDoubleVectorAbs<PositionUnit, LengthUnit, PositionVector, LengthVector, MutablePositionVector, Position>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double PositionVector.
     * @param values double[]; the values of the entries in the new Absolute Mutable Double PositionVector
     * @param unit PositionUnit; the unit of the new Absolute Mutable Double PositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutablePositionVector(final double[] values, final PositionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double PositionVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Absolute Mutable Double PositionVector
     * @param unit PositionUnit; the unit of the new Absolute Mutable Double PositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutablePositionVector(final List<Double> values, final PositionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double PositionVector.
     * @param values Position[]; the values of the entries in the new Absolute Mutable Double PositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutablePositionVector(final Position[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double PositionVector.
     * @param values List&lt;Position&gt;; the values of the entries in the new Absolute Mutable Double PositionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutablePositionVector(final List<Position> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double PositionVector.
     * @param values SortedMap&lt;Integer, Position&gt;; the values of the entries in the new Absolute Sparse Mutable Double
     *            PositionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutablePositionVector(final SortedMap<Integer, Position> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double PositionVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Absolute Sparse Mutable Double
     *            PositionVector
     * @param unit PositionUnit; the unit of the new Absolute Sparse Mutable Double PositionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutablePositionVector(final SortedMap<Integer, Double> values, final PositionUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double PositionVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit PositionUnit; the unit
     */
    MutablePositionVector(final DoubleVectorData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final PositionVector instantiateTypeAbs(final DoubleVectorData dvd, final PositionUnit unit)
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
    protected final MutablePositionVector instantiateMutableType(final DoubleVectorData dvd, final PositionUnit unit)
    {
        return new MutablePositionVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Position instantiateScalar(final double value, final PositionUnit unit)
    {
        return new Position(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePositionVector toDense()
    {
        return this.data.isDense() ? (MutablePositionVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePositionVector toSparse()
    {
        return this.data.isSparse() ? (MutablePositionVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Position Scalars from this vector.
     * @return Position[]; an array of Position Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Position[] toArray()
    {
        Position[] array = new Position[size()];
        for (int i = 0; i < size(); i++)
        {
            try
            {
                array[i] = get(i);
            }
            catch (ValueException exception)
            {
                throw new RuntimeException(exception);
            }
        }
        return array;
    }

}
