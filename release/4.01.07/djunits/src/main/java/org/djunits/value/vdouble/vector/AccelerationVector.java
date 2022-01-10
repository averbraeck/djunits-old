package org.djunits.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits.unit.AccelerationUnit;
import org.djunits.value.vdouble.scalar.Acceleration;
import org.djunits.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double AccelerationVector, a vector of values with a AccelerationUnit.
 * <p>
 * Copyright (c) 2013-2022 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2020-01-19T15:21:24.964166400Z")
public class AccelerationVector extends AbstractDoubleVectorRel<AccelerationUnit, Acceleration, AccelerationVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an AccelerationVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit AccelerationUnit; the display unit of the vector data
     */
    public AccelerationVector(final DoubleVectorData data, final AccelerationUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Acceleration> getScalarClass()
    {
        return Acceleration.class;
    }

    /** {@inheritDoc} */
    @Override
    public AccelerationVector instantiateVector(final DoubleVectorData dvd, final AccelerationUnit displayUnit)
    {
        return new AccelerationVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Acceleration instantiateScalarSI(final double valueSI, final AccelerationUnit displayUnit)
    {
        Acceleration result = Acceleration.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}