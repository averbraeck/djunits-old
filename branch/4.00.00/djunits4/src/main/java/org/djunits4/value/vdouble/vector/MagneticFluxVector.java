package org.djunits4.value.vdouble.vector;

import javax.annotation.Generated;

import org.djunits4.unit.MagneticFluxUnit;
import org.djunits4.value.vdouble.scalar.MagneticFlux;
import org.djunits4.value.vdouble.vector.base.AbstractDoubleVectorRel;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double MagneticFluxVector, a vector of values with a MagneticFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T08:19:03.301Z")
public class MagneticFluxVector extends AbstractDoubleVectorRel<MagneticFluxUnit, MagneticFlux, MagneticFluxVector>

{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an MagneticFluxVector from an internal data object.
     * @param data DoubleVectorData; an internal data object
     * @param unit MagneticFluxUnit; the unit
     */
    public MagneticFluxVector(final DoubleVectorData data, final MagneticFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<MagneticFlux> getScalarClass()
    {
        return MagneticFlux.class;
    }

}
