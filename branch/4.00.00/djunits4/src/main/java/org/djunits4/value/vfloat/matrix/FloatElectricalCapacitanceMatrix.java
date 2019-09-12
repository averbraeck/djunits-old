package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalCapacitanceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatElectricalCapacitance;

/**
 * Immutable FloatElectricalCapacitanceMatrix, a matrix of values with a ElectricalCapacitanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class FloatElectricalCapacitanceMatrix extends AbstractFloatMatrixRel<ElectricalCapacitanceUnit,
        FloatElectricalCapacitanceMatrix, MutableFloatElectricalCapacitanceMatrix, FloatElectricalCapacitance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalCapacitanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalCapacitanceMatrix
     * @param unit ElectricalCapacitanceUnit; the unit of the new Relative Immutable FloatElectricalCapacitanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatElectricalCapacitanceMatrix(final float[][] values, final ElectricalCapacitanceUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalCapacitanceMatrix.
     * @param values FloatElectricalCapacitance; the values of the entries in the new Relative Immutable
     *            FloatElectricalCapacitanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatElectricalCapacitanceMatrix(final FloatElectricalCapacitance[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalCapacitanceUnit; the unit
     */
    FloatElectricalCapacitanceMatrix(final FloatMatrixData data, final ElectricalCapacitanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCapacitanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCapacitanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCapacitanceMatrix instantiateType(final FloatMatrixData fmd,
            final ElectricalCapacitanceUnit unit)
    {
        return new FloatElectricalCapacitanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalCapacitanceMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalCapacitanceUnit unit)
    {
        return new MutableFloatElectricalCapacitanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCapacitance instantiateScalar(final float value, final ElectricalCapacitanceUnit unit)
    {
        return new FloatElectricalCapacitance(value, unit);
    }

}
