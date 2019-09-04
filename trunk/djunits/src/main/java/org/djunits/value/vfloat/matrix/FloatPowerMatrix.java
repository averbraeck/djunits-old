package org.djunits.value.vfloat.matrix;

import org.djunits.unit.PowerUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatPower;

/**
 * Immutable FloatPowerMatrix, a matrix of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatPowerMatrix extends AbstractFloatMatrixRel<PowerUnit, FloatPowerMatrix, MutableFloatPowerMatrix, FloatPower>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatPowerMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatPowerMatrix
     * @param unit PowerUnit; the unit of the new Relative Immutable FloatPowerMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatPowerMatrix(final float[][] values, final PowerUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPowerMatrix.
     * @param values FloatPower[][]; the values of the entries in the new Relative Immutable Float FloatPowerMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatPowerMatrix(final FloatPower[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit PowerUnit; the unit
     */
    FloatPowerMatrix(final FloatMatrixData data, final PowerUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPowerMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPowerMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPowerMatrix instantiateType(final FloatMatrixData fmd, final PowerUnit unit)
    {
        return new FloatPowerMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPowerMatrix instantiateMutableType(final FloatMatrixData fmd, final PowerUnit unit)
    {
        return new MutableFloatPowerMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPower instantiateScalar(final float value, final PowerUnit unit)
    {
        return new FloatPower(value, unit);
    }

}
