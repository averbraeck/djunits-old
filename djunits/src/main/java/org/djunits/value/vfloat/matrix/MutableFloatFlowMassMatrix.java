package org.djunits.value.vfloat.matrix;

import org.djunits.unit.FlowMassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatFlowMass;

/**
 * Mutable FloatFlowMassMatrix, a matrix of values with a FlowMassUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
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
     * @throws ValueException when values is null
     */
    public MutableFloatFlowMassMatrix(final float[][] values, final FlowMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatFlowMassMatrix.
     * @param values FloatFlowMass[][]; the values of the entries in the new Relative Immutable Float FloatFlowMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatFlowMassMatrix(final FloatFlowMass[][] values, final StorageType storageType) throws ValueException
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
