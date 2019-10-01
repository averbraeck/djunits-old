package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.TorqueUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatTorque;
import org.djunits4.value.vfloat.vector.FloatTorqueVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatTorqueMatrix, a matrix of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatTorqueMatrix extends AbstractFloatMatrixRel<TorqueUnit, FloatTorque, FloatTorqueVector, FloatTorqueMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit TorqueUnit; the unit
     */
    public FloatTorqueMatrix(final FloatMatrixData data, final TorqueUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatTorque> getScalarClass()
    {
        return FloatTorque.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatTorqueVector> getVectorClass()
    {
        return FloatTorqueVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatTorqueMatrix instantiateMatrix(final FloatMatrixData fmd, final TorqueUnit displayUnit)
    {
        return new FloatTorqueMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatTorqueVector instantiateVector(final FloatVectorData fvd, final TorqueUnit displayUnit)
    {
        return new FloatTorqueVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatTorque instantiateScalarSI(final float valueSI, final TorqueUnit displayUnit)
    {
        FloatTorque result = FloatTorque.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
