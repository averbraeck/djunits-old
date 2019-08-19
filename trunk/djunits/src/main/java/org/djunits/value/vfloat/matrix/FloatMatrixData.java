package org.djunits.value.vfloat.matrix;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.djunits.unit.scale.Scale;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatScalarInterface;

/**
 * Stores the data for a FloatMatrix and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
abstract class FloatMatrixData implements Serializable
{
    /** */
    private static final long serialVersionUID = 1L;

    /** the internal storage of the Matrix; can be sparse or dense. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected float[] matrixSI;

    /** the number of rows of the matrix. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected int rows;

    /** the number of columns of the matrix. */
    @SuppressWarnings("checkstyle:visibilitymodifier")
    protected int cols;

    /** the data type. */
    private final StorageType storageType;

    /**
     * @param storageType StorageType; the data type.
     */
    FloatMatrixData(final StorageType storageType)
    {
        super();
        this.storageType = storageType;
    }

    /* ============================================================================================ */
    /* ====================================== INSTANTIATION ======================================= */
    /* ============================================================================================ */

    /**
     * Instantiate a FloatMatrixData with the right data type.
     * @param values float[][]; the (SI) values to store
     * @param scale Scale; the scale of the unit to use for conversion to SI
     * @param storageType StorageType; the data type to use
     * @return the FloatMatrixData with the right data type
     * @throws ValueException when values are null, or storageType is null
     */
    public static FloatMatrixData instantiate(final float[][] values, final Scale scale, final StorageType storageType)
            throws ValueException
    {
        if (values == null || values.length == 0 || values[0].length == 0)
        {
            throw new ValueException("FloatMatrixData.instantiate: float[][] values is null or "
                    + "values.length == 0 or values[0].length == 0");
        }

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
                float[][] matrixSI = new float[rows][cols];
                IntStream.range(0, values.length).parallel().forEach(r -> IntStream.range(0, cols)
                        .forEach(c -> matrixSI[r][c] = (float) scale.toStandardUnit(values[r][c])));
                return FloatMatrixDataSparse.instantiate(matrixSI);

            default:
                throw new ValueException("Unknown data type in FloatMatrixData.instantiate: " + storageType);
        }
    }

    /**
     * Instantiate a FloatMatrixData with the right data type.
     * @param values FloatScalarInterface[][]; the values to store
     * @param storageType StorageType; the data type to use
     * @return the FloatMatrixData with the right data type
     * @throws ValueException when values is null, or storageType is null
     */
    public static FloatMatrixData instantiate(final FloatScalarInterface[][] values, final StorageType storageType)
            throws ValueException
    {
        if (values == null)
        {
            throw new ValueException("FloatMatrixData.instantiate: FloatScalar[] values is null");
        }

        if (values == null || values.length == 0 || values[0].length == 0)
        {
            throw new ValueException("FloatMatrixData.instantiate: FloatScalar[][] values is null or "
                    + "values.length == 0 or values[0].length == 0");
        }

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
                throw new ValueException("Unknown data type in FloatMatrixData.instantiate: " + storageType);
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
     * @return the number of rows of the matrix
     */
    public int rows()
    {
        return this.rows;
    }

    /**
     * @return the number of columns of the matrix
     */
    public int cols()
    {
        return this.cols;
    }

    /**
     * @return whether data type is sparse.
     */
    public boolean isSparse()
    {
        return this.storageType.equals(StorageType.SPARSE);
    }

    /**
     * @return the sparse transformation of this data
     */
    public FloatMatrixDataSparse toSparse()
    {
        return isSparse() ? (FloatMatrixDataSparse) this : ((FloatMatrixDataDense) this).toSparse();
    }

    /**
     * @return whether data type is dense.
     */
    public boolean isDense()
    {
        return this.storageType.equals(StorageType.DENSE);
    }

    /**
     * @return the dense transformation of this data
     */
    public FloatMatrixDataDense toDense()
    {
        return isDense() ? (FloatMatrixDataDense) this : ((FloatMatrixDataSparse) this).toDense();
    }

    /**
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

    /**
     * @return the number of non-zero cells.
     */
    public final int cardinality()
    {
        // this does not copy the data. See http://stackoverflow.com/questions/23106093/how-to-get-a-stream-from-a-float
        return (int) IntStream.range(0, this.matrixSI.length).parallel().mapToDouble(i -> this.matrixSI[i])
                .filter(d -> d != 0.0).count();
    }

    /**
     * @return the sum of the values of all cells.
     */
    public final float zSum()
    {
        // this does not copy the data. See http://stackoverflow.com/questions/23106093/how-to-get-a-stream-from-a-float
        return (float) IntStream.range(0, this.matrixSI.length).parallel().mapToDouble(i -> this.matrixSI[i]).sum();
    }

    /**
     * @return a deep copy of the data.
     */
    public abstract FloatMatrixData copy();

    /**
     * @return a safe dense copy of matrixSI as a matrix
     */
    public abstract float[][] getDenseMatrixSI();

    /**
     * @return a safe dense copy of matrixSI as a double matrix
     */
    public abstract double[][] getDoubleDenseMatrixSI();

    /**
     * Check the sizes of this data object and the other data object.
     * @param other FloatMatrixData; the other data object
     * @throws ValueException if matrices have different lengths
     */
    private void checkSizes(final FloatMatrixData other) throws ValueException
    {
        if (this.rows() != other.rows() || this.cols() != other.cols())
        {
            throw new ValueException("Two data objects used in a FloatMatrix operation do not have the same size");
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
     * @throws ValueException if matrices have different lengths
     */
    public FloatMatrixData plus(final FloatMatrixData right) throws ValueException
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
     * @throws ValueException if matrices have different lengths
     */
    public abstract void incrementBy(FloatMatrixData right) throws ValueException;

    /**
     * Add a number to this matrix on a cell-by-cell basis.
     * @param valueSI float; the value to add
     */
    public void incrementBy(final float valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] += valueSI);
    }

    /**
     * Subtract two matrices on a cell-by-cell basis. If both matrices are sparse, a sparse matrix is returned, otherwise a
     * dense matrix is returned.
     * @param right FloatMatrixData; the other data object to subtract
     * @return the sum of this data object and the other data object
     * @throws ValueException if matrices have different lengths
     */
    public FloatMatrixData minus(final FloatMatrixData right) throws ValueException
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
     * @throws ValueException if matrices have different lengths
     */
    public abstract void decrementBy(FloatMatrixData right) throws ValueException;

    /**
     * Subtract a number from this matrix on a cell-by-cell basis.
     * @param valueSI float; the value to subtract
     */
    public void decrementBy(final float valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] -= valueSI);
    }

    /**
     * Multiply two matrix on a cell-by-cell basis. If both matrices are dense, a dense matrix is returned, otherwise a sparse
     * matrix is returned.
     * @param right FloatMatrixData; the other data object to multiply with
     * @return the sum of this data object and the other data object
     * @throws ValueException if matrices have different lengths
     */
    public FloatMatrixData times(final FloatMatrixData right) throws ValueException
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
     * @throws ValueException if matrices have different lengths
     */
    public abstract void multiplyBy(FloatMatrixData right) throws ValueException;

    /**
     * Multiply the values of this matrix with a number on a cell-by-cell basis.
     * @param valueSI float; the value to multiply with
     */
    public void multiplyBy(final float valueSI)
    {
        IntStream.range(0, this.matrixSI.length).parallel().forEach(i -> this.matrixSI[i] *= valueSI);
    }

    /**
     * Divide two matrices on a cell-by-cell basis. If both matrices are dense, a dense matrix is returned, otherwise a sparse
     * matrix is returned.
     * @param right FloatMatrixData; the other data object to divide by
     * @return the sum of this data object and the other data object
     * @throws ValueException if matrices have different lengths
     */
    public FloatMatrixData divide(final FloatMatrixData right) throws ValueException
    {
        // FIXME: looks very wrong; div0 appears to result in 0f; not Float.NaN
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
     * @throws ValueException if matrices have different lengths
     */
    public abstract void divideBy(FloatMatrixData right) throws ValueException;

    /**
     * Divide the values of this matrix by a number on a cell-by-cell basis.
     * @param valueSI float; the value to multiply with
     */
    public void divideBy(final float valueSI)
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
