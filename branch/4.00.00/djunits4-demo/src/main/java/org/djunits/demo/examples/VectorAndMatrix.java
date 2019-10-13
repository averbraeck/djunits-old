package org.djunits.demo.examples;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Duration;
import org.djunits4.value.vdouble.vector.AbsoluteTemperatureVector;
import org.djunits4.value.vdouble.vector.DurationVector;
import org.djunits4.value.vdouble.vector.TemperatureVector;
import org.djunits4.value.vdouble.vector.TimeVector;
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
public final class VectorAndMatrix
{

    /** */
    private VectorAndMatrix()
    {
        //
    }

    /**
     * @param args String[]; args
     * @throws ValueRuntimeException on error
     */
    public static void main(final String[] args) throws ValueRuntimeException
    {
        double[] doubleValues = new double[] {0.2, 10.0, 5.7, -100.0, 15.0};
        TimeVector dva = DoubleVector.instantiate(doubleValues, TimeUnit.EPOCH_MINUTE, StorageType.DENSE);
        System.out.println(dva);

        double[] doubleValues2 = new double[] {10, 20.0, 60, 120.0, 300.0};
        DurationVector dvr = DoubleVector.instantiate(doubleValues2, DurationUnit.SECOND, StorageType.DENSE);
        System.out.println(dvr);

        TimeVector dva2 = dva.plus(dvr);
        System.out.println(dva2);
        TimeVector dva3 = dva.minus(dvr);
        System.out.println(dva3);
        TimeVector dva4 = dvr.plus(dva);
        System.out.println(dva4);

        double[] tempValues = new double[] {0.0, -17.77778, -273.15, 100.0};
        AbsoluteTemperatureVector tva =
                DoubleVector.instantiate(tempValues, AbsoluteTemperatureUnit.DEGREE_CELSIUS, StorageType.DENSE);
        System.out.println(tva);

        double[] tempValues2 = new double[] {32.0, 32.0, 459.67 + 32, 212.0 - 32.0};
        TemperatureVector tvr = DoubleVector.instantiate(tempValues2, TemperatureUnit.DEGREE_FAHRENHEIT, StorageType.DENSE);
        System.out.println(tvr);

        AbsoluteTemperatureVector tva2 = tva.plus(tvr);
        System.out.println(tva2);
        AbsoluteTemperatureVector tva3 = tva.minus(tvr);
        System.out.println(tva3);
        // XXX DoubleVector.Abs<TimeUnit, DurationUnit> dva4 = dvr.plus(dva);
        System.out.println();

        DurationVector dv =
                DoubleVector.instantiate(new double[] {1.0, 2.0, 5.0, 10.0}, DurationUnit.MINUTE, StorageType.DENSE);
        Duration d = dv.get(2);
        System.out.println(d);
    }

}
