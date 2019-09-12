package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.value.vdouble.scalar.Angle;
import org.djunits4.value.vdouble.scalar.Direction;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRelWithAbs;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double AngleVector, a vector of values with a AngleUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class AngleVector
        extends AbstractDoubleVectorRelWithAbs<DirectionUnit, Direction, DirectionVector, AngleUnit, Angle, AngleVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an AngleVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    public AngleVector(final DoubleVectorData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Angle> getScalarClass()
    {
        return Angle.class;
    }

}
