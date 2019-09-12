package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRelWithAbs;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatAngle;
import org.djunits4.value.vfloat.scalar.FloatDirection;
import org.djunits4.value.vfloat.vector.FloatAngleVector;
import org.djunits4.value.vfloat.vector.FloatDirectionVector;

/**
 * Immutable FloatAngle Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T21:03:23.462Z")
public class FloatAngleMatrix extends AbstractFloatMatrixRelWithAbs<DirectionUnit, FloatDirection, FloatDirectionVector,
        FloatDirectionMatrix, AngleUnit, FloatAngle, FloatAngleVector, FloatAngleMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AngleUnit; the unit
     */
    public FloatAngleMatrix(final FloatMatrixData data, final AngleUnit unit)
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
    public Class<FloatAngleVector> getVectorClass()
    {
        return FloatAngleVector.class;
    }

}
