package org.djunits4.value.vdouble.scalar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.base.UnitTypes;
import org.djunits4.unit.util.UNITS;
import org.djunits4.value.CLASSNAMES;
import org.djunits4.value.vdouble.scalar.base.DoubleScalarInterface;
import org.djunits4.value.vfloat.scalar.base.FloatScalarInterface;
import org.junit.Test;

/**
 * Test the scalar contructors.
 */
public class ScalarConstructorsTest implements UNITS
{

    /**
     * Test all constructors.
     * @throws ClassNotFoundException when that happens uncaught this test has failed
     * @throws SecurityException when that happens uncaught this test has failed
     * @throws NoSuchMethodException when that happens uncaught this test has failed
     * @throws InvocationTargetException when that happens uncaught this test has failed
     * @throws IllegalArgumentException when that happens uncaught this test has failed
     * @throws IllegalAccessException when that happens uncaught this test has failed
     * @throws InstantiationException when that happens uncaught this test has failed
     */
    @Test
    public void constructorsTest() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        // Force loading of all classes
        LengthUnit length = UNITS.METER;
        if (length == null)
            fail();

        for (String className : CLASSNAMES.ALL_NODIM)
        {
            UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase(className + "Unit");
            // double
            String scalarClassName = "org.djunits4.value.vdouble.scalar." + className;
            Class<?> scalarClass = Class.forName(scalarClassName);
            Unit<?> standardUnit = unitBase.getStandardUnit();
            Constructor<?> constructor = scalarClass.getConstructor(double.class, standardUnit.getClass());
            double testValue = 123.456d;
            Object[] args = new Object[] { testValue, standardUnit };
            DoubleScalarInterface<?, ?> doubleScalar = (DoubleScalarInterface<?, ?>) constructor.newInstance(args);
            System.out.println(doubleScalar);
            assertEquals("Value must match", testValue, doubleScalar.getSI(), 0.1);
            assertEquals("Unit must match", standardUnit, doubleScalar.getUnit());
            // float
            scalarClassName = "org.djunits4.value.vfloat.scalar.Float" + className;
            scalarClass = Class.forName(scalarClassName);
            float floatTestValue = 12.34f;
            args[0] = floatTestValue;
            constructor = scalarClass.getConstructor(float.class, standardUnit.getClass());
            args = new Object[] { floatTestValue, standardUnit };
            FloatScalarInterface<?, ?> floatScalar = (FloatScalarInterface<?, ?>) constructor.newInstance(args);
            System.out.println(doubleScalar);
            assertEquals("Value must match", floatTestValue, floatScalar.getSI(), 0.1);
            assertEquals("Unit must match", standardUnit, floatScalar.getUnit());
        }
    }
}
