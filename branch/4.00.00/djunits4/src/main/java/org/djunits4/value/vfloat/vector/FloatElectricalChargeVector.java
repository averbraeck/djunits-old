package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalChargeUnit;
import org.djunits4.value.vfloat.scalar.FloatElectricalCharge;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatElectricalChargeVector, a vector of values with a ElectricalChargeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T16:38:21.610Z")
public class FloatElectricalChargeVector
        extends AbstractFloatVectorRel<ElectricalChargeUnit, FloatElectricalCharge, FloatElectricalChargeVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatElectricalChargeVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit ElectricalChargeUnit; the unit
     */
    public FloatElectricalChargeVector(final FloatVectorData data, final ElectricalChargeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatElectricalCharge> getScalarClass()
    {
        return FloatElectricalCharge.class;
    }

}
