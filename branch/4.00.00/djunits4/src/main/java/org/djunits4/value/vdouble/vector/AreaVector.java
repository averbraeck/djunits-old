package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AreaUnit;
import org.djunits4.value.vdouble.scalar.Area;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double AreaVector, a vector of values with a AreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class AreaVector extends AbstractDoubleVectorRel<AreaUnit, Area, AreaVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an AreaVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit AreaUnit; the display unit of the vector data
     */
    public AreaVector(final DoubleVectorData data, final AreaUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Area> getScalarClass()
    {
        return Area.class;
    }

    /** {@inheritDoc} */
    @Override
    public AreaVector instantiateVector(final DoubleVectorData dvd, final AreaUnit displayUnit)
    {
        return new AreaVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Area instantiateScalarSI(final double valueSI, final AreaUnit displayUnit)
    {
        Area result = Area.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
