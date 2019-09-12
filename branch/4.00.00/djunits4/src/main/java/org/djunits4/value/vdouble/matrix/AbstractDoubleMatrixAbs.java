package org.djunits4.value.vdouble.matrix;

import java.io.Serializable;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.function.FunctionsAbsWithRel;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarAbs;

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
abstract class AbstractDoubleMatrixAbs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
        A extends AbstractDoubleMatrixAbs<AU, RU, A, R, MA, S>, R extends AbstractDoubleMatrixRel<RU, R, ?, ?>,
        MA extends AbstractMutableDoubleMatrixAbs<AU, RU, A, R, MA, S>, S extends AbstractDoubleScalarAbs<AU, S, RU, ?>>
        extends AbstractDoubleMatrix<AU, A> implements FunctionsAbsWithRel<AU, RU, A, R>, Absolute, Serializable
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Absolute Immutable DoubleMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Immutable DoubleMatrix
     * @param unit AU; the unit of the new Absolute Immutable DoubleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractDoubleMatrixAbs(final double[][] values, final AU unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(unit, DoubleMatrixData.instantiate(ensureRectangularAndNonEmpty(values), unit.getScale(), storageType));
    }

    /**
     * Construct a new Absolute Immutable DoubleMatrix.
     * @param values S[][]; the values of the entries in the new Absolute Immutable DoubleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractDoubleMatrixAbs(final S[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(checkUnit(values), DoubleMatrixData.instantiate(values, storageType));
    }

    /**
     * Construct a new Relative Immutable DoubleMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit AU; the unit
     */
    AbstractDoubleMatrixAbs(final DoubleMatrixData data, final AU unit)
    {
        super(unit, data.copy());
    }

    /**
     * Create a mutable version of this DoubleMatrix. <br>
     * The mutable version is created with a shallow copy of the data and the internal copyOnWrite flag set. The first operation
     * in the mutable version that modifies the data shall trigger a deep copy of the data.
     * @return MA; mutable version of this DoubleMatrix
     */
    public MA mutable()
    {
        return instantiateMutableType(getData(), getUnit());
    }

    /**
     * Construct a new Absolute Immutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd DoubleMatrixData; an internal data object
     * @param unit AU; the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract A instantiateTypeAbs(DoubleMatrixData dmd, AU unit);

    /**
     * Construct a new Relative Immutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd DoubleMatrixData; an internal data object
     * @param unit RU; the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract R instantiateTypeRel(DoubleMatrixData dmd, RU unit);

    /**
     * Construct a new Absolute Mutable DoubleMatrix of the right type. Each extending class must implement this method.
     * @param dmd DoubleMatrixData; an internal data object
     * @param unit AU; the unit
     * @return M the Mutable DoubleMatrix of the right type
     */
    protected abstract MA instantiateMutableType(DoubleMatrixData dmd, AU unit);

    /**
     * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
     * @param value double; the value
     * @param unit AU; the unit
     * @return S the Immutable DoubleScalar of the right type
     */
    protected abstract S instantiateScalar(double value, AU unit);

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public final S get(final int row, final int column) throws ValueRuntimeException
    {
        checkIndex(row, column);
        return instantiateScalar(getInUnit(row, column, getUnit()), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final A plus(final R rel) throws ValueRuntimeException
    {
        return instantiateTypeAbs(this.getData().plus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final A minus(final R rel) throws ValueRuntimeException
    {
        return instantiateTypeAbs(this.getData().minus(rel.getData()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final R minus(final A abs) throws ValueRuntimeException
    {
        return instantiateTypeRel(this.getData().minus(abs.getData()), getUnit().getRelativeUnit());
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a DoubleMatrix, and return the Unit.
     * @param dsArray S[][]; the array to check and get the unit for
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar type
     * @return the unit of the object
     * @throws ValueRuntimeException when the array is null, has length equal to 0, or has first entry with length equal to 0
     */
    static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractDoubleScalarAbs<AU, S, RU, ?>> AU checkUnit(final S[][] dsArray) throws ValueRuntimeException
    {
        ensureRectangularAndNonEmpty(dsArray);
        return dsArray[0][0].getUnit();
    }

    /**
     * Check that a 2D array of DoubleScalar&lt;?&gt; is rectangular; i.e. all rows have the same length and is non empty.
     * @param values S[][]; the 2D array to check
     * @param <AU> the absolute unit
     * @param <RU> the corresponding relative unit
     * @param <S> the scalar type
     * @throws ValueRuntimeException when values is not rectangular, or contains no data
     */
    protected static <AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
            S extends AbstractDoubleScalarAbs<AU, S, RU, ?>> void ensureRectangularAndNonEmpty(final S[][] values)
                    throws ValueRuntimeException
    {
        if (null == values)
        {
            throw new ValueRuntimeException("Cannot create a DoubleVector or MutableDoubleVector from an empty array of DoubleScalar");
        }
        if (0 == values.length || 0 == values[0].length)
        {
            throw new ValueRuntimeException("Creating DoubleVector or MutableDoubleVector: "
                    + "Cannot determine unit for DoubleMatrix from an empty array of DoubleScalar");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (values[0].length != values[row].length)
            {
                throw new ValueRuntimeException("Creating DoubleVector or MutableDoubleVector: Lengths of rows are not all the same");
            }
        }
    }

}
