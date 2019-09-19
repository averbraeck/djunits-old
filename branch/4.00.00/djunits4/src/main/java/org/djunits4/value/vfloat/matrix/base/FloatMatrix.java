package org.djunits4.value.vfloat.matrix.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.matrix.FloatSIMatrix;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalar;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVector;

/**
 * FloatMatrix utility methods, e.g., for creating FloatMatrixs from different types of data.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public final class FloatMatrix
{
    /** The cache to make the lookup of the constructor for a Immutable Matrix belonging to a unit faster. */
    private static Map<Unit<?>, Constructor<? extends AbstractFloatMatrix<?, ?, ?, ?>>> CACHE_DATA = new HashMap<>();

    /** Do not instantiate. */
    private FloatMatrix()
    {
        // Utility class.
    }

    /**
     * Instantiate the FloatMatrix based on its unit. Rigid check on types for the compiler.
     * @param values float[][]; the values
     * @param unit U; the unit in which the values are expressed
     * @param storageType StorageType; whether the matrix is SPARSE or DENSE
     * @return V; an instantiated FloatMatrix with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>,
            M extends AbstractFloatMatrix<U, S, V, M>> M instantiate(final float[][] values, final U unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(values, unit, storageType);
    }

    /**
     * Instantiate the Mutable FloatMatrix based on its unit. Rigid check on types for the compiler.
     * @param values FloatMatrixData; the values
     * @param unit U; the unit in which the values are expressed
     * @return V; an instantiated mutable FloatMatrix with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>,
            M extends AbstractFloatMatrix<U, S, V, M>> M instantiate(final FloatMatrixData values, final U unit)
    {
        return instantiateAnonymous(values, unit);
    }

    /**
     * Instantiate the FloatMatrix based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param values float[][]; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @param storageType StorageType; whether the matrix is SPARSE or DENSE
     * @return V; an instantiated FloatMatrix with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>,
            M extends AbstractFloatMatrix<U, S, V, M>> M instantiateAnonymous(final float[][] values, final Unit<?> unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(FloatMatrixData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Instantiate the Immutable FloatMatrix based on its unit. Loose check for types on the compiler. This allows the unit to
     * be specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param values FloatMatrixData; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @return V; an instantiated FloatMatrix with the values expressed in their unit
     */
    @SuppressWarnings("unchecked")
    protected static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>,
            M extends AbstractFloatMatrix<U, S, V, M>> M instantiateAnonymous(final FloatMatrixData values, final Unit<?> unit)
    {
        try
        {
            Constructor<? extends AbstractFloatMatrix<?, ?, ?, ?>> matrixConstructor = CACHE_DATA.get(unit);
            if (matrixConstructor == null)
            {
                if (!unit.getClass().getSimpleName().endsWith("Unit"))
                {
                    throw new ClassNotFoundException("Unit " + unit.getClass().getSimpleName()
                            + " name does not end with 'Unit'. Cannot find corresponding matrix");
                }
                Class<? extends AbstractFloatMatrix<?, ?, ?, ?>> matrixClass;
                if (unit instanceof SIUnit)
                {
                    matrixClass = FloatSIMatrix.class;
                }
                else
                {
                    matrixClass =
                            (Class<AbstractFloatMatrix<?, ?, ?, ?>>) Class.forName("org.djunits4.value.vfloat.matrix.Float"
                                    + unit.getClass().getSimpleName().replace("Unit", "") + "Matrix");
                }
                matrixConstructor = matrixClass.getDeclaredConstructor(FloatMatrixData.class, unit.getClass());
                CACHE_DATA.put(unit, matrixConstructor);
            }
            return (M) matrixConstructor.newInstance(values, unit);
        }
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
        {
            throw new UnitRuntimeException("Cannot instantiate AbstractFloatMatrix of unit " + unit.toString() + ". Reason: "
                    + exception.getMessage());
        }
    }

    /**
     * Construct a new Relative Immutable Float Matrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable Float Matrix
     * @param unit Unit; the unit of the new Relative Immutable Float Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Matrix of the specified unit
     * @throws ValueRuntimeException when values is null
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>,
            M extends AbstractFloatMatrix<U, S, V, M>> M create(final float[][] values, final U unit,
                    final StorageType storageType) throws ValueRuntimeException
    {
        return instantiate(FloatMatrixData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Immutable Float Matrix.
     * @param values [][]; the values of the entries in the new Relative Immutable Float Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Matrix of the specified unit
     * @throws ValueRuntimeException when values has zero entries
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>,
            M extends AbstractFloatMatrix<U, S, V, M>> M create(final S[][] values, final StorageType storageType)
                    throws ValueRuntimeException
    {
        U unit = values[0][0].getUnit();
        return instantiate(FloatMatrixData.instantiate(values, storageType), unit);
    }
}
