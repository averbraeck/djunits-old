package org.djunits4.value.vfloat.matrix;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.djunits4.unit.Unit;
import org.djunits4.value.vfloat.matrix.base.FloatSparseValue;
import org.djunits4.value.vfloat.scalar.base.FloatScalarInterface;

/**
 * FLOATMATRIX.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class FLOATMATRIX
{
    /**
     * Return a square array with all values != 0.
     * @param rc the number of rows and columns
     * @return an array with all nonzero values
     */
    public static float[][] denseSquareArrays(final int rc)
    {
        float[][] array = new float[rc][];
        for (int i = 0; i < rc; i++)
        {
            float[] r = new float[rc];
            array[i] = r;
            for (int j = 0; j < rc; j++)
            {
                r[j] = 10.0f * i + j + 1.0f;
            }
        }
        return array;
    }

    /**
     * Return a square array with only nonzero values on the diagonal.
     * @param rc the number of rows and columns
     * @return an array with only nonzero values on the diagonal
     */
    public static float[][] sparseSquareArrays(final int rc)
    {
        float[][] array = new float[rc][];
        for (int i = 0; i < rc; i++)
        {
            float[] r = new float[rc];
            array[i] = r;
            for (int j = 0; j < rc; j++)
            {
                r[j] = (i == j) ? i + 1.0f : 0.0f;
            }
        }
        return array;
    }

    /**
     * Return a square array with all values != 0.
     * @param rc the number of rows and columns
     * @param scalarClass the class of scalars to use
     * @return an array with all nonzero values
     */
    @SuppressWarnings("unchecked")
    public static <U extends Unit<U>, S extends FloatScalarInterface<U, S>> S[][] denseSquareScalarArrays(final int rc,
            final Class<S> scalarClass)
    {
        try
        {
            S[][] array = (S[][]) Array.newInstance(scalarClass, rc, rc);
            Method createSI = scalarClass.getMethod("createSI", new Class<?>[] {float.class});
            for (int i = 0; i < rc; i++)
            {
                for (int j = 0; j < rc; j++)
                {
                    array[i][j] = (S) createSI.invoke(null, 10.0f * i + j + 1.0f);
                }
            }
            return array;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return a square array with only nonzero values on the diagonal.
     * @param rc the number of rows and columns
     * @param scalarClass the class of scalars to use
     * @return an array with only nonzero values on the diagonal
     */
    @SuppressWarnings("unchecked")
    public static <U extends Unit<U>, S extends FloatScalarInterface<U, S>> S[][] sparseSquareScalarArrays(final int rc,
            final Class<S> scalarClass)
    {
        try
        {
            S[][] array = (S[][]) Array.newInstance(scalarClass, rc, rc);
            Method createSI = scalarClass.getMethod("createSI", new Class<?>[] {float.class});
            for (int i = 0; i < rc; i++)
            {
                for (int j = 0; j < rc; j++)
                {
                    array[i][j] = (i == j) ? (S) createSI.invoke(null, i + 1.0f) : (S) createSI.invoke(null, 0.0f);
                }
            }
            return array;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return a square array with all values != 0.
     * @param rc the number of rows and columns
     * @param scalarClass the class of scalars to use
     * @return an array with all nonzero values
     */
    @SuppressWarnings("unchecked")
    public static <U extends Unit<U>,
            S extends FloatScalarInterface<U, S>> Collection<FloatSparseValue<U, S>> denseSquareTuples(final int rc,
                    final Class<S> scalarClass)
    {
        try
        {
            List<FloatSparseValue<U, S>> matrixList = new ArrayList<>();
            Method createSI = scalarClass.getMethod("createSI", new Class<?>[] {float.class});
            for (int i = 0; i < rc; i++)
            {
                for (int j = 0; j < rc; j++)
                {
                    S v = (S) createSI.invoke(null, 10.0f * i + j + 1.0f);
                    FloatSparseValue<U, S> dsv = new FloatSparseValue<U, S>(i, j, v);
                    matrixList.add(dsv);
                }
            }
            return matrixList;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return a square array with only nonzero values on the diagonal.
     * @param rc the number of rows and columns
     * @param scalarClass the class of scalars to use
     * @return an array with only nonzero values on the diagonal
     */
    public static <U extends Unit<U>,
            S extends FloatScalarInterface<U, S>> Collection<FloatSparseValue<U, S>> sparseSquareTuples(final int rc,
                    final Class<S> scalarClass)
    {
        try
        {
            List<FloatSparseValue<U, S>> matrixList = new ArrayList<>();
            for (int i = 0; i < rc; i++)
            {
                for (int j = 0; j < rc; j++)
                {
                    if (i == j)
                    {
                        float v = i + 1;
                        FloatSparseValue<U, S> dsv = new FloatSparseValue<U, S>(i, j, v);
                        matrixList.add(dsv);
                    }
                }
            }
            return matrixList;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
