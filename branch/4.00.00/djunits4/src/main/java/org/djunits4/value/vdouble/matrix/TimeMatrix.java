package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixAbs;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Duration;
import org.djunits4.value.vdouble.scalar.Time;
import org.djunits4.value.vdouble.vector.DurationVector;
import org.djunits4.value.vdouble.vector.TimeVector;

/**
 * Immutable Time Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T20:33:12.910Z")
public class TimeMatrix extends
        AbstractDoubleMatrixAbs<TimeUnit, Time, TimeVector, TimeMatrix, DurationUnit, Duration, DurationVector, DurationMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit TimeUnit; the unit
     */
    public TimeMatrix(final DoubleMatrixData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Time> getScalarClass()
    {
        return Time.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<TimeVector> getVectorClass()
    {
        return TimeVector.class;
    }

}
