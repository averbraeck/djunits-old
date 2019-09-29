package org.djunits4.userdefined;

import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;

/**
 * Immutable Double JerkMatrix, a matrix of values with a JerkUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class JerkMatrix extends AbstractDoubleMatrixRel<JerkUnit, Jerk, JerkVector, JerkMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit JerkUnit; the unit
     */
    public JerkMatrix(final DoubleMatrixData data, final JerkUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Jerk> getScalarClass()
    {
        return Jerk.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<JerkVector> getVectorClass()
    {
        return JerkVector.class;
    }

}
