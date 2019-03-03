package org.djunits.value.vdouble.vector;

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
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
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
public class DoubleVectorUtilTest
{
    /**
     * Test the instantiation utility function of classes.
     * @throws ValueException on instantiation error
     */
    @Test
    public final void instantiateTest() throws ValueException
    {
        double[] a12 = new double[] { 1.0, 2.0 };
        double[] a1020 = new double[] { 10.0, 20.0 };
        double[] a12h = new double[] { 100.0, 200.0 };
        double[] a12k = new double[] { 1000.0, 2000.0 };
        double[] a12k10 = new double[] { 10000.0, 20000.0 };

        DimensionlessVector dimensionless = DoubleVectorUtil.instantiate(a1020, DimensionlessUnit.SI, StorageType.DENSE);
        assertEquals("Dimensionless", 10.0, dimensionless.getSI(0), 0.0001d);
        dimensionless = DoubleVectorUtil.instantiateSI(a1020, DimensionlessUnit.SI, StorageType.DENSE);
        assertEquals("Dimensionless", 10.0, dimensionless.getSI(0), 0.0001d);
        assertSame("Dimensionless", DimensionlessUnit.SI, dimensionless.getUnit());

        AccelerationVector acceleration = DoubleVectorUtil.instantiate(a1020, AccelerationUnit.SI, StorageType.DENSE);
        assertEquals("Acceleration", 10.0, acceleration.getSI(0), 0.0001d);
        acceleration =
                DoubleVectorUtil.instantiate(new double[] { 12960.0, 10.0 }, AccelerationUnit.KM_PER_HOUR_2, StorageType.DENSE);
        assertEquals("Acceleration", 1.0, acceleration.getSI(0), 0.001d);
        acceleration = DoubleVectorUtil.instantiateSI(a1020, AccelerationUnit.KM_PER_HOUR_2, StorageType.DENSE);
        assertEquals("Acceleration", 10.0, acceleration.getSI(0), 0.0001d);
        assertSame("Acceleration", AccelerationUnit.KM_PER_HOUR_2, acceleration.getUnit());

        AngleSolidVector angleSolid = DoubleVectorUtil.instantiate(a1020, AngleSolidUnit.SI, StorageType.DENSE);
        assertEquals("AngleSolid", 10.0, angleSolid.getSI(0), 0.0001d);
        angleSolid = DoubleVectorUtil.instantiate(a12, AngleSolidUnit.SQUARE_DEGREE, StorageType.DENSE);
        assertEquals("AngleSolid", (Math.PI / 180.0) * (Math.PI / 180.0), angleSolid.getSI(0), 0.001d);
        angleSolid = DoubleVectorUtil.instantiateSI(a1020, AngleSolidUnit.SQUARE_DEGREE, StorageType.DENSE);
        assertEquals("AngleSolid", 10.0, angleSolid.getSI(0), 0.0001d);
        assertSame("AngleSolid", AngleSolidUnit.SQUARE_DEGREE, angleSolid.getUnit());

        AngleVector angle = DoubleVectorUtil.instantiate(a1020, AngleUnit.SI, StorageType.DENSE);
        assertEquals("Angle", 10.0, angle.getSI(0), 0.0001d);
        angle = DoubleVectorUtil.instantiate(a12, AngleUnit.DEGREE, StorageType.DENSE);
        assertEquals("Angle", Math.PI / 180.0, angle.getSI(0), 0.001d);
        angle = DoubleVectorUtil.instantiateSI(a1020, AngleUnit.DEGREE, StorageType.DENSE);
        assertEquals("Angle", 10.0, angle.getSI(0), 0.0001d);
        assertSame("Angle", AngleUnit.DEGREE, angle.getUnit());

        DirectionVector direction = DoubleVectorUtil.instantiate(a1020, DirectionUnit.BASE, StorageType.DENSE);
        assertEquals("Direction", 10.0, direction.getSI(0), 0.0001d);
        direction = DoubleVectorUtil.instantiate(a12, DirectionUnit.NORTH_DEGREE, StorageType.DENSE);
        assertEquals("Direction", Math.PI / 180.0, direction.getSI(0), 0.001d);
        direction = DoubleVectorUtil.instantiateSI(a1020, DirectionUnit.NORTH_DEGREE, StorageType.DENSE);
        assertEquals("Direction", 10.0, direction.getSI(0), 0.0001d);
        assertSame("Direction", DirectionUnit.NORTH_DEGREE, direction.getUnit());

        AreaVector area = DoubleVectorUtil.instantiate(a1020, AreaUnit.SI, StorageType.DENSE);
        assertEquals("Area", 10.0, area.getSI(0), 0.0001d);
        area = DoubleVectorUtil.instantiate(a12, AreaUnit.HECTARE, StorageType.DENSE);
        assertEquals("Area", 10000.0, area.getSI(0), 0.001d);
        area = DoubleVectorUtil.instantiateSI(a1020, AreaUnit.HECTARE, StorageType.DENSE);
        assertEquals("Area", 10.0, area.getSI(0), 0.0001d);
        assertSame("Area", AreaUnit.HECTARE, area.getUnit());

        // TODO: other base units

        MoneyVector money = DoubleVectorUtil.instantiate(a1020, MoneyUnit.USD, StorageType.DENSE);
        assertEquals("Money", 10.0, money.getSI(0), 0.0001d);
        money = DoubleVectorUtil.instantiate(a12h, MoneyUnit.EUR, StorageType.DENSE);
        assertEquals("Money", 100.0, money.getSI(0), 0.001d);
        money = DoubleVectorUtil.instantiateSI(a1020, MoneyUnit.EUR, StorageType.DENSE);
        assertEquals("Money", 10.0, money.getSI(0), 0.0001d);
        assertSame("Money", MoneyUnit.EUR, money.getUnit());

        MoneyPerAreaUnit unitUSDm2 = new MoneyPerAreaUnit(MoneyUnit.USD, AreaUnit.SQUARE_METER, "USD/m2", "$/m2");
        MoneyPerAreaUnit unitEURha = new MoneyPerAreaUnit(MoneyUnit.EUR, AreaUnit.HECTARE, "EUR/ha", "EUR/ha");
        MoneyPerAreaVector moneyPerArea = DoubleVectorUtil.instantiate(a1020, unitUSDm2, StorageType.DENSE);
        assertEquals("MoneyPerArea", 10.0, moneyPerArea.getSI(0), 0.0001d);
        moneyPerArea = DoubleVectorUtil.instantiate(a12k10, unitEURha, StorageType.DENSE);
        assertEquals("MoneyPerArea", 1.0, moneyPerArea.getSI(0), 0.001d);
        moneyPerArea = DoubleVectorUtil.instantiateSI(a1020, unitEURha, StorageType.DENSE);
        assertEquals("MoneyPerArea", 10.0, moneyPerArea.getSI(0), 0.0001d);
        assertSame("MoneyPerArea", unitEURha, moneyPerArea.getUnit());

        MoneyPerEnergyUnit unitUSDJ = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.JOULE, "USD/J", "$/J");
        MoneyPerEnergyUnit unitEURKJ = new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.KILOJOULE, "EUR/MWh", "EUR/KJ");
        MoneyPerEnergyVector moneyPerEnergy = DoubleVectorUtil.instantiate(a1020, unitUSDJ, StorageType.DENSE);
        assertEquals("MoneyPerEnerg", 10.0, moneyPerEnergy.getSI(0), 0.0001d);
        moneyPerEnergy = DoubleVectorUtil.instantiate(a12k, unitEURKJ, StorageType.DENSE);
        assertEquals("MoneyPerEnerg", 1.0, moneyPerEnergy.getSI(0), 0.001d);
        moneyPerEnergy = DoubleVectorUtil.instantiateSI(a1020, unitEURKJ, StorageType.DENSE);
        assertEquals("MoneyPerEnerg", 10.0, moneyPerEnergy.getSI(0), 0.0001d);
        assertSame("MoneyPerEnerg", unitEURKJ, moneyPerEnergy.getUnit());

    }

    /**
     * Test the instantiation utility function of classes for anonymous units, also for the compiler.
     * @throws ValueException on instantiation error
     */
    @Test
    public final void anonymousUnitTest() throws ValueException
    {
        double[] a12 = new double[] { 1.0, 2.0 };
        double[] a1020 = new double[] { 10.0, 20.0 };
        double[] a12h = new double[] { 100.0, 200.0 };
        double[] a12k = new double[] { 1000.0, 2000.0 };
        double[] a12k10 = new double[] { 10000.0, 20000.0 };

        Unit<?> unitSI = LengthUnit.SI;
        Unit<?> unitKM = LengthUnit.KILOMETER;
        LengthVector length = DoubleVectorUtil.instantiateAnonymous(a1020, unitSI, StorageType.DENSE);
        assertEquals("Length", 10.0, length.getSI(0), 0.0001d);
        length = DoubleVectorUtil.instantiateAnonymous(a12, unitKM, StorageType.DENSE);
        assertEquals("Length", 1000.0, length.getSI(0), 0.001d);
        length = DoubleVectorUtil.instantiateAnonymousSI(a1020, unitKM, StorageType.DENSE);
        assertEquals("Length", 10.0, length.getSI(0), 0.0001d);
        assertSame("Length", unitKM, length.getUnit());

        // TODO: other base units

        Unit<?> unitUSD = MoneyUnit.USD;
        Unit<?> unitEUR = MoneyUnit.EUR;
        MoneyVector money = DoubleVectorUtil.instantiateAnonymous(a1020, unitUSD, StorageType.DENSE);
        assertEquals("Money", 10.0, money.getSI(0), 0.0001d);
        money = DoubleVectorUtil.instantiateAnonymous(a12h, unitEUR, StorageType.DENSE);
        assertEquals("Money", 100.0, money.getSI(0), 0.001d);
        money = DoubleVectorUtil.instantiateAnonymousSI(a1020, unitEUR, StorageType.DENSE);
        assertEquals("Money", 10.0, money.getSI(0), 0.0001d);
        assertSame("Money", unitEUR, money.getUnit());

        Unit<?> unitUSDm2 = new MoneyPerAreaUnit(MoneyUnit.USD, AreaUnit.SQUARE_METER, "USD/m2", "$/m2");
        Unit<?> unitEURha = new MoneyPerAreaUnit(MoneyUnit.EUR, AreaUnit.HECTARE, "EUR/ha", "EUR/ha");
        MoneyPerAreaVector moneyPerArea = DoubleVectorUtil.instantiateAnonymous(a1020, unitUSDm2, StorageType.DENSE);
        assertEquals("MoneyPerArea", 10.0, moneyPerArea.getSI(0), 0.0001d);
        moneyPerArea = DoubleVectorUtil.instantiateAnonymous(a12k10, unitEURha, StorageType.DENSE);
        assertEquals("MoneyPerArea", 1.0, moneyPerArea.getSI(0), 0.001d);
        moneyPerArea = DoubleVectorUtil.instantiateAnonymousSI(a1020, unitEURha, StorageType.DENSE);
        assertEquals("MoneyPerArea", 10.0, moneyPerArea.getSI(0), 0.0001d);
        assertSame("MoneyPerArea", unitEURha, moneyPerArea.getUnit());

        Unit<?> unitUSDJ = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.JOULE, "USD/J", "$/J");
        Unit<?> unitEURKJ = new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.KILOJOULE, "EUR/MWh", "EUR/KJ");
        MoneyPerEnergyVector moneyPerEnergy = DoubleVectorUtil.instantiateAnonymous(a1020, unitUSDJ, StorageType.DENSE);
        assertEquals("MoneyPerEnerg", 10.0, moneyPerEnergy.getSI(0), 0.0001d);
        moneyPerEnergy = DoubleVectorUtil.instantiateAnonymous(a12k, unitEURKJ, StorageType.DENSE);
        assertEquals("MoneyPerEnerg", 1.0, moneyPerEnergy.getSI(0), 0.001d);
        moneyPerEnergy = DoubleVectorUtil.instantiateAnonymousSI(a1020, unitEURKJ, StorageType.DENSE);
        assertEquals("MoneyPerEnerg", 10.0, moneyPerEnergy.getSI(0), 0.0001d);
        assertSame("MoneyPerEnerg", unitEURKJ, moneyPerEnergy.getUnit());

    }
}
