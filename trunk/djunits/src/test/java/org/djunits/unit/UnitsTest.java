package org.djunits.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits.util.ClassUtil;
import org.djunits.value.Scalar;
import org.junit.Test;

/**
 * Test UNITS.java
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @version $Revision$, $LastChangedDate$, by $Author$, initial version Oct 21, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class UnitsTest implements UNITS
{
    /** The classes that are absolute (name = class name). Do not check Dimensionless. */
    public static final String[] CLASSNAMES = new String[] {"AbsoluteTemperature", "Direction", "Position", "Time",
            "Temperature", "Angle", "Length", "Duration", "Angle", "Acceleration", "AngleSolid", "Area", "Density", "Duration",
            "ElectricalCharge", "ElectricalCurrent", "ElectricalPotential", "ElectricalResistance", "Energy", "FlowMass",
            "FlowVolume", "Force", "Frequency", "Length", "LinearDensity", "Mass", "Power", "Pressure", "Speed", "Temperature",
            "Torque", "Volume"};

    /**
     * If this runs, all the static fields in the UNTIS.java interface were initialized with no errors.
     */
    @Test
    public final void testUnits()
    {
        // Accessing any static field causes the class to be loaded and all units defined therein to be initialized.
        assertTrue("It exists", METER_PER_SECOND_2 != null);
    }

    /**
     * Test all units with valueOf(...) compared to new Scalar(...). Mistakes in unit abbreviations can easily be spotted this
     * way.
     * @param <U> placeholder for unit type in loop
     * @throws ClassNotFoundException on error
     * @throws SecurityException on inaccessible constructor
     * @throws NoSuchMethodException when constructor of the scalar cannot be found
     * @throws InvocationTargetException when scalar construction fails
     * @throws IllegalArgumentException when arguments for scalar constructor don't match
     * @throws IllegalAccessException when scalar construction fails
     * @throws InstantiationException when scalar construction fails
     */
    @SuppressWarnings("unchecked")
    @Test
    public final <U extends Unit<U>> void testValueOf() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalArgumentException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        for (String className : CLASSNAMES)
        {
            Class<Scalar<U>> scalarClass = (Class<Scalar<U>>) Class.forName("org.djunits.value.vdouble.scalar." + className);
            Class<U> unitClass = (Class<U>) Class.forName("org.djunits.unit." + className + "Unit");
            for (U unit : Unit.getUnits(unitClass))
            {
                String defaultAbbreviation = unit.getDefaultTextualRepresentation();
                Constructor<Scalar<U>> scalarConstructor = scalarClass.getConstructor(double.class, unitClass);
                Scalar<U> scalarNew = scalarConstructor.newInstance(1.2, unit);
                Method valueOfMethod = ClassUtil.resolveMethod(scalarClass, "valueOf", String.class);
                Scalar<U> scalarValue = (Scalar<U>) valueOfMethod.invoke(scalarClass, "1.2" + defaultAbbreviation);
                assertEquals(scalarNew.doubleValue(), scalarValue.doubleValue(), 0.00001);
                assertEquals(scalarNew.getUnit(), scalarValue.getUnit());
                assertEquals(scalarNew, scalarValue);
                // System.out.println(scalarNew + " = " + scalarValue);
            }
        }
    }
}
