package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatElectricalResistance;

/**
 * Immutable FloatElectricalResistanceMatrix, a matrix of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatElectricalResistanceMatrix extends AbstractFloatMatrixRel<ElectricalResistanceUnit,
        FloatElectricalResistanceMatrix, MutableFloatElectricalResistanceMatrix, FloatElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalResistanceMatrix
     * @param unit ElectricalResistanceUnit; the unit of the new Relative Immutable FloatElectricalResistanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalResistanceMatrix(final float[][] values, final ElectricalResistanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceMatrix.
     * @param values FloatElectricalResistance; the values of the entries in the new Relative Immutable
     *            FloatElectricalResistanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalResistanceMatrix(final FloatElectricalResistance[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalResistanceUnit; the unit
     */
    FloatElectricalResistanceMatrix(final FloatMatrixData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalResistanceMatrix instantiateType(final FloatMatrixData fmd,
            final ElectricalResistanceUnit unit)
    {
        return new FloatElectricalResistanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalResistanceMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalResistanceUnit unit)
    {
        return new MutableFloatElectricalResistanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalResistance instantiateScalar(final float value, final ElectricalResistanceUnit unit)
    {
        return new FloatElectricalResistance(value, unit);
    }

}
