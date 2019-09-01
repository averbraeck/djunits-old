package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Absolute Direction Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableDirectionVector
        extends
        AbstractMutableDoubleVectorAbs<DirectionUnit, AngleUnit, DirectionVector, AngleVector, MutableDirectionVector, Direction>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double DirectionVector.
     * @param values double[]; the values of the entries in the new Absolute Mutable Double DirectionVector
     * @param unit DirectionUnit; the unit of the new Absolute Mutable Double DirectionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDirectionVector(final double[] values, final DirectionUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Absolute Mutable Double DirectionVector
     * @param unit DirectionUnit; the unit of the new Absolute Mutable Double DirectionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDirectionVector(final List<Double> values, final DirectionUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionVector.
     * @param values Direction[]; the values of the entries in the new Absolute Mutable Double DirectionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDirectionVector(final Direction[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionVector.
     * @param values List&lt;Direction&gt;; the values of the entries in the new Absolute Mutable Double DirectionVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDirectionVector(final List<Direction> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionVector.
     * @param values SortedMap&lt;Integer, Direction&gt;; the values of the entries in the new Absolute Sparse Mutable Double DirectionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDirectionVector(final SortedMap<Integer, Direction> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Absolute Sparse Mutable Double DirectionVector
     * @param unit DirectionUnit; the unit of the new Absolute Sparse Mutable Double DirectionVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDirectionVector(final SortedMap<Integer, Double> values, final DirectionUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit DirectionUnit; the unit
     */
    MutableDirectionVector(final DoubleVectorData data, final DirectionUnit unit)
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
    public final MutableDirectionVector toDense()
    {
        return this.data.isDense() ? (MutableDirectionVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDirectionVector toSparse()
    {
        return this.data.isSparse() ? (MutableDirectionVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }
    
    
    /**
     * Return an array of Direction Scalars from this vector.
     * @return Direction[]; an array of Direction Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Direction[] toArray()
    {
        Direction[] array = new Direction[size()];
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