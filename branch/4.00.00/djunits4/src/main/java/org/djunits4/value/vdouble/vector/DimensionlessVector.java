package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Dimensionless;

/**
 * Immutable Double DimensionlessVector, a vector of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DimensionlessVector
        extends AbstractDoubleVectorRel<DimensionlessUnit, DimensionlessVector, MutableDimensionlessVector, Dimensionless>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double DimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Double DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DimensionlessVector(final double[] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double DimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Double DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DimensionlessVector(final List<Double> values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values Dimensionless[]; the values of the entries in the new Relative Immutable Double DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DimensionlessVector(final Dimensionless[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values List&lt;Dimensionless&gt;; the values of the entries in the new Relative Immutable Double
     *            DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DimensionlessVector(final List<Dimensionless> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values SortedMap&lt;Integer, Dimensionless&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Double DimensionlessVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DimensionlessVector(final SortedMap<Integer, Dimensionless> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            DimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Sparse Mutable Double DimensionlessVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DimensionlessVector(final SortedMap<Integer, Double> values, final DimensionlessUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    DimensionlessVector(final DoubleVectorData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DimensionlessVector instantiateType(final DoubleVectorData dvd, final DimensionlessUnit unit)
    {
        return new DimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDimensionlessVector instantiateMutableType(final DoubleVectorData dvd, final DimensionlessUnit unit)
    {
        return new MutableDimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Dimensionless instantiateScalar(final double value, final DimensionlessUnit unit)
    {
        return new Dimensionless(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector toDense()
    {
        return this.data.isDense() ? (DimensionlessVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessVector toSparse()
    {
        return this.data.isSparse() ? (DimensionlessVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Dimensionless Scalars from this vector.
     * @return Dimensionless[]; an array of Dimensionless Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Dimensionless[] toArray()
    {
        Dimensionless[] array = new Dimensionless[size()];
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
