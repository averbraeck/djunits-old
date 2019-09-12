package org.djunits4.value.vdouble.scalar;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.base.UnitBase;
import org.djunits4.unit.base.UnitTypes;
import org.djunits4.unit.util.UNITS;
import org.djunits4.value.CLASSNAMES;
import org.djunits4.value.base.Scalar;
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

        for (String className : CLASSNAMES.ALL_NODIM)
        {
            for (boolean doubleType : new boolean[] { true, false })
            {
                String doubleOrFloat = doubleType ? "double" : "float";
                String scalarClassName =
                        "org.djunits4.value.v" + doubleOrFloat + ".scalar." + (doubleType ? "" : "Float") + className;
                Class<?> scalarClass = Class.forName(scalarClassName);
                UnitBase<?> unitBase = UnitTypes.INSTANCE.getUnitBase(className + "Unit");
                Unit<?> standardUnit = unitBase.getStandardUnit();
                Constructor<?> constructor =
                        scalarClass.getConstructor(doubleType ? double.class : float.class, standardUnit.getClass());
                Object[] args = new Object[] { null, standardUnit };
                if (doubleType)
                {
                    args[0] = 123.456d;
                }
                else
                {
                    args[0] = 12.34f;
                }
                Scalar<?, ?> scalar =
                        (Scalar<?, ?>) constructor.newInstance(args);
                System.out.println(scalar);
            }
        }
    }
}
