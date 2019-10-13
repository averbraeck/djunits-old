package org.djunits.demo.examples;

import org.djunits4.unit.LengthUnit;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vfloat.scalar.FloatLength;

/**
 * Parsing.java. <br>
 * <br>
 * Copyright (c) 2003-2018 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://www.simulation.tudelft.nl/" target="_blank">www.simulation.tudelft.nl</a>. The
 * source code and binary code of this software is proprietary information of Delft University of Technology.
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public final class Parsing
{
    /** */
    private Parsing()
    {
        // utility method
    }
    
    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        Length l = new Length(100.0, LengthUnit.KILOMETER);
        System.out.println(l.toString());
        System.out.println(Length.valueOf(l.toString()));

        String[] sa = new String[] {"80 mm", "+80 mm", "80.0 mm", "-80.00mm", "8E6mm", "-8E-3yd", "8.mm", "0m",
                "18.37823472346234623  mi"};
        for (String s : sa)
        {
            System.out.println("\n" + Length.valueOf(s));
            System.out.println(Length.valueOf(s).toString());
        }

        System.out.println("\n==========================================================\n");

        FloatLength fl = new FloatLength(100.0f, LengthUnit.KILOMETER);
        System.out.println(fl.toString());
        System.out.println(FloatLength.valueOf(fl.toString()));

        for (String s : sa)
        {
            System.out.println("\n" + FloatLength.valueOf(s));
            System.out.println(FloatLength.valueOf(s).toString());
        }

    }

}
