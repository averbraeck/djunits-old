package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.ForceUnit;
import org.djunits4.value.vfloat.scalar.FloatForce;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatForceVector, a vector of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatForceVector extends AbstractFloatVectorRel<ForceUnit, FloatForce, FloatForceVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatForceVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit ForceUnit; the unit
     */
    public FloatForceVector(final FloatVectorData data, final ForceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatForce> getScalarClass()
    {
        return FloatForce.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatForceVector instantiateVector(final FloatVectorData fvd, final ForceUnit displayUnit)
    {
        return new FloatForceVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatForce instantiateScalarSI(final float valueSI, final ForceUnit displayUnit)
    {
        FloatForce result = FloatForce.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
