package org.djunits.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits.unit.MagneticFluxUnit;
import org.djunits.value.vfloat.scalar.FloatMagneticFlux;
import org.djunits.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatMagneticFluxVector, a vector of values with a MagneticFluxUnit.
 * <p>
 * Copyright (c) 2013-2020 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2020-01-19T15:21:24.964166400Z")
public class FloatMagneticFluxVector
        extends AbstractFloatVectorRel<MagneticFluxUnit, FloatMagneticFlux, FloatMagneticFluxVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatMagneticFluxVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit MagneticFluxUnit; the unit
     */
    public FloatMagneticFluxVector(final FloatVectorData data, final MagneticFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatMagneticFlux> getScalarClass()
    {
        return FloatMagneticFlux.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatMagneticFluxVector instantiateVector(final FloatVectorData fvd, final MagneticFluxUnit displayUnit)
    {
        return new FloatMagneticFluxVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatMagneticFlux instantiateScalarSI(final float valueSI, final MagneticFluxUnit displayUnit)
    {
        FloatMagneticFlux result = FloatMagneticFlux.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}