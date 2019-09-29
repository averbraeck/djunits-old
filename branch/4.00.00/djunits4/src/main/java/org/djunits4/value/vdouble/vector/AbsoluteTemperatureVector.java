package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.value.vdouble.scalar.AbsoluteTemperature;
import org.djunits4.value.vdouble.scalar.Temperature;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorAbs;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double AbsoluteTemperatureVector, a vector of values with a AbsoluteTemperatureUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class AbsoluteTemperatureVector extends AbstractDoubleVectorAbs<AbsoluteTemperatureUnit, AbsoluteTemperature,
        AbsoluteTemperatureVector, TemperatureUnit, Temperature, TemperatureVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an AbsoluteTemperatureVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param unit AbsoluteTemperatureUnit; the display unit of the vector data
     */
    public AbsoluteTemperatureVector(final DoubleVectorData data, final AbsoluteTemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<AbsoluteTemperature> getScalarClass()
    {
        return AbsoluteTemperature.class;
    }

    /** {@inheritDoc} */
    @Override
    public AbsoluteTemperatureVector instantiateVector(final DoubleVectorData dvd, final AbsoluteTemperatureUnit displayUnit)
    {
        return new AbsoluteTemperatureVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public AbsoluteTemperature instantiateScalar(final double value, final AbsoluteTemperatureUnit unit)
    {
        return new AbsoluteTemperature(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public TemperatureVector instantiateVectorRel(final DoubleVectorData dvd, final TemperatureUnit displayUnit)
    {
        return new TemperatureVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Temperature instantiateScalarRel(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
    }

}
