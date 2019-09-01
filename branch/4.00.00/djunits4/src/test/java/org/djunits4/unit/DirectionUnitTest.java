package org.djunits4.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.djunits4.locale.DefaultLocale;
import org.djunits4.unit.unitsystem.UnitSystem;
import org.djunits4.value.AngleUtil;
import org.djunits4.value.vdouble.scalar.DoubleScalar;
import org.djunits4.value.vfloat.scalar.FloatScalar;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-03-02 19:06:46 +0100 (Sat, 02 Mar 2019) $, @version $Revision: 342 $, by $Author: averbraeck $,
 * initial version Jun 4, 2014 <br>
 * @author <a href="https://tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class DirectionUnitTest extends AbstractUnitTest<DirectionUnit>
{
    /**
     * Set the locale to "en" so we know what texts should be retrieved from the resources.
     */
    @Before
    public final void setup()
    {
        DefaultLocale.setLocale(new Locale("en"));
    }

    /**
     * Verify one conversion factor to standard unit and the localization of the name and abbreviation.
     * @param au Unit to check
     * @param expectedValue Double; expected value of one 'unit to check' in SI units
     * @param precision Double; precision of verification
     * @param expectedName String; expected name in the resources
     * @param expectedAbbreviation String; expected abbreviation in the resources
     */
    protected final void checkUnitValueNameAndAbbreviation(final DirectionUnit au, final double expectedValue,
            final double precision, final String expectedName, final String expectedAbbreviation)
    {
        assertEquals("rad", DirectionUnit.DEFAULT.getUnitBase().getSiDimensions().toString(true, false));
        assertEquals(String.format("one %s is about %f reference unit", au.getId(), expectedValue), expectedValue,
                au.getScale().toStandardUnit(1.0), precision);
        assertEquals(String.format("Name of %s is %s", au.getId(), expectedName), expectedName, au.getName());
        assertEquals(String.format("Abbreviation of %s is %s", au.getId(), expectedAbbreviation), expectedAbbreviation,
                au.getDefaultDisplayAbbreviation());
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        checkUnitValueNameAndAbbreviation(DirectionUnit.EAST_RADIAN, 1.0, 0.00001, "radians (East)", "rad(E)");
        checkUnitValueNameAndAbbreviation(DirectionUnit.EAST_DEGREE, Math.PI / 180.0, 0.00001, "degrees (East)", "\u00b0(E)");
        checkUnitValueNameAndAbbreviation(DirectionUnit.NORTH_RADIAN, 1.0 + Math.PI / 2.0, 0.00001, "radians (North)",
                "rad(N)");
        checkUnitValueNameAndAbbreviation(DirectionUnit.NORTH_DEGREE, Math.PI / 2.0 + Math.PI / 180.0, 0.00001,
                "degrees (North)", "\u00b0(N)");
    }

    /**
     * Verify that we can create our own direction unit.
     */
    @Test
    public final void createClockwiseDirectionUnit()
    {
        // clockwise degrees from 0 EAST
        DirectionUnit myAPU = DirectionUnit.EAST_RADIAN.deriveLinearOffset(-Math.PI / 180.0, -0.0, AngleUnit.RADIAN, "cDE",
                "clockDegE", UnitSystem.OTHER);
        assertTrue("Can create a new DirectionUnit", null != myAPU);
        checkUnitValueNameAndAbbreviation(myAPU, -Math.PI / 180.0, 0.0001, "clockDegE", "cDE");
        DirectionUnit.BASE.unregister(myAPU);
    }

    /**
     * Verify that we can create our own direction unit.
     */
    @Test
    public final void createCompassDirectionUnit()
    {
        // clockwise degrees from 0 NORTH (compass)
        DirectionUnit myAPU = DirectionUnit.EAST_RADIAN.deriveLinearOffset(-Math.PI / 180.0, -90.0, AngleUnit.DEGREE, "cDN",
                "compass", UnitSystem.OTHER);
        assertTrue("Can create a new DirectionUnit", null != myAPU);
        checkUnitValueNameAndAbbreviation(myAPU, Math.PI / 2.0 - Math.PI / 180.0, 0.0001, "compass", "cDN");
        DirectionUnit.BASE.unregister(myAPU);
    }

    /**
     * Check normalize for all data types.
     * @param input double; value to normalize
     */
    private void checkDoubleNormalize(final double input)
    {
        double margin = 0.00000000001;
        double expected = input;
        while (expected > 0)
        {
            expected -= 2 * Math.PI;
        }
        while (expected < 0)
        {
            expected += 2 * Math.PI;
        }
        assertEquals("double normalize", expected, AngleUtil.normalize(input), margin);
        DoubleScalar.Abs<DirectionUnit, AngleUnit> dsr = new DoubleScalar.Abs<>(input, DirectionUnit.EAST_RADIAN);
        assertEquals("DoubleScalar.Abs normalize", expected, AngleUtil.normalize(dsr).getSI(), margin);
    }

    /**
     * Check normalize for all data types.
     * @param input double; value to normalize
     */
    private void checkFloatNormalize(final float input)
    {
        double margin = 0.00001;
        float expected = input;
        while (expected > 0)
        {
            expected -= 2 * Math.PI;
        }
        while (expected < 0)
        {
            expected += 2 * Math.PI;
        }
        assertEquals("float normalize", expected, AngleUtil.normalize(input), margin);
        FloatScalar.Abs<DirectionUnit, AngleUnit> dsr = new FloatScalar.Abs<>(input, DirectionUnit.EAST_RADIAN);
        assertEquals("FloatScalar.Abs normalize", expected, AngleUtil.normalize(dsr).getSI(), margin);
    }

    /**
     * Verify that the normalizations work as intended.
     */
    @Test
    public final void normalizations()
    {
        for (int i = -100; i <= 100; i++)
        {
            double doubleValue = i * Math.PI / 10;
            checkDoubleNormalize(doubleValue - i * Math.ulp(doubleValue));
            checkDoubleNormalize(doubleValue + i * Math.ulp(doubleValue));
            float floatValue = (float) (i * Math.PI / 10);
            checkFloatNormalize(floatValue - i * Math.ulp(floatValue));
            checkFloatNormalize(floatValue + i * Math.ulp(floatValue));
        }
    }
    
    /**
     * Verify relative base unit.
     */
    @Test
    public final void testRelative()
    {
        assertEquals(AngleUnit.BASE, DirectionUnit.DEFAULT.getRelativeUnitBase());
    }

}
