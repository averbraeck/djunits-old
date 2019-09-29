package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AccelerationUnit;
import org.djunits4.value.vfloat.scalar.FloatAcceleration;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatAccelerationVector, a vector of values with a AccelerationUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class FloatAccelerationVector
        extends AbstractFloatVectorRel<AccelerationUnit, FloatAcceleration, FloatAccelerationVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatAccelerationVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit AccelerationUnit; the unit
     */
    public FloatAccelerationVector(final FloatVectorData data, final AccelerationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAcceleration> getScalarClass()
    {
        return FloatAcceleration.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatAccelerationVector instantiateVector(final FloatVectorData fvd, final AccelerationUnit displayUnit)
    {
        return new FloatAccelerationVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAcceleration instantiateScalarSI(final float valueSI, final AccelerationUnit displayUnit)
    {
        FloatAcceleration result = FloatAcceleration.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
