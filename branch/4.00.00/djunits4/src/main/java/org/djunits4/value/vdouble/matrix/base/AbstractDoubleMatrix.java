package org.djunits4.value.vdouble.matrix.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.djunits4.Throw;
import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.AbstractValue;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.formatter.Format;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.util.ValueUtil;
import org.djunits4.value.vdouble.function.DoubleFunction;
import org.djunits4.value.vdouble.function.DoubleMathFunctions;
import org.djunits4.value.vdouble.matrix.DoubleMatrix;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixDataDense;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixDataSparse;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;
import org.djunits4.value.vdouble.vector.base.DoubleVectorInterface;
import org.ojalgo.matrix.PrimitiveMatrix;

/**
 * The most basic abstract class for the DoubleMatrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 * @param <S> the scalar with unit U
 * @param <V> the matrix type belonging to the matrix type
 * @param <M> the generic matrix type
 */
public abstract class AbstractDoubleMatrix<U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
        V extends DoubleVectorInterface<U, S, V>, M extends AbstractDoubleMatrix<U, S, V, M>> extends AbstractValue<U, M>
        implements DoubleMatrixInterface<U, S, V, M>
{
    /** */
    private static final long serialVersionUID = 20161015L;

    /** The stored data as an object, can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected DoubleMatrixData data;

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /** helper flag to indicate whether the data is mutable or not. */
    private boolean mutable = false;

    /**
     * Construct a new DoubleMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit U; the unit
     */
    AbstractDoubleMatrix(final DoubleMatrixData data, final U unit)
    {
        super(unit);
        this.data = data;
    }

    /**
     * Retrieve the data.
     * @return the internal data -- can only be used within package and by subclasses.
     */
    protected final DoubleMatrixData getData()
    {
        return this.data;
    }

    /** {@inheritDoc} */
    @Override
    public final StorageType getStorageType()
    {
        return this.data.getStorageType();
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

    /**
     * Return helper flag to indicate whether the data is mutable or not.
     * @return boolean; helper flag to indicate whether the data is mutable or not
     */
    public boolean isMutable()
    {
        return this.mutable;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public M immutable()
    {
        setMutable(false);
        return (M) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public M mutable()
    {
        setMutable(true);
        return (M) this;
    }

    /** {@inheritDoc} */
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    /**
     * Set helper flag to indicate whether the data is mutable or not.
     * @param mutable boolean; helper flag to indicate whether the data is mutable or not
     */
    protected void setMutable(final boolean mutable)
    {
        this.mutable = mutable;
    }

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored Matrix.
     * @return the StorageType (DENSE, SPARSE, etc.) for the stored Matrix
     */
    public final StorageType getStorageType()
    {
        return this.data.getStorageType();
    }

    /** {@inheritDoc} */
    @Override
    public final double[][] getValuesSI()
    {
        return this.data.getDenseMatrixSI();
    }

    /** {@inheritDoc} */
    @Override
    public final double[][] getValuesInUnit()
    {
        return getValuesInUnit(getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final double[][] getValuesInUnit(final U targetUnit)
    {
        double[][] values = getValuesSI();
        for (int row = rows(); --row >= 0;)
        {
            for (int column = columns(); --column >= 0;)
            {
                values[row][column] = ValueUtil.expressAsUnit(values[row][column], targetUnit);
            }
        }
        return values;
    }

    /** {@inheritDoc} */
    @Override
    public final int rows()
    {
        return this.data.rows();
    }

    /** {@inheritDoc} */
    @Override
    public final int columns()
    {
        return this.data.cols();
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI(final int row, final int column) throws ValueRuntimeException
    {
        checkIndex(row, column);
        return this.data.getSI(row, column);
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int row, final int column) throws ValueRuntimeException
    {
        return expressAsSpecifiedUnit(getSI(row, column));
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int row, final int column, final U targetUnit) throws ValueRuntimeException
    {
        return ValueUtil.expressAsUnit(getSI(row, column), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final double zSum()
    {
        return this.data.zSum();
    }

    /** {@inheritDoc} */
    @Override
    public final int cardinality()
    {
        return this.data.cardinality();
    }

    /** {@inheritDoc} */
    @Override
    public final String toString()
    {
        return toString(getUnit(), false, true);
    }

    /** {@inheritDoc} */
    @Override
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /** {@inheritDoc} */
    @Override
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final String toString(final U displayUnit, final boolean verbose, final boolean withUnit)
    {
        StringBuffer buf = new StringBuffer();
        if (verbose)
        {
            String ab = this instanceof Absolute ? "Abs " : "Rel ";
            String ds = this.data.isDense() ? "Dense  " : this.data.isSparse() ? "Sparse " : "?????? ";
            if (this instanceof IsMutable)
            {
                buf.append("Mutable   " + ab + ds);
            }
            else
            {
                buf.append("Immutable " + ab + ds);
            }
        }
        for (int row = 0; row < rows(); row++)
        {
            buf.append("\r\n\t");
            for (int column = 0; column < columns(); column++)
            {
                try
                {
                    double d = ValueUtil.expressAsUnit(getSI(row, column), displayUnit);
                    buf.append(" " + Format.format(d));
                }
                catch (ValueRuntimeException ve)
                {
                    buf.append(" " + "********************".substring(0, Format.DEFAULTSIZE));
                }
            }
        }
        buf.append("\n");
        if (withUnit)
        {
            buf.append(displayUnit.getDefaultDisplayAbbreviation());
        }
        return buf.toString();
    }

    /**
     * Centralized size equality check.
     * @param other AbstractDoubleMatrixRel&lt;?, ?, ?, ?&gt;; other DoubleMatrix
     * @throws ValueRuntimeException when other is null, or matrices have unequal size
     */
    protected final void checkSize(final AbstractDoubleMatrixRel<?, ?, ?, ?> other) throws ValueRuntimeException
    {
        if (null == other)
        {
            throw new ValueRuntimeException("other is null");
        }
        if (rows() != other.rows() || columns() != other.columns())
        {
            throw new ValueRuntimeException("The matrices have different sizes: " + rows() + "x" + columns() + " != " + other.rows()
                    + "x" + other.columns());
        }
    }

    /**
     * Check that a 2D array of double is not null, not empty and not jagged; i.e. all rows have the same length.
     * @param values double[][]; the 2D array to check
     * @return the values in case the method is used in a constructor
     * @throws ValueRuntimeException when <code>values</code> is null, empty, or jagged
     */
    protected static double[][] ensureRectangularAndNonEmpty(final double[][] values) throws ValueRuntimeException
    {
        if (null == values)
        {
            throw new ValueRuntimeException("Cannot create a DoubleVector or MutableDoubleVector from a null array of double[][]");
        }
        if (values.length > 0 && null == values[0])
        {
            throw new ValueRuntimeException("Creating DoubleVector or MutableDoubleVector: Row 0 is null");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (null == values[row] || values[0].length != values[row].length)
            {
                throw new ValueRuntimeException("Creating DoubleVector or MutableDoubleVector: Lengths of rows are not all the same");
            }
        }
        return values;
    }

    /**
     * Centralized size equality check.
     * @param other double[][]; array of double
     * @throws ValueRuntimeException when matrices have unequal size
     */
    protected final void checkSize(final double[][] other) throws ValueRuntimeException
    {
        ensureRectangularAndNonEmpty(other);
        final int otherColumns = other[0].length;
        if (rows() != other.length || columns() != otherColumns)
        {
            throw new ValueRuntimeException("The matrix and the array have different sizes: " + rows() + "x" + columns() + " != "
                    + other.length + "x" + otherColumns);
        }
    }

    /**
     * Check that provided row and column indices are valid.
     * @param row int; the row value to check
     * @param column int; the column value to check
     * @throws ValueRuntimeException when row or column is invalid
     */
    protected final void checkIndex(final int row, final int column) throws ValueRuntimeException
    {
        if (row < 0 || row >= rows() || column < 0 || column >= columns())
        {
            throw new ValueRuntimeException("index out of range (valid range is 0.." + (rows() - 1) + ", 0.." + (columns() - 1)
                    + ", got " + row + ", " + column + ")");
        }
    }

    /** {@inheritDoc} */
    @Override
    public final double determinant() throws ValueRuntimeException
    {
        try
        {
            final PrimitiveMatrix.Factory matrixFactory = PrimitiveMatrix.FACTORY;
            final PrimitiveMatrix m = matrixFactory.rows(this.data.getDenseMatrixSI());
            if (!m.isSquare())
            {
                throw new IllegalArgumentException("Matrix is not square -- determinant cannot be calculated.");
            }
            return m.getDeterminant().doubleValue();
        }
        catch (IllegalArgumentException exception)
        {
            throw new ValueRuntimeException(exception); // Matrix must be square
        }
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public M toSparse()
    {
        M result;
        if (getStorageType().equals(StorageType.SPARSE))
        {
            result = (M) this;
            result.setDisplayUnit(getUnit());
        }
        else
        {
            result = (M) DoubleMatrix.instantiate(this.data.toSparse(), getUnit());
        }
        result.setDisplayUnit(getUnit());
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public M toDense()
    {
        M result;
        if (getStorageType().equals(StorageType.DENSE))
        {
            result = (M) this;
            result.setDisplayUnit(getUnit());
        }
        else
        {
            result = (M) DoubleMatrix.instantiate(this.data.toDense(), getUnit());
        }
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public M copy()
    {
        return (M) DoubleMatrix.instantiate(this.data.copy(), getUnit());
    }

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
    @SuppressWarnings("unchecked")
    @Override
    public M times(final double multiplier)
    {
        M result = isMutable() ? (M) this : copy();
        result.assign(DoubleMathFunctions.MULT(multiplier));
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public M divide(final double divisor)
    {
        @SuppressWarnings("unchecked")
        M result = isMutable() ? (M) this : copy();
        result.assign(DoubleMathFunctions.DIV(divisor));
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public M times(final float multiplier)
    {
        return times((double) multiplier);
    }

    /** {@inheritDoc} */
    @Override
    public M divide(float divisor)
    {
        return divide((double) divisor);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final M abs()
    {
        M result = isMutable() ? (M) this : copy();
        result.assign(DoubleMathFunctions.ABS);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final M ceil()
    {
        M result = isMutable() ? (M) this : copy();
        result.assign(DoubleMathFunctions.CEIL);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final M floor()
    {
        M result = isMutable() ? (M) this : copy();
        result.assign(DoubleMathFunctions.FLOOR);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final M neg()
    {
        M result = isMutable() ? (M) this : copy();
        result.assign(DoubleMathFunctions.NEG);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final M rint()
    {
        M result = isMutable() ? (M) this : copy();
        result.assign(DoubleMathFunctions.RINT);
        return result;
    }

    /**
     * Centralized size equality check.
     * @param other AbstractDoubleMatrix&lt;U, ?&gt;; other DoubleMatrix
     * @throws NullPointerException when other matrix is null
     * @throws ValueRuntimeException when matrixs have unequal size
     */
    protected final void checkSize(final DoubleMatrixInterface<?, ?, ?, ?> other) throws ValueRuntimeException
    {
        Throw.whenNull(other, "Other matrix is null");
        Throw.when(size() != other.size(), ValueRuntimeException.class, "The matrixs have different sizes: %d != %d", size(),
                other.size());
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public int hashCode()
    {
        final int prime = 31;
        int result = getUnit().getStandardUnit().hashCode();
        result = prime * result + ((this.data == null) ? 0 : this.data.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({"checkstyle:designforextension", "checkstyle:needbraces"})
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractDoubleMatrix<?, ?, ?, ?> other = (AbstractDoubleMatrix<?, ?, ?, ?>) obj;
        if (!getUnit().getStandardUnit().equals(other.getUnit().getStandardUnit()))
            return false;
        if (this.data == null)
        {
            if (other.data != null)
                return false;
        }
        else if (!this.data.equals(other.data))
            return false;
        return true;
    }

    /* ============================================================================================ */
    /* =============================== ITERATOR METHODS AND CLASS ================================= */
    /* ============================================================================================ */

    /** {@inheritDoc} */
    @Override
    public Iterator<S> iterator()
    {
        return new Itr();
    }

    /**
     * The iterator class is loosely based in AbstractList.Itr. It does not throw a ConcurrentModificationException, because the
     * size of the matrix does not change. Normal (non-mutable) matrixs cannot change their size, nor their content. The only
     * thing for the MutableMatrix that can change is its content, not its length.
     */
    protected class Itr implements Iterator<S>
    {
        /** index of next element to return. */
        private int cursor = 0;

        /** {@inheritDoc} */
        @Override
        public boolean hasNext()
        {
            return this.cursor != size();
        }

        /** {@inheritDoc} */
        @Override
        public S next()
        {
            if (this.cursor >= size())
            {
                throw new NoSuchElementException();
            }
            try
            {
                int i = this.cursor;
                S next = get(i);
                this.cursor = i + 1;
                return next;
            }
            catch (ValueRuntimeException exception)
            {
                throw new RuntimeException(exception);
            }
        }

        /** {@inheritDoc} */
        @Override
        public void remove()
        {
            throw new RuntimeException("Remove function cannot be applied on fixed-size DJUNITS Matrix");
        }
    }

}
