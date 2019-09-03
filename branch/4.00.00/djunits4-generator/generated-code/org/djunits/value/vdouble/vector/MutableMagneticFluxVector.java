package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double MagneticFluxVector, a vector of values with a MagneticFluxUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.197Z")
public class MutableMagneticFluxVector extends
    AbstractMutableDoubleVectorRel<MagneticFluxUnit, MagneticFluxVector, MutableMagneticFluxVector, MagneticFlux> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MagneticFluxVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MagneticFluxVector
     * @param unit MagneticFluxUnit; the unit of the new Relative Immutable Double MagneticFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMagneticFluxVector(final double[] values, final MagneticFluxUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double MagneticFluxVector
     * @param unit MagneticFluxUnit; the unit of the new Relative Immutable Double MagneticFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMagneticFluxVector(final List<Double> values, final MagneticFluxUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxVector.
     * @param values MagneticFlux[]; the values of the entries in the new Relative Immutable Double MagneticFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMagneticFluxVector(final MagneticFlux[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxVector.
     * @param values List&lt;MagneticFlux&gt;; the values of the entries in the new Relative Immutable Double MagneticFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMagneticFluxVector(final List<MagneticFlux> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxVector.
     * @param values SortedMap&lt;Integer, MagneticFlux&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            MagneticFluxVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMagneticFluxVector(final SortedMap<Integer, MagneticFlux> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double MagneticFluxVector
     * @param unit MagneticFluxUnit; the unit of the new Relative Sparse Mutable Double MagneticFluxVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMagneticFluxVector(final SortedMap<Integer, Double> values, final MagneticFluxUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit MagneticFluxUnit; the unit
     */
    MutableMagneticFluxVector(final DoubleVectorData data, final MagneticFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFluxVector instantiateType(final DoubleVectorData dvd, final MagneticFluxUnit unit)
    {
        return new MagneticFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMagneticFluxVector instantiateMutableType(final DoubleVectorData dvd, final MagneticFluxUnit unit)
    {
        return new MutableMagneticFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFlux instantiateScalar(final double value, final MagneticFluxUnit unit)
    {
        return new MagneticFlux(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableMagneticFluxVector toDense()
    {
        return this.data.isDense() ? (MutableMagneticFluxVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMagneticFluxVector toSparse()
    {
        return this.data.isSparse() ? (MutableMagneticFluxVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of MagneticFlux Scalars from this vector.
     * @return MagneticFlux[]; an array of MagneticFlux Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public MagneticFlux[] toArray()
    {
        MagneticFlux[] array = new MagneticFlux[size()];
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
