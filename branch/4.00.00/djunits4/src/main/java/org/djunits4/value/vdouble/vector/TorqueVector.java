package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.TorqueUnit;
import org.djunits4.value.vdouble.scalar.Torque;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double TorqueVector, a vector of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class TorqueVector extends AbstractDoubleVectorRel<TorqueUnit, Torque, TorqueVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an TorqueVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit TorqueUnit; the display unit of the vector data
     */
    public TorqueVector(final DoubleVectorData data, final TorqueUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Torque> getScalarClass()
    {
        return Torque.class;
    }

    /** {@inheritDoc} */
    @Override
    public TorqueVector instantiateVector(final DoubleVectorData dvd, final TorqueUnit displayUnit)
    {
        return new TorqueVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Torque instantiateScalarSI(final double valueSI, final TorqueUnit displayUnit)
    {
        Torque result = Torque.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
