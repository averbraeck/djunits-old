package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.FrequencyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Frequency;

/**
 * Mutable Double FrequencyVector, a vector of values with a FrequencyUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFrequencyVector extends
    MutableTypedDoubleVectorRel<FrequencyUnit, FrequencyVector, MutableFrequencyVector, Frequency>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double FrequencyVector
     * @param unit U; the unit of the new Relative Immutable Double FrequencyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFrequencyVector(final double[] values, final FrequencyUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values List; the values of the entries in the new Relative Immutable Double FrequencyVector
     * @param unit U; the unit of the new Relative Immutable Double FrequencyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFrequencyVector(final List<Double> values, final FrequencyUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double FrequencyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFrequencyVector(final Frequency[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values List; the values of the entries in the new Relative Immutable Double FrequencyVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFrequencyVector(final List<Frequency> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            FrequencyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFrequencyVector(final SortedMap<Integer, Frequency> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double FrequencyVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double FrequencyVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFrequencyVector(final SortedMap<Integer, Double> values, final FrequencyUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFrequencyVector(final DoubleVectorData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FrequencyVector instantiateType(final DoubleVectorData dvd, final FrequencyUnit unit)
    {
        return new FrequencyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFrequencyVector instantiateMutableType(final DoubleVectorData dvd, final FrequencyUnit unit)
    {
        return new MutableFrequencyVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Frequency get(final int index) throws ValueException
    {
        return new Frequency(getInUnit(index, getUnit()), getUnit());
    }

}
