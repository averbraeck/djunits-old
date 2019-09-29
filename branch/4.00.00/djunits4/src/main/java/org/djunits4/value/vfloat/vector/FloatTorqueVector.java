package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.TorqueUnit;
import org.djunits4.value.vfloat.scalar.FloatTorque;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatTorqueVector, a vector of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatTorqueVector extends AbstractFloatVectorRel<TorqueUnit, FloatTorque, FloatTorqueVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatTorqueVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit TorqueUnit; the unit
     */
    public FloatTorqueVector(final FloatVectorData data, final TorqueUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatTorque> getScalarClass()
    {
        return FloatTorque.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatTorqueVector instantiateVector(final FloatVectorData fvd, final TorqueUnit displayUnit)
    {
        return new FloatTorqueVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatTorque instantiateScalar(final float value, final TorqueUnit unit)
    {
        return new FloatTorque(value, unit);
    }

}
