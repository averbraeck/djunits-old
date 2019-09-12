package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalInductanceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatElectricalInductance;

/**
 * Mutable FloatElectricalInductanceMatrix, a matrix of values with a ElectricalInductanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatElectricalInductanceMatrix extends AbstractMutableFloatMatrixRel<ElectricalInductanceUnit,
        FloatElectricalInductanceMatrix, MutableFloatElectricalInductanceMatrix, FloatElectricalInductance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalInductanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalInductanceMatrix
     * @param unit ElectricalInductanceUnit; the unit of the new Relative Immutable FloatElectricalInductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatElectricalInductanceMatrix(final float[][] values, final ElectricalInductanceUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalInductanceMatrix.
     * @param values FloatElectricalInductance[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalInductanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatElectricalInductanceMatrix(final FloatElectricalInductance[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalInductanceUnit; the unit
     */
    MutableFloatElectricalInductanceMatrix(final FloatMatrixData data, final ElectricalInductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalInductanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalInductanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductanceMatrix instantiateType(final FloatMatrixData fmd,
            final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalInductanceMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalInductanceUnit unit)
    {
        return new MutableFloatElectricalInductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalInductance instantiateScalar(final float value, final ElectricalInductanceUnit unit)
    {
        return new FloatElectricalInductance(value, unit);
    }

}
