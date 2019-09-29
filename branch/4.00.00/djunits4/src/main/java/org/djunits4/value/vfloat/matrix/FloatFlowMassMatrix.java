package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.FlowMassUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatFlowMass;
import org.djunits4.value.vfloat.vector.FloatFlowMassVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatFlowMassMatrix, a matrix of values with a FlowMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatFlowMassMatrix
        extends AbstractFloatMatrixRel<FlowMassUnit, FloatFlowMass, FloatFlowMassVector, FloatFlowMassMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit FlowMassUnit; the unit
     */
    public FloatFlowMassMatrix(final FloatMatrixData data, final FlowMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatFlowMass> getScalarClass()
    {
        return FloatFlowMass.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatFlowMassVector> getVectorClass()
    {
        return FloatFlowMassVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatFlowMassMatrix instantiateMatrix(final FloatMatrixData fmd, final FlowMassUnit displayUnit)
    {
        return new FloatFlowMassMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatFlowMassVector instantiateVector(final FloatVectorData fvd, final FlowMassUnit displayUnit)
    {
        return new FloatFlowMassVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatFlowMass instantiateScalar(final float value, final FlowMassUnit unit)
    {
        return new FloatFlowMass(value, unit);
    }

}
