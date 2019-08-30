package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.LengthUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Length;

/**
 * Mutable Relative Length Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableLengthVector extends AbstractMutableDoubleVectorRel<LengthUnit, LengthVector, MutableLengthVector, Length>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable Double LengthVector.
     * @param values double[]; the values of the entries in the new Relative Mutable Double LengthVector
     * @param unit LengthUnit; the unit of the new Relative Mutable Double LengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLengthVector(final double[] values, final LengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double LengthVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Mutable Double LengthVector
     * @param unit LengthUnit; the unit of the new Relative Mutable Double LengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLengthVector(final List<Double> values, final LengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double LengthVector.
     * @param values Length[]; the values of the entries in the new Relative Mutable Double LengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLengthVector(final Length[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double LengthVector.
     * @param values List&lt;Length&gt;; the values of the entries in the new Relative Mutable Double LengthVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLengthVector(final List<Length> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double LengthVector.
     * @param values SortedMap&lt;Integer, Length&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            LengthVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLengthVector(final SortedMap<Integer, Length> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Double LengthVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            LengthVector
     * @param unit LengthUnit; the unit of the new Relative Sparse Mutable Double LengthVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLengthVector(final SortedMap<Integer, Double> values, final LengthUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Double LengthVector.
     * @param data DoubleVectorData; an internal data object
     * @param unit LengthUnit; the unit
     */
    MutableLengthVector(final DoubleVectorData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LengthVector instantiateType(final DoubleVectorData dvd, final LengthUnit unit)
    {
        return new LengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableLengthVector instantiateMutableType(final DoubleVectorData dvd, final LengthUnit unit)
    {
        return new MutableLengthVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Length instantiateScalar(final double value, final LengthUnit unit)
    {
        return new Length(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLengthVector toDense()
    {
        return this.data.isDense() ? (MutableLengthVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLengthVector toSparse()
    {
        return this.data.isSparse() ? (MutableLengthVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Length Scalars from this vector.
     * @return Length[]; an array of Length Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Length[] toArray()
    {
        Length[] array = new Length[size()];
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
