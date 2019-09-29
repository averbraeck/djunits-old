package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.MassUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.Mass;
import org.djunits4.value.vdouble.vector.MassVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double MassMatrix, a matrix of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T16:47:45.717Z")
public class MassMatrix extends AbstractDoubleMatrixRel<MassUnit, Mass, MassVector, MassMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MassUnit; the unit
     */
    public MassMatrix(final DoubleMatrixData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Mass> getScalarClass()
    {
        return Mass.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<MassVector> getVectorClass()
    {
        return MassVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public MassMatrix instantiateMatrix(final DoubleMatrixData dmd, final MassUnit displayUnit)
    {
        return new MassMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public MassVector instantiateVector(final DoubleVectorData dvd, final MassUnit displayUnit)
    {
        return new MassVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Mass instantiateScalarSI(final double valueSI, final MassUnit displayUnit)
    {
        Mass result = Mass.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
