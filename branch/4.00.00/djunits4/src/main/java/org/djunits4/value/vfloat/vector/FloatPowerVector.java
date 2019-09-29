package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.PowerUnit;
import org.djunits4.value.vfloat.scalar.FloatPower;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatPowerVector, a vector of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatPowerVector extends AbstractFloatVectorRel<PowerUnit, FloatPower, FloatPowerVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatPowerVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit PowerUnit; the unit
     */
    public FloatPowerVector(final FloatVectorData data, final PowerUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatPower> getScalarClass()
    {
        return FloatPower.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatPowerVector instantiateVector(final FloatVectorData fvd, final PowerUnit displayUnit)
    {
        return new FloatPowerVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatPower instantiateScalar(final float value, final PowerUnit unit)
    {
        return new FloatPower(value, unit);
    }

}
