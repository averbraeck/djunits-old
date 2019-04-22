package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Mutable Relative Float%TypeRel% Vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloat%TypeRel%Vector extends AbstractMutableFloatVectorRel<%TypeUnit%, Float%TypeRel%Vector, MutableFloat%TypeRel%Vector, Float%TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values float[]; the values of the entries in the new Relative Mutable Float%TypeRel%Vector
     * @param unit U; the unit of the new Relative Mutable Float%TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeRel%Vector(final float[] values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values List; the values of the entries in the new Relative Mutable Float%TypeRel%Vector
     * @param unit U; the unit of the new Relative Mutable Float%TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeRel%Vector(final List<Float> values, final %TypeUnit% unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable Float%TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeRel%Vector(final Float%TypeRel%[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values List; the values of the entries in the new Relative Mutable Float%TypeRel%Vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeRel%Vector(final List<Float%TypeRel%> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float%TypeRel%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%TypeRel%Vector(final SortedMap<Integer, Float%TypeRel%> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float%TypeRel%Vector
     * @param unit U; the unit of the new Relative Sparse Mutable Float%TypeRel%Vector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%TypeRel%Vector(final SortedMap<Integer, Float> values, final %TypeUnit% unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable Float%TypeRel%Vector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloat%TypeRel%Vector(final FloatVectorData data, final %TypeUnit% unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel%Vector instantiateType(final FloatVectorData dvd, final %TypeUnit% unit)
    {
        return new Float%TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%TypeRel%Vector instantiateMutableType(final FloatVectorData dvd, final %TypeUnit% unit)
    {
        return new MutableFloat%TypeRel%Vector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel% instantiateScalar(final float value, final %TypeUnit% unit)
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
     * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative %TypeRel% vector.
     */
    public final MutableFloat%TypeAbs%Vector toAbs()
    {
        return new MutableFloat%TypeAbs%Vector(getData(), getUnit());
    }
    
%FORMULAS%%TypeRel%%
}