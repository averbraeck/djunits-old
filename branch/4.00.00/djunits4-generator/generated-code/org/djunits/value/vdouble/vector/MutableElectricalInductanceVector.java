package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double ElectricalInductanceVector, a vector of values with a ElectricalInductanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableElectricalInductanceVector extends
    AbstractMutableDoubleVectorRel<ElectricalInductanceUnit, ElectricalInductanceVector, MutableElectricalInductanceVector, ElectricalInductance> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double ElectricalInductanceVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalInductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalInductanceVector(final double[] values, final ElectricalInductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalInductanceVector
     * @param unit U; the unit of the new Relative Immutable Double ElectricalInductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalInductanceVector(final List<Double> values, final ElectricalInductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            ElectricalInductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalInductanceVector(final ElectricalInductance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double ElectricalInductanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalInductanceVector(final List<ElectricalInductance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            ElectricalInductanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalInductanceVector(final SortedMap<Integer, ElectricalInductance> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalInductanceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double ElectricalInductanceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double ElectricalInductanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalInductanceVector(final SortedMap<Integer, Double> values, final ElectricalInductanceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableElectricalInductanceVector(final DoubleVectorData data, final ElectricalInductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalInductanceVector instantiateType(final DoubleVectorData dvd, final ElectricalInductanceUnit unit)
    {
        return new ElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalInductanceVector instantiateMutableType(final DoubleVectorData dvd, final ElectricalInductanceUnit unit)
    {
        return new MutableElectricalInductanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalInductance instantiateScalar(final double value, final ElectricalInductanceUnit unit)
    {
        return new ElectricalInductance(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableElectricalInductanceVector toDense()
    {
        return this.data.isDense() ? (MutableElectricalInductanceVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalInductanceVector toSparse()
    {
        return this.data.isSparse() ? (MutableElectricalInductanceVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of ElectricalInductance Scalars from this vector.
     * @return ElectricalInductance[]; an array of ElectricalInductance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public ElectricalInductance[] toArray()
    {
        ElectricalInductance[] array = new ElectricalInductance[size()];
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
