package org.djunits.value.vfloat.matrix;

import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatElectricalCharge;

/**
 * Immutable FloatElectricalChargeMatrix, a matrix of values with a ElectricalChargeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatElectricalChargeMatrix extends AbstractFloatMatrixRel<ElectricalChargeUnit, FloatElectricalChargeMatrix,
        MutableFloatElectricalChargeMatrix, FloatElectricalCharge>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalChargeMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalChargeMatrix
     * @param unit ElectricalChargeUnit; the unit of the new Relative Immutable FloatElectricalChargeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalChargeMatrix(final float[][] values, final ElectricalChargeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalChargeMatrix.
     * @param values FloatElectricalCharge[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalChargeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalChargeMatrix(final FloatElectricalCharge[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalChargeUnit; the unit
     */
    FloatElectricalChargeMatrix(final FloatMatrixData data, final ElectricalChargeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalChargeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalChargeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalChargeMatrix instantiateType(final FloatMatrixData fmd, final ElectricalChargeUnit unit)
    {
        return new FloatElectricalChargeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalChargeMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalChargeUnit unit)
    {
        return new MutableFloatElectricalChargeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCharge instantiateScalar(final float value, final ElectricalChargeUnit unit)
    {
        return new FloatElectricalCharge(value, unit);
    }

}
