package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.CatalyticActivityUnit;
import org.djunits4.value.vdouble.scalar.CatalyticActivity;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double CatalyticActivityVector, a vector of values with a CatalyticActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class CatalyticActivityVector
        extends AbstractDoubleVectorRel<CatalyticActivityUnit, CatalyticActivity, CatalyticActivityVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an CatalyticActivityVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit CatalyticActivityUnit; the display unit of the vector data
     */
    public CatalyticActivityVector(final DoubleVectorData data, final CatalyticActivityUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<CatalyticActivity> getScalarClass()
    {
        return CatalyticActivity.class;
    }

    /** {@inheritDoc} */
    @Override
    public CatalyticActivityVector instantiateVector(final DoubleVectorData dvd, final CatalyticActivityUnit displayUnit)
    {
        return new CatalyticActivityVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public CatalyticActivity instantiateScalar(final double value, final CatalyticActivityUnit unit)
    {
        return new CatalyticActivity(value, unit);
    }

}
