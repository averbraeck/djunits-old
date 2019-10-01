package org.djunits4.value.vfloat.vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.djunits4.Try;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.userdefined.FloatJerk;
import org.djunits4.userdefined.FloatJerkVector;
import org.djunits4.userdefined.JerkUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatArea;
import org.djunits4.value.vfloat.scalar.FloatLength;
import org.djunits4.value.vfloat.vector.base.FloatVector;
import org.junit.Test;

/**
 * FloatVectorInstantiateTest.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class FloatVectorInstantiateTest
{
    /**
     * Test the instantiation of dense and sparse vector types with dense data (no zeros).
     */
    @Test
    public void testInstantiateDenseData()
    {
        FloatLengthVector lvdkm10 = FloatVector.instantiate(FLOATVECTOR.denseArray(100), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(100, lvdkm10.size());
        assertEquals(100, lvdkm10.cardinality());
        assertEquals(50 * 101 * 1000.0, lvdkm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lvdkm10.getDisplayUnit());

        FloatLengthVector lvskm10 = FloatVector.instantiate(FLOATVECTOR.denseArray(100), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(100, lvskm10.size());
        assertEquals(100, lvskm10.cardinality());
        assertEquals(50 * 101 * 1000.0, lvskm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertEquals(lvdkm10, lvdkm10.toSparse()); // dense and sparse are the same if content is the same
        assertEquals(lvskm10, lvskm10.toDense()); // dense and sparse are the same if content is the same
        assertEquals(lvdkm10, lvdkm10.toDense());
        assertEquals(lvskm10, lvskm10.toSparse());
        assertTrue(lvdkm10.isDense());
        assertTrue(lvskm10.isSparse());

        FloatLengthVector lvdsi10 =
                FloatVector.instantiateSI(FLOATVECTOR.denseArray(100), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(100, lvdsi10.size());
        assertEquals(100, lvdsi10.cardinality());
        assertEquals(50 * 101, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lvdsi10.getDisplayUnit());

        FloatLengthVector lvssi10 =
                FloatVector.instantiateSI(FLOATVECTOR.denseArray(100), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(100, lvssi10.size());
        assertEquals(100, lvssi10.cardinality());
        assertEquals(50 * 101, lvssi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lvssi10.getDisplayUnit());

        FloatLengthVector lvdsc10 = FloatVector.instantiate(FLOATVECTOR.denseScalarArray(100, FloatLength.class), LengthUnit.HECTOMETER,
                StorageType.DENSE);
        assertEquals(100, lvdsc10.size());
        assertEquals(100, lvdsc10.cardinality());
        assertEquals(50 * 101, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lvdsc10.getDisplayUnit());

        FloatLengthVector lvssc10 = FloatVector.instantiate(FLOATVECTOR.denseScalarArray(100, FloatLength.class), LengthUnit.HECTOMETER,
                StorageType.SPARSE);
        assertEquals(100, lvssc10.size());
        assertEquals(100, lvssc10.cardinality());
        assertEquals(50 * 101, lvssc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse vector types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSparseData()
    {
        FloatLengthVector lvdkm10 = FloatVector.instantiate(FLOATVECTOR.sparseArray(100), LengthUnit.KILOMETER, StorageType.DENSE);
        assertEquals(100, lvdkm10.size());
        assertEquals(10, lvdkm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lvdkm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lvdkm10.getDisplayUnit());

        FloatLengthVector lvskm10 =
                FloatVector.instantiate(FLOATVECTOR.sparseArray(100), LengthUnit.KILOMETER, StorageType.SPARSE);
        assertEquals(100, lvskm10.size());
        assertEquals(10, lvskm10.cardinality());
        assertEquals(5 * 11 * 1000.0, lvskm10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.KILOMETER, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertEquals(lvdkm10, lvdkm10.toSparse()); // dense and sparse are the same if content is the same
        assertEquals(lvskm10, lvskm10.toDense()); // dense and sparse are the same if content is the same

        FloatLengthVector lvdsi10 =
                FloatVector.instantiateSI(FLOATVECTOR.sparseArray(100), LengthUnit.CENTIMETER, StorageType.DENSE);
        assertEquals(100, lvdsi10.size());
        assertEquals(10, lvdsi10.cardinality());
        assertEquals(5 * 11, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lvdsi10.getDisplayUnit());

        FloatLengthVector lvssi10 =
                FloatVector.instantiateSI(FLOATVECTOR.sparseArray(100), LengthUnit.CENTIMETER, StorageType.SPARSE);
        assertEquals(100, lvssi10.size());
        assertEquals(10, lvssi10.cardinality());
        assertEquals(5 * 11, lvssi10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.CENTIMETER, lvssi10.getDisplayUnit());

        FloatLengthVector lvdsc10 = FloatVector.instantiate(FLOATVECTOR.sparseScalarArray(100, FloatLength.class),
                LengthUnit.HECTOMETER, StorageType.DENSE);
        assertEquals(100, lvdsc10.size());
        assertEquals(10, lvdsc10.cardinality());
        assertEquals(5 * 11, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lvdsc10.getDisplayUnit());

        FloatLengthVector lvssc10 = FloatVector.instantiate(FLOATVECTOR.sparseScalarArray(100, FloatLength.class),
                LengthUnit.HECTOMETER, StorageType.SPARSE);
        assertEquals(100, lvssc10.size());
        assertEquals(10, lvssc10.cardinality());
        assertEquals(5 * 11, lvssc10.zSum().getSI(), 0.001);
        assertEquals(LengthUnit.HECTOMETER, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse vector types with dense data (no zeros).
     */
    @Test
    public void testInstantiateDenseDataWithClass()
    {
        FloatAreaVector lvdkm10 = FloatVector.instantiate(FLOATVECTOR.denseArray(100), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, FloatAreaVector.class);
        assertEquals(100, lvdkm10.size());
        assertEquals(100, lvdkm10.cardinality());
        assertEquals(50 * 101 * 1.0E6, lvdkm10.zSum().getSI(), 1000.0);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lvdkm10.getDisplayUnit());

        FloatAreaVector lvskm10 = FloatVector.instantiate(FLOATVECTOR.denseArray(100), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, FloatAreaVector.class);
        assertEquals(100, lvskm10.size());
        assertEquals(100, lvskm10.cardinality());
        assertEquals(50 * 101 * 1.0E6, lvskm10.zSum().getSI(), 1000.0);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertEquals(lvdkm10, lvdkm10.toSparse()); // dense and sparse are the same if content is the same
        assertEquals(lvskm10, lvskm10.toDense()); // dense and sparse are the same if content is the same

        FloatAreaVector lvdsi10 = FloatVector.instantiateSI(FLOATVECTOR.denseArray(100), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, FloatAreaVector.class);
        assertEquals(100, lvdsi10.size());
        assertEquals(100, lvdsi10.cardinality());
        assertEquals(50 * 101, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lvdsi10.getDisplayUnit());

        FloatAreaVector lvssi10 = FloatVector.instantiateSI(FLOATVECTOR.denseArray(100), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, FloatAreaVector.class);
        assertEquals(100, lvssi10.size());
        assertEquals(100, lvssi10.cardinality());
        assertEquals(50 * 101, lvssi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lvssi10.getDisplayUnit());

        FloatAreaVector lvdsc10 = FloatVector.instantiate(FLOATVECTOR.denseScalarArray(100, FloatArea.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, FloatAreaVector.class);
        assertEquals(100, lvdsc10.size());
        assertEquals(100, lvdsc10.cardinality());
        assertEquals(50 * 101, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lvdsc10.getDisplayUnit());

        FloatAreaVector lvssc10 = FloatVector.instantiate(FLOATVECTOR.denseScalarArray(100, FloatArea.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, FloatAreaVector.class);
        assertEquals(100, lvssc10.size());
        assertEquals(100, lvssc10.cardinality());
        assertEquals(50 * 101, lvssc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse vector types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSparseDataWithClass()
    {
        FloatAreaVector lvdkm10 = FloatVector.instantiate(FLOATVECTOR.sparseArray(100), AreaUnit.SQUARE_KILOMETER,
                StorageType.DENSE, FloatAreaVector.class);
        assertEquals(100, lvdkm10.size());
        assertEquals(10, lvdkm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lvdkm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lvdkm10.getDisplayUnit());

        FloatAreaVector lvskm10 = FloatVector.instantiate(FLOATVECTOR.sparseArray(100), AreaUnit.SQUARE_KILOMETER,
                StorageType.SPARSE, FloatAreaVector.class);
        assertEquals(100, lvskm10.size());
        assertEquals(10, lvskm10.cardinality());
        assertEquals(5 * 11 * 1.0E6, lvskm10.zSum().getSI(), 0.1);
        assertEquals(AreaUnit.SQUARE_KILOMETER, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertEquals(lvdkm10, lvdkm10.toSparse());
        assertEquals(lvskm10, lvskm10.toDense());

        FloatAreaVector lvdsi10 = FloatVector.instantiateSI(FLOATVECTOR.sparseArray(100), AreaUnit.SQUARE_CENTIMETER,
                StorageType.DENSE, FloatAreaVector.class);
        assertEquals(100, lvdsi10.size());
        assertEquals(10, lvdsi10.cardinality());
        assertEquals(5 * 11, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lvdsi10.getDisplayUnit());

        FloatAreaVector lvssi10 = FloatVector.instantiateSI(FLOATVECTOR.sparseArray(100), AreaUnit.SQUARE_CENTIMETER,
                StorageType.SPARSE, FloatAreaVector.class);
        assertEquals(100, lvssi10.size());
        assertEquals(10, lvssi10.cardinality());
        assertEquals(5 * 11, lvssi10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_CENTIMETER, lvssi10.getDisplayUnit());

        FloatAreaVector lvdsc10 = FloatVector.instantiate(FLOATVECTOR.sparseScalarArray(100, FloatArea.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.DENSE, FloatAreaVector.class);
        assertEquals(100, lvdsc10.size());
        assertEquals(10, lvdsc10.cardinality());
        assertEquals(5 * 11, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lvdsc10.getDisplayUnit());

        FloatAreaVector lvssc10 = FloatVector.instantiate(FLOATVECTOR.sparseScalarArray(100, FloatArea.class),
                AreaUnit.SQUARE_HECTOMETER, StorageType.SPARSE, FloatAreaVector.class);
        assertEquals(100, lvssc10.size());
        assertEquals(10, lvssc10.cardinality());
        assertEquals(5 * 11, lvssc10.zSum().getSI(), 0.001);
        assertEquals(AreaUnit.SQUARE_HECTOMETER, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse vector types with dense data (no zeros).
     */
    @Test
    public void testInstantiateDenseDataWithUserDefinedClass()
    {
        FloatJerkVector lvdkm10 =
                FloatVector.instantiate(FLOATVECTOR.denseArray(100), JerkUnit.JERK, StorageType.DENSE, FloatJerkVector.class);
        assertEquals(100, lvdkm10.size());
        assertEquals(100, lvdkm10.cardinality());
        assertEquals(50 * 101, lvdkm10.zSum().getSI(), 0.1);
        assertEquals(JerkUnit.JERK, lvdkm10.getDisplayUnit());

        FloatJerkVector lvskm10 =
                FloatVector.instantiate(FLOATVECTOR.denseArray(100), JerkUnit.JERK, StorageType.SPARSE, FloatJerkVector.class);
        assertEquals(100, lvskm10.size());
        assertEquals(100, lvskm10.cardinality());
        assertEquals(50 * 101, lvskm10.zSum().getSI(), 0.1);
        assertEquals(JerkUnit.JERK, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertEquals(lvdkm10, lvdkm10.toSparse()); // dense and sparse are the same if content is the same
        assertEquals(lvskm10, lvskm10.toDense()); // dense and sparse are the same if content is the same

        FloatJerkVector lvdsi10 =
                FloatVector.instantiateSI(FLOATVECTOR.denseArray(100), JerkUnit.JERK, StorageType.DENSE, FloatJerkVector.class);
        assertEquals(100, lvdsi10.size());
        assertEquals(100, lvdsi10.cardinality());
        assertEquals(50 * 101, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvdsi10.getDisplayUnit());

        FloatJerkVector lvssi10 =
                FloatVector.instantiateSI(FLOATVECTOR.denseArray(100), JerkUnit.JERK, StorageType.SPARSE, FloatJerkVector.class);
        assertEquals(100, lvssi10.size());
        assertEquals(100, lvssi10.cardinality());
        assertEquals(50 * 101, lvssi10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvssi10.getDisplayUnit());

        FloatJerkVector lvdsc10 = FloatVector.instantiate(FLOATVECTOR.denseScalarArray(100, FloatJerk.class), JerkUnit.JERK,
                StorageType.DENSE, FloatJerkVector.class);
        assertEquals(100, lvdsc10.size());
        assertEquals(100, lvdsc10.cardinality());
        assertEquals(50 * 101, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvdsc10.getDisplayUnit());

        FloatJerkVector lvssc10 = FloatVector.instantiate(FLOATVECTOR.denseScalarArray(100, FloatJerk.class), JerkUnit.JERK,
                StorageType.SPARSE, FloatJerkVector.class);
        assertEquals(100, lvssc10.size());
        assertEquals(100, lvssc10.cardinality());
        assertEquals(50 * 101, lvssc10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse vector types with sparse data (90% zeros).
     */
    @Test
    public void testInstantiatSparseDataWithUserDefinedClass()
    {
        FloatJerkVector lvdkm10 =
                FloatVector.instantiate(FLOATVECTOR.sparseArray(100), JerkUnit.JERK, StorageType.DENSE, FloatJerkVector.class);
        assertEquals(100, lvdkm10.size());
        assertEquals(10, lvdkm10.cardinality());
        assertEquals(5 * 11, lvdkm10.zSum().getSI(), 0.1);
        assertEquals(JerkUnit.JERK, lvdkm10.getDisplayUnit());

        FloatJerkVector lvskm10 =
                FloatVector.instantiate(FLOATVECTOR.sparseArray(100), JerkUnit.JERK, StorageType.SPARSE, FloatJerkVector.class);
        assertEquals(100, lvskm10.size());
        assertEquals(10, lvskm10.cardinality());
        assertEquals(5 * 11, lvskm10.zSum().getSI(), 0.1);
        assertEquals(JerkUnit.JERK, lvskm10.getDisplayUnit());

        assertEquals(lvdkm10, lvdkm10.toSparse().toDense());
        assertEquals(lvskm10, lvskm10.toDense().toSparse());
        assertEquals(lvdkm10, lvskm10.toDense());
        assertEquals(lvskm10, lvdkm10.toSparse());
        assertEquals(lvdkm10, lvdkm10.toSparse()); // dense and sparse are the same if content is the same
        assertEquals(lvskm10, lvskm10.toDense()); // dense and sparse are the same if content is the same

        FloatJerkVector lvdsi10 =
                FloatVector.instantiateSI(FLOATVECTOR.sparseArray(100), JerkUnit.JERK, StorageType.DENSE, FloatJerkVector.class);
        assertEquals(100, lvdsi10.size());
        assertEquals(10, lvdsi10.cardinality());
        assertEquals(5 * 11, lvdsi10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvdsi10.getDisplayUnit());

        FloatJerkVector lvssi10 =
                FloatVector.instantiateSI(FLOATVECTOR.sparseArray(100), JerkUnit.JERK, StorageType.SPARSE, FloatJerkVector.class);
        assertEquals(100, lvssi10.size());
        assertEquals(10, lvssi10.cardinality());
        assertEquals(5 * 11, lvssi10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvssi10.getDisplayUnit());

        FloatJerkVector lvdsc10 = FloatVector.instantiate(FLOATVECTOR.sparseScalarArray(100, FloatJerk.class), JerkUnit.JERK,
                StorageType.DENSE, FloatJerkVector.class);
        assertEquals(100, lvdsc10.size());
        assertEquals(10, lvdsc10.cardinality());
        assertEquals(5 * 11, lvdsc10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvdsc10.getDisplayUnit());

        FloatJerkVector lvssc10 = FloatVector.instantiate(FLOATVECTOR.sparseScalarArray(100, FloatJerk.class), JerkUnit.JERK,
                StorageType.SPARSE, FloatJerkVector.class);
        assertEquals(100, lvssc10.size());
        assertEquals(10, lvssc10.cardinality());
        assertEquals(5 * 11, lvssc10.zSum().getSI(), 0.001);
        assertEquals(JerkUnit.JERK, lvssc10.getDisplayUnit());
    }

    /**
     * Test the instantiation of dense and sparse vector types with dense data (no zeros).
     * @throws UnitException on error
     */
    @Test
    public void testInstantiateSIUnit() throws UnitException
    {
        FloatSIVector si10dd = FloatVector.instantiate(FLOATVECTOR.denseArray(100), SIUnit.of("m2/s3"), StorageType.DENSE);
        assertEquals(100, si10dd.size());
        assertEquals(100, si10dd.cardinality());
        assertEquals(50 * 101, si10dd.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10dd.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        FloatSIVector si10ds = FloatVector.instantiate(FLOATVECTOR.denseArray(100), SIUnit.of("m2/s3"), StorageType.SPARSE);
        assertEquals(100, si10ds.size());
        assertEquals(100, si10ds.cardinality());
        assertEquals(50 * 101, si10ds.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10ds.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        FloatSIVector si10sd = FloatVector.instantiate(FLOATVECTOR.sparseArray(100), SIUnit.of("m2/s3"), StorageType.DENSE);
        assertEquals(100, si10sd.size());
        assertEquals(10, si10sd.cardinality());
        assertEquals(5 * 11, si10sd.zSum().getSI(), 0.001);
        assertEquals("m2/s3", si10sd.getDisplayUnit().getUnitBase().getSiDimensions().toString(true, false, false));

        FloatSIVector si10ss = FloatVector.instantiate(FLOATVECTOR.sparseArray(100), SIUnit.of("m2/s3"), StorageType.SPARSE);
        assertEquals(100, si10ss.size());
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
     * Test the instantiation of dense and sparse vector types with one vect or one column, and errors with null pointers and/or
     * zero vects/columns.
     */
    @Test
    public void testInstantiateEdgeCases()
    {
        // DENSE DATA

        FloatSpeedVector vect1dd =
                FloatVector.instantiate(FLOATVECTOR.denseArray(1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, vect1dd.size());
        assertEquals(1, vect1dd.cardinality());
        assertEquals(1, vect1dd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, vect1dd.getDisplayUnit());

        FloatSpeedVector vect1ds =
                FloatVector.instantiate(FLOATVECTOR.denseArray(1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, vect1ds.size());
        assertEquals(1, vect1ds.cardinality());
        assertEquals(1, vect1ds.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, vect1ds.getDisplayUnit());

        // SPARSE DATA

        FloatSpeedVector vect1sd =
                FloatVector.instantiate(FLOATVECTOR.sparseArray(1), SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
        assertEquals(1, vect1sd.size());
        assertEquals(1, vect1sd.cardinality());
        assertEquals(1, vect1sd.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, vect1sd.getDisplayUnit());

        FloatSpeedVector vect1ss =
                FloatVector.instantiate(FLOATVECTOR.sparseArray(1), SpeedUnit.METER_PER_SECOND, StorageType.SPARSE);
        assertEquals(1, vect1ss.size());
        assertEquals(1, vect1ss.cardinality());
        assertEquals(1, vect1ss.zSum().getSI(), 0.001);
        assertEquals(SpeedUnit.METER_PER_SECOND, vect1ss.getDisplayUnit());

        // NULL / ZERO ROWS / ZERO COLS

        float[] d0 = new float[0];
        float[] d1 = new float[1];

        new Try()
        {
            public @Override void execute()
            {
                FloatVector.instantiate(d0, SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
            }
        }.test("constructing vector with zero length should have thrown an exception", ValueRuntimeException.class);

        new Try()
        {
            public @Override void execute()
            {
                FloatVector.instantiate((float[]) null, SpeedUnit.METER_PER_SECOND, StorageType.DENSE);
            }
        }.test("constructing vector with null input should have thrown an exception", NullPointerException.class);

        new Try()
        {
            public @Override void execute()
            {
                FloatVector.instantiate(d1, null, StorageType.DENSE);
            }
        }.test("constructing vector with null unit should have thrown an exception", NullPointerException.class);

        new Try()
        {
            public @Override void execute()
            {
                FloatVector.instantiate(d1, SpeedUnit.METER_PER_SECOND, null);
            }
        }.test("constructing vector with null storage type should have thrown an exception", NullPointerException.class);
    }
}
