package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.value.vdouble.scalar.Duration;
import org.djunits4.value.vdouble.scalar.Time;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRelWithAbs;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double DurationVector, a vector of values with a DurationUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class DurationVector
        extends AbstractDoubleVectorRelWithAbs<TimeUnit, Time, TimeVector, DurationUnit, Duration, DurationVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an DurationVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    public DurationVector(final DoubleVectorData data, final DurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Duration> getScalarClass()
    {
        return Duration.class;
    }

}
