package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRelWithAbs;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Duration;
import org.djunits4.value.vdouble.scalar.Time;
import org.djunits4.value.vdouble.vector.DurationVector;
import org.djunits4.value.vdouble.vector.TimeVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Duration Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class DurationMatrix extends AbstractDoubleMatrixRelWithAbs<TimeUnit, Time, TimeVector, TimeMatrix, DurationUnit,
        Duration, DurationVector, DurationMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit DurationUnit; the unit
     */
    public DurationMatrix(final DoubleMatrixData data, final DurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Duration> getScalarClass()
    {
        return Duration.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<DurationVector> getVectorClass()
    {
        return DurationVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public DurationMatrix instantiateMatrix(final DoubleMatrixData dmd, final DurationUnit displayUnit)
    {
        return new DurationMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public DurationVector instantiateVector(final DoubleVectorData dvd, final DurationUnit displayUnit)
    {
        return new DurationVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Duration instantiateScalar(final double value, final DurationUnit unit)
    {
        return new Duration(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public TimeMatrix instantiateMatrixAbs(final DoubleMatrixData dmd, final TimeUnit displayUnit)
    {
        return new TimeMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public TimeVector instantiateVectorAbs(final DoubleVectorData dvd, final TimeUnit displayUnit)
    {
        return new TimeVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Time instantiateScalarAbs(final double value, final TimeUnit unit)
    {
        return new Time(value, unit);
    }

}
