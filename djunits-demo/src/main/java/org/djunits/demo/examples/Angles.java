package org.djunits.demo.examples;

import org.djunits.unit.AngleUnit;
import org.djunits.value.AngleUtil;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Angle;

/**
 * Normalization of angles.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/node/13">OpenTrafficSim License</a>.
 * <p>
 * @version $Revision$, $LastChangedDate$, by $Author$, initial version Oct 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Angles
{
    /**
     * Create some Angle values to demonstrate conversion from and to related units, including the non-linear AngleUnit.PERCENT.
     * @param args String[]; the command line arguments; not used
     * @throws ValueException in case of error
     */
    public static void main(final String[] args) throws ValueException
    {
        System.out.println("Normalization of an angle adds or subtracts a multiple of 2\u03c0. For linear angle units "
            + "the result is a value between 0 and +2\u03c0.");
        System.out.println("Angles not between -90\u00b0 and +90\u00b0, -\u03c0/2 and +\u03c0/2 cannot properly be "
            + "expressed as percentage.");
        Angle.Rel a1 = new Angle.Rel(3 * Math.PI, AngleUnit.RADIAN);
        // This now works: Why does this not work: Angle.Rel normA1 = AngleUtil.normalize(a1);
        System.out.println("3 * \u03c0: " + a1 + " (" + a1.toString(AngleUnit.DEGREE) + ") -> "
            + AngleUtil.normalize(a1) + " (" + AngleUtil.normalize(a1).toString(AngleUnit.DEGREE) + ")");
        System.out.println("3 * \u03c0: " + a1 + " (" + a1.toString(AngleUnit.DEGREE) + ", "
            + a1.toString(AngleUnit.PERCENT) + ") -> " + AngleUtil.normalize(a1) + " ("
            + AngleUtil.normalize(a1).toString(AngleUnit.DEGREE) + ", "
            + AngleUtil.normalize(a1).toString(AngleUnit.PERCENT) + ") Note: percentage almost 0");
        Angle.Rel a2 = new Angle.Rel(-Math.PI, AngleUnit.RADIAN);
        System.out.println("   -\u03c0: " + a2 + " (" + a2.toString(AngleUnit.DEGREE) + ") -> "
            + AngleUtil.normalize(a2) + " (" + AngleUtil.normalize(a2).toString(AngleUnit.DEGREE) + ")");
        System.out.println("   -\u03c0: " + a2 + " (" + a2.toString(AngleUnit.DEGREE) + ", "
            + a2.toString(AngleUnit.PERCENT) + ") -> " + AngleUtil.normalize(a2) + " ("
            + AngleUtil.normalize(a2).toString(AngleUnit.DEGREE) + ", "
            + AngleUtil.normalize(a2).toString(AngleUnit.PERCENT) + ") Note: percentage almost 0");
        Angle.Rel a3 = new Angle.Rel(-45, AngleUnit.DEGREE);
        System.out.println("  -45\u0090: " + a3 + " (" + a3.toString(AngleUnit.RADIAN) + ", "
            + a3.toString(AngleUnit.PERCENT) + ") -> " + AngleUtil.normalize(a3) + " ("
            + AngleUtil.normalize(a3).toString(AngleUnit.RADIAN) + ", "
            + AngleUtil.normalize(a3).toString(AngleUnit.PERCENT) + ")");
        System.out.println("");
        System.out.println("Angles expressed as percentage are always between -inf and +inf (-90\u00b0 and +90\u00b0, "
            + "-\u03c0/2 and +\u03c0/2); even after normalization.");
        Angle.Rel a4 = new Angle.Rel(-100, AngleUnit.PERCENT);
        System.out.println("-100%: " + a4 + " (" + a4.toString(AngleUnit.DEGREE) + ", " + a4.toString(AngleUnit.RADIAN)
            + ") -> " + AngleUtil.normalize(a4) + " (" + AngleUtil.normalize(a4).toString(AngleUnit.DEGREE) + ", "
            + AngleUtil.normalize(a4).toString(AngleUnit.RADIAN) + ")");
        Angle.Rel a5 = new Angle.Rel(100, AngleUnit.PERCENT);
        System.out.println(" 100%: " + a5 + " (" + a5.toString(AngleUnit.DEGREE) + ", " + a5.toString(AngleUnit.RADIAN)
            + ") -> " + AngleUtil.normalize(a5) + " (" + AngleUtil.normalize(a5).toString(AngleUnit.DEGREE) + ", "
            + AngleUtil.normalize(a5).toString(AngleUnit.RADIAN) + ")");
        Angle.Rel a6 = new Angle.Rel(1000, AngleUnit.PERCENT);
        System.out.println("1000%: " + a6 + " (" + a6.toString(AngleUnit.DEGREE) + ", " + a6.toString(AngleUnit.RADIAN)
            + ") -> " + AngleUtil.normalize(a6) + " (" + AngleUtil.normalize(a6).toString(AngleUnit.DEGREE) + ", "
            + AngleUtil.normalize(a6).toString(AngleUnit.RADIAN) + ")");

    }
}
