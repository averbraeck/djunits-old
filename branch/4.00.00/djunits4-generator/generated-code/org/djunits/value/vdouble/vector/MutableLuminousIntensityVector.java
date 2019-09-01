package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double LuminousIntensityVector, a vector of values with a LuminousIntensityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableLuminousIntensityVector extends
    AbstractMutableDoubleVectorRel<LuminousIntensityUnit, LuminousIntensityVector, MutableLuminousIntensityVector, LuminousIntensity> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double LuminousIntensityVector
     * @param unit U; the unit of the new Relative Immutable Double LuminousIntensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLuminousIntensityVector(final double[] values, final LuminousIntensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double LuminousIntensityVector
     * @param unit U; the unit of the new Relative Immutable Double LuminousIntensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLuminousIntensityVector(final List<Double> values, final LuminousIntensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            LuminousIntensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLuminousIntensityVector(final LuminousIntensity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double LuminousIntensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLuminousIntensityVector(final List<LuminousIntensity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            LuminousIntensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLuminousIntensityVector(final SortedMap<Integer, LuminousIntensity> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousIntensityVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double LuminousIntensityVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double LuminousIntensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLuminousIntensityVector(final SortedMap<Integer, Double> values, final LuminousIntensityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableLuminousIntensityVector(final DoubleVectorData data, final LuminousIntensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LuminousIntensityVector instantiateType(final DoubleVectorData dvd, final LuminousIntensityUnit unit)
    {
        return new LuminousIntensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableLuminousIntensityVector instantiateMutableType(final DoubleVectorData dvd, final LuminousIntensityUnit unit)
    {
        return new MutableLuminousIntensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LuminousIntensity instantiateScalar(final double value, final LuminousIntensityUnit unit)
    {
        return new LuminousIntensity(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableLuminousIntensityVector toDense()
    {
        return this.data.isDense() ? (MutableLuminousIntensityVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLuminousIntensityVector toSparse()
    {
        return this.data.isSparse() ? (MutableLuminousIntensityVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of LuminousIntensity Scalars from this vector.
     * @return LuminousIntensity[]; an array of LuminousIntensity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public LuminousIntensity[] toArray()
    {
        LuminousIntensity[] array = new LuminousIntensity[size()];
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
