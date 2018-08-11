package org.djunits.unit.scale;

/**
 * Scales for unit conversion, offers functions to and from SI units. E.g., LinearScale for Length, Area, etc. LinearOffsetScale
 * for Temperature. PercentScale for Angle. LogarithmicScale for Sound.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 11, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface Scale
{
    /**
     * Convert a value to an SI value using this scale.
     * @param value the value to convert
     * @return the corresponding SI value
     */
    double toStandardUnit(double value);

    /**
     * Convert a value from an SI value to a value in the unit that uses this scale.
     * @param value the value to convert
     * @return the corresponding value in the given unit
     */
    double fromStandardUnit(double value);

    /**
     * Return whether this is a base (SI) scale.
     * @return boolean; whether this is a base (SI) scale or not
     */
    boolean isBaseSIScale();
}
