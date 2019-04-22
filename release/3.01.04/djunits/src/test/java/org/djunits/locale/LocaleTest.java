package org.djunits.locale;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.djunits.unit.DurationUnit;
import org.junit.Test;

/**
 * LocaleTest.java. <br>
 * <br>
 * Copyright (c) 2003-2018 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://www.simulation.tudelft.nl/" target="_blank">www.simulation.tudelft.nl</a>. The
 * source code and binary code of this software is proprietary information of Delft University of Technology.
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class LocaleTest
{
    /**
     * Verify the result of localization. The defaults should stay in English, while the 'normal' abbreviations and names should
     * be translated.
     */
    @Test
    public final void testLocalization()
    {
        DefaultLocale.setLocale(new Locale("en"));
        assertEquals("h", DurationUnit.HOUR.getAbbreviation());
        assertEquals("h", DurationUnit.HOUR.getDefaultLocaleAbbreviation());
        assertEquals("hour", DurationUnit.HOUR.getName());
        assertEquals("hour", DurationUnit.HOUR.getDefaultLocaleName());

        DefaultLocale.setLocale(new Locale("nl"));
        assertEquals("u", DurationUnit.HOUR.getAbbreviation());
        assertEquals("h", DurationUnit.HOUR.getDefaultLocaleAbbreviation());
        assertEquals("uur", DurationUnit.HOUR.getName());
        assertEquals("hour", DurationUnit.HOUR.getDefaultLocaleName());

        DefaultLocale.setLocale(new Locale("en"));
        assertEquals("h", DurationUnit.HOUR.getAbbreviation());
        assertEquals("h", DurationUnit.HOUR.getDefaultLocaleAbbreviation());
        assertEquals("hour", DurationUnit.HOUR.getName());
        assertEquals("hour", DurationUnit.HOUR.getDefaultLocaleName());
    }

}
