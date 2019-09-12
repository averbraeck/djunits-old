package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.CatalyticActivityUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatCatalyticActivity;
import org.djunits4.value.vfloat.vector.FloatCatalyticActivityVector;

/**
 * Immutable FloatFloatCatalyticActivityMatrix, a matrix of values with a CatalyticActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T21:03:23.462Z")
public class FloatCatalyticActivityMatrix extends AbstractFloatMatrixRel<CatalyticActivityUnit, FloatCatalyticActivity,
        FloatCatalyticActivityVector, FloatCatalyticActivityMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit CatalyticActivityUnit; the unit
     */
    public FloatCatalyticActivityMatrix(final FloatMatrixData data, final CatalyticActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatCatalyticActivity> getScalarClass()
    {
        return FloatCatalyticActivity.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatCatalyticActivityVector> getVectorClass()
    {
        return FloatCatalyticActivityVector.class;
    }

}
