package org.djunits.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits.unit.LuminousIntensityUnit;
import org.djunits.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits.value.vdouble.scalar.LuminousIntensity;
import org.djunits.value.vdouble.vector.LuminousIntensityVector;
import org.djunits.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double LuminousIntensityMatrix, a matrix of values with a LuminousIntensityUnit.
 * <p>
 * Copyright (c) 2013-2020 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2020-01-19T15:21:24.964166400Z")
public class LuminousIntensityMatrix extends
        AbstractDoubleMatrixRel<LuminousIntensityUnit, LuminousIntensity, LuminousIntensityVector, LuminousIntensityMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit LuminousIntensityUnit; the unit
     */
    public LuminousIntensityMatrix(final DoubleMatrixData data, final LuminousIntensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<LuminousIntensity> getScalarClass()
    {
        return LuminousIntensity.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<LuminousIntensityVector> getVectorClass()
    {
        return LuminousIntensityVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public LuminousIntensityMatrix instantiateMatrix(final DoubleMatrixData dmd, final LuminousIntensityUnit displayUnit)
    {
        return new LuminousIntensityMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public LuminousIntensityVector instantiateVector(final DoubleVectorData dvd, final LuminousIntensityUnit displayUnit)
    {
        return new LuminousIntensityVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public LuminousIntensity instantiateScalarSI(final double valueSI, final LuminousIntensityUnit displayUnit)
    {
        LuminousIntensity result = LuminousIntensity.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
