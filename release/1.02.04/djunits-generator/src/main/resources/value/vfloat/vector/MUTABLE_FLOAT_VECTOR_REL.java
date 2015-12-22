package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Mutable Float%Type%Vector, a vector of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloat%Type%Vector extends
    MutableTypedFloatVectorRel<%Type%Unit, Float%Type%Vector, MutableFloat%Type%Vector, Float%Type%>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float%Type%Vector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float%Type%Vector
     * @param unit U; the unit of the new Relative Immutable Float%Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%Type%Vector(final float[] values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%Type%Vector.
     * @param values List; the values of the entries in the new Relative Immutable Float%Type%Vector
     * @param unit U; the unit of the new Relative Immutable Float%Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%Type%Vector(final List<Float> values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%Type%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            Float%Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%Type%Vector(final Float%Type%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%Type%Vector.
     * @param values List; the values of the entries in the new Relative Immutable Float%Type%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%Type%Vector(final List<Float%Type%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%Type%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            Float%Type%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%Type%Vector(final SortedMap<Integer, Float%Type%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%Type%Vector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float%Type%Vector
     * @param unit U; the unit of the new Relative Sparse Mutable Float%Type%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%Type%Vector(final SortedMap<Integer, Float> values, final %Type%Unit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }
    
    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloat%Type%Vector(final FloatVectorData data, final %Type%Unit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%Type%Vector instantiateType(final FloatVectorData dvd, final %Type%Unit unit)
    {
        return new Float%Type%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%Type%Vector instantiateMutableType(final FloatVectorData dvd, final %Type%Unit unit)
    {
        return new MutableFloat%Type%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Float%Type% get(final int index) throws ValueException
    {
        return new Float%Type%(getInUnit(index, getUnit()), getUnit());
    }

%FORMULAS%%Type%.Rel%

}

