package org.djunits.generator;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Apr 12, 2017 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class GenerateStaticUNITS
{
    /** the standard units. */
    private static final String[] STANDARD_UNITS = new String[] {"AbsoluteTemperatureUnit", "AccelerationUnit",
            "AngleSolidUnit", "AngleUnit", "AreaUnit", "DensityUnit", "DimensionlessUnit", "DirectionUnit", "DurationUnit",
            "ElectricalChargeUnit", "ElectricalCurrentUnit", "ElectricalPotentialUnit", "ElectricalResistanceUnit",
            "EnergyUnit", "FlowMassUnit", "FlowVolumeUnit", "ForceUnit", "FrequencyUnit", "LengthUnit", "LinearDensityUnit",
            "MassUnit", "PositionUnit", "PowerUnit", "PressureUnit", "SpeedUnit", "TemperatureUnit", "TimeUnit", "TorqueUnit",
            "VolumeUnit"};

    /**
     * 
     */
    private GenerateStaticUNITS()
    {
        // utility class
    }

    /**
     * @param args String[]; should be empty
     */
    public static void main(String[] args)
    {
        for (String className : STANDARD_UNITS)
        {
            if (!className.contains("Dimensionless"))
            {
                System.out.println();
                System.out.println(
                        "    /****************************************************************************************************************/");
                String s =
                        "    /******************************************************XX********************************************************/";
                String cs = className.toUpperCase().replace("UNIT", "");
                int i = cs.length() + 2;
                cs = (i % 2 == 1) ? cs + " " : cs;
                i = (i % 2 == 1) ? i + 2 : i;
                i = i / 2;
                s = s.replace("********************".substring(0, i - 1) + "X", " " + cs + " ");
                s = s.replace("X********************".substring(0, i), "");
                System.out.println(s);
                System.out.println(
                        "    /****************************************************************************************************************/");
                System.out.println();

                @SuppressWarnings("rawtypes")
                Class c;
                try
                {
                    c = Class.forName("org.djunits.unit." + className);
                }
                catch (Exception exception)
                {
                    System.exit(-1);
                    return;
                }

                int l = 0;
                for (Field f : c.getFields())
                {
                    if (Modifier.isPublic(f.getModifiers()) && Modifier.isStatic(f.getModifiers())
                            && Modifier.isFinal(f.getModifiers()) && !f.getName().equals("SI")
                            && !f.getName().equals("STANDARD_UNITS"))
                    {
                        String n = f.getName();
                        if (f.getName().contains("ELECTRONVOLT"))
                        {
                            n = cs.trim() + "_" + n;
                        }
                        l = Math.max(l, n.length());
                    }
                }

                for (Field f : c.getFields())
                {
                    if (Modifier.isPublic(f.getModifiers()) && Modifier.isStatic(f.getModifiers())
                            && Modifier.isFinal(f.getModifiers()) && !f.getName().equals("SI")
                            && !f.getName().equals("STANDARD_UNITS"))
                    {
                        String n = f.getName();
                        if (f.getName().contains("ELECTRONVOLT"))
                        {
                            n = cs.trim() + "_" + n;
                        }

                        String un = (n + "                                    ").substring(0, l);
                        System.out.println(
                                "    " + c.getSimpleName() + " " + un + " = " + c.getSimpleName() + "." + f.getName() + ";");
                    }
                }
            }
        }
    }

}
