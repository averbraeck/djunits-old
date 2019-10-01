package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalCapacitanceUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatElectricalCapacitance;
import org.djunits4.value.vfloat.vector.FloatElectricalCapacitanceVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatElectricalCapacitanceMatrix, a matrix of values with a ElectricalCapacitanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatElectricalCapacitanceMatrix extends AbstractFloatMatrixRel<ElectricalCapacitanceUnit,
        FloatElectricalCapacitance, FloatElectricalCapacitanceVector, FloatElectricalCapacitanceMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalCapacitanceUnit; the unit
     */
    public FloatElectricalCapacitanceMatrix(final FloatMatrixData data, final ElectricalCapacitanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatElectricalCapacitance> getScalarClass()
    {
        return FloatElectricalCapacitance.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatElectricalCapacitanceVector> getVectorClass()
    {
        return FloatElectricalCapacitanceVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalCapacitanceMatrix instantiateMatrix(final FloatMatrixData fmd,
            final ElectricalCapacitanceUnit displayUnit)
    {
        return new FloatElectricalCapacitanceMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalCapacitanceVector instantiateVector(final FloatVectorData fvd,
            final ElectricalCapacitanceUnit displayUnit)
    {
        return new FloatElectricalCapacitanceVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalCapacitance instantiateScalarSI(final float valueSI, final ElectricalCapacitanceUnit displayUnit)
    {
        FloatElectricalCapacitance result = FloatElectricalCapacitance.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
