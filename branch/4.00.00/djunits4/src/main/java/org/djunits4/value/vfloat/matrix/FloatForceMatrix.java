package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ForceUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatForce;
import org.djunits4.value.vfloat.vector.FloatForceVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatForceMatrix, a matrix of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatForceMatrix extends AbstractFloatMatrixRel<ForceUnit, FloatForce, FloatForceVector, FloatForceMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ForceUnit; the unit
     */
    public FloatForceMatrix(final FloatMatrixData data, final ForceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatForce> getScalarClass()
    {
        return FloatForce.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatForceVector> getVectorClass()
    {
        return FloatForceVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatForceMatrix instantiateMatrix(final FloatMatrixData fmd, final ForceUnit displayUnit)
    {
        return new FloatForceMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatForceVector instantiateVector(final FloatVectorData fvd, final ForceUnit displayUnit)
    {
        return new FloatForceVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatForce instantiateScalar(final float value, final ForceUnit unit)
    {
        return new FloatForce(value, unit);
    }

}
