package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.LuminousFlux;

/**
 * Mutable Double LuminousFluxVector, a vector of values with a LuminousFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableLuminousFluxVector
        extends AbstractMutableDoubleVectorRel<LuminousFluxUnit, LuminousFluxVector, MutableLuminousFluxVector, LuminousFlux>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double LuminousFluxVector
     * @param unit LuminousFluxUnit; the unit of the new Relative Immutable Double LuminousFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLuminousFluxVector(final double[] values, final LuminousFluxUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double LuminousFluxVector
     * @param unit LuminousFluxUnit; the unit of the new Relative Immutable Double LuminousFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLuminousFluxVector(final List<Double> values, final LuminousFluxUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values LuminousFlux[]; the values of the entries in the new Relative Immutable Double LuminousFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLuminousFluxVector(final LuminousFlux[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values List&lt;LuminousFlux&gt;; the values of the entries in the new Relative Immutable Double LuminousFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLuminousFluxVector(final List<LuminousFlux> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values SortedMap&lt;Integer, LuminousFlux&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            LuminousFluxVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLuminousFluxVector(final SortedMap<Integer, LuminousFlux> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            LuminousFluxVector
     * @param unit LuminousFluxUnit; the unit of the new Relative Sparse Mutable Double LuminousFluxVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLuminousFluxVector(final SortedMap<Integer, Double> values, final LuminousFluxUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit LuminousFluxUnit; the unit
     */
    MutableLuminousFluxVector(final DoubleVectorData data, final LuminousFluxUnit unit)
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
    public final MutableLuminousFluxVector toDense()
    {
        return this.data.isDense() ? (MutableLuminousFluxVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLuminousFluxVector toSparse()
    {
        return this.data.isSparse() ? (MutableLuminousFluxVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
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
