package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Temperature;

/**
 * Mutable Relative Temperature Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableTemperatureVector
        extends AbstractMutableDoubleVectorRel<TemperatureUnit, TemperatureVector, MutableTemperatureVector, Temperature>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable Double TemperatureVector.
     * @param values double[]; the values of the entries in the new Relative Mutable Double TemperatureVector
     * @param unit TemperatureUnit; the unit of the new Relative Mutable Double TemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableTemperatureVector(final double[] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double TemperatureVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Mutable Double TemperatureVector
     * @param unit TemperatureUnit; the unit of the new Relative Mutable Double TemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableTemperatureVector(final List<Double> values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double TemperatureVector.
     * @param values Temperature[]; the values of the entries in the new Relative Mutable Double TemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableTemperatureVector(final Temperature[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double TemperatureVector.
     * @param values List&lt;Temperature&gt;; the values of the entries in the new Relative Mutable Double TemperatureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableTemperatureVector(final List<Temperature> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double TemperatureVector.
     * @param values SortedMap&lt;Integer, Temperature&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            TemperatureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableTemperatureVector(final SortedMap<Integer, Temperature> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Double TemperatureVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            TemperatureVector
     * @param unit TemperatureUnit; the unit of the new Relative Sparse Mutable Double TemperatureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableTemperatureVector(final SortedMap<Integer, Double> values, final TemperatureUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Double TemperatureVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit TemperatureUnit; the unit
     */
    MutableTemperatureVector(final DoubleVectorData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final TemperatureVector instantiateType(final DoubleVectorData dvd, final TemperatureUnit unit)
    {
        return new TemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableTemperatureVector instantiateMutableType(final DoubleVectorData dvd, final TemperatureUnit unit)
    {
        return new MutableTemperatureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Temperature instantiateScalar(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTemperatureVector toDense()
    {
        return this.data.isDense() ? (MutableTemperatureVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTemperatureVector toSparse()
    {
        return this.data.isSparse() ? (MutableTemperatureVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Temperature Scalars from this vector.
     * @return Temperature[]; an array of Temperature Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Temperature[] toArray()
    {
        Temperature[] array = new Temperature[size()];
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
