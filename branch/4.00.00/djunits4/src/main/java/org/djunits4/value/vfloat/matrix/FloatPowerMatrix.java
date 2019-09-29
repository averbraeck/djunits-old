package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.PowerUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatPower;
import org.djunits4.value.vfloat.vector.FloatPowerVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatPowerMatrix, a matrix of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatPowerMatrix extends AbstractFloatMatrixRel<PowerUnit, FloatPower, FloatPowerVector, FloatPowerMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit PowerUnit; the unit
     */
    public FloatPowerMatrix(final FloatMatrixData data, final PowerUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatPower> getScalarClass()
    {
        return FloatPower.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatPowerVector> getVectorClass()
    {
        return FloatPowerVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatPowerMatrix instantiateMatrix(final FloatMatrixData fmd, final PowerUnit displayUnit)
    {
        return new FloatPowerMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatPowerVector instantiateVector(final FloatVectorData fvd, final PowerUnit displayUnit)
    {
        return new FloatPowerVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatPower instantiateScalar(final float value, final PowerUnit unit)
    {
        return new FloatPower(value, unit);
    }

}
