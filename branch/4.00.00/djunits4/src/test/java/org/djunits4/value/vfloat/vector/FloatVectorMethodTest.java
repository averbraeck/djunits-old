package org.djunits4.value.vfloat.vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.djunits4.Try;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.function.FloatMathFunctions;
import org.djunits4.value.vfloat.scalar.FloatArea;
import org.djunits4.value.vfloat.scalar.FloatDuration;
import org.djunits4.value.vfloat.vector.base.FloatVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;
import org.junit.Test;

/**
 * Test the incrementBy, etc. methods.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatVectorMethodTest
{

    /**
     * Test the standard methods of all vector classes.
     * @throws UnitException on error
     * @throws ValueRuntimeException on error
     */
    @Test
    public void testVectorMethods() throws ValueRuntimeException, UnitException
    {
        float[] denseTestData = FLOATVECTOR.denseArray(105);
        float[] sparseTestData = FLOATVECTOR.sparseArray(105);
        float[] reverseSparseTestData = new float[sparseTestData.length];
        // sparseTestData and reverseSparseTestData should not "run out of values" at the same index
        for (int index = 0; index < sparseTestData.length; index++)
        {
            reverseSparseTestData[reverseSparseTestData.length - 1 - index] = sparseTestData[index];
        }
        // Ensure that both have a value at some index (i.c. 10)
        sparseTestData[10] = 123.456f;
        reverseSparseTestData[10] = sparseTestData[10];

        for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
        {
            for (AreaUnit au : new AreaUnit[] { AreaUnit.SQUARE_METER, AreaUnit.ACRE })
            {
                float[] testData = storageType.equals(StorageType.DENSE) ? denseTestData : sparseTestData;
                FloatAreaVector am =
                        FloatVector.instantiate(FloatVectorData.instantiate(testData, au.getScale(), storageType), au);

                // SPARSE AND DENSE
                assertEquals(am, am.toSparse());
                assertEquals(am, am.toDense());
                assertEquals(am, am.toSparse().toDense());
                assertEquals(am, am.toDense().toSparse());
                assertEquals(am.hashCode(), am.toSparse().hashCode());
                assertEquals(am.hashCode(), am.toDense().hashCode());
                assertTrue(am.toDense().isDense());
                assertFalse(am.toDense().isSparse());
                assertTrue(am.toSparse().isSparse());
                assertFalse(am.toSparse().isDense());

                // EQUALS
                assertEquals(am, am);
                assertNotEquals(am, new Object());
                assertNotEquals(am, null);
                assertNotEquals(am, FloatVector.instantiate(
                        FloatVectorData.instantiate(testData, LengthUnit.METER.getScale(), storageType), LengthUnit.METER));
                assertNotEquals(am, am.divide(2.0d));

                // MUTABLE
                assertFalse(am.isMutable());
                FloatAreaVector ammut = am.mutable();
                assertTrue(ammut.isMutable());
                assertFalse(am.isMutable());
                FloatAreaVector ammut2 = ammut.multiplyBy(1.0);
                assertEquals(am, ammut2);
                assertTrue(ammut.isMutable());
                assertFalse(am.isMutable());
                assertTrue(ammut2.isMutable());
                ammut2 = ammut2.mutable().divideBy(2.0);
                assertEquals(am, ammut);
                assertNotEquals(am, ammut2);

                // ZSUM and CARDINALITY
                FloatArea zSum = am.zSum();
                double sum = 0;
                int card = 0;
                for (int index = 0; index < testData.length; index++)
                {
                    sum += testData[index];
                    card += testData[index] == 0.0d ? 0 : 1;
                }
                assertEquals("zSum", sum, zSum.getInUnit(), 0.1);
                assertEquals("cardinality", card, am.cardinality());

                // INCREMENTBY(SCALAR) and DECREMENTBY(SCALAR)
                FloatAreaVector amold = am.clone();
                FloatArea fa = FloatArea.of(10.0f, "m^2");
                FloatAreaVector aminc = am.mutable().incrementBy(fa).immutable();
                FloatAreaVector amdec = am.mutable().decrementBy(fa).immutable();
                FloatAreaVector amid = aminc.mutable().decrementBy(fa);
                assertEquals("immutable vector should not change when converted to mutable", am, amold);
                for (int index = 0; index < testData.length; index++)
                {
                    assertEquals("increment and decrement with scalar should result in same vector", am.getSI(index),
                            amid.getSI(index), 0.1);
                    assertEquals("m + s = (m+s)", au.getScale().toStandardUnit(testData[index]) + 10.0, aminc.getSI(index),
                            0.1);
                    assertEquals("m - s = (m-s)", au.getScale().toStandardUnit(testData[index]) - 10.0, amdec.getSI(index),
                            0.1);
                }

                // MULTIPLYBY() and DIVIDEBY(), TIMES(), DIVIDE()
                FloatAreaVector amt5 = am.mutable().multiplyBy(5.0d).immutable();
                FloatAreaVector amd5 = am.mutable().divideBy(5.0d).immutable();
                FloatAreaVector amtd = amt5.mutable().divideBy(5.0d);
                FloatAreaVector amtimD = am.times(5.0d);
                FloatAreaVector amtimF = am.times(5.0f);
                FloatAreaVector amdivD = am.divide(5.0d);
                FloatAreaVector amdivF = am.divide(5.0f);
                for (int index = 0; index < testData.length; index++)
                {
                    assertEquals("times followed by divide with constant should result in same vector", am.getSI(index),
                            amtd.getSI(index), 0.1);
                    assertEquals("m * 5.0 = (m*5.0)", au.getScale().toStandardUnit(testData[index]) * 5.0d, amt5.getSI(index),
                            0.2);
                    assertEquals("m / 5.0 = (m/5.0)", au.getScale().toStandardUnit(testData[index]) / 5.0d, amd5.getSI(index),
                            0.1);
                    assertEquals("amtimD", amt5.getSI(index), amtimD.getSI(index), 0.1d);
                    assertEquals("amtimF", amt5.getSI(index), amtimF.getSI(index), 0.1d);
                    assertEquals("amdivD", amd5.getSI(index), amdivD.getSI(index), 0.01d);
                    assertEquals("amdivD", amd5.getSI(index), amdivF.getSI(index), 0.01d);
                }

                // GET(), GETINUNIT()
                assertEquals("get()", new FloatArea(testData[2], au), am.get(2));
                assertEquals("getSI()", au.getScale().toStandardUnit(testData[2]), am.getSI(2), 0.1);
                assertEquals("getInUnit()", testData[2], am.getInUnit(2), 0.1);
                assertEquals("getInUnit(unit)",
                        AreaUnit.SQUARE_YARD.getScale().fromStandardUnit(au.getScale().toStandardUnit(testData[2])),
                        am.getInUnit(2, AreaUnit.SQUARE_YARD), 0.1);

                // SET(), SETINUNIT()
                FloatArea fasqft = new FloatArea(10.5d, AreaUnit.SQUARE_FOOT);
                FloatAreaVector famChange = am.clone().mutable();
                famChange.set(2, fasqft);
                assertEquals("set()", fasqft.si, famChange.get(2).si, 0.1d);
                famChange = am.clone().mutable();
                famChange.setSI(2, 123.4f);
                assertEquals("setSI()", 123.4d, famChange.get(2).si, 0.1d);
                famChange = am.clone().mutable();
                famChange.setInUnit(2, 1.2f);
                assertEquals("setInUnit()", 1.2d, famChange.getInUnit(2), 0.1d);
                famChange = am.clone().mutable();
                famChange.setInUnit(2, 1.5f, AreaUnit.HECTARE);
                assertEquals("setInUnit(unit)", 15000.0d, famChange.get(2).si, 1.0d);

                // GETVALUES(), GETSCALARS()
                float[] valsi = am.getValuesSI();
                float[] valunit = am.getValuesInUnit();
                float[] valsqft = am.getValuesInUnit(AreaUnit.SQUARE_YARD);
                FloatArea[] valscalars = am.getScalars();
                for (int index = 0; index < testData.length; index++)
                {
                    assertEquals("getValuesSI()", au.getScale().toStandardUnit(testData[index]), valsi[index], 0.1);
                    assertEquals("getValuesInUnit()", testData[index], valunit[index], 0.1);
                    assertEquals("getValuesInUnit(unit)",
                            AreaUnit.SQUARE_YARD.getScale().fromStandardUnit(au.getScale().toStandardUnit(testData[index])),
                            valsqft[index], 0.1);
                    assertEquals("getValuesInUnit(unit)", au.getScale().toStandardUnit(testData[index]), valscalars[index].si,
                            0.1);
                }

                // ASSIGN FUNCTION ABS, CEIL, FLOOR, NEG, RINT
                FloatAreaVector amdiv2 = am.divide(2.0d);
                assertEquals(am.getStorageType(), amdiv2.getStorageType());
                assertEquals(am.getDisplayUnit(), amdiv2.getDisplayUnit());
                FloatAreaVector amAbs = amdiv2.mutable().abs().immutable();
                assertEquals(am.getStorageType(), amAbs.getStorageType());
                assertEquals(am.getDisplayUnit(), amAbs.getDisplayUnit());
                FloatAreaVector amCeil = amdiv2.mutable().ceil().immutable();
                assertEquals(am.getStorageType(), amCeil.getStorageType());
                assertEquals(am.getDisplayUnit(), amCeil.getDisplayUnit());
                FloatAreaVector amFloor = amdiv2.mutable().floor().immutable();
                assertEquals(am.getStorageType(), amFloor.getStorageType());
                assertEquals(am.getDisplayUnit(), amFloor.getDisplayUnit());
                FloatAreaVector amNeg = amdiv2.mutable().neg().immutable();
                assertEquals(am.getStorageType(), amNeg.getStorageType());
                assertEquals(am.getDisplayUnit(), amNeg.getDisplayUnit());
                FloatAreaVector amRint = amdiv2.mutable().rint().immutable();
                assertEquals(am.getStorageType(), amRint.getStorageType());
                assertEquals(am.getDisplayUnit(), amRint.getDisplayUnit());
                for (int index = 0; index < testData.length; index++)
                {
                    // TODO: Should be rounded IN THE UNIT rather than BY SI VALUES
                    assertEquals("div2", au.getScale().toStandardUnit(testData[index]) / 2.0d, amdiv2.getSI(index), 0.1d);
                    assertEquals("abs", Math.abs(au.getScale().toStandardUnit(testData[index]) / 2.0d), amAbs.getSI(index),
                            0.1d);
                    assertEquals("ceil", Math.ceil(au.getScale().toStandardUnit(testData[index]) / 2.0d), amCeil.getSI(index),
                            0.1d);
                    assertEquals("floor", Math.floor(au.getScale().toStandardUnit(testData[index]) / 2.0d),
                            amFloor.getSI(index), 0.1d);
                    assertEquals("neg", -au.getScale().toStandardUnit(testData[index]) / 2.0d, amNeg.getSI(index), 0.1d);
                    assertEquals("rint", Math.rint(au.getScale().toStandardUnit(testData[index]) / 2.0d), amRint.getSI(index),
                            0.1d);
                }

                // TEST METHODS THAT INVOLVE TWO VECTOR INSTANCES

                for (StorageType storageType2 : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
                {
                    float[] testData2 = storageType2.equals(StorageType.DENSE) ? denseTestData : reverseSparseTestData;
                    for (AreaUnit au2 : new AreaUnit[] { AreaUnit.SQUARE_METER, AreaUnit.ACRE })
                    {

                        // PLUS and INCREMENTBY(VECTOR)
                        FloatAreaVector am2 = FloatVector
                                .instantiate(FloatVectorData.instantiate(testData2, au2.getScale(), storageType2), au2);
                        FloatAreaVector amSum1 = am.plus(am2);
                        FloatAreaVector amSum2 = am2.plus(am);
                        FloatAreaVector amSum3 = am.mutable().incrementBy(am2).immutable();
                        // different order of running out of nonzero values
                        FloatAreaVector amSum4 = am2.mutable().incrementBy(am).immutable();
                        assertEquals("a+b == b+a", amSum1, amSum2);
                        assertEquals("a+b == b+a", amSum1, amSum3);
                        assertEquals("a+c == c+a", amSum1, amSum4);
                        for (int index = 0; index < testData.length; index++)
                        {
                            float tolerance =
                                    Float.isFinite(amSum1.getSI(index)) ? Math.abs((float) (amSum1.getSI(index) / 10000.0d)) : 0.1f;
                            assertEquals("value in vector matches", au.getScale().toStandardUnit(testData[index])
                                    + au2.getScale().toStandardUnit(testData2[index]), amSum1.getSI(index), tolerance);
                        }

                        // MINUS and DECREMENTBY(VECTOR)
                        FloatAreaVector amDiff1 = am.minus(am2);
                        FloatAreaVector amDiff2 = am2.minus(am).mutable().neg();
                        FloatAreaVector amDiff3 = am.mutable().decrementBy(am2).immutable();
                        // different order of running out of nonzero values
                        FloatAreaVector amDiff4 = am2.mutable().decrementBy(am).neg().immutable();
                        assertEquals("a-b == -(b-a)", amDiff1, amDiff2);
                        assertEquals("a-b == -(b-a)", amDiff1, amDiff3);
                        assertEquals("a-c == -(c-a)", amDiff1, amDiff4);
                        for (int index = 0; index < testData.length; index++)
                        {
                            float tolerance =
                                    Float.isFinite(amDiff1.getSI(index)) ? Math.abs((float) (amDiff1.getSI(index) / 10000.0d)) : 0.1f;
                            assertEquals("value in vector matches", au.getScale().toStandardUnit(testData[index])
                                    - au2.getScale().toStandardUnit(testData2[index]), amDiff1.getSI(index), tolerance);
                        }

                        // TIMES(VECTOR) and DIVIDE(VECTOR)
                        FloatSIVector amTim = am.times(am2);
                        FloatSIVector amDiv = am.divide(am2);
                        assertEquals("unit of m2 * m2 should be m4", "m4",
                                amTim.getDisplayUnit().getUnitBase().getSiDimensions().toString(false, false, false));
                        assertEquals("unit of m2 / m2 should be 1", "1",
                                amDiv.getDisplayUnit().getUnitBase().getSiDimensions().toString(false, false, false));
                        for (int index = 0; index < testData.length; index++)
                        {
                            float tolerance =
                                    Float.isFinite(amTim.getSI(index)) ? Math.abs((float) (amTim.getSI(index) / 10000.0d)) : 0.1f;
                            assertEquals("value in m2 * m2 matches", au.getScale().toStandardUnit(testData[index])
                                    * au2.getScale().toStandardUnit(testData2[index]), amTim.getSI(index), tolerance);
                            tolerance = Float.isFinite(amTim.getSI(index)) ? Math.abs((float) (amDiv.getSI(index) / 10000.0d)) : 0.1f;
                            assertEquals("value in m2 / m2 matches (could be NaN)",
                                    au.getScale().toStandardUnit(testData[index])
                                            / au2.getScale().toStandardUnit(testData2[index]),
                                    amDiv.getSI(index), tolerance);
                        }
                        // This does not compile: SIVector amTim2 = am.immutable().multiplyBy(am2).immutable();
                    }
                }
            }
        }
    }

    /**
     * Test if mutable methods give an error in case the vector is immutable.
     */
    @Test
    public void testImmutableVector()
    {
        float[] denseTestData = FLOATVECTOR.denseArray(105);
        float[] sparseTestData = FLOATVECTOR.sparseArray(105);

        for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
        {
            for (AreaUnit au : new AreaUnit[] { AreaUnit.SQUARE_METER, AreaUnit.ACRE })
            {
                float[] testData = storageType.equals(StorageType.DENSE) ? denseTestData : sparseTestData;
                FloatAreaVector am =
                        FloatVector.instantiate(FloatVectorData.instantiate(testData, au.getScale(), storageType), au);
                am = am.immutable();
                final FloatAreaVector amPtr = am;
                FloatArea fa = FloatArea.of(10.0f, "m^2");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.assign(FloatMathFunctions.ABS);
                    }
                }.test("ImmutableVector.assign(...) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.decrementBy(fa);
                    }
                }.test("ImmutableVector.decrementBy(scalar) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.decrementBy(amPtr);
                    }
                }.test("ImmutableVector.decrementBy(vector) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.incrementBy(fa);
                    }
                }.test("ImmutableVector.incrementBy(scalar) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.incrementBy(amPtr);
                    }
                }.test("ImmutableVector.incrementBy(vector) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.divideBy(2.0d);
                    }
                }.test("ImmutableVector.divideBy(factor) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.multiplyBy(2.0d);
                    }
                }.test("ImmutableVector.multiplyBy(factor) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.set(1, fa);
                    }
                }.test("ImmutableVector.set() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.setSI(1, 20.1f);
                    }
                }.test("ImmutableVector.setSI() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.setInUnit(1, 15.2f);
                    }
                }.test("ImmutableVector.setInUnit(f) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.setInUnit(1, 15.2f, AreaUnit.ARE);
                    }
                }.test("ImmutableVector.setInUnit(f, u) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.abs();
                    }
                }.test("ImmutableVector.abs() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.ceil();
                    }
                }.test("ImmutableVector.ceil() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.floor();
                    }
                }.test("ImmutableVector.floor() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.neg();
                    }
                }.test("ImmutableVector.neg() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.rint();
                    }
                }.test("ImmutableVector.rint() should throw error");
            }
        }
    }

    /**
     * Test toString() methods. TODO: expand?
     */
    @Test
    public void testVectorToString()
    {
        float[] denseTestData = FLOATVECTOR.denseArray(105);
        float[] sparseTestData = FLOATVECTOR.sparseArray(105);

        for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
        {
            for (AreaUnit au : new AreaUnit[] { AreaUnit.SQUARE_METER, AreaUnit.ACRE })
            {
                float[] testData = storageType.equals(StorageType.DENSE) ? denseTestData : sparseTestData;
                FloatAreaVector am =
                        FloatVector.instantiate(FloatVectorData.instantiate(testData, au.getScale(), storageType), au);
                String s1 = am.toString(); // non-verbose with unit
                assertTrue(s1.contains(au.getDefaultTextualAbbreviation()));
                String s2 = am.toString(AreaUnit.SQUARE_INCH); // non-verbose with unit
                assertTrue(s2.contains(AreaUnit.SQUARE_INCH.getDefaultTextualAbbreviation()));
                String s3 = am.toString(AreaUnit.SQUARE_INCH, true, true); // verbose with unit
                assertTrue(s3.contains(AreaUnit.SQUARE_INCH.getDefaultTextualAbbreviation()));
                if (storageType.equals(StorageType.DENSE))
                {
                    assertTrue(s3.contains("Dense"));
                    assertFalse(s3.contains("Sparse"));
                }
                else
                {
                    assertFalse(s3.contains("Dense"));
                    assertTrue(s3.contains("Sparse"));
                }
                assertTrue(s3.contains("Rel"));
                assertFalse(s3.contains("Abs"));
                assertTrue(s3.contains("Immutable"));
                assertFalse(s3.contains("Mutable"));
                FloatAreaVector ammut = am.mutable();
                String smut = ammut.toString(AreaUnit.SQUARE_INCH, true, true); // verbose with unit
                assertFalse(smut.contains("Immutable"));
                assertTrue(smut.contains("Mutable"));
                String sNotVerbose = ammut.toString(false, false);
                assertFalse(sNotVerbose.contains("Rel"));
                assertFalse(sNotVerbose.contains("Abs"));
                assertFalse(sNotVerbose.contains("Immutable"));
                assertFalse(sNotVerbose.contains("Mutable"));
                assertFalse(sNotVerbose.contains(au.getDefaultTextualAbbreviation()));
            }
        }
        FloatTimeVector tm = FloatVector.instantiate(
                FloatVectorData.instantiate(denseTestData, TimeUnit.DEFAULT.getScale(), StorageType.DENSE), TimeUnit.DEFAULT);
        String st = tm.toString(TimeUnit.DEFAULT, true, true); // verbose with unit
        assertFalse(st.contains("Rel"));
        assertTrue(st.contains("Abs"));
        FloatLengthVector lm = FloatVector.instantiate(
                FloatVectorData.instantiate(denseTestData, LengthUnit.SI.getScale(), StorageType.DENSE), LengthUnit.SI);
        String sl = lm.toString(LengthUnit.SI, true, true); // verbose with unit
        assertTrue(sl.contains("Rel"));
        assertFalse(sl.contains("Abs"));
    }

    /**
     * Test the extra methods that Absolute and Relative with Absolute matrices implement.
     */
    @Test
    public void testSpecialVectorMethodsRelWithAbs()
    {
        float[] denseTestData = FLOATVECTOR.denseArray(105);
        FloatTimeVector tm = FloatVector.instantiate(
                FloatVectorData.instantiate(denseTestData, TimeUnit.DEFAULT.getScale(), StorageType.DENSE), TimeUnit.DEFAULT);
        FloatDurationVector dm = FloatVector.instantiate(
                FloatVectorData.instantiate(denseTestData, DurationUnit.MINUTE.getScale(), StorageType.DENSE),
                DurationUnit.SECOND);
        assertTrue(tm.isAbsolute());
        assertFalse(dm.isAbsolute());
        assertFalse(tm.isRelative());
        assertTrue(dm.isRelative());

        FloatTimeVector absPlusRel = tm.plus(dm);
        FloatTimeVector absMinusRel = tm.minus(dm);
        FloatDurationVector absMinusAbs = tm.minus(tm.divide(2.0));
        FloatTimeVector absDecByRelS = tm.mutable().decrementBy(FloatDuration.of(1.0f, "min"));
        FloatTimeVector absDecByRelM = tm.mutable().decrementBy(dm.divide(2.0d));
        FloatTimeVector relPlusAbs = dm.plus(tm);
        for (int index = 0; index < denseTestData.length; index++)
        {
            assertEquals("absPlusRel", 61.0 * denseTestData[index], absPlusRel.getSI(index), 0.01);
            assertEquals("absMinusRel", -59.0 * denseTestData[index], absMinusRel.getSI(index), 0.01);
            assertEquals("absMinusAbs", denseTestData[index] / 2.0, absMinusAbs.getSI(index), 0.01);
            assertEquals("absDecByRelS", denseTestData[index] - 60.0, absDecByRelS.getSI(index), 0.01);
            assertEquals("absDecByRelM", -29.0 * denseTestData[index], absDecByRelM.getSI(index), 0.01);
            assertEquals("relPlusAbs", 61.0 * denseTestData[index], relPlusAbs.getSI(index), 0.01);
        }
    }

}