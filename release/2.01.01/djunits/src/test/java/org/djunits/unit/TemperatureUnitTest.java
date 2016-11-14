package org.djunits.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.djunits.locale.DefaultLocale;
import org.djunits.unit.unitsystem.UnitSystem;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Jun 6, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class TemperatureUnitTest extends AbstractOffsetUnitTest<TemperatureUnit>
{
    /**
     * Set the locale to "en" so we know what texts should be retrieved from the resources.
     */
    @SuppressWarnings("static-method")
    @Before
    public final void setup()
    {
        DefaultLocale.setLocale(new Locale("en"));
    }

    /**
     * Verify the result of some get*Key methods.
     */
    @Test
    public final void keys()
    {
        checkKeys(TemperatureUnit.KELVIN, "TemperatureUnit.kelvin", "TemperatureUnit.K");
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        checkUnitRatioOffsetNameAndAbbreviation(TemperatureUnit.KELVIN, 1, 0, 0.00000001, "kelvin", "K");
        checkUnitRatioOffsetNameAndAbbreviation(TemperatureUnit.DEGREE_CELSIUS, 1, 273.15, 0.000001, "degree Celsius",
            "\u00B0C");
        checkUnitRatioOffsetNameAndAbbreviation(TemperatureUnit.DEGREE_FAHRENHEIT, 5. / 9., 459.67, 0.00001,
            "degree Fahrenheit", "\u00B0F");
        // Check two conversions between non-standard units
        assertEquals("one DEGREE CELSIUS is 9/5 DEGREE FAHRENHEIT", 9. / 5., getMultiplicationFactorTo(
            TemperatureUnit.DEGREE_CELSIUS, TemperatureUnit.DEGREE_FAHRENHEIT), 0.0001);
        assertEquals("zero DEGREE CELSIUS is 32 DEGREE FAHRENHEIT", 32, TemperatureUnit.DEGREE_FAHRENHEIT.getScale()
            .fromStandardUnit(TemperatureUnit.DEGREE_CELSIUS.getScale().toStandardUnit(0.0)), 0.0001);
        assertEquals("100 DEGREE CELSIUS is 212 DEGREE FAHRENHEIT", 212, TemperatureUnit.DEGREE_FAHRENHEIT.getScale()
            .fromStandardUnit(TemperatureUnit.DEGREE_CELSIUS.getScale().toStandardUnit(100.0)), 0.0001);
        assertEquals("zero DEGREE FAHRENHEIT is about -17.7778 DEGREE CELSIUS", -17.7778,
            TemperatureUnit.DEGREE_CELSIUS.getScale().fromStandardUnit(
                TemperatureUnit.DEGREE_FAHRENHEIT.getScale().toStandardUnit(0.0)), 0.0001);
        checkUnitRatioOffsetNameAndAbbreviation(TemperatureUnit.DEGREE_RANKINE, 5. / 9., 0, 0.0001, "degree Rankine",
            "\u00B0R");
        checkUnitRatioOffsetNameAndAbbreviation(TemperatureUnit.DEGREE_REAUMUR, 0.8, 273.15, 0.000001,
            "degree Reaumur", "\u00B0R\u00E9");
    }

    /**
     * Verify that we can create our own temperature unit; i.c. Newton.
     */
    @Test
    public final void createTemperatureUnit()
    {
        TemperatureUnit myTU = new TemperatureUnit("Newton", "N", UnitSystem.OTHER, 3.0, 273.15);
        assertTrue("Can create a new TemperatureUnit", null != myTU);
        checkUnitRatioOffsetNameAndAbbreviation(myTU, 3, 273.15, 0.0001, "Newton", "N");
    }

}
