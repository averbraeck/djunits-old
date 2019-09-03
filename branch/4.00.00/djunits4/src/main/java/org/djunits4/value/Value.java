package org.djunits4.value;

import org.djunits4.unit.Unit;

/**
 * Value is a static interface that forces implementation of a few unit- and value-related methods.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @param <U> the unit type
 */
public interface Value<U extends Unit<U>>
{
    /**
     * Retrieve the unit of this Value.
     * @return U; the unit of this Value
     */
    U getUnit();

    /**
     * Convert a value to the standard SI unit.
     * @param value double; the value to convert to the standard SI unit
     * @return double; the value in the standard SI unit
     */
    double expressAsSIUnit(double value);

    /**
     * Set a new display unit for the value. Internally, the value will stay stored in the default or SI unit.
     * @param newUnit U; the new display unit of this Value
     */
    void setDisplayUnit(U newUnit);

    /**
     * Indicate whether this is an Absolute Value.
     * @return boolean
     */
    boolean isAbsolute();

    /**
     * Indicate whether this is a Relative Value.
     * @return boolean
     */
    boolean isRelative();

}
