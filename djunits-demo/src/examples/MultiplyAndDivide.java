package examples;

import java.util.Locale;

import org.djunits.value.vdouble.scalar.DOUBLE_SCALAR;

/**
 * This Java code demonstrates multiplication and division using DJUNITS.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @version $Revision$, $LastChangedDate$, by $Author$, initial version 3 sep. 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MultiplyAndDivide implements DOUBLE_SCALAR
{
    /**
     * Create some scalar values to demonstrate conversion from and to related units.
     * @param args String[]; the command line arguments; not used
     */
    public static void main(final String[] args)
    {
        Locale.setDefault(Locale.US); // Ensure that floating point values are printed using a dot (".")
        Speed speed = new Speed(50, KM_PER_HOUR);
        Time.Rel duration = new Time.Rel(0.5, HOUR);
        System.out.println("speed is " + speed); // prints 50.000km/h
        System.out.println("duration is " + duration); // prints 0.500h
        Length.Rel distance = speed.toRel().multiplyBy(duration);
        System.out.println("distance is " + distance); // prints 2.500e+04m
        Length.Rel finish = new Length.Rel(100, KILOMETER);
        Time.Rel timeToFinish = finish.divideBy(speed.toRel());
        System.out.println("at speed " + speed + " it will take " + timeToFinish + " to travel " + finish);
        Speed requiredSpeed = finish.divideBy(duration);
        System.out.println("speed required to reach finish at " + finish + " in " + duration + " is "
                + requiredSpeed.toString(KM_PER_HOUR));
    }

}
