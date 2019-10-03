package org.djunits4.value.vdouble.matrix;

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
import org.djunits4.value.vdouble.function.DoubleMathFunctions;
import org.djunits4.value.vdouble.matrix.base.DoubleMatrix;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Area;
import org.djunits4.value.vdouble.scalar.Duration;
import org.djunits4.value.vdouble.vector.AreaVector;
import org.junit.Test;

/**
 * ...
 */
public class DoubleMatrixMethodTest
{

    /**
     * Test the standard methods of all matrix classes.
     * @throws UnitException on error
     * @throws ValueRuntimeException on error
     */
    @Test
    public void testMatrixMethods() throws ValueRuntimeException, UnitException
    {
        double[][] denseTestData = DOUBLEMATRIX.denseRectArrays(5, 10);
        double[][] sparseTestData = DOUBLEMATRIX.sparseRectArrays(5, 10);

        for (StorageType storageType : new StorageType[] {StorageType.DENSE, StorageType.SPARSE})
        {
            for (AreaUnit au : new AreaUnit[] {AreaUnit.SQUARE_METER, AreaUnit.ACRE})
            {
                double[][] testData = storageType.equals(StorageType.DENSE) ? denseTestData : sparseTestData;
                AreaMatrix am =
                        DoubleMatrix.instantiate(DoubleMatrixData.instantiate(testData, au.getScale(), storageType), au);

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
                assertNotEquals(am, DoubleMatrix.instantiate(
                        DoubleMatrixData.instantiate(testData, LengthUnit.METER.getScale(), storageType), LengthUnit.METER));
                assertNotEquals(am, am.divide(2.0d));

                // MUTABLE
                assertFalse(am.isMutable());
                AreaMatrix ammut = am.mutable();
                assertTrue(ammut.isMutable());
                assertFalse(am.isMutable());
                AreaMatrix ammut2 = ammut.multiplyBy(1.0);
                assertEquals(am, ammut2);
                assertTrue(ammut.isMutable());
                assertFalse(am.isMutable());
                assertTrue(ammut2.isMutable());
                ammut2 = ammut2.mutable().divideBy(2.0);
                assertEquals(am, ammut);
                assertNotEquals(am, ammut2);

                // ZSUM and CARDINALITY
                Area zSum = am.zSum();
                double sum = 0;
                int card = 0;
                for (int row = 0; row < testData.length; row++)
                {
                    for (int col = 0; col < testData[0].length; col++)
                    {
                        sum += testData[row][col];
                        card += testData[row][col] == 0.0d ? 0 : 1;
                    }
                }
                assertEquals("zSum", sum, zSum.getInUnit(), 0.1);
                assertEquals("cardinality", card, am.cardinality());

                // INCREMENTBY(SCALAR) and DECREMENTBY(SCALAR)
                AreaMatrix amold = am.clone();
                Area fa = Area.of(10.0d, "m^2");
                AreaMatrix aminc = am.mutable().incrementBy(fa).immutable();
                AreaMatrix amdec = am.mutable().decrementBy(fa).immutable();
                AreaMatrix amid = aminc.mutable().decrementBy(fa);
                assertEquals("immutable matrix should not change when converted to mutable", am, amold);
                for (int row = 0; row < testData.length; row++)
                {
                    for (int col = 0; col < testData[0].length; col++)
                    {
                        assertEquals("increment and decrement with scalar should result in same matrix", am.getSI(row, col),
                                amid.getSI(row, col), 0.1);
                        assertEquals("m + s = (m+s)", au.getScale().toStandardUnit(testData[row][col]) + 10.0,
                                aminc.getSI(row, col), 0.1);
                        assertEquals("m - s = (m-s)", au.getScale().toStandardUnit(testData[row][col]) - 10.0,
                                amdec.getSI(row, col), 0.1);
                    }
                }

                // MULTIPLYBY() and DIVIDEBY(), TIMES(), DIVIDE()
                AreaMatrix amt5 = am.mutable().multiplyBy(5.0d).immutable();
                AreaMatrix amd5 = am.mutable().divideBy(5.0d).immutable();
                AreaMatrix amtd = amt5.mutable().divideBy(5.0d);
                AreaMatrix amtimD = am.times(5.0d);
                AreaMatrix amtimF = am.times(5.0f);
                AreaMatrix amdivD = am.divide(5.0d);
                AreaMatrix amdivF = am.divide(5.0f);
                for (int row = 0; row < testData.length; row++)
                {
                    for (int col = 0; col < testData[0].length; col++)
                    {
                        assertEquals("times followed by divide with constant should result in same matrix", am.getSI(row, col),
                                amtd.getSI(row, col), 0.1);
                        assertEquals("m * 5.0 = (m*5.0)", au.getScale().toStandardUnit(testData[row][col]) * 5.0d,
                                amt5.getSI(row, col), 0.1);
                        assertEquals("m / 5.0 = (m/5.0)", au.getScale().toStandardUnit(testData[row][col]) / 5.0d,
                                amd5.getSI(row, col), 0.1);
                        assertEquals("amtimD", amt5.getSI(row, col), amtimD.getSI(row, col), 0.1d);
                        assertEquals("amtimF", amt5.getSI(row, col), amtimF.getSI(row, col), 0.1d);
                        assertEquals("amdivD", amd5.getSI(row, col), amdivD.getSI(row, col), 0.01d);
                        assertEquals("amdivD", amd5.getSI(row, col), amdivF.getSI(row, col), 0.01d);
                    }
                }

                // GET(), GETINUNIT()
                assertEquals("get()", new Area(testData[2][2], au), am.get(2, 2));
                assertEquals("getSI()", au.getScale().toStandardUnit(testData[2][2]), am.getSI(2, 2), 0.1);
                assertEquals("getInUnit()", testData[2][2], am.getInUnit(2, 2), 0.1);
                assertEquals("getInUnit(unit)",
                        AreaUnit.SQUARE_YARD.getScale().fromStandardUnit(au.getScale().toStandardUnit(testData[2][2])),
                        am.getInUnit(2, 2, AreaUnit.SQUARE_YARD), 0.1);

                // SET(), SETINUNIT()
                Area fasqft = new Area(10.5d, AreaUnit.SQUARE_FOOT);
                AreaMatrix famChange = am.clone().mutable();
                famChange.set(2, 2, fasqft);
                assertEquals("set()", fasqft.si, famChange.get(2, 2).si, 0.1d);
                famChange = am.clone().mutable();
                famChange.setSI(2, 2, 123.4d);
                assertEquals("setSI()", 123.4d, famChange.get(2, 2).si, 0.1d);
                famChange = am.clone().mutable();
                famChange.setInUnit(2, 2, 1.2d);
                assertEquals("setInUnit()", 1.2d, famChange.getInUnit(2, 2), 0.1d);
                famChange = am.clone().mutable();
                famChange.setInUnit(2, 2, 1.5d, AreaUnit.HECTARE);
                assertEquals("setInUnit(unit)", 15000.0d, famChange.get(2, 2).si, 1.0d);

                // GETROW(), GETCOLUMN(), GETDIAGONAL
                double[][] squareData = storageType.equals(StorageType.DENSE) ? DOUBLEMATRIX.denseRectArrays(12, 12)
                        : DOUBLEMATRIX.sparseRectArrays(12, 12);
                AreaMatrix amSquare =
                        DoubleMatrix.instantiate(DoubleMatrixData.instantiate(squareData, au.getScale(), storageType), au);
                double[] row2si = am.getRowSI(2);
                double[] col2si = am.getColumnSI(2);
                double[] diagsi = amSquare.getDiagonalSI();
                AreaVector row2v = am.getRow(2);
                AreaVector col2v = am.getColumn(2);
                AreaVector diagv = amSquare.getDiagonal();
                Area[] row2scalar = am.getRowScalars(2);
                Area[] col2scalar = am.getColumnScalars(2);
                Area[] diagscalar = amSquare.getDiagonalScalars();
                for (int col = 0; col < testData[0].length; col++)
                {
                    assertEquals("row2si", au.getScale().toStandardUnit(testData[2][col]), row2si[col], 0.1d);
                    assertEquals("row2v", au.getScale().toStandardUnit(testData[2][col]), row2v.getSI(col), 0.1d);
                    assertEquals("row2scalar", au.getScale().toStandardUnit(testData[2][col]), row2scalar[col].si, 0.1d);
                }
                for (int row = 0; row < testData.length; row++)
                {
                    assertEquals("col2si", au.getScale().toStandardUnit(testData[row][2]), col2si[row], 0.1d);
                    assertEquals("col2v", au.getScale().toStandardUnit(testData[row][2]), col2v.getSI(row), 0.1d);
                    assertEquals("col2scalar", au.getScale().toStandardUnit(testData[row][2]), col2scalar[row].si, 0.1d);
                }
                for (int diag = 0; diag < amSquare.rows(); diag++)
                {
                    assertEquals("diag2si", au.getScale().toStandardUnit(squareData[diag][diag]), diagsi[diag], 0.1d);
                    assertEquals("diag2v", au.getScale().toStandardUnit(squareData[diag][diag]), diagv.getSI(diag), 0.1d);
                    assertEquals("diag2scalar", au.getScale().toStandardUnit(squareData[diag][diag]), diagscalar[diag].si,
                            0.1d);
                }

                // GETVALUES(), GETSCALARS()
                double[][] valsi = am.getValuesSI();
                double[][] valunit = am.getValuesInUnit();
                double[][] valsqft = am.getValuesInUnit(AreaUnit.SQUARE_YARD);
                Area[][] valscalars = am.getScalars();
                for (int row = 0; row < testData.length; row++)
                {
                    for (int col = 0; col < testData[0].length; col++)
                    {
                        assertEquals("getValuesSI()", au.getScale().toStandardUnit(testData[row][col]), valsi[row][col], 0.1);
                        assertEquals("getValuesInUnit()", testData[row][col], valunit[row][col], 0.1);
                        assertEquals("getValuesInUnit(unit)", AreaUnit.SQUARE_YARD.getScale()
                                .fromStandardUnit(au.getScale().toStandardUnit(testData[row][col])), valsqft[row][col], 0.1);
                        assertEquals("getValuesInUnit(unit)", au.getScale().toStandardUnit(testData[row][col]),
                                valscalars[row][col].si, 0.1);
                    }
                }

                // ASSIGN FUNCTION ABS, CEIL, FLOOR, NEG, RINT
                AreaMatrix amdiv2 = am.divide(2.0d);
                assertEquals(am.getStorageType(), amdiv2.getStorageType());
                assertEquals(am.getDisplayUnit(), amdiv2.getDisplayUnit());
                AreaMatrix amAbs = amdiv2.mutable().abs().immutable();
                assertEquals(am.getStorageType(), amAbs.getStorageType());
                assertEquals(am.getDisplayUnit(), amAbs.getDisplayUnit());
                AreaMatrix amCeil = amdiv2.mutable().ceil().immutable();
                assertEquals(am.getStorageType(), amCeil.getStorageType());
                assertEquals(am.getDisplayUnit(), amCeil.getDisplayUnit());
                AreaMatrix amFloor = amdiv2.mutable().floor().immutable();
                assertEquals(am.getStorageType(), amFloor.getStorageType());
                assertEquals(am.getDisplayUnit(), amFloor.getDisplayUnit());
                AreaMatrix amNeg = amdiv2.mutable().neg().immutable();
                assertEquals(am.getStorageType(), amNeg.getStorageType());
                assertEquals(am.getDisplayUnit(), amNeg.getDisplayUnit());
                AreaMatrix amRint = amdiv2.mutable().rint().immutable();
                assertEquals(am.getStorageType(), amRint.getStorageType());
                assertEquals(am.getDisplayUnit(), amRint.getDisplayUnit());
                for (int row = 0; row < testData.length; row++)
                {
                    for (int col = 0; col < testData[0].length; col++)
                    {
                        // TODO: Should be rounded IN THE UNIT rather than BY SI VALUES
                        assertEquals("div2", au.getScale().toStandardUnit(testData[row][col]) / 2.0d, amdiv2.getSI(row, col),
                                0.1d);
                        assertEquals("abs", Math.abs(au.getScale().toStandardUnit(testData[row][col]) / 2.0d),
                                amAbs.getSI(row, col), 0.1d);
                        assertEquals("ceil", Math.ceil(au.getScale().toStandardUnit(testData[row][col]) / 2.0d),
                                amCeil.getSI(row, col), 0.1d);
                        assertEquals("floor", Math.floor(au.getScale().toStandardUnit(testData[row][col]) / 2.0d),
                                amFloor.getSI(row, col), 0.1d);
                        assertEquals("neg", -au.getScale().toStandardUnit(testData[row][col]) / 2.0d, amNeg.getSI(row, col),
                                0.1d);
                        assertEquals("rint", Math.rint(au.getScale().toStandardUnit(testData[row][col]) / 2.0d),
                                amRint.getSI(row, col), 0.1d);
                    }
                }

                // TODO: CALCULATE DETERMINANT INDEPENDENTLY AND CHECK
                // XXX: this is clearly wrong. See console output!
                double det = amSquare.determinant();
                System.out.println("Determinant of square matrix with unit " + au.getDefaultTextualAbbreviation()
                        + ", storage = " + storageType + " = " + det);
                new Try()
                {
                    public @Override void execute()
                    {
                        double detErr = am.determinant();
                        System.out.println(detErr);
                    }
                }.test("Determinant of non-square matrix should have thrown exception");

                // TEST METHODS THAT INVOLVE TWO MATRIX INSTANCES

                for (StorageType storageType2 : new StorageType[] {StorageType.DENSE, StorageType.SPARSE})
                {
                    double[][] testData2 = storageType2.equals(StorageType.DENSE) ? denseTestData : sparseTestData;
                    for (AreaUnit au2 : new AreaUnit[] {AreaUnit.SQUARE_METER, AreaUnit.ACRE})
                    {

                        // PLUS and INCREMENTBY(MATRIX)
                        AreaMatrix am2 = DoubleMatrix
                                .instantiate(DoubleMatrixData.instantiate(testData2, au2.getScale(), storageType2), au2);
                        AreaMatrix amSum1 = am.plus(am2);
                        AreaMatrix amSum2 = am2.plus(am);
                        AreaMatrix amSum3 = am.mutable().incrementBy(am2).immutable();
                        assertEquals("a+b == b+a", amSum1, amSum2);
                        assertEquals("a+b == b+a", amSum1, amSum3);
                        for (int row = 0; row < testData.length; row++)
                        {
                            for (int col = 0; col < testData[0].length; col++)
                            {
                                double tolerance = Double.isFinite(amSum1.getSI(row, col))
                                        ? Math.abs(amSum1.getSI(row, col) / 10000.0d) : 0.1d;
                                assertEquals("value in matrix matches",
                                        au.getScale().toStandardUnit(testData[row][col])
                                                + au2.getScale().toStandardUnit(testData2[row][col]),
                                        amSum1.getSI(row, col), tolerance);
                            }
                        }

                        // MINUS and DECREMENTBY(MATRIX)
                        AreaMatrix amDiff1 = am.minus(am2);
                        AreaMatrix amDiff2 = am2.minus(am).mutable().neg();
                        AreaMatrix amDiff3 = am.mutable().decrementBy(am2).immutable();
                        assertEquals("a-b == -(b-a)", amDiff1, amDiff2);
                        assertEquals("a-b == -(b-a)", amDiff1, amDiff3);
                        for (int row = 0; row < testData.length; row++)
                        {
                            for (int col = 0; col < testData[0].length; col++)
                            {
                                double tolerance = Double.isFinite(amDiff1.getSI(row, col))
                                        ? Math.abs(amDiff1.getSI(row, col) / 10000.0d) : 0.1d;
                                assertEquals("value in matrix matches",
                                        au.getScale().toStandardUnit(testData[row][col])
                                                - au2.getScale().toStandardUnit(testData2[row][col]),
                                        amDiff1.getSI(row, col), tolerance);
                            }
                        }

                        // TIMES(MATRIX) and DIVIDE(MATRIX)
                        SIMatrix amTim = am.times(am2);
                        SIMatrix amDiv = am.divide(am2);
                        assertEquals("unit of m2 * m2 should be m4", "m4",
                                amTim.getDisplayUnit().getUnitBase().getSiDimensions().toString(false, false, false));
                        assertEquals("unit of m2 / m2 should be 1", "1",
                                amDiv.getDisplayUnit().getUnitBase().getSiDimensions().toString(false, false, false));
                        for (int row = 0; row < testData.length; row++)
                        {
                            for (int col = 0; col < testData[0].length; col++)
                            {
                                double tolerance = Double.isFinite(amTim.getSI(row, col))
                                        ? Math.abs(amTim.getSI(row, col) / 10000.0d) : 0.1d;
                                assertEquals("value in m2 * m2 matches",
                                        au.getScale().toStandardUnit(testData[row][col])
                                                * au2.getScale().toStandardUnit(testData2[row][col]),
                                        amTim.getSI(row, col), tolerance);
                                tolerance = Double.isFinite(amTim.getSI(row, col)) ? Math.abs(amDiv.getSI(row, col) / 10000.0d)
                                        : 0.1d;
                                assertEquals("value in m2 / m2 matches (could be NaN)",
                                        au.getScale().toStandardUnit(testData[row][col])
                                                / au2.getScale().toStandardUnit(testData2[row][col]),
                                        amDiv.getSI(row, col), tolerance);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Test if mutable methods give an error in case the matrix is immutable.
     */
    @Test
    public void testImmutableMatrix()
    {
        double[][] denseTestData = DOUBLEMATRIX.denseRectArrays(5, 10);
        double[][] sparseTestData = DOUBLEMATRIX.sparseRectArrays(5, 10);

        for (StorageType storageType : new StorageType[] {StorageType.DENSE, StorageType.SPARSE})
        {
            for (AreaUnit au : new AreaUnit[] {AreaUnit.SQUARE_METER, AreaUnit.ACRE})
            {
                double[][] testData = storageType.equals(StorageType.DENSE) ? denseTestData : sparseTestData;
                AreaMatrix am =
                        DoubleMatrix.instantiate(DoubleMatrixData.instantiate(testData, au.getScale(), storageType), au);
                am = am.immutable();
                final AreaMatrix amPtr = am;
                Area fa = Area.of(10.0d, "m^2");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.assign(DoubleMathFunctions.ABS);
                    }
                }.test("ImmutableMatrix.assign(...) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.decrementBy(fa);
                    }
                }.test("ImmutableMatrix.decrementBy(scalar) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.decrementBy(amPtr);
                    }
                }.test("ImmutableMatrix.decrementBy(matrix) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.incrementBy(fa);
                    }
                }.test("ImmutableMatrix.incrementBy(scalar) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.incrementBy(amPtr);
                    }
                }.test("ImmutableMatrix.incrementBy(matrix) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.divideBy(2.0d);
                    }
                }.test("ImmutableMatrix.divideBy(factor) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.multiplyBy(2.0d);
                    }
                }.test("ImmutableMatrix.multiplyBy(factor) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.set(1, 1, fa);
                    }
                }.test("ImmutableMatrix.set() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.setSI(1, 1, 20.1d);
                    }
                }.test("ImmutableMatrix.setSI() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.setInUnit(1, 1, 15.2d);
                    }
                }.test("ImmutableMatrix.setInUnit(f) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.setInUnit(1, 1, 15.2d, AreaUnit.ARE);
                    }
                }.test("ImmutableMatrix.setInUnit(f, u) should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.abs();
                    }
                }.test("ImmutableMatrix.abs() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.ceil();
                    }
                }.test("ImmutableMatrix.ceil() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.floor();
                    }
                }.test("ImmutableMatrix.floor() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.neg();
                    }
                }.test("ImmutableMatrix.neg() should throw error");
                new Try()
                {
                    public @Override void execute()
                    {
                        amPtr.rint();
                    }
                }.test("ImmutableMatrix.rint() should throw error");
            }
        }
    }

    /**
     * Test toString() methods. TODO: expand?
     */
    @Test
    public void testMatrixToString()
    {
        double[][] denseTestData = DOUBLEMATRIX.denseRectArrays(5, 10);
        double[][] sparseTestData = DOUBLEMATRIX.sparseRectArrays(5, 10);

        for (StorageType storageType : new StorageType[] {StorageType.DENSE, StorageType.SPARSE})
        {
            for (AreaUnit au : new AreaUnit[] {AreaUnit.SQUARE_METER, AreaUnit.ACRE})
            {
                double[][] testData = storageType.equals(StorageType.DENSE) ? denseTestData : sparseTestData;
                AreaMatrix am =
                        DoubleMatrix.instantiate(DoubleMatrixData.instantiate(testData, au.getScale(), storageType), au);
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
                AreaMatrix ammut = am.mutable();
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
        TimeMatrix tm = DoubleMatrix.instantiate(
                DoubleMatrixData.instantiate(denseTestData, TimeUnit.DEFAULT.getScale(), StorageType.DENSE), TimeUnit.DEFAULT);
        String st = tm.toString(TimeUnit.DEFAULT, true, true); // verbose with unit
        assertFalse(st.contains("Rel"));
        assertTrue(st.contains("Abs"));
        LengthMatrix lm = DoubleMatrix.instantiate(
                DoubleMatrixData.instantiate(denseTestData, LengthUnit.SI.getScale(), StorageType.DENSE), LengthUnit.SI);
        String sl = lm.toString(LengthUnit.SI, true, true); // verbose with unit
        assertTrue(sl.contains("Rel"));
        assertFalse(sl.contains("Abs"));
    }

    /**
     * Test the extra methods that Absolute and Relative with Absolute matrices implement.
     */
    @Test
    public void testSpecialMatrixMethodsRelWithAbs()
    {
        double[][] denseTestData = DOUBLEMATRIX.denseRectArrays(5, 10);
        TimeMatrix tm = DoubleMatrix.instantiate(
                DoubleMatrixData.instantiate(denseTestData, TimeUnit.DEFAULT.getScale(), StorageType.DENSE), TimeUnit.DEFAULT);
        DurationMatrix dm = DoubleMatrix.instantiate(
                DoubleMatrixData.instantiate(denseTestData, DurationUnit.MINUTE.getScale(), StorageType.DENSE),
                DurationUnit.SECOND);
        assertTrue(tm.isAbsolute());
        assertFalse(dm.isAbsolute());
        assertFalse(tm.isRelative());
        assertTrue(dm.isRelative());

        TimeMatrix absPlusRel = tm.plus(dm);
        TimeMatrix absMinusRel = tm.minus(dm);
        DurationMatrix absMinusAbs = tm.minus(tm.divide(2.0));
        TimeMatrix absDecByRelS = tm.mutable().decrementBy(Duration.of(1.0d, "min"));
        TimeMatrix absDecByRelM = tm.mutable().decrementBy(dm.divide(2.0d));
        TimeMatrix relPlusAbs = dm.plus(tm);
        for (int row = 0; row < denseTestData.length; row++)
        {
            for (int col = 0; col < denseTestData[0].length; col++)
            {
                assertEquals("absPlusRel", 61.0 * denseTestData[row][col], absPlusRel.getSI(row, col), 0.01);
                assertEquals("absMinusRel", -59.0 * denseTestData[row][col], absMinusRel.getSI(row, col), 0.01);
                assertEquals("absMinusAbs", denseTestData[row][col] / 2.0, absMinusAbs.getSI(row, col), 0.01);
                assertEquals("absDecByRelS", denseTestData[row][col] - 60.0, absDecByRelS.getSI(row, col), 0.01);
                assertEquals("absDecByRelM", -29.0 * denseTestData[row][col], absDecByRelM.getSI(row, col), 0.01);
                assertEquals("relPlusAbs", 61.0 * denseTestData[row][col], relPlusAbs.getSI(row, col), 0.01);
            }
        }
    }

}