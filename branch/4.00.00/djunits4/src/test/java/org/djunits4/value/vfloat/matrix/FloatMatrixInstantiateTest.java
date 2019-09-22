package org.djunits4.value.vfloat.matrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.matrix.base.FloatMatrix;
import org.djunits4.value.vfloat.scalar.FloatArea;
import org.djunits4.value.vfloat.scalar.FloatLength;
import org.junit.Test;

/**
 * FloatMatrixInstantiateTest.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class FloatMatrixInstantiateTest
{
    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     */
    @Test
    public void testInstantiateSquareDenseData()
    {
        FloatLengthMatrix lmdkm10 =
                FloatMatrix.instantiate(FLOATMATRIX.denseSquareArrays(10), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(10, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(100, lmdkm10.cardinality());
        assertEquals(50 * 101 * 1000.0, lmdkm10.zSum(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmdkm10.getUnit());

        FloatLengthMatrix lmskm10 =
                FloatMatrix.instantiate(FLOATMATRIX.denseSquareArrays(10), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(10, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(100, lmskm10.cardinality());
        assertEquals(50 * 101 * 1000.0, lmskm10.zSum(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmskm10.getUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());
        assertEquals(lmdkm10, lmdkm10.toDense());
        assertEquals(lmskm10, lmskm10.toSparse());
        // TODO: assertTrue(lmdkm10.isDense());
        // TODO: assertTrue(lmskm10.isSparse());

        FloatLengthMatrix lmdsi10 =
                FloatMatrix.instantiateSI(FLOATMATRIX.denseSquareArrays(10), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(10, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(100, lmdsi10.cardinality());
        assertEquals(50 * 101, lmdsi10.zSum(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmdsi10.getUnit());

        FloatLengthMatrix lmssi10 =
                FloatMatrix.instantiateSI(FLOATMATRIX.denseSquareArrays(10), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(10, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(100, lmssi10.cardinality());
        assertEquals(50 * 101, lmssi10.zSum(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmssi10.getUnit());

        FloatLengthMatrix lmdsc10 = FloatMatrix.instantiate(FLOATMATRIX.denseSquareScalarArrays(10, FloatLength.class),
                LengthUnit.HECTOMETER, StorageType.DENSE);
        assertEquals(10, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(100, lmdsc10.cardinality());
        assertEquals(50 * 101, lmdsc10.zSum(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmdsc10.getUnit());

        FloatLengthMatrix lmssc10 = FloatMatrix.instantiate(FLOATMATRIX.denseSquareScalarArrays(10, FloatLength.class),
                LengthUnit.HECTOMETER, StorageType.SPARSE);
        assertEquals(10, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(100, lmssc10.cardinality());
        assertEquals(50 * 101, lmssc10.zSum(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmssc10.getUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSquareSparseData()
    {
        FloatLengthMatrix lmdkm10 =
                FloatMatrix.instantiate(FLOATMATRIX.sparseSquareArrays(10), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(10, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(10, lmdkm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lmdkm10.zSum(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmdkm10.getUnit());

        FloatLengthMatrix lmskm10 =
                FloatMatrix.instantiate(FLOATMATRIX.sparseSquareArrays(10), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(10, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(10, lmskm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lmskm10.zSum(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmskm10.getUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());

        FloatLengthMatrix lmdsi10 =
                FloatMatrix.instantiateSI(FLOATMATRIX.sparseSquareArrays(10), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(10, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(10, lmdsi10.cardinality());
        assertEquals(5 * 11, lmdsi10.zSum(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmdsi10.getUnit());

        FloatLengthMatrix lmssi10 =
                FloatMatrix.instantiateSI(FLOATMATRIX.sparseSquareArrays(10), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(10, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(10, lmssi10.cardinality());
        assertEquals(5 * 11, lmssi10.zSum(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmssi10.getUnit());

        FloatLengthMatrix lmdsc10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareScalarArrays(10, FloatLength.class),
                LengthUnit.HECTOMETER, StorageType.DENSE);
        assertEquals(10, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(10, lmdsc10.cardinality());
        assertEquals(5 * 11, lmdsc10.zSum(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmdsc10.getUnit());

        FloatLengthMatrix lmssc10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareScalarArrays(10, FloatLength.class),
                LengthUnit.HECTOMETER, StorageType.SPARSE);
        assertEquals(10, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(10, lmssc10.cardinality());
        assertEquals(5 * 11, lmssc10.zSum(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmssc10.getUnit());

        FloatLengthMatrix lmdtu10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareTuples(10, FloatLength.class), 10, 10,
                LengthUnit.NANOMETER, StorageType.DENSE);
        assertEquals(10, lmdtu10.rows());
        assertEquals(10, lmdtu10.cols());
        assertEquals(10, lmdtu10.cardinality());
        assertEquals(5 * 11, lmdtu10.zSum(), 0.001);
        assertEquals(LengthUnit.NANOMETER, lmdtu10.getUnit());

        FloatLengthMatrix lmstu10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareTuples(10, FloatLength.class), 10, 10,
                LengthUnit.NANOMETER, StorageType.SPARSE);
        assertEquals(10, lmstu10.rows());
        assertEquals(10, lmstu10.cols());
        assertEquals(10, lmstu10.cardinality());
        assertEquals(5 * 11, lmstu10.zSum(), 0.001);
        assertEquals(LengthUnit.NANOMETER, lmstu10.getUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     */
    @Test
    public void testInstantiateSquareDenseDataWithClass()
    {
        FloatAreaMatrix lmdkm10 = FloatMatrix.instantiate(FLOATMATRIX.denseSquareArrays(10), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, FloatAreaMatrix.class);
        assertEquals(10, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(100, lmdkm10.cardinality());
        assertEquals(50 * 101 * 1.0E6, lmdkm10.zSum(), 1E3);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmdkm10.getUnit());

        FloatAreaMatrix lmskm10 = FloatMatrix.instantiate(FLOATMATRIX.denseSquareArrays(10), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, FloatAreaMatrix.class);
        assertEquals(10, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(100, lmskm10.cardinality());
        assertEquals(50 * 101 * 1.0E6, lmskm10.zSum(), 1E3);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmskm10.getUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());

        FloatAreaMatrix lmdsi10 = FloatMatrix.instantiateSI(FLOATMATRIX.denseSquareArrays(10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, FloatAreaMatrix.class);
        assertEquals(10, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(100, lmdsi10.cardinality());
        assertEquals(50 * 101, lmdsi10.zSum(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmdsi10.getUnit());

        FloatAreaMatrix lmssi10 = FloatMatrix.instantiateSI(FLOATMATRIX.denseSquareArrays(10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, FloatAreaMatrix.class);
        assertEquals(10, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(100, lmssi10.cardinality());
        assertEquals(50 * 101, lmssi10.zSum(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmssi10.getUnit());

        FloatAreaMatrix lmdsc10 = FloatMatrix.instantiate(FLOATMATRIX.denseSquareScalarArrays(10, FloatArea.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, FloatAreaMatrix.class);
        assertEquals(10, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(100, lmdsc10.cardinality());
        assertEquals(50 * 101, lmdsc10.zSum(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmdsc10.getUnit());

        FloatAreaMatrix lmssc10 = FloatMatrix.instantiate(FLOATMATRIX.denseSquareScalarArrays(10, FloatArea.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, FloatAreaMatrix.class);
        assertEquals(10, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(100, lmssc10.cardinality());
        assertEquals(50 * 101, lmssc10.zSum(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmssc10.getUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSquareSparseDataWithClass()
    {
        FloatAreaMatrix lmdkm10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareArrays(10), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, FloatAreaMatrix.class);
        assertEquals(10, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(10, lmdkm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lmdkm10.zSum(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmdkm10.getUnit());

        FloatAreaMatrix lmskm10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareArrays(10), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, FloatAreaMatrix.class);
        assertEquals(10, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(10, lmskm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lmskm10.zSum(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmskm10.getUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());

        FloatAreaMatrix lmdsi10 = FloatMatrix.instantiateSI(FLOATMATRIX.sparseSquareArrays(10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, FloatAreaMatrix.class);
        assertEquals(10, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(10, lmdsi10.cardinality());
        assertEquals(5 * 11, lmdsi10.zSum(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmdsi10.getUnit());

        FloatAreaMatrix lmssi10 = FloatMatrix.instantiateSI(FLOATMATRIX.sparseSquareArrays(10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, FloatAreaMatrix.class);
        assertEquals(10, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(10, lmssi10.cardinality());
        assertEquals(5 * 11, lmssi10.zSum(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmssi10.getUnit());

        FloatAreaMatrix lmdsc10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareScalarArrays(10, FloatArea.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, FloatAreaMatrix.class);
        assertEquals(10, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(10, lmdsc10.cardinality());
        assertEquals(5 * 11, lmdsc10.zSum(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmdsc10.getUnit());

        FloatAreaMatrix lmssc10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareScalarArrays(10, FloatArea.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, FloatAreaMatrix.class);
        assertEquals(10, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(10, lmssc10.cardinality());
        assertEquals(5 * 11, lmssc10.zSum(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmssc10.getUnit());

        FloatAreaMatrix lmdtu10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareTuples(10, FloatArea.class), 10, 10,
                AreaUnit.ACRE, StorageType.DENSE, FloatAreaMatrix.class);
        assertEquals(10, lmdtu10.rows());
        assertEquals(10, lmdtu10.cols());
        assertEquals(10, lmdtu10.cardinality());
        assertEquals(5 * 11, lmdtu10.zSum(), 0.001);
        assertEquals(AreaUnit.ACRE, lmdtu10.getUnit());

        FloatAreaMatrix lmstu10 = FloatMatrix.instantiate(FLOATMATRIX.sparseSquareTuples(10, FloatArea.class), 10, 10,
                AreaUnit.ACRE, StorageType.SPARSE, FloatAreaMatrix.class);
        assertEquals(10, lmstu10.rows());
        assertEquals(10, lmstu10.cols());
        assertEquals(10, lmstu10.cardinality());
        assertEquals(5 * 11, lmstu10.zSum(), 0.001);
        assertEquals(AreaUnit.ACRE, lmstu10.getUnit());
    }

}
