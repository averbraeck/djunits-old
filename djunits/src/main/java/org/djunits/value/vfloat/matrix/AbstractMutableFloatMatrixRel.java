package org.djunits.value.vfloat.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsRel;
import org.djunits.value.Mutable;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.vfloat.FloatFunction;
import org.djunits.value.vfloat.FloatMathFunctions;
import org.djunits.value.vfloat.scalar.AbstractFloatScalarRel;

/**
 * Relative Mutable typed Matrix.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the matrix type
 * @param <MR> the mutable matrix type
 * @param <S> the scalar type
 */
abstract class AbstractMutableFloatMatrixRel<U extends Unit<U>, R extends AbstractFloatMatrixRel<U, R, MR, S>, MR extends AbstractMutableFloatMatrixRel<U, R, MR, S>, S extends AbstractFloatScalarRel<U, S>>
        extends AbstractFloatMatrixRel<U, R, MR, S> implements Mutable, MathFunctionsRel<MR>, FloatMathFunctions<MR>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMatrix
     * @param unit U; the unit of the new Absolute Immutable FloatMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableFloatMatrixRel(final float[][] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param values S[][]; the values of the entries in the new Relative Immutable FloatMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableFloatMatrixRel(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param data an internal data object
     * @param unit the unit
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
     * @param increment FloatMatrix.Rel&lt;U&gt;; amount by which the value is incremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     * @throws ValueException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR incrementBy(final R increment) throws ValueException
    {
        checkCopyOnWrite();
        this.data.incrementBy(increment.getData());
        return (MR) this;
    }

    /**
     * Increment the value by the supplied value and return the changed matrix.
     * @param increment FloatScalar.Rel&lt;U&gt;; amount by which the value is incremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MR incrementBy(final S increment)
    {
        return incrementBy(increment.si);
    }

    /**
     * Increment the value by the supplied constant and return the changed matrix.
     * @param increment amount by which the value is incremented
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
     * @param decrement FloatMatrix.Rel&lt;U&gt;; amount by which the value is decremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     * @throws ValueException when the size of increment is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR decrementBy(final R decrement) throws ValueException
    {
        checkCopyOnWrite();
        this.data.decrementBy(decrement.getData());
        return (MR) this;
    }

    /**
     * Decrement the value by the supplied value and return the changed matrix.
     * @param decrement FloatScalar.Rel&lt;U&gt;; amount by which the value is decremented
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MR decrementBy(final S decrement)
    {
        return decrementBy(decrement.si);
    }

    /**
     * Decrement the value by the supplied constant and return the changed matrix.
     * @param decrement amount by which the value is decremented
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
     * @param factors FloatMatrix.Rel&lt;U&gt;; amounts by which the value is multiplied
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     * @throws ValueException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR multiplyBy(final R factors) throws ValueException
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factors.getData());
        return (MR) this;
    }

    /**
     * Multiply the values in the matrix by the supplied value and return the changed matrix.
     * @param factor FloatScalar.Rel&lt;U&gt;; amount by which the values in the matrix are multiplied
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MR multiplyBy(final S factor)
    {
        return multiplyBy(factor.si);
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
     * @param factors FloatMatrix.Rel&lt;U&gt;; amounts by which the value is divided
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     * @throws ValueException when the size of the factors is not identical to the size of this
     */
    @SuppressWarnings("unchecked")
    public final MR divideBy(final R factors) throws ValueException
    {
        checkCopyOnWrite();
        this.data.divideBy(factors.getData());
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({ "checkstyle:designforextension", "unchecked" })
    public MR divideBy(final float factor)
    {
        this.data.divideBy(factor);
        return (MR) this;
    }

    /**
     * Divide the values in the matrix by the supplied value and return the changed matrix.
     * @param factor FloatScalar.Rel&lt;U&gt;; amount by which the values in the matrix are divided
     * @return the changed MutableFloatMatrix.Rel&lt;U&gt;
     */
    public final MR divideBy(final S factor)
    {
        return divideBy(factor.si);
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /**
     * Execute a function on a cell by cell basis. Note: because many functions have to act on zero cells or can generate cells
     * with a zero value, the functions have to be applied on a dense dataset which has to be transformed back to a sparse
     * dataset if necessary.
     * @param floatFunction the function to apply
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
     * @param row the row
     * @param column the column
     * @param valueSI the value, expressed in the SI unit
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
     * @param row the row
     * @param column the column
     * @param value the value
     * @throws ValueException when the row/column is out of range
     */
    public final void set(final int row, final int column, final S value) throws ValueException
    {
        setSI(row, column, value.getSI());
    }

    /**
     * Set the value for a cell in the matrix.
     * @param row the row
     * @param column the column
     * @param value the value, expressed in the given unit
     * @param valueUnit the unit of the value
     * @throws ValueException when the row/column is out of range
     */
    public final void setInUnit(final int row, final int column, final float value, final U valueUnit) throws ValueException
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
