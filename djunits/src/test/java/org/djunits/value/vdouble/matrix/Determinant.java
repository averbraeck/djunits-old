package org.djunits.value.vdouble.matrix;

import java.util.Arrays;

/**
 * Compute the determinant of a matrix.
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class Determinant
{

    /**
     * Compute the determinant of a matrix. Code based on
     * <a href="https://www.mathsisfun.com/algebra/matrix-determinant.html">Determinant of a Matrix</a>.
     * @param matrix double[][]; the matrix (better be square, minimum size is 1x1)
     * @return double; the determinant of the matrix
     */
    public static double det(final double[][] matrix)
    {
        if (matrix.length == 1)
        {
            return matrix[0][0];
        }
        double result = 0;
        int sign = 1;
        for (int col = 0; col < matrix[0].length; col++)
        {
            result += sign * matrix[0][col] * det(subMatrix(matrix, col));
            sign = 0 - sign;
        }
        return result;
    }

    /**
     * Extract a sub matrix from a matrix leaving out row 0 and column <code>pivot</code>.
     * @param matrix double[][]; the matrix (better be square)
     * @param pivot int; the column to skip
     * @return double[][]; a matrix that is one step smaller than the input <code>matrix</code>
     */
    public static double[][] subMatrix(final double[][] matrix, final int pivot)
    {
        double[][] result = new double[matrix.length - 1][matrix.length - 1];
        for (int row = 0; row < result.length; row++)
        {
            for (int col = 0; col < result.length; col++)
            {
                result[row][col] = matrix[row + 1][col >= pivot ? col + 1 : col];
            }
        }
        return result;
    }

    /**
     * Program entry point.
     * @param args String[]; the command line arguments (not used)
     */
    public static void main(final String[] args)
    {
        double[][] testData1 = new double[][] {{2.0}};
        double[][] testData2 = new double[][] {{2, 3}, {5, 7}};
        double[][] testData3 = new double[][] {{2, 3, 5}, {7, 11, 13}, {17, 19, 23}};
        double[][] testData4 = new double[][] {{2, 3, 5, 7}, {11, 13, 17, 19}, {23, 29, 31, 37}, {41, 43, 47, 49}};
        System.out.println(Arrays.deepToString(testData1));
        System.out.println("det=" + det(testData1));
        System.out.println(Arrays.deepToString(testData2));
        System.out.println("subMatrix(0): " + Arrays.deepToString(subMatrix(testData2, 0)));
        System.out.println(Arrays.deepToString(testData2));
        System.out.println("subMatrix(1): " + Arrays.deepToString(subMatrix(testData2, 1)));
        System.out.println("det=" + det(testData2));
        System.out.println(Arrays.deepToString(testData3));
        System.out.println("det=" + det(testData3));
        System.out.println(Arrays.deepToString(testData4));
        System.out.println("det=" + det(testData4));
    }

}
