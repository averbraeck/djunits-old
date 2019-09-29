package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.value.vfloat.scalar.FloatAngle;
import org.djunits4.value.vfloat.scalar.FloatDirection;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRelWithAbs;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Relative FloatAngle Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatAngleVector extends AbstractFloatVectorRelWithAbs<DirectionUnit, FloatDirection, FloatDirectionVector,
        AngleUnit, FloatAngle, FloatAngleVector>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatAngleVector.
     * @param data FloatVectorData; an internal data object
     * @param unit AngleUnit; the unit
     */
    public FloatAngleVector(final FloatVectorData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAngle> getScalarClass()
    {
        return FloatAngle.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatAngleVector instantiateVector(final FloatVectorData fvd, final AngleUnit displayUnit)
    {
        return new FloatAngleVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAngle instantiateScalar(final float value, final AngleUnit unit)
    {
        return new FloatAngle(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatDirectionVector instantiateVectorAbs(final FloatVectorData fvd, final DirectionUnit displayUnit)
    {
        return new FloatDirectionVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatDirection instantiateScalarAbs(final float value, final DirectionUnit unit)
    {
        return new FloatDirection(value, unit);
    }

}
