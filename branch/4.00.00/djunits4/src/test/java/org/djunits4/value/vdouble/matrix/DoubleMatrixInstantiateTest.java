package org.djunits4.value.vdouble.matrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.djunits4.Try;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.matrix.base.DoubleMatrix;
import org.djunits4.value.vdouble.scalar.Area;
import org.djunits4.value.vdouble.scalar.Length;
import org.junit.Test;

/**
 * DoubleMatrixInstantiateTest.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class DoubleMatrixInstantiateTest
{
    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     */
    @Test
    public void testInstantiateSquareDenseData()
    {
        LengthMatrix lmdkm10 =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(10, 10), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(10, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(100, lmdkm10.cardinality());
        assertEquals(50 * 101 * 1000.0, lmdkm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmdkm10.getDisplayUnit());

        LengthMatrix lmskm10 =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(10, 10), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(10, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(100, lmskm10.cardinality());
        assertEquals(50 * 101 * 1000.0, lmskm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmskm10.getDisplayUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());
        assertEquals(lmdkm10, lmdkm10.toDense());
        assertEquals(lmskm10, lmskm10.toSparse());
        assertTrue(lmdkm10.isDense());
        assertTrue(lmskm10.isSparse());

        LengthMatrix lmdsi10 =
                DoubleMatrix.instantiateSI(DOUBLEMATRIX.denseRectArrays(10, 10), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(10, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(100, lmdsi10.cardinality());
        assertEquals(50 * 101, lmdsi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmdsi10.getDisplayUnit());

        LengthMatrix lmssi10 =
                DoubleMatrix.instantiateSI(DOUBLEMATRIX.denseRectArrays(10, 10), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(10, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(100, lmssi10.cardinality());
        assertEquals(50 * 101, lmssi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmssi10.getDisplayUnit());

        LengthMatrix lmdsc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectScalarArrays(10, 10, Length.class),
                LengthUnit.HECTOMETER, StorageType.DENSE);
        assertEquals(10, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(100, lmdsc10.cardinality());
        assertEquals(50 * 101, lmdsc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmdsc10.getDisplayUnit());

        LengthMatrix lmssc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectScalarArrays(10, 10, Length.class),
                LengthUnit.HECTOMETER, StorageType.SPARSE);
        assertEquals(10, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(100, lmssc10.cardinality());
        assertEquals(50 * 101, lmssc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSquareSparseData()
    {
        LengthMatrix lmdkm10 =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(10, 10), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(10, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(10, lmdkm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lmdkm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmdkm10.getDisplayUnit());

        LengthMatrix lmskm10 =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(10, 10), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(10, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(10, lmskm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lmskm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmskm10.getDisplayUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());

        LengthMatrix lmdsi10 =
                DoubleMatrix.instantiateSI(DOUBLEMATRIX.sparseRectArrays(10, 10), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(10, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(10, lmdsi10.cardinality());
        assertEquals(5 * 11, lmdsi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmdsi10.getDisplayUnit());

        LengthMatrix lmssi10 =
                DoubleMatrix.instantiateSI(DOUBLEMATRIX.sparseRectArrays(10, 10), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(10, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(10, lmssi10.cardinality());
        assertEquals(5 * 11, lmssi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmssi10.getDisplayUnit());

        LengthMatrix lmdsc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectScalarArrays(10, 10, Length.class),
                LengthUnit.HECTOMETER, StorageType.DENSE);
        assertEquals(10, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(10, lmdsc10.cardinality());
        assertEquals(5 * 11, lmdsc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmdsc10.getDisplayUnit());

        LengthMatrix lmssc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectScalarArrays(10, 10, Length.class),
                LengthUnit.HECTOMETER, StorageType.SPARSE);
        assertEquals(10, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(10, lmssc10.cardinality());
        assertEquals(5 * 11, lmssc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmssc10.getDisplayUnit());

        LengthMatrix lmdtu10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectTuples(10, 10, Length.class), 10, 10,
                LengthUnit.NANOMETER, StorageType.DENSE);
        assertEquals(10, lmdtu10.rows());
        assertEquals(10, lmdtu10.cols());
        assertEquals(10, lmdtu10.cardinality());
        assertEquals(5 * 11, lmdtu10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.NANOMETER, lmdtu10.getDisplayUnit());

        LengthMatrix lmstu10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectTuples(10, 10, Length.class), 10, 10,
                LengthUnit.NANOMETER, StorageType.SPARSE);
        assertEquals(10, lmstu10.rows());
        assertEquals(10, lmstu10.cols());
        assertEquals(10, lmstu10.cardinality());
        assertEquals(5 * 11, lmstu10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.NANOMETER, lmstu10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     */
    @Test
    public void testInstantiateSquareDenseDataWithClass()
    {
        AreaMatrix lmdkm10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(10, 10), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(10, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(100, lmdkm10.cardinality());
        assertEquals(50 * 101 * 1.0E6, lmdkm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmdkm10.getDisplayUnit());

        AreaMatrix lmskm10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(10, 10), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(10, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(100, lmskm10.cardinality());
        assertEquals(50 * 101 * 1.0E6, lmskm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmskm10.getDisplayUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());

        AreaMatrix lmdsi10 = DoubleMatrix.instantiateSI(DOUBLEMATRIX.denseRectArrays(10, 10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(10, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(100, lmdsi10.cardinality());
        assertEquals(50 * 101, lmdsi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmdsi10.getDisplayUnit());

        AreaMatrix lmssi10 = DoubleMatrix.instantiateSI(DOUBLEMATRIX.denseRectArrays(10, 10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(10, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(100, lmssi10.cardinality());
        assertEquals(50 * 101, lmssi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmssi10.getDisplayUnit());

        AreaMatrix lmdsc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectScalarArrays(10, 10, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, AreaMatrix.class);
        assertEquals(10, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(100, lmdsc10.cardinality());
        assertEquals(50 * 101, lmdsc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmdsc10.getDisplayUnit());

        AreaMatrix lmssc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectScalarArrays(10, 10, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, AreaMatrix.class);
        assertEquals(10, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(100, lmssc10.cardinality());
        assertEquals(50 * 101, lmssc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSquareSparseDataWithClass()
    {
        AreaMatrix lmdkm10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(10, 10), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(10, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(10, lmdkm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lmdkm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmdkm10.getDisplayUnit());

        AreaMatrix lmskm10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(10, 10), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(10, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(10, lmskm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lmskm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmskm10.getDisplayUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());

        AreaMatrix lmdsi10 = DoubleMatrix.instantiateSI(DOUBLEMATRIX.sparseRectArrays(10, 10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(10, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(10, lmdsi10.cardinality());
        assertEquals(5 * 11, lmdsi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmdsi10.getDisplayUnit());

        AreaMatrix lmssi10 = DoubleMatrix.instantiateSI(DOUBLEMATRIX.sparseRectArrays(10, 10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(10, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(10, lmssi10.cardinality());
        assertEquals(5 * 11, lmssi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmssi10.getDisplayUnit());

        AreaMatrix lmdsc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectScalarArrays(10, 10, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, AreaMatrix.class);
        assertEquals(10, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(10, lmdsc10.cardinality());
        assertEquals(5 * 11, lmdsc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmdsc10.getDisplayUnit());

        AreaMatrix lmssc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectScalarArrays(10, 10, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, AreaMatrix.class);
        assertEquals(10, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(10, lmssc10.cardinality());
        assertEquals(5 * 11, lmssc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmssc10.getDisplayUnit());

        AreaMatrix lmdtu10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectTuples(10, 10, Area.class), 10, 10, AreaUnit.ACRE,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(10, lmdtu10.rows());
        assertEquals(10, lmdtu10.cols());
        assertEquals(10, lmdtu10.cardinality());
        assertEquals(5 * 11, lmdtu10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.ACRE, lmdtu10.getDisplayUnit());

        AreaMatrix lmstu10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectTuples(10, 10, Area.class), 10, 10, AreaUnit.ACRE,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(10, lmstu10.rows());
        assertEquals(10, lmstu10.cols());
        assertEquals(10, lmstu10.cardinality());
        assertEquals(5 * 11, lmstu10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.ACRE, lmstu10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     * @throws UnitException on error
     */
    @Test
    public void testInstantiateSquareSIUnit() throws UnitException
    {
        SIMatrix si10dd = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(10, 10), SIUnit.of("m2/s3"), StorageType.DENSE);
        assertEquals(10, si10dd.rows());
        assertEquals(10, si10dd.cols());
        assertEquals(100, si10dd.cardinality());
        assertEquals(50 * 101, si10dd.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10dd.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        SIMatrix si10ds =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(10, 10), SIUnit.of("m2/s3"), StorageType.SPARSE);
        assertEquals(10, si10ds.rows());
        assertEquals(10, si10ds.cols());
        assertEquals(100, si10ds.cardinality());
        assertEquals(50 * 101, si10ds.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10ds.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        SIMatrix si10sd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(10, 10), SIUnit.of("m2/s3"), StorageType.DENSE);
        assertEquals(10, si10sd.rows());
        assertEquals(10, si10sd.cols());
        assertEquals(10, si10sd.cardinality());
        assertEquals(5 * 11, si10sd.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10sd.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        SIMatrix si10ss =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(10, 10), SIUnit.of("m2/s3"), StorageType.SPARSE);
        assertEquals(10, si10ss.rows());
        assertEquals(10, si10ss.cols());
        assertEquals(10, si10ss.cardinality());
        assertEquals(5 * 11, si10ss.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10ss.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        assertEquals(si10dd, si10ds.toDense());
        assertEquals(si10ds, si10dd.toSparse());
        assertEquals(si10dd, si10dd.toDense());
        assertEquals(si10ds, si10ds.toSparse());
        assertEquals(si10dd, si10dd.toSparse().toDense());
        assertEquals(si10ds, si10ds.toDense().toSparse());

        assertEquals(si10sd, si10ss.toDense());
        assertEquals(si10ss, si10sd.toSparse());
        assertEquals(si10sd, si10sd.toDense());
        assertEquals(si10ss, si10ss.toSparse());
        assertEquals(si10sd, si10sd.toSparse().toDense());
        assertEquals(si10ss, si10ss.toDense().toSparse());
    }

    // =============================================== RECTANGULAR MATRICES ===================================================

    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     */
    @Test
    public void testInstantiateRectDenseData()
    {
        LengthMatrix lmdkm10 =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(20, 10), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(20, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(200, lmdkm10.cardinality());
        assertEquals(100 * 201 * 1000.0, lmdkm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmdkm10.getDisplayUnit());

        LengthMatrix lmskm10 =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(20, 10), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(20, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(200, lmskm10.cardinality());
        assertEquals(100 * 201 * 1000.0, lmskm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmskm10.getDisplayUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());
        assertEquals(lmdkm10, lmdkm10.toDense());
        assertEquals(lmskm10, lmskm10.toSparse());
        assertTrue(lmdkm10.isDense());
        assertTrue(lmskm10.isSparse());

        LengthMatrix lmdsi10 =
                DoubleMatrix.instantiateSI(DOUBLEMATRIX.denseRectArrays(20, 10), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(20, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(200, lmdsi10.cardinality());
        assertEquals(100 * 201, lmdsi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmdsi10.getDisplayUnit());

        LengthMatrix lmssi10 =
                DoubleMatrix.instantiateSI(DOUBLEMATRIX.denseRectArrays(20, 10), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(20, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(200, lmssi10.cardinality());
        assertEquals(100 * 201, lmssi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmssi10.getDisplayUnit());

        LengthMatrix lmdsc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectScalarArrays(20, 10, Length.class),
                LengthUnit.HECTOMETER, StorageType.DENSE);
        assertEquals(20, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(200, lmdsc10.cardinality());
        assertEquals(100 * 201, lmdsc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmdsc10.getDisplayUnit());

        LengthMatrix lmssc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectScalarArrays(20, 10, Length.class),
                LengthUnit.HECTOMETER, StorageType.SPARSE);
        assertEquals(20, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(200, lmssc10.cardinality());
        assertEquals(100 * 201, lmssc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatRectSparseData()
    {
        LengthMatrix lmdkm10 =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(20, 10), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(20, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(10, lmdkm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lmdkm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmdkm10.getDisplayUnit());

        LengthMatrix lmskm10 =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(20, 10), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(20, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(10, lmskm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lmskm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lmskm10.getDisplayUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());

        LengthMatrix lmdsi10 =
                DoubleMatrix.instantiateSI(DOUBLEMATRIX.sparseRectArrays(20, 10), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(20, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(10, lmdsi10.cardinality());
        assertEquals(5 * 11, lmdsi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmdsi10.getDisplayUnit());

        LengthMatrix lmssi10 =
                DoubleMatrix.instantiateSI(DOUBLEMATRIX.sparseRectArrays(20, 10), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(20, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(10, lmssi10.cardinality());
        assertEquals(5 * 11, lmssi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lmssi10.getDisplayUnit());

        LengthMatrix lmdsc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectScalarArrays(20, 10, Length.class),
                LengthUnit.HECTOMETER, StorageType.DENSE);
        assertEquals(20, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(10, lmdsc10.cardinality());
        assertEquals(5 * 11, lmdsc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmdsc10.getDisplayUnit());

        LengthMatrix lmssc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectScalarArrays(20, 10, Length.class),
                LengthUnit.HECTOMETER, StorageType.SPARSE);
        assertEquals(20, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(10, lmssc10.cardinality());
        assertEquals(5 * 11, lmssc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lmssc10.getDisplayUnit());

        LengthMatrix lmdtu10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectTuples(20, 10, Length.class), 20, 10,
                LengthUnit.NANOMETER, StorageType.DENSE);
        assertEquals(20, lmdtu10.rows());
        assertEquals(10, lmdtu10.cols());
        assertEquals(10, lmdtu10.cardinality());
        assertEquals(5 * 11, lmdtu10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.NANOMETER, lmdtu10.getDisplayUnit());

        LengthMatrix lmstu10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectTuples(20, 10, Length.class), 20, 10,
                LengthUnit.NANOMETER, StorageType.SPARSE);
        assertEquals(20, lmstu10.rows());
        assertEquals(10, lmstu10.cols());
        assertEquals(10, lmstu10.cardinality());
        assertEquals(5 * 11, lmstu10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.NANOMETER, lmstu10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     */
    @Test
    public void testInstantiateRectDenseDataWithClass()
    {
        AreaMatrix lmdkm10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(20, 10), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(20, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(200, lmdkm10.cardinality());
        assertEquals(100 * 201 * 1.0E6, lmdkm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmdkm10.getDisplayUnit());

        AreaMatrix lmskm10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(20, 10), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(20, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(200, lmskm10.cardinality());
        assertEquals(100 * 201 * 1.0E6, lmskm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmskm10.getDisplayUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());

        AreaMatrix lmdsi10 = DoubleMatrix.instantiateSI(DOUBLEMATRIX.denseRectArrays(20, 10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(20, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(200, lmdsi10.cardinality());
        assertEquals(100 * 201, lmdsi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmdsi10.getDisplayUnit());

        AreaMatrix lmssi10 = DoubleMatrix.instantiateSI(DOUBLEMATRIX.denseRectArrays(20, 10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(20, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(200, lmssi10.cardinality());
        assertEquals(100 * 201, lmssi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmssi10.getDisplayUnit());

        AreaMatrix lmdsc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectScalarArrays(20, 10, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, AreaMatrix.class);
        assertEquals(20, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(200, lmdsc10.cardinality());
        assertEquals(100 * 201, lmdsc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmdsc10.getDisplayUnit());

        AreaMatrix lmssc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectScalarArrays(20, 10, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, AreaMatrix.class);
        assertEquals(20, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(200, lmssc10.cardinality());
        assertEquals(100 * 201, lmssc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatRectSparseDataWithClass()
    {
        AreaMatrix lmdkm10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(20, 10), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(20, lmdkm10.rows());
        assertEquals(10, lmdkm10.cols());
        assertEquals(10, lmdkm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lmdkm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmdkm10.getDisplayUnit());

        AreaMatrix lmskm10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(20, 10), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(20, lmskm10.rows());
        assertEquals(10, lmskm10.cols());
        assertEquals(10, lmskm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lmskm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lmskm10.getDisplayUnit());

        assertEquals(lmdkm10, lmdkm10.toSparse().toDense());
        assertEquals(lmskm10, lmskm10.toDense().toSparse());
        assertEquals(lmdkm10, lmskm10.toDense());
        assertEquals(lmskm10, lmdkm10.toSparse());
        assertNotEquals(lmdkm10, lmdkm10.toSparse());
        assertNotEquals(lmskm10, lmskm10.toDense());

        AreaMatrix lmdsi10 = DoubleMatrix.instantiateSI(DOUBLEMATRIX.sparseRectArrays(20, 10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(20, lmdsi10.rows());
        assertEquals(10, lmdsi10.cols());
        assertEquals(10, lmdsi10.cardinality());
        assertEquals(5 * 11, lmdsi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmdsi10.getDisplayUnit());

        AreaMatrix lmssi10 = DoubleMatrix.instantiateSI(DOUBLEMATRIX.sparseRectArrays(20, 10), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(20, lmssi10.rows());
        assertEquals(10, lmssi10.cols());
        assertEquals(10, lmssi10.cardinality());
        assertEquals(5 * 11, lmssi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lmssi10.getDisplayUnit());

        AreaMatrix lmdsc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectScalarArrays(20, 10, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, AreaMatrix.class);
        assertEquals(20, lmdsc10.rows());
        assertEquals(10, lmdsc10.cols());
        assertEquals(10, lmdsc10.cardinality());
        assertEquals(5 * 11, lmdsc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmdsc10.getDisplayUnit());

        AreaMatrix lmssc10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectScalarArrays(20, 10, Area.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, AreaMatrix.class);
        assertEquals(20, lmssc10.rows());
        assertEquals(10, lmssc10.cols());
        assertEquals(10, lmssc10.cardinality());
        assertEquals(5 * 11, lmssc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lmssc10.getDisplayUnit());

        AreaMatrix lmdtu10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectTuples(20, 10, Area.class), 20, 10, AreaUnit.ACRE,
                StorageType.DENSE, AreaMatrix.class);
        assertEquals(20, lmdtu10.rows());
        assertEquals(10, lmdtu10.cols());
        assertEquals(10, lmdtu10.cardinality());
        assertEquals(5 * 11, lmdtu10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.ACRE, lmdtu10.getDisplayUnit());

        AreaMatrix lmstu10 = DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectTuples(20, 10, Area.class), 20, 10, AreaUnit.ACRE,
                StorageType.SPARSE, AreaMatrix.class);
        assertEquals(20, lmstu10.rows());
        assertEquals(10, lmstu10.cols());
        assertEquals(10, lmstu10.cardinality());
        assertEquals(5 * 11, lmstu10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.ACRE, lmstu10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse matrix types with dense data (no zeros).
     * @throws UnitException on error
     */
    @Test
    public void testInstantiateRectSIUnit() throws UnitException
    {
        SIMatrix si10dd = DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(20, 10), SIUnit.of("m2/s3"), StorageType.DENSE);
        assertEquals(20, si10dd.rows());
        assertEquals(10, si10dd.cols());
        assertEquals(200, si10dd.cardinality());
        assertEquals(100 * 201, si10dd.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10dd.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        SIMatrix si10ds =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(20, 10), SIUnit.of("m2/s3"), StorageType.SPARSE);
        assertEquals(20, si10ds.rows());
        assertEquals(10, si10ds.cols());
        assertEquals(200, si10ds.cardinality());
        assertEquals(100 * 201, si10ds.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10ds.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        SIMatrix si10sd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(20, 10), SIUnit.of("m2/s3"), StorageType.DENSE);
        assertEquals(20, si10sd.rows());
        assertEquals(10, si10sd.cols());
        assertEquals(10, si10sd.cardinality());
        assertEquals(5 * 11, si10sd.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10sd.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        SIMatrix si10ss =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(20, 10), SIUnit.of("m2/s3"), StorageType.SPARSE);
        assertEquals(20, si10ss.rows());
        assertEquals(10, si10ss.cols());
        assertEquals(10, si10ss.cardinality());
        assertEquals(5 * 11, si10ss.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10ss.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        assertEquals(si10dd, si10ds.toDense());
        assertEquals(si10ds, si10dd.toSparse());
        assertEquals(si10dd, si10dd.toDense());
        assertEquals(si10ds, si10ds.toSparse());
        assertEquals(si10dd, si10dd.toSparse().toDense());
        assertEquals(si10ds, si10ds.toDense().toSparse());

        assertEquals(si10sd, si10ss.toDense());
        assertEquals(si10ss, si10sd.toSparse());
        assertEquals(si10sd, si10sd.toDense());
        assertEquals(si10ss, si10ss.toSparse());
        assertEquals(si10sd, si10sd.toSparse().toDense());
        assertEquals(si10ss, si10ss.toDense().toSparse());
    }

    // =============================================== EDGE CASE MATRICES ===================================================

    /**
     * Test the instantiation of dense and sparse matrix types with one row or one column, and errors with null pointers and/or
     * zero rows/columns.
     */
    @Test
    public void testInstantiateEdgeCases()
    {
        // DENSE DATA

        SpeedMatrix row1dd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(1, 10), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, row1dd.rows());
        assertEquals(10, row1dd.cols());
        assertEquals(10, row1dd.cardinality());
        assertEquals(5 * 11, row1dd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, row1dd.getDisplayUnit());

        SpeedMatrix col1dd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(10, 1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(10, col1dd.rows());
        assertEquals(1, col1dd.cols());
        assertEquals(10, col1dd.cardinality());
        assertEquals(5 * 11, col1dd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, col1dd.getDisplayUnit());

        SpeedMatrix row1ds =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(1, 10), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, row1ds.rows());
        assertEquals(10, row1ds.cols());
        assertEquals(10, row1ds.cardinality());
        assertEquals(5 * 11, row1ds.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, row1ds.getDisplayUnit());

        SpeedMatrix col1ds =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(10, 1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(10, col1ds.rows());
        assertEquals(1, col1ds.cols());
        assertEquals(10, col1ds.cardinality());
        assertEquals(5 * 11, col1ds.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, col1ds.getDisplayUnit());

        // SPARSE DATA

        SpeedMatrix row1sd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(1, 10), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, row1sd.rows());
        assertEquals(10, row1sd.cols());
        assertEquals(1, row1sd.cardinality());
        assertEquals(1, row1sd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, row1sd.getDisplayUnit());

        SpeedMatrix col1sd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(10, 1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(10, col1sd.rows());
        assertEquals(1, col1sd.cols());
        assertEquals(1, col1sd.cardinality());
        assertEquals(1, col1sd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, col1sd.getDisplayUnit());

        SpeedMatrix row1ss =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(1, 10), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, row1ss.rows());
        assertEquals(10, row1ss.cols());
        assertEquals(1, row1ss.cardinality());
        assertEquals(1, row1ss.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, row1ss.getDisplayUnit());

        SpeedMatrix col1ss =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(10, 1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(10, col1ss.rows());
        assertEquals(1, col1ss.cols());
        assertEquals(1, col1ss.cardinality());
        assertEquals(1, col1ss.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, col1ss.getDisplayUnit());

        // 1 x 1 DENSE DATA

        SpeedMatrix row11dd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(1, 1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, row11dd.rows());
        assertEquals(1, row11dd.cols());
        assertEquals(1, row11dd.cardinality());
        assertEquals(1, row11dd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, row11dd.getDisplayUnit());

        SpeedMatrix col11dd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(1, 1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, col11dd.rows());
        assertEquals(1, col11dd.cols());
        assertEquals(1, col11dd.cardinality());
        assertEquals(1, col11dd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, col11dd.getDisplayUnit());

        SpeedMatrix row11ds =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(1, 1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, row11ds.rows());
        assertEquals(1, row11ds.cols());
        assertEquals(1, row11ds.cardinality());
        assertEquals(1, row11ds.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, row11ds.getDisplayUnit());

        SpeedMatrix col11ds =
                DoubleMatrix.instantiate(DOUBLEMATRIX.denseRectArrays(1, 1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, col11ds.rows());
        assertEquals(1, col11ds.cols());
        assertEquals(1, col11ds.cardinality());
        assertEquals(1, col11ds.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, col11ds.getDisplayUnit());

        // 1 x 1 SPARSE DATA

        SpeedMatrix row11sd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(1, 1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, row11sd.rows());
        assertEquals(1, row11sd.cols());
        assertEquals(1, row11sd.cardinality());
        assertEquals(1, row11sd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, row11sd.getDisplayUnit());

        SpeedMatrix col11sd =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(1, 1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, col11sd.rows());
        assertEquals(1, col11sd.cols());
        assertEquals(1, col11sd.cardinality());
        assertEquals(1, col11sd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, col11sd.getDisplayUnit());

        SpeedMatrix row11ss =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(1, 1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, row11ss.rows());
        assertEquals(1, row11ss.cols());
        assertEquals(1, row11ss.cardinality());
        assertEquals(1, row11ss.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, row11ss.getDisplayUnit());

        SpeedMatrix col11ss =
                DoubleMatrix.instantiate(DOUBLEMATRIX.sparseRectArrays(1, 1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, col11ss.rows());
        assertEquals(1, col11ss.cols());
        assertEquals(1, col11ss.cardinality());
        assertEquals(1, col11ss.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, col11ss.getDisplayUnit());

        // NULL / ZERO ROWS / ZERO COLS

        double[][] d0_1 = new double[0][1];
        double[][] d1_0 = new double[1][];
        d1_0[0] = new double[0];
        double[][] d0_0 = new double[0][0];
        double[][] d1_1 = new double[1][];
        d1_1[0] = new double[1];

        new Try()
        {
            public @Override void execute()
            {
                DoubleMatrix.instantiate(d0_1, SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
            }
        }.test("constructing matrix with zero rows should have thrown an exception", ValueRuntimeException.class);

        new Try()
        {
            public @Override void execute()
            {
                DoubleMatrix.instantiate(d1_0, SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
            }
        }.test("constructing matrix with zero columns should have thrown an exception", ValueRuntimeException.class);

        new Try()
        {
            public @Override void execute()
            {
                DoubleMatrix.instantiate(d0_0, SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
            }
        }.test("constructing matrix with zero rows and cols should have thrown an exception", ValueRuntimeException.class);

        new Try()
        {
            public @Override void execute()
            {
                DoubleMatrix.instantiate((double[][]) null, SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
            }
        }.test("constructing matrix with null input should have thrown an exception", NullPointerException.class);

        new Try()
        {
            public @Override void execute()
            {
                DoubleMatrix.instantiate(d1_1, null, StorageType.DENSE);
            }
        }.test("constructing matrix with null unit should have thrown an exception", NullPointerException.class);

        new Try()
        {
            public @Override void execute()
            {
                DoubleMatrix.instantiate(d1_1, SpeedUnit.METER_PER_SECOND, null);
            }
        }.test("constructing matrix with null storage type should have thrown an exception", NullPointerException.class);
    }
}
