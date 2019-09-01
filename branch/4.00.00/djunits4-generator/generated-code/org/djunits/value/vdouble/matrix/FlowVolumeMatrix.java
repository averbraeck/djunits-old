package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double FlowVolumeMatrix, a matrix of values with a FlowVolumeUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FlowVolumeMatrix extends
AbstractDoubleMatrixRel<FlowVolumeUnit, FlowVolumeMatrix, MutableFlowVolumeMatrix, FlowVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double FlowVolumeMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double FlowVolumeMatrix
     * @param unit FlowVolumeUnit; the unit of the new Relative Immutable Double FlowVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FlowVolumeMatrix(final double[][] values, final FlowVolumeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FlowVolumeMatrix.
     * @param values FlowVolume[][]; the values of the entries in the new Relative Immutable Double FlowVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FlowVolumeMatrix(final FlowVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit FlowVolumeUnit; the unit
     */
    FlowVolumeMatrix(final DoubleMatrixData data, final FlowVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FlowVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FlowVolumeMatrix instantiateType(final DoubleMatrixData dmd, final FlowVolumeUnit unit)
    {
        return new FlowVolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFlowVolumeMatrix instantiateMutableType(final DoubleMatrixData dmd, final FlowVolumeUnit unit)
    {
        return new MutableFlowVolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FlowVolume instantiateScalar(final double value, final FlowVolumeUnit unit)
    {
        return new FlowVolume(value, unit);
    }


    
}
