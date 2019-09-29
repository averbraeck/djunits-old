package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.LinearDensityUnit;
import org.djunits4.value.vdouble.scalar.LinearDensity;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double LinearDensityVector, a vector of values with a LinearDensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class LinearDensityVector extends AbstractDoubleVectorRel<LinearDensityUnit, LinearDensity, LinearDensityVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an LinearDensityVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit LinearDensityUnit; the display unit of the vector data
     */
    public LinearDensityVector(final DoubleVectorData data, final LinearDensityUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<LinearDensity> getScalarClass()
    {
        return LinearDensity.class;
    }

    /** {@inheritDoc} */
    @Override
    public LinearDensityVector instantiateVector(final DoubleVectorData dvd, final LinearDensityUnit displayUnit)
    {
        return new LinearDensityVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public LinearDensity instantiateScalar(final double value, final LinearDensityUnit unit)
    {
        return new LinearDensity(value, unit);
    }

}
