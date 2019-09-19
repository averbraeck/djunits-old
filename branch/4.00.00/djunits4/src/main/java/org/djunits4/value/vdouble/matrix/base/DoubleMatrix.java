package org.djunits4.value.vdouble.matrix.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.matrix.SIMatrix;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVector;

/**
 * DoubleMatrix utility methods, e.g., for creating DoubleMatrixs from different types of data.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public final class DoubleMatrix
{
    /** The cache to make the lookup of the constructor for a Immutable Matrix belonging to a unit faster. */
    private static Map<Unit<?>, Constructor<? extends AbstractDoubleMatrix<?, ?, ?, ?>>> CACHE_DATA = new HashMap<>();

    /** Do not instantiate. */
    private DoubleMatrix()
    {
        // Utility class.
    }

    /**
     * Instantiate the DoubleMatrix based on its unit. Rigid check on types for the compiler.
     * @param values double[][]; the values
     * @param unit U; the unit in which the values are expressed
     * @param storageType StorageType; whether the matrix is SPARSE or DENSE
     * @return V; an instantiated DoubleMatrix with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>,
            M extends AbstractDoubleMatrix<U, S, V, M>> M instantiate(final double[][] values, final U unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(values, unit, storageType);
    }

    /**
     * Instantiate the Mutable DoubleMatrix based on its unit. Rigid check on types for the compiler.
     * @param values DoubleMatrixData; the values
     * @param unit U; the unit in which the values are expressed
     * @return V; an instantiated mutable DoubleMatrix with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>,
            M extends AbstractDoubleMatrix<U, S, V, M>> M instantiate(final DoubleMatrixData values, final U unit)
    {
        return instantiateAnonymous(values, unit);
    }

    /**
     * Instantiate the DoubleMatrix based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param values double[][]; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @param storageType StorageType; whether the matrix is SPARSE or DENSE
     * @return V; an instantiated DoubleMatrix with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>,
            M extends AbstractDoubleMatrix<U, S, V, M>> M instantiateAnonymous(final double[][] values, final Unit<?> unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(DoubleMatrixData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Instantiate the Immutable DoubleMatrix based on its unit. Loose check for types on the compiler. This allows the unit to
     * be specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param values DoubleMatrixData; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @return V; an instantiated DoubleMatrix with the values expressed in their unit
     */
    @SuppressWarnings("unchecked")
    protected static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>,
            M extends AbstractDoubleMatrix<U, S, V, M>> M instantiateAnonymous(final DoubleMatrixData values,
                    final Unit<?> unit)
    {
        try
        {
            Constructor<? extends AbstractDoubleMatrix<?, ?, ?, ?>> matrixConstructor = CACHE_DATA.get(unit);
            if (matrixConstructor == null)
            {
                if (!unit.getClass().getSimpleName().endsWith("Unit"))
                {
                    throw new ClassNotFoundException("Unit " + unit.getClass().getSimpleName()
                            + " name does not end with 'Unit'. Cannot find corresponding matrix");
                }
                Class<? extends AbstractDoubleMatrix<?, ?, ?, ?>> matrixClass;
                if (unit instanceof SIUnit)
                {
                    matrixClass = SIMatrix.class;
                }
                else
                {
                    matrixClass = (Class<AbstractDoubleMatrix<?, ?, ?, ?>>) Class.forName("org.djunits4.value.vdouble.matrix."
                            + unit.getClass().getSimpleName().replace("Unit", "") + "Matrix");
                }
                matrixConstructor = matrixClass.getDeclaredConstructor(DoubleMatrixData.class, unit.getClass());
                CACHE_DATA.put(unit, matrixConstructor);
            }
            return (M) matrixConstructor.newInstance(values, unit);
        }
        catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | ClassNotFoundException | NoSuchMethodException exception)
        {
            throw new UnitRuntimeException("Cannot instantiate AbstractDoubleMatrix of unit " + unit.toString() + ". Reason: "
                    + exception.getMessage());
        }
    }

    /**
     * Construct a new Relative Immutable Double Matrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double Matrix
     * @param unit Unit; the unit of the new Relative Immutable Double Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Matrix of the specified unit
     * @throws ValueRuntimeException when values is null
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>,
            M extends AbstractDoubleMatrix<U, S, V, M>> M create(final double[][] values, final U unit,
                    final StorageType storageType) throws ValueRuntimeException
    {
        return instantiate(DoubleMatrixData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Immutable Double Matrix.
     * @param values S[][]; the values of the entries in the new Relative Immutable Double Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Matrix of the specified unit
     * @throws ValueRuntimeException when values has zero entries
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>,
            M extends AbstractDoubleMatrix<U, S, V, M>> M create(final S[][] values, final StorageType storageType)
                    throws ValueRuntimeException
    {
        U unit = values[0][0].getUnit();
        return instantiate(DoubleMatrixData.instantiate(values, storageType), unit);
    }
}
