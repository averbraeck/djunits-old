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
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-08-19 11:30:26 +0200 (Mon, 19 Aug 2019) $, @version $Revision: 425 $, by $Author: averbraeck $,
 * initial version Jun 5, 2014 <br>
 * @author <a href="https://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class EquivalentDoseUnitTest extends AbstractLinearUnitTest<EquivalentDoseUnit>
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
        assertEquals("m2/s2", EquivalentDoseUnit.SI.getUnitBase().getSiDimensions().toString(true, false));
        checkUnitRatioNameAndAbbreviation(EquivalentDoseUnit.SIEVERT, 1, 0.000001, "sievert", "Sv");
    }

    /**
     * Verify that we can create our own EquivalentDose unit.
     */
    @Test
    public final void createEquivalentDoseUnit()
    {
        EquivalentDoseUnit myUnit = EquivalentDoseUnit.SI.deriveLinear(1.23, "my", "myEquivalentDose", UnitSystem.OTHER);
        assertTrue("Can create a new EquivalentDoseUnit", null != myUnit);
        checkUnitRatioNameAndAbbreviation(myUnit, 1.23, 0.0001, "myEquivalentDose", "my");
        EquivalentDoseUnit.BASE.unregister(myUnit);
    }

}
