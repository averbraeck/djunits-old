package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Temperature;

/**
 * Immutable Relative Temperature Vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class TemperatureVector
        extends AbstractDoubleVectorRel<TemperatureUnit, TemperatureVector, MutableTemperatureVector, Temperature>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double TemperatureVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double TemperatureVector
     * @param unit U; the unit of the new Relative Immutable Double TemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TemperatureVector(final double[] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TemperatureVector.
     * @param values List; the values of the entries in the new Relative Immutable Double TemperatureVector
     * @param unit U; the unit of the new Relative Immutable Double TemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TemperatureVector(final List<Double> values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TemperatureVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            TemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TemperatureVector(final Temperature[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TemperatureVector.
     * @param values List; the values of the entries in the new Relative Immutable Double TemperatureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TemperatureVector(final List<Temperature> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TemperatureVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            TemperatureVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public TemperatureVector(final SortedMap<Integer, Temperature> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TemperatureVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double TemperatureVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double TemperatureVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public TemperatureVector(final SortedMap<Integer, Double> values, final TemperatureUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TemperatureVector.
     * @param data an internal data object
     * @param unit the unit
     */
    TemperatureVector(final DoubleVectorData data, final TemperatureUnit unit)
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
    public final TemperatureVector toDense()
    {
        return this.data.isDense() ? (TemperatureVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final TemperatureVector toSparse()
    {
        return this.data.isSparse() ? (TemperatureVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative Temperature vector.
     */
    public final AbsoluteTemperatureVector toAbs()
    {
        return new AbsoluteTemperatureVector(getData(), getUnit());
    }

}
