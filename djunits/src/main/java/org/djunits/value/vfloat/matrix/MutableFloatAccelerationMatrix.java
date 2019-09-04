package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AccelerationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAcceleration;

/**
 * Mutable FloatAccelerationMatrix, a matrix of values with a AccelerationUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatAccelerationMatrix extends AbstractMutableFloatMatrixRel<AccelerationUnit, FloatAccelerationMatrix,
        MutableFloatAccelerationMatrix, FloatAcceleration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatAccelerationMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatAccelerationMatrix
     * @param unit AccelerationUnit; the unit of the new Relative Immutable FloatAccelerationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAccelerationMatrix(final float[][] values, final AccelerationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAccelerationMatrix.
     * @param values FloatAcceleration[][]; the values of the entries in the new Relative Immutable Float
     *            FloatAccelerationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAccelerationMatrix(final FloatAcceleration[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AccelerationUnit; the unit
     */
    MutableFloatAccelerationMatrix(final FloatMatrixData data, final AccelerationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAccelerationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAccelerationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAccelerationMatrix instantiateType(final FloatMatrixData fmd, final AccelerationUnit unit)
    {
        return new FloatAccelerationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAccelerationMatrix instantiateMutableType(final FloatMatrixData fmd,
            final AccelerationUnit unit)
    {
        return new MutableFloatAccelerationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAcceleration instantiateScalar(final float value, final AccelerationUnit unit)
    {
        return new FloatAcceleration(value, unit);
    }

}
