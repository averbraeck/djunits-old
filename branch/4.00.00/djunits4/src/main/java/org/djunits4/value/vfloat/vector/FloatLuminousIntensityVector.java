package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.LuminousIntensityUnit;
import org.djunits4.value.vfloat.scalar.FloatLuminousIntensity;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatLuminousIntensityVector, a vector of values with a LuminousIntensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T13:56:12.916Z")
public class FloatLuminousIntensityVector
        extends AbstractFloatVectorRel<LuminousIntensityUnit, FloatLuminousIntensity, FloatLuminousIntensityVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatLuminousIntensityVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit LuminousIntensityUnit; the unit
     */
    public FloatLuminousIntensityVector(final FloatVectorData data, final LuminousIntensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatLuminousIntensity> getScalarClass()
    {
        return FloatLuminousIntensity.class;
    }

}
