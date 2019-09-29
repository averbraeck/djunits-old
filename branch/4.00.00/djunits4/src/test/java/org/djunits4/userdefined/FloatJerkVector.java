package org.djunits4.userdefined;

import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Float JerkVector, a vector of values with a JerkUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatJerkVector extends AbstractFloatVectorRel<JerkUnit, FloatJerk, FloatJerkVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an JerkVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit JerkUnit; the unit
     */
    public FloatJerkVector(final FloatVectorData data, final JerkUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatJerk> getScalarClass()
    {
        return FloatJerk.class;
    }

}
