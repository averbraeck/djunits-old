package org.djunits.demo.examples;

import org.djunits.unit.LengthUnit;
import org.djunits.value.Scalar;
import org.djunits.value.vdouble.scalar.Length;
import org.djunits.value.vfloat.scalar.FloatLength;

/**
 * Parsing.java. <br>
 * <br>
 * Copyright (c) 2003-2018 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://www.simulation.tudelft.nl/" target="_blank">www.simulation.tudelft.nl</a>. The
 * source code and binary code of this software is proprietary information of Delft University of Technology.
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class Parsing
{
    public static void main(String[] args)
    {
        Length l = new Length(100.0, LengthUnit.KILOMETER);
        System.out.println(Scalar.stringOf(l));
        System.out.println(Length.valueOf(Scalar.stringOf(l)));

        String[] sa = new String[] {"80 mm", "+80 mm", "80.0 mm", "-80.00mm", "8E6mm", "-8E-3yd", "8.mm", "0m",
                "18.37823472346234623  mi"};
        for (String s : sa)
        {
            System.out.println("\n" + Length.valueOf(s));
            System.out.println(Scalar.stringOf(Length.valueOf(s)));
        }

        System.out.println("\n==========================================================\n");
        
        FloatLength fl = new FloatLength(100.0f, LengthUnit.KILOMETER);
        System.out.println(Scalar.stringOf(fl));
        System.out.println(FloatLength.valueOf(Scalar.stringOf(fl)));

        for (String s : sa)
        {
            System.out.println("\n" + FloatLength.valueOf(s));
            System.out.println(Scalar.stringOf(FloatLength.valueOf(s)));
        }

    }

}

