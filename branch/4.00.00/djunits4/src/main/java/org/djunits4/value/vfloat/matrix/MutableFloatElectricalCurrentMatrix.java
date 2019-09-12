package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalCurrentUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatElectricalCurrent;

/**
 * Mutable FloatElectricalCurrentMatrix, a matrix of values with a ElectricalCurrentUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatElectricalCurrentMatrix extends AbstractMutableFloatMatrixRel<ElectricalCurrentUnit,
        FloatElectricalCurrentMatrix, MutableFloatElectricalCurrentMatrix, FloatElectricalCurrent>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalCurrentMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalCurrentMatrix
     * @param unit ElectricalCurrentUnit; the unit of the new Relative Immutable FloatElectricalCurrentMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatElectricalCurrentMatrix(final float[][] values, final ElectricalCurrentUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalCurrentMatrix.
     * @param values FloatElectricalCurrent[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalCurrentMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatElectricalCurrentMatrix(final FloatElectricalCurrent[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalCurrentUnit; the unit
     */
    MutableFloatElectricalCurrentMatrix(final FloatMatrixData data, final ElectricalCurrentUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalCurrentMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalCurrentMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCurrentMatrix instantiateType(final FloatMatrixData fmd, final ElectricalCurrentUnit unit)
    {
        return new FloatElectricalCurrentMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalCurrentMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalCurrentUnit unit)
    {
        return new MutableFloatElectricalCurrentMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCurrent instantiateScalar(final float value, final ElectricalCurrentUnit unit)
    {
        return new FloatElectricalCurrent(value, unit);
    }

}
