package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.RadioActivityUnit;
import org.djunits4.value.vdouble.scalar.RadioActivity;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double RadioActivityVector, a vector of values with a RadioActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class RadioActivityVector extends AbstractDoubleVectorRel<RadioActivityUnit, RadioActivity, RadioActivityVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an RadioActivityVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit RadioActivityUnit; the display unit of the vector data
     */
    public RadioActivityVector(final DoubleVectorData data, final RadioActivityUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<RadioActivity> getScalarClass()
    {
        return RadioActivity.class;
    }

    /** {@inheritDoc} */
    @Override
    public RadioActivityVector instantiateVector(final DoubleVectorData dvd, final RadioActivityUnit displayUnit)
    {
        return new RadioActivityVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public RadioActivity instantiateScalarSI(final double valueSI, final RadioActivityUnit displayUnit)
    {
        RadioActivity result = RadioActivity.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
