package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Relative %TypeRel% Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %TypeRel%Vector extends AbstractDoubleVectorRel<%TypeRelUnit%, %TypeRel%Vector, Mutable%TypeRel%Vector, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double %TypeRel%Vector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double %TypeRel%Vector
     * @param unit %TypeRelUnit%; the unit of the new Relative Immutable Double %TypeRel%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %TypeRel%Vector(final double[] values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Vector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double %TypeRel%Vector
     * @param unit %TypeRelUnit%; the unit of the new Relative Immutable Double %TypeRel%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %TypeRel%Vector(final List<Double> values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Vector.
     * @param values %TypeRel%[]; the values of the entries in the new Relative Immutable Double %TypeRel%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %TypeRel%Vector(final %TypeRel%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Vector.
     * @param values List&lt;%TypeRel%&gt;; the values of the entries in the new Relative Immutable Double %TypeRel%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %TypeRel%Vector(final List<%TypeRel%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Vector.
     * @param values SortedMap&lt;Integer, %TypeRel%&gt;; the values of the entries in the new Relative Sparse Mutable Double %TypeRel%Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %TypeRel%Vector(final SortedMap<Integer, %TypeRel%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Vector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double %TypeRel%Vector
     * @param unit %TypeRelUnit%; the unit of the new Relative Sparse Mutable Double %TypeRel%Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %TypeRel%Vector(final SortedMap<Integer, Double> values, final %TypeRelUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %TypeRel%Vector.
     * @param data DoubleVectorData; an internal data object
     * @param unit %TypeRelUnit%; the unit
     */
    %TypeRel%Vector(final DoubleVectorData data, final %TypeRelUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel%Vector instantiateType(final DoubleVectorData dvd, final %TypeRelUnit% unit)
    {
        return new %TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%TypeRel%Vector
        instantiateMutableType(final DoubleVectorData dvd, final %TypeRelUnit% unit)
    {
        return new Mutable%TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel% instantiateScalar(final double value, final %TypeRelUnit% unit)
    {
        return new %TypeRel%(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final %TypeRel%Vector toDense()
    {
        return this.data.isDense() ? (%TypeRel%Vector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeRel%Vector toSparse()
    {
        return this.data.isSparse() ? (%TypeRel%Vector) this : instantiateType(this.data.toSparse(), getUnit());
    }
        
    /**
     * Return an array of %TypeRel% Scalars from this vector.
     * @return %TypeRel%[]; an array of %TypeRel% Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public %TypeRel%[] toArray()
    {
        %TypeRel%[] array = new %TypeRel%[size()];
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
