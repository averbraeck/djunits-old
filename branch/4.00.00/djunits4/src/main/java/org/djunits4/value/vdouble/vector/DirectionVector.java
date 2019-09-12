package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.value.vdouble.scalar.Angle;
import org.djunits4.value.vdouble.scalar.Direction;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorAbs;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double DirectionVector, a vector of values with a DirectionUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class DirectionVector
        extends AbstractDoubleVectorAbs<DirectionUnit, Direction, DirectionVector, AngleUnit, Angle, AngleVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an DirectionVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    public DirectionVector(final DoubleVectorData data, final DirectionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Direction> getScalarClass()
    {
        return Direction.class;
    }

}
