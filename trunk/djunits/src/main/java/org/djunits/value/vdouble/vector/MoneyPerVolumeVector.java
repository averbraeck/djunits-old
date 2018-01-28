package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerVolume;

/**
 * Immutable Double MoneyPerVolumeVector, a vector of values with a MoneyPerVolumeUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerVolumeVector
        extends AbstractDoubleVectorRel<MoneyPerVolumeUnit, MoneyPerVolumeVector, MutableMoneyPerVolumeVector, MoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MoneyPerVolumeVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerVolumeVector(final double[] values, final MoneyPerVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerVolumeVector
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerVolumeVector(final List<Double> values, final MoneyPerVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            MoneyPerVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerVolumeVector(final MoneyPerVolume[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MoneyPerVolumeVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerVolumeVector(final List<MoneyPerVolume> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            MoneyPerVolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerVolumeVector(final SortedMap<Integer, MoneyPerVolume> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double MoneyPerVolumeVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double MoneyPerVolumeVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerVolumeVector(final SortedMap<Integer, Double> values, final MoneyPerVolumeUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MoneyPerVolumeVector(final DoubleVectorData data, final MoneyPerVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerVolumeVector instantiateType(final DoubleVectorData dvd, final MoneyPerVolumeUnit unit)
    {
        return new MoneyPerVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerVolumeVector instantiateMutableType(final DoubleVectorData dvd,
            final MoneyPerVolumeUnit unit)
    {
        return new MutableMoneyPerVolumeVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerVolume instantiateScalar(final double value, final MoneyPerVolumeUnit unit)
    {
        return new MoneyPerVolume(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolumeVector toDense()
    {
        return this.data.isDense() ? (MoneyPerVolumeVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolumeVector toSparse()
    {
        return this.data.isSparse() ? (MoneyPerVolumeVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

}
