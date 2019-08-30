package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.PowerUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Power;

/**
 * Immutable Double PowerVector, a vector of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class PowerVector extends AbstractDoubleVectorRel<PowerUnit, PowerVector, MutablePowerVector, Power>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double PowerVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double PowerVector
     * @param unit U; the unit of the new Relative Immutable Double PowerVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PowerVector(final double[] values, final PowerUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PowerVector.
     * @param values List; the values of the entries in the new Relative Immutable Double PowerVector
     * @param unit U; the unit of the new Relative Immutable Double PowerVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PowerVector(final List<Double> values, final PowerUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PowerVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double PowerVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PowerVector(final Power[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PowerVector.
     * @param values List; the values of the entries in the new Relative Immutable Double PowerVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PowerVector(final List<Power> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PowerVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            PowerVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PowerVector(final SortedMap<Integer, Power> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PowerVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double PowerVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double PowerVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PowerVector(final SortedMap<Integer, Double> values, final PowerUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    PowerVector(final DoubleVectorData data, final PowerUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final PowerVector instantiateType(final DoubleVectorData dvd, final PowerUnit unit)
    {
        return new PowerVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutablePowerVector instantiateMutableType(final DoubleVectorData dvd, final PowerUnit unit)
    {
        return new MutablePowerVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Power instantiateScalar(final double value, final PowerUnit unit)
    {
        return new Power(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final PowerVector toDense()
    {
        return this.data.isDense() ? (PowerVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final PowerVector toSparse()
    {
        return this.data.isSparse() ? (PowerVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Power Scalars from this vector.
     * @return Power[]; an array of Power Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Power[] toArray()
    {
        Power[] array = new Power[size()];
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
