package org.djunits4.value.vfloat.scalar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.VolumeUnit;
import org.djunits4.value.CLASSNAMES;
import org.djunits4.value.Scalar;
import org.junit.Test;

/**
 * Test the FloatScalar and FloatScalar classes for the valueOf and stringOf methods.
 * <p>
 * This file was generated by the djunits value test classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version 26 jun, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatValueOfStringOfTest
{
    /**
     * Test the FloatDuration class for the valueOf and stringOf methods.
     */
    @Test
    public final void durationValueOfTest()
    {
        FloatDuration floatDuration = new FloatDuration(10.0f, DurationUnit.MINUTE);
        assertEquals("10.0 min", Scalar.stringOf(floatDuration));
        assertEquals(floatDuration, FloatDuration.valueOf(Scalar.stringOf(floatDuration)));
    }

    /**
     * Test the FloatScalar and FloatScalar classes for the valueOf and stringOf methods.
     */
    @Test
    public final void valueOfFloatTest()
    {
        for (String className : CLASSNAMES.REL)
        {
            // get the class
            Class<?> scalarClass = null;
            String classPath = "org.djunits4.value.vfloat.scalar.Float" + className;
            try
            {
                scalarClass = Class.forName(classPath);
            }
            catch (ClassNotFoundException exception)
            {
                fail("Class not found for Scalar class " + classPath);
            }

            // create a value so we can obtain info
            Method createSIMethod = null;
            try
            {
                createSIMethod = scalarClass.getMethod("createSI", float.class);
            }
            catch (NoSuchMethodException | SecurityException exception)
            {
                fail("Method createSI not found for Scalar class " + classPath);
            }
            Scalar<?> scalarSI = null;
            try
            {
                scalarSI = (Scalar<?>) createSIMethod.invoke(scalarClass, new Float(10.0));
            }
            catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
            {
                fail("Method createSI failed for Scalar class " + classPath);
            }

            // get the unit
            Unit<?> unitSI = scalarSI.getUnit();

            // get the constructor
            Constructor<?> constructScalar = null;
            try
            {
                constructScalar = scalarClass.getConstructor(float.class, unitSI.getClass());
            }
            catch (NoSuchMethodException | SecurityException exception)
            {
                fail("Constructor for unit " + unitSI.getClass().getName() + " not found for Scalar class " + classPath);
            }

            // loop over all the unit types
            for (Unit<?> unit : unitSI.getUnitBase().getUnitsById().values())
            {
                if (unit.equals(VolumeUnit.CUBIC_LIGHTYEAR) || unit.equals(VolumeUnit.CUBIC_PARSEC))
                    continue; // does not fit in a float...
                Scalar<?> scalarUnit = null;
                try
                {
                    scalarUnit = (Scalar<?>) constructScalar.newInstance(new Float(1.0), unit);
                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                        | InstantiationException exception)
                {
                    fail("Construct with unit " + unit.getClass().getName() + " failed for Scalar class " + classPath);
                }

                // see if the 'valueOf' and the 'StringOf' match
                String scalarString = null;
                String unitRep = null;
                try
                {
                    unitRep = unit.getDefaultTextualAbbreviation();
                }
                catch (Exception e)
                {
                    fail("getDefaultTextualRepresentation for unit " + unit.getClass().getName() + " failed for Scalar class "
                            + classPath);
                }
                try
                {
                    scalarString = Scalar.textualStringOfDefaultLocale(scalarUnit);
                }
                catch (Exception e)
                {
                    fail("textualStringOfDefaultLocale for scalar " + scalarUnit + " failed for Scalar class " + classPath);
                }
                // rounding errors can lead to values such as 1.0000000195414815 yK
                assertTrue("Scalar string for scalar " + scalarUnit.getClass().getSimpleName() + " not equal to 1.0: "
                        + scalarString, scalarString.startsWith("1.0") || scalarString.startsWith("0.99"));
                assertTrue(scalarString.endsWith(" " + unitRep));

                // find the valueOf method
                Method valueOfMethod = null;
                try
                {
                    valueOfMethod = scalarClass.getMethod("valueOf", String.class);
                }
                catch (NoSuchMethodException | SecurityException exception)
                {
                    fail("Method valueOf not found for Scalar class " + classPath);
                }
                Scalar<?> value = null;
                try
                {
                    System.out.println("Calling " + scalarClass.getName() + ".valueOf(" + scalarString + ")");
                    value = (Scalar<?>) valueOfMethod.invoke(scalarClass, scalarString);
                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
                {
                    if (exception.getCause() != null)
                    {
                        exception.getCause().printStackTrace();
                    }
                    else
                    {
                        exception.printStackTrace();
                    }
                    fail("Method valueOf failed for Scalar class " + classPath);
                }
                assertEquals(value.toString(), scalarUnit.toString());
                
                
                // find the of method
                Method ofMethod = null;
                try
                {
                    ofMethod = scalarClass.getMethod("of", float.class, String.class);
                }
                catch (NoSuchMethodException | SecurityException exception)
                {
                    fail("Method 'of' not found for Scalar class " + classPath);
                }
                Scalar<?> ofValue = null;
                try
                {
                    System.out.println("Calling " + scalarClass.getName() + ".of(" + scalarString + ")");
                    ofValue = (Scalar<?>) ofMethod.invoke(scalarClass, 1.0f, unit.getDefaultTextualAbbreviation());
                }
                catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
                {
                    if (exception.getCause() != null)
                    {
                        exception.getCause().printStackTrace();
                    }
                    else
                    {
                        exception.printStackTrace();
                    }
                    fail("Method 'of' failed for Scalar class " + classPath);
                }
                assertEquals(ofValue.toString(), scalarUnit.toString());
            }
        }
    }
}