package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float FloatMagneticFluxVector, a vector of values with a MagneticFluxUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatMagneticFluxVector extends
    AbstractFloatVectorRel<MagneticFluxUnit, FloatMagneticFluxVector, MutableFloatMagneticFluxVector, FloatMagneticFlux>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FloatMagneticFluxVector
     * @param unit U; the unit of the new Relative Immutable Float FloatMagneticFluxVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMagneticFluxVector(final float[] values, final MagneticFluxUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatMagneticFluxVector
     * @param unit U; the unit of the new Relative Immutable Float FloatMagneticFluxVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMagneticFluxVector(final List<Float> values, final MagneticFluxUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatMagneticFluxVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMagneticFluxVector(final FloatMagneticFlux[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values List; the values of the entries in the new Relative Immutable Float FloatMagneticFluxVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMagneticFluxVector(final List<FloatMagneticFlux> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatMagneticFluxVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMagneticFluxVector(final SortedMap<Integer, FloatMagneticFlux> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FloatMagneticFluxVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float FloatMagneticFluxVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float FloatMagneticFluxVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMagneticFluxVector(final SortedMap<Integer, Float> values, final MagneticFluxUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatMagneticFluxVector(final FloatVectorData data, final MagneticFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFluxVector instantiateType(final FloatVectorData dvd, final MagneticFluxUnit unit)
    {
        return new FloatMagneticFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMagneticFluxVector instantiateMutableType(final FloatVectorData dvd, final MagneticFluxUnit unit)
    {
        return new MutableFloatMagneticFluxVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFlux instantiateScalar(final float value, final MagneticFluxUnit unit)
    {
        return new FloatMagneticFlux(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxVector toDense()
    {
        return this.data.isDense() ? (FloatMagneticFluxVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxVector toSparse()
    {
        return this.data.isSparse() ? (FloatMagneticFluxVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of FloatMagneticFlux Scalars from this vector.
     * @return FloatMagneticFlux[]; an array of FloatMagneticFlux Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatMagneticFlux[] toArray()
    {
        FloatMagneticFlux[] array = new FloatMagneticFlux[size()];
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

