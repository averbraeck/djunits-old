package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.value.vfloat.scalar.FloatLength;
import org.djunits4.value.vfloat.scalar.FloatPosition;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRelWithAbs;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Relative FloatLength Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T13:56:12.916Z")
public class FloatLengthVector extends AbstractFloatVectorRelWithAbs<PositionUnit, FloatPosition, FloatPositionVector,
        LengthUnit, FloatLength, FloatLengthVector>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable FloatLengthVector.
     * @param data FloatVectorData; an internal data object
     * @param unit LengthUnit; the unit
     */
    public FloatLengthVector(final FloatVectorData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatLength> getScalarClass()
    {
        return FloatLength.class;
    }

}
