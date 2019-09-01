package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double CatalyticActivityVector, a vector of values with a CatalyticActivityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableCatalyticActivityVector extends
    AbstractMutableDoubleVectorRel<CatalyticActivityUnit, CatalyticActivityVector, MutableCatalyticActivityVector, CatalyticActivity> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double CatalyticActivityVector
     * @param unit CatalyticActivityUnit; the unit of the new Relative Immutable Double CatalyticActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableCatalyticActivityVector(final double[] values, final CatalyticActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double CatalyticActivityVector
     * @param unit CatalyticActivityUnit; the unit of the new Relative Immutable Double CatalyticActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableCatalyticActivityVector(final List<Double> values, final CatalyticActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values CatalyticActivity[]; the values of the entries in the new Relative Immutable Double CatalyticActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableCatalyticActivityVector(final CatalyticActivity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values List&lt;CatalyticActivity&gt;; the values of the entries in the new Relative Immutable Double CatalyticActivityVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableCatalyticActivityVector(final List<CatalyticActivity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values SortedMap&lt;Integer, CatalyticActivity&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            CatalyticActivityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableCatalyticActivityVector(final SortedMap<Integer, CatalyticActivity> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double CatalyticActivityVector
     * @param unit CatalyticActivityUnit; the unit of the new Relative Sparse Mutable Double CatalyticActivityVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableCatalyticActivityVector(final SortedMap<Integer, Double> values, final CatalyticActivityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit CatalyticActivityUnit; the unit
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
    protected final MutableCatalyticActivityVector instantiateMutableType(final DoubleVectorData dvd, final CatalyticActivityUnit unit)
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
        return this.data.isDense() ? (MutableCatalyticActivityVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableCatalyticActivityVector toSparse()
    {
        return this.data.isSparse() ? (MutableCatalyticActivityVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
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
