package org.djunits.value.vfloat.matrix;

import org.djunits.unit.FlowVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatFlowVolume;

/**
 * Mutable FloatFlowVolumeMatrix, a matrix of values with a FlowVolumeUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatFlowVolumeMatrix extends
        AbstractMutableFloatMatrixRel<FlowVolumeUnit, FloatFlowVolumeMatrix, MutableFloatFlowVolumeMatrix, FloatFlowVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatFlowVolumeMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatFlowVolumeMatrix
     * @param unit FlowVolumeUnit; the unit of the new Relative Immutable FloatFlowVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatFlowVolumeMatrix(final float[][] values, final FlowVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatFlowVolumeMatrix.
     * @param values FloatFlowVolume[][]; the values of the entries in the new Relative Immutable Float FloatFlowVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatFlowVolumeMatrix(final FloatFlowVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit FlowVolumeUnit; the unit
     */
    MutableFloatFlowVolumeMatrix(final FloatMatrixData data, final FlowVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFlowVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFlowVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowVolumeMatrix instantiateType(final FloatMatrixData fmd, final FlowVolumeUnit unit)
    {
        return new FloatFlowVolumeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatFlowVolumeMatrix instantiateMutableType(final FloatMatrixData fmd, final FlowVolumeUnit unit)
    {
        return new MutableFloatFlowVolumeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowVolume instantiateScalar(final float value, final FlowVolumeUnit unit)
    {
        return new FloatFlowVolume(value, unit);
    }

}
