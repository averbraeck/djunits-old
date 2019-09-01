package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.AreaUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Area;

/**
 * Immutable Double AreaVector, a vector of values with a AreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class AreaVector extends AbstractDoubleVectorRel<AreaUnit, AreaVector, MutableAreaVector, Area>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double AreaVector
     * @param unit AreaUnit; the unit of the new Relative Immutable Double AreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AreaVector(final double[] values, final AreaUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double AreaVector
     * @param unit AreaUnit; the unit of the new Relative Immutable Double AreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AreaVector(final List<Double> values, final AreaUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values Area[]; the values of the entries in the new Relative Immutable Double AreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AreaVector(final Area[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values List&lt;Area&gt;; the values of the entries in the new Relative Immutable Double AreaVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AreaVector(final List<Area> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values SortedMap&lt;Integer, Area&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            AreaVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AreaVector(final SortedMap<Integer, Area> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            AreaVector
     * @param unit AreaUnit; the unit of the new Relative Sparse Mutable Double AreaVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AreaVector(final SortedMap<Integer, Double> values, final AreaUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit AreaUnit; the unit
     */
    AreaVector(final DoubleVectorData data, final AreaUnit unit)
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
    protected final Area instantiateScalar(final double value, final AreaUnit unit)
    {
        return new Area(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AreaVector toDense()
    {
        return this.data.isDense() ? (AreaVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AreaVector toSparse()
    {
        return this.data.isSparse() ? (AreaVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Area Scalars from this vector.
     * @return Area[]; an array of Area Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Area[] toArray()
    {
        Area[] array = new Area[size()];
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
