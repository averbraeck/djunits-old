package org.djunits.value.vfloat.matrix;

import org.djunits.unit.FlowVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatFlowVolume;

/**
 * Immutable FloatFlowVolumeMatrix, a matrix of values with a FlowVolumeUnit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatFlowVolumeMatrix
        extends AbstractFloatMatrixRel<FlowVolumeUnit, FloatFlowVolumeMatrix, MutableFloatFlowVolumeMatrix, FloatFlowVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatFlowVolumeMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatFlowVolumeMatrix
     * @param unit U; the unit of the new Relative Immutable FloatFlowVolumeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatFlowVolumeMatrix(final float[][] values, final FlowVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatFlowVolumeMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatFlowVolumeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatFlowVolumeMatrix(final FloatFlowVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatFlowVolumeMatrix(final FloatMatrixData data, final FlowVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatFlowVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
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
