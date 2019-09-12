package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixAbs;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatDuration;
import org.djunits4.value.vfloat.scalar.FloatTime;
import org.djunits4.value.vfloat.vector.FloatDurationVector;
import org.djunits4.value.vfloat.vector.FloatTimeVector;

/**
 * Immutable FloatTime Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T21:03:23.462Z")
public class FloatTimeMatrix extends AbstractFloatMatrixAbs<TimeUnit, FloatTime, FloatTimeVector, FloatTimeMatrix, DurationUnit,
        FloatDuration, FloatDurationVector, FloatDurationMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit TimeUnit; the unit
     */
    public FloatTimeMatrix(final FloatMatrixData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatTime> getScalarClass()
    {
        return FloatTime.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatTimeVector> getVectorClass()
    {
        return FloatTimeVector.class;
    }

}
