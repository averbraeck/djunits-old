package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.LuminousFlux;
import org.djunits4.value.vdouble.vector.LuminousFluxVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double LuminousFluxMatrix, a matrix of values with a LuminousFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class LuminousFluxMatrix
        extends AbstractDoubleMatrixRel<LuminousFluxUnit, LuminousFlux, LuminousFluxVector, LuminousFluxMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit LuminousFluxUnit; the unit
     */
    public LuminousFluxMatrix(final DoubleMatrixData data, final LuminousFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<LuminousFlux> getScalarClass()
    {
        return LuminousFlux.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<LuminousFluxVector> getVectorClass()
    {
        return LuminousFluxVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public LuminousFluxMatrix instantiateMatrix(final DoubleMatrixData dmd, final LuminousFluxUnit displayUnit)
    {
        return new LuminousFluxMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public LuminousFluxVector instantiateVector(final DoubleVectorData dvd, final LuminousFluxUnit displayUnit)
    {
        return new LuminousFluxVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public LuminousFlux instantiateScalar(final double value, final LuminousFluxUnit unit)
    {
        return new LuminousFlux(value, unit);
    }

}
