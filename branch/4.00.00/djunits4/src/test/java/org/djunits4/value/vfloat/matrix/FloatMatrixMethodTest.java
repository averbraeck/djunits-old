package org.djunits4.value.vfloat.matrix;

import static org.junit.Assert.assertEquals;

import org.djunits4.unit.AreaUnit;
import org.djunits4.value.base.Matrix;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.matrix.base.FloatMatrix;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatArea;
import org.junit.Test;

/**
 * ...
 */
public class FloatMatrixMethodTest
{

    /**
     * Test the standard methods of all matrix classes.
     */
    @Test
    public void testMatrixMethods()
    {
        float[][] denseTestData = FLOATMATRIX.denseRectArrays(5, 10);
        float[][] sparseTestData = FLOATMATRIX.sparseRectArrays(5, 10);

        for (StorageType storageType : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
        {
            for (AreaUnit au : new AreaUnit[] { AreaUnit.SQUARE_METER, AreaUnit.ACRE })
            {
                float[][] testData = storageType.equals(StorageType.DENSE) ? denseTestData : sparseTestData;
                FloatAreaMatrix am =
                        FloatMatrix.instantiate(FloatMatrixData.instantiate(testData, au.getScale(), storageType), au);
                // Check the zSum
                FloatArea zSum = am.zSum();
                float sum = 0;
                for (int row = 0; row < testData.length; row++)
                {
                    for (int col = 0; col < testData[0].length; col++)
                    {
                        sum += testData[row][col];
                    }
                }
                assertEquals("zSum", sum, zSum.getInUnit(), 0.1);
                for (StorageType storageType2 : new StorageType[] { StorageType.DENSE, StorageType.SPARSE })
                {
                    float[][] testData2 = storageType2.equals(StorageType.DENSE) ? denseTestData : sparseTestData;
                    for (AreaUnit au2 : new AreaUnit[] { AreaUnit.SQUARE_METER, AreaUnit.ACRE })
                    {
                        FloatAreaMatrix am2 = FloatMatrix
                                .instantiate(FloatMatrixData.instantiate(testData2, au2.getScale(), storageType2), au2);
                        FloatAreaMatrix amSum1 = am.plus(am2);
                        FloatAreaMatrix amSum2 = am2.plus(am);
                        FloatAreaMatrix amSum3 = am.mutable().incrementBy(am2).immutable();
                        assertEquals("a+b == b+a", amSum1, amSum2);
                        if (!amSum1.equals(amSum3))
                        {
                            amSum1.equals(amSum3);
                        }
                        assertEquals("a+b == b+a", amSum1, amSum3);
                        for (int row = 0; row < testData.length; row++)
                        {
                            for (int col = 0; col < testData[0].length; col++)
                            {
                                assertEquals("value in matrix matches",
                                        au.getScale().toStandardUnit(testData[row][col])
                                                + au2.getScale().toStandardUnit(testData2[row][col]),
                                        amSum1.getSI(row, col), 0.1);
                            }
                        }
                        FloatAreaMatrix amDiff1 = am.minus(am2);
                        FloatAreaMatrix amDiff2 = am2.minus(am).mutable().neg();
                        FloatAreaMatrix amDiff3 = am.mutable().decrementBy(am2).immutable();
                        assertEquals("a-b == -(b-a)", amDiff1, amDiff2);
                        assertEquals("a-b == -(b-a)", amDiff1, amDiff3);
                        for (int row = 0; row < testData.length; row++)
                        {
                            for (int col = 0; col < testData[0].length; col++)
                            {
                                assertEquals("value in matrix matches",
                                        au.getScale().toStandardUnit(testData[row][col])
                                                - au2.getScale().toStandardUnit(testData2[row][col]),
                                        amDiff1.getSI(row, col), 0.1);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * TODO Test the extra methods that Absolute and Relative with Absolute matrices implement.
     */
    @Test
    public void testSpecialMatrixMethodsRelWithAbs()
    {
    }

}
