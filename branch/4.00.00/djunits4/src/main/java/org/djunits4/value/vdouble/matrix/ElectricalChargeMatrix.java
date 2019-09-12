package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalChargeUnit;
import org.djunits4.value.vdouble.matrix.base.AbstractDoubleMatrixRel;
import org.djunits4.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits4.value.vdouble.scalar.ElectricalCharge;
import org.djunits4.value.vdouble.vector.ElectricalChargeVector;

/**
 * Immutable Double ElectricalChargeMatrix, a matrix of values with a ElectricalChargeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-12T20:33:12.910Z")
public class ElectricalChargeMatrix
        extends AbstractDoubleMatrixRel<ElectricalChargeUnit, ElectricalCharge, ElectricalChargeVector, ElectricalChargeMatrix>

{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalChargeUnit; the unit
     */
    public ElectricalChargeMatrix(final DoubleMatrixData data, final ElectricalChargeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<ElectricalCharge> getScalarClass()
    {
        return ElectricalCharge.class;
    }

    /** {@inheritDoc} */
    @Override
    public Class<ElectricalChargeVector> getVectorClass()
    {
        return ElectricalChargeVector.class;
    }

}
