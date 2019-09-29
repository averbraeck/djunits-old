package org.djunits4.userdefined;

import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double JerkVector, a vector of values with a JerkUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class JerkVector extends AbstractDoubleVectorRel<JerkUnit, Jerk, JerkVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an JerkVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit JerkUnit; the unit
     */
    public JerkVector(final DoubleVectorData data, final JerkUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Jerk> getScalarClass()
    {
        return Jerk.class;
    }

}
