package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Absolute Float%TypeAbs% Vector a vector of values with a %TypeAbsUnit%.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloat%TypeAbs%Vector
    extends
    AbstractMutableFloatVectorAbs<%TypeAbsUnit%, %TypeRelUnit%, Float%TypeAbs%Vector, Float%TypeRel%Vector, MutableFloat%TypeAbs%Vector, Float%TypeAbs%>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values float[]; the values of the entries in the new Absolute Mutable Float%TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Mutable Float%TypeAbs%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeAbs%Vector(final float[] values, final %TypeAbsUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values List; the values of the entries in the new Absolute Mutable Float%TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Mutable Float%TypeAbs%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeAbs%Vector(final List<Float> values, final %TypeAbsUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable Float%TypeAbs%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeAbs%Vector(final Float%TypeAbs%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values List; the values of the entries in the new Absolute Mutable Float%TypeAbs%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeAbs%Vector(final List<Float%TypeAbs%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Float%TypeAbs%Vector
     * @param length the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeAbs%Vector(final SortedMap<Integer, Float%TypeAbs%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Float%TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Sparse Mutable Float%TypeAbs%Vector
     * @param length the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeAbs%Vector(final SortedMap<Integer, Float> values, final %TypeAbsUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloat%TypeAbs%Vector(final FloatVectorData data, final %TypeAbsUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeAbs%Vector instantiateTypeAbs(final FloatVectorData dvd, final %TypeAbsUnit% unit)
    {
        return new Float%TypeAbs%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel%Vector instantiateTypeRel(final FloatVectorData dvd, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%TypeAbs%Vector instantiateMutableType(final FloatVectorData dvd, final %TypeAbsUnit% unit)
    {
        return new MutableFloat%TypeAbs%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeAbs% instantiateScalar(final float value, final %TypeAbsUnit% unit)
    {
        return new Float%TypeAbs%(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MutableFloat%TypeAbs%Vector toDense()
    {
        return this.data.isDense() ? (MutableFloat%TypeAbs%Vector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%TypeAbs%Vector toSparse()
    {
        return this.data.isSparse() ? (MutableFloat%TypeAbs%Vector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }
    
    
    /**
     * Return an array of Float%TypeAbs% Scalars from this vector.
     * @return Float%TypeAbs%[]; an array of Float%TypeAbs% Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Float%TypeAbs%[] toArray()
    {
        Float%TypeAbs%[] array = new Float%TypeAbs%[size()];
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

%FORMULAS%%TypeAbs%%
}
