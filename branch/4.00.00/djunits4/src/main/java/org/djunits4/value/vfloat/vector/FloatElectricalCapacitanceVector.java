package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalCapacitanceUnit;
import org.djunits4.value.vfloat.scalar.FloatElectricalCapacitance;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatElectricalCapacitanceVector, a vector of values with a ElectricalCapacitanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatElectricalCapacitanceVector
        extends AbstractFloatVectorRel<ElectricalCapacitanceUnit, FloatElectricalCapacitance, FloatElectricalCapacitanceVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatElectricalCapacitanceVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit ElectricalCapacitanceUnit; the unit
     */
    public FloatElectricalCapacitanceVector(final FloatVectorData data, final ElectricalCapacitanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatElectricalCapacitance> getScalarClass()
    {
        return FloatElectricalCapacitance.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalCapacitanceVector instantiateVector(final FloatVectorData fvd,
            final ElectricalCapacitanceUnit displayUnit)
    {
        return new FloatElectricalCapacitanceVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalCapacitance instantiateScalar(final float value, final ElectricalCapacitanceUnit unit)
    {
        return new FloatElectricalCapacitance(value, unit);
    }

}
