package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Absolute Mutable typed Vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <A> the absolute vector type
 * @param <R> the relative vector type
 * @param <MA> the mutable absolute vector type
 * @param <S> the absolute scalar type
 */
abstract class MutableTypedFloatVectorAbs<U extends Unit<U>, A extends TypedFloatVectorAbs<U, A, R, MA, S>, R extends TypedFloatVectorRel<U, R, ?, ?>, MA extends MutableTypedFloatVectorAbs<U, A, R, MA, S>, S extends FloatScalar.Abs<U>>
        extends MutableFloatVector.Abs<U>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values float[]; the values of the entries in the new Relative Mutable FloatVector
     * @param unit U; the unit of the new Relative Mutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedFloatVectorAbs(final float[] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values List; the values of the entries in the new Relative Mutable FloatVector
     * @param unit U; the unit of the new Relative Mutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedFloatVectorAbs(final List<Float> values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedFloatVectorAbs(final S[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values List; the values of the entries in the new Relative Mutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedFloatVectorAbs(final List<S> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable FloatVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedFloatVectorAbs(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedFloatVectorAbs(final SortedMap<Integer, Float> values, final U unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatVector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableTypedFloatVectorAbs(final FloatVectorData data, final U unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MA mutable()
    {
        setCopyOnWrite(true);
        final MA result = instantiateMutableType(getData(), getUnit());
        result.setCopyOnWrite(true);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public A immutable()
    {
        setCopyOnWrite(true);
        return instantiateTypeAbs(getData(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA toDense()
    {
        return this.data.isDense() ? (MA) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA toSparse()
    {
        return this.data.isSparse() ? (MA) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Construct a new Absolute Immutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatVector of the right type
     */
    protected abstract A instantiateTypeAbs(final FloatVectorData dvd, final U unit);

    /**
     * Construct a new Relative Immutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatVector of the right type
     */
    protected abstract R instantiateTypeRel(final FloatVectorData dvd, final U unit);

    /**
     * Construct a new Absolute Mutable FloatVector of the right type. Each extending class must implement this method.
     * @param dvd an internal data object
     * @param unit the unit
     * @return M the Mutable FloatVector of the right type
     */
    protected abstract MA instantiateMutableType(final FloatVectorData dvd, final U unit);

    /** {@inheritDoc} */
    @Override
    public abstract S get(final int index) throws ValueException;

    /** {@inheritDoc} */
    @Override
    public final MA copy()
    {
        return mutable();
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA ceil()
    {
        return (MA) super.ceil();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA floor()
    {
        return (MA) super.floor();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA rint()
    {
        return (MA) super.rint();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA round()
    {
        return (MA) super.round();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA multiplyBy(final float constant)
    {
        return (MA) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA divideBy(final float constant)
    {
        return (MA) super.divideBy(constant);
    }

}
