package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRelWithAbs;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.AbsoluteTemperature;
import org.djunits4.value.vdouble.scalar.Temperature;
import org.djunits4.value.vdouble.vector.AbsoluteTemperatureVector;
import org.djunits4.value.vdouble.vector.TemperatureVector;

/**
 * Immutable Temperature Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T20:33:12.910Z")
public class TemperatureMatrix
        extends AbstractDoubleMatrixRelWithAbs<AbsoluteTemperatureUnit, AbsoluteTemperature, AbsoluteTemperatureVector,
                AbsoluteTemperatureMatrix, TemperatureUnit, Temperature, TemperatureVector, TemperatureMatrix>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit TemperatureUnit; the unit
     */
    public TemperatureMatrix(final DoubleMatrixData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Temperature> getScalarClass()
    {
        return Temperature.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<TemperatureVector> getVectorClass()
    {
        return TemperatureVector.class;
    }

}
