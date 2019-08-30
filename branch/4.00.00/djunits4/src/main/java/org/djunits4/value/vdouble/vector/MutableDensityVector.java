package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.DensityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Density;

/**
 * Mutable Double DensityVector, a vector of values with a DensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableDensityVector
        extends AbstractMutableDoubleVectorRel<DensityUnit, DensityVector, MutableDensityVector, Density>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double DensityVector
     * @param unit U; the unit of the new Relative Immutable Double DensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDensityVector(final double[] values, final DensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double DensityVector
     * @param unit U; the unit of the new Relative Immutable Double DensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDensityVector(final List<Double> values, final DensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double DensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDensityVector(final Density[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double DensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDensityVector(final List<Density> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            DensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDensityVector(final SortedMap<Integer, Density> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double DensityVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double DensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDensityVector(final SortedMap<Integer, Double> values, final DensityUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableDensityVector(final DoubleVectorData data, final DensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DensityVector instantiateType(final DoubleVectorData dvd, final DensityUnit unit)
    {
        return new DensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDensityVector instantiateMutableType(final DoubleVectorData dvd, final DensityUnit unit)
    {
        return new MutableDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Density instantiateScalar(final double value, final DensityUnit unit)
    {
        return new Density(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector toDense()
    {
        return this.data.isDense() ? (MutableDensityVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityVector toSparse()
    {
        return this.data.isSparse() ? (MutableDensityVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Density Scalars from this vector.
     * @return Density[]; an array of Density Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Density[] toArray()
    {
        Density[] array = new Density[size()];
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
