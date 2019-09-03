package org.djunits4.value.vdouble.matrix;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.djunits4.unit.scale.Scale;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.DoubleScalarInterface;

/**
 * Stores the data for a DoubleMatrix and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
abstract class DoubleMatrixData implements Serializable
{
    /** */
    private static final long serialVersionUID = 1L;

    /** the internal storage of the Matrix; can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected double[] matrixSI;

    /** the number of rows of the matrix. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected int rows;

    /** the number of columns of the matrix. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected int cols;

    /** the data type. */
    private final StorageType storageType;

    /**
     * Construct a new DoubleMatrixData store.
     * @param storageType StorageType; the data type
     */
    DoubleMatrixData(final StorageType storageType)
    {
        super();
        this.storageType = storageType;
    }

    /* ============================================================================================ */
    /* ====================================== INSTANTIATION ======================================= */
    /* ============================================================================================ */

    /**
     * Instantiate a DoubleMatrixData with the right data type.
     * @param values double[][]; the (SI) values to store
     * @param scale Scale; the scale of the unit to use for conversion to SI
     * @param storageType StorageType; the data type to use
     * @return the DoubleMatrixData with the right data type
     * @throws ValueException when values are null, or storageType is null
     */
    public static DoubleMatrixData instantiate(final double[][] values, final Scale scale, final StorageType storageType)
            throws ValueException
    {
        if (values == null || values.length == 0 || values[0].length == 0)
        {
            throw new ValueException("DoubleMatrixData.instantiate: double[][] values is null or "
                    + "values.length == 0 or values[0].length == 0");
        }

        final int rows = values.length;
        final int cols = values[0].length;

        switch (storageType)
        {
            case DENSE:
                double[] valuesSI = new double[rows * cols];
                IntStream.range(0, values.length).parallel().forEach(r -> IntStream.range(0, cols)
                        .forEach(c -> valuesSI[r * cols + c] = scale.toStandardUnit(values[r][c])));
                return new DoubleMatrixDataDense(valuesSI, rows, cols);

            case SPARSE:
                double[][] matrixSI = new double[rows][cols];
                IntStream.range(0, values.length).parallel().forEach(
                        r -> IntStream.range(0, cols).forEach(c -> matrixSI[r][c] = scale.toStandardUnit(values[r][c])));
                return DoubleMatrixDataSparse.instantiate(matrixSI);

            default:
                throw new ValueException("Unknown data type in DoubleMatrixData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a DoubleMatrixData with the right data type.
     * @param values DoubleScalarInterface[][]; the values to store
     * @param storageType StorageType; the data type to use
     * @return the DoubleMatrixData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static DoubleMatrixData instantiate(final DoubleScalarInterface[][] values, final StorageType storageType)
            throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("DoubleMatrixData.instantiate: DoubleScalar[] values is null");
        }

        if (values == null || values.length == 0 || values[0].length == 0)
        {
            throw new ValueException("DoubleMatrixData.instantiate: DoubleScalar[][] values is null or "
                    + "values.length == 0 or values[0].length == 0");
        }

        final int rows = values.length;
        final int cols = values[0].length;

        switch (storageType)
        {
            case DENSE:
                double[] valuesSI = new double[rows * cols];
                IntStream.range(0, rows).parallel()
                        .forEach(r -> IntStream.range(0, cols).forEach(c -> valuesSI[r * cols + c] = values[r][c].getSI()));
                return new DoubleMatrixDataDense(valuesSI, rows, cols);

            case SPARSE:
                double[][] matrixSI = new double[rows][cols];
                IntStream.range(0, values.length).parallel()
                        .forEach(r -> IntStream.range(0, cols).forEach(c -> matrixSI[r][c] = values[r][c].getSI()));
                return DoubleMatrixDataSparse.instantiate(matrixSI);

            default:
                throw new ValueException("Unknown data type in DoubleMatrixData.instantiate: " + storageType);
        }
    }

    /* ============================================================================================ */
    /* ==================================== UTILITY FUNCTIONS ===================================== */
    /* ============================================================================================ */

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored Matrix.
     * @return the StorageType (DENSE, SPARSE, etc.) for the stored Matrix
     */
    public final StorageType getStorageType()
    {
        return this.storageType;
    }

    /**
     * Retrieve the row count.
     * @return int; the number of rows of the matrix
     */
    public int rows()
    {
        return this.rows;
    }

    /**
     * Retrieve the column count.
     * @return int; the number of columns of the matrix
     */
    public int cols()
    {
        return this.cols;
    }

    /**
     * Is this matrix sparse?
     * @return boolean; true if the data storage type is sparse; false if the data storage type is not sparse
     */
    public boolean isSparse()
    {
        return this.storageType.equals(StorageType.SPARSE);
    }

    /**
     * Return the data of this matrix in sparse storage format.
     * @return DoubleMatrixDataSparse; the sparse transformation of this data
     */
    public DoubleMatrixDataSparse toSparse()
    {
        return isSparse() ? (DoubleMatrixDataSparse) this : ((DoubleMatrixDataDense) this).toSparse();
    }

    /**
     * Is this matrix dense?
     * @return boolean; true if the data storage type is dense; false if the data storage type is not dense
     */
    public boolean isDense()
    {
        return this.storageType.equals(StorageType.DENSE);
    }

    /**
     * Return the data of this matrix in dense storage format.
     * @return DoubleMatrixDataDense; the dense transformation of this data
     */
    public DoubleMatrixDataDense toDense()
    {
        return isDense() ? (DoubleMatrixDataDense) this : ((DoubleMatrixDataSparse) this).toDense();
    }

    /**
     * Retrieve one value from this data.
     * @param row int; the row number to get the value for
     * @param col int; the column number to get the value for
     * @return the value at the [row, col] point
     */
    public abstract double getSI(int row, int col);

    /**
     * Sets a value at the [row, col] point in the matrix.
     * @param row int; the row number to set the value for
     * @param col int; the column number to set the value for
     * @param valueSI double; the value at the index
     */
    public abstract void setSI(int row, int col, double valueSI);

    /**
     * Compute and return the number of non-zero cells in this matrix.
     * @return int; the number of non-zero cells
     */
    public final int cardinality()
    {
        return (int) Arrays.stream(this.matrixSI).parallel().filter(d -> d != 0.0).count();
    }

    /**
     * Compute and return the sum of the values of all cells of this matrix.
     * @return double; the sum of the values of all cells
     */
    public final double zSum()
    {
        return Arrays.stream(this.matrixSI).parallel().sum();
    }

    /**
     * Create and return a deep copy of the data.
     * @return DoubleMatrixData; a deep copy of the data
     */
    public abstract DoubleMatrixData copy();

    /**
     * Create and return a deep copy of the data in dense format.
     * @return double[][]; a safe, dense copy of matrixSI as a matrix
     */
    public abstract double[][] getDenseMatrixSI();

    /**
     * Check the sizes of this data object and the other data object.
     * @param other DoubleMatrixData; the other data object
     * @throws ValueException if matrices have different lengths
     */
    private void checkSizes(final DoubleMatrixData other) throws ValueException
    {
        if (this.rows() != other.rows() || this.cols() != other.cols())
        {
            throw new ValueException("Two data objects used in a DoubleMatrix operation do not have the same size");
        }
    }

    /* ============================================================================================ */
    /* ================================== CALCULATION FUNCTIONS =================================== */
    /* ============================================================================================ */

    /**
     * Add two matrices on a cell-by-cell basis. If both matrices are sparse, a sparse matrix is returned, otherwise a dense
     * matrix is returned.
     * @param right DoubleMatrixData; the other data object to add
     * @return the sum of this data object and the other data object
     * @throws ValueException if matrices have different lengths
     */
    public DoubleMatrixData plus(final DoubleMatrixData right) throws ValueException
    {
        checkSizes(right);
        double[] dm = new double[this.rows * this.cols];
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> dm[r * this.cols + c] = getSI(r, c) + right.getSI(r, c)));
        if (this instanceof DoubleMatrixDataSparse && right instanceof DoubleMatrixDataSparse)
        {
            return new DoubleMatrixDataDense(dm, this.rows, this.cols).toSparse();
        }
        return new DoubleMatrixDataDense(dm, this.rows, this.cols);
    }

    /**
     * Add a matrix to this matrix on a cell-by-cell basis. The type of matrix (sparse, dense) stays the same.
     * @param right DoubleMatrixData; the other data object to add
     * @throws ValueException if matrices have different lengths
     */
    public abstract void incrementBy(DoubleMatrixData right) throws ValueException;

    /**
     * Add a number to this matrix on a cell-by-cell basis.
     * @param valueSI double; the value to add
     */
    public void incrementBy(final double valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] += valueSI);
    }

    /**
     * Subtract two matrices on a cell-by-cell basis. If both matrices are sparse, a sparse matrix is returned, otherwise a
     * dense matrix is returned.
     * @param right DoubleMatrixData; the other data object to subtract
     * @return the sum of this data object and the other data object
     * @throws ValueException if matrices have different lengths
     */
    public DoubleMatrixData minus(final DoubleMatrixData right) throws ValueException
    {
        checkSizes(right);
        double[] dm = new double[this.rows * this.cols];
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> dm[r * this.cols + c] = getSI(r, c) - right.getSI(r, c)));
        if (this instanceof DoubleMatrixDataSparse && right instanceof DoubleMatrixDataSparse)
        {
            return new DoubleMatrixDataDense(dm, this.rows, this.cols).toSparse();
        }
        return new DoubleMatrixDataDense(dm, this.rows, this.cols);
    }

    /**
     * Subtract a matrix from this matrix on a cell-by-cell basis. The type of matrix (sparse, dense) stays the same.
     * @param right DoubleMatrixData; the other data object to subtract
     * @throws ValueException if matrices have different sizes
     */
    public abstract void decrementBy(DoubleMatrixData right) throws ValueException;

    /**
     * Subtract a number from this matrix on a cell-by-cell basis.
     * @param valueSI double; the value to subtract
     */
    public void decrementBy(final double valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] -= valueSI);
    }

    /**
     * Multiply two matrix on a cell-by-cell basis. If both matrices are dense, a dense matrix is returned, otherwise a sparse
     * matrix is returned.
     * @param right DoubleMatrixData; the other data object to multiply with
     * @return the sum of this data object and the other data object
     * @throws ValueException if matrices have different sizes
     */
    public DoubleMatrixData times(final DoubleMatrixData right) throws ValueException
    {
        checkSizes(right);
        double[] dm = new double[this.rows * this.cols];
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> dm[r * this.cols + c] = getSI(r, c) * right.getSI(r, c)));
        if (this instanceof DoubleMatrixDataDense && right instanceof DoubleMatrixDataDense)
        {
            return new DoubleMatrixDataDense(dm, this.rows, this.cols);
        }
        return new DoubleMatrixDataDense(dm, this.rows, this.cols).toSparse();
    }

    /**
     * Multiply a matrix with the values of another matrix on a cell-by-cell basis. The type of matrix (sparse, dense) stays the
     * same.
     * @param right DoubleMatrixData; the other data object to multiply with
     * @throws ValueException if matrices have different lengths
     */
    public abstract void multiplyBy(DoubleMatrixData right) throws ValueException;

    /**
     * Multiply the values of this matrix with a number on a cell-by-cell basis.
     * @param valueSI double; the value to multiply with
     */
    public void multiplyBy(final double valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] *= valueSI);
    }

    /**
     * Divide two matrices on a cell-by-cell basis. If both matrices are dense, a dense matrix is returned, otherwise a sparse
     * matrix is returned.
     * @param right DoubleMatrixData; the other data object to divide by
     * @return the ratio of this data object and the other data object on a value by value basis
     * @throws ValueException if matrices have different sizes
     */
    public DoubleMatrixData divide(final DoubleMatrixData right) throws ValueException
    {
        checkSizes(right);
        double[] dm = new double[this.rows * this.cols];
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> dm[r * this.cols + c] = getSI(r, c) / right.getSI(r, c)));
        if (this instanceof DoubleMatrixDataSparse && right instanceof DoubleMatrixDataSparse)
        {
            return new DoubleMatrixDataSparse(dm, this.rows, this.cols);
        }
        return new DoubleMatrixDataDense(dm, this.rows, this.cols).toSparse();
    }

    /**
     * Divide the values of a matrix by the values of another matrix on a cell-by-cell basis. The type of matrix (sparse, dense)
     * stays the same.
     * @param right DoubleMatrixData; the other data object to divide by
     * @throws ValueException if matrices have different sizes
     */
    public abstract void divideBy(DoubleMatrixData right) throws ValueException;

    /**
     * Divide the values of this matrix by a number on a cell-by-cell basis.
     * @param valueSI double; the value to multiply with
     */
    public void divideBy(final double valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] /= valueSI);
    }

    /* ============================================================================================ */
    /* =============================== EQUALS, HASHCODE, TOSTRING ================================= */
    /* ============================================================================================ */

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.rows;
        result = prime * result + this.cols;
        result = prime * result + ((this.storageType == null) ? 0 : this.storageType.hashCode());
        result = prime * result + Arrays.hashCode(this.matrixSI);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:needbraces")
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DoubleMatrixData other = (DoubleMatrixData) obj;
        if (this.rows != other.rows)
            return false;
        if (this.cols != other.cols)
            return false;
        if (this.storageType != other.storageType)
            return false;
        if (!Arrays.equals(this.matrixSI, other.matrixSI))
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "DoubleMatrixData [storageType=" + this.storageType + ", matrixSI=" + Arrays.toString(this.matrixSI) + "]";
    }

}
