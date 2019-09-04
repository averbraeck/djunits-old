package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Mutable Float %Type%Vector, a vector of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>

 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloat%Type%Vector extends
    AbstractMutableFloatVectorRel<%Type%Unit, Float%Type%Vector, MutableFloat%Type%Vector, Float%Type%> %DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float %Type%Vector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float %Type%Vector
     * @param unit U; the unit of the new Relative Immutable Float %Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%Type%Vector(final float[] values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float %Type%Vector.
     * @param values List; the values of the entries in the new Relative Immutable Float %Type%Vector
     * @param unit U; the unit of the new Relative Immutable Float %Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%Type%Vector(final List<Float> values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float %Type%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            %Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%Type%Vector(final Float%Type%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float %Type%Vector.
     * @param values List; the values of the entries in the new Relative Immutable Float %Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%Type%Vector(final List<Float%Type%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float %Type%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            %Type%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%Type%Vector(final SortedMap<Integer, Float%Type%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float %Type%Vector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float %Type%Vector
     * @param unit U; the unit of the new Relative Sparse Mutable Float %Type%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%Type%Vector(final SortedMap<Integer, Float> values, final %Type%Unit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloat%Type%Vector(final FloatVectorData data, final %Type%Unit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%Type%Vector instantiateType(final FloatVectorData dvd, final %Type%Unit unit)
    {
        return new Float%Type%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%Type%Vector instantiateMutableType(final FloatVectorData dvd, final %Type%Unit unit)
    {
        return new MutableFloat%Type%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%Type% instantiateScalar(final float value, final %Type%Unit unit)
    {
        return new Float%Type%(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector toDense()
    {
        return this.data.isDense() ? (MutableFloat%Type%Vector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Vector toSparse()
    {
        return this.data.isSparse() ? (MutableFloat%Type%Vector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Float%Type% Scalars from this vector.
     * @return Float%Type%[]; an array of Float%Type% Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Float%Type%[] toArray()
    {
        Float%Type%[] array = new Float%Type%[size()];
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

%FORMULAS%%Type%%

}


