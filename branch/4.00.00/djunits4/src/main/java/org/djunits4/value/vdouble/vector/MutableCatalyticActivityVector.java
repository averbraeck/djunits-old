package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.CatalyticActivityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.CatalyticActivity;

/**
 * Mutable Double CatalyticActivityVector, a vector of values with a CatalyticActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableCatalyticActivityVector extends AbstractMutableDoubleVectorRel<CatalyticActivityUnit,
        CatalyticActivityVector, MutableCatalyticActivityVector, CatalyticActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double CatalyticActivityVector
     * @param unit U; the unit of the new Relative Immutable Double CatalyticActivityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableCatalyticActivityVector(final double[] values, final CatalyticActivityUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double CatalyticActivityVector
     * @param unit U; the unit of the new Relative Immutable Double CatalyticActivityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableCatalyticActivityVector(final List<Double> values, final CatalyticActivityUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            CatalyticActivityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableCatalyticActivityVector(final CatalyticActivity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double CatalyticActivityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableCatalyticActivityVector(final List<CatalyticActivity> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            CatalyticActivityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableCatalyticActivityVector(final SortedMap<Integer, CatalyticActivity> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double CatalyticActivityVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double CatalyticActivityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableCatalyticActivityVector(final SortedMap<Integer, Double> values, final CatalyticActivityUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableCatalyticActivityVector(final DoubleVectorData data, final CatalyticActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final CatalyticActivityVector instantiateType(final DoubleVectorData dvd, final CatalyticActivityUnit unit)
    {
        return new CatalyticActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableCatalyticActivityVector instantiateMutableType(final DoubleVectorData dvd,
            final CatalyticActivityUnit unit)
    {
        return new MutableCatalyticActivityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final CatalyticActivity instantiateScalar(final double value, final CatalyticActivityUnit unit)
    {
        return new CatalyticActivity(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableCatalyticActivityVector toDense()
    {
        return this.data.isDense() ? (MutableCatalyticActivityVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableCatalyticActivityVector toSparse()
    {
        return this.data.isSparse() ? (MutableCatalyticActivityVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of CatalyticActivity Scalars from this vector.
     * @return CatalyticActivity[]; an array of CatalyticActivity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public CatalyticActivity[] toArray()
    {
        CatalyticActivity[] array = new CatalyticActivity[size()];
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
