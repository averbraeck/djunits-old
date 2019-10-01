package org.djunits4.value.vfloat.matrix.data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

import org.djunits4.Throw;
import org.djunits4.unit.Unit;
import org.djunits4.unit.scale.Scale;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.AbstractStorage;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.matrix.base.FloatSparseValue;
import org.djunits4.value.vfloat.scalar.base.FloatScalarInterface;

/**
 * Stores the data for a FloatMatrix and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public abstract class FloatMatrixData extends AbstractStorage<FloatMatrixData> implements Serializable
{
    /** */
    private static final long serialVersionUID = 1L;

    /** the internal storage of the Matrix; can be sparse or dense. The data is stored in an array. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected float[] matrixSI;

    /** the number of rows of the matrix. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected int rows;

    /** the number of columns of the matrix. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected int cols;

    /**
     * Construct a new DoubleMatrixData store.
     * @param storageType StorageType; the data type
     */
    public FloatMatrixData(final StorageType storageType)
    {
        super(storageType);
    }

    /* ============================================================================================ */
    /* ====================================== INSTANTIATION ======================================= */
    /* ============================================================================================ */

    /**
     * Instantiate a FloatMatrixData with the right data type. The float array is of the form f[rows][columns] so each value can
     * be found with f[row][column].
     * @param values float[][]; the (SI) values to store
     * @param scale Scale; the scale of the unit to use for conversion to SI
     * @param storageType StorageType; the data type to use
     * @return the FloatMatrixData with the right data type
     * @throws ValueRuntimeException when values are null, or storageType is null
     */
    public static FloatMatrixData instantiate(final float[][] values, final Scale scale, final StorageType storageType)
            throws ValueRuntimeException
    {
        Throw.whenNull(scale, "FloatMatrixData.instantiate: scale is null");
        Throw.whenNull(storageType, "FloatMatrixData.instantiate: storageType is null");
        checkRectangularAndNonEmpty(values);

        final int rows = values.length;
        final int cols = values[0].length;

        switch (storageType)
        {
            case DENSE:
                float[] valuesSI = new float[rows * cols];
                IntStream.range(0, values.length).parallel().forEach(r -> IntStream.range(0, cols)
                        .forEach(c -> valuesSI[r * cols + c] = (float) scale.toStandardUnit(values[r][c])));
                return new FloatMatrixDataDense(valuesSI, rows, cols);

            case SPARSE:
                // TODO: too expensive, another copy of a probably already large matrix
                float[][] matrixSI = new float[rows][cols];
                IntStream.range(0, values.length).parallel().forEach(r -> IntStream.range(0, cols)
                        .forEach(c -> matrixSI[r][c] = (float) scale.toStandardUnit(values[r][c])));
                return FloatMatrixDataSparse.instantiate(matrixSI);

            default:
                throw new ValueRuntimeException("Unknown data type in FloatMatrixData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a FloatMatrixData with the right data type.
     * @param values Collection&lt;FloatSparseValue&lt;U, S&gt;&gt;; the (sparse [X, Y, SI]) values to store
     * @param rows int; the number of rows of the matrix
     * @param cols int; the number of columns of the matrix
     * @param storageType StorageType; the data type to use
     * @return the FloatMatrixData with the right data type
     * @throws ValueRuntimeException when values are null, or storageType is null
     */
    public static <U extends Unit<U>, S extends FloatScalarInterface<U, S>> FloatMatrixData instantiate(
            final Collection<FloatSparseValue<U, S>> values, final int rows, final int cols, final StorageType storageType)
            throws ValueRuntimeException
    {
        Throw.whenNull(values, "FloatMatrixData.instantiate: values is null");
        Throw.whenNull(storageType, "FloatMatrixData.instantiate: storageType is null");
        Throw.when(cols <= 0, ValueRuntimeException.class, "cols must be > 0");
        Throw.when(rows <= 0, ValueRuntimeException.class, "rows must be > 0");
        for (FloatSparseValue<U, S> fsp : values)
        {
            Throw.whenNull(fsp, "null value in values");
            Throw.when(fsp.getRow() < 0 || fsp.getRow() >= rows, ValueRuntimeException.class, "row out of range");
            Throw.when(fsp.getColumn() < 0 || fsp.getColumn() >= cols, ValueRuntimeException.class, "column out of range");
        }

        switch (storageType)
        {
            case DENSE:
                float[] valuesSI = new float[rows * cols];
                values.stream().parallel().forEach(v -> valuesSI[v.getRow() * cols + v.getColumn()] = v.getValueSI());
                return new FloatMatrixDataDense(valuesSI, rows, cols);

            case SPARSE:
                return new FloatMatrixDataSparse(values, rows, cols);

            default:
                throw new ValueRuntimeException("Unknown data type in FloatMatrixData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a FloatMatrixData with the right data type. The FloatScalar array is of the form fs[rows][columns] so each
     * value can be found with fs[row][column].
     * @param values FloatScalarInterface[][]; the values to store
     * @param storageType StorageType; the data type to use
     * @return the FloatMatrixData with the right data type
     * @throws ValueRuntimeException when values is null, or storageType is null
     */
    public static <U extends Unit<U>, S extends FloatScalarInterface<U, S>> FloatMatrixData instantiate(final S[][] values,
            final StorageType storageType) throws ValueRuntimeException
    {
        Throw.whenNull(storageType, "FloatMatrixData.instantiate: storageType is null");
        checkRectangularAndNonEmpty(values);

        final int rows = values.length;
        final int cols = values[0].length;

        switch (storageType)
        {
            case DENSE:
                float[] valuesSI = new float[rows * cols];
                IntStream.range(0, rows).parallel()
                        .forEach(r -> IntStream.range(0, cols).forEach(c -> valuesSI[r * cols + c] = values[r][c].getSI()));
                return new FloatMatrixDataDense(valuesSI, rows, cols);

            case SPARSE:
                float[][] matrixSI = new float[rows][cols];
                IntStream.range(0, values.length).parallel()
                        .forEach(r -> IntStream.range(0, cols).forEach(c -> matrixSI[r][c] = values[r][c].getSI()));
                return FloatMatrixDataSparse.instantiate(matrixSI);

            default:
                throw new ValueRuntimeException("Unknown data type in FloatMatrixData.instantiate: " + storageType);
        }
    }

    /* ============================================================================================ */
    /* ==================================== UTILITY FUNCTIONS ===================================== */
    /* ============================================================================================ */

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
     * Return the data of this matrix in sparse storage format.
     * @return FloatMatrixDataSparse; the sparse transformation of this data
     */
    public FloatMatrixDataSparse toSparse()
    {
        return isSparse() ? (FloatMatrixDataSparse) this : ((FloatMatrixDataDense) this).toSparse();
    }

    /**
     * Return the data of this matrix in dense storage format.
     * @return FloatMatrixDataDense; the dense transformation of this data
     */
    public FloatMatrixDataDense toDense()
    {
        return isDense() ? (FloatMatrixDataDense) this : ((FloatMatrixDataSparse) this).toDense();
    }

    /**
     * Retrieve one value from this data.
     * @param row int; the row number to get the value for
     * @param col int; the column number to get the value for
     * @return the value at the [row, col] point
     */
    public abstract float getSI(int row, int col);

    /**
     * Sets a value at the [row, col] point in the matrix.
     * @param row int; the row number to set the value for
     * @param col int; the column number to set the value for
     * @param valueSI float; the value at the index
     */
    public abstract void setSI(int row, int col, float valueSI);

    /** {@inheritDoc} */
    @Override
    public final int cardinality()
    {
        // this does not copy the data. See http://stackoverflow.com/questions/23106093/how-to-get-a-stream-from-a-float
        return (int) IntStream.range(0, this.matrixSI.length).parallel().mapToDouble(i -> this.matrixSI[i])
                .filter(d -> d != 0.0).count();
    }

    /**
     * Compute and return the sum of the values of all cells of this matrix.
     * @return float; the sum of the values of all cells
     */
    public final float zSum()
    {
        // this does not copy the data. See http://stackoverflow.com/questions/23106093/how-to-get-a-stream-from-a-float
        return (float) IntStream.range(0, this.matrixSI.length).parallel().mapToDouble(i -> this.matrixSI[i]).sum();
    }

    /**
     * Create and return a deep copy of the data in dense format. The float array is of the form f[rows][columns] so each value
     * can be found with f[row][column].
     * @return float[][]; a safe, dense copy of matrixSI as a matrix
     */
    public abstract float[][] getDenseMatrixSI();

    /**
     * Create and return a deep copy of the data in dense format. The double array is of the form d[rows][columns] so each value
     * can be found with d[row][column].
     * @return double[][]; a safe, dense copy of matrixSI as a matrix
     */
    public abstract double[][] getDoubleDenseMatrixSI();

    /**
     * Check that a 2D array of float is not null, not empty and not jagged; i.e. all rows have the same length.
     * @param values float[][]; the 2D array to check
     * @return the values in case the method is used in a constructor
     * @throws NullPointerException when <code>values</code> is null
     * @throws ValueRuntimeException when <code>values</code> is empty, or jagged
     */
    protected static float[][] checkRectangularAndNonEmpty(final float[][] values) throws ValueRuntimeException
    {
        Throw.when(null == values, NullPointerException.class, "Cannot create a matrix from a null float[][]");
        Throw.when(0 == values.length, ValueRuntimeException.class, "Cannot create a matrix from zero length float[][]");
        for (int row = 0; row < values.length; row++)
        {
            Throw.when(null == values[row], ValueRuntimeException.class,
                    "Cannot create a matrix from float[][] containing null row(s)");
            Throw.when(values[row].length != values[0].length, ValueRuntimeException.class,
                    "Cannot create a matrix from a jagged float[][]");
        }
        Throw.when(0 == values[0].length, ValueRuntimeException.class,
                "Cannot create a matrix from a float[][] with zero values");
        return values;
    }

    /**
     * Check that a 2D array of float is not null, not empty and not jagged; i.e. all rows have the same length.
     * @param values S[][]; the 2D array to check
     * @return the values in case the method is used in a constructor
     * @throws NullPointerException when <code>values</code> is null
     * @throws ValueRuntimeException when <code>values</code> is empty, or jagged
     */
    protected static <U extends Unit<U>, S extends FloatScalarInterface<U, S>> S[][] checkRectangularAndNonEmpty(
            final S[][] values) throws ValueRuntimeException
    {
        Throw.when(null == values, NullPointerException.class, "Cannot create a matrix from a null Scalar[][]");
        Throw.when(0 == values.length, ValueRuntimeException.class, "Cannot create a matrix from zero length Scalar[][]");
        for (int row = 0; row < values.length; row++)
        {
            Throw.when(null == values[row], ValueRuntimeException.class,
                    "Cannot create a matrix from Scalar[][] containing null row(s)");
            Throw.when(values[row].length != values[0].length, ValueRuntimeException.class,
                    "Cannot create a matrix from a jagged Scalar[][]");
            for (int col = 0; col < values[row].length; col++)
            {
                Throw.whenNull(values[row][col], "Cannot create a matrix from Scalar[][] containing null(s)");
            }
        }
        Throw.when(0 == values[0].length, ValueRuntimeException.class,
                "Cannot create a matrix from a Scalar[][] with zero values");
        return values;
    }

    /**
     * Check the sizes of this data object and the other data object.
     * @param other FloatMatrixData; the other data object
     * @throws ValueRuntimeException if matrices have different lengths
     */
    private void checkSizes(final FloatMatrixData other) throws ValueRuntimeException
    {
        if (this.rows() != other.rows() || this.cols() != other.cols())
        {
            throw new ValueRuntimeException("Two data objects used in a FloatMatrix operation do not have the same size");
        }
    }

    /* ============================================================================================ */
    /* ================================== CALCULATION FUNCTIONS =================================== */
    /* ============================================================================================ */

    /**
     * Add two matrices on a cell-by-cell basis. If both matrices are sparse, a sparse matrix is returned, otherwise a dense
     * matrix is returned.
     * @param right FloatMatrixData; the other data object to add
     * @return the sum of this data object and the other data object
     * @throws ValueRuntimeException if matrices have different lengths
     */
    public FloatMatrixData plus(final FloatMatrixData right) throws ValueRuntimeException
    {
        checkSizes(right);
        float[] dm = new float[this.rows * this.cols];
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> dm[r * this.cols + c] = getSI(r, c) + right.getSI(r, c)));
        if (this instanceof FloatMatrixDataSparse && right instanceof FloatMatrixDataSparse)
        {
            return new FloatMatrixDataDense(dm, this.rows, this.cols).toSparse();
        }
        return new FloatMatrixDataDense(dm, this.rows, this.cols);
    }

    /**
     * Add a matrix to this matrix on a cell-by-cell basis. The type of matrix (sparse, dense) stays the same.
     * @param right FloatMatrixData; the other data object to add
     * @throws ValueRuntimeException if matrices have different lengths
     */
    public abstract void incrementBy(FloatMatrixData right) throws ValueRuntimeException;

    /**
     * Add a number to this matrix on a cell-by-cell basis.
     * @param valueSI float; the value to add
     */
    public abstract void incrementBy(float valueSI);

    /**
     * Subtract two matrices on a cell-by-cell basis. If both matrices are sparse, a sparse matrix is returned, otherwise a
     * dense matrix is returned.
     * @param right FloatMatrixData; the other data object to subtract
     * @return the sum of this data object and the other data object
     * @throws ValueRuntimeException if matrices have different lengths
     */
    public FloatMatrixData minus(final FloatMatrixData right) throws ValueRuntimeException
    {
        checkSizes(right);
        float[] dm = new float[this.rows * this.cols];
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> dm[r * this.cols + c] = getSI(r, c) - right.getSI(r, c)));
        if (this instanceof FloatMatrixDataSparse && right instanceof FloatMatrixDataSparse)
        {
            return new FloatMatrixDataDense(dm, this.rows, this.cols).toSparse();
        }
        return new FloatMatrixDataDense(dm, this.rows, this.cols);
    }

    /**
     * Subtract a matrix from this matrix on a cell-by-cell basis. The type of matrix (sparse, dense) stays the same.
     * @param right FloatMatrixData; the other data object to subtract
     * @throws ValueRuntimeException if matrices have different lengths
     */
    public abstract void decrementBy(FloatMatrixData right) throws ValueRuntimeException;

    /**
     * Subtract a number from this matrix on a cell-by-cell basis.
     * @param valueSI float; the value to subtract
     */
    public abstract void decrementBy(float valueSI);

    /**
     * Multiply two matrix on a cell-by-cell basis. If both matrices are dense, a dense matrix is returned, otherwise a sparse
     * matrix is returned.
     * @param right FloatMatrixData; the other data object to multiply with
     * @return the sum of this data object and the other data object
     * @throws ValueRuntimeException if matrices have different sizes
     */
    public FloatMatrixData times(final FloatMatrixData right) throws ValueRuntimeException
    {
        checkSizes(right);
        float[] dm = new float[this.rows * this.cols];
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> dm[r * this.cols + c] = getSI(r, c) * right.getSI(r, c)));
        if (this instanceof FloatMatrixDataDense && right instanceof FloatMatrixDataDense)
        {
            return new FloatMatrixDataDense(dm, this.rows, this.cols);
        }
        return new FloatMatrixDataDense(dm, this.rows, this.cols).toSparse();
    }

    /**
     * Multiply a matrix with the values of another matrix on a cell-by-cell basis. The type of matrix (sparse, dense) stays the
     * same.
     * @param right FloatMatrixData; the other data object to multiply with
     * @throws ValueRuntimeException if matrices have different sizes
     */
    public abstract void multiplyBy(FloatMatrixData right) throws ValueRuntimeException;

    /**
     * Multiply the values of this matrix with a number on a cell-by-cell basis.
     * @param valueSI float; the value to multiply with
     */
    public abstract void multiplyBy(float valueSI);

    /**
     * Divide two matrices on a cell-by-cell basis. If both matrices are dense, a dense matrix is returned, otherwise a sparse
     * matrix is returned.
     * @param right FloatMatrixData; the other data object to divide by
     * @return the sum of this data object and the other data object
     * @throws ValueRuntimeException if matrices have different sizes
     */
    public FloatMatrixData divide(final FloatMatrixData right) throws ValueRuntimeException
    {
        checkSizes(right);
        float[] dm = new float[this.rows * this.cols];
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> dm[r * this.cols + c] = getSI(r, c) / right.getSI(r, c)));
        if (this instanceof FloatMatrixDataDense && right instanceof FloatMatrixDataDense)
        {
            return new FloatMatrixDataDense(dm, this.rows, this.cols);
        }
        return new FloatMatrixDataDense(dm, this.rows, this.cols).toSparse();
    }

    /**
     * Divide the values of a matrix by the values of another matrix on a cell-by-cell basis. The type of matrix (sparse, dense)
     * stays the same.
     * @param right FloatMatrixData; the other data object to divide by
     * @throws ValueRuntimeException if matrices have different sizes
     */
    public abstract void divideBy(FloatMatrixData right) throws ValueRuntimeException;

    /**
     * Divide the values of this matrix by a number on a cell-by-cell basis.
     * @param valueSI float; the value to multiply with
     */
    public abstract void divideBy(float valueSI);

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
        FloatMatrixData other = (FloatMatrixData) obj;
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
        return "FloatMatrixData [storageType=" + this.storageType + ", matrixSI=" + Arrays.toString(this.matrixSI) + "]";
    }

}
