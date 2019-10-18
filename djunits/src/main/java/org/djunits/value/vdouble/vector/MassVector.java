package org.djunits.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits.unit.MassUnit;
import org.djunits.value.vdouble.scalar.Mass;
import org.djunits.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double MassVector, a vector of values with a MassUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-18T12:12:25.568Z")
public class MassVector extends AbstractDoubleVectorRel<MassUnit, Mass, MassVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an MassVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit MassUnit; the display unit of the vector data
     */
    public MassVector(final DoubleVectorData data, final MassUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Mass> getScalarClass()
    {
        return Mass.class;
    }

    /** {@inheritDoc} */
    @Override
    public MassVector instantiateVector(final DoubleVectorData dvd, final MassUnit displayUnit)
    {
        return new MassVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Mass instantiateScalarSI(final double valueSI, final MassUnit displayUnit)
    {
        Mass result = Mass.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

   
}
