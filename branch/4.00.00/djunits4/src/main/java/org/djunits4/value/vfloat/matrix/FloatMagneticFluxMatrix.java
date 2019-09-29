package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.MagneticFluxUnit;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatMagneticFlux;
import org.djunits4.value.vfloat.vector.FloatMagneticFluxVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatMagneticFluxMatrix, a matrix of values with a MagneticFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class FloatMagneticFluxMatrix
        extends AbstractFloatMatrixRel<MagneticFluxUnit, FloatMagneticFlux, FloatMagneticFluxVector, FloatMagneticFluxMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit MagneticFluxUnit; the unit
     */
    public FloatMagneticFluxMatrix(final FloatMatrixData data, final MagneticFluxUnit unit)
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
    public Class<FloatMagneticFluxVector> getVectorClass()
    {
        return FloatMagneticFluxVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatMagneticFluxMatrix instantiateMatrix(final FloatMatrixData fmd, final MagneticFluxUnit displayUnit)
    {
        return new FloatMagneticFluxMatrix(fmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatMagneticFluxVector instantiateVector(final FloatVectorData fvd, final MagneticFluxUnit displayUnit)
    {
        return new FloatMagneticFluxVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatMagneticFlux instantiateScalar(final float value, final MagneticFluxUnit unit)
    {
        return new FloatMagneticFlux(value, unit);
    }

}
