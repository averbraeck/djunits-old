package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.value.vfloat.scalar.FloatAbsoluteTemperature;
import org.djunits4.value.vfloat.scalar.FloatTemperature;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorAbs;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Absolute FloatAbsoluteTemperature Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T13:56:12.916Z")
public class FloatAbsoluteTemperatureVector extends AbstractFloatVectorAbs<AbsoluteTemperatureUnit, FloatAbsoluteTemperature,
        FloatAbsoluteTemperatureVector, TemperatureUnit, FloatTemperature, FloatTemperatureVector>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absative Immutable FloatAbsoluteTemperatureVector.
     * @param data FloatVectorData; an internal data object
     * @param unit AbsoluteTemperatureUnit; the unit
     */
    public FloatAbsoluteTemperatureVector(final FloatVectorData data, final AbsoluteTemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAbsoluteTemperature>

            getScalarClass()
    {
        return FloatAbsoluteTemperature.class;
    }

}
