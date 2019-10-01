package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AbsorbedDoseUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatAbsorbedDose;
import org.djunits4.value.vfloat.vector.FloatAbsorbedDoseVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatAbsorbedDoseMatrix, a matrix of values with a AbsorbedDoseUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatAbsorbedDoseMatrix
        extends AbstractFloatMatrixRel<AbsorbedDoseUnit, FloatAbsorbedDose, FloatAbsorbedDoseVector, FloatAbsorbedDoseMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AbsorbedDoseUnit; the unit
     */
    public FloatAbsorbedDoseMatrix(final FloatMatrixData data, final AbsorbedDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAbsorbedDose> getScalarClass()
    {
        return FloatAbsorbedDose.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAbsorbedDoseVector> getVectorClass()
    {
        return FloatAbsorbedDoseVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatAbsorbedDoseMatrix instantiateMatrix(final FloatMatrixData fmd, final AbsorbedDoseUnit displayUnit)
    {
        return new FloatAbsorbedDoseMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAbsorbedDoseVector instantiateVector(final FloatVectorData fvd, final AbsorbedDoseUnit displayUnit)
    {
        return new FloatAbsorbedDoseVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAbsorbedDose instantiateScalarSI(final float valueSI, final AbsorbedDoseUnit displayUnit)
    {
        FloatAbsorbedDose result = FloatAbsorbedDose.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
