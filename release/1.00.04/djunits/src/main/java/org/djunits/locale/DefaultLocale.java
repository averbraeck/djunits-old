package org.djunits.locale;

import java.util.Locale;

/**
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-26 01:01:13 +0200 (Sun, 26 Jul 2015) $, @version $Revision: 1155 $, by $Author: averbraeck $,
 * initial version Jun 3, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class DefaultLocale
{
    /** The default locale to use in djunits. */
    private static Locale locale;

    /**
     * @return locale
     */
    public static Locale getLocale()
    {
        return DefaultLocale.locale;
    }

    /**
     * @param locale Locale; set locale
     */
    public static void setLocale(final Locale locale)
    {
        DefaultLocale.locale = locale;
    }

}
