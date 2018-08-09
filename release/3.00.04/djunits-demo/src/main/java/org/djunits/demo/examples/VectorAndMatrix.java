package org.djunits.demo.examples;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.DurationUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Duration;
import org.djunits.value.vdouble.vector.DoubleVector;
import org.djunits.value.vdouble.vector.DurationVector;

/**
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Apr 28, 2017 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class VectorAndMatrix
{

    /** */
    private VectorAndMatrix()
    {
        //
    }

    /**
     * @param args args
     * @throws ValueException on error
     */
    public static void main(final String[] args) throws ValueException
    {
        double[] doubleValues = new double[] { 0.2, 10.0, 5.7, -100.0, 15.0 };
        DoubleVector.Abs<TimeUnit, DurationUnit> dva =
                new DoubleVector.Abs<TimeUnit, DurationUnit>(doubleValues, TimeUnit.EPOCH_MINUTE, StorageType.DENSE);
        System.out.println(dva);

        double[] doubleValues2 = new double[] { 10, 20.0, 60, 120.0, 300.0 };
        DoubleVector.Rel<DurationUnit> dvr =
                new DoubleVector.Rel<DurationUnit>(doubleValues2, DurationUnit.SECOND, StorageType.DENSE);
        System.out.println(dvr);

        DoubleVector.Abs<TimeUnit, DurationUnit> dva2 = dva.plus(dvr);
        System.out.println(dva2);
        DoubleVector.Abs<TimeUnit, DurationUnit> dva3 = dva.minus(dvr);
        System.out.println(dva3);
        // XXX DoubleVector.Abs<TimeUnit, DurationUnit> dva4 = dvr.plus(dva);
        System.out.println();

        double[] tempValues = new double[] { 0.0, -17.77778, -273.15, 100.0 };
        DoubleVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> tva =
                new DoubleVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit>(tempValues,
                        AbsoluteTemperatureUnit.DEGREE_CELSIUS, StorageType.DENSE);
        System.out.println(tva);

        double[] tempValues2 = new double[] { 32.0, 32.0, 459.67 + 32, 212.0 - 32.0 };
        DoubleVector.Rel<TemperatureUnit> tvr =
                new DoubleVector.Rel<TemperatureUnit>(tempValues2, TemperatureUnit.DEGREE_FAHRENHEIT, StorageType.DENSE);
        System.out.println(tvr);

        DoubleVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> tva2 = tva.plus(tvr);
        System.out.println(tva2);
        DoubleVector.Abs<AbsoluteTemperatureUnit, TemperatureUnit> tva3 = tva.minus(tvr);
        System.out.println(tva3);
        // XXX DoubleVector.Abs<TimeUnit, DurationUnit> dva4 = dvr.plus(dva);
        System.out.println();
        
        DurationVector dv = new DurationVector(new double[] {1.0,  2.0,  5.0, 10.0}, DurationUnit.MINUTE, StorageType.DENSE);
        Duration d = dv.get(2);
        System.out.println(d);
    }

}
