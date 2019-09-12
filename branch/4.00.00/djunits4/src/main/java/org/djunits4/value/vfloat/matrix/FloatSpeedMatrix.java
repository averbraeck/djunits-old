package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.SpeedUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatSpeed;
import org.djunits4.value.vfloat.vector.FloatSpeedVector;

/**
 * Immutable FloatFloatSpeedMatrix, a matrix of values with a SpeedUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T21:03:23.462Z")
public class FloatSpeedMatrix extends AbstractFloatMatrixRel<SpeedUnit, FloatSpeed, FloatSpeedVector, FloatSpeedMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit SpeedUnit; the unit
     */
    public FloatSpeedMatrix(final FloatMatrixData data, final SpeedUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatSpeed> getScalarClass()
    {
        return FloatSpeed.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatSpeedVector> getVectorClass()
    {
        return FloatSpeedVector.class;
    }

}
