package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.ElectricalResistance;
import org.djunits4.value.vdouble.vector.ElectricalResistanceVector;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;

/**
 * Immutable Double ElectricalResistanceMatrix, a matrix of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-29T15:02:59.536Z")
public class ElectricalResistanceMatrix extends AbstractDoubleMatrixRel<ElectricalResistanceUnit, ElectricalResistance,
        ElectricalResistanceVector, ElectricalResistanceMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalResistanceUnit; the unit
     */
    public ElectricalResistanceMatrix(final DoubleMatrixData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<ElectricalResistance> getScalarClass()
    {
        return ElectricalResistance.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<ElectricalResistanceVector> getVectorClass()
    {
        return ElectricalResistanceVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public ElectricalResistanceMatrix instantiateMatrix(final DoubleMatrixData dmd, final ElectricalResistanceUnit displayUnit)
    {
        return new ElectricalResistanceMatrix(dmd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public ElectricalResistanceVector instantiateVector(final DoubleVectorData dvd, final ElectricalResistanceUnit displayUnit)
    {
        return new ElectricalResistanceVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public ElectricalResistance instantiateScalar(final double value, final ElectricalResistanceUnit unit)
    {
        return new ElectricalResistance(value, unit);
    }

}
