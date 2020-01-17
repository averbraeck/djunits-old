package org.djunits.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits.unit.LinearDensityUnit;
import org.djunits.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits.value.vfloat.scalar.FloatLinearDensity;
import org.djunits.value.vfloat.vector.FloatLinearDensityVector;
import org.djunits.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatLinearDensityMatrix, a matrix of values with a LinearDensityUnit.
 * <p>
 * Copyright (c) 2013-2020 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2020-01-17T10:29:24.905971300Z")
public class FloatLinearDensityMatrix extends
        AbstractFloatMatrixRel<LinearDensityUnit, FloatLinearDensity, FloatLinearDensityVector, FloatLinearDensityMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit LinearDensityUnit; the unit
     */
    public FloatLinearDensityMatrix(final FloatMatrixData data, final LinearDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatLinearDensity> getScalarClass()
    {
        return FloatLinearDensity.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatLinearDensityVector> getVectorClass()
    {
        return FloatLinearDensityVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatLinearDensityMatrix instantiateMatrix(final FloatMatrixData fmd, final LinearDensityUnit displayUnit)
    {
        return new FloatLinearDensityMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatLinearDensityVector instantiateVector(final FloatVectorData fvd, final LinearDensityUnit displayUnit)
    {
        return new FloatLinearDensityVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatLinearDensity instantiateScalarSI(final float valueSI, final LinearDensityUnit displayUnit)
    {
        FloatLinearDensity result = FloatLinearDensity.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}