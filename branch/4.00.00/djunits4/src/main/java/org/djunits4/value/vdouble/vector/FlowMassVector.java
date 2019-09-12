package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.FlowMassUnit;
import org.djunits4.value.vdouble.scalar.FlowMass;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double FlowMassVector, a vector of values with a FlowMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class FlowMassVector extends AbstractDoubleVectorRel<FlowMassUnit, FlowMass, FlowMassVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FlowMassVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit FlowMassUnit; the unit
     */
    public FlowMassVector(final DoubleVectorData data, final FlowMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FlowMass> getScalarClass()
    {
        return FlowMass.class;
    }

}
