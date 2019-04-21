package org.djunits.value.vfloat.scalar;

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
public class FloatScalarUtilTest
{
    /**
     * Test the instantiation utility function of classes.
     */
    @Test
    public final void instantiateTest()
    {
        FloatDimensionless dimensionless = FloatScalarUtil.instantiate(10.0f, DimensionlessUnit.SI);
        assertEquals("Dimensionless", 10.0f, dimensionless.si, 0.001d);
        dimensionless = FloatScalarUtil.instantiateSI(10.0f, DimensionlessUnit.SI);
        assertEquals("Dimensionless", 10.0f, dimensionless.si, 0.001d);
        assertSame("Dimensionless", DimensionlessUnit.SI, dimensionless.getUnit());

        FloatAcceleration acceleration = FloatScalarUtil.instantiate(10.0f, AccelerationUnit.SI);
        assertEquals("Acceleration", 10.0f, acceleration.si, 0.001d);
        acceleration = FloatScalarUtil.instantiate(12960.0f, AccelerationUnit.KM_PER_HOUR_2);
        assertEquals("Acceleration", 1.0, acceleration.si, 0.001d);
        acceleration = FloatScalarUtil.instantiateSI(10.0f, AccelerationUnit.KM_PER_HOUR_2);
        assertEquals("Acceleration", 10.0f, acceleration.si, 0.001d);
        assertSame("Acceleration", AccelerationUnit.KM_PER_HOUR_2, acceleration.getUnit());

        FloatAngleSolid angleSolid = FloatScalarUtil.instantiate(10.0f, AngleSolidUnit.SI);
        assertEquals("AngleSolid", 10.0f, angleSolid.si, 0.001d);
        angleSolid = FloatScalarUtil.instantiate(1.0f, AngleSolidUnit.SQUARE_DEGREE);
        assertEquals("AngleSolid", (Math.PI / 180.0) * (Math.PI / 180.0), angleSolid.si, 0.001d);
        angleSolid = FloatScalarUtil.instantiateSI(10.0f, AngleSolidUnit.SQUARE_DEGREE);
        assertEquals("AngleSolid", 10.0f, angleSolid.si, 0.001d);
        assertSame("AngleSolid", AngleSolidUnit.SQUARE_DEGREE, angleSolid.getUnit());

        FloatAngle angle = FloatScalarUtil.instantiate(10.0f, AngleUnit.SI);
        assertEquals("Angle", 10.0f, angle.si, 0.001d);
        angle = FloatScalarUtil.instantiate(1.0f, AngleUnit.DEGREE);
        assertEquals("Angle", Math.PI / 180.0, angle.si, 0.001d);
        angle = FloatScalarUtil.instantiateSI(10.0f, AngleUnit.DEGREE);
        assertEquals("Angle", 10.0f, angle.si, 0.001d);
        assertSame("Angle", AngleUnit.DEGREE, angle.getUnit());

        FloatDirection direction = FloatScalarUtil.instantiate(10.0f, DirectionUnit.BASE);
        assertEquals("Direction", 10.0f, direction.si, 0.001d);
        direction = FloatScalarUtil.instantiate(1.0f, DirectionUnit.EAST_DEGREE);
        assertEquals("Direction", Math.PI / 180.0, direction.si, 0.001d);
        direction = FloatScalarUtil.instantiateSI(10.0f, DirectionUnit.EAST_DEGREE);
        assertEquals("Direction", 10.0f, direction.si, 0.001d);
        assertSame("Direction", DirectionUnit.EAST_DEGREE, direction.getUnit());

        FloatArea area = FloatScalarUtil.instantiate(10.0f, AreaUnit.SI);
        assertEquals("Area", 10.0f, area.si, 0.001d);
        area = FloatScalarUtil.instantiate(1.0f, AreaUnit.HECTARE);
        assertEquals("Area", 10000.0, area.si, 0.001d);
        area = FloatScalarUtil.instantiateSI(10.0f, AreaUnit.HECTARE);
        assertEquals("Area", 10.0f, area.si, 0.001d);
        assertSame("Area", AreaUnit.HECTARE, area.getUnit());

        // TODO: other base units

        FloatMoney money = FloatScalarUtil.instantiate(10.0f, MoneyUnit.USD);
        assertEquals("Money", 10.0f, money.si, 0.001d);
        money = FloatScalarUtil.instantiate(100.0f, MoneyUnit.EUR);
        assertEquals("Money", 100.0, money.si, 0.001d);
        money = FloatScalarUtil.instantiateSI(10.0f, MoneyUnit.EUR);
        assertEquals("Money", 10.0f, money.si, 0.001d);
        assertSame("Money", MoneyUnit.EUR, money.getUnit());

        MoneyPerAreaUnit unitUSDm2 = new MoneyPerAreaUnit(MoneyUnit.USD, AreaUnit.SQUARE_METER, "USD/m2", "$/m2");
        MoneyPerAreaUnit unitEURha = new MoneyPerAreaUnit(MoneyUnit.EUR, AreaUnit.HECTARE, "EUR/ha", "EUR/ha");
        FloatMoneyPerArea moneyPerArea = FloatScalarUtil.instantiate(10.0f, unitUSDm2);
        assertEquals("MoneyPerArea", 10.0f, moneyPerArea.si, 0.001d);
        moneyPerArea = FloatScalarUtil.instantiate(10000.0f, unitEURha);
        assertEquals("MoneyPerArea", 1.0, moneyPerArea.si, 0.001d);
        moneyPerArea = FloatScalarUtil.instantiateSI(10.0f, unitEURha);
        assertEquals("MoneyPerArea", 10.0f, moneyPerArea.si, 0.001d);
        assertSame("MoneyPerArea", unitEURha, moneyPerArea.getUnit());

        MoneyPerEnergyUnit unitUSDJ = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.JOULE, "USD/J", "$/J");
        MoneyPerEnergyUnit unitEURKJ = new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.KILOJOULE, "EUR/MWh", "EUR/KJ");
        FloatMoneyPerEnergy moneyPerEnergy = FloatScalarUtil.instantiate(10.0f, unitUSDJ);
        assertEquals("MoneyPerEnerg", 10.0f, moneyPerEnergy.si, 0.001d);
        moneyPerEnergy = FloatScalarUtil.instantiate(1000.0f, unitEURKJ);
        assertEquals("MoneyPerEnerg", 1.0, moneyPerEnergy.si, 0.001d);
        moneyPerEnergy = FloatScalarUtil.instantiateSI(10.0f, unitEURKJ);
        assertEquals("MoneyPerEnerg", 10.0f, moneyPerEnergy.si, 0.001d);
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
        FloatLength length = FloatScalarUtil.instantiateAnonymous(10.0f, unitSI);
        assertEquals("Length", 10.0f, length.si, 0.001d);
        length = FloatScalarUtil.instantiateAnonymous(1.0f, unitKM);
        assertEquals("Length", 1000.0, length.si, 0.001d);
        length = FloatScalarUtil.instantiateAnonymousSI(10.0f, unitKM);
        assertEquals("Length", 10.0f, length.si, 0.001d);
        assertSame("Length", unitKM, length.getUnit());

        // TODO: other base units

        Unit<?> unitUSD = MoneyUnit.USD;
        Unit<?> unitEUR = MoneyUnit.EUR;
        FloatMoney money = FloatScalarUtil.instantiateAnonymous(10.0f, unitUSD);
        assertEquals("Money", 10.0f, money.si, 0.001d);
        money = FloatScalarUtil.instantiateAnonymous(100.0f, unitEUR);
        assertEquals("Money", 100.0, money.si, 0.001d);
        money = FloatScalarUtil.instantiateAnonymousSI(10.0f, unitEUR);
        assertEquals("Money", 10.0f, money.si, 0.001d);
        assertSame("Money", unitEUR, money.getUnit());

        Unit<?> unitUSDm2 = new MoneyPerAreaUnit(MoneyUnit.USD, AreaUnit.SQUARE_METER, "USD/m2", "$/m2");
        Unit<?> unitEURha = new MoneyPerAreaUnit(MoneyUnit.EUR, AreaUnit.HECTARE, "EUR/ha", "EUR/ha");
        FloatMoneyPerArea moneyPerArea = FloatScalarUtil.instantiateAnonymous(10.0f, unitUSDm2);
        assertEquals("MoneyPerArea", 10.0f, moneyPerArea.si, 0.001d);
        moneyPerArea = FloatScalarUtil.instantiateAnonymous(10000.0f, unitEURha);
        assertEquals("MoneyPerArea", 1.0, moneyPerArea.si, 0.001d);
        moneyPerArea = FloatScalarUtil.instantiateAnonymousSI(10.0f, unitEURha);
        assertEquals("MoneyPerArea", 10.0f, moneyPerArea.si, 0.001d);
        assertSame("MoneyPerArea", unitEURha, moneyPerArea.getUnit());

        Unit<?> unitUSDJ = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.JOULE, "USD/J", "$/J");
        Unit<?> unitEURKJ = new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.KILOJOULE, "EUR/MWh", "EUR/KJ");
        FloatMoneyPerEnergy moneyPerEnergy = FloatScalarUtil.instantiateAnonymous(10.0f, unitUSDJ);
        assertEquals("MoneyPerEnerg", 10.0f, moneyPerEnergy.si, 0.001d);
        moneyPerEnergy = FloatScalarUtil.instantiateAnonymous(1000.0f, unitEURKJ);
        assertEquals("MoneyPerEnerg", 1.0, moneyPerEnergy.si, 0.001d);
        moneyPerEnergy = FloatScalarUtil.instantiateAnonymousSI(10.0f, unitEURKJ);
        assertEquals("MoneyPerEnerg", 10.0f, moneyPerEnergy.si, 0.001d);
        assertSame("MoneyPerEnerg", unitEURKJ, moneyPerEnergy.getUnit());

    }
}
