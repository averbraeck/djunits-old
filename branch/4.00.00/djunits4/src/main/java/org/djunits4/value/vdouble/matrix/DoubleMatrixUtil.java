package org.djunits4.value.vdouble.matrix;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;

/**
 * Class to instantiate any DoubleMatrix based on the provided unit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 11, 2018 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class DoubleMatrixUtil
{
    /** The cache to make the lookup of the constructor for a Scalar belonging to a unit faster. */
    private static Map<Unit<?>, Constructor<? extends AbstractDoubleMatrix<?, ?>>> CACHE = new HashMap<>();

    /** Do not instantiate. */
    private DoubleMatrixUtil()
    {
        // Utility class.
    }

    /**
     * Instantiate the DoubleMatrix based on its unit. Rigid check on types for the compiler.
     * @param value double[][]; the value
     * @param unit U; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return S; an instantiated DoubleMatrix with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     * @throws ValueException on vector init error
     */
    public static <U extends Unit<U>, S extends AbstractDoubleMatrix<U, S>> S instantiate(final double[][] value, final U unit,
            final StorageType storageType) throws ValueException
    {
        return instantiateAnonymous(value, unit, storageType);
    }

    /**
     * Instantiate the DoubleMatrix based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param value double[][]; the value
     * @param unit Unit&lt;?&gt;; the unit in which the value is expressed
     * @param storageType StorageType; whether the matrix is SPARSE or DENSE
     * @return S; an instantiated DoubleMatrix with the value expressed in the unit
     * @param <S> the return type
     * @throws ValueException on vector init error
     */
    @SuppressWarnings("unchecked")
    public static <S extends AbstractDoubleMatrix<?, S>> S instantiateAnonymous(final double[][] value, final Unit<?> unit,
            final StorageType storageType) throws ValueException
    {
        try
        {
            Constructor<? extends AbstractDoubleMatrix<?, ?>> matrixConstructor = CACHE.get(unit);
            if (matrixConstructor == null)
            {
                if (!unit.getClass().getSimpleName().endsWith("Unit"))
                {
                    throw new ClassNotFoundException("Unit " + unit.getClass().getSimpleName()
                            + " name does noet end with 'Unit'. Cannot find corresponding matrix");
                }
                Class<? extends AbstractDoubleMatrix<?, ?>> matrixClass;
                if (unit instanceof SIUnit)
                {
                    // TODO: matrixClass = SIMatrix.class;
                    throw new UnitRuntimeException("Cannot instantiate AbstractDoubleMatrix of unit " + unit.toString());
                }
                else
                {
                    matrixClass = (Class<AbstractDoubleMatrix<?, ?>>) Class.forName("org.djunits4.value.vdouble.matrix."
                            + unit.getClass().getSimpleName().replace("Unit", "") + "Matrix");
                }
                matrixConstructor = matrixClass.getDeclaredConstructor(double[][].class, unit.getClass(), StorageType.class);
                CACHE.put(unit, matrixConstructor);
            }
            return (S) matrixConstructor.newInstance(value, unit, storageType);
        }
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
        {
            throw new UnitRuntimeException("Cannot instantiate AbstractDoubleMatrix of unit " + unit.toString() + ". Reason: "
                    + exception.getMessage());
        }
    }

    /**
     * Instantiate the DoubleMatrix based on its unit.
     * @param si double[][]; the value in SI units
     * @param displayUnit U; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return S; an instantiated DoubleMatrix with the value expressed in the unit
     * @throws ValueException on vector init error
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractDoubleMatrix<U, S>> S instantiateSI(final double[][] si,
            final U displayUnit, final StorageType storageType) throws ValueException
    {
        return instantiateAnonymousSI(si, displayUnit, storageType);
    }

    /**
     * Instantiate the DoubleMatrix based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units. The following <u>does</u> compile:
     * 
     * <pre>
     * MoneyPerLengthUnit mlu = new MoneyPerLengthUnit(MoneyUnit.USD, LengthUnit.METER, "$/m", "$/m");
     * 
     * MoneyPerArea mpa = DoubleMatrixUtil.instantiateAnonymousSI(10.0, mlu);
     * </pre>
     * 
     * @param si double[][]; the value in SI units
     * @param displayUnit Unit&lt;?&gt;; the unit in which the value is expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return S; an instantiated DoubleMatrix with the value expressed in the unit
     * @throws ValueException on vector init error
     * @param <S> the return type
     */
    @SuppressWarnings({"unchecked", "checkstyle:needbraces", "rawtypes"})
    public static <S extends AbstractDoubleMatrix<?, S>> S instantiateAnonymousSI(final double[][] si,
            final Unit<?> displayUnit, final StorageType storageType) throws ValueException
    {
        S value = (S) instantiateAnonymous(si, displayUnit.getStandardUnit(), storageType);
        ((AbstractDoubleMatrix) value).setDisplayUnit((Unit) displayUnit);
        return value;
    }

}
