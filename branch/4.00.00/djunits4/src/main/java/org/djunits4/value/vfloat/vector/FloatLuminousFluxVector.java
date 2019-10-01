package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.value.vfloat.scalar.FloatLuminousFlux;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatLuminousFluxVector, a vector of values with a LuminousFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatLuminousFluxVector
        extends AbstractFloatVectorRel<LuminousFluxUnit, FloatLuminousFlux, FloatLuminousFluxVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatLuminousFluxVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit LuminousFluxUnit; the unit
     */
    public FloatLuminousFluxVector(final FloatVectorData data, final LuminousFluxUnit unit)
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
    public FloatLuminousFluxVector instantiateVector(final FloatVectorData fvd, final LuminousFluxUnit displayUnit)
    {
        return new FloatLuminousFluxVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatLuminousFlux instantiateScalarSI(final float valueSI, final LuminousFluxUnit displayUnit)
    {
        FloatLuminousFlux result = FloatLuminousFlux.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
