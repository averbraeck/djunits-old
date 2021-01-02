package org.djunits.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits.unit.DurationUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.value.vfloat.scalar.FloatDuration;
import org.djunits.value.vfloat.scalar.FloatTime;
import org.djunits.value.vfloat.vector.base.AbstractFloatVectorAbs;
import org.djunits.value.vfloat.vector.data.FloatVectorData;

/**
 * Absolute FloatTime Vector.
 * <p>
 * Copyright (c) 2013-2021 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2020-01-19T15:21:24.964166400Z")
public class FloatTimeVector
        extends AbstractFloatVectorAbs<TimeUnit, FloatTime, FloatTimeVector, DurationUnit, FloatDuration, FloatDurationVector>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absative Immutable FloatTimeVector.
     * @param data FloatVectorData; an internal data object
     * @param unit TimeUnit; the unit
     */
    public FloatTimeVector(final FloatVectorData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatTime>

            getScalarClass()
    {
        return FloatTime.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatTimeVector instantiateVector(final FloatVectorData fvd, final TimeUnit displayUnit)
    {
        return new FloatTimeVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatTime instantiateScalarSI(final float valueSI, final TimeUnit displayUnit)
    {
        FloatTime result = FloatTime.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public FloatDurationVector instantiateVectorRel(final FloatVectorData fvd, final DurationUnit displayUnit)
    {
        return new FloatDurationVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatDuration instantiateScalarRelSI(final float valueSI, final DurationUnit displayUnit)
    {
        FloatDuration result = FloatDuration.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
