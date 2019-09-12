package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalConductanceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatElectricalConductance;

/**
 * Mutable FloatElectricalConductanceMatrix, a matrix of values with a ElectricalConductanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatElectricalConductanceMatrix extends AbstractMutableFloatMatrixRel<ElectricalConductanceUnit,
        FloatElectricalConductanceMatrix, MutableFloatElectricalConductanceMatrix, FloatElectricalConductance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalConductanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalConductanceMatrix
     * @param unit ElectricalConductanceUnit; the unit of the new Relative Immutable FloatElectricalConductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatElectricalConductanceMatrix(final float[][] values, final ElectricalConductanceUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalConductanceMatrix.
     * @param values FloatElectricalConductance[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalConductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatElectricalConductanceMatrix(final FloatElectricalConductance[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalConductanceUnit; the unit
     */
    MutableFloatElectricalConductanceMatrix(final FloatMatrixData data, final ElectricalConductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalConductanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalConductanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalConductanceMatrix instantiateType(final FloatMatrixData fmd,
            final ElectricalConductanceUnit unit)
    {
        return new FloatElectricalConductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalConductanceMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalConductanceUnit unit)
    {
        return new MutableFloatElectricalConductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalConductance instantiateScalar(final float value, final ElectricalConductanceUnit unit)
    {
        return new FloatElectricalConductance(value, unit);
    }

}
