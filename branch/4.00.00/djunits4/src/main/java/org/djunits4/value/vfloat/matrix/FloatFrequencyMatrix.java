package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.FrequencyUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatFrequency;
import org.djunits4.value.vfloat.vector.FloatFrequencyVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatFrequencyMatrix, a matrix of values with a FrequencyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class FloatFrequencyMatrix
        extends AbstractFloatMatrixRel<FrequencyUnit, FloatFrequency, FloatFrequencyVector, FloatFrequencyMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit FrequencyUnit; the unit
     */
    public FloatFrequencyMatrix(final FloatMatrixData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatFrequency> getScalarClass()
    {
        return FloatFrequency.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatFrequencyVector> getVectorClass()
    {
        return FloatFrequencyVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatFrequencyMatrix instantiateMatrix(final FloatMatrixData fmd, final FrequencyUnit displayUnit)
    {
        return new FloatFrequencyMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatFrequencyVector instantiateVector(final FloatVectorData fvd, final FrequencyUnit displayUnit)
    {
        return new FloatFrequencyVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatFrequency instantiateScalarSI(final float valueSI, final FrequencyUnit displayUnit)
    {
        FloatFrequency result = FloatFrequency.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
