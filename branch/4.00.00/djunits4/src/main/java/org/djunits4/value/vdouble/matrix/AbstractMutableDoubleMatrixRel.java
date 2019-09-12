package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.Unit;
import org.djunits4.value.IsMutable;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.function.MathFunctionsRel;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vdouble.DoubleFunction;
import org.djunits4.value.vdouble.DoubleFunctionsAll;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalarRel;

/**
 * Relative Mutable typed Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the matrix type
 * @param <MR> the mutable matrix type
 * @param <S> the scalar type
 */
abstract class AbstractMutableDoubleMatrixRel<U extends Unit<U>, R extends AbstractDoubleMatrixRel<U, R, MR, S>,
        MR extends AbstractMutableDoubleMatrixRel<U, R, MR, S>, S extends AbstractDoubleScalarRel<U, S>>
        extends AbstractDoubleMatrixRel<U, R, MR, S> implements IsMutable, MathFunctionsRel<MR>, DoubleFunctionsAll<MR>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable DoubleMatrix
     * @param unit U; the unit of the new Absolute Immutable DoubleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractMutableDoubleMatrixRel(final double[][] values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param values S[][]; the values of the entries in the new Relative Immutable DoubleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractMutableDoubleMatrixRel(final S[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit U; the unit
     */
    AbstractMutableDoubleMatrixRel(final DoubleMatrixData data, final U unit)
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
    public final MR mutable()
    {
        setCopyOnWrite(true);
        final MR result = instantiateMutableType(getData(), getUnit());
        result.setCopyOnWrite(true);
        return result;
    }

    /**
     * Create a immutable version of this MutableDoubleMatrix. <br>
     * @return DoubleMatrix&lt;U&gt;; mutable version of this MutableDoubleMatrix
     */
    public final R immutable()
    {
        setCopyOnWrite(true);
        return instantiateType(getData(), getUnit());
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /**
     * Create a deep copy of this MutableDoubleMatrix. <br>
     * @return DoubleMatrix&lt;U&gt;; deep copy of this MutableDoubleMatrix
     */
    public final MR copy()
    {
        return mutable();
    }

    /**
     * Increment the value by the supplied value and return the changed matrix.
     * @param increment R; amount by which the value is incremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     * @throws ValueRuntimeException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR incrementBy(final R increment) throws ValueRuntimeException
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment.getData());
        return (MR) this;
    }

    /**
     * Increment the value by the supplied value and return the changed matrix.
     * @param increment S; amount by which the value is incremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    public final MR incrementBy(final S increment)
    {
        return incrementBy(increment.getSI());
    }

    /**
     * Increment the value by the supplied constant and return the changed matrix.
     * @param increment double; amount by which the value is incremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MR incrementBy(final double increment)
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment);
        return (MR) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed matrix.
     * @param decrement R; amount by which the value is decremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     * @throws ValueRuntimeException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR decrementBy(final R decrement) throws ValueRuntimeException
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement.getData());
        return (MR) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed matrix.
     * @param decrement S; amount by which the value is decremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    public final MR decrementBy(final S decrement)
    {
        return decrementBy(decrement.getSI());
    }

    /**
     * Decrement the value by the supplied constant and return the changed matrix.
     * @param decrement double; amount by which the value is decremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MR decrementBy(final double decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement);
        return (MR) this;
    }

    /**
     * Multiply the values in the matrix by the supplied values and return the changed matrix.
     * @param factors R; amounts by which the value is multiplied
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     * @throws ValueRuntimeException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR multiplyBy(final R factors) throws ValueRuntimeException
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factors.getData());
        return (MR) this;
    }

    /**
     * Multiply the values in the matrix by the supplied value and return the changed matrix.
     * @param factor S; amount by which the values in the matrix are multiplied
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    public final MR multiplyBy(final S factor)
    {
        return times(factor.getSI());
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR times(final double factor)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factor);
        return (MR) this;
    }

    /**
     * Divide the values in the matrix by the supplied values and return the changed matrix.
     * @param factors R; amounts by which the value is divided
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     * @throws ValueRuntimeException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR divideBy(final R factors) throws ValueRuntimeException
    {
        checkCopyOnWrite();
        this.data.divideBy(factors.getData());
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:designforextension", "unchecked"})
    public MR divide(final double divisor)
    {
        this.data.divideBy(divisor);
        return (MR) this;
    }

    /**
     * Divide the values in the matrix by the supplied value and return the changed matrix.
     * @param divisor S; amount by which the values in the matrix are divided
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    public final MR divideBy(final S divisor)
    {
        return divide(divisor.getSI());
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
            ((DoubleMatrixDataDense) this.data).apply(doubleFunction);
        }
        else
        {
            DoubleMatrixDataDense dvdd = ((DoubleMatrixDataSparse) this.data).toDense();
            dvdd.apply(doubleFunction);
            this.data = dvdd.toSparse();
        }
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR abs()
    {
        apply(DoubleFunctionsAll.ABS);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR ceil()
    {
        apply(DoubleFunctionsAll.CEIL);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR floor()
    {
        apply(DoubleFunctionsAll.FLOOR);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR neg()
    {
        apply(DoubleFunctionsAll.NEG);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR rint()
    {
        apply(DoubleFunctionsAll.RINT);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR round()
    {
        apply(DoubleFunctionsAll.ROUND);
        return (MR) this;
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
     * @throws ValueRuntimeException when the row/column is out of range
     */
    public final void setSI(final int row, final int column, final double valueSI) throws ValueRuntimeException
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
     * @throws ValueRuntimeException when the row/column is out of range
     */
    public final void set(final int row, final int column, final S value) throws ValueRuntimeException
    {
        setSI(row, column, value.getSI());
    }

    /**
     * Set the value for a cell in the matrix.
     * @param row int; the row
     * @param column int; the column
     * @param value double; the value, expressed in the given unit
     * @param valueUnit U; the unit of the value
     * @throws ValueRuntimeException when the row/column is out of range
     */
    public final void setInUnit(final int row, final int column, final double value, final U valueUnit) throws ValueRuntimeException
    {
        setSI(row, column, ValueUtil.expressAsSIUnit(value, valueUnit));
    }

    /**
     * Normalize the matrix, i.e. scale the values to make the sum equal to 1.
     * @throws ValueRuntimeException when the sum of the values is zero and normalization is not possible
     */
    public final void normalize() throws ValueRuntimeException
    {
        double sum = zSum();
        if (0 == sum)
        {
            throw new ValueRuntimeException("zSum is 0; cannot normalize");
        }
        checkCopyOnWrite();
        this.data.divideBy(sum);
    }
}
