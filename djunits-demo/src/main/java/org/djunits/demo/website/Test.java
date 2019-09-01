package org.djunits.demo.website;

import org.djunits.unit.DurationUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.unitsystem.UnitSystem;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.matrix.MutableLengthMatrix;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Duration;
import org.djunits.value.vdouble.scalar.Length;
import org.djunits.value.vdouble.scalar.Speed;
import org.djunits.value.vdouble.vector.DoubleVector;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 16, 2016 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class Test
{
    /** Furlong example. */
    public static final LengthUnit FURLONG = new LengthUnit("Furlong", "fr", UnitSystem.IMPERIAL, LengthUnit.FOOT, 660);

    /** Fortnight example. */
    public static final DurationUnit FORTNIGHT = new DurationUnit("Fortnight", "fn", UnitSystem.OTHER, DurationUnit.DAY, 14);

    /** fr/fn example. */
    public static final SpeedUnit FURLONGS_PER_FORTNIGHT =
            new SpeedUnit(FURLONG, FORTNIGHT, "Furlongs per Fortnight", "fr/fn", UnitSystem.OTHER);

    /** */
    private Test()
    {
        // utility class
    }

    /**
     * @param args String[]; args
     * @throws ValueException on error
     */
    public static void main(final String[] args) throws ValueException
    {
        Length fr1000 = new Length(1000.0, FURLONG);
        Duration twoWeeks = new Duration(1.0, FORTNIGHT);
        Speed speed = fr1000.divideBy(twoWeeks);
        System.out.println(speed);
        System.out.println(speed.toString(FURLONGS_PER_FORTNIGHT));
        System.out.println();

        DoubleScalar.Rel<JerkUnit> jerk1 = new DoubleScalar.Rel<>(1.2, JerkUnit.SI);
        System.out.println("jerk1 = new DoubleScalar.Rel<>(1.2, JerkUnit.SI) : " + jerk1);
        DoubleScalar.Rel<JerkUnit> jerk2 = jerk1.multiplyBy(2.0);
        System.out.println("jerk2 = jerk1.multiplyBy(2.0)                    : " + jerk2);
        double[] sv = new double[] {1, 2, 3, 4, 5};
        DoubleVector.Rel<JerkUnit> jerkVector = new DoubleVector.Rel<JerkUnit>(sv, JerkUnit.SI, StorageType.DENSE);
        System.out.println("jerkVector: : " + jerkVector);

        Jerk jjerk1 = new Jerk(1.2, JerkUnit.SI);
        System.out.println("jerk1 = new Jerk(1.2, JerkUnit.SI) : " + jjerk1);
        Jerk jjerk2 = jjerk1.multiplyBy(2.0);
        System.out.println("jerk2 = jerk1.multiplyBy(2.0)      : " + jjerk2);

        double[][] data = new double[1000][1000];
        for (int i = 0; i < 1000; i++)
        {
            for (int j = 0; j < 1000; j++)
            {
                data[i][j] = 9 * i + 2 * j * 0.364;
            }
        }
        MutableLengthMatrix lengthMatrix = new MutableLengthMatrix(data, LengthUnit.CENTIMETER, StorageType.DENSE);
        lengthMatrix.round();
    }

}
