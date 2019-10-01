package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AmountOfSubstanceUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatAmountOfSubstance;
import org.djunits4.value.vfloat.vector.FloatAmountOfSubstanceVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatAmountOfSubstanceMatrix, a matrix of values with a AmountOfSubstanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatAmountOfSubstanceMatrix extends AbstractFloatMatrixRel<AmountOfSubstanceUnit, FloatAmountOfSubstance,
        FloatAmountOfSubstanceVector, FloatAmountOfSubstanceMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AmountOfSubstanceUnit; the unit
     */
    public FloatAmountOfSubstanceMatrix(final FloatMatrixData data, final AmountOfSubstanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAmountOfSubstance> getScalarClass()
    {
        return FloatAmountOfSubstance.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAmountOfSubstanceVector> getVectorClass()
    {
        return FloatAmountOfSubstanceVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatAmountOfSubstanceMatrix instantiateMatrix(final FloatMatrixData fmd, final AmountOfSubstanceUnit displayUnit)
    {
        return new FloatAmountOfSubstanceMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAmountOfSubstanceVector instantiateVector(final FloatVectorData fvd, final AmountOfSubstanceUnit displayUnit)
    {
        return new FloatAmountOfSubstanceVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAmountOfSubstance instantiateScalarSI(final float valueSI, final AmountOfSubstanceUnit displayUnit)
    {
        FloatAmountOfSubstance result = FloatAmountOfSubstance.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
