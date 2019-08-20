package org.djunits.value.vdouble.scalar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.AngleSolidUnit;
import org.djunits.unit.AngleUnit;
import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.DirectionUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.Unit;
import org.junit.Test;

/**
 * Test the instantiation utility functions.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 11, 2018 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public class DoubleScalarUtilTest
{
    /**
     * Test the instantiation utility function of classes.
     */
    @Test
    public final void instantiateTest()
    {
        Dimensionless dimensionless = DoubleScalarUtil.instantiate(10.0, DimensionlessUnit.SI);
        assertEquals("Dimensionless", 10.0, dimensionless.si, 0.0001d);
        dimensionless = DoubleScalarUtil.instantiateSI(10.0, DimensionlessUnit.SI);
        assertEquals("Dimensionless", 10.0, dimensionless.si, 0.0001d);
        assertSame("Dimensionless", DimensionlessUnit.SI, dimensionless.getUnit());

        Acceleration acceleration = DoubleScalarUtil.instantiate(10.0, AccelerationUnit.SI);
        assertEquals("Acceleration", 10.0, acceleration.si, 0.0001d);
        acceleration = DoubleScalarUtil.instantiate(12960.0, AccelerationUnit.KM_PER_HOUR_2);
        assertEquals("Acceleration", 1.0, acceleration.si, 0.001d);
        acceleration = DoubleScalarUtil.instantiateSI(10.0, AccelerationUnit.KM_PER_HOUR_2);
        assertEquals("Acceleration", 10.0, acceleration.si, 0.0001d);
        assertSame("Acceleration", AccelerationUnit.KM_PER_HOUR_2, acceleration.getUnit());

        AngleSolid angleSolid = DoubleScalarUtil.instantiate(10.0, AngleSolidUnit.SI);
        assertEquals("AngleSolid", 10.0, angleSolid.si, 0.0001d);
        angleSolid = DoubleScalarUtil.instantiate(1.0, AngleSolidUnit.SQUARE_DEGREE);
        assertEquals("AngleSolid", (Math.PI / 180.0) * (Math.PI / 180.0), angleSolid.si, 0.001d);
        angleSolid = DoubleScalarUtil.instantiateSI(10.0, AngleSolidUnit.SQUARE_DEGREE);
        assertEquals("AngleSolid", 10.0, angleSolid.si, 0.0001d);
        assertSame("AngleSolid", AngleSolidUnit.SQUARE_DEGREE, angleSolid.getUnit());

        Angle angle = DoubleScalarUtil.instantiate(10.0, AngleUnit.SI);
        assertEquals("Angle", 10.0, angle.si, 0.0001d);
        angle = DoubleScalarUtil.instantiate(1.0, AngleUnit.DEGREE);
        assertEquals("Angle", Math.PI / 180.0, angle.si, 0.001d);
        angle = DoubleScalarUtil.instantiateSI(10.0, AngleUnit.DEGREE);
        assertEquals("Angle", 10.0, angle.si, 0.0001d);
        assertSame("Angle", AngleUnit.DEGREE, angle.getUnit());

        Direction direction = DoubleScalarUtil.instantiate(10.0, DirectionUnit.BASE);
        assertEquals("Direction", 10.0, direction.si, 0.0001d);
        direction = DoubleScalarUtil.instantiate(1.0, DirectionUnit.EAST_DEGREE);
        assertEquals("Direction", Math.PI / 180.0, direction.si, 0.001d);
        direction = DoubleScalarUtil.instantiateSI(10.0, DirectionUnit.EAST_DEGREE);
        assertEquals("Direction", 10.0, direction.si, 0.0001d);
        assertSame("Direction", DirectionUnit.EAST_DEGREE, direction.getUnit());

        Area area = DoubleScalarUtil.instantiate(10.0, AreaUnit.SI);
        assertEquals("Area", 10.0, area.si, 0.0001d);
        area = DoubleScalarUtil.instantiate(1.0, AreaUnit.HECTARE);
        assertEquals("Area", 10000.0, area.si, 0.001d);
        area = DoubleScalarUtil.instantiateSI(10.0, AreaUnit.HECTARE);
        assertEquals("Area", 10.0, area.si, 0.0001d);
        assertSame("Area", AreaUnit.HECTARE, area.getUnit());

        // TODO: other base units

        Money money = DoubleScalarUtil.instantiate(10.0, MoneyUnit.USD);
        assertEquals("Money", 10.0, money.si, 0.0001d);
        money = DoubleScalarUtil.instantiate(100.0, MoneyUnit.EUR);
        assertEquals("Money", 100.0, money.si, 0.001d);
        money = DoubleScalarUtil.instantiateSI(10.0, MoneyUnit.EUR);
        assertEquals("Money", 10.0, money.si, 0.0001d);
        assertSame("Money", MoneyUnit.EUR, money.getUnit());

        MoneyPerAreaUnit unitUSDm2 = new MoneyPerAreaUnit(MoneyUnit.USD, AreaUnit.SQUARE_METER, "USD/m2", "$/m2");
        MoneyPerAreaUnit unitEURha = new MoneyPerAreaUnit(MoneyUnit.EUR, AreaUnit.HECTARE, "EUR/ha", "EUR/ha");
        MoneyPerArea moneyPerArea = DoubleScalarUtil.instantiate(10.0, unitUSDm2);
        assertEquals("MoneyPerArea", 10.0, moneyPerArea.si, 0.0001d);
        moneyPerArea = DoubleScalarUtil.instantiate(10000.0, unitEURha);
        assertEquals("MoneyPerArea", 1.0, moneyPerArea.si, 0.001d);
        moneyPerArea = DoubleScalarUtil.instantiateSI(10.0, unitEURha);
        assertEquals("MoneyPerArea", 10.0, moneyPerArea.si, 0.0001d);
        assertSame("MoneyPerArea", unitEURha, moneyPerArea.getUnit());

        MoneyPerEnergyUnit unitUSDJ = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.JOULE, "USD/J", "$/J");
        MoneyPerEnergyUnit unitEURKJ = new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.KILOJOULE, "EUR/MWh", "EUR/KJ");
        MoneyPerEnergy moneyPerEnergy = DoubleScalarUtil.instantiate(10.0, unitUSDJ);
        assertEquals("MoneyPerEnerg", 10.0, moneyPerEnergy.si, 0.0001d);
        moneyPerEnergy = DoubleScalarUtil.instantiate(1000.0, unitEURKJ);
        assertEquals("MoneyPerEnerg", 1.0, moneyPerEnergy.si, 0.001d);
        moneyPerEnergy = DoubleScalarUtil.instantiateSI(10.0, unitEURKJ);
        assertEquals("MoneyPerEnerg", 10.0, moneyPerEnergy.si, 0.0001d);
        assertSame("MoneyPerEnerg", unitEURKJ, moneyPerEnergy.getUnit());

    }

    /**
     * Test the instantiation utility function of classes for anonymous units, also for the compiler.
     */
    @Test
    public final void anonymousUnitTest()
    {
        Unit<?> unitSI = LengthUnit.SI;
        Unit<?> unitKM = LengthUnit.KILOMETER;
        Length length = DoubleScalarUtil.instantiateAnonymous(10.0, unitSI);
        assertEquals("Length", 10.0, length.si, 0.0001d);
        length = DoubleScalarUtil.instantiateAnonymous(1.0, unitKM);
        assertEquals("Length", 1000.0, length.si, 0.001d);
        length = DoubleScalarUtil.instantiateAnonymousSI(10.0, unitKM);
        assertEquals("Length", 10.0, length.si, 0.0001d);
        assertSame("Length", unitKM, length.getUnit());

        // TODO: other base units

        Unit<?> unitUSD = MoneyUnit.USD;
        Unit<?> unitEUR = MoneyUnit.EUR;
        Money money = DoubleScalarUtil.instantiateAnonymous(10.0, unitUSD);
        assertEquals("Money", 10.0, money.si, 0.0001d);
        money = DoubleScalarUtil.instantiateAnonymous(100.0, unitEUR);
        assertEquals("Money", 100.0, money.si, 0.001d);
        money = DoubleScalarUtil.instantiateAnonymousSI(10.0, unitEUR);
        assertEquals("Money", 10.0, money.si, 0.0001d);
        assertSame("Money", unitEUR, money.getUnit());

        Unit<?> unitUSDm2 = new MoneyPerAreaUnit(MoneyUnit.USD, AreaUnit.SQUARE_METER, "USD/m2", "$/m2");
        Unit<?> unitEURha = new MoneyPerAreaUnit(MoneyUnit.EUR, AreaUnit.HECTARE, "EUR/ha", "EUR/ha");
        MoneyPerArea moneyPerArea = DoubleScalarUtil.instantiateAnonymous(10.0, unitUSDm2);
        assertEquals("MoneyPerArea", 10.0, moneyPerArea.si, 0.0001d);
        moneyPerArea = DoubleScalarUtil.instantiateAnonymous(10000.0, unitEURha);
        assertEquals("MoneyPerArea", 1.0, moneyPerArea.si, 0.001d);
        moneyPerArea = DoubleScalarUtil.instantiateAnonymousSI(10.0, unitEURha);
        assertEquals("MoneyPerArea", 10.0, moneyPerArea.si, 0.0001d);
        assertSame("MoneyPerArea", unitEURha, moneyPerArea.getUnit());

        Unit<?> unitUSDJ = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.JOULE, "USD/J", "$/J");
        Unit<?> unitEURKJ = new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.KILOJOULE, "EUR/MWh", "EUR/KJ");
        MoneyPerEnergy moneyPerEnergy = DoubleScalarUtil.instantiateAnonymous(10.0, unitUSDJ);
        assertEquals("MoneyPerEnerg", 10.0, moneyPerEnergy.si, 0.0001d);
        moneyPerEnergy = DoubleScalarUtil.instantiateAnonymous(1000.0, unitEURKJ);
        assertEquals("MoneyPerEnerg", 1.0, moneyPerEnergy.si, 0.001d);
        moneyPerEnergy = DoubleScalarUtil.instantiateAnonymousSI(10.0, unitEURKJ);
        assertEquals("MoneyPerEnerg", 10.0, moneyPerEnergy.si, 0.0001d);
        assertSame("MoneyPerEnerg", unitEURKJ, moneyPerEnergy.getUnit());

    }
}
