package org.djunits4.value.vdouble.matrix.base;

import java.lang.reflect.Array;

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
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixDataDense;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixDataSparse;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;
import org.djunits4.value.vdouble.scalar.base.DoubleScalar;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVector;
import org.djunits4.value.vdouble.vector.base.DoubleVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;
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
 * @param <V> the vector type belonging to the matrix type
 * @param <M> the generic matrix type
 */
public abstract class AbstractDoubleMatrix<U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
        V extends AbstractDoubleVector<U, S, V>, M extends AbstractDoubleMatrix<U, S, V, M>> extends AbstractValue<U, M>
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
     * @throws ValueRuntimeException if the matrix is immutable
     */
    protected final void checkCopyOnWrite()
    {
        Throw.when(!this.mutable, ValueRuntimeException.class, "Immutable Matrix cannot be modified");
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
    @Override
    public M immutable()
    {
        if (this.mutable)
        {
            setCopyOnWrite(true);
        }
        M result = DoubleMatrix.instantiate(this.data, getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        result.setCopyOnWrite(false);
        result.setMutable(false);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public M mutable()
    {
        if (this.mutable)
        {
            setCopyOnWrite(true);
        }
        M result = DoubleMatrix.instantiate(this.data, getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        result.setCopyOnWrite(true);
        result.setMutable(true);
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    protected AbstractDoubleMatrix<U, S, V, M> clone() throws CloneNotSupportedException
    {
        return (AbstractDoubleMatrix<U, S, V, M>) super.clone();
    }

    /**
     * Set helper flag to indicate whether the data is mutable or not.
     * @param mutable boolean; helper flag to indicate whether the data is mutable or not
     */
    protected void setMutable(final boolean mutable)
    {
        this.mutable = mutable;
    }

    /** {@inheritDoc} */
    @Override
    public double getSI(int row, int column) throws ValueRuntimeException
    {
        checkIndex(row, column);
        return this.data.getSI(row, column);
    }

    /** {@inheritDoc} */
    @Override
    public double getInUnit(int row, int column) throws ValueRuntimeException
    {
        checkIndex(row, column);
        return ValueUtil.expressAsUnit(this.data.getSI(row, column), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public double getInUnit(int row, int column, U targetUnit) throws ValueRuntimeException
    {
        checkIndex(row, column);
        return ValueUtil.expressAsUnit(this.data.getSI(row, column), targetUnit);
    }
    
    /** {@inheritDoc} */
    @Override
    public void setSI(final int row, final int column, final double valueSI) throws ValueRuntimeException
    {
        checkIndex(row, column);
        checkCopyOnWrite();
        this.data.setSI(row, column, valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public void setInUnit(final int row, final int column, final double valueInUnit) throws ValueRuntimeException
    {
        setSI(row, column, ValueUtil.expressAsSIUnit(valueInUnit, getUnit()));
    }

    /** {@inheritDoc} */
    @Override
    public void setInUnit(final int row, final int column, final double valueInUnit, final U valueUnit) throws ValueRuntimeException
    {
        setSI(row, column, ValueUtil.expressAsSIUnit(valueInUnit, valueUnit));
    }

    /** {@inheritDoc} */
    @Override
    public void set(final int row, final int column, final S value) throws ValueRuntimeException
    {
        setSI(row, column, value.si);
    }

    /** {@inheritDoc} */
    @Override
    public double[] getRowSI(int row) throws ValueRuntimeException
    {
        checkRowIndex(row);
        double[] result = new double[this.data.cols()];
        for (int col = 0; col < result.length; col++)
        {
            result[col] = this.data.getSI(row, col);
        }
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public double[] getColumnSI(int column) throws ValueRuntimeException
    {
        checkColumnIndex(column);
        double[] result = new double[this.data.rows()];
        for (int row = 0; row < result.length; row++)
        {
            result[row] = this.data.getSI(row, column);
        }
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public double[] getDiagonalSI() throws ValueRuntimeException
    {
        checkSquare();
        double[] result = new double[this.data.rows()];
        for (int row = 0; row < result.length; row++)
        {
            result[row] = this.data.getSI(row, row);
        }
        return result;
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
        for (int i = values.length; --i >= 0;)
        {
            for (int j = values[i].length; --j >= 0;)
            {
                values[i][j] = ValueUtil.expressAsUnit(values[i][j], targetUnit);
            }
        }
        return values;
    }

    /** {@inheritDoc} */
    @Override
    public int rows()
    {
        return this.data.rows();
    }

    /** {@inheritDoc} */
    @Override
    public int cols()
    {
        return this.data.cols();
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public S[][] getScalars()
    {
        S[][] array = (S[][]) Array.newInstance(getScalarClass(), rows());
        for (int i = 0; i < rows(); i++)
        {
            S[] row = (S[]) Array.newInstance(getScalarClass(), cols());
            array[i] = row;
            for (int j = 0; j < cols(); j++)
            {
                row[j] = get(i, j);
            }
        }
        return array;
    }

    /** {@inheritDoc} */
    @Override
    public final int cardinality()
    {
        return this.data.cardinality();
    }

    /** {@inheritDoc} */
    @Override
    public S get(final int row, final int column) throws ValueRuntimeException
    {
        checkIndex(row, column);
        return DoubleScalar.instantiateSI(getSI(row, column), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public V getRow(final int row) throws ValueRuntimeException
    {
        checkRowIndex(row);
        DoubleVectorData dvd =
                DoubleVectorData.instantiate(getRowSI(row), getUnit().getStandardUnit().getScale(), getStorageType());
        V result = DoubleVector.instantiate(dvd, getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public V getColumn(final int column) throws ValueRuntimeException
    {
        checkColumnIndex(column);
        DoubleVectorData dvd =
                DoubleVectorData.instantiate(getColumnSI(column), getUnit().getStandardUnit().getScale(), getStorageType());
        V result = DoubleVector.instantiate(dvd, getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public V getDiagonal() throws ValueRuntimeException
    {
        checkSquare();
        DoubleVectorData dvd =
                DoubleVectorData.instantiate(getDiagonalSI(), getUnit().getStandardUnit().getScale(), getStorageType());
        V result = DoubleVector.instantiate(dvd, getUnit().getStandardUnit());
        result.setDisplayUnit(getUnit());
        return result;

    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public S[] getRowScalars(int row) throws ValueRuntimeException
    {
        checkRowIndex(row);
        S[] array = (S[]) Array.newInstance(getScalarClass(), cols());
        for (int col = 0; col < cols(); col++)
        {
            array[col] = get(row, col);
        }
        return array;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public S[] getColumnScalars(int col) throws ValueRuntimeException
    {
        checkColumnIndex(col);
        S[] array = (S[]) Array.newInstance(getScalarClass(), rows());
        for (int row = 0; row < rows(); row++)
        {
            array[row] = get(row, col);
        }
        return array;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public S[] getDiagonalScalars() throws ValueRuntimeException
    {
        checkSquare();
        S[] array = (S[]) Array.newInstance(getScalarClass(), rows());
        for (int row = 0; row < rows(); row++)
        {
            array[row] = get(row, row);
        }
        return array;
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
    public M incrementBy(final S increment)
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.INC(increment.si));
        return (M) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public M decrementBy(final S decrement)
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.DEC(decrement.si));
        return (M) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final M abs()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.ABS);
        return (M) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final M ceil()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.CEIL);
        return (M) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final M floor()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.FLOOR);
        return (M) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final M neg()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.NEG);
        return (M) this;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public final M rint()
    {
        checkCopyOnWrite();
        assign(DoubleMathFunctions.RINT);
        return (M) this;
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
            if (this.mutable)
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
            for (int col = 0; col < cols(); col++)
            {
                try
                {
                    double d = ValueUtil.expressAsUnit(getSI(row, col), displayUnit);
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
    protected final void checkSize(final AbstractDoubleMatrix<?, ?, ?, ?> other) throws ValueRuntimeException
    {
        if (null == other)
        {
            throw new ValueRuntimeException("other is null");
        }
        if (rows() != other.rows() || cols() != other.cols())
        {
            throw new ValueRuntimeException(
                    "The matrices have different sizes: " + rows() + "x" + cols() + " != " + other.rows() + "x" + other.cols());
        }
    }

    /**
     * Check that a 2D array of double is not null, not empty and not jagged; i.e. all rows have the same length.
     * @param values double[][]; the 2D array to check
     * @return the values in case the method is used in a constructor
     * @throws ValueRuntimeException when <code>values</code> is null, empty, or jagged
     */
    protected static double[][] checkRectangularAndNonEmpty(final double[][] values) throws ValueRuntimeException
    {
        if (null == values)
        {
            throw new ValueRuntimeException(
                    "Cannot create a DoubleVector or MutableDoubleVector from a null array of double[][]");
        }
        if (values.length > 0 && null == values[0])
        {
            throw new ValueRuntimeException("Creating DoubleVector or MutableDoubleVector: Row 0 is null");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (null == values[row] || values[0].length != values[row].length)
            {
                throw new ValueRuntimeException(
                        "Creating DoubleVector or MutableDoubleVector: Lengths of rows are not all the same");
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
        checkRectangularAndNonEmpty(other);
        final int otherCols = other[0].length;
        if (rows() != other.length || cols() != otherCols)
        {
            throw new ValueRuntimeException("The matrix and the array have different sizes: " + rows() + "x" + cols() + " != "
                    + other.length + "x" + otherCols);
        }
    }

    /**
     * Check that provided row and column indices are valid.
     * @param row int; the row value to check
     * @param col int; the column value to check
     * @throws ValueRuntimeException when row or column is invalid
     */
    protected final void checkIndex(final int row, final int col) throws ValueRuntimeException
    {
        if (row < 0 || row >= rows() || col < 0 || col >= cols())
        {
            throw new ValueRuntimeException("index out of range (valid range is 0.." + (rows() - 1) + ", 0.." + (cols() - 1)
                    + ", got " + row + ", " + col + ")");
        }
    }

    /**
     * Check that provided row index is valid.
     * @param row int; the row value to check
     * @throws ValueRuntimeException when row is invalid
     */
    protected final void checkRowIndex(final int row) throws ValueRuntimeException
    {
        if (row < 0 || row >= rows())
        {
            throw new ValueRuntimeException("row index out of range (valid range is 0.." + (rows() - 1) + ", got " + row + ")");
        }
    }

    /**
     * Check that provided column index is valid.
     * @param col int; the column value to check
     * @throws ValueRuntimeException when row is invalid
     */
    protected final void checkColumnIndex(final int col) throws ValueRuntimeException
    {
        if (col < 0 || col >= cols())
        {
            throw new ValueRuntimeException(
                    "column index out of range (valid range is 0.." + (cols() - 1) + ", got " + col + ")");
        }
    }

    /**
     * Check that the matrix is square.
     * @throws ValueRuntimeException when matrix is not square
     */
    protected final void checkSquare() throws ValueRuntimeException
    {
        Throw.when(rows() != cols(), ValueRuntimeException.class, "Matrix is not square, rows=%d, cols=%d", rows(), cols());
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
}
