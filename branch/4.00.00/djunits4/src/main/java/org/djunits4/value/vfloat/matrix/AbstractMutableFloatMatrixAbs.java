package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.MathFunctionsAbs;
import org.djunits4.value.Mutable;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.ValueUtil;
import org.djunits4.value.vfloat.FloatFunction;
import org.djunits4.value.vfloat.FloatMathFunctions;
import org.djunits4.value.vfloat.scalar.AbstractFloatScalarAbs;

/**
 * Absolute Mutable typed Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
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
abstract class AbstractMutableFloatMatrixAbs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>,
        A extends AbstractFloatMatrixAbs<AU, RU, A, R, MA, S>, R extends AbstractFloatMatrixRel<RU, R, ?, ?>,
        MA extends AbstractMutableFloatMatrixAbs<AU, RU, A, R, MA, S>, S extends AbstractFloatScalarAbs<AU, S, RU, ?>>
        extends AbstractFloatMatrixAbs<AU, RU, A, R, MA, S> implements Mutable, MathFunctionsAbs<MA>, FloatMathFunctions<MA>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Construct a new Absolute Mutable FloatMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Immutable FloatMatrix
     * @param unit AU; the unit of the new Absolute Immutable FloatMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableFloatMatrixAbs(final float[][] values, final AU unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatMatrix.
     * @param values S[][]; the values of the entries in the new Absolute Immutable FloatMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableFloatMatrixAbs(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit AU; the unit
     */
    AbstractMutableFloatMatrixAbs(final FloatMatrixData data, final AU unit)
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
     * Create a immutable version of this MutableFloatMatrix. <br>
     * @return FloatMatrix&lt;U&gt;; mutable version of this MutableFloatMatrix
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
     * Create a deep copy of this MutableFloatMatrix. <br>
     * @return FloatMatrix&lt;U&gt;; deep copy of this MutableFloatMatrix
     */
    public final MA copy()
    {
        return mutable();
    }

    /**
     * Increment the value by the supplied value and return the changed matrix.
     * @param increment R; amount by which the value is incremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
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
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MA incrementBy(final S increment)
    {
        return incrementBy(increment.getSI());
    }

    /**
     * Increment the value by the supplied constant and return the changed matrix.
     * @param increment float; amount by which the value is incremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MA incrementBy(final float increment)
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment);
        return (MA) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed matrix.
     * @param decrement R; amount by which the value is decremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
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
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MA decrementBy(final S decrement)
    {
        return decrementBy(decrement.getSI());
    }

    /**
     * Decrement the value by the supplied constant and return the changed matrix.
     * @param decrement float; amount by which the value is decremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    @SuppressWarnings("unchecked")
    public final MA decrementBy(final float decrement)
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MA multiplyBy(final float factor)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factor);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:designforextension", "unchecked"})
    public MA divideBy(final float factor)
    {
        this.data.divideBy(factor);
        return (MA) this;
    }

    /**
     * Multiply the values in the matrix by the supplied values and return the changed matrix.
     * @param factors R; amounts by which the value is multiplied
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
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
    @Override
    @SuppressWarnings("unchecked")
    public final MA ceil()
    {
        assign(FloatMathFunctions.CEIL);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA floor()
    {
        assign(FloatMathFunctions.FLOOR);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA rint()
    {
        assign(FloatMathFunctions.RINT);
        return (MA) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MA round()
    {
        assign(FloatMathFunctions.ROUND);
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
     * @param valueSI float; the value, expressed in the SI unit
     * @throws ValueException when the row/column is out of range
     */
    public final void setSI(final int row, final int column, final float valueSI) throws ValueException
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
     * @param value float; the value, expressed in the given unit
     * @param valueUnit AU; the unit of the value
     * @throws ValueException when the row/column is out of range
     */
    public final void setInUnit(final int row, final int column, final float value, final AU valueUnit) throws ValueException
    {
        setSI(row, column, (float) ValueUtil.expressAsSIUnit(value, valueUnit));
    }

    /**
     * Normalize the matrix, i.e. scale the values to make the sum equal to 1.
     * @throws ValueException when the sum of the values is zero and normalization is not possible
     */
    public final void normalize() throws ValueException
    {
        float sum = zSum();
        if (0 == sum)
        {
            throw new ValueException("zSum is 0; cannot normalize");
        }
        checkCopyOnWrite();
        this.data.divideBy(sum);
    }
    
}
