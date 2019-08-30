package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double ElectricalConductanceVector, a vector of values with a ElectricalConductanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableElectricalConductanceVector extends
    AbstractMutableDoubleVectorRel<ElectricalConductanceUnit, ElectricalConductanceVector, MutableElectricalConductanceVector, ElectricalConductance> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalConductanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalConductanceVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalConductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalConductanceVector(final double[] values, final ElectricalConductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalConductanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalConductanceVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalConductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalConductanceVector(final List<Double> values, final ElectricalConductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalConductanceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            ElectricalConductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalConductanceVector(final ElectricalConductance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalConductanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalConductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalConductanceVector(final List<ElectricalConductance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalConductanceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            ElectricalConductanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalConductanceVector(final SortedMap<Integer, ElectricalConductance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalConductanceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double ElectricalConductanceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double ElectricalConductanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalConductanceVector(final SortedMap<Integer, Double> values, final ElectricalConductanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableElectricalConductanceVector(final DoubleVectorData data, final ElectricalConductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalConductanceVector instantiateType(final DoubleVectorData dvd, final ElectricalConductanceUnit unit)
    {
        return new ElectricalConductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalConductanceVector instantiateMutableType(final DoubleVectorData dvd, final ElectricalConductanceUnit unit)
    {
        return new MutableElectricalConductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalConductance instantiateScalar(final double value, final ElectricalConductanceUnit unit)
    {
        return new ElectricalConductance(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableElectricalConductanceVector toDense()
    {
        return this.data.isDense() ? (MutableElectricalConductanceVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalConductanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableElectricalConductanceVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of ElectricalConductance Scalars from this vector.
     * @return ElectricalConductance[]; an array of ElectricalConductance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public ElectricalConductance[] toArray()
    {
        ElectricalConductance[] array = new ElectricalConductance[size()];
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
