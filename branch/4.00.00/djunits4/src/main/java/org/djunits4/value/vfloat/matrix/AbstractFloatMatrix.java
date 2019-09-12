package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.Unit;
import org.djunits4.value.Absolute;
import org.djunits4.value.AbstractValue;
import org.djunits4.value.IsMutable;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.formatter.Format;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.util.ValueUtil;
import org.ojalgo.matrix.PrimitiveMatrix;

/**
 * The most basic abstract class for the FloatMatrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit
 * @param <T> the type
 */
public abstract class AbstractFloatMatrix<U extends Unit<U>, T extends AbstractFloatMatrix<U, T>> extends AbstractValue<U>
        implements FloatMatrixInterface<U>
{
    /** */
    private static final long serialVersionUID = 20161015L;

    /** The stored data as an object, can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected FloatMatrixData data;

    /**
     * Construct a new FloatMatrix.
     * @param unit U; the unit
     * @param data FloatMatrixData; an internal data object
     */
    AbstractFloatMatrix(final U unit, final FloatMatrixData data)
    {
        super(unit);
        this.data = data;
    }

    /**
     * Retrieve the data.
     * @return the internal data -- can only be used within package and by subclasses.
     */
    protected final FloatMatrixData getData()
    {
        return this.data;
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
    public final float[][] getValuesSI()
    {
        return this.data.getDenseMatrixSI();
    }

    /** {@inheritDoc} */
    @Override
    public final float[][] getValuesInUnit()
    {
        return getValuesInUnit(getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final float[][] getValuesInUnit(final U targetUnit)
    {
        float[][] values = getValuesSI();
        for (int row = rows(); --row >= 0;)
        {
            for (int column = columns(); --column >= 0;)
            {
                values[row][column] = (float) ValueUtil.expressAsUnit(values[row][column], targetUnit);
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
    public final float getSI(final int row, final int column) throws ValueRuntimeException
    {
        checkIndex(row, column);
        return this.data.getSI(row, column);
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit(final int row, final int column) throws ValueRuntimeException
    {
        return (float) expressAsSpecifiedUnit(getSI(row, column));
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit(final int row, final int column, final U targetUnit) throws ValueRuntimeException
    {
        return (float) ValueUtil.expressAsUnit(getSI(row, column), targetUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final float zSum()
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
                    float d = (float) ValueUtil.expressAsUnit(getSI(row, column), displayUnit);
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
     * Check that a 2D array of float is not null,not empty and not jagged; i.e. all rows have the same length.
     * @param values float[][]; the 2D array to check
     * @return the values in case the method is used in a constructor
     * @throws ValueRuntimeException when <code>values</code> is null, empty, or jagged
     */
    protected static float[][] ensureRectangularAndNonEmpty(final float[][] values) throws ValueRuntimeException
    {
        if (null == values)
        {
            throw new ValueRuntimeException("Cannot create a FloatVector or MutableFloatVector from a null array of float[][]");
        }
        if (values.length > 0 && null == values[0])
        {
            throw new ValueRuntimeException("Creating FloatVector or MutableFloatVector: Row 0 is null");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (null == values[row] || values[0].length != values[row].length)
            {
                throw new ValueRuntimeException("Creating FloatVector or MutableFloatVector: Lengths of rows are not all the same");
            }
        }
        return values;
    }

    /**
     * Centralized size equality check.
     * @param other AbstractFloatMatrixRel&lt;?, ?, ?, ?&gt;; other FloatMatrix
     * @throws ValueRuntimeException when other is null, or matrices have unequal size
     */
    protected final void checkSize(final AbstractFloatMatrixRel<?, ?, ?, ?> other) throws ValueRuntimeException
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
     * Centralized size equality check.
     * @param other float[][]; array of float
     * @throws ValueRuntimeException when matrices have unequal size
     */
    protected final void checkSize(final float[][] other) throws ValueRuntimeException
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
    public final float determinant() throws ValueRuntimeException
    {
        try
        {
            final PrimitiveMatrix.Factory matrixFactory = PrimitiveMatrix.FACTORY;
            final PrimitiveMatrix m = matrixFactory.rows(this.data.getDoubleDenseMatrixSI());
            if (!m.isSquare())
            {
                throw new IllegalArgumentException("Matrix is not square -- determinant cannot be calculated.");
            }
            return (float) m.getDeterminant().doubleValue();
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
    @SuppressWarnings({"checkstyle:designforextension", "checkstyle:needbraces", "unchecked"})
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractFloatMatrix<U, T> other = (AbstractFloatMatrix<U, T>) obj;
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
