package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.Unit;
import org.djunits4.value.IsMutable;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.function.MathFunctionsRel;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vfloat.FloatFunction;
import org.djunits4.value.vfloat.FloatMathFunctions;
import org.djunits4.value.vfloat.scalar.AbstractFloatScalarRel;

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
abstract class AbstractMutableFloatMatrixRel<U extends Unit<U>, R extends AbstractFloatMatrixRel<U, R, MR, S>,
        MR extends AbstractMutableFloatMatrixRel<U, R, MR, S>, S extends AbstractFloatScalarRel<U, S>>
        extends AbstractFloatMatrixRel<U, R, MR, S> implements IsMutable, MathFunctionsRel<MR>, FloatMathFunctions<MR>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMatrix
     * @param unit U; the unit of the new Absolute Immutable FloatMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    AbstractMutableFloatMatrixRel(final float[][] values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param values S[][]; the values of the entries in the new Relative Immutable FloatMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    AbstractMutableFloatMatrixRel(final S[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit U; the unit
     */
    AbstractMutableFloatMatrixRel(final FloatMatrixData data, final U unit)
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
     * Create a immutable version of this MutableFloatMatrix. <br>
     * @return FloatMatrix&lt;U&gt;; mutable version of this MutableFloatMatrix
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
     * Create a deep copy of this MutableFloatMatrix. <br>
     * @return FloatMatrix&lt;U&gt;; deep copy of this MutableFloatMatrix
     */
    public final MR copy()
    {
        return mutable();
    }

    /**
     * Increment the value by the supplied value and return the changed matrix.
     * @param increment R; amount by which the value is incremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
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
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MR incrementBy(final S increment)
    {
        return incrementBy(increment.getSI());
    }

    /**
     * Increment the value by the supplied constant and return the changed matrix.
     * @param increment float; amount by which the value is incremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MR incrementBy(final float increment)
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment);
        return (MR) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed matrix.
     * @param decrement R; amount by which the value is decremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
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
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MR decrementBy(final S decrement)
    {
        return decrementBy(decrement.getSI());
    }

    /**
     * Decrement the value by the supplied constant and return the changed matrix.
     * @param decrement float; amount by which the value is decremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MR decrementBy(final float decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement);
        return (MR) this;
    }

    /**
     * Multiply the values in the matrix by the supplied values and return the changed matrix.
     * @param factors R; amounts by which the value is multiplied
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
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
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MR multiplyBy(final S factor)
    {
        return multiplyBy(factor.getSI());
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR multiplyBy(final float factor)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factor);
        return (MR) this;
    }

    /**
     * Divide the values in the matrix by the supplied values and return the changed matrix.
     * @param factors R; amounts by which the value is divided
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
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
    public MR divideBy(final float divisor)
    {
        this.data.divideBy(divisor);
        return (MR) this;
    }

    /**
     * Divide the values in the matrix by the supplied value and return the changed matrix.
     * @param factor S; amount by which the values in the matrix are divided
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MR divideBy(final S factor)
    {
        return divideBy(factor.getSI());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /**
     * Execute a function on a cell by cell basis. Note: because many functions have to act on zero cells or can generate cells
     * with a zero value, the functions have to be applied on a dense dataset which has to be transformed back to a sparse
     * dataset if necessary.
     * @param floatFunction FloatFunction; the function to apply
     */
    public final void assign(final FloatFunction floatFunction)
    {
        checkCopyOnWrite();
        if (this.data instanceof FloatMatrixDataDense)
        {
            ((FloatMatrixDataDense) this.data).assign(floatFunction);
        }
        else
        {
            FloatMatrixDataDense dvdd = ((FloatMatrixDataSparse) this.data).toDense();
            dvdd.assign(floatFunction);
            this.data = dvdd.toSparse();
        }
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR abs()
    {
        assign(FloatMathFunctions.ABS);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR ceil()
    {
        assign(FloatMathFunctions.CEIL);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR floor()
    {
        assign(FloatMathFunctions.FLOOR);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR neg()
    {
        assign(FloatMathFunctions.NEG);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR rint()
    {
        assign(FloatMathFunctions.RINT);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR round()
    {
        assign(FloatMathFunctions.ROUND);
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
     * @param valueSI float; the value, expressed in the SI unit
     * @throws ValueRuntimeException when the row/column is out of range
     */
    public final void setSI(final int row, final int column, final float valueSI) throws ValueRuntimeException
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
     * @param value float; the value, expressed in the given unit
     * @param valueUnit U; the unit of the value
     * @throws ValueRuntimeException when the row/column is out of range
     */
    public final void setInUnit(final int row, final int column, final float value, final U valueUnit) throws ValueRuntimeException
    {
        setSI(row, column, (float) ValueUtil.expressAsSIUnit(value, valueUnit));
    }

    /**
     * Normalize the matrix, i.e. scale the values to make the sum equal to 1.
     * @throws ValueRuntimeException when the sum of the values is zero and normalization is not possible
     */
    public final void normalize() throws ValueRuntimeException
    {
        float sum = zSum();
        if (0 == sum)
        {
            throw new ValueRuntimeException("zSum is 0; cannot normalize");
        }
        checkCopyOnWrite();
        this.data.divideBy(sum);
    }

}
