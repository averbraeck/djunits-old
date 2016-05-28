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
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Mutable%TypeRel%Vector extends MutableTypedDoubleVectorRel<%TypeUnit%, %TypeRel%Vector, Mutable%TypeRel%Vector, %TypeRel%>
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
    public Mutable%TypeRel%Vector(final double[] values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
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
    public Mutable%TypeRel%Vector(final List<Double> values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
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
    public Mutable%TypeRel%Vector(final SortedMap<Integer, Double> values, final %TypeUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Double %TypeRel%Vector.
     * @param data an internal data object
     * @param unit the unit
     */
    Mutable%TypeRel%Vector(final DoubleVectorData data, final %TypeUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %TypeRel%Vector instantiateType(final DoubleVectorData dvd, final %TypeUnit% unit)
    {
        return new %TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%TypeRel%Vector
        instantiateMutableType(final DoubleVectorData dvd, final %TypeUnit% unit)
    {
        return new Mutable%TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeRel% get(final int index) throws ValueException
    {
        return new %TypeRel%(getInUnit(index, getUnit()), getUnit());
    }
    
    /**
     * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative %TypeRel% vector.
     */
    public final Mutable%TypeAbs%Vector toAbs()
    {
        return new Mutable%TypeAbs%Vector(getData(), getUnit());
    }
        
%FORMULAS%%TypeRel%%
}
