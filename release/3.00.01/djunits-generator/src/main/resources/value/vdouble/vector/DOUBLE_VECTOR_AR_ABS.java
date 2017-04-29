package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.*;

/**
 * Immutable Absolute %TypeAbs% Vector.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class %TypeAbs%Vector extends
    AbstractDoubleVectorAbs<%TypeAbsUnit%, %TypeRelUnit%, %TypeAbs%Vector, %TypeRel%Vector, Mutable%TypeAbs%Vector, %TypeAbs%>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double %TypeAbs%Vector.
     * @param values double[]; the values of the entries in the new Absolute Immutable Double %TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Immutable Double %TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %TypeAbs%Vector(final double[] values, final %TypeAbsUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double %TypeAbs%Vector.
     * @param values List; the values of the entries in the new Absolute Immutable Double %TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Immutable Double %TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %TypeAbs%Vector(final List<Double> values, final %TypeAbsUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double %TypeAbs%Vector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Immutable Double %TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %TypeAbs%Vector(final %TypeAbs%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double %TypeAbs%Vector.
     * @param values List; the values of the entries in the new Absolute Immutable Double %TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %TypeAbs%Vector(final List<%TypeAbs%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double %TypeAbs%Vector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double %TypeAbs%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public %TypeAbs%Vector(final SortedMap<Integer, %TypeAbs%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double %TypeAbs%Vector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double %TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Sparse Mutable Double %TypeAbs%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public %TypeAbs%Vector(final SortedMap<Integer, Double> values, final %TypeAbsUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double %TypeAbs%Vector.
     * @param data an internal data object
     * @param unit the unit
     */
    %TypeAbs%Vector(final DoubleVectorData data, final %TypeAbsUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeAbs%Vector instantiateTypeAbs(final DoubleVectorData dvd, final %TypeAbsUnit% unit)
    {
        return new %TypeAbs%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel%Vector instantiateTypeRel(final DoubleVectorData dvd, final %TypeRelUnit% unit)
    {
        return new %TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%TypeAbs%Vector
        instantiateMutableType(final DoubleVectorData dvd, final %TypeAbsUnit% unit)
    {
        return new Mutable%TypeAbs%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeAbs% instantiateScalar(final double value, final %TypeAbsUnit% unit)
    {
        return new %TypeAbs%(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final %TypeAbs%Vector toDense()
    {
        return this.data.isDense() ? (%TypeAbs%Vector) this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeAbs%Vector toSparse()
    {
        return this.data.isSparse() ? (%TypeAbs%Vector) this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }
    
%FORMULAS%%TypeAbs%%
}
