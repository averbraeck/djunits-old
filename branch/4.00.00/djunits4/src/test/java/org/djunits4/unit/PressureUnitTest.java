package org.djunits4.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.djunits4.locale.DefaultLocale;
import org.djunits4.unit.unitsystem.UnitSystem;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-08-19 11:30:26 +0200 (Mon, 19 Aug 2019) $, @version $Revision: 425 $, by $Author: averbraeck $,
 * initial version Jun 6, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class PressureUnitTest extends AbstractLinearUnitTest<PressureUnit>
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
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        assertEquals("kg/ms2", PressureUnit.SI.getUnitBase().getSiDimensions().toString(true, false));
        checkUnitRatioNameAndAbbreviation(PressureUnit.PASCAL, 1, 0.00000001, "pascal", "Pa");
        checkUnitRatioNameAndAbbreviation(PressureUnit.ATMOSPHERE_STANDARD, 101325, 0.5, "atmosphere (standard)", "atm");
        checkUnitRatioNameAndAbbreviation(PressureUnit.ATMOSPHERE_TECHNICAL, 98066.5, 0.1, "atmosphere (technical)", "at");
        // Check two conversions between non-standard units
        assertEquals("one ATMOSPHERE STANDARD is about 1.03327 ATMOSPHERE TECHNICAL", 1 / 0.9678,
                getMultiplicationFactorTo(PressureUnit.ATMOSPHERE_STANDARD, PressureUnit.ATMOSPHERE_TECHNICAL), 0.0001);
        assertEquals("one ATMOSPHERE TECHNICAL is 0.9678 ATMOSPHERE STANDARD", 0.9678,
                getMultiplicationFactorTo(PressureUnit.ATMOSPHERE_TECHNICAL, PressureUnit.ATMOSPHERE_STANDARD), 0.0001);
        // Check conversion factor to standard unit for all remaining time units
        checkUnitRatioNameAndAbbreviation(PressureUnit.HECTOPASCAL, 100, 0.0001, "hectopascal", "hPa");
        checkUnitRatioNameAndAbbreviation(PressureUnit.KILOPASCAL, 1000, 0.001, "kilopascal", "kPa");
        checkUnitRatioNameAndAbbreviation(PressureUnit.BAR, 100000, 0.01, "bar", "bar");
        checkUnitRatioNameAndAbbreviation(PressureUnit.MILLIBAR, 100, 0.000001, "millibar", "mbar");
        checkUnitRatioNameAndAbbreviation(PressureUnit.CENTIMETER_MERCURY, 1333.22368, 0.001, "centimeter mercury", "cmHg");
        checkUnitRatioNameAndAbbreviation(PressureUnit.MILLIMETER_MERCURY, 133.322368, 0.001, "millimeter mercury", "mmHg");
        checkUnitRatioNameAndAbbreviation(PressureUnit.FOOT_MERCURY, 40636.66, 0.01, "foot mercury", "ftHg");
        checkUnitRatioNameAndAbbreviation(PressureUnit.INCH_MERCURY, 3386, 0.5, "inch mercury", "inHg");
        checkUnitRatioNameAndAbbreviation(PressureUnit.KGF_PER_SQUARE_MM, 9806650, 0.5, "kilogram-force per square millimeter",
                "kgf/mm^2");
        checkUnitRatioNameAndAbbreviation(PressureUnit.POUND_PER_SQUARE_FOOT, 47.880259, 0.000001,
                "pound-force per square foot", "lbf/ft^2");
        checkUnitRatioNameAndAbbreviation(PressureUnit.POUND_PER_SQUARE_INCH, 6894.75729, 0.00001,
                "pound-force per square inch", "lbf/in^2");
    }

    /**
     * Verify that we can create our own pressure unit.
     */
    @Test
    public final void createPressureUnit()
    {
        PressureUnit myPU = PressureUnit.MILLIMETER_MERCURY.deriveLinear(106, "hhhp", "HealthyHumanHeart", UnitSystem.OTHER);
        assertTrue("Can create a new PowerUnit", null != myPU);
        checkUnitRatioNameAndAbbreviation(myPU, 14132.1711, 0.01, "HealthyHumanHeart", "hhhp");
        PressureUnit.BASE.unregister(myPU);
    }

}
