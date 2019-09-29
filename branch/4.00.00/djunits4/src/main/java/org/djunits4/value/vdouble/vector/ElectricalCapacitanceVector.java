package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalCapacitanceUnit;
import org.djunits4.value.vdouble.scalar.ElectricalCapacitance;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double ElectricalCapacitanceVector, a vector of values with a ElectricalCapacitanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class ElectricalCapacitanceVector
        extends AbstractDoubleVectorRel<ElectricalCapacitanceUnit, ElectricalCapacitance, ElectricalCapacitanceVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an ElectricalCapacitanceVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit ElectricalCapacitanceUnit; the display unit of the vector data
     */
    public ElectricalCapacitanceVector(final DoubleVectorData data, final ElectricalCapacitanceUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<ElectricalCapacitance> getScalarClass()
    {
        return ElectricalCapacitance.class;
    }

    /** {@inheritDoc} */
    @Override
    public ElectricalCapacitanceVector instantiateVector(final DoubleVectorData dvd,
            final ElectricalCapacitanceUnit displayUnit)
    {
        return new ElectricalCapacitanceVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public ElectricalCapacitance instantiateScalar(final double value, final ElectricalCapacitanceUnit unit)
    {
        return new ElectricalCapacitance(value, unit);
    }

}
