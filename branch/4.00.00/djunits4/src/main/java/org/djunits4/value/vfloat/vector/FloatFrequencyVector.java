package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.FrequencyUnit;
import org.djunits4.value.vfloat.scalar.FloatFrequency;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatFrequencyVector, a vector of values with a FrequencyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatFrequencyVector extends AbstractFloatVectorRel<FrequencyUnit, FloatFrequency, FloatFrequencyVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatFrequencyVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit FrequencyUnit; the unit
     */
    public FloatFrequencyVector(final FloatVectorData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatFrequency> getScalarClass()
    {
        return FloatFrequency.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatFrequencyVector instantiateVector(final FloatVectorData fvd, final FrequencyUnit displayUnit)
    {
        return new FloatFrequencyVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatFrequency instantiateScalar(final float value, final FrequencyUnit unit)
    {
        return new FloatFrequency(value, unit);
    }

}
