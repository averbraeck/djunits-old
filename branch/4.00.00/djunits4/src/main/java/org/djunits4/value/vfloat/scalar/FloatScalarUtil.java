package org.djunits4.value.vfloat.scalar;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.util.UnitRuntimeException;

/**
 * Class to instantiate any FloatScalar based on the provided unit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class FloatScalarUtil
{
    /** The cache to make the lookup of the constructor for a Scalar belonging to a unit faster. */
    private static Map<Unit<?>, Constructor<? extends AbstractFloatScalar<?, ?>>> CACHE = new HashMap<>();

    /** Do not instantiate. */
    private FloatScalarUtil()
    {
        // Utility class.
    }

    /**
     * Instantiate the FloatScalar based on its unit. Rigid check on types by the compiler.
     * @param value float; the value
     * @param unit U; the unit in which the value is expressed
     * @return S; an instantiated FloatScalar with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>> S instantiate(final float value, final U unit)
    {
        return instantiateAnonymous(value, unit);
    }

    /**
     * Instantiate the FloatScalar based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param value float; the value
     * @param unit Unit&lt;?&gt;; the unit in which the value is expressed
     * @return S; an instantiated FloatScalar with the value expressed in the unit
     * @param <S> the return type
     */
    @SuppressWarnings("unchecked")
    public static <S extends AbstractFloatScalar<?, S>> S instantiateAnonymous(final float value, final Unit<?> unit)
    {
        try
        {
            Constructor<? extends AbstractFloatScalar<?, ?>> scalarConstructor = CACHE.get(unit);
            if (scalarConstructor == null)
            {
                if (!unit.getClass().getSimpleName().endsWith("Unit"))
                {
                    throw new ClassNotFoundException("Unit " + unit.getClass().getSimpleName()
                            + " name does noet end with 'Unit'. Cannot find corresponding scalar");
                }
                Class<? extends AbstractFloatScalar<?, ?>> scalarClass;
                if (unit instanceof SIUnit)
                {
                    scalarClass = FloatSIScalar.class;
                }
                else
                {
                    scalarClass = (Class<AbstractFloatScalar<?, ?>>) Class.forName(
                            "org.djunits4.value.vfloat.scalar.Float" + unit.getClass().getSimpleName().replace("Unit", ""));
                }
                scalarConstructor = scalarClass.getDeclaredConstructor(float.class, unit.getClass());
                CACHE.put(unit, scalarConstructor);
            }
            return (S) scalarConstructor.newInstance(value, unit);
        }
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
        {
            throw new UnitRuntimeException("Cannot instantiate AbstractFloatScalar of unit " + unit.toString() + ". Reason: "
                    + exception.getMessage());
        }
    }

    /**
     * Instantiate the FloatScalar based on its unit.
     * @param si float; the value in SI units
     * @param displayUnit U; the unit in which the value is expressed
     * @return S; an instantiated FloatScalar with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>> S instantiateSI(final float si, final U displayUnit)
    {
        return instantiateAnonymousSI(si, displayUnit);
    }

    /**
     * Instantiate the FloatScalar based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param si float; the value in SI units
     * @param displayUnit Unit&lt;?&gt;; the unit in which the value is expressed
     * @return an instantiated FloatScalar with the value expressed in the unit
     * @param <S> the return type
     */
    @SuppressWarnings({"unchecked"})
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>> S instantiateAnonymousSI(final float si,
            final Unit<?> displayUnit)
    {
        S value;
        value = (S) instantiateAnonymous(si, displayUnit.getStandardUnit());
        value.setDisplayUnit((U) displayUnit);
        return value;
    }

}
