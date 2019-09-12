package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.DensityUnit;
import org.djunits4.value.vfloat.scalar.FloatDensity;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatDensityVector, a vector of values with a DensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T16:38:21.610Z")
public class FloatDensityVector extends AbstractFloatVectorRel<DensityUnit, FloatDensity, FloatDensityVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatDensityVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit DensityUnit; the unit
     */
    public FloatDensityVector(final FloatVectorData data, final DensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatDensity> getScalarClass()
    {
        return FloatDensity.class;
    }

}
