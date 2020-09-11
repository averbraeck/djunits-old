package org.djunits.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits.unit.AngularVelocityUnit;
import org.djunits.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits.value.vfloat.scalar.FloatAngularVelocity;
import org.djunits.value.vfloat.vector.FloatAngularVelocityVector;
import org.djunits.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatAngularVelocityMatrix, a matrix of values with a AngularVelocityUnit.
 * <p>
 * Copyright (c) 2013-2020 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2020-01-19T15:21:24.964166400Z")
public class FloatAngularVelocityMatrix extends AbstractFloatMatrixRel<AngularVelocityUnit, FloatAngularVelocity,
        FloatAngularVelocityVector, FloatAngularVelocityMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AngularVelocityUnit; the unit
     */
    public FloatAngularVelocityMatrix(final FloatMatrixData data, final AngularVelocityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAngularVelocity> getScalarClass()
    {
        return FloatAngularVelocity.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAngularVelocityVector> getVectorClass()
    {
        return FloatAngularVelocityVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatAngularVelocityMatrix instantiateMatrix(final FloatMatrixData fmd, final AngularVelocityUnit displayUnit)
    {
        return new FloatAngularVelocityMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAngularVelocityVector instantiateVector(final FloatVectorData fvd, final AngularVelocityUnit displayUnit)
    {
        return new FloatAngularVelocityVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAngularVelocity instantiateScalarSI(final float valueSI, final AngularVelocityUnit displayUnit)
    {
        FloatAngularVelocity result = FloatAngularVelocity.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
