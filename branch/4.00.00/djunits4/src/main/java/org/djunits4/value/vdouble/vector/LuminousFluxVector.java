package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.value.vdouble.scalar.LuminousFlux;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double LuminousFluxVector, a vector of values with a LuminousFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class LuminousFluxVector extends AbstractDoubleVectorRel<LuminousFluxUnit, LuminousFlux, LuminousFluxVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an LuminousFluxVector from an internal data object.
     * @param data DoubleVectorData; the internal data object for the vector data
     * @param displayUnit LuminousFluxUnit; the display unit of the vector data
     */
    public LuminousFluxVector(final DoubleVectorData data, final LuminousFluxUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<LuminousFlux> getScalarClass()
    {
        return LuminousFlux.class;
    }

    /** {@inheritDoc} */
    @Override
    public LuminousFluxVector instantiateVector(final DoubleVectorData dvd, final LuminousFluxUnit displayUnit)
    {
        return new LuminousFluxVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public LuminousFlux instantiateScalarSI(final double valueSI, final LuminousFluxUnit displayUnit)
    {
        LuminousFlux result = LuminousFlux.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
