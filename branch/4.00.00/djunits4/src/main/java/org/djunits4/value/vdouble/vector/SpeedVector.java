package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.SpeedUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Speed;

/**
 * Immutable Double SpeedVector, a vector of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class SpeedVector extends AbstractDoubleVectorRel<SpeedUnit, SpeedVector, MutableSpeedVector, Speed>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param unit SpeedUnit; the unit of the new Relative Immutable Double SpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public SpeedVector(final double[] values, final SpeedUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param unit SpeedUnit; the unit of the new Relative Immutable Double SpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public SpeedVector(final List<Double> values, final SpeedUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values Speed[]; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public SpeedVector(final Speed[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values List&lt;Speed&gt;; the values of the entries in the new Relative Immutable Double SpeedVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public SpeedVector(final List<Speed> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values SortedMap&lt;Integer, Speed&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            SpeedVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public SpeedVector(final SortedMap<Integer, Speed> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            SpeedVector
     * @param unit SpeedUnit; the unit of the new Relative Sparse Mutable Double SpeedVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public SpeedVector(final SortedMap<Integer, Double> values, final SpeedUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit SpeedUnit; the unit
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
    protected final Speed instantiateScalar(final double value, final SpeedUnit unit)
    {
        return new Speed(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final SpeedVector toDense()
    {
        return this.data.isDense() ? (SpeedVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final SpeedVector toSparse()
    {
        return this.data.isSparse() ? (SpeedVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Speed Scalars from this vector.
     * @return Speed[]; an array of Speed Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Speed[] toArray()
    {
        Speed[] array = new Speed[size()];
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
