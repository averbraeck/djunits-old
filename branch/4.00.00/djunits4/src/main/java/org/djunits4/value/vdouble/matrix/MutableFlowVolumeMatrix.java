package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.FlowVolumeUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.FlowVolume;

/**
 * Mutable Double FlowVolumeMatrix, a matrix of values with a FlowVolumeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFlowVolumeMatrix
        extends AbstractMutableDoubleMatrixRel<FlowVolumeUnit, FlowVolumeMatrix, MutableFlowVolumeMatrix, FlowVolume>
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
    public MutableFlowVolumeMatrix(final double[][] values, final FlowVolumeUnit unit, final StorageType storageType)
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
    public MutableFlowVolumeMatrix(final FlowVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit FlowVolumeUnit; the unit
     */
    MutableFlowVolumeMatrix(final DoubleMatrixData data, final FlowVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
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
