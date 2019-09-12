package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalPotentialUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatElectricalPotential;

/**
 * Mutable FloatElectricalPotentialMatrix, a matrix of values with a ElectricalPotentialUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatElectricalPotentialMatrix extends AbstractMutableFloatMatrixRel<ElectricalPotentialUnit,
        FloatElectricalPotentialMatrix, MutableFloatElectricalPotentialMatrix, FloatElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalPotentialMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalPotentialMatrix
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Immutable FloatElectricalPotentialMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatElectricalPotentialMatrix(final float[][] values, final ElectricalPotentialUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalPotentialMatrix.
     * @param values FloatElectricalPotential[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalPotentialMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatElectricalPotentialMatrix(final FloatElectricalPotential[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalPotentialUnit; the unit
     */
    MutableFloatElectricalPotentialMatrix(final FloatMatrixData data, final ElectricalPotentialUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalPotentialMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalPotentialMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotentialMatrix instantiateType(final FloatMatrixData fmd,
            final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotentialMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalPotentialMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalPotentialUnit unit)
    {
        return new MutableFloatElectricalPotentialMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotential instantiateScalar(final float value, final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotential(value, unit);
    }

}
