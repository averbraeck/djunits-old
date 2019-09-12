package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.PressureUnit;
import org.djunits4.value.vfloat.scalar.FloatPressure;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatPressureVector, a vector of values with a PressureUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T13:56:12.916Z")
public class FloatPressureVector extends AbstractFloatVectorRel<PressureUnit, FloatPressure, FloatPressureVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatPressureVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit PressureUnit; the unit
     */
    public FloatPressureVector(final FloatVectorData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatPressure> getScalarClass()
    {
        return FloatPressure.class;
    }

}
