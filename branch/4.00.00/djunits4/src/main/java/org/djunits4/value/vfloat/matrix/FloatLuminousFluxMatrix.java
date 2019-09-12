package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatLuminousFlux;
import org.djunits4.value.vfloat.vector.FloatLuminousFluxVector;

/**
 * Immutable FloatFloatLuminousFluxMatrix, a matrix of values with a LuminousFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T21:03:23.462Z")
public class FloatLuminousFluxMatrix
        extends AbstractFloatMatrixRel<LuminousFluxUnit, FloatLuminousFlux, FloatLuminousFluxVector, FloatLuminousFluxMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit LuminousFluxUnit; the unit
     */
    public FloatLuminousFluxMatrix(final FloatMatrixData data, final LuminousFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatLuminousFlux> getScalarClass()
    {
        return FloatLuminousFlux.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatLuminousFluxVector> getVectorClass()
    {
        return FloatLuminousFluxVector.class;
    }

}
