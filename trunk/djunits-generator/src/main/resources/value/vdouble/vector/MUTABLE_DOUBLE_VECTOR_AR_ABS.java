package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.*;

/**
 * Mutable Absolute %TypeAbs% Vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Mutable%TypeAbs%Vector
        extends
        MutableTypedDoubleVectorAbs<%TypeUnit%, %TypeAbs%Vector, %TypeRel%Vector, Mutable%TypeAbs%Vector, %TypeAbs%>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Vector.
     * @param values double[]; the values of the entries in the new Absolute Mutable Double %TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Mutable Double %TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Mutable%TypeAbs%Vector(final double[] values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Vector.
     * @param values List; the values of the entries in the new Absolute Mutable Double %TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Mutable Double %TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Mutable%TypeAbs%Vector(final List<Double> values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Vector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable Double %TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Mutable%TypeAbs%Vector(final %TypeAbs%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Vector.
     * @param values List; the values of the entries in the new Absolute Mutable Double %TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Mutable%TypeAbs%Vector(final List<%TypeAbs%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Vector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable Double %TypeAbs%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Mutable%TypeAbs%Vector(final SortedMap<Integer, %TypeAbs%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Vector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable Double %TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Sparse Mutable Double %TypeAbs%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Mutable%TypeAbs%Vector(final SortedMap<Integer, Double> values, final %TypeUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double %TypeAbs%Vector.
     * @param data an internal data object
     * @param unit the unit
     */
    Mutable%TypeAbs%Vector(final DoubleVectorData data, final %TypeUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeAbs%Vector instantiateTypeAbs(final DoubleVectorData dvd, final %TypeUnit% unit)
    {
        return new %TypeAbs%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel%Vector instantiateTypeRel(final DoubleVectorData dvd, final %TypeUnit% unit)
    {
        return new %TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%TypeAbs%Vector
        instantiateMutableType(final DoubleVectorData dvd, final %TypeUnit% unit)
    {
        return new Mutable%TypeAbs%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeAbs% get(final int index) throws ValueException
    {
        return new %TypeAbs%(getInUnit(index, getUnit()), getUnit());
    }
    
    /**
     * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute %TypeAbs% vector.
     */
    public final Mutable%TypeRel%Vector toRel()
    {
        return new Mutable%TypeRel%Vector(getData(), getUnit());
    }
    
%FORMULAS%%TypeAbs%%
}
