package org.djunits4.value.vfloat.matrix;

import java.io.Serializable;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.FunctionsAbs;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.AbstractFloatScalarAbs;

/**
 * Absolute Immutable typed matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <AU> the absolute unit
 * @param <RU> the relative unit
 * @param <A> the absolute matrix type
 * @param <R> the relative matrix type
 * @param <MA> the mutable absolute matrix type
 * @param <S> the absolute scalar type
 */
abstract class AbstractFloatMatrixAbs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
        A extends AbstractFloatMatrixAbs<AU, RU, A, R, MA, S>, R extends AbstractFloatMatrixRel<RU, R, ?, ?>,
        MA extends AbstractMutableFloatMatrixAbs<AU, RU, A, R, MA, S>, S extends AbstractFloatScalarAbs<AU, S, RU, ?>> extends
        AbstractFloatMatrix<AU, A> implements FunctionsAbs<AU, RU, A, R>, FloatMatrixInterface<AU>, Absolute, Serializable
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Absolute Immutable FloatMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Immutable FloatMatrix
     * @param unit AU; the unit of the new Absolute Immutable FloatMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractFloatMatrixAbs(final float[][] values, final AU unit, final StorageType storageType) throws ValueException
    {
        super(unit, FloatMatrixData.instantiate(ensureRectangularAndNonEmpty(values), unit.getScale(), storageType));

    }

    /**
     * Construct a new Absolute Immutable FloatMatrix.
     * @param values S[][]; the values of the entries in the new Absolute Immutable FloatMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractFloatMatrixAbs(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(checkUnit(values), FloatMatrixData.instantiate(values, storageType));
    }

    /**
     * Construct a new Relative Immutable FloatMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit AU; the unit
     */
    AbstractFloatMatrixAbs(final FloatMatrixData data, final AU unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this FloatMatrix. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MA; mutable version of this FloatMatrix
     */
    public MA mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /**
     * Construct a new Absolute Immutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd FloatMatrixData; an internal data object
     * @param unit AU; the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract A instantiateTypeAbs(FloatMatrixData dmd, AU unit);

    /**
     * Construct a new Relative Immutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd FloatMatrixData; an internal data object
     * @param unit RU; the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract R instantiateTypeRel(FloatMatrixData dmd, RU unit);

    /**
     * Construct a new Absolute Mutable FloatMatrix of the right type. Each extending class must implement this method.
     * @param dmd FloatMatrixData; an internal data object
     * @param unit AU; the unit
     * @return M the Mutable FloatMatrix of the right type
     */
    protected abstract MA instantiateMutableType(FloatMatrixData dmd, AU unit);

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value float; the value
     * @param unit AU; the unit
     * @return S the Immutable FloatScalar of the right type
     */
    protected abstract S instantiateScalar(float value, AU unit);

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public final S get(final int row, final int column) throws ValueException
    {
        checkIndex(row, column);
        return instantiateScalar(getInUnit(row, column, getUnit()), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final A plus(final R rel) throws ValueException
    {
        return instantiateTypeAbs(this.getData().plus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final A minus(final R rel) throws ValueException
    {
        return instantiateTypeAbs(this.getData().minus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R minus(final A abs) throws ValueException
    {
        return instantiateTypeRel(this.getData().minus(abs.getData()), getUnit().getRelativeUnit());
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a FloatMatrix, and return the Unit.
     * @param dsArray S[][]; the array to check and get the unit for
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar type
     * @return the unit of the object
     * @throws ValueException when the array is null, has length equal to 0, or has first entry with length equal to 0
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractFloatScalarAbs<AU, S, RU, ?>> AU checkUnit(final S[][] dsArray) throws ValueException
    {
        ensureRectangularAndNonEmpty(dsArray);
        return dsArray[0][0].getUnit();
    }

    /**
     * Check that a 2D array of FloatScalar&lt;?&gt; is rectangular; i.e. all rows have the same length and is non empty.
     * @param values S[][]; the 2D array to check
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar type
     * @throws ValueException when values is not rectangular, or contains no data
     */
    protected static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractFloatScalarAbs<AU, S, RU, ?>> void ensureRectangularAndNonEmpty(final S[][] values)
                    throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("Cannot create a FloatVector or MutableFloatVector from an empty array of FloatScalar");
        }
        if (0 == values.length || 0 == values[0].length)
        {
            throw new ValueException("Creating FloatVector or MutableFloatVector: "
                    + "Cannot determine unit for FloatMatrix from an empty array of FloatScalar");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (values[0].length != values[row].length)
            {
                throw new ValueException("Creating FloatVector or MutableFloatVector: Lengths of rows are not all the same");
            }
        }
    }

}
