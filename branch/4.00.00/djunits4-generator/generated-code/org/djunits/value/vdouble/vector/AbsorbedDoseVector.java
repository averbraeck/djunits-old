package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double AbsorbedDoseVector, a vector of values with a AbsorbedDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class AbsorbedDoseVector extends
    AbstractDoubleVectorRel<AbsorbedDoseUnit, AbsorbedDoseVector, MutableAbsorbedDoseVector, AbsorbedDose>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double AbsorbedDoseVector
     * @param unit U; the unit of the new Relative Immutable Double AbsorbedDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AbsorbedDoseVector(final double[] values, final AbsorbedDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AbsorbedDoseVector
     * @param unit U; the unit of the new Relative Immutable Double AbsorbedDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AbsorbedDoseVector(final List<Double> values, final AbsorbedDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            AbsorbedDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AbsorbedDoseVector(final AbsorbedDose[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AbsorbedDoseVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AbsorbedDoseVector(final List<AbsorbedDose> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            AbsorbedDoseVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AbsorbedDoseVector(final SortedMap<Integer, AbsorbedDose> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double AbsorbedDoseVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double AbsorbedDoseVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AbsorbedDoseVector(final SortedMap<Integer, Double> values, final AbsorbedDoseUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    AbsorbedDoseVector(final DoubleVectorData data, final AbsorbedDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AbsorbedDoseVector instantiateType(final DoubleVectorData dvd, final AbsorbedDoseUnit unit)
    {
        return new AbsorbedDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAbsorbedDoseVector instantiateMutableType(final DoubleVectorData dvd, final AbsorbedDoseUnit unit)
    {
        return new MutableAbsorbedDoseVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AbsorbedDose instantiateScalar(final double value, final AbsorbedDoseUnit unit)
    {
        return new AbsorbedDose(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final AbsorbedDoseVector toDense()
    {
        return this.data.isDense() ? (AbsorbedDoseVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AbsorbedDoseVector toSparse()
    {
        return this.data.isSparse() ? (AbsorbedDoseVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of AbsorbedDose Scalars from this vector.
     * @return AbsorbedDose[]; an array of AbsorbedDose Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public AbsorbedDose[] toArray()
    {
        AbsorbedDose[] array = new AbsorbedDose[size()];
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
