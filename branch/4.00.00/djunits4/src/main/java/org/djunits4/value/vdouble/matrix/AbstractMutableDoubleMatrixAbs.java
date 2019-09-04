package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.MathFunctionsAbs;
import org.djunits4.value.Mutable;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.ValueUtil;
import org.djunits4.value.vdouble.DoubleFunction;
import org.djunits4.value.vdouble.DoubleMathFunctions;
import org.djunits4.value.vdouble.scalar.AbstractDoubleScalarAbs;

/**
 * Absolute Mutable typed Matrix.
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
abstract class AbstractMutableDoubleMatrixAbs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
        A extends AbstractDoubleMatrixAbs<AU, RU, A, R, MA, S>, R extends AbstractDoubleMatrixRel<RU, R, ?, ?>,
        MA extends AbstractMutableDoubleMatrixAbs<AU, RU, A, R, MA, S>, S extends AbstractDoubleScalarAbs<AU, S, RU, ?>>
        extends AbstractDoubleMatrixAbs<AU, RU, A, R, MA, S> implements Mutable, MathFunctionsAbs<MA>, DoubleMathFunctions<MA>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Construct a new Absolute Mutable DoubleMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Immutable DoubleMatrix
     * @param unit AU; the unit of the new Absolute Immutable DoubleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableDoubleMatrixAbs(final double[][] values, final AU unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable DoubleMatrix.
     * @param values S[][]; the values of the entries in the new Absolute Immutable DoubleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableDoubleMatrixAbs(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable DoubleMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit AU; the unit
     */
    AbstractMutableDoubleMatrixAbs(final DoubleMatrixData data, final AU unit)
    {
        super(data, unit);
    }

    /**
     * Retrieve the value of the copyOnWrite flag.
     * @return boolean
     */
    private boolean isCopyOnWrite()
    {
        return this.copyOnWrite;
    }

    /**
     * Change the copyOnWrite flag.
     * @param copyOnWrite boolean; the new value for the copyOnWrite flag
     */
    final void setCopyOnWrite(final boolean copyOnWrite)
    {
        this.copyOnWrite = copyOnWrite;
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

    /**
     * Create a immutable version of this MutableDoubleMatrix. <br>
     * @return DoubleMatrix&lt;U&gt;; mutable version of this MutableDoubleMatrix
     */
    public final A immutable()
    {
        setCopyOnWrite(true);
        return instantiateTypeAbs(getData(), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /**
     * Create a deep copy of this MutableDoubleMatrix. <br>
     * @return DoubleMatrix&lt;U&gt;; deep copy of this MutableDoubleMatrix
     */
    public final MA copy()
    {
        return mutable();
    }

    /**
     * Increment the value by the supplied value and return the changed matrix.
     * @param increment R; amount by which the value is incremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     * @throws ValueException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MA incrementBy(final R increment) throws ValueException
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment.getData());
        return (MA) this;
    }

    /**
     * Increment the value by the supplied value and return the changed matrix.
     * @param increment S; amount by which the value is incremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    public final MA incrementBy(final S increment)
    {
        return incrementBy(increment.getSI());
    }

    /**
     * Increment the value by the supplied constant and return the changed matrix.
     * @param increment double; amount by which the value is incremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MA incrementBy(final double increment)
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment);
        return (MA) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed matrix.
     * @param decrement R; amount by which the value is decremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     * @throws ValueException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MA decrementBy(final R decrement) throws ValueException
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement.getData());
        return (MA) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed matrix.
     * @param decrement S; amount by which the value is decremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    public final MA decrementBy(final S decrement)
    {
        return decrementBy(decrement.getSI());
    }

    /**
     * Decrement the value by the supplied constant and return the changed matrix.
     * @param decrement double; amount by which the value is decremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MA decrementBy(final double decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA multiplyBy(final double factor)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factor);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:designforextension", "unchecked"})
    public MA divideBy(final double divisor)
    {
        this.data.divideBy(divisor);
        return (MA) this;
    }

    /**
     * Multiply the values in the matrix by the supplied values and return the changed matrix.
     * @param factors R; amounts by which the value is multiplied
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     * @throws ValueException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MA multiplyBy(final R factors) throws ValueException
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factors.getData());
        return (MA) this;
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /**
     * Execute a function on a cell by cell basis. Note: because many functions have to act on zero cells or can generate cells
     * with a zero value, the functions have to be applied on a dense dataset which has to be transformed back to a sparse
     * dataset if necessary.
     * @param doubleFunction DoubleFunction; the function to apply
     */
    public final void assign(final DoubleFunction doubleFunction)
    {
        checkCopyOnWrite();
        if (this.data instanceof DoubleMatrixDataDense)
        {
            ((DoubleMatrixDataDense) this.data).assign(doubleFunction);
        }
        else
        {
            DoubleMatrixDataDense dvdd = ((DoubleMatrixDataSparse) this.data).toDense();
            dvdd.assign(doubleFunction);
            this.data = dvdd.toSparse();
        }
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA ceil()
    {
        assign(DoubleMathFunctions.CEIL);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA floor()
    {
        assign(DoubleMathFunctions.FLOOR);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA rint()
    {
        assign(DoubleMathFunctions.RINT);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA round()
    {
        assign(DoubleMathFunctions.ROUND);
        return (MA) this;
    }

    /**
     * Check the copyOnWrite flag and, if it is set, make a deep copy of the data and clear the flag.
     */
    protected final void checkCopyOnWrite()
    {
        if (isCopyOnWrite())
        {
            this.data = this.data.copy();
            setCopyOnWrite(false);
        }
    }

    /**
     * Set the value for a cell in the matrix.
     * @param row int; the row
     * @param column int; the column
     * @param valueSI double; the value, expressed in the SI unit
     * @throws ValueException when the row/column is out of range
     */
    public final void setSI(final int row, final int column, final double valueSI) throws ValueException
    {
        checkIndex(row, column);
        checkCopyOnWrite();
        this.data.setSI(row, column, valueSI);
    }

    /**
     * Set the value for a cell in the matrix.
     * @param row int; the row
     * @param column int; the column
     * @param value S; the value
     * @throws ValueException when the row/column is out of range
     */
    public final void set(final int row, final int column, final S value) throws ValueException
    {
        setSI(row, column, value.getSI());
    }

    /**
     * Set the value for a cell in the matrix.
     * @param row int; the row
     * @param column int; the column
     * @param value double; the value, expressed in the given unit
     * @param valueUnit AU; the unit of the value
     * @throws ValueException when the row/column is out of range
     */
    public final void setInUnit(final int row, final int column, final double value, final AU valueUnit) throws ValueException
    {
        setSI(row, column, ValueUtil.expressAsSIUnit(value, valueUnit));
    }

    /**
     * Normalize the matrix, i.e. scale the values to make the sum equal to 1.
     * @throws ValueException when the sum of the values is zero and normalization is not possible
     */
    public final void normalize() throws ValueException
    {
        double sum = zSum();
        if (0 == sum)
        {
            throw new ValueException("zSum is 0; cannot normalize");
        }
        checkCopyOnWrite();
        this.data.divideBy(sum);
    }
}
