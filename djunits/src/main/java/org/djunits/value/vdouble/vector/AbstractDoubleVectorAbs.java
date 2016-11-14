package org.djunits.value.vdouble.vector;

import java.io.Serializable;
import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalarAbs;

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
abstract class AbstractDoubleVectorAbs<U extends Unit<U>, A extends AbstractDoubleVectorAbs<U, A, R, MA, S>, R extends AbstractDoubleVectorRel<U, R, ?, ?>, MA extends AbstractMutableDoubleVectorAbs<U, A, R, MA, S>, S extends AbstractDoubleScalarAbs<U, S, ?>>
        extends AbstractDoubleVector<U, A> implements Absolute, Serializable
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values double[]; the values of the entries in the new Absolute Immutable DoubleVector
     * @param unit U; the unit of the new Absolute Immutable DoubleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractDoubleVectorAbs(final double[] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(unit, DoubleVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values List; the values of the entries in the new Absolute Immutable DoubleVector
     * @param unit U; the unit of the new Absolute Immutable DoubleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractDoubleVectorAbs(final List<Double> values, final U unit, final StorageType storageType) throws ValueException
    {
        super(unit, DoubleVectorData.instantiate(values, unit.getScale(), storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Immutable DoubleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractDoubleVectorAbs(final S[] values, final StorageType storageType) throws ValueException
    {
        super(checkUnit(values), DoubleVectorData.instantiate(values, storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values List; the values of the entries in the new Absolute Immutable DoubleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractDoubleVectorAbs(final List<S> values, final StorageType storageType) throws ValueException
    {
        super(checkUnit(values), DoubleVectorData.instantiateLD(values, storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values DoubleScalar.Abs&lt;U&gt;[]; the values of the entries in the new Absolute Sparse Mutable DoubleVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractDoubleVectorAbs(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(checkUnit(values), DoubleVectorData.instantiateMD(values, length, storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleVector.
     * @param values Map; the map of indexes to values of the Absolute Sparse Mutable DoubleVector
     * @param unit U; the unit of the new Absolute Sparse Mutable DoubleVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractDoubleVectorAbs(final SortedMap<Integer, Double> values, final U unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(unit, DoubleVectorData.instantiate(values, length, unit.getScale(), storageType));
    }

    /**
     * Construct a new Relative Immutable DoubleVector.
     * @param data an internal data object
     * @param unit the unit
     */
    AbstractDoubleVectorAbs(final DoubleVectorData data, final U unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this DoubleVector. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MA; mutable version of this DoubleVector
     */
    @Override
    public MA mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /**
     * Construct a new Absolute Immutable DoubleVector of the right type. Each extending class must implement this method.
     * @param dvd an internal data object
     * @param unit the unit
     * @return M the Mutable DoubleVector of the right type
     */
    protected abstract A instantiateTypeAbs(final DoubleVectorData dvd, final U unit);

    /**
     * Construct a new Relative Immutable DoubleVector of the right type. Each extending class must implement this method.
     * @param dvd an internal data object
     * @param unit the unit
     * @return M the Mutable DoubleVector of the right type
     */
    protected abstract R instantiateTypeRel(final DoubleVectorData dvd, final U unit);

    /**
     * Construct a new Absolute Mutable DoubleVector of the right type. Each extending class must implement this method.
     * @param dvd an internal data object
     * @param unit the unit
     * @return M the Mutable DoubleVector of the right type
     */
    protected abstract MA instantiateMutableType(final DoubleVectorData dvd, final U unit);

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value the value
     * @param unit the unit
     * @return S the Immutable DoubleScalar of the right type
     */
    protected abstract S instantiateScalar(final double value, final U unit);

    /** {@inheritDoc} */
    @Override
    public final S get(final int index) throws ValueException
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
     * Check that a provided array can be used to create some descendant of a DoubleVector, and return the Unit.
     * @param dsArray the array to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar type
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>, S extends AbstractDoubleScalarAbs<U, S, ?>> U checkUnit(final S[] dsArray) throws ValueException
    {
        if (dsArray != null && dsArray.length > 0)
        {
            return dsArray[0].getUnit();
        }
        throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from a null or empty array of DoubleScalar");
    }

    /**
     * Check that a provided list can be used to create some descendant of a DoubleVector, and return the Unit.
     * @param dsList the list to check and get the unit for
     * @param <U> the unit
     * @param <S> the scalar in the list
     * @return the unit of the object
     * @throws ValueException when the array has length equal to 0
     */
    static <U extends Unit<U>, S extends AbstractDoubleScalarAbs<U, S, ?>> U checkUnit(final List<S> dsList)
            throws ValueException
    {
        if (dsList != null && dsList.size() > 0)
        {
            return dsList.get(0).getUnit();
        }
        throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from a null or empty list of DoubleScalar");
    }

    /**
     * Check that a provided Map can be used to create some descendant of a DoubleVector.
     * @param dsMap the provided map
     * @param <U> Unit; the unit of the DoubleScalar list
     * @param <S> the scalar in the list
     * @return List the provided list
     * @throws ValueException when the list has size equal to 0
     */
    static <U extends Unit<U>, S extends AbstractDoubleScalarAbs<U, S, ?>> U checkUnit(final SortedMap<Integer, S> dsMap)
            throws ValueException
    {
        if (dsMap != null && dsMap.size() > 0)
        {
            return dsMap.get(dsMap.firstKey()).getUnit();
        }
        throw new ValueException(
                "Cannot create a DoubleVector or MutableDoubleVector from a null or empty Map of DoubleScalar");
    }

}
