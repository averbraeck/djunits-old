package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.FlowMassUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatFlowMass;

/**
 * Mutable FloatFlowMassMatrix, a matrix of values with a FlowMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatFlowMassMatrix
        extends AbstractMutableFloatMatrixRel<FlowMassUnit, FloatFlowMassMatrix, MutableFloatFlowMassMatrix, FloatFlowMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatFlowMassMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatFlowMassMatrix
     * @param unit FlowMassUnit; the unit of the new Relative Immutable FloatFlowMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatFlowMassMatrix(final float[][] values, final FlowMassUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatFlowMassMatrix.
     * @param values FloatFlowMass[][]; the values of the entries in the new Relative Immutable Float FloatFlowMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatFlowMassMatrix(final FloatFlowMass[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit FlowMassUnit; the unit
     */
    MutableFloatFlowMassMatrix(final FloatMatrixData data, final FlowMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFlowMassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFlowMassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowMassMatrix instantiateType(final FloatMatrixData fmd, final FlowMassUnit unit)
    {
        return new FloatFlowMassMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatFlowMassMatrix instantiateMutableType(final FloatMatrixData fmd, final FlowMassUnit unit)
    {
        return new MutableFloatFlowMassMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowMass instantiateScalar(final float value, final FlowMassUnit unit)
    {
        return new FloatFlowMass(value, unit);
    }

}
