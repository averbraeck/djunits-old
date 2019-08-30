package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.AmountOfSubstanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.AmountOfSubstance;

/**
 * Immutable Double AmountOfSubstanceVector, a vector of values with a AmountOfSubstanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AmountOfSubstanceVector extends AbstractDoubleVectorRel<AmountOfSubstanceUnit, AmountOfSubstanceVector,
        MutableAmountOfSubstanceVector, AmountOfSubstance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double AmountOfSubstanceVector
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Immutable Double AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AmountOfSubstanceVector(final double[] values, final AmountOfSubstanceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double AmountOfSubstanceVector
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Immutable Double AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AmountOfSubstanceVector(final List<Double> values, final AmountOfSubstanceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values AmountOfSubstance[]; the values of the entries in the new Relative Immutable Double AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AmountOfSubstanceVector(final AmountOfSubstance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values List&lt;AmountOfSubstance&gt;; the values of the entries in the new Relative Immutable Double
     *            AmountOfSubstanceVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AmountOfSubstanceVector(final List<AmountOfSubstance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values SortedMap&lt;Integer, AmountOfSubstance&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Double AmountOfSubstanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AmountOfSubstanceVector(final SortedMap<Integer, AmountOfSubstance> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            AmountOfSubstanceVector
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Sparse Mutable Double AmountOfSubstanceVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AmountOfSubstanceVector(final SortedMap<Integer, Double> values, final AmountOfSubstanceUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit AmountOfSubstanceUnit; the unit
     */
    AmountOfSubstanceVector(final DoubleVectorData data, final AmountOfSubstanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AmountOfSubstanceVector instantiateType(final DoubleVectorData dvd, final AmountOfSubstanceUnit unit)
    {
        return new AmountOfSubstanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAmountOfSubstanceVector instantiateMutableType(final DoubleVectorData dvd,
            final AmountOfSubstanceUnit unit)
    {
        return new MutableAmountOfSubstanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AmountOfSubstance instantiateScalar(final double value, final AmountOfSubstanceUnit unit)
    {
        return new AmountOfSubstance(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AmountOfSubstanceVector toDense()
    {
        return this.data.isDense() ? (AmountOfSubstanceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AmountOfSubstanceVector toSparse()
    {
        return this.data.isSparse() ? (AmountOfSubstanceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of AmountOfSubstance Scalars from this vector.
     * @return AmountOfSubstance[]; an array of AmountOfSubstance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public AmountOfSubstance[] toArray()
    {
        AmountOfSubstance[] array = new AmountOfSubstance[size()];
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
