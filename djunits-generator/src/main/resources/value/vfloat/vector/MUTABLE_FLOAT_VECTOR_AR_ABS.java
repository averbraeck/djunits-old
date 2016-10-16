package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Mutable Absolute Float%TypeAbs% Vector a vector of values with a %TypeUnit%.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloat%TypeAbs%Vector
    extends
    AbstractMutableFloatVectorAbs<%TypeUnit%, Float%TypeAbs%Vector, Float%TypeRel%Vector, MutableFloat%TypeAbs%Vector, Float%TypeAbs%>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values float[]; the values of the entries in the new Absolute Mutable Float%TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Mutable Float%TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeAbs%Vector(final float[] values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values List; the values of the entries in the new Absolute Mutable Float%TypeAbs%Vector
     * @param unit U; the unit of the new Absolute Mutable Float%TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeAbs%Vector(final List<Float> values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Absolute Mutable Float%TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeAbs%Vector(final Float%TypeAbs%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param values List; the values of the entries in the new Absolute Mutable Float%TypeAbs%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
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
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
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
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeAbs%Vector(final SortedMap<Integer, Float> values, final %TypeUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Absolute Mutable Float%TypeAbs%Vector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloat%TypeAbs%Vector(final FloatVectorData data, final %TypeUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeAbs%Vector instantiateTypeAbs(final FloatVectorData dvd, final %TypeUnit% unit)
    {
        return new Float%TypeAbs%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel%Vector instantiateTypeRel(final FloatVectorData dvd, final %TypeUnit% unit)
    {
        return new Float%TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%TypeAbs%Vector instantiateMutableType(final FloatVectorData dvd, final %TypeUnit% unit)
    {
        return new MutableFloat%TypeAbs%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeAbs% instantiateScalar(final float value, final %TypeUnit% unit)
    {
        return new Float%TypeAbs%(value, unit);
    }
    
    /**
     * Create a dense version of this FloatVector.
     * @return the dense version of this FloatVector
     */
    public final MutableFloat%TypeAbs%Vector toDense()
    {
        return this.data.isDense() ? (MutableFloat%TypeAbs%Vector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /**
     * Create a sparse version of this FloatVector.
     * @return the sparse version of this FloatVector
     */
    public final MutableFloat%TypeAbs%Vector toSparse()
    {
        return this.data.isSparse() ? (MutableFloat%TypeAbs%Vector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Translate the absolute vector into a relative vector (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute %TypeAbs% vector.
     */
    public final MutableFloat%TypeRel%Vector toRel()
    {
        return new MutableFloat%TypeRel%Vector(getData(), getUnit());
    }
    
%FORMULAS%%TypeAbs%%
}
