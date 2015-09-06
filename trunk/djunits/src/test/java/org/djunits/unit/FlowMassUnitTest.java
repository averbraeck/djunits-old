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
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-26 01:01:13 +0200 (Sun, 26 Jul 2015) $, @version $Revision: 1155 $, by $Author: averbraeck $,
 * initial version Jun 5, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FlowMassUnitTest extends AbstractUnitTest<FlowMassUnit>
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
        checkKeys(FlowMassUnit.KILOGRAM_PER_SECOND, "FlowMassUnit.kilogram_per_second", "FlowMassUnit.kg/s");
    }

    /**
     * Verify conversion factors, English names and abbreviations.
     */
    @Test
    public final void conversions()
    {
        checkUnitRatioNameAndAbbreviation(FlowMassUnit.KILOGRAM_PER_SECOND, 1, 0.000001, "kilogram per second", "kg/s");
        checkUnitRatioNameAndAbbreviation(FlowMassUnit.POUND_PER_SECOND, 0.453592, 0.0001, "pound per second", "lb/s");
        // Check two conversions between non-standard units
        assertEquals("one KILOGRAM PER SECOND is about 2.205 POUND PER SECOND", 2.205, getMultiplicationFactorTo(
            FlowMassUnit.KILOGRAM_PER_SECOND, FlowMassUnit.POUND_PER_SECOND), 0.0005);
        assertEquals("one POUND PER SECOND is about 0.453592 KILOGRAM PER SECOND", 0.453592, getMultiplicationFactorTo(
            FlowMassUnit.POUND_PER_SECOND, FlowMassUnit.KILOGRAM_PER_SECOND), 0.0001);
    }

    /**
     * Verify that we can create our own FlowMass unit.
     */
    @Test
    public final void createFlowMassUnit()
    {
        FlowMassUnit myFMU =
            new FlowMassUnit("WaterDropsPerHour", "wdpu", UnitSystem.OTHER, FlowMassUnit.KILOGRAM_PER_SECOND, 1234);
        assertTrue("Can create a new FlowMassUnit", null != myFMU);
        checkUnitRatioNameAndAbbreviation(myFMU, 1234, 0.0001, "WaterDropsPerHour", "wdpu");
    }

}
