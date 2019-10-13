package org.djunits.demo.website;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Duration;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vdouble.scalar.Speed;
import org.djunits4.value.vdouble.vector.base.DoubleVector;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class Test
{
    /** Furlong example. */
    public static final LengthUnit FURLONG = LengthUnit.FOOT.deriveLinear(660.0, "fr", "Furlong");

    /** Fortnight example. */
    public static final DurationUnit FORTNIGHT = DurationUnit.DAY.deriveLinear(14.0, "fn", "Fortnight");

    /** fr/fn example. */
    public static final SpeedUnit FURLONGS_PER_FORTNIGHT =
            SpeedUnit.SI.deriveLinear(FURLONG.getScale().toStandardUnit(1.0) / FORTNIGHT.getScale().toStandardUnit(1.0),
                    "fr/fn", "Furlongs per Fortnight");

    /** */
    private Test()
    {
        // utility class
    }

    /**
     * @param args String[]; args
     * @throws ValueRuntimeException on error
     */
    public static void main(final String[] args) throws ValueRuntimeException
    {
        Length fr1000 = new Length(1000.0, FURLONG);
        Duration twoWeeks = new Duration(1.0, FORTNIGHT);
        Speed speed = fr1000.divide(twoWeeks);
        System.out.println(speed);
        System.out.println(speed.toString(FURLONGS_PER_FORTNIGHT));
        System.out.println();

        Jerk jerk1 = new Jerk(1.2, JerkUnit.SI);
        System.out.println("jerk1 = Jerk(1.2, JerkUnit.SI) : " + jerk1);
        Jerk jerk2 = jerk1.times(2.0);
        System.out.println("jerk2 = jerk1.multiplyBy(2.0)                    : " + jerk2);
        double[] sv = new double[] {1, 2, 3, 4, 5};
        JerkVector jerkVector = DoubleVector.instantiate(sv, JerkUnit.SI, StorageType.DENSE);
        System.out.println("jerkVector: : " + jerkVector);

        Jerk jjerk1 = new Jerk(1.2, JerkUnit.SI);
        System.out.println("jerk1 = new Jerk(1.2, JerkUnit.SI) : " + jjerk1);
        Jerk jjerk2 = jjerk1.times(2.0);
        System.out.println("jerk2 = jerk1.multiplyBy(2.0)      : " + jjerk2);

        double[][] data = new double[1000][1000];
        for (int i = 0; i < 1000; i++)
        {
            for (int j = 0; j < 1000; j++)
            {
                data[i][j] = 9 * i + 2 * j * 0.364;
            }
        }
    }

}
