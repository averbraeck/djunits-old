package org.djunits.value.vdouble.scalar;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.djunits.unit.Unit;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Sep 14, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DoubleScalarOperationsTest
{
    /**
     * Test constructor on the interfaces that DOUBLE_SCALAR extends.
     */
    @SuppressWarnings("static-method")
    @Test
    public final void doubleScalarOperationsTest()
    {
        Class<?> ds = DOUBLE_SCALAR.class;
        // get an array of the DOUBLE_SCALAR$Length classes
        for (Class<?> dsClass : ds.getClasses())
        {
            // get the interfaces such as org.djunits.value.vdouble.scalar.Area
            for (Class<?> scalarClass : dsClass.getInterfaces())
            {
                Class<?> scalarClassRel = null;
                // get the Rel implementation of that class
                try
                {
                    scalarClassRel = Class.forName(scalarClass.getName() + "$Rel");
                }
                catch (ClassNotFoundException exception)
                {
                    Assert.fail("Class Rel not found for DoubleScalar class " + scalarClass.getName());
                }
                // find the methods defined in the class itself (not in a superclass) called multiplyBy
                for (Method method : scalarClassRel.getDeclaredMethods())
                {
                    if (method.getName().equals("multiplyBy"))
                    {
                        // note: filter out the method that multiplies by a constant...
                        testMultiplyMethodRel(scalarClassRel, method);
                    }
                }

            }
        }
    }

    /**
     * Test a multiplication method for a Rel scalar. Note: filter out the method that multiplies by a constant...
     * @param scalarClassRel the Rel class for the multiplication, e.g. Length.Rel
     * @param method the method 'multiplyBy' for that class
     */
    private void testMultiplyMethodRel(final Class<?> scalarClassRel, final Method method)
    {
        Class<?> relativeClass = null;
        try
        {
            relativeClass = Class.forName("org.djunits.value.Relative");
        }
        catch (ClassNotFoundException exception)
        {
            Assert.fail("Could not find org.djunits.value.Relative class");
        }
        Class<?>[] parTypes = method.getParameterTypes();
        if (parTypes.length != 1)
        {
            Assert.fail("DoubleScalar class " + scalarClassRel.getName() + ".multiplyBy() has " + parTypes.length
                + " parameters, <> 1");
        }
        Class<?> parameterClass = parTypes[0];
        if (parameterClass.toString().equals("double"))
        {
            // not interested in multiplying a scalar with a double.
            return;
        }
        if (!relativeClass.isAssignableFrom(parameterClass))
        {
            Assert.fail("DoubleScalar class " + scalarClassRel.getName()
                + ".multiplyBy() has parameter with non-relative class: " + relativeClass.getName());
        }

        Class<?> returnClass = method.getReturnType();
        if (!relativeClass.isAssignableFrom(returnClass))
        {
            Assert.fail("DoubleScalar class " + scalarClassRel.getName()
                + ".multiplyBy() has return type with non-relative class: " + returnClass.getName());
        }

        // get the unit classes
        Class<?> unitScalarClassRel = getUnitClass(scalarClassRel);
        Class<?> unitParamClassRel = getUnitClass(parameterClass);
        Class<?> unitReturnClassRel = getUnitClass(returnClass);

        String scalarSI = "NONE";
        String paramSI = "NONE";
        String returnSI = "NONE";

        // get the SI units of the unit classes, calling class, parameter type and return type
        try
        {
            if (unitScalarClassRel.getName().contains("Money"))
            {
                scalarSI = "1";
            }
            else
            {
                Field si = unitScalarClassRel.getField("SI");
                scalarSI = ((Unit<?>) si.get(unitScalarClassRel)).getSICoefficientsString();
            }
        }
        catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException exception)
        {
            Assert.fail("DoubleScalar class " + scalarClassRel.getName()
                + ".multiplyBy() has no field SI or no getSICoefficientsString() method");
        }

        try
        {
            if (unitParamClassRel.getName().contains("Money"))
            {
                paramSI = "1";
            }
            else
            {
                Field si = unitParamClassRel.getField("SI");
                paramSI = ((Unit<?>) si.get(unitParamClassRel)).getSICoefficientsString();
            }
        }
        catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException exception)
        {
            Assert.fail("DoubleScalar class " + parameterClass.getName()
                + ".multiplyBy() has no field SI or no getSICoefficientsString() method");
        }

        try
        {
            if (unitReturnClassRel.getName().contains("Money"))
            {
                returnSI = "1";
            }
            else
            {
                Field si = unitReturnClassRel.getField("SI");
                returnSI = ((Unit<?>) si.get(unitReturnClassRel)).getSICoefficientsString();
            }
        }
        catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException exception)
        {
            Assert.fail("DoubleScalar class " + returnClass.getName()
                + ".multiplyBy() has no field SI or no getSICoefficientsString() method");
        }

        // print what we just have done
        System.out.println(scalarClassRel.getName() + ".multiplyBy(" + parameterClass.getName() + ") => "
            + returnClass.getName() + " : " + scalarSI + " * " + paramSI + " => " + returnSI);
    }

    /**
     * Get the unit of a Scalar class by looking at the constructor with two arguments -- the second argument is the unit type.
     * @param scalarClass the class to find the unit for
     * @return the unit class for this scalar class
     */
    private Class<?> getUnitClass(final Class<?> scalarClass)
    {
        Constructor<?>[] constructors = scalarClass.getConstructors();
        for (Constructor<?> constructor : constructors)
        {
            Class<?>[] parTypes = constructor.getParameterTypes();
            if (parTypes.length == 2 && Unit.class.isAssignableFrom(parTypes[1]))
            {
                return parTypes[1];
            }
        }
        Assert.fail("Could not find constructor with one unit for Scalar class " + scalarClass.getName());
        return null;
    }
}
