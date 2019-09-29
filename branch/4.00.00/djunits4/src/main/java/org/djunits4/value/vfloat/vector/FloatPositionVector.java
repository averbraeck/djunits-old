package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.value.vfloat.scalar.FloatLength;
import org.djunits4.value.vfloat.scalar.FloatPosition;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorAbs;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Absolute FloatPosition Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatPositionVector extends
        AbstractFloatVectorAbs<PositionUnit, FloatPosition, FloatPositionVector, LengthUnit, FloatLength, FloatLengthVector>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absative Immutable FloatPositionVector.
     * @param data FloatVectorData; an internal data object
     * @param unit PositionUnit; the unit
     */
    public FloatPositionVector(final FloatVectorData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatPosition>

            getScalarClass()
    {
        return FloatPosition.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatPositionVector instantiateVector(final FloatVectorData fvd, final PositionUnit displayUnit)
    {
        return new FloatPositionVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatPosition instantiateScalar(final float value, final PositionUnit unit)
    {
        return new FloatPosition(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatLengthVector instantiateVectorRel(final FloatVectorData fvd, final LengthUnit displayUnit)
    {
        return new FloatLengthVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatLength instantiateScalarRel(final float value, final LengthUnit unit)
    {
        return new FloatLength(value, unit);
    }

}
