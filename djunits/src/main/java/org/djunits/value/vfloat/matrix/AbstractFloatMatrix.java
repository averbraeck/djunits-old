package org.djunits.value.vfloat.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.AbstractValue;
import org.djunits.value.Mutable;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.formatter.Format;
import org.ojalgo.access.Access2D.Factory;
import org.ojalgo.matrix.BasicMatrix;
import org.ojalgo.matrix.PrimitiveMatrix;

/**
 * The most basic abstract class for the FloatMatrix.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 16, 2016 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
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
     * @param unit the unit
     * @param data an internal data object
     */
    AbstractFloatMatrix(final U unit, final FloatMatrixData data)
    {
        super(unit);
        this.data = data;
    }

    /**
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

    /**
     * Create a float[][] array filled with the values in the standard SI unit.
     * @return float[][]; array of values in the standard SI unit
     */
    public final float[][] getValuesSI()
    {
        return this.data.getDenseMatrixSI();
    }

    /**
     * Create a float[][] array filled with the values in the original unit.
     * @return float[][]; the values in the original unit
     */
    public final float[][] getValuesInUnit()
    {
        return getValuesInUnit(getUnit());
    }

    /**
     * Create a float[][] array filled with the values converted into a specified unit.
     * @param targetUnit U; the unit into which the values are converted for use
     * @return float[][]; the values converted into the specified unit
     */
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
    public final float getSI(final int row, final int column) throws ValueException
    {
        checkIndex(row, column);
        return this.data.getSI(row, column);
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit(final int row, final int column) throws ValueException
    {
        return (float) expressAsSpecifiedUnit(getSI(row, column));
    }

    /** {@inheritDoc} */
    @Override
    public final float getInUnit(final int row, final int column, final U targetUnit) throws ValueException
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

    /**
     * Print this FloatMatrix with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @return String; printable string with the matrix contents expressed in the specified unit
     */
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /**
     * Print this FloatMatrix with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the matrix contents
     */
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /**
     * Print this FloatMatrix with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the matrix contents
     */
    public final String toString(final U displayUnit, final boolean verbose, final boolean withUnit)
    {
        StringBuffer buf = new StringBuffer();
        if (verbose)
        {
            String ab = this instanceof Absolute ? "Abs " : "Rel ";
            String ds = this.data.isDense() ? "Dense  " : this.data.isSparse() ? "Sparse " : "?????? ";
            if (this instanceof Mutable)
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
                catch (ValueException ve)
                {
                    buf.append(" " + "********************".substring(0, Format.DEFAULTSIZE));
                }
            }
        }
        buf.append("\n");
        if (withUnit)
        {
            buf.append(displayUnit.getAbbreviation());
        }
        return buf.toString();
    }

    /**
     * Check that a 2D array of float is not null and rectangular; i.e. all rows have the same length.
     * @param values float[][]; the 2D array to check
     * @return the values in case the method is used in a constructor
     * @throws ValueException when not all rows have the same length
     */
    protected static float[][] ensureRectangularAndNonEmpty(final float[][] values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("Cannot create a FloatVector or MutableFloatVector from a null array of float[][]");
        }
        if (values.length > 0 && null == values[0])
        {
            throw new ValueException("Creating FloatVector or MutableFloatVector: Row 0 is null");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (null == values[row] || values[0].length != values[row].length)
            {
                throw new ValueException("Creating FloatVector or MutableFloatVector: Lengths of rows are not all the same");
            }
        }
        return values;
    }

    /**
     * Centralized size equality check.
     * @param other FloatMatrix&lt;?&gt;; other FloatMatrix
     * @throws ValueException when other is null, or matrices have unequal size
     */
    protected final void checkSize(final AbstractFloatMatrixRel<?, ?, ?, ?> other) throws ValueException
    {
        if (null == other)
        {
            throw new ValueException("other is null");
        }
        if (rows() != other.rows() || columns() != other.columns())
        {
            throw new ValueException("The matrices have different sizes: " + rows() + "x" + columns() + " != " + other.rows()
                    + "x" + other.columns());
        }
    }

    /**
     * Centralized size equality check.
     * @param other float[][]; array of float
     * @throws ValueException when matrices have unequal size
     */
    protected final void checkSize(final float[][] other) throws ValueException
    {
        ensureRectangularAndNonEmpty(other);
        final int otherColumns = other[0].length;
        if (rows() != other.length || columns() != otherColumns)
        {
            throw new ValueException("The matrix and the array have different sizes: " + rows() + "x" + columns() + " != "
                    + other.length + "x" + otherColumns);
        }
    }

    /**
     * Check that provided row and column indices are valid.
     * @param row int; the row value to check
     * @param column int; the column value to check
     * @throws ValueException when row or column is invalid
     */
    protected final void checkIndex(final int row, final int column) throws ValueException
    {
        if (row < 0 || row >= rows() || column < 0 || column >= columns())
        {
            throw new ValueException("index out of range (valid range is 0.." + (rows() - 1) + ", 0.." + (columns() - 1)
                    + ", got " + row + ", " + column + ")");
        }
    }

    /** {@inheritDoc} */
    @Override
    public final float determinant() throws ValueException
    {
        try
        {
            final Factory<PrimitiveMatrix> matrixFactory = PrimitiveMatrix.FACTORY;
            final BasicMatrix m = matrixFactory.rows(this.data.getDoubleDenseMatrixSI());
            return (float) m.getDeterminant().doubleValue();
        }
        catch (IllegalArgumentException exception)
        {
            throw new ValueException(exception); // Matrix must be square
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
    @SuppressWarnings({ "checkstyle:designforextension", "checkstyle:needbraces", "unchecked" })
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
