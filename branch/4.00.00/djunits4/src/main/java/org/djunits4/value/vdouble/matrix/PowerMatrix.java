package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.PowerUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Power;
import org.djunits4.value.vdouble.vector.PowerVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double PowerMatrix, a matrix of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class PowerMatrix extends AbstractDoubleMatrixRel<PowerUnit, Power, PowerVector, PowerMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit PowerUnit; the unit
     */
    public PowerMatrix(final DoubleMatrixData data, final PowerUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Power> getScalarClass()
    {
        return Power.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<PowerVector> getVectorClass()
    {
        return PowerVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public PowerMatrix instantiateMatrix(final DoubleMatrixData dmd, final PowerUnit displayUnit)
    {
        return new PowerMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public PowerVector instantiateVector(final DoubleVectorData dvd, final PowerUnit displayUnit)
    {
        return new PowerVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Power instantiateScalar(final double value, final PowerUnit unit)
    {
        return new Power(value, unit);
    }

}
