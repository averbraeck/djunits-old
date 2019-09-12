package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vdouble.scalar.Position;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorAbs;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double PositionVector, a vector of values with a PositionUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class PositionVector
        extends AbstractDoubleVectorAbs<PositionUnit, Position, PositionVector, LengthUnit, Length, LengthVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an PositionVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    public PositionVector(final DoubleVectorData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Position> getScalarClass()
    {
        return Position.class;
    }

}
