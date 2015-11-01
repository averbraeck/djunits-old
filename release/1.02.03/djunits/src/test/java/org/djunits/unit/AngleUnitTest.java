package org.djunits.unit;

import static org.djunits.unit.unitsystem.UnitSystem.OTHER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.djunits.locale.DefaultLocale;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vfloat.scalar.FloatScalar;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Jun 4, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AngleUnitTest extends AbstractUnitTest<AngleUnit>
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
        checkKeys(AngleUnit.RADIAN, "AngleUnit.radian", "AngleUnit.rad");
    }

    /**
     * Verify one length conversion factor to standard unit and the localization of the name and abbreviation.
     * @param au Unit to check
     * @param expectedValue Double; expected value of one 'unit to check' in SI units
     * @param precision Double; precision of verification
     * @param expectedName String; expected name in the resources
     * @param expectedAbbreviation String; expected abbreviation in the resources
     */
    protected final void checkUnitValueNameAndAbbreviation(final AngleUnit au, final double expectedValue,
        final double precision, final String expectedName,
        final String expectedAbbreviation)
    {
        assertEquals(String.format("one %s is about %f reference unit", au.getNameKey(), expectedValue), expectedValue,
            au.getScale().toStandardUnit(1.0), precision);
        assertEquals(String.format("Name of %s is %s", au.getNameKey(), expectedName), expectedName, au.getName());
        assertEquals(String.format("Abbreviation of %s is %s", au.getNameKey(), expectedAbbreviation),
            expectedAbbreviation, au.getAbbreviation());
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        checkUnitValueNameAndAbbreviation(AngleUnit.DEGREE, 2 * Math.PI / 360, 0.000001, "degree", "\u00b0");
        checkUnitValueNameAndAbbreviation(AngleUnit.ARCMINUTE, 2 * Math.PI / 360 / 60, 0.0001, "arcminute", "\'");
        checkUnitValueNameAndAbbreviation(AngleUnit.GRAD, 2 * Math.PI / 400, 0.00001, "gradian", "grad");
        // TODO Check two conversions between non-standard Angle units
        // assertEquals("one GRAD is about 54 ARCMINUTE", 54, getMultiplicationFactorTo(AngleUnit.GRAD,
        // AngleUnit.ARCMINUTE), 0.5);
        // assertEquals("one ARCMINUTE is about 0.0185 GRAD", 0.0185, getMultiplicationFactorTo(AngleUnit.ARCMINUTE,
        // AngleUnit.GRAD), 0.0001);
        // Check conversion factor to standard unit for all remaining time units
        checkUnitValueNameAndAbbreviation(AngleUnit.CENTESIMAL_ARCMINUTE, 0.00015708, 0.0000001,
            "centesimal arcminute", "\'");
        checkUnitValueNameAndAbbreviation(AngleUnit.CENTESIMAL_ARCSECOND, 1.57079e-6, 0.1, "centesimal arcsecond",
            "\"");
        checkUnitValueNameAndAbbreviation(AngleUnit.PERCENT, 0.0099996667, 0.0001, "percent",
                "%");
    }

    /**
     * Verify that we can create our own angle unit.
     */
    @Test
    public final void createAngleUnit()
    {
        AngleUnit myAPU = new AngleUnit("point", "pt", OTHER, AngleUnit.RADIAN, 0.19634954085);
        assertTrue("Can create a new AngleUnit", null != myAPU);
        checkUnitValueNameAndAbbreviation(myAPU, 0.19634954085, 0.0000001, "point", "pt");
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
        assertEquals("double normalize", expected, AngleUnit.normalize(input), margin);
        DoubleScalar.Abs<AngleUnit> dsa = new DoubleScalar.Abs<AngleUnit>(input, AngleUnit.SI);
        assertEquals("DoubleScalar.Abs normalize", expected, AngleUnit.normalize(dsa).getSI(), margin);
        DoubleScalar.Rel<AngleUnit> dsr = new DoubleScalar.Rel<AngleUnit>(input, AngleUnit.SI);
        assertEquals("DoubleScalar.Rel normalize", expected, AngleUnit.normalize(dsr).getSI(), margin);
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
        assertEquals("float normalize", expected, AngleUnit.normalize(input), margin);
        FloatScalar.Abs<AngleUnit> fsa = new FloatScalar.Abs<AngleUnit>(input, AngleUnit.SI);
        assertEquals("FloatScalar.Abs normalize", expected, AngleUnit.normalize(fsa).getSI(), margin);
        FloatScalar.Rel<AngleUnit> fsr = new FloatScalar.Rel<AngleUnit>(input, AngleUnit.SI);
        assertEquals("FloatScalar.Rek normalize", expected, AngleUnit.normalize(fsr).getSI(), margin);
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

}
