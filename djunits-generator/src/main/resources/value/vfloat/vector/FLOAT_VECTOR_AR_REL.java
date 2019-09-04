package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Relative Float%TypeRel% Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>

 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class Float%TypeRel%Vector extends AbstractFloatVectorRel<%TypeRelUnit%, Float%TypeRel%Vector, MutableFloat%TypeRel%Vector, Float%TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Float%TypeRel%Vector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float%TypeRel%Vector
     * @param unit U; the unit of the new Relative Immutable Float%TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Float%TypeRel%Vector(final float[] values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Vector.
     * @param values List; the values of the entries in the new Relative Immutable Float%TypeRel%Vector
     * @param unit U; the unit of the new Relative Immutable Float%TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Float%TypeRel%Vector(final List<Float> values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float%TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Float%TypeRel%Vector(final Float%TypeRel%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Vector.
     * @param values List; the values of the entries in the new Relative Immutable Float%TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Float%TypeRel%Vector(final List<Float%TypeRel%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float%TypeRel%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Float%TypeRel%Vector(final SortedMap<Integer, Float%TypeRel%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Vector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float%TypeRel%Vector
     * @param unit U; the unit of the new Relative Sparse Mutable Float%TypeRel%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Float%TypeRel%Vector(final SortedMap<Integer, Float> values, final %TypeRelUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%TypeRel%Vector.
     * @param data an internal data object
     * @param unit the unit
     */
    Float%TypeRel%Vector(final FloatVectorData data, final %TypeRelUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel%Vector instantiateType(final FloatVectorData dvd, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%TypeRel%Vector
        instantiateMutableType(final FloatVectorData dvd, final %TypeRelUnit% unit)
    {
        return new MutableFloat%TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel% instantiateScalar(final float value, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final Float%TypeRel%Vector toDense()
    {
        return this.data.isDense() ? (Float%TypeRel%Vector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TypeRel%Vector toSparse()
    {
        return this.data.isSparse() ? (Float%TypeRel%Vector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of Float%TypeRel% Scalars from this vector.
     * @return Float%TypeRel%[]; an array of Float%TypeRel% Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Float%TypeRel%[] toArray()
    {
        Float%TypeRel%[] array = new Float%TypeRel%[size()];
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

%FORMULAS%%TypeRel%%
}
