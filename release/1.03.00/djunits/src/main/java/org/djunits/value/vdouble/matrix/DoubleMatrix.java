package org.djunits.value.vdouble.matrix;

import java.io.Serializable;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.AbstractValue;
import org.djunits.value.FunctionsAbs;
import org.djunits.value.FunctionsRel;
import org.djunits.value.Relative;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.formatter.Format;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.ojalgo.access.Access2D.Factory;
import org.ojalgo.matrix.BasicMatrix;
import org.ojalgo.matrix.PrimitiveMatrix;

/**
 * Immutable DoubleMatrix.
 * <p>
 * This file was generated by the djunits value classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> Unit; the unit of this DoubleMatrix
 */
public abstract class DoubleMatrix<U extends Unit<U>> extends AbstractValue<U> implements Serializable,
        DoubleMatrixInterface<U>
{
    /**  */
    private static final long serialVersionUID = 20151003L;

    /** The stored data as an object, can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected DoubleMatrixData data;

    /**
     * @return the internal data -- can only be used within package and by subclasses.
     */
    protected final DoubleMatrixData getData()
    {
        return this.data;
    }

    /**
     * Construct a new Immutable DoubleMatrix.
     * @param unit U; the unit of the new DoubleMatrix
     */
    protected DoubleMatrix(final U unit)
    {
        super(unit);
    }

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored Vector.
     * @return the StorageType (DENSE, SPARSE, etc.) for the stored Vector
     */
    public final StorageType getStorageType()
    {
        return this.data.getStorageType();
    }

    /* ============================================================================================ */
    /* ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * ABSOLUTE implementation of DoubleMatrix.
     * @param <U> Unit the unit for which this Matrix will be created
     */
    public static class Abs<U extends Unit<U>> extends DoubleMatrix<U> implements Absolute,
            FunctionsAbs<U, DoubleMatrix.Abs<U>, DoubleMatrix.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Immutable DoubleMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Immutable DoubleMatrix
         * @param unit U; the unit of the new Absolute Immutable DoubleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            ensureRectangularAndNonEmpty(values);
            this.data = DoubleMatrixData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Absolute Immutable DoubleMatrix.
         * @param values DoubleScalar.Abs&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable DoubleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final DoubleScalar.Abs<U>[][] values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = DoubleMatrixData.instantiate(values, storageType);
        }

        /**
         * Construct a new Absolute Immutable DoubleMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Abs(final DoubleMatrixData data, final U unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @SuppressWarnings("checkstyle:designforextension")
        @Override
        public MutableDoubleMatrix.Abs<U> mutable()
        {
            return MutableDoubleMatrix.instantiateMutableAbs(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Abs<U> toDense()
        {
            return this.data.isDense() ? this : instantiateAbs(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Abs<U> toSparse()
        {
            return this.data.isSparse() ? this : instantiateAbs(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleScalar.Abs<U> get(final int row, final int column) throws ValueException
        {
            return new DoubleScalar.Abs<U>(getInUnit(row, column, getUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Abs<U> plus(final DoubleMatrix.Rel<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Abs<U> minus(final DoubleMatrix.Rel<U> rel) throws ValueException
        {
            return instantiateAbs(this.getData().minus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Rel<U> minus(final DoubleMatrix.Abs<U> abs) throws ValueException
        {
            return instantiateRel(this.getData().minus(abs.getData()), getUnit());
        }
    }

    /* ============================================================================================ */
    /* ================================= RELATIVE IMPLEMENTATION ================================== */
    /* ============================================================================================ */

    /**
     * RELATIVE implementation of DoubleMatrix.
     * @param <U> Unit the unit for which this Matrix will be created
     */
    public static class Rel<U extends Unit<U>> extends DoubleMatrix<U> implements Relative,
            FunctionsRel<U, DoubleMatrix.Abs<U>, DoubleMatrix.Rel<U>>
    {
        /** */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative Immutable DoubleMatrix.
         * @param values double[][]; the values of the entries in the new Relative Immutable DoubleMatrix
         * @param unit U; the unit of the new Relative Immutable DoubleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(unit);
            ensureRectangularAndNonEmpty(values);
            this.data = DoubleMatrixData.instantiate(values, unit.getScale(), storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable DoubleMatrix
         * @param storageType the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final DoubleScalar.Rel<U>[][] values, final StorageType storageType) throws ValueException
        {
            super(checkUnit(values));
            this.data = DoubleMatrixData.instantiate(values, storageType);
        }

        /**
         * Construct a new Relative Immutable DoubleMatrix.
         * @param data an internal data object
         * @param unit the unit
         */
        Rel(final DoubleMatrixData data, final U unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @SuppressWarnings("checkstyle:designforextension")
        @Override
        public MutableDoubleMatrix.Rel<U> mutable()
        {
            return new MutableDoubleMatrix.Rel<U>(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Rel<U> toDense()
        {
            return this.data.isDense() ? this : instantiateRel(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Rel<U> toSparse()
        {
            return this.data.isSparse() ? this : instantiateRel(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleScalar.Rel<U> get(final int row, final int column) throws ValueException
        {
            return new DoubleScalar.Rel<U>(getInUnit(row, column, getUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Rel<U> plus(final DoubleMatrix.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().plus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public DoubleMatrix.Abs<U> plus(final DoubleMatrix.Abs<U> abs) throws ValueException
        {
            return instantiateAbs(this.getData().plus(abs.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final DoubleMatrix.Rel<U> minus(final DoubleMatrix.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().minus(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final DoubleMatrix.Rel<U> times(final DoubleMatrix.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().times(rel.getData()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public final DoubleMatrix.Rel<U> divide(final DoubleMatrix.Rel<U> rel) throws ValueException
        {
            return instantiateRel(this.getData().divide(rel.getData()), getUnit());
        }
    }

    /* ============================================================================================ */
    /* ============================= STATIC CONSTRUCTOR HELP METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Check that a provided array can be used to create some descendant of a DoubleMatrix, and return the Unit.
     * @param dsArray the array to check and get the unit for
     * @param <U> the unit
     * @return the unit of the object
     * @throws ValueException when the array is null, has length equal to 0, or has first entry with length equal to 0
     */
    static <U extends Unit<U>> U checkUnit(final DoubleScalar<U>[][] dsArray) throws ValueException
    {
        ensureRectangularAndNonEmpty(dsArray);
        return dsArray[0][0].getUnit();
    }

    /**
     * Check that a 2D array of double is not null and rectangular; i.e. all rows have the same length.
     * @param values double[][]; the 2D array to check
     * @throws ValueException when not all rows have the same length
     */
    protected static void ensureRectangularAndNonEmpty(final double[][] values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("Cannot create a DoubleVector or MutableDoubleVector from a null array of double[][]");
        }
        if (values.length > 0 && null == values[0])
        {
            throw new ValueException("Creating DoubleVector or MutableDoubleVector: Row 0 is null");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (null == values[row] || values[0].length != values[row].length)
            {
                throw new ValueException("Creating DoubleVector or MutableDoubleVector: Lengths of rows are not all the same");
            }
        }
    }

    /**
     * Check that a 2D array of DoubleScalar&lt;?&gt; is rectangular; i.e. all rows have the same length and is non empty.
     * @param values DoubleScalar&lt;?&gt;[][]; the 2D array to check
     * @throws ValueException when values is not rectangular, or contains no data
     */
    protected static void ensureRectangularAndNonEmpty(final DoubleScalar<?>[][] values) throws ValueException
    {
        if (null == values)
        {
            throw new ValueException("Cannot create a DoubleVector or MutableDoubleVector from an empty array of DoubleScalar");
        }
        if (0 == values.length || 0 == values[0].length)
        {
            throw new ValueException("Creating DoubleVector or MutableDoubleVector: "
                    + "Cannot determine unit for DoubleMatrix from an empty array of DoubleScalar");
        }
        for (int row = values.length; --row >= 1;)
        {
            if (values[0].length != values[row].length)
            {
                throw new ValueException("Creating DoubleVector or MutableDoubleVector: Lengths of rows are not all the same");
            }
        }
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dmData the DoubleMatrixData
     * @param unit the unit to use
     * @param <U> the unit
     * @return an instantiated vector
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> instantiateRel(final DoubleMatrixData dmData, final U unit)
    {
        return new DoubleMatrix.Rel<U>(dmData, unit);
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dmData the DoubleMatrixData
     * @param unit the unit to use
     * @param <U> the unit
     * @return an instantiated vector
     */
    static <U extends Unit<U>> DoubleMatrix.Abs<U> instantiateAbs(final DoubleMatrixData dmData, final U unit)
    {
        return new DoubleMatrix.Abs<U>(dmData, unit);
    }

    /* ============================================================================================ */
    /* =========================== STATIC CALCULATION MATRIX METHODS ============================== */
    /* ============================================================================================ */

    /**
     * Add the content of two matrices with a static method on a cell-by-cell basis; Abs + Rel = Abs.
     * @param left the first matrix
     * @param right the second matrix
     * @param <U> the unit
     * @return the sum of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Abs<U> plus(final DoubleMatrix.Abs<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().plus(right);
    }

    /**
     * Add the content of two matrices with a static method on a cell-by-cell basis; Rel + Rel = Rel.
     * @param left the first matrix
     * @param right the second matrix
     * @param <U> the unit
     * @return the sum of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> plus(final DoubleMatrix.Rel<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().plus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Abs - Rel = Abs.
     * @param left the first matrix
     * @param right the second matrix
     * @param <U> the unit
     * @return the difference of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Abs<U> minus(final DoubleMatrix.Abs<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().minus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Abs - Abs = Rel.
     * @param left the first matrix
     * @param right the second matrix
     * @param <U> the unit
     * @return the difference of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> minus(final DoubleMatrix.Abs<U> left, final DoubleMatrix.Abs<U> right)
            throws ValueException
    {
        return left.mutable().minus(right);
    }

    /**
     * Subtract the content of two matrices with a static method on a cell-by-cell basis; Rel - Rel = Rel.
     * @param left the first matrix
     * @param right the second matrix
     * @param <U> the unit
     * @return the difference of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> minus(final DoubleMatrix.Rel<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().minus(right);
    }

    /**
     * Multiply the content of two matrices with a static method on a cell-by-cell basis; Rel * Rel = Rel. The unit is not
     * changed by this method.
     * @param left the first matrix
     * @param right the second matrix
     * @param <U> the unit
     * @return the cell-by-cell multiplication of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> times(final DoubleMatrix.Rel<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().times(right);
    }

    /**
     * Divide the content of two matrices with a static method on a cell-by-cell basis; Rel / Rel = Rel. The unit is not changed
     * by this method.
     * @param left the first matrix
     * @param right the second matrix
     * @param <U> the unit
     * @return the cell-by-cell division of the two matrices
     * @throws ValueException when the two matrices have unequal size, or when one of the matrices is null or not well-formed
     */
    static <U extends Unit<U>> DoubleMatrix.Rel<U> divide(final DoubleMatrix.Rel<U> left, final DoubleMatrix.Rel<U> right)
            throws ValueException
    {
        return left.mutable().divide(right);
    }

    /* ============================================================================================ */
    /* ================================== GENERIC MATRIX METHODS ================================== */
    /* ============================================================================================ */

    /**
     * Create a double[][] array filled with the values in the standard SI unit.
     * @return double[][]; array of values in the standard SI unit
     */
    public final double[][] getValuesSI()
    {
        return this.data.getDenseMatrixSI();
    }

    /**
     * Create a double[][] array filled with the values in the original unit.
     * @return double[][]; the values in the original unit
     */
    public final double[][] getValuesInUnit()
    {
        return getValuesInUnit(getUnit());
    }

    /**
     * Create a double[][] array filled with the values converted into a specified unit.
     * @param targetUnit U; the unit into which the values are converted for use
     * @return double[][]; the values converted into the specified unit
     */
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
    public final double getSI(final int row, final int column) throws ValueException
    {
        checkIndex(row, column);
        return this.data.getSI(row, column);
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int row, final int column) throws ValueException
    {
        return expressAsSpecifiedUnit(getSI(row, column));
    }

    /** {@inheritDoc} */
    @Override
    public final double getInUnit(final int row, final int column, final U targetUnit) throws ValueException
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

    /**
     * Print this DoubleMatrix with the values expressed in the specified unit.
     * @param displayUnit U; the unit into which the values are converted for display
     * @return String; printable string with the matrix contents expressed in the specified unit
     */
    public final String toString(final U displayUnit)
    {
        return toString(displayUnit, false, true);
    }

    /**
     * Print this DoubleMatrix with optional type and unit information.
     * @param verbose boolean; if true; include type info; if false; exclude type info
     * @param withUnit boolean; if true; include the unit; of false; exclude the unit
     * @return String; printable string with the matrix contents
     */
    public final String toString(final boolean verbose, final boolean withUnit)
    {
        return toString(getUnit(), verbose, withUnit);
    }

    /**
     * Print this DoubleMatrix with the values expressed in the specified unit.
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
            String ab = this instanceof Absolute ? "Abs " : this instanceof Relative ? "Rel " : "??? ";
            String ds = this.data.isDense() ? "Dense  " : this.data.isSparse() ? "Sparse " : "?????? ";
            if (this instanceof MutableDoubleMatrix)
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
     * Centralized size equality check.
     * @param other DoubleMatrix&lt;?&gt;; other DoubleMatrix
     * @throws ValueException when other is null, or matrices have unequal size
     */
    protected final void checkSize(final DoubleMatrix<?> other) throws ValueException
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
     * @param other double[][]; array of double
     * @throws ValueException when matrices have unequal size
     */
    protected final void checkSize(final double[][] other) throws ValueException
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
    public final double determinant() throws ValueException
    {
        try
        {
            final Factory<PrimitiveMatrix> matrixFactory = PrimitiveMatrix.FACTORY;
            final BasicMatrix m = matrixFactory.rows(this.data.getDenseMatrixSI());
            return m.getDeterminant().doubleValue();
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
        int result = 1;
        result = prime * result + ((this.data == null) ? 0 : this.data.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings({ "checkstyle:needbraces", "checkstyle:designforextension" })
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoubleMatrix<?> other = (DoubleMatrix<?>) obj;
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
