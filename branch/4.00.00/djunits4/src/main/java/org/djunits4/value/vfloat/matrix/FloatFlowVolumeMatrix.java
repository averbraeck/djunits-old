package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.FlowVolumeUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatFlowVolume;
import org.djunits4.value.vfloat.vector.FloatFlowVolumeVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatFlowVolumeMatrix, a matrix of values with a FlowVolumeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatFlowVolumeMatrix
        extends AbstractFloatMatrixRel<FlowVolumeUnit, FloatFlowVolume, FloatFlowVolumeVector, FloatFlowVolumeMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit FlowVolumeUnit; the unit
     */
    public FloatFlowVolumeMatrix(final FloatMatrixData data, final FlowVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatFlowVolume> getScalarClass()
    {
        return FloatFlowVolume.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatFlowVolumeVector> getVectorClass()
    {
        return FloatFlowVolumeVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatFlowVolumeMatrix instantiateMatrix(final FloatMatrixData fmd, final FlowVolumeUnit displayUnit)
    {
        return new FloatFlowVolumeMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatFlowVolumeVector instantiateVector(final FloatVectorData fvd, final FlowVolumeUnit displayUnit)
    {
        return new FloatFlowVolumeVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatFlowVolume instantiateScalar(final float value, final FlowVolumeUnit unit)
    {
        return new FloatFlowVolume(value, unit);
    }

}
