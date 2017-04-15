package org.djunits.value.vdouble.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsRel;
import org.djunits.value.Mutable;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.vdouble.DoubleFunction;
import org.djunits.value.vdouble.DoubleMathFunctions;
import org.djunits.value.vdouble.scalar.AbstractDoubleScalarRel;

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
abstract class AbstractMutableDoubleMatrixRel<U extends Unit<U>, R extends AbstractDoubleMatrixRel<U, R, MR, S>, MR extends AbstractMutableDoubleMatrixRel<U, R, MR, S>, S extends AbstractDoubleScalarRel<U, S>>
        extends AbstractDoubleMatrixRel<U, R, MR, S> implements Mutable, MathFunctionsRel<MR>, DoubleMathFunctions<MR>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable DoubleMatrix
     * @param unit U; the unit of the new Absolute Immutable DoubleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    AbstractMutableDoubleMatrixRel(final double[][] values, final U unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param values S[][]; the values of the entries in the new Relative Immutable DoubleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    AbstractMutableDoubleMatrixRel(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param data an internal data object
     * @param unit the unit
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
     * @param increment DoubleMatrix.Rel&lt;U&gt;; amount by which the value is incremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
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
     * @param increment DoubleScalar.Rel&lt;U&gt;; amount by which the value is incremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    public final MR incrementBy(final S increment)
    {
        return incrementBy(increment.si);
    }

    /**
     * Increment the value by the supplied constant and return the changed matrix.
     * @param increment amount by which the value is incremented
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
     * @param decrement DoubleMatrix.Rel&lt;U&gt;; amount by which the value is decremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
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
     * @param decrement DoubleScalar.Rel&lt;U&gt;; amount by which the value is decremented
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    public final MR decrementBy(final S decrement)
    {
        return decrementBy(decrement.si);
    }

    /**
     * Decrement the value by the supplied constant and return the changed matrix.
     * @param decrement amount by which the value is decremented
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
     * @param factors DoubleMatrix.Rel&lt;U&gt;; amounts by which the value is multiplied
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
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
     * @param factor DoubleScalar.Rel&lt;U&gt;; amount by which the values in the matrix are multiplied
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
     */
    public final MR multiplyBy(final S factor)
    {
        return multiplyBy(factor.si);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR multiplyBy(final double factor)
    {
        checkCopyOnWrite();
        this.data.multiplyBy(factor);
        return (MR) this;
    }

    /**
     * Divide the values in the matrix by the supplied values and return the changed matrix.
     * @param factors DoubleMatrix.Rel&lt;U&gt;; amounts by which the value is divided
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
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
    public MR divideBy(final double factor)
    {
        this.data.divideBy(factor);
        return (MR) this;
    }

    /**
     * Divide the values in the matrix by the supplied value and return the changed matrix.
     * @param factor DoubleScalar.Rel&lt;U&gt;; amount by which the values in the matrix are divided
     * @return the changed MutableDoubleMatrix.Rel&lt;U&gt;
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
     * @param doubleFunction the function to apply
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
    @SuppressWarnings("unchecked")
    @Override
    public final MR abs()
    {
        assign(DoubleMathFunctions.ABS);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR ceil()
    {
        assign(DoubleMathFunctions.CEIL);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR floor()
    {
        assign(DoubleMathFunctions.FLOOR);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR neg()
    {
        assign(DoubleMathFunctions.NEG);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR rint()
    {
        assign(DoubleMathFunctions.RINT);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final MR round()
    {
        assign(DoubleMathFunctions.ROUND);
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
    public final void setSI(final int row, final int column, final double valueSI) throws ValueException
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
    public final void setInUnit(final int row, final int column, final double value, final U valueUnit) throws ValueException
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
