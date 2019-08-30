package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double MassVector, a vector of values with a MassUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MassVector extends
    AbstractDoubleVectorRel<MassUnit, MassVector, MutableMassVector, Mass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MassVector
     * @param unit U; the unit of the new Relative Immutable Double MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MassVector(final double[] values, final MassUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MassVector
     * @param unit U; the unit of the new Relative Immutable Double MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MassVector(final List<Double> values, final MassUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MassVector(final Mass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MassVector(final List<Mass> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            MassVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MassVector(final SortedMap<Integer, Mass> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double MassVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double MassVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MassVector(final SortedMap<Integer, Double> values, final MassUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MassVector(final DoubleVectorData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MassVector instantiateType(final DoubleVectorData dvd, final MassUnit unit)
    {
        return new MassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMassVector instantiateMutableType(final DoubleVectorData dvd, final MassUnit unit)
    {
        return new MutableMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mass instantiateScalar(final double value, final MassUnit unit)
    {
        return new Mass(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MassVector toDense()
    {
        return this.data.isDense() ? (MassVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MassVector toSparse()
    {
        return this.data.isSparse() ? (MassVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of Mass Scalars from this vector.
     * @return Mass[]; an array of Mass Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Mass[] toArray()
    {
        Mass[] array = new Mass[size()];
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
