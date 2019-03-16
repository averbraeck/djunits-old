package org.djunits.value.vdouble.matrix;

import java.util.stream.IntStream;

import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.DoubleFunction;

/**
 * Stores dense data for a DoubleMatrix and carries out basic operations.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 3, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DoubleMatrixDataDense extends DoubleMatrixData
{
    /**
     * Create a matrix with dense data.
     * @param matrixSI double[]; the data to store
     * @param rows int; the number of rows
     * @param cols int; the number of columns
     * @throws ValueException in case <tt>rows * cols != matrixSI.length</tt>
     */
    public DoubleMatrixDataDense(final double[] matrixSI, final int rows, final int cols) throws ValueException
    {
        super(StorageType.DENSE);
        if (rows * cols != matrixSI.length)
        {
            throw new ValueException("DoubleMatrixDataDense constructor, rows * cols != matrixSI.length");
        }
        this.matrixSI = new double[matrixSI.length];
        System.arraycopy(matrixSI, 0, this.matrixSI, 0, matrixSI.length);
        this.rows = rows;
        this.cols = cols;
    }

    /**
     * Create a matrix with dense data.
     * @param matrixSI double[][]; the data to store
     * @throws ValueException in case matrix is ragged
     */
    public DoubleMatrixDataDense(final double[][] matrixSI) throws ValueException
    {
        super(StorageType.DENSE);
        if (matrixSI == null || matrixSI.length == 0)
        {
            throw new ValueException("DoubleMatrixDataDense constructor, matrixSI == null || matrixSI.length == 0");
        }
        this.rows = matrixSI.length;
        this.cols = matrixSI[0].length;
        this.matrixSI = new double[this.rows * this.cols];
        for (int r = 0; r < this.rows; r++)
        {
            double[] row = matrixSI[r];
            if (row.length != this.cols)
            {
                throw new ValueException("DoubleMatrixDataDense constructor, ragged matrix");
            }
            System.arraycopy(row, 0, this.matrixSI, r * this.cols, row.length);
        }
    }

    /**
     * @param doubleFunction DoubleFunction; the function to apply on the (mutable) data elements
     */
    public final void assign(final DoubleFunction doubleFunction)
    {
        IntStream.range(0, this.rows() * this.cols()).parallel()
                .forEach(i -> this.matrixSI[i] = doubleFunction.apply(this.matrixSI[i]));
    }

    /** {@inheritDoc} */
    @Override
    public final DoubleMatrixDataSparse toSparse()
    {
        int length = cardinality();
        double[] sparseSI = new double[length];
        long[] indices = new long[length];
        int count = 0;
        for (int r = 0; r < this.rows; r++)
        {
            for (int c = 0; c < this.cols; c++)
            {
                int index = r * this.cols + c;
                if (this.matrixSI[index] != 0.0)
                {
                    sparseSI[count] = this.matrixSI[index];
                    indices[count] = index;
                    count++;
                }
            }
        }
        return new DoubleMatrixDataSparse(sparseSI, indices, this.matrixSI.length, this.rows, this.cols);
    }

    /** {@inheritDoc} */
    @Override
    public final double getSI(final int row, final int col)
    {
        return this.matrixSI[row * this.cols + col];
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int row, final int col, final double valueSI)
    {
        this.matrixSI[row * this.cols + col] = valueSI;
    }

    /** {@inheritDoc} */
    @Override
    public final double[][] getDenseMatrixSI()
    {
        double[][] matrix = new double[this.rows][];
        for (int r = 0; r < this.rows; r++)
        {
            double[] row = new double[this.cols];
            System.arraycopy(this.matrixSI, r * this.cols, row, 0, row.length);
            matrix[r] = row;
        }
        return matrix;
    }

    /** {@inheritDoc} */
    @Override
    public final DoubleMatrixDataDense copy()
    {
        try
        {
            return new DoubleMatrixDataDense(getDenseMatrixSI());
        }
        catch (ValueException exception)
        {
            throw new RuntimeException(exception); // should not happen -- original is not ragged...
        }
    }

    /** {@inheritDoc} */
    @Override
    public final void incrementBy(final DoubleMatrixData right) throws ValueException
    {
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> this.matrixSI[r * this.cols + c] += right.getSI(r, c)));
    }

    /** {@inheritDoc} */
    @Override
    public final void decrementBy(final DoubleMatrixData right) throws ValueException
    {
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> this.matrixSI[r * this.cols + c] -= right.getSI(r, c)));
    }

    /** {@inheritDoc} */
    @Override
    public final void multiplyBy(final DoubleMatrixData right) throws ValueException
    {
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> this.matrixSI[r * this.cols + c] *= right.getSI(r, c)));
    }

    /** {@inheritDoc} */
    @Override
    public final void divideBy(final DoubleMatrixData right) throws ValueException
    {
        IntStream.range(0, this.rows).parallel().forEach(
                r -> IntStream.range(0, this.cols).forEach(c -> this.matrixSI[r * this.cols + c] /= right.getSI(r, c)));
    }
}
