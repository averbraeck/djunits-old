package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double %Type%Vector, a vector of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class %Type%Vector extends
    AbstractDoubleVectorRel<%Type%Unit, %Type%Vector, Mutable%Type%Vector, %Type%>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double %Type%Vector
     * @param unit %Type%Unit; the unit of the new Relative Immutable Double %Type%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %Type%Vector(final double[] values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double %Type%Vector
     * @param unit %Type%Unit; the unit of the new Relative Immutable Double %Type%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %Type%Vector(final List<Double> values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values %Type%[]; the values of the entries in the new Relative Immutable Double %Type%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %Type%Vector(final %Type%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values List&lt;%Type%&gt;; the values of the entries in the new Relative Immutable Double %Type%Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %Type%Vector(final List<%Type%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values SortedMap&lt;Integer, %Type%&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            %Type%Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %Type%Vector(final SortedMap<Integer, %Type%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double %Type%Vector
     * @param unit %Type%Unit; the unit of the new Relative Sparse Mutable Double %Type%Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %Type%Vector(final SortedMap<Integer, Double> values, final %Type%Unit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    %Type%Vector(final DoubleVectorData data, final %Type%Unit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %Type%Vector instantiateType(final DoubleVectorData dvd, final %Type%Unit unit)
    {
        return new %Type%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%Type%Vector instantiateMutableType(final DoubleVectorData dvd, final %Type%Unit unit)
    {
        return new Mutable%Type%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %Type% instantiateScalar(final double value, final %Type%Unit unit)
    {
        return new %Type%(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final %Type%Vector toDense()
    {
        return this.data.isDense() ? (%Type%Vector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %Type%Vector toSparse()
    {
        return this.data.isSparse() ? (%Type%Vector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of %Type% Scalars from this vector.
     * @return %Type%[]; an array of %Type% Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public %Type%[] toArray()
    {
        %Type%[] array = new %Type%[size()];
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

