package org.djunits.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits.unit.SolidAngleUnit;
import org.djunits.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits.value.vdouble.scalar.SolidAngle;
import org.djunits.value.vdouble.vector.SolidAngleVector;
import org.djunits.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double SolidAngleMatrix, a matrix of values with a SolidAngleUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-18T12:12:25.568Z")
public class SolidAngleMatrix extends AbstractDoubleMatrixRel<SolidAngleUnit, SolidAngle, SolidAngleVector, SolidAngleMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit SolidAngleUnit; the unit
     */
    public SolidAngleMatrix(final DoubleMatrixData data, final SolidAngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<SolidAngle> getScalarClass()
    {
        return SolidAngle.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<SolidAngleVector> getVectorClass()
    {
        return SolidAngleVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public SolidAngleMatrix instantiateMatrix(final DoubleMatrixData dmd, final SolidAngleUnit displayUnit)
    {
        return new SolidAngleMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public SolidAngleVector instantiateVector(final DoubleVectorData dvd, final SolidAngleUnit displayUnit)
    {
        return new SolidAngleVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public SolidAngle instantiateScalarSI(final double valueSI, final SolidAngleUnit displayUnit)
    {
        SolidAngle result = SolidAngle.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }
    
}
