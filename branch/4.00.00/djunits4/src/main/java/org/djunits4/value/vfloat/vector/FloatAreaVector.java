package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.AreaUnit;
import org.djunits4.value.vfloat.scalar.FloatArea;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatAreaVector, a vector of values with a AreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatAreaVector extends AbstractFloatVectorRel<AreaUnit, FloatArea, FloatAreaVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatAreaVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit AreaUnit; the unit
     */
    public FloatAreaVector(final FloatVectorData data, final AreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatArea> getScalarClass()
    {
        return FloatArea.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatAreaVector instantiateVector(final FloatVectorData fvd, final AreaUnit displayUnit)
    {
        return new FloatAreaVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatArea instantiateScalar(final float value, final AreaUnit unit)
    {
        return new FloatArea(value, unit);
    }

}
