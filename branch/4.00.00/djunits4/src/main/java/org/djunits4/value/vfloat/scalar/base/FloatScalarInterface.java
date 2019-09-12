package org.djunits4.value.vfloat.scalar.base;

import org.djunits4.unit.Unit;
import org.djunits4.value.base.Scalar;

/**
 * Float scalar functions.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 * @param <U> the unit for which this is the interface
 * @param <S> the scalar type belonging to the unit
 */
public interface FloatScalarInterface<U extends Unit<U>, S extends FloatScalarInterface<U, S>> extends Scalar<U, S>
{
    /**
     * Retrieve the value in the underlying SI unit.
     * @return float
     */
    float getSI();

    /**
     * Retrieve the value in the original unit.
     * @return float
     */
    float getInUnit();

    /**
     * Retrieve the value converted into some specified unit.
     * @param targetUnit U; the unit to convert the value into
     * @return float
     */
    float getInUnit(U targetUnit);

}
