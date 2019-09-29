package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.TorqueUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Torque;
import org.djunits4.value.vdouble.vector.TorqueVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double TorqueMatrix, a matrix of values with a TorqueUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class TorqueMatrix extends AbstractDoubleMatrixRel<TorqueUnit, Torque, TorqueVector, TorqueMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit TorqueUnit; the unit
     */
    public TorqueMatrix(final DoubleMatrixData data, final TorqueUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Torque> getScalarClass()
    {
        return Torque.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<TorqueVector> getVectorClass()
    {
        return TorqueVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public TorqueMatrix instantiateMatrix(final DoubleMatrixData dmd, final TorqueUnit displayUnit)
    {
        return new TorqueMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public TorqueVector instantiateVector(final DoubleVectorData dvd, final TorqueUnit displayUnit)
    {
        return new TorqueVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Torque instantiateScalar(final double value, final TorqueUnit unit)
    {
        return new Torque(value, unit);
    }

}
