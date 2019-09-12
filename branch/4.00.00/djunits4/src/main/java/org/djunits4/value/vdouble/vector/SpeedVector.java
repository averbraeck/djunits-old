package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.SpeedUnit;
import org.djunits4.value.vdouble.scalar.Speed;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double SpeedVector, a vector of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class SpeedVector extends AbstractDoubleVectorRel<SpeedUnit, Speed, SpeedVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an SpeedVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit SpeedUnit; the unit
     */
    public SpeedVector(final DoubleVectorData data, final SpeedUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Speed> getScalarClass()
    {
        return Speed.class;
    }

}
