package org.djunits.unit;

/**
 * An absolute unit is a unit that needs to be defined with a "distance" to the reference absolute unit. E.g., for Time, an
 * absolute reference unit has to be chosen such as an Epoch (e.g., 0001-01-01 AD at 00:00), where other TimeUnits can be
 * defined relative to that reference unit (e.g., POSIX time, 1-1-1970 at 00:00, which is 719162 days after the reference time).
 * <p>
 * An absolute unit is always a unit with an OffsetLinearScale. The offset defines how far away the origin of that absolute unit
 * is compared to the base unit. The linear scale indicates in what default "steps" compared to the reference relative scale the
 * absolute scale is used. For temperature, this is very clear. Degrees Celcius is shifted 273.15 compared to the origin of the
 * Kelvin scale, and the linear unit is 1 (relatively, 1 Kelvin is one degree Celcius). For Degree Fahrenheit, the linear scale
 * is 5/9, and the offset is 459.67. For Direction, North can be chosen as 0, and radians (SI) as the default angle. But one
 * could also define a NORTH_DEGREES absolute direction unit, or a WEST_RADIANS one. Similar choices can be made for time and
 * position.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Apr 27, 2017 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface AbsoluteUnit
{
    /**
     * Return the scale factor to transform to the standard (reference) unit. Multiply by this number to convert to the standard
     * (e.g., SI) unit. For Degrees Fahrenheit, the linear scale factor is 5/9 to convert it to Kelvin, the standard unit.
     * @return double; the scale factor to transform to the standard (reference) unit.
     */
    double getScaleFactor();

    /**
     * Return the offset to transform to the standard (reference) unit. Add this number before scaling to convert to the
     * standard (e.g., SI) unit. For Degrees Fahrenheit, the offset is 459.67 to convert it to Kelvin, the standard unit.
     * @return double; the offset to transform to the standard (reference) unit.
     */
    double getOffset();

}
