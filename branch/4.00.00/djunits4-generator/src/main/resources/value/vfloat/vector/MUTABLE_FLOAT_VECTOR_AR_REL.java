package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable Relative Float%TypeRel% Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloat%TypeRel%Vector extends AbstractMutableFloatVectorRel<%TypeRelUnit%, Float%TypeRel%Vector, MutableFloat%TypeRel%Vector, Float%TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values float[]; the values of the entries in the new Relative Mutable Float%TypeRel%Vector
     * @param unit %TypeRelUnit%; the unit of the new Relative Mutable Float%TypeRel%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeRel%Vector(final float[] values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Mutable Float%TypeRel%Vector
     * @param unit %TypeRelUnit%; the unit of the new Relative Mutable Float%TypeRel%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeRel%Vector(final List<Float> values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values Float%TypeRel%[]; the values of the entries in the new Relative Mutable Float%TypeRel%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeRel%Vector(final Float%TypeRel%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values List&lt;Float%TypeRel%&gt;; the values of the entries in the new Relative Mutable Float%TypeRel%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeRel%Vector(final List<Float%TypeRel%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values SortedMap&lt;Integer, Float%TypeRel%&gt;; the values of the entries in the new Relative Sparse Mutable Float%TypeRel%Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeRel%Vector(final SortedMap<Integer, Float%TypeRel%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float%TypeRel%Vector
     * @param unit %TypeRelUnit%; the unit of the new Relative Sparse Mutable Float%TypeRel%Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeRel%Vector(final SortedMap<Integer, Float> values, final %TypeRelUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloat%TypeRel%Vector(final FloatVectorData data, final %TypeRelUnit% unit)
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
    protected final MutableFloat%TypeRel%Vector instantiateMutableType(final FloatVectorData dvd, final %TypeRelUnit% unit)
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
    public final MutableFloat%TypeRel%Vector toDense()
    {
        return this.data.isDense() ? (MutableFloat%TypeRel%Vector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%TypeRel%Vector toSparse()
    {
        return this.data.isSparse() ? (MutableFloat%TypeRel%Vector) this : instantiateMutableType(this.data.toSparse(), getUnit());
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
