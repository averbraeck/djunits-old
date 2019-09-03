package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatFlowMassMatrix, a matrix of values with a FlowMassUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatFlowMassMatrix extends
    AbstractFloatMatrixRel<FlowMassUnit, FloatFlowMassMatrix, MutableFloatFlowMassMatrix, FloatFlowMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatFlowMassMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatFlowMassMatrix
     * @param unit FlowMassUnit; the unit of the new Relative Immutable FloatFlowMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatFlowMassMatrix(final float[][] values, final FlowMassUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatFlowMassMatrix.
     * @param values FloatFlowMass; the values of the entries in the new Relative Immutable FloatFlowMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatFlowMassMatrix(final FloatFlowMass[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit FlowMassUnit; the unit
     */
    FloatFlowMassMatrix(final FloatMatrixData data, final FlowMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowMassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
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
