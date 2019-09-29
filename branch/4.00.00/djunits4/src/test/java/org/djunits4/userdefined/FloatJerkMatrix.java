package org.djunits4.userdefined;

import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;

/**
 * Immutable Float JerkMatrix, a matrix of values with a JerkUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatJerkMatrix extends AbstractFloatMatrixRel<JerkUnit, FloatJerk, FloatJerkVector, FloatJerkMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit JerkUnit; the unit
     */
    public FloatJerkMatrix(final FloatMatrixData data, final JerkUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatJerk> getScalarClass()
    {
        return FloatJerk.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatJerkVector> getVectorClass()
    {
        return FloatJerkVector.class;
    }

}
