package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AngleSolidUnit;
import org.djunits4.value.vdouble.scalar.AngleSolid;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double AngleSolidVector, a vector of values with a AngleSolidUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class AngleSolidVector extends AbstractDoubleVectorRel<AngleSolidUnit, AngleSolid, AngleSolidVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an AngleSolidVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit AngleSolidUnit; the display unit of the vector data
     */
    public AngleSolidVector(final DoubleVectorData data, final AngleSolidUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<AngleSolid> getScalarClass()
    {
        return AngleSolid.class;
    }

    /** {@inheritDoc} */
    @Override
    public AngleSolidVector instantiateVector(final DoubleVectorData dvd, final AngleSolidUnit displayUnit)
    {
        return new AngleSolidVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public AngleSolid instantiateScalar(final double value, final AngleSolidUnit unit)
    {
        return new AngleSolid(value, unit);
    }

}
