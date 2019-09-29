package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.EnergyUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Energy;
import org.djunits4.value.vdouble.vector.EnergyVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double EnergyMatrix, a matrix of values with a EnergyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class EnergyMatrix extends AbstractDoubleMatrixRel<EnergyUnit, Energy, EnergyVector, EnergyMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit EnergyUnit; the unit
     */
    public EnergyMatrix(final DoubleMatrixData data, final EnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Energy> getScalarClass()
    {
        return Energy.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<EnergyVector> getVectorClass()
    {
        return EnergyVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public EnergyMatrix instantiateMatrix(final DoubleMatrixData dmd, final EnergyUnit displayUnit)
    {
        return new EnergyMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public EnergyVector instantiateVector(final DoubleVectorData dvd, final EnergyUnit displayUnit)
    {
        return new EnergyVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Energy instantiateScalar(final double value, final EnergyUnit unit)
    {
        return new Energy(value, unit);
    }

}
