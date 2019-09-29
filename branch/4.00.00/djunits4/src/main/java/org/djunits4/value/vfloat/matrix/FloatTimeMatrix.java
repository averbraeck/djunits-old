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
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatTime Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
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

    /** {@inheritDoc} */
    @Override
    public FloatTimeMatrix instantiateMatrix(final FloatMatrixData fmd, final TimeUnit displayUnit)
    {
        return new FloatTimeMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatTimeVector instantiateVector(final FloatVectorData fvd, final TimeUnit displayUnit)
    {
        return new FloatTimeVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatTime instantiateScalar(final float value, final TimeUnit unit)
    {
        return new FloatTime(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatDurationMatrix instantiateMatrixRel(final FloatMatrixData fmd, final DurationUnit displayUnit)
    {
        return new FloatDurationMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatDurationVector instantiateVectorRel(final FloatVectorData fvd, final DurationUnit displayUnit)
    {
        return new FloatDurationVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatDuration instantiateScalarRel(final float value, final DurationUnit unit)
    {
        return new FloatDuration(value, unit);
    }

}
