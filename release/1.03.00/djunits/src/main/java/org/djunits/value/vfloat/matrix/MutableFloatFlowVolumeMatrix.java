package org.djunits.value.vfloat.matrix;

import org.djunits.unit.FlowVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatFlowVolume;

/**
 * Mutable FloatFlowVolumeMatrix, a matrix of values with a FlowVolumeUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatFlowVolumeMatrix extends
        MutableTypedFloatMatrixRel<FlowVolumeUnit, FloatFlowVolumeMatrix, MutableFloatFlowVolumeMatrix, FloatFlowVolume>
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
    public MutableFloatFlowVolumeMatrix(final float[][] values, final FlowVolumeUnit unit, final StorageType storageType)
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
    public MutableFloatFlowVolumeMatrix(final FloatFlowVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatFlowVolumeMatrix(final FloatMatrixData data, final FlowVolumeUnit unit)
    {
        super(data, unit);
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
    public final FloatFlowVolume get(final int row, final int column) throws ValueException
    {
        return new FloatFlowVolume(getInUnit(row, column, getUnit()), getUnit());
    }

}
