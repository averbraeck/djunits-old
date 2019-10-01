package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalConductanceUnit;
import org.djunits4.value.vfloat.scalar.FloatElectricalConductance;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatElectricalConductanceVector, a vector of values with a ElectricalConductanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatElectricalConductanceVector
        extends AbstractFloatVectorRel<ElectricalConductanceUnit, FloatElectricalConductance, FloatElectricalConductanceVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatElectricalConductanceVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit ElectricalConductanceUnit; the unit
     */
    public FloatElectricalConductanceVector(final FloatVectorData data, final ElectricalConductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatElectricalConductance> getScalarClass()
    {
        return FloatElectricalConductance.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalConductanceVector instantiateVector(final FloatVectorData fvd,
            final ElectricalConductanceUnit displayUnit)
    {
        return new FloatElectricalConductanceVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalConductance instantiateScalarSI(final float valueSI, final ElectricalConductanceUnit displayUnit)
    {
        FloatElectricalConductance result = FloatElectricalConductance.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
