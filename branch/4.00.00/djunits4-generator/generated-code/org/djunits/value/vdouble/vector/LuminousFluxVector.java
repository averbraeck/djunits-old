package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double LuminousFluxVector, a vector of values with a LuminousFluxUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class LuminousFluxVector extends
    AbstractDoubleVectorRel<LuminousFluxUnit, LuminousFluxVector, MutableLuminousFluxVector, LuminousFlux>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double LuminousFluxVector
     * @param unit U; the unit of the new Relative Immutable Double LuminousFluxVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public LuminousFluxVector(final double[] values, final LuminousFluxUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values List; the values of the entries in the new Relative Immutable Double LuminousFluxVector
     * @param unit U; the unit of the new Relative Immutable Double LuminousFluxVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public LuminousFluxVector(final List<Double> values, final LuminousFluxUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            LuminousFluxVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public LuminousFluxVector(final LuminousFlux[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values List; the values of the entries in the new Relative Immutable Double LuminousFluxVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public LuminousFluxVector(final List<LuminousFlux> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            LuminousFluxVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public LuminousFluxVector(final SortedMap<Integer, LuminousFlux> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double LuminousFluxVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double LuminousFluxVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public LuminousFluxVector(final SortedMap<Integer, Double> values, final LuminousFluxUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    LuminousFluxVector(final DoubleVectorData data, final LuminousFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LuminousFluxVector instantiateType(final DoubleVectorData dvd, final LuminousFluxUnit unit)
    {
        return new LuminousFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableLuminousFluxVector instantiateMutableType(final DoubleVectorData dvd, final LuminousFluxUnit unit)
    {
        return new MutableLuminousFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LuminousFlux instantiateScalar(final double value, final LuminousFluxUnit unit)
    {
        return new LuminousFlux(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final LuminousFluxVector toDense()
    {
        return this.data.isDense() ? (LuminousFluxVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LuminousFluxVector toSparse()
    {
        return this.data.isSparse() ? (LuminousFluxVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of LuminousFlux Scalars from this vector.
     * @return LuminousFlux[]; an array of LuminousFlux Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public LuminousFlux[] toArray()
    {
        LuminousFlux[] array = new LuminousFlux[size()];
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
