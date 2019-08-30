package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatLuminousFlux;

/**
 * Mutable Float LuminousFluxVector, a vector of values with a LuminousFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatLuminousFluxVector extends AbstractMutableFloatVectorRel<LuminousFluxUnit, FloatLuminousFluxVector,
        MutableFloatLuminousFluxVector, FloatLuminousFlux>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float LuminousFluxVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float LuminousFluxVector
     * @param unit LuminousFluxUnit; the unit of the new Relative Immutable Float LuminousFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLuminousFluxVector(final float[] values, final LuminousFluxUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LuminousFluxVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float LuminousFluxVector
     * @param unit LuminousFluxUnit; the unit of the new Relative Immutable Float LuminousFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLuminousFluxVector(final List<Float> values, final LuminousFluxUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LuminousFluxVector.
     * @param values FloatLuminousFlux[]; the values of the entries in the new Relative Immutable Float LuminousFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLuminousFluxVector(final FloatLuminousFlux[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LuminousFluxVector.
     * @param values List&lt;FloatLuminousFlux&gt;; the values of the entries in the new Relative Immutable Float
     *            LuminousFluxVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLuminousFluxVector(final List<FloatLuminousFlux> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LuminousFluxVector.
     * @param values SortedMap&lt;Integer, FloatLuminousFlux&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float LuminousFluxVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLuminousFluxVector(final SortedMap<Integer, FloatLuminousFlux> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float LuminousFluxVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            LuminousFluxVector
     * @param unit LuminousFluxUnit; the unit of the new Relative Sparse Mutable Float LuminousFluxVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLuminousFluxVector(final SortedMap<Integer, Float> values, final LuminousFluxUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit LuminousFluxUnit; the unit
     */
    MutableFloatLuminousFluxVector(final FloatVectorData data, final LuminousFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLuminousFluxVector instantiateType(final FloatVectorData dvd, final LuminousFluxUnit unit)
    {
        return new FloatLuminousFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLuminousFluxVector instantiateMutableType(final FloatVectorData dvd,
            final LuminousFluxUnit unit)
    {
        return new MutableFloatLuminousFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLuminousFlux instantiateScalar(final float value, final LuminousFluxUnit unit)
    {
        return new FloatLuminousFlux(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLuminousFluxVector toDense()
    {
        return this.data.isDense() ? (MutableFloatLuminousFluxVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLuminousFluxVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatLuminousFluxVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatLuminousFlux Scalars from this vector.
     * @return FloatLuminousFlux[]; an array of FloatLuminousFlux Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatLuminousFlux[] toArray()
    {
        FloatLuminousFlux[] array = new FloatLuminousFlux[size()];
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
