package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.*;

/**
 * Mutable Relative %TypeRel% Vector.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Mutable%TypeRel%Vector extends AbstractMutableDoubleVectorRel<%TypeRelUnit%, %TypeRel%Vector, Mutable%TypeRel%Vector, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable Double %TypeRel%Vector.
     * @param values double[]; the values of the entries in the new Relative Mutable Double %TypeRel%Vector
     * @param unit U; the unit of the new Relative Mutable Double %TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Mutable%TypeRel%Vector(final double[] values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double %TypeRel%Vector.
     * @param values List; the values of the entries in the new Relative Mutable Double %TypeRel%Vector
     * @param unit U; the unit of the new Relative Mutable Double %TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Mutable%TypeRel%Vector(final List<Double> values, final %TypeRelUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double %TypeRel%Vector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable Double %TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Mutable%TypeRel%Vector(final %TypeRel%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double %TypeRel%Vector.
     * @param values List; the values of the entries in the new Relative Mutable Double %TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Mutable%TypeRel%Vector(final List<%TypeRel%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double %TypeRel%Vector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double %TypeRel%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Mutable%TypeRel%Vector(final SortedMap<Integer, %TypeRel%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Double %TypeRel%Vector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double %TypeRel%Vector
     * @param unit U; the unit of the new Relative Sparse Mutable Double %TypeRel%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Mutable%TypeRel%Vector(final SortedMap<Integer, Double> values, final %TypeRelUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Double %TypeRel%Vector.
     * @param data an internal data object
     * @param unit the unit
     */
    Mutable%TypeRel%Vector(final DoubleVectorData data, final %TypeRelUnit% unit)
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
    protected final Mutable%TypeRel%Vector instantiateMutableType(final DoubleVectorData dvd, final %TypeRelUnit% unit)
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
    public final Mutable%TypeRel%Vector toDense()
    {
        return this.data.isDense() ? (Mutable%TypeRel%Vector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%TypeRel%Vector toSparse()
    {
        return this.data.isSparse() ? (Mutable%TypeRel%Vector) this : instantiateMutableType(this.data.toSparse(), getUnit());
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
