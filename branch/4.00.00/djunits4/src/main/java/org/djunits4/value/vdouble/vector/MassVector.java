package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.MassUnit;
import org.djunits4.value.vdouble.scalar.Mass;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double MassVector, a vector of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class MassVector extends AbstractDoubleVectorRel<MassUnit, Mass, MassVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an MassVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit MassUnit; the unit
     */
    public MassVector(final DoubleVectorData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Mass> getScalarClass()
    {
        return Mass.class;
    }

}
