package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatElectricalResistance;
import org.djunits4.value.vfloat.vector.FloatElectricalResistanceVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatElectricalResistanceMatrix, a matrix of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class FloatElectricalResistanceMatrix extends AbstractFloatMatrixRel<ElectricalResistanceUnit, FloatElectricalResistance,
        FloatElectricalResistanceVector, FloatElectricalResistanceMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalResistanceUnit; the unit
     */
    public FloatElectricalResistanceMatrix(final FloatMatrixData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatElectricalResistance> getScalarClass()
    {
        return FloatElectricalResistance.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatElectricalResistanceVector> getVectorClass()
    {
        return FloatElectricalResistanceVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalResistanceMatrix instantiateMatrix(final FloatMatrixData fmd,
            final ElectricalResistanceUnit displayUnit)
    {
        return new FloatElectricalResistanceMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalResistanceVector instantiateVector(final FloatVectorData fvd,
            final ElectricalResistanceUnit displayUnit)
    {
        return new FloatElectricalResistanceVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatElectricalResistance instantiateScalarSI(final float valueSI, final ElectricalResistanceUnit displayUnit)
    {
        FloatElectricalResistance result = FloatElectricalResistance.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
