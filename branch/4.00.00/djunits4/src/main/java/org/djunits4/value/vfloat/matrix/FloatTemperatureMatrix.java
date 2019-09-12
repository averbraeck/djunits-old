package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRelWithAbs;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatAbsoluteTemperature;
import org.djunits4.value.vfloat.scalar.FloatTemperature;
import org.djunits4.value.vfloat.vector.FloatAbsoluteTemperatureVector;
import org.djunits4.value.vfloat.vector.FloatTemperatureVector;

/**
 * Immutable FloatTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T21:03:23.462Z")
public class FloatTemperatureMatrix extends
        AbstractFloatMatrixRelWithAbs<AbsoluteTemperatureUnit, FloatAbsoluteTemperature, FloatAbsoluteTemperatureVector,
                FloatAbsoluteTemperatureMatrix, TemperatureUnit, FloatTemperature, FloatTemperatureVector,
                FloatTemperatureMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit TemperatureUnit; the unit
     */
    public FloatTemperatureMatrix(final FloatMatrixData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatTemperature> getScalarClass()
    {
        return FloatTemperature.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatTemperatureVector> getVectorClass()
    {
        return FloatTemperatureVector.class;
    }

}
