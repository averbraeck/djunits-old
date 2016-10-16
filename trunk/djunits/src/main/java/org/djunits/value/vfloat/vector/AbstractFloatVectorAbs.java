package org.djunits.value.vfloat.vector;

import java.io.Serializable;
import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.AbstractFloatScalarAbs;

/**
 * Absolute Immutable typed vector.
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
abstract class AbstractFloatVectorAbs<U extends Unit<U>, A extends AbstractFloatVectorAbs<U, A, R, MA, S>, 
        R extends AbstractFloatVectorRel<U, R, ?, ?>, MA extends AbstractMutableFloatVectorAbs<U, A, R, MA, S>, 
        S extends AbstractFloatScalarAbs<U, S, ?>>
        extends AbstractFloatVector<U, A> implements Absolute, Serializable
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values float[]; the values of the entries in the new Absolute Immutable FloatVector
     * @param unit U; the unit of the new Absolute Immutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractFloatVectorAbs(final float[] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(unit, FloatVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values List; the values of the entries in the new Absolute Immutable FloatVector
     * @param unit U; the unit of the new Absolute Immutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractFloatVectorAbs(final List<Float> values, final U unit, final StorageType storageType) throws ValueException
    {
        super(unit, FloatVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values FloatScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Immutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractFloatVectorAbs(final S[] values, final StorageType storageType) throws ValueException
    {
        super(checkUnit(values), FloatVectorData.instantiate(values, storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values List; the values of the entries in the new Absolute Immutable FloatVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractFloatVectorAbs(final List<S> values, final StorageType storageType) throws ValueException
    {
        super(checkUnit(values), FloatVectorData.instantiateLD(values, storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values FloatScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable FloatVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractFloatVectorAbs(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(checkUnit(values), FloatVectorData.instantiateMD(values, length, storageType));
    }

    /**
     * Construct a new Absolute Immutable FloatVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable FloatVector
     * @param unit U; the unit of the new Absolute Sparse Mutable FloatVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractFloatVectorAbs(final SortedMap<Integer, Float> values, final U unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(unit, FloatVectorData.instantiate(values, length, unit.getScale(), storageType));
    }

    /**
     * Construct a new Relative Immutable FloatVector.
     * @param data an internal data object
     * @param unit the unit
     */
    AbstractFloatVectorAbs(final FloatVectorData data, final U unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this FloatVector. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MA; mutable version of this FloatVector
     */
    public MA mutable()
    {
        return instantiateMutableType(getData(), getUnit());
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

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the value
     * @param unit the unit
     * @return S the Immutable FloatScalar of the right type
     */
    protected abstract S instantiateScalar(final float value, final U unit);

    /** {@inheritDoc} */
    @Override
    public S get(final int index) throws ValueException
    {
        return instantiateScalar(getInUnit(index, getUnit()), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /**
     * Add a Relative value to this Absolute value for a vector or matrix. The addition is done value by value and the result is
     * stored in a new Absolute value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final A plus(final R rel) throws ValueException
    {
        return instantiateTypeAbs(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Absolute value for a vector or matrix. The subtraction is done value by value and the
     * result is stored in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public A minus(final R rel) throws ValueException
    {
        return instantiateTypeAbs(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Subtract an Absolute value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * the result is stored in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix,
     * otherwise the result is a dense vector or matrix.
     * @param abs the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public R minus(final A abs) throws ValueException
    {
        return instantiateTypeRel(this.getData().minus(abs.getData()), getUnit());
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a FloatVector, and return the Unit.
     * @param dsArray the array to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar type
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>, S extends AbstractFloatScalarAbs<U, S, ?>> U checkUnit(final S[] dsArray) throws ValueException
    {
        if (dsArray != null && dsArray.length > 0)
        {
            return dsArray[0].getUnit();
        }
        throw new ValueException("Cannot create a FloatVector or MutableFloatVector from a null or empty array of FloatScalar");
    }

    /**
     * Check that a provided list can be used to create some descendant of a FloatVector, and return the Unit.
     * @param dsList the list to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar in the list
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>, S extends AbstractFloatScalarAbs<U, S, ?>> U checkUnit(final List<S> dsList)
            throws ValueException
    {
        if (dsList != null && dsList.size() > 0)
        {
            return dsList.get(0).getUnit();
        }
        throw new ValueException("Cannot create a FloatVector or MutableFloatVector from a null or empty list of FloatScalar");
    }

    /**
     * Check that a provided Map can be used to create some descendant of a FloatVector.
     * @param dsMap the provided map
     * @param <U> Unit; the unit of the FloatScalar list
     * @param <S> the scalar in the list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>, S extends AbstractFloatScalarAbs<U, S, ?>> U checkUnit(final SortedMap<Integer, S> dsMap)
            throws ValueException
    {
        if (dsMap != null && dsMap.size() > 0)
        {
            return dsMap.get(dsMap.firstKey()).getUnit();
        }
        throw new ValueException("Cannot create a FloatVector or MutableFloatVector from a null or empty Map of FloatScalar");
    }
}
