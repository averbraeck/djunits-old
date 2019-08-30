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
 * initial version Jun 5, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class DensityUnitTest extends AbstractLinearUnitTest<DensityUnit>
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
        checkUnitRatioNameAndAbbreviation(DensityUnit.KG_PER_METER_3, 1, 0.00000001, "kilogram per cubic meter", "kg/m^3");
        checkUnitRatioNameAndAbbreviation(DensityUnit.GRAM_PER_CENTIMETER_3, 1000, 0.0001, "gram per cubic centimeter",
                "g/cm^3");
        // Check two conversions between two units
        assertEquals("one KG PER CUBIC METER is 0.0001 GRAM PER CUBIC CENTIMETER", 0.001,
                getMultiplicationFactorTo(DensityUnit.KG_PER_METER_3, DensityUnit.GRAM_PER_CENTIMETER_3), 0.000000001);
    }

    /**
     * Verify that we can create our own density unit.
     */
    @Test
    public final void createDensityUnit()
    {
        DensityUnit myDU = DensityUnit.KG_PER_METER_3.deriveLinear(515.317882, "SPCF", "DensityUnit", UnitSystem.SI_DERIVED);
        assertTrue("Can create a new DensityUnit", null != myDU);
        checkUnitRatioNameAndAbbreviation(myDU, 515.3, 0.1, "DensityUnit", "SPCF");
        DensityUnit.BASE.unregister(myDU);
    }

}
