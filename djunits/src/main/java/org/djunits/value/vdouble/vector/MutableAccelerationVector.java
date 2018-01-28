package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AccelerationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Acceleration;

/**
 * Mutable Double AccelerationVector, a vector of values with a AccelerationUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableAccelerationVector
        extends AbstractMutableDoubleVectorRel<AccelerationUnit, AccelerationVector, MutableAccelerationVector, Acceleration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AccelerationVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double AccelerationVector
     * @param unit U; the unit of the new Relative Immutable Double AccelerationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAccelerationVector(final double[] values, final AccelerationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AccelerationVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AccelerationVector
     * @param unit U; the unit of the new Relative Immutable Double AccelerationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAccelerationVector(final List<Double> values, final AccelerationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AccelerationVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            AccelerationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAccelerationVector(final Acceleration[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AccelerationVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AccelerationVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAccelerationVector(final List<Acceleration> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AccelerationVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            AccelerationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAccelerationVector(final SortedMap<Integer, Acceleration> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AccelerationVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double AccelerationVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double AccelerationVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAccelerationVector(final SortedMap<Integer, Double> values, final AccelerationUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableAccelerationVector(final DoubleVectorData data, final AccelerationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AccelerationVector instantiateType(final DoubleVectorData dvd, final AccelerationUnit unit)
    {
        return new AccelerationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAccelerationVector instantiateMutableType(final DoubleVectorData dvd, final AccelerationUnit unit)
    {
        return new MutableAccelerationVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Acceleration instantiateScalar(final double value, final AccelerationUnit unit)
    {
        return new Acceleration(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector toDense()
    {
        return this.data.isDense() ? (MutableAccelerationVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAccelerationVector toSparse()
    {
        return this.data.isSparse() ? (MutableAccelerationVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Acceleration Scalars from this vector.
     * @return Acceleration[]; an array of Acceleration Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Acceleration[] toArray()
    {
        Acceleration[] array = new Acceleration[size()];
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
