package org.djunits.demo.examples;

import java.util.Locale;

import org.djunits.unit.SpeedUnit;
import org.djunits.unit.UNITS;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Duration;
import org.djunits.value.vdouble.scalar.Length;
import org.djunits.value.vdouble.scalar.Speed;
import org.djunits.value.vdouble.vector.DoubleVector;

/**
 * This Java code demonstrates multiplication and division using DJUNITS.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @version $Revision$, $LastChangedDate$, by $Author$,
 *          initial version 3 sep. 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public final class MultiplyAndDivide implements UNITS
{
    /** */
    private MultiplyAndDivide()
    {
        // utility constructor.
    }

    /**
     * Create some scalar values to demonstrate conversion from and to related units.
     * @param args String[]; the command line arguments; not used
     * @throws ValueException in case of error
     */
    public static void main(final String[] args) throws ValueException
    {
        Locale.setDefault(Locale.US); // Ensure that floating point values are printed using a dot (".")
        Speed speed = new Speed(50, KM_PER_HOUR);
        Duration duration = new Duration(0.5, HOUR);
        System.out.println("speed is " + speed); // prints 50.000km/h
        System.out.println("duration is " + duration); // prints 0.500h
        Length distance = speed.multiplyBy(duration);
        System.out.println("distance is " + distance); // prints 2.500e+04m
        Length finish = new Length(100, KILOMETER);
        Duration timeToFinish = finish.divideBy(speed);
        System.out.println("at speed " + speed + " it will take " + timeToFinish + " to travel " + finish);
        Speed requiredSpeed = finish.divideBy(duration);
        System.out.println("speed required to reach finish at " + finish + " in " + duration + " is "
                + requiredSpeed.toString(KM_PER_HOUR));
        DoubleScalar.Rel<SpeedUnit> speed1 = new DoubleScalar.Rel<>(1.2, SpeedUnit.SI);
        DoubleScalar.Rel<SpeedUnit> speed2 = speed1.multiplyBy(2.0);
        DoubleScalar.Rel<SpeedUnit> speed3 = speed1.multiplyBy(3.0);
        double[] sv = new double[] { 1, 2, 3, 4, 5 };
        DoubleVector.Rel<SpeedUnit> speedVector = new DoubleVector.Rel<SpeedUnit>(sv, SpeedUnit.SI, StorageType.DENSE);
    }

}
