package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.FlowMassUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.FlowMass;

/**
 * Immutable Double FlowMassMatrix, a matrix of values with a FlowMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class FlowMassMatrix extends AbstractDoubleMatrixRel<FlowMassUnit, FlowMassMatrix, MutableFlowMassMatrix, FlowMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double FlowMassMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double FlowMassMatrix
     * @param unit FlowMassUnit; the unit of the new Relative Immutable Double FlowMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FlowMassMatrix(final double[][] values, final FlowMassUnit unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowMassMatrix.
     * @param values FlowMass[][]; the values of the entries in the new Relative Immutable Double FlowMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FlowMassMatrix(final FlowMass[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit FlowMassUnit; the unit
     */
    FlowMassMatrix(final DoubleMatrixData data, final FlowMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowMassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FlowMassMatrix instantiateType(final DoubleMatrixData dmd, final FlowMassUnit unit)
    {
        return new FlowMassMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFlowMassMatrix instantiateMutableType(final DoubleMatrixData dmd, final FlowMassUnit unit)
    {
        return new MutableFlowMassMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FlowMass instantiateScalar(final double value, final FlowMassUnit unit)
    {
        return new FlowMass(value, unit);
    }

}
