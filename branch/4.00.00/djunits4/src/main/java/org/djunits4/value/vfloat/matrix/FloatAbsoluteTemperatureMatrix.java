package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixAbs;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatAbsoluteTemperature;
import org.djunits4.value.vfloat.scalar.FloatTemperature;
import org.djunits4.value.vfloat.vector.FloatAbsoluteTemperatureVector;
import org.djunits4.value.vfloat.vector.FloatTemperatureVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatAbsoluteTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatAbsoluteTemperatureMatrix extends
        AbstractFloatMatrixAbs<AbsoluteTemperatureUnit, FloatAbsoluteTemperature, FloatAbsoluteTemperatureVector,
                FloatAbsoluteTemperatureMatrix, TemperatureUnit, FloatTemperature, FloatTemperatureVector,
                FloatTemperatureMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AbsoluteTemperatureUnit; the unit
     */
    public FloatAbsoluteTemperatureMatrix(final FloatMatrixData data, final AbsoluteTemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAbsoluteTemperature> getScalarClass()
    {
        return FloatAbsoluteTemperature.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatAbsoluteTemperatureVector> getVectorClass()
    {
        return FloatAbsoluteTemperatureVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatAbsoluteTemperatureMatrix instantiateMatrix(final FloatMatrixData fmd,
            final AbsoluteTemperatureUnit displayUnit)
    {
        return new FloatAbsoluteTemperatureMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAbsoluteTemperatureVector instantiateVector(final FloatVectorData fvd,
            final AbsoluteTemperatureUnit displayUnit)
    {
        return new FloatAbsoluteTemperatureVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatAbsoluteTemperature instantiateScalarSI(final float valueSI, final AbsoluteTemperatureUnit displayUnit)
    {
        FloatAbsoluteTemperature result = FloatAbsoluteTemperature.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public FloatTemperatureMatrix instantiateMatrixRel(final FloatMatrixData fmd, final TemperatureUnit displayUnit)
    {
        return new FloatTemperatureMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatTemperatureVector instantiateVectorRel(final FloatVectorData fvd, final TemperatureUnit displayUnit)
    {
        return new FloatTemperatureVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatTemperature instantiateScalarRelSI(final float valueSI, final TemperatureUnit displayUnit)
    {
        FloatTemperature result = FloatTemperature.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
