package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AngleSolid;

/**
 * Mutable Double AngleSolidVector, a vector of values with a AngleSolidUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableAngleSolidVector
        extends AbstractMutableDoubleVectorRel<AngleSolidUnit, AngleSolidVector, MutableAngleSolidVector, AngleSolid>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double AngleSolidVector
     * @param unit AngleSolidUnit; the unit of the new Relative Immutable Double AngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAngleSolidVector(final double[] values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double AngleSolidVector
     * @param unit AngleSolidUnit; the unit of the new Relative Immutable Double AngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAngleSolidVector(final List<Double> values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values AngleSolid[]; the values of the entries in the new Relative Immutable Double AngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAngleSolidVector(final AngleSolid[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values List&lt;AngleSolid&gt;; the values of the entries in the new Relative Immutable Double AngleSolidVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAngleSolidVector(final List<AngleSolid> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values SortedMap&lt;Integer, AngleSolid&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            AngleSolidVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAngleSolidVector(final SortedMap<Integer, AngleSolid> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            AngleSolidVector
     * @param unit AngleSolidUnit; the unit of the new Relative Sparse Mutable Double AngleSolidVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAngleSolidVector(final SortedMap<Integer, Double> values, final AngleSolidUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit AngleSolidUnit; the unit
     */
    MutableAngleSolidVector(final DoubleVectorData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleSolidVector instantiateType(final DoubleVectorData dvd, final AngleSolidUnit unit)
    {
        return new AngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAngleSolidVector instantiateMutableType(final DoubleVectorData dvd, final AngleSolidUnit unit)
    {
        return new MutableAngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleSolid instantiateScalar(final double value, final AngleSolidUnit unit)
    {
        return new AngleSolid(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector toDense()
    {
        return this.data.isDense() ? (MutableAngleSolidVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector toSparse()
    {
        return this.data.isSparse() ? (MutableAngleSolidVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of AngleSolid Scalars from this vector.
     * @return AngleSolid[]; an array of AngleSolid Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public AngleSolid[] toArray()
    {
        AngleSolid[] array = new AngleSolid[size()];
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
