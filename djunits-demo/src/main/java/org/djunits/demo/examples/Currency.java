package org.djunits.demo.examples;

import java.util.Locale;

import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.UNITS;
import org.djunits.value.vdouble.scalar.Density;
import org.djunits.value.vdouble.scalar.Mass;
import org.djunits.value.vdouble.scalar.Money;
import org.djunits.value.vdouble.scalar.MoneyPerMass;
import org.djunits.value.vdouble.scalar.Volume;

/**
 * This Java code demonstrates demonstrates the use of Money units in DJUNITS.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @version $Revision$, $LastChangedDate$, by $Author$,
 *          initial version 7 sep. 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public final class Currency implements UNITS
{
    /** */
    private Currency()
    {
        // utility constructor.
    }

    /**
     * Create some scalar values to demonstrate conversion from and to related units.
     * @param args String[]; the command line arguments; not used
     */
    public static void main(final String[] args)
    {
        Locale.setDefault(Locale.US); // Ensure that floating point values are printed using a dot (".")
        MoneyUnit.setStandardUnit(MoneyUnit.EUR);
        Density density = new Density(150.0, KG_PER_METER_3);
        MoneyPerMass costPerKG = new MoneyPerMass(20.0, MoneyPerMassUnit.EUR_PER_KILOGRAM);
        System.out.println("standard price " + costPerKG); // prints 20.000�/kg
        Money startupCost = new Money(100.0, MoneyUnit.EUR);
        Volume volume = new Volume(300.0, LITER);
        Mass totalWeight = volume.multiplyBy(density);
        System.out.println("weight of " + volume + " is " + totalWeight); // prints 45.000kg
        Money totalCost = startupCost.plus(totalWeight.multiplyBy(costPerKG));
        System.out.println("total cost " + totalCost); // prints 1000.000EUR
    }
}
