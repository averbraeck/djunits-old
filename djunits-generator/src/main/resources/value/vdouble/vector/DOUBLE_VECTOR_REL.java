package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.*;

/**
 * Immutable Double %Type%Vector, a vector of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class %Type%Vector extends
    AbstractDoubleVectorRel<%Type%Unit, %Type%Vector, Mutable%Type%Vector, %Type%>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double %Type%Vector
     * @param unit U; the unit of the new Relative Immutable Double %Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %Type%Vector(final double[] values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values List; the values of the entries in the new Relative Immutable Double %Type%Vector
     * @param unit U; the unit of the new Relative Immutable Double %Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %Type%Vector(final List<Double> values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            %Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %Type%Vector(final %Type%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values List; the values of the entries in the new Relative Immutable Double %Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %Type%Vector(final List<%Type%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            %Type%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %Type%Vector(final SortedMap<Integer, %Type%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Vector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double %Type%Vector
     * @param unit U; the unit of the new Relative Sparse Mutable Double %Type%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %Type%Vector(final SortedMap<Integer, Double> values, final %Type%Unit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
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

